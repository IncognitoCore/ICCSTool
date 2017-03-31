// Generated from nl/han/ica/icss/parser/ICSS.g4 by ANTLR 4.3
package nl.han.ica.icss.parser;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ICSSLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		Operator=1, COLORLITERAL=2, PIXELLITERAL=3, PERCENTAGELITERAL=4, LBRACE=5, 
		RBRACE=6, COLON=7, SEMI=8, ADD=9, SUB=10, ASSIGN=11, DOLLARSIGN=12, HASHTAG=13, 
		DOT=14, PIXEL=15, PERCENT=16, ID=17, DEC=18, HEX=19, WS=20;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"'\\u0000'", "'\\u0001'", "'\\u0002'", "'\\u0003'", "'\\u0004'", "'\\u0005'", 
		"'\\u0006'", "'\\u0007'", "'\b'", "'\t'", "'\n'", "'\\u000B'", "'\f'", 
		"'\r'", "'\\u000E'", "'\\u000F'", "'\\u0010'", "'\\u0011'", "'\\u0012'", 
		"'\\u0013'", "'\\u0014'"
	};
	public static final String[] ruleNames = {
		"Operator", "COLORLITERAL", "PIXELLITERAL", "PERCENTAGELITERAL", "LBRACE", 
		"RBRACE", "COLON", "SEMI", "ADD", "SUB", "ASSIGN", "DOLLARSIGN", "HASHTAG", 
		"DOT", "PIXEL", "PERCENT", "ID", "DEC", "HEX", "WS"
	};


	public ICSSLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "ICSS.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\26i\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\3\2\3\2\5\2.\n\2\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\4\3\4\3\4\3\5\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n"+
		"\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\20\3\21"+
		"\3\21\3\22\6\22X\n\22\r\22\16\22Y\3\23\6\23]\n\23\r\23\16\23^\3\24\3\24"+
		"\3\25\6\25d\n\25\r\25\16\25e\3\25\3\25\2\2\26\3\3\5\4\7\5\t\6\13\7\r\b"+
		"\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26"+
		"\3\2\6\6\2//C\\aac|\3\2\62;\5\2\62;CHch\5\2\13\f\17\17\"\"l\2\3\3\2\2"+
		"\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3"+
		"\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2"+
		"\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2"+
		"\2\2\2\'\3\2\2\2\2)\3\2\2\2\3-\3\2\2\2\5/\3\2\2\2\7\67\3\2\2\2\t:\3\2"+
		"\2\2\13=\3\2\2\2\r?\3\2\2\2\17A\3\2\2\2\21C\3\2\2\2\23E\3\2\2\2\25G\3"+
		"\2\2\2\27I\3\2\2\2\31K\3\2\2\2\33M\3\2\2\2\35O\3\2\2\2\37Q\3\2\2\2!T\3"+
		"\2\2\2#W\3\2\2\2%\\\3\2\2\2\'`\3\2\2\2)c\3\2\2\2+.\5\23\n\2,.\5\25\13"+
		"\2-+\3\2\2\2-,\3\2\2\2.\4\3\2\2\2/\60\5\33\16\2\60\61\5\'\24\2\61\62\5"+
		"\'\24\2\62\63\5\'\24\2\63\64\5\'\24\2\64\65\5\'\24\2\65\66\5\'\24\2\66"+
		"\6\3\2\2\2\678\5%\23\289\5\37\20\29\b\3\2\2\2:;\5%\23\2;<\5!\21\2<\n\3"+
		"\2\2\2=>\7}\2\2>\f\3\2\2\2?@\7\177\2\2@\16\3\2\2\2AB\7<\2\2B\20\3\2\2"+
		"\2CD\7=\2\2D\22\3\2\2\2EF\7-\2\2F\24\3\2\2\2GH\7/\2\2H\26\3\2\2\2IJ\7"+
		"?\2\2J\30\3\2\2\2KL\7&\2\2L\32\3\2\2\2MN\7%\2\2N\34\3\2\2\2OP\7\60\2\2"+
		"P\36\3\2\2\2QR\7r\2\2RS\7z\2\2S \3\2\2\2TU\7\'\2\2U\"\3\2\2\2VX\t\2\2"+
		"\2WV\3\2\2\2XY\3\2\2\2YW\3\2\2\2YZ\3\2\2\2Z$\3\2\2\2[]\t\3\2\2\\[\3\2"+
		"\2\2]^\3\2\2\2^\\\3\2\2\2^_\3\2\2\2_&\3\2\2\2`a\t\4\2\2a(\3\2\2\2bd\t"+
		"\5\2\2cb\3\2\2\2de\3\2\2\2ec\3\2\2\2ef\3\2\2\2fg\3\2\2\2gh\b\25\2\2h*"+
		"\3\2\2\2\7\2-Y^e\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}