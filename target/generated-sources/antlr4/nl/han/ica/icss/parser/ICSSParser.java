// Generated from nl/han/ica/icss/parser/ICSS.g4 by ANTLR 4.3
package nl.han.ica.icss.parser;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ICSSParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		Operator=1, COLORLITERAL=2, PIXELLITERAL=3, PERCENTAGELITERAL=4, LBRACE=5, 
		RBRACE=6, COLON=7, SEMI=8, ADD=9, SUB=10, ASSIGN=11, DOLLARSIGN=12, HASHTAG=13, 
		DOT=14, PIXEL=15, PERCENT=16, ID=17, DEC=18, HEX=19, WS=20;
	public static final String[] tokenNames = {
		"<INVALID>", "Operator", "COLORLITERAL", "PIXELLITERAL", "PERCENTAGELITERAL", 
		"'{'", "'}'", "':'", "';'", "'+'", "'-'", "'='", "'$'", "'#'", "'.'", 
		"'px'", "'%'", "ID", "DEC", "HEX", "WS"
	};
	public static final int
		RULE_stylesheet = 0, RULE_styleRules = 1, RULE_styleRule = 2, RULE_declarations = 3, 
		RULE_selector = 4, RULE_selectorTag = 5, RULE_selectorId = 6, RULE_selectorClass = 7, 
		RULE_declaration = 8, RULE_value = 9, RULE_constants = 10, RULE_constant = 11, 
		RULE_constantName = 12, RULE_constantValue = 13, RULE_operation = 14;
	public static final String[] ruleNames = {
		"stylesheet", "styleRules", "styleRule", "declarations", "selector", "selectorTag", 
		"selectorId", "selectorClass", "declaration", "value", "constants", "constant", 
		"constantName", "constantValue", "operation"
	};

	@Override
	public String getGrammarFileName() { return "ICSS.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ICSSParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class StylesheetContext extends ParserRuleContext {
		public StyleRulesContext styleRules(int i) {
			return getRuleContext(StyleRulesContext.class,i);
		}
		public ConstantsContext constants(int i) {
			return getRuleContext(ConstantsContext.class,i);
		}
		public List<StyleRulesContext> styleRules() {
			return getRuleContexts(StyleRulesContext.class);
		}
		public List<ConstantsContext> constants() {
			return getRuleContexts(ConstantsContext.class);
		}
		public StylesheetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stylesheet; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).enterStylesheet(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).exitStylesheet(this);
		}
	}

	public final StylesheetContext stylesheet() throws RecognitionException {
		StylesheetContext _localctx = new StylesheetContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_stylesheet);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(34);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DOLLARSIGN) | (1L << HASHTAG) | (1L << DOT) | (1L << ID))) != 0)) {
				{
				setState(32);
				switch (_input.LA(1)) {
				case DOLLARSIGN:
					{
					setState(30); constants();
					}
					break;
				case HASHTAG:
				case DOT:
				case ID:
					{
					setState(31); styleRules();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(36);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StyleRulesContext extends ParserRuleContext {
		public List<StyleRuleContext> styleRule() {
			return getRuleContexts(StyleRuleContext.class);
		}
		public StyleRuleContext styleRule(int i) {
			return getRuleContext(StyleRuleContext.class,i);
		}
		public StyleRulesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_styleRules; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).enterStyleRules(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).exitStyleRules(this);
		}
	}

	public final StyleRulesContext styleRules() throws RecognitionException {
		StyleRulesContext _localctx = new StyleRulesContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_styleRules);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(38); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(37); styleRule();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(40); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StyleRuleContext extends ParserRuleContext {
		public TerminalNode RBRACE() { return getToken(ICSSParser.RBRACE, 0); }
		public SelectorContext selector() {
			return getRuleContext(SelectorContext.class,0);
		}
		public TerminalNode LBRACE() { return getToken(ICSSParser.LBRACE, 0); }
		public DeclarationsContext declarations() {
			return getRuleContext(DeclarationsContext.class,0);
		}
		public StyleRulesContext styleRules() {
			return getRuleContext(StyleRulesContext.class,0);
		}
		public StyleRuleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_styleRule; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).enterStyleRule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).exitStyleRule(this);
		}
	}

	public final StyleRuleContext styleRule() throws RecognitionException {
		StyleRuleContext _localctx = new StyleRuleContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_styleRule);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(42); selector();
			setState(43); match(LBRACE);
			setState(45);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				{
				setState(44); declarations();
				}
				break;
			}
			setState(48);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << HASHTAG) | (1L << DOT) | (1L << ID))) != 0)) {
				{
				setState(47); styleRules();
				}
			}

			setState(50); match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclarationsContext extends ParserRuleContext {
		public List<DeclarationContext> declaration() {
			return getRuleContexts(DeclarationContext.class);
		}
		public DeclarationContext declaration(int i) {
			return getRuleContext(DeclarationContext.class,i);
		}
		public DeclarationsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declarations; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).enterDeclarations(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).exitDeclarations(this);
		}
	}

	public final DeclarationsContext declarations() throws RecognitionException {
		DeclarationsContext _localctx = new DeclarationsContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_declarations);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(53); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(52); declaration();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(55); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SelectorContext extends ParserRuleContext {
		public SelectorTagContext selectorTag() {
			return getRuleContext(SelectorTagContext.class,0);
		}
		public SelectorIdContext selectorId() {
			return getRuleContext(SelectorIdContext.class,0);
		}
		public SelectorClassContext selectorClass() {
			return getRuleContext(SelectorClassContext.class,0);
		}
		public SelectorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selector; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).enterSelector(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).exitSelector(this);
		}
	}

	public final SelectorContext selector() throws RecognitionException {
		SelectorContext _localctx = new SelectorContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_selector);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(60);
			switch (_input.LA(1)) {
			case ID:
				{
				setState(57); selectorTag();
				}
				break;
			case HASHTAG:
				{
				setState(58); selectorId();
				}
				break;
			case DOT:
				{
				setState(59); selectorClass();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SelectorTagContext extends ParserRuleContext {
		public TerminalNode DEC() { return getToken(ICSSParser.DEC, 0); }
		public TerminalNode ID() { return getToken(ICSSParser.ID, 0); }
		public SelectorTagContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selectorTag; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).enterSelectorTag(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).exitSelectorTag(this);
		}
	}

	public final SelectorTagContext selectorTag() throws RecognitionException {
		SelectorTagContext _localctx = new SelectorTagContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_selectorTag);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(62); match(ID);
			setState(64);
			_la = _input.LA(1);
			if (_la==DEC) {
				{
				setState(63); match(DEC);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SelectorIdContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(ICSSParser.ID, 0); }
		public TerminalNode HASHTAG() { return getToken(ICSSParser.HASHTAG, 0); }
		public SelectorIdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selectorId; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).enterSelectorId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).exitSelectorId(this);
		}
	}

	public final SelectorIdContext selectorId() throws RecognitionException {
		SelectorIdContext _localctx = new SelectorIdContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_selectorId);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(66); match(HASHTAG);
			setState(67); match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SelectorClassContext extends ParserRuleContext {
		public TerminalNode DOT() { return getToken(ICSSParser.DOT, 0); }
		public TerminalNode ID() { return getToken(ICSSParser.ID, 0); }
		public SelectorClassContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selectorClass; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).enterSelectorClass(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).exitSelectorClass(this);
		}
	}

	public final SelectorClassContext selectorClass() throws RecognitionException {
		SelectorClassContext _localctx = new SelectorClassContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_selectorClass);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(69); match(DOT);
			setState(70); match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclarationContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(ICSSParser.ID, 0); }
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(ICSSParser.SEMI, 0); }
		public TerminalNode COLON() { return getToken(ICSSParser.COLON, 0); }
		public DeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).enterDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).exitDeclaration(this);
		}
	}

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_declaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(72); match(ID);
			setState(73); match(COLON);
			setState(74); value();
			setState(75); match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ValueContext extends ParserRuleContext {
		public ConstantValueContext constantValue() {
			return getRuleContext(ConstantValueContext.class,0);
		}
		public OperationContext operation() {
			return getRuleContext(OperationContext.class,0);
		}
		public ConstantNameContext constantName() {
			return getRuleContext(ConstantNameContext.class,0);
		}
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).enterValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).exitValue(this);
		}
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_value);
		try {
			setState(80);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(77); constantValue();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(78); constantName();
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(79); operation();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstantsContext extends ParserRuleContext {
		public List<ConstantContext> constant() {
			return getRuleContexts(ConstantContext.class);
		}
		public ConstantContext constant(int i) {
			return getRuleContext(ConstantContext.class,i);
		}
		public ConstantsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constants; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).enterConstants(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).exitConstants(this);
		}
	}

	public final ConstantsContext constants() throws RecognitionException {
		ConstantsContext _localctx = new ConstantsContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_constants);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(83); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(82); constant();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(85); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstantContext extends ParserRuleContext {
		public TerminalNode ASSIGN() { return getToken(ICSSParser.ASSIGN, 0); }
		public ConstantNameContext constantName(int i) {
			return getRuleContext(ConstantNameContext.class,i);
		}
		public TerminalNode SEMI() { return getToken(ICSSParser.SEMI, 0); }
		public OperationContext operation(int i) {
			return getRuleContext(OperationContext.class,i);
		}
		public ConstantValueContext constantValue() {
			return getRuleContext(ConstantValueContext.class,0);
		}
		public List<OperationContext> operation() {
			return getRuleContexts(OperationContext.class);
		}
		public List<ConstantNameContext> constantName() {
			return getRuleContexts(ConstantNameContext.class);
		}
		public ConstantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constant; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).enterConstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).exitConstant(this);
		}
	}

	public final ConstantContext constant() throws RecognitionException {
		ConstantContext _localctx = new ConstantContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_constant);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(87); constantName();
			setState(88); match(ASSIGN);
			setState(96);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				{
				setState(89); constantValue();
				}
				break;

			case 2:
				{
				setState(91); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(90); operation();
					}
					}
					setState(93); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << COLORLITERAL) | (1L << PIXELLITERAL) | (1L << PERCENTAGELITERAL) | (1L << DOLLARSIGN))) != 0) );
				}
				break;

			case 3:
				{
				setState(95); constantName();
				}
				break;
			}
			setState(98); match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstantNameContext extends ParserRuleContext {
		public TerminalNode DOLLARSIGN() { return getToken(ICSSParser.DOLLARSIGN, 0); }
		public TerminalNode ID() { return getToken(ICSSParser.ID, 0); }
		public ConstantNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constantName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).enterConstantName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).exitConstantName(this);
		}
	}

	public final ConstantNameContext constantName() throws RecognitionException {
		ConstantNameContext _localctx = new ConstantNameContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_constantName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(100); match(DOLLARSIGN);
			setState(101); match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstantValueContext extends ParserRuleContext {
		public ConstantValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constantValue; }
	 
		public ConstantValueContext() { }
		public void copyFrom(ConstantValueContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class PixelLiteralContext extends ConstantValueContext {
		public TerminalNode PIXELLITERAL() { return getToken(ICSSParser.PIXELLITERAL, 0); }
		public PixelLiteralContext(ConstantValueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).enterPixelLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).exitPixelLiteral(this);
		}
	}
	public static class PercentageLiteralContext extends ConstantValueContext {
		public TerminalNode PERCENTAGELITERAL() { return getToken(ICSSParser.PERCENTAGELITERAL, 0); }
		public PercentageLiteralContext(ConstantValueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).enterPercentageLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).exitPercentageLiteral(this);
		}
	}
	public static class ColorLiteralContext extends ConstantValueContext {
		public TerminalNode COLORLITERAL() { return getToken(ICSSParser.COLORLITERAL, 0); }
		public ColorLiteralContext(ConstantValueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).enterColorLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).exitColorLiteral(this);
		}
	}

	public final ConstantValueContext constantValue() throws RecognitionException {
		ConstantValueContext _localctx = new ConstantValueContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_constantValue);
		try {
			setState(106);
			switch (_input.LA(1)) {
			case PIXELLITERAL:
				_localctx = new PixelLiteralContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(103); match(PIXELLITERAL);
				}
				break;
			case COLORLITERAL:
				_localctx = new ColorLiteralContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(104); match(COLORLITERAL);
				}
				break;
			case PERCENTAGELITERAL:
				_localctx = new PercentageLiteralContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(105); match(PERCENTAGELITERAL);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OperationContext extends ParserRuleContext {
		public ConstantNameContext constantName(int i) {
			return getRuleContext(ConstantNameContext.class,i);
		}
		public ConstantValueContext constantValue(int i) {
			return getRuleContext(ConstantValueContext.class,i);
		}
		public List<ConstantValueContext> constantValue() {
			return getRuleContexts(ConstantValueContext.class);
		}
		public OperationContext operation() {
			return getRuleContext(OperationContext.class,0);
		}
		public TerminalNode Operator() { return getToken(ICSSParser.Operator, 0); }
		public List<ConstantNameContext> constantName() {
			return getRuleContexts(ConstantNameContext.class);
		}
		public OperationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).enterOperation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ICSSListener ) ((ICSSListener)listener).exitOperation(this);
		}
	}

	public final OperationContext operation() throws RecognitionException {
		OperationContext _localctx = new OperationContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_operation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(110);
			switch (_input.LA(1)) {
			case DOLLARSIGN:
				{
				setState(108); constantName();
				}
				break;
			case COLORLITERAL:
			case PIXELLITERAL:
			case PERCENTAGELITERAL:
				{
				setState(109); constantValue();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(112); match(Operator);
			setState(118);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				{
				setState(115);
				switch (_input.LA(1)) {
				case DOLLARSIGN:
					{
					setState(113); constantName();
					}
					break;
				case COLORLITERAL:
				case PIXELLITERAL:
				case PERCENTAGELITERAL:
					{
					setState(114); constantValue();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;

			case 2:
				{
				{
				setState(117); operation();
				}
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\26{\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t\13\4"+
		"\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\3\2\3\2\7\2#\n\2\f\2\16\2"+
		"&\13\2\3\3\6\3)\n\3\r\3\16\3*\3\4\3\4\3\4\5\4\60\n\4\3\4\5\4\63\n\4\3"+
		"\4\3\4\3\5\6\58\n\5\r\5\16\59\3\6\3\6\3\6\5\6?\n\6\3\7\3\7\5\7C\n\7\3"+
		"\b\3\b\3\b\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\5\13S\n\13\3"+
		"\f\6\fV\n\f\r\f\16\fW\3\r\3\r\3\r\3\r\6\r^\n\r\r\r\16\r_\3\r\5\rc\n\r"+
		"\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3\17\5\17m\n\17\3\20\3\20\5\20q\n\20"+
		"\3\20\3\20\3\20\5\20v\n\20\3\20\5\20y\n\20\3\20\2\2\21\2\4\6\b\n\f\16"+
		"\20\22\24\26\30\32\34\36\2\2\177\2$\3\2\2\2\4(\3\2\2\2\6,\3\2\2\2\b\67"+
		"\3\2\2\2\n>\3\2\2\2\f@\3\2\2\2\16D\3\2\2\2\20G\3\2\2\2\22J\3\2\2\2\24"+
		"R\3\2\2\2\26U\3\2\2\2\30Y\3\2\2\2\32f\3\2\2\2\34l\3\2\2\2\36p\3\2\2\2"+
		" #\5\26\f\2!#\5\4\3\2\" \3\2\2\2\"!\3\2\2\2#&\3\2\2\2$\"\3\2\2\2$%\3\2"+
		"\2\2%\3\3\2\2\2&$\3\2\2\2\')\5\6\4\2(\'\3\2\2\2)*\3\2\2\2*(\3\2\2\2*+"+
		"\3\2\2\2+\5\3\2\2\2,-\5\n\6\2-/\7\7\2\2.\60\5\b\5\2/.\3\2\2\2/\60\3\2"+
		"\2\2\60\62\3\2\2\2\61\63\5\4\3\2\62\61\3\2\2\2\62\63\3\2\2\2\63\64\3\2"+
		"\2\2\64\65\7\b\2\2\65\7\3\2\2\2\668\5\22\n\2\67\66\3\2\2\289\3\2\2\29"+
		"\67\3\2\2\29:\3\2\2\2:\t\3\2\2\2;?\5\f\7\2<?\5\16\b\2=?\5\20\t\2>;\3\2"+
		"\2\2><\3\2\2\2>=\3\2\2\2?\13\3\2\2\2@B\7\23\2\2AC\7\24\2\2BA\3\2\2\2B"+
		"C\3\2\2\2C\r\3\2\2\2DE\7\17\2\2EF\7\23\2\2F\17\3\2\2\2GH\7\20\2\2HI\7"+
		"\23\2\2I\21\3\2\2\2JK\7\23\2\2KL\7\t\2\2LM\5\24\13\2MN\7\n\2\2N\23\3\2"+
		"\2\2OS\5\34\17\2PS\5\32\16\2QS\5\36\20\2RO\3\2\2\2RP\3\2\2\2RQ\3\2\2\2"+
		"S\25\3\2\2\2TV\5\30\r\2UT\3\2\2\2VW\3\2\2\2WU\3\2\2\2WX\3\2\2\2X\27\3"+
		"\2\2\2YZ\5\32\16\2Zb\7\r\2\2[c\5\34\17\2\\^\5\36\20\2]\\\3\2\2\2^_\3\2"+
		"\2\2_]\3\2\2\2_`\3\2\2\2`c\3\2\2\2ac\5\32\16\2b[\3\2\2\2b]\3\2\2\2ba\3"+
		"\2\2\2cd\3\2\2\2de\7\n\2\2e\31\3\2\2\2fg\7\16\2\2gh\7\23\2\2h\33\3\2\2"+
		"\2im\7\5\2\2jm\7\4\2\2km\7\6\2\2li\3\2\2\2lj\3\2\2\2lk\3\2\2\2m\35\3\2"+
		"\2\2nq\5\32\16\2oq\5\34\17\2pn\3\2\2\2po\3\2\2\2qr\3\2\2\2rx\7\3\2\2s"+
		"v\5\32\16\2tv\5\34\17\2us\3\2\2\2ut\3\2\2\2vy\3\2\2\2wy\5\36\20\2xu\3"+
		"\2\2\2xw\3\2\2\2y\37\3\2\2\2\22\"$*/\629>BRW_blpux";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}