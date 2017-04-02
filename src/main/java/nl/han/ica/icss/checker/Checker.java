package nl.han.ica.icss.checker;

import java.util.*;

import nl.han.ica.icss.ast.*;

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
        // First we need to make sure we put all the constants in the symboltable
        // Two for loops are required here, because we can't check constant references before setting all the constants
        // in the style sheet. This is because we can use constants in the syntax before we declared and initialized
        // them.
        for (ASTNode node : ast.root.body) {
            if (node instanceof Assignment) {
                addAssignment((Assignment) node);
            }
        }
        for (ASTNode node : ast.root.body) {
            if (node instanceof Assignment) {
                checkAssignment((Assignment) node);
            }
            if (node instanceof Stylerule) {
                checkStyleRule((Stylerule) node);
            }
        }
    }

    private void addAssignment(Assignment assignment) {
        if (symboltable.containsKey(assignment.name.name)) { // Constant already exists
            assignment.setError(assignment.getNodeLabel() + " has already been defined!");
        } else {
            symboltable.put(assignment.name.name, assignment.value);
        }
        System.out.printf("%s declared.\n", assignment.getNodeLabel());
    }

    private void checkAssignment(Assignment assignment) {
        if (assignment.value instanceof ConstantReference) { // If the assignment value is a reference to a constant
            checkConstantReference(((ConstantReference) assignment.value));
            if (!symboltable.containsKey(((ConstantReference) assignment.value).name)) { // Check if it exists
                assignment.setError(assignment.value.getNodeLabel() + " not declared!");
            }
        }
        System.out.printf("%s checked.\n", assignment.getNodeLabel());
    }

    private void checkStyleRule(Stylerule stylerule) {
        for (ASTNode styleruleChild : stylerule.getChildren()) {
            if (styleruleChild instanceof Declaration) {
                checkDeclaration((Declaration) styleruleChild);
            } else if (styleruleChild instanceof Stylerule) {
                checkStyleRule((Stylerule) styleruleChild);
            }
        }
        System.out.printf("%s checked.\n", stylerule.getNodeLabel());
    }

    private void checkDeclaration(Declaration declaration) {
        checkValue(declaration.value);
        if (semantics.containsKey(declaration.property)) {
            checkValueSemantically(declaration.property, declaration.value, semantics.get(declaration.property),
                    declaration);
        }
        System.out.printf("%s checked.\n", declaration.getNodeLabel());
    }

    private void checkValue(Value value) {
        if (value instanceof ConstantReference) {
            checkConstantReference((ConstantReference) value);
        }
        if (value instanceof Operation) {
            checkOperation((Operation) value);
        }
    }

    private void checkConstantReference(ConstantReference constantReference) {
        if (!symboltable.containsKey(constantReference.name)) {
            constantReference.setError("Variable " + constantReference.name + " not declared!");
        }
        System.out.printf("%s checked.\n", constantReference.getNodeLabel());
    }

    private void checkValueSemantically(String attributename, Value value, ArrayList<ValueType> accepts, ASTNode parent) {
        ValueType type = getValueType(value);
        if (!accepts.contains(type)) {
            parent.setError("Type mismatch: cannot assign " + value.getClass() + " to " + attributename + "-attribute");
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

    private Value checkOperation(Operation operation) {
        Value checklhs = operation.lhs;
        Value checkrhs = operation.rhs;

        if (operation.lhs instanceof Operation) {
            checklhs = checkOperation((Operation) operation.lhs);
        }
        if (operation.rhs instanceof Operation) {
            checkrhs = checkOperation((Operation) operation.rhs);
        }
        if (operation.lhs instanceof ConstantReference) {
            checklhs = resolveReference((ConstantReference) operation.lhs);
        }
        if (operation.rhs instanceof ConstantReference) {
            checkrhs = resolveReference((ConstantReference) operation.rhs);
        }

        if (checkrhs.getClass() == ColorLiteral.class || checklhs.getClass() == ColorLiteral.class) {
            operation.setError("Operator '" + operation.operator + "' cannot be applied to " + ColorLiteral.class);
            checklhs = null;
        } else if (!(checkrhs.getClass() == checklhs.getClass())) {
            operation.setError("Type mismatch: cannot convert " + checkrhs.getClass() + " to "
                    + checklhs.getClass());
            checklhs = null;
        }
        System.out.printf("%s checked.\n", operation.getNodeLabel());

        return checklhs;
    }

    private Value resolveReference(ConstantReference reference) {
        Value referenceValue = symboltable.get(reference.name); // Getting the referenceValue from the referenceTable
        if (referenceValue instanceof ConstantReference) {
            referenceValue = resolveReference((ConstantReference) referenceValue);
        }
        if (referenceValue instanceof Operation) {
            Value resolvedOperation = checkOperation((Operation) referenceValue);
            if (!(resolvedOperation == null)) { // To avoid a nullpointer exception!
                referenceValue = resolvedOperation;
            }
        }
        return referenceValue;
    }

}
