// Generated from nl/han/ica/icss/parser/ICSS.g4 by ANTLR 4.3
package nl.han.ica.icss.parser;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ICSSParser}.
 */
public interface ICSSListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ICSSParser#stylesheet}.
	 * @param ctx the parse tree
	 */
	void enterStylesheet(@NotNull ICSSParser.StylesheetContext ctx);
	/**
	 * Exit a parse tree produced by {@link ICSSParser#stylesheet}.
	 * @param ctx the parse tree
	 */
	void exitStylesheet(@NotNull ICSSParser.StylesheetContext ctx);

	/**
	 * Enter a parse tree produced by {@link ICSSParser#selectorId}.
	 * @param ctx the parse tree
	 */
	void enterSelectorId(@NotNull ICSSParser.SelectorIdContext ctx);
	/**
	 * Exit a parse tree produced by {@link ICSSParser#selectorId}.
	 * @param ctx the parse tree
	 */
	void exitSelectorId(@NotNull ICSSParser.SelectorIdContext ctx);

	/**
	 * Enter a parse tree produced by {@link ICSSParser#constant}.
	 * @param ctx the parse tree
	 */
	void enterConstant(@NotNull ICSSParser.ConstantContext ctx);
	/**
	 * Exit a parse tree produced by {@link ICSSParser#constant}.
	 * @param ctx the parse tree
	 */
	void exitConstant(@NotNull ICSSParser.ConstantContext ctx);

	/**
	 * Enter a parse tree produced by the {@code pixelLiteral}
	 * labeled alternative in {@link ICSSParser#constantValue}.
	 * @param ctx the parse tree
	 */
	void enterPixelLiteral(@NotNull ICSSParser.PixelLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code pixelLiteral}
	 * labeled alternative in {@link ICSSParser#constantValue}.
	 * @param ctx the parse tree
	 */
	void exitPixelLiteral(@NotNull ICSSParser.PixelLiteralContext ctx);

	/**
	 * Enter a parse tree produced by {@link ICSSParser#styleRules}.
	 * @param ctx the parse tree
	 */
	void enterStyleRules(@NotNull ICSSParser.StyleRulesContext ctx);
	/**
	 * Exit a parse tree produced by {@link ICSSParser#styleRules}.
	 * @param ctx the parse tree
	 */
	void exitStyleRules(@NotNull ICSSParser.StyleRulesContext ctx);

	/**
	 * Enter a parse tree produced by {@link ICSSParser#constantName}.
	 * @param ctx the parse tree
	 */
	void enterConstantName(@NotNull ICSSParser.ConstantNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link ICSSParser#constantName}.
	 * @param ctx the parse tree
	 */
	void exitConstantName(@NotNull ICSSParser.ConstantNameContext ctx);

	/**
	 * Enter a parse tree produced by {@link ICSSParser#selectorTag}.
	 * @param ctx the parse tree
	 */
	void enterSelectorTag(@NotNull ICSSParser.SelectorTagContext ctx);
	/**
	 * Exit a parse tree produced by {@link ICSSParser#selectorTag}.
	 * @param ctx the parse tree
	 */
	void exitSelectorTag(@NotNull ICSSParser.SelectorTagContext ctx);

	/**
	 * Enter a parse tree produced by {@link ICSSParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration(@NotNull ICSSParser.DeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link ICSSParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration(@NotNull ICSSParser.DeclarationContext ctx);

	/**
	 * Enter a parse tree produced by {@link ICSSParser#declarations}.
	 * @param ctx the parse tree
	 */
	void enterDeclarations(@NotNull ICSSParser.DeclarationsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ICSSParser#declarations}.
	 * @param ctx the parse tree
	 */
	void exitDeclarations(@NotNull ICSSParser.DeclarationsContext ctx);

	/**
	 * Enter a parse tree produced by the {@code colorLiteral}
	 * labeled alternative in {@link ICSSParser#constantValue}.
	 * @param ctx the parse tree
	 */
	void enterColorLiteral(@NotNull ICSSParser.ColorLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code colorLiteral}
	 * labeled alternative in {@link ICSSParser#constantValue}.
	 * @param ctx the parse tree
	 */
	void exitColorLiteral(@NotNull ICSSParser.ColorLiteralContext ctx);

	/**
	 * Enter a parse tree produced by {@link ICSSParser#styleRule}.
	 * @param ctx the parse tree
	 */
	void enterStyleRule(@NotNull ICSSParser.StyleRuleContext ctx);
	/**
	 * Exit a parse tree produced by {@link ICSSParser#styleRule}.
	 * @param ctx the parse tree
	 */
	void exitStyleRule(@NotNull ICSSParser.StyleRuleContext ctx);

	/**
	 * Enter a parse tree produced by {@link ICSSParser#selector}.
	 * @param ctx the parse tree
	 */
	void enterSelector(@NotNull ICSSParser.SelectorContext ctx);
	/**
	 * Exit a parse tree produced by {@link ICSSParser#selector}.
	 * @param ctx the parse tree
	 */
	void exitSelector(@NotNull ICSSParser.SelectorContext ctx);

	/**
	 * Enter a parse tree produced by {@link ICSSParser#constants}.
	 * @param ctx the parse tree
	 */
	void enterConstants(@NotNull ICSSParser.ConstantsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ICSSParser#constants}.
	 * @param ctx the parse tree
	 */
	void exitConstants(@NotNull ICSSParser.ConstantsContext ctx);

	/**
	 * Enter a parse tree produced by {@link ICSSParser#selectorClass}.
	 * @param ctx the parse tree
	 */
	void enterSelectorClass(@NotNull ICSSParser.SelectorClassContext ctx);
	/**
	 * Exit a parse tree produced by {@link ICSSParser#selectorClass}.
	 * @param ctx the parse tree
	 */
	void exitSelectorClass(@NotNull ICSSParser.SelectorClassContext ctx);

	/**
	 * Enter a parse tree produced by {@link ICSSParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValue(@NotNull ICSSParser.ValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link ICSSParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValue(@NotNull ICSSParser.ValueContext ctx);

	/**
	 * Enter a parse tree produced by {@link ICSSParser#operation}.
	 * @param ctx the parse tree
	 */
	void enterOperation(@NotNull ICSSParser.OperationContext ctx);
	/**
	 * Exit a parse tree produced by {@link ICSSParser#operation}.
	 * @param ctx the parse tree
	 */
	void exitOperation(@NotNull ICSSParser.OperationContext ctx);

	/**
	 * Enter a parse tree produced by the {@code percentageLiteral}
	 * labeled alternative in {@link ICSSParser#constantValue}.
	 * @param ctx the parse tree
	 */
	void enterPercentageLiteral(@NotNull ICSSParser.PercentageLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code percentageLiteral}
	 * labeled alternative in {@link ICSSParser#constantValue}.
	 * @param ctx the parse tree
	 */
	void exitPercentageLiteral(@NotNull ICSSParser.PercentageLiteralContext ctx);
}