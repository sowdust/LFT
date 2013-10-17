grammar ExprEvaluator;


start	:	{
			System.out.println("Valore espressione: "+vexpr);
		} 
		vexpr=expr	
		EOFF
	;

expr returns [int val]
	:	vterm=term vexprp=exprp[vterm]
		{
			System.out.println("expr -> term exprp");

			$val=vexprp;
		}
	;

exprp[int i] returns [int val]
	:	'+' vterm=term vexprp=exprp[vterm+$i]
		{
			System.out.println("exprp -> + term exprp");
			$val=vexprp;
		}
	|	'-' vterm=term vexprp=exprp[$i-vterm]
		{
			System.out.println("exprp -> - term exprp");
			$val=vexprp;
					}
	|	{ System.out.println("exprp -> epsilon"); $val=$i; }
	;

term returns[int val]
	:	vfact=fact	vtermp=termp[vfact]
		{
			System.out.println("term -> fact termp");
			$val=vtermp;
			
		}
	;

termp[int i] returns[int val]
	:	'*' vfact=fact vtermp=termp[$i * vfact]
		{
			System.out.println("termp -> * fact termp");
			$val=vtermp;
						
		}
	|	'/'	vfact=fact vtermp=termp[$i / vfact]
		{
			System.out.println("termp -> / fact termp");
			$val=vtermp;
			
		}
	|	{
			System.out.println("termp -> epsilon");
			$val=$i;
			
		}
	;
	
fact returns [int val]
	:	'(' vexpr=expr ')'
		{
			System.out.println("fact -> ( expr )");
			$val=vexpr;
			
		}
	|	INT
		{
			
			System.out.println("fact -> NUM");
			$val=Integer.parseInt($INT.text);
		}
	|	ID
		{
			$val=0;
			System.out.println("fact -> ID");
		}
	;


ID  :	('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'0'..'9'|'_')*
    ;

INT :	'0'..'9'+
    ;
   
EOFF	:	'$' | EOF;

WS  :   ( ' '
        | '\t'
        | '\r'
        | '\n'
        ) {$channel=HIDDEN;}
    ;

