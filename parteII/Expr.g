grammar Expr;

start
	:	{ System.out.println(" start -> expr "); }
		expr ENDOF
	;

expr
	:	{ System.out.println(" expr -> term exprp "); }
		term	exprp		
	;
	
exprp
	:	{ System.out.println(" exprp -> + term exprp "); }
		PLUS	term	exprp
	|	{ System.out.println(" exprp -> - term exprp "); }
		MINUS	term	exprp
	|	{ System.out.println(" exprp -> epsilon "); }
	;

term
	:	{ System.out.println(" term -> fact termp "); }
		fact	termp		
	;
	
termp
	:	{ System.out.println(" termp -> * fact termp"); }
		MULT	fact	termp	
	|	{ System.out.println(" termp -> / fact termp"); }
		DIV	fact	termp	
	|				{ System.out.println(" termp -> epsilon "); }
	;
	
fact
	:	{ System.out.println(" fact -> ( expr ) "); }
		LPAR	expr	RPAR
	|	ID			{ System.out.println(" fact -> ID "); }
	|	NUM			{ System.out.println(" fact -> NUM "); }
	;
	

PLUS
	:	'+'
	;
	
MINUS
	:	'-'
	;
	
MULT
	:	'*'
	;
	
DIV
	:	'/'
	;
	
LPAR
	:	'('
	;
	
RPAR
	:	')'
	;

NUM
	:	('0'..'9')+
	;

ID
	:	('a'..'z' | 'A'..'Z' | '_') ('a'..'z' | 'A'..'Z' | '0'..'9' | '_')*
	;
	
WS
	:	(' ' | '\t' | '\n' | '\r')	{ $channel = HIDDEN; }
	;
	
ENDOF	:	'$' | EOF;
