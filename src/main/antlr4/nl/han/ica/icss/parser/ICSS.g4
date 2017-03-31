grammar ICSS;

stylesheet              : (constants | styleRules)*;

styleRules              : styleRule+;
styleRule               : selector LBRACE declarations? styleRules? RBRACE;
declarations            : declaration+;
selector                : (selectorTag | selectorId | selectorClass);
selectorTag             : ID DEC?; //dec is needed for, forexample h1
selectorId              : HASHTAG ID;
selectorClass           : DOT ID;
declaration             : ID COLON value SEMI;
value                   : constantValue | constantName | operation;
constants               : constant+;
constant                : constantName ASSIGN (constantValue | operation+ | constantName) SEMI;
constantName            : DOLLARSIGN ID; // constants cant be with a number;o
constantValue           : PIXELLITERAL #pixelLiteral
                            | COLORLITERAL #colorLiteral
                            | PERCENTAGELITERAL #percentageLiteral;
operation               : (constantName | constantValue) Operator ((constantName | constantValue) | (operation));


Operator                : ADD | SUB; // MUST BE ABOVE ID!!
COLORLITERAL            : HASHTAG HEX HEX HEX HEX HEX HEX;
PIXELLITERAL            : DEC PIXEL;
PERCENTAGELITERAL       : DEC PERCENT;

// SEPERATORS
LBRACE                  : '{';
RBRACE                  : '}';

// OPERATORS
COLON                   : ':';
SEMI                    : ';';
ADD                     : '+';
SUB                     : '-';
ASSIGN                  : '=';

// PREFIXES
DOLLARSIGN              : '$'; // Constant
HASHTAG                 : '#'; // ID
DOT                     : '.'; // Class

// SUFFIXES
PIXEL                   : 'px';
PERCENT                 : '%';

//
ID                      : [a-zA-Z\-_]+; // must be above hex
DEC                     : [0-9]+ ;
HEX                     : [a-fA-F0-9];
//LETTER                  : LOWERCASELETTER
//                            | UPPERCASELETTER;
//LOWERCASELETTER         : [a-z];
//UPPERCASELETTER         : [A-Z];

WS : [ \t\r\n]+ -> skip ;



// GLOBAL TODO
// todo: stylesheet is multivoud kan ook enkelvoud zijn
// todo: checking on innerconstraint
// todo: assignment opengeklapt schijnt bug te zijn!
// todo: assignment decleration after usage <- works?
// todo: literals/assignments in operations dont work when using innerinner