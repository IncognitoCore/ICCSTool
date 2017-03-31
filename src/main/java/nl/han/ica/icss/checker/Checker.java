package nl.han.ica.icss.checker;

import java.util.*;

import com.sun.tools.internal.jxc.ap.Const;
import nl.han.ica.icss.ast.*;

import javax.swing.text.Style;

public class Checker {

    public enum ValueType {
        PIXELVALUE,
        PERCENTAGE,
        COLORVALUE,
        UNDEFINED
    }

    private static final Map<String, ArrayList<ValueType>> semantics = Collections.unmodifiableMap(
            new HashMap<String, ArrayList<ValueType>>() {{
                put("width", new ArrayList<>(Arrays.asList(ValueType.PIXELVALUE, ValueType.PERCENTAGE)));
                put("height", new ArrayList<>(Arrays.asList(ValueType.PIXELVALUE, ValueType.PERCENTAGE)));
                put("color", new ArrayList<>(Arrays.asList(ValueType.COLORVALUE)));
                put("background-color", new ArrayList<>(Arrays.asList(ValueType.COLORVALUE)));
            }}
    );

    private HashMap<String, Value> symboltable;

    public void check(AST ast) {
        //Clear
        symboltable = new HashMap<>();

        //DO THE CHECKING HERE...
        System.out.println("\n== CHECKING ==");
        checkStylesheet(ast);
        System.out.println("Checking finished.");

        //Save the symboltable.
        ast.symboltable = symboltable;
        //Save the verdict
        if (ast.getErrors().isEmpty()) {
            ast.checked = true;
        }
    }

    private void checkStylesheet(AST ast) {
        // start method
        System.out.println("> Checking Stylesheet");

        // First we need to make sure we put all the variables in the symboltable
        for (ASTNode node : ast.root.body) {
            if (node instanceof Assignment) {
                checkAssignment((Assignment) node);
            }
        }
        for (ASTNode node : ast.root.body) {
            if (node instanceof Stylerule) {
                checkStyleRule((Stylerule) node);
            }
        }
    }

    private void checkAssignment(Assignment assignment) {
        System.out.printf("+ Checking %s\n", assignment.getNodeLabel());
        addAssignment(assignment);
    }

    private void addAssignment(Assignment assignment) {
        System.out.println("Setting a new constant");
        if (symboltable.containsKey(assignment.name.name)) {
            System.out.println("That variable already exists!");
            assignment.setError("Constant " + assignment.name.name + " is already defined!");
        } else {
            if (assignment.value instanceof ConstantReference) { // If the assignment value is a reference to a constant
//                checkConstantReference(((ConstantReference) assignment.value)); // Doesn't work because ConstantReference isn't in the tree. According
                if (!symboltable.containsKey(((ConstantReference) assignment.value).name)) { // Check if it exists
                    assignment.setError("Variable " + ((ConstantReference) assignment.value).name + " not declared!");
                }
            }
            symboltable.put(assignment.name.name, assignment.value);
            if (assignment.value instanceof Operation) {
                //checkOperation((Operation) assignment.value, assignment);
                System.out.println("is instance of operation");
                System.out.println((Operation) assignment.value);
            }
        }
    }

    private void checkStyleRule(Stylerule stylerule) {
        System.out.printf("- Checking %s\n", stylerule.getNodeLabel());
        for (ASTNode node : stylerule.getChildren()) {
            if (node instanceof Declaration) {
                checkDeclaration((Declaration) node);
            } else if (node instanceof Stylerule) {
                checkStyleRule((Stylerule) node);
            } else {
                node.setError("Found " + node.getNodeLabel() + ".");
            }
        }
    }

    private void checkDeclaration(Declaration declaration) {
        System.out.printf("Checking %s\n", declaration.getNodeLabel());
        checkValue(declaration.value, declaration);
        if (semantics.containsKey(declaration.property)) {
            checkValueSemantically(declaration.property, declaration.value, semantics.get(declaration.property), declaration);
        }
    }

    private void checkValue(Value value, ASTNode parent) {
        if (value instanceof ConstantReference) {
            checkConstantReference((ConstantReference) value);
        }
        if (value instanceof Operation) {
            checkOperation((Operation) value, parent);
        }
    }


    private void checkValueSemantically(String name, Value value, ArrayList<ValueType> accepts, ASTNode parent) {
        ValueType type = getValueType(value);
        if (!accepts.contains(type)) {
            switch (type) {
                case PIXELVALUE:
                    parent.setError("Typemissmatch: expecting value of type " + name + ", found pixel value.");
                    break;
                case PERCENTAGE:
                    parent.setError("Typemissmatch: expecting value of type " + name + ", found percentage value.");
                    break;
                case COLORVALUE:
                    parent.setError("Typemissmatch: expecting value of type " + name + ", found color value.");
                    break;
                default:
                case UNDEFINED:
                    parent.setError("Typemissmatch: expecting value of type " + name + ", found unexpected value.");
                    break;
            }
        }
    }

    private ValueType getValueType(Value value) {
        if (value instanceof PixelLiteral) {
            return ValueType.PIXELVALUE;
        }

        if (value instanceof PercentageLiteral) {
            return ValueType.PERCENTAGE;
        }

        if (value instanceof ColorLiteral) {
            return ValueType.COLORVALUE;
        }

        if (value instanceof Operation) {
            return getValueType(((Operation) value).lhs);
        }

        if (value instanceof ConstantReference) {
            ConstantReference reference = (ConstantReference) value;
            if (symboltable.containsKey(reference.name)) {
                Value refValue = symboltable.get(reference.name);
                return getValueType(refValue);
            }
        }
        return ValueType.UNDEFINED;
    }

//    private void checkColorLiteral(ColorLiteral colorLiteral, String type) {
//        System.out.printf("Checking %s\n", colorLiteral.getNodeLabel());
//        if (!(type.equals("color") | type.equals("background-color"))) {
//            colorLiteral.setError("Type missmatch: " + colorLiteral.getNodeLabel() + " is not of type " + type);
//        }
//    }
//
//    private void checkPixelLiteral(PixelLiteral pixelLiteral, String type) {
//        System.out.printf("Checking %s\n", pixelLiteral.getNodeLabel());
//        if (!(type.equals("width") | type.equals("height"))) {
//            pixelLiteral.setError("Type missmatch: " + pixelLiteral.getNodeLabel() + " is not of type " + type);
//        }
//    }
//
//    private void checkPercentageLiteral(PercentageLiteral percentageLiteral, String type) {
//        System.out.printf("Checking %s\n", percentageLiteral.getNodeLabel());
//        if (!(type.equals("width") | type.equals("height"))) {
//            percentageLiteral.setError("Type missmatch: " + percentageLiteral.getNodeLabel() + " is not of type " + type);
//        }
//
//    }

    private void checkOperation(Operation operation, ASTNode parent) {
        System.out.printf("Checking %s\n", operation.getNodeLabel());
        Class checkrhs = operation.rhs.getClass();
        Class checklhs = operation.lhs.getClass();
        if (operation.lhs instanceof ConstantReference) {
            System.out.println("lhs is cr");
            checklhs = (symboltable.get(((ConstantReference) operation.lhs).name)).getClass();
        }
        if (operation.rhs instanceof ConstantReference) {
            System.out.println("rhs is cr");
            checkrhs = (symboltable.get(((ConstantReference) operation.rhs).name)).getClass();
        }
        System.out.printf("%s == %s\n", checklhs, checkrhs);
        if (!(checkrhs == checklhs)) {
            if (parent instanceof Assignment) {
                parent.setError("Type missmatch: " + operation.lhs.getNodeLabel() + " is not of same type as "
                        + operation.rhs.getNodeLabel());
            } else {
                operation.setError("Type missmatch: " + operation.lhs.getNodeLabel() + " is not of same type as "
                        + operation.rhs.getNodeLabel());
            }
        }
    }

    private void checkConstantReference(ConstantReference constantReference) {
        System.out.printf("Checking %s\n", constantReference.getNodeLabel());
        if (!symboltable.containsKey(constantReference.name)) {
            constantReference.setError("Variable " + constantReference.name + " not declared!");
        }
    }


}
