package nl.han.ica.icss.parser;

import java.util.Stack;

import com.sun.tools.internal.jxc.ap.Const;
import nl.han.ica.icss.ast.*;
import org.antlr.v4.runtime.misc.NotNull;

/**
 * This class extracts the ICSS Abstract Syntax Tree from the Antlr Parse tree.
 */
public class ASTListener extends ICSSBaseListener {

    private AST ast;
    private Stack stack; // Declaring a stack variable (see explanation below).

    // I am using a stack, because we need a list-like variable to push all found items to while we work with them.
    // When a new item is found/recognized it will be pushed to the stack.
    // When we are done parsing this item it will be removed (popped) from the stack.

    public ASTListener() {
        ast = new AST();
    }

    public AST getAST() {
        return ast;
    }

    @Override
    // This method is called when entering a stylesheet (should only be once, since you parse only one stylesheet at a
    // time)
    public void enterStylesheet(@NotNull ICSSParser.StylesheetContext ctx) {
        System.out.println("\n== PARSING ==");
        System.out.println("> Parsing Stylesheet");
        ast.setRoot(new Stylesheet()); // Add root-node to AST tree
        stack = new Stack(); // Create a new stack
    }

    @Override
    public void enterConstant(@NotNull ICSSParser.ConstantContext ctx) {
        System.out.println("ASTListener.enterConstant");
        Assignment assignment = new Assignment();
        stack.push(assignment);
    }

    @Override
    public void enterConstantName(@NotNull ICSSParser.ConstantNameContext ctx) {
        System.out.println("ASTListener.enterConstantName");
        ConstantReference constantReference = new ConstantReference(ctx.getText());
        if (stack.peek() instanceof Declaration) { // Checking the parent-Node's type
            // We check the parent-Node's type. In this case the parent-Node's type is a declaration. This means that
            // this is should be a reference to another (previously declared) constant according to the ICS language
            // specification.
            System.out.println("-> Referencing constant: " + ctx.getText());
            Declaration declaration = (Declaration) stack.peek(); // Casting peeked Node to a Declaration object
            // Casting must be done here because Java doesn't accept all Nodes in the Declaration variable even though
            // the if-statement above excludes all other objects.
            declaration.value = constantReference; // Setting the declaration value
        }
        if (stack.peek() instanceof Assignment) {
            // In the case of the parent-type being an Assignment, this must be a new constant according to the ICSS
            // language specification.
            Assignment assignment = (Assignment) stack.peek();
            if (assignment.name != null) {
                System.out.println("-> Referencing constant: " + ctx.getText());
                assignment.value = constantReference;
            } else {
                System.out.println("-> Setting new constant: " + ctx.getText());
                assignment.name = constantReference;
            }
        }
        if (stack.peek() instanceof Operation) {
            System.out.println("-> Referencing constant: " + ctx.getText());
            Operation operation = (Operation) stack.peek();
            if (operation.lhs == null) {
                operation.lhs = constantReference;
            } else if (operation.rhs == null) {
                operation.rhs = constantReference;
            }
        }
    }

    @Override
    public void enterStyleRule(@NotNull ICSSParser.StyleRuleContext ctx) {
        System.out.println("ASTListener.enterStyleRule");
        Stylerule stylerule = new Stylerule(); // Creating a new Stylerule object
        stack.push(stylerule); // Pushing te Stylerule object to the stack, so we can use it in the next method(s)
    }

    @Override
    public void enterSelector(@NotNull ICSSParser.SelectorContext ctx) {
        System.out.println("ASTListener.enterSelector");
        if (stack.peek() instanceof Stylerule) {
            Selector selector = new Selector();
            stack.push(selector);
        }
    }

    @Override
    public void enterSelectorTag(@NotNull ICSSParser.SelectorTagContext ctx) {
        System.out.println("ASTListener.enterSelectorTag");
        if (stack.peek() instanceof Selector) {
            Selector selector = (Selector) stack.peek(); // Retrieving the Selector object from the stack
            selector.tag = ctx.getText();  // Put the read text in the Selector object.
            // (Since this is a reference you don't have to re-add it to the stack)
        }
    }

    @Override
    // This method is used when we have an ID selector (this means that it starts with #, like #menu)
    public void enterSelectorId(@NotNull ICSSParser.SelectorIdContext ctx) {
        System.out.println("ASTListener.enterSelectorId");
        if (stack.peek() instanceof Selector) {
            Selector selector = (Selector) stack.peek();
            selector.id = ctx.ID().getText();
        }
    }

    @Override
    // This method is used when we have an Class selector (this means that it starts with ., like .menu)
    public void enterSelectorClass(@NotNull ICSSParser.SelectorClassContext ctx) {
        System.out.println("ASTListener.enterSelectorClass");
        if (stack.peek() instanceof Selector) {
            Selector selector = (Selector) stack.peek();
            selector.cls = ctx.ID().getText();
        }
    }

    @Override
    public void exitSelector(@NotNull ICSSParser.SelectorContext ctx) {
        System.out.println("ASTListener.exitSelector");
        if (stack.peek() instanceof Selector) {
            Selector selector = (Selector) stack.pop();
            if (stack.peek() instanceof Stylerule) {
                Stylerule stylerule = (Stylerule) stack.peek();
                stylerule.selector = selector;
            } else {
                // throw exception
            }
        }

    }

    @Override
    public void enterDeclaration(@NotNull ICSSParser.DeclarationContext ctx) {
        System.out.println("ASTListener.enterDeclaration");
        Declaration declaration = new Declaration();
        // You dont set declaration.value here, because you don't know which value type you are setting.
        // This is done in the setValue() method;
        declaration.property = ctx.ID().getText();
        stack.push(declaration);
    }

    @Override
    public void enterPixelLiteral(@NotNull ICSSParser.PixelLiteralContext ctx) {
        System.out.println("ASTListener.enterPixelLiteral");
        PixelLiteral pixelLiteral = new PixelLiteral(ctx.getText());
        setValue(pixelLiteral);
    }

    @Override
    public void enterPercentageLiteral(@NotNull ICSSParser.PercentageLiteralContext ctx) {
        System.out.println("ASTListener.enterPercentageLiteral");
        PercentageLiteral percentageLiteral = new PercentageLiteral(ctx.getText());
        setValue(percentageLiteral);
    }

    @Override
    public void enterColorLiteral(@NotNull ICSSParser.ColorLiteralContext ctx) {
        System.out.println("ASTListener.enterColorLiteral");
        ColorLiteral colorLiteral = new ColorLiteral(ctx.getText());
        setValue(colorLiteral);
    }

    private void setValue(Literal literal) {
        if (stack.peek() instanceof Declaration) {
            Declaration declaration = (Declaration) stack.peek();
            declaration.value = literal;
        } else if (stack.peek() instanceof Assignment) {
            Assignment assignment = (Assignment) stack.peek();
            assignment.value = literal;
        } else if (stack.peek() instanceof Operation) {
            Operation operation = (Operation) stack.peek();
            if (operation.lhs == null) {
                operation.lhs = literal;
            } else if (operation.rhs == null) {
                operation.rhs = literal;
            } else {
                //throw new Exception("LHS and RHS are both already set.");
            }
        } else {
            // throw new Exception("Setting value for a non-valid parent");
        }
    }

    @Override
    public void enterOperation(@NotNull ICSSParser.OperationContext ctx) {
        System.out.println("ASTListener.enterOperation");
        Operation operation = new Operation();
        if (ctx.Operator() != null) {
            if (ctx.Operator().getText().equals("+")) {
                operation.operator = Operation.Operator.PLUS;
            } else if (ctx.Operator().getText().equals("-")) {
                operation.operator = Operation.Operator.MIN;
            }
        }
        stack.push(operation);
    }

    @Override
    public void exitOperation(@NotNull ICSSParser.OperationContext ctx) {
        System.out.println("ASTListener.exitOperation");
        if (stack.peek() instanceof Operation) {
            Operation operation = (Operation) stack.pop();
            if (stack.peek() instanceof Declaration
                    || stack.peek() instanceof Assignment
                    || stack.peek() instanceof Operation) {
                System.out.println("?? Adding operation to parent");
                ASTNode parent = (ASTNode) stack.peek();
                parent.addChild(operation);
            } else {
                // exception
            }
        }
    }

    @Override
    public void exitDeclaration(@NotNull ICSSParser.DeclarationContext ctx) {
        System.out.println("ASTListener.exitDeclaration");
        if (stack.peek() instanceof Declaration) {
            Declaration declaration = (Declaration) stack.pop();
            if (declaration.value == null) {
                System.out.printf("%s has no value\n", declaration.property);
            } else if (stack.peek() instanceof Stylerule) {
                Stylerule stylerule = (Stylerule) stack.peek();
                stylerule.addChild(declaration);
            } else {
                // exception
            }
        } else {
            // exception
        }
    }

    @Override
    public void exitConstant(@NotNull ICSSParser.ConstantContext ctx) {
        System.out.println("ASTListener.exitConstant");
        if (stack.peek() instanceof Assignment) {
            Assignment assignment = (Assignment) stack.pop();
            ast.root.addChild(assignment);
        } else {
            // exception
        }
    }

    @Override
    // This method adds the style rule to the parent style rule or to the ast tree
    public void exitStyleRule(@NotNull ICSSParser.StyleRuleContext ctx) {
        System.out.println("ASTListener.exitStyleRule");
        if (stack.peek() instanceof Stylerule) {
            Stylerule stylerule = (Stylerule) stack.pop();
            if (!stack.empty()) { // This is needed for when you have a style rule into a style rule (into a style r...)
                // Adding the current style rule to the parent style rule
                ASTNode inner = (ASTNode) stack.peek();
                inner.addChild(stylerule);
            } else {
                // Adding the current style rule to the ast tree
                ast.root.addChild(stylerule);
            }
        }
    }

    @Override
    // This method does nothing except printing that your style sheet has ended and checking if parsing went fine
    public void exitStylesheet(@NotNull ICSSParser.StylesheetContext ctx) {
        System.out.println("ASTListener.exitStylesheet");
        if (!stack.empty()) {
            System.out.println("!! There was an error parsing your stylesheet: stack not empty!");
        }
        System.out.println("Parsing finished.");
    }


}