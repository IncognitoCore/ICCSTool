package nl.han.ica.icss.transforms;

import nl.han.ica.icss.ast.*;

import java.util.ArrayList;

public class EvalOperations implements Transform {


    @Override
    public void apply(AST ast) {
        check(ast.root.body);
        System.out.println("Transforming step 2 finished.");
        System.out.println("Transforming finished.");
    }

    private void check(ArrayList<ASTNode> ast) {
        resolveOperations(ast);
    }

    private void resolveOperations(ArrayList<ASTNode> ast) {
        for (ASTNode node : ast) {
            checkChild(node, node);
        }
    }

    private void checkChild(ASTNode node, ASTNode parent) {
        if (node instanceof Declaration) {
            parent = node;
        } else if (node instanceof Assignment) {
            parent = node;
            // todo: never tested! this goes wrong already in the checker.
        }

        if (node instanceof Operation) {
            resolveOperation(parent, (Operation) node);
        } else if (node.getChildren().size() > 0) {
            ArrayList<ASTNode> children = node.getChildren();
            for (ASTNode child : children) {
                checkChild(child, parent);
            }
        }
    }

    private void resolveOperation(ASTNode parent, Operation operation) {
        int result = calculateResult(operation); // Calculating the result

        if (parent instanceof Declaration) { // Actions to do when the parent is of type Declaration
            Declaration declaration = (Declaration) parent;
            declaration.value = resolveValue(operation, result);
        } else if (parent instanceof Operation) { // Actions to do when the parent is of type Operation
            Operation parentoperation = (Operation) parent;
            // This check must be done on both of the operation sides!
            // Both sides can possibly contain a operation! I GUESS! //todo: uitzoeken
            if (parentoperation.lhs instanceof Operation) {
                parentoperation.lhs = resolveValue(operation, result);
            }
            if (parentoperation.rhs instanceof Operation) {
                parentoperation.rhs = resolveValue(operation, result);
            }
        }

        //todo: somethign with assignments maybe? :P

        System.out.printf("%s in %s resolved to %s.\n", operation.getNodeLabel(), parent.getNodeLabel(),
                resolveValue(operation, result).getNodeLabel());
    }

    private int calculateResult(Operation operation) {
        if (operation.operator == Operation.Operator.MIN) {
            return sub(operation);
        } // Otherwise it must be a PLUS operation
        return add(operation);
    }

    private int sub(Operation operation) {
        return resolveValue(operation.lhs) - resolveValue(operation.rhs);
    }

    private int add(Operation operation) {
        return resolveValue(operation.lhs) + resolveValue(operation.rhs);
    }

    // This method resolves a value of type Value to an Integer
    private int resolveValue(Value value) {
        if (value instanceof PixelLiteral) {
            return ((PixelLiteral) value).value;
        } else if (value instanceof PercentageLiteral) {
            return ((PercentageLiteral) value).value;
        }
//        if (value instanceof Operation) {
//            return resolveOperation((Operation) value);
//        }

        // else (we should never get here anyway)
        value.setError("Unexpected error while resolving value.");
        return 0;
    }

    // This method resolves a value of type Integer to a Value
    private Value resolveValue(Operation operation, int value) {
        if (operation.lhs instanceof PixelLiteral) {
            return new PixelLiteral(value);
        } else if (operation.lhs instanceof PercentageLiteral) {
            return new PercentageLiteral(value);
        }

        // else (we should never get here anyway)
        operation.setError("Unexpected error while resolving value.");
        return null;
    }
}
