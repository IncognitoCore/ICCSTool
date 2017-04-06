package nl.han.ica.icss.generator;

import nl.han.ica.icss.ast.*;

import java.util.ArrayList;

public class Generator {

    public StringBuilder cssStylesheet;

    public String generate(AST ast) {
        System.out.println("\n== GENERATING ==");
        cssStylesheet = new StringBuilder();
        buildChilds(ast.root.body);
        System.out.println("Generating finished.");
        return cssStylesheet.toString();
    }

    private void buildChilds(ArrayList<ASTNode> ast) {
        for (ASTNode node : ast) {
            buildChild(node);
        }
    }

    private void buildChild(ASTNode node) {
        if (node instanceof Stylerule) {
            buildStylerule((Stylerule) node, new ArrayList<>());
        }
    }

    private void buildStylerule(Stylerule stylerule, ArrayList<ASTNode> parent) {
        buildSelector(stylerule, parent);
        cssStylesheet.append(" {\n");
        for (ASTNode styleruleChild : stylerule.getChildren()) {
            if (styleruleChild instanceof Declaration) {
                buildDeclaration((Declaration) styleruleChild);
            }
        }
        cssStylesheet.append("}\n\n");
        System.out.printf("%s generated.\n", stylerule.getNodeLabel());

        for (ASTNode styleruleChild : stylerule.getChildren()) {
            if (styleruleChild instanceof Stylerule) {
                // For inner style rules
                parent.add(stylerule);
                buildStylerule((Stylerule) styleruleChild, parent);
            }
        }
    }

    private void buildSelector(Stylerule stylerule, ArrayList<ASTNode> parent) {
        for(ASTNode node : parent) {
            Stylerule parentRule = (Stylerule)node;
            cssStylesheet.append(parentRule.selector + " > ");
        }
        cssStylesheet.append(stylerule.selector.toString());
    }

    private void buildDeclaration(Declaration declaration) {
        cssStylesheet.append("\t");
        cssStylesheet.append(declaration.property);
        cssStylesheet.append(": ");
        buildValue(declaration.value);
        cssStylesheet.append(";\n");
    }

    private void buildValue(Value value) {
        if (value instanceof ColorLiteral) {
            cssStylesheet.append(((ColorLiteral) value).value);
        } else if (value instanceof PercentageLiteral) {
            cssStylesheet.append(((PercentageLiteral) value).value + "%");
        } else if (value instanceof PixelLiteral) {
            cssStylesheet.append(((PixelLiteral) value).value + "px");
        }
    }

}
