grammar EvaluatorEBNF;

start	:	
		{ System.out.println("start -> expr EOF "); }
		val=expr
			{ System.out.println("Valore espressione: "+val); }
		Endoffile;

expr	returns [int val]
	:	{ System.out.println("expr -> term [ +term | - term ]*"); }
		t0=term			{ $val=t0; }
		(
			'+' t=term	{ $val+=t; }
	 	| 	'-' t=term	{ $val-=t; }
	 	)*;

term	returns [int val]
	:	{ System.out.println("term -> fact [ *fact | /fact ]*"); }
		f0=fact			{ $val=f0; }
		(
			'*' f=fact	{ $val=$val*f; }
		 | 	'/' f=fact	{ $val=$val/f; }
		)*;

fact	returns	[int val]
	:	
		{ System.out.println("fact -> ( expr ) | NUM | ID "); }
	'(' e=expr ')'	{ $val=e; } 
	| 	INT		{ $val=Integer.parseInt($INT.text); }
	|	ID		{ $val=0; };
	
Endoffile
	:	'$' | EOF;

ID  :	('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'0'..'9'|'_')*
    ;

INT :	'0'..'9'+
    ;

WS  :   ( ' '
        | '\t'
        | '\r'
        | '\n'
        ) {$channel=HIDDEN;};
   

