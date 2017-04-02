package nl.han.ica.icss.transforms;

import nl.han.ica.icss.ast.*;

import java.util.ArrayList;
import java.util.HashMap;

public class InlineConstants implements Transform {
    private HashMap<String, Value> symboltable;


    @Override
    public void apply(AST ast) {
        System.out.println("\n== TRANSFORMING ==");
        symboltable = new HashMap<>();
        check(ast.root.body);
        System.out.println("Transforming step 1 finished.");
    }

    private void check(ArrayList<ASTNode> ast) {
        declareAssignments(ast);
        resolveReferences(ast);
    }

    // This method declares assignments.
    // This means that it puts the assignment name and value to the symboltable.
    private void declareAssignments(ArrayList<ASTNode> ast) {
        for (ASTNode node : ast) {
            if (node instanceof Assignment) {
                Assignment assignment = (Assignment) node;
                symboltable.put(assignment.name.name, assignment.value);
                System.out.printf("%s declared and initialized as %s.\n", assignment.getNodeLabel(),
                        assignment.value.getNodeLabel());
            }
        }
    }

    // This method resolves all Assignments.
    // It also checks assignments again, but only to resolve them if they contain ConstantReferences.
    private void resolveReferences(ArrayList<ASTNode> ast) {
        for (ASTNode node : ast) {
            checkChild(node, node);
            // You are setting the @node and the @parent to $node. This is because the checkChild methods needs a
            // parent node to be able to use recursion. This can be refactored in two methods, one which only requires
            // a child, and one which requires both, if this is needed.
        }
    }

    // This method checks all child nodes of childs in the ASTNode tree.
    // It also checks assignments again, but only to resolve them if they contain ConstantReferences.
    private void checkChild(ASTNode node, ASTNode parent) {
        if (node instanceof Assignment) {
            parent = node;
            checkChild(((Assignment) node).value, parent);
        }
        if (node instanceof Declaration) {
            parent = node; // Setting parent to this declaration node.
            // This is needed to correctly set a containing reference, because this changes the value of the
            // declaration.
        }

        if (node instanceof Operation) {
            Operation operation = (Operation) node;
            parent = node; // Setting parent to this operation node.
            // This is needed to correctly set a containing reference, because this changes the value of the
            // operation. This overwrites any other operation/assignment/declaration parent.
            if (!(operation.lhs instanceof Literal)) {
                // If an operation-value is not a Literal, it means that its a reference (or in case of an rhs, a
                // reference or an operation).
                // LHS can never be a child operation, but can be a reference. For the sake of readability we chose to
                // check if lhs is not an instance of Literal, instead of checking if it is a instance of
                // ConstantReference, though that would also work in this case.
                checkChild(operation.lhs, parent);
            }
            if (!(operation.rhs instanceof Literal)) {
                checkChild(operation.rhs, parent);
            }
        } else if (node instanceof ConstantReference) {
            if (parent instanceof Declaration) { // Actions to do when the parent is of type Declaration
                Declaration declaration = (Declaration) parent;
                declaration.value = resolveReference((ConstantReference) node);
            } else if (parent instanceof Operation) { // Actions to do when the parent is of type Operation
                Operation operation = (Operation) parent;
                // This check must be done on both of the operation sides!
                // Both sides can possibly contain a constantreference!
                if (operation.lhs instanceof ConstantReference) {
                    operation.lhs = resolveReference((ConstantReference) node);
                }
                if (operation.rhs instanceof ConstantReference) {
                    operation.rhs = resolveReference((ConstantReference) node);
                }
            }
        } else if (node.getChildren().size() > 0) { // must be else; otherwise it also checks reference childs when its an operation
            ArrayList<ASTNode> children = node.getChildren();
            for (ASTNode child : children) {
                checkChild(child, parent);
            }
        }
    }

    // This methods resolves a reference ($a) to the value set to this reference (40px)
    private Value resolveReference(ConstantReference reference) {
        Value referenceValue = symboltable.get(reference.name); // Getting the referenceValue from the referenceTable
        if (referenceValue instanceof ConstantReference) {
            referenceValue = resolveReference((ConstantReference) referenceValue);
        }
        return referenceValue;
    }
}
