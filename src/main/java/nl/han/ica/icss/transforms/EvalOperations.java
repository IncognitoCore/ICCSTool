package nl.han.ica.icss.transforms;

import nl.han.ica.icss.ast.*;

import java.util.ArrayList;
import java.util.Stack;

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
        }

        if (node instanceof Operation) {
            if (parent instanceof Declaration) { // Actions to do when the parent is of type Declaration
                Declaration declaration = (Declaration) parent;
                declaration.value = resolveOperation((Operation) node);
            } else if(parent instanceof Assignment) {
                System.out.println("THATS AN ASSIGNMENT");
                Assignment assignment = (Assignment) parent;
                assignment.value = resolveOperation((Operation) node);
            } else {
                System.out.println("!! Operation for this parent isn't implemented yet!");
            }
            System.out.printf("%s transformed.\n", node.getNodeLabel());
        } else if (node.getChildren().size() > 0) {
            ArrayList<ASTNode> children = node.getChildren();
            for (ASTNode child : children) {
                checkChild(child, parent);
            }
        }
    }

    // This method resolves an operation to a value (a PixelLiteral or PercentageLiteral).
    // Use this function to resolve operations containing PixelLiterals or PercentageLiterals.
    private Value resolveOperation(Operation operation){
        // We resolve operations via postfix, because we can't resolve an operation recursively, since this will fail
        // in cases where you use a subtract operation in a operation consisting of 2 or more operations.
        // E.g. 200 - 20 - 20 will resolve 20 - 20 to 0. 200 - 0 = 200, while the correct answer would be 160.
        // An alternative would be to use recursion backwards, but using postfix will also work for multiply- and devide
        // which may be introduced in future releases.

        Stack stack = new Stack();
        // We use a stack to push these operation values to. This way we only have to walk through our stack later on,
        // to resolve the operation. An alternative would be to use a tree here.

        // Transforming the full operation to a postfix notation.
        transformOperation(operation, stack);

        // Resolve the full operation using the postfix notation.
        Value result = calculateResult(stack);
//        System.out.printf("%s resolved to %s.\n", operation.getNodeLabel(), result.getNodeLabel());
        return result;
    }

    // This method resolves a postfix notated operation.
    private Value calculateResult(Stack stack){
        Operation calculation = new Operation();
        calculation.lhs = (Value) stack.pop();
        while(!(stack.empty())){
            calculation.rhs = (Value) stack.pop();
            calculation.operator = (Operation.Operator) stack.pop();
            calculation.lhs = calculate(calculation);
        }

        return calculation.lhs;
    }

    // This method transforms a multi-operation to a postfix notation.
    private void transformOperation(Operation operation, Stack stack){
        transformInnerOperation(operation, stack);
        stack.push(operation.lhs); // We do need to add our first number outside of this recursive method.
    }

    // This method transforms a single-operation to a postfix notation.
    private void transformInnerOperation(Operation operation, Stack stack){
        if(operation.lhs.getChildren().size() > 0){
            operation.lhs = resolveOperation((Operation) operation.lhs);
        }
        if(operation.rhs.getChildren().size() > 0){
            transformInnerOperation((Operation) operation.rhs, stack);
        }

        if (operation.rhs instanceof Operation) {
            stack.push(operation.operator);
            stack.push(((Operation) operation.rhs).lhs);
        } else {
            stack.push(operation.operator);
            stack.push(operation.rhs);
        }
    }

    // This method resolves a single-operation into a calculation.
    private Value calculate(Operation operation){
        if(operation.operator == Operation.Operator.MIN){
            return sub(operation);
        }
        return add(operation);
    }

    // This method subtracts value 1 from value 2 in a single-operation.
    private Value sub(Operation operation) {
        return resolveValue(operation, resolveValue(operation.lhs) - resolveValue(operation.rhs));
    }

    // This method adds value 1 to value 2 in a single-operation.
    private Value add(Operation operation) {
        return resolveValue(operation, resolveValue(operation.lhs) + resolveValue(operation.rhs));
    }

    // This method resolves a value of type Value to an Integer.
    private int resolveValue(Value value) {
        if (value instanceof PixelLiteral) {
            return ((PixelLiteral) value).value;
        } else if (value instanceof PercentageLiteral) {
            return ((PercentageLiteral) value).value;
        }
//        else if (value instanceof ConstantReference) {
//            symboltable
//            return resolveValue(((ConstantReference) value).);
//        }

        // else (we should never get here anyway)
        value.setError("Unexpected error while resolving value.");
        return 0;
    }

    // This method resolves a value of type Integer to a Value (using the value-type of the operation's lhs).
    // This is possible because the lhs and rhs should always be of the same type.
    private Value resolveValue(Operation operation, int value) {
        if (operation.lhs instanceof PixelLiteral) {
            return new PixelLiteral(value);
        } else if (operation.lhs instanceof PercentageLiteral) {
            return new PercentageLiteral(value);
        }
//        else if (operation.lhs instanceof Operation) {
//            // todo: operation $a - 20px
//            // when $a = 100px - $b;
//        }

        // else (we should never get here anyway)
        operation.setError("Unexpected error while resolving value.");
        return null;
    }
}
