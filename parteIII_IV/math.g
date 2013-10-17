////// METTERE A POSTO LA BIPUSH PER GLI INT CHE NON HA SENSO!!!!


grammar math;

@members	{
	private SymbleTable st = new SymbleTable();
	private Code code = new Code();
	private int offset = 0;
}

start 
	: (statement)* EOF
			{	System.out.println(code.toJasmin());	}
	;

statement
@init{
	int lstart = code.getLabel();
}
	:	declaration
	|	assignment
	|	'?'
		{
			code.emitLabel(lstart);
		}
		'{' texpr=expr '}'
		{
			if(texpr!=Type.BOOL) throw new RuntimeException(" l espressione da valutare non e booleana");
		}
		'=>' ( whilestatement [lstart] | ifstatement)
	|	forstatement
	;
	

declaration
@init {
	// per dichiarare variabili locali al metodo
	java.util.Stack<Type> ltypes = new java.util.Stack<Type>();
	java.util.Stack<String> lids = new java.util.Stack<String>();
	Type t=null;
}
	:	'{' ('int' { t=Type.INT; } | 'bool' { t=Type.BOOL; } )
			{	ltypes.push(t);	}
		
		(','('int' { t=Type.INT; } | 'bool' { t=Type.BOOL; } )
			{	ltypes.push(t);	}
		)* '}' '=>'
		'{' id1=ID {	lids.push($id1.text);	} (',' id2=ID  {	lids.push($id2.text);	} )* '}'
			{
				if(lids.size()==ltypes.size())
					while(!lids.empty())
						st.insert(lids.pop(),ltypes.pop(),offset++);
				else
					throw new RuntimeException("Nell'assegnazione il numero di variabili non corrisponde al numero dei tipi");
			}
	;
	
assignment
@init{
	java.util.Stack<Type>ltypes=new java.util.Stack<Type>();	
	java.util.Stack<String>lids=new java.util.Stack<String>();
}
	:	'{'
		texpr=expr
		{
			ltypes.push(texpr);
		}
		(','
		texpr=expr
		{
			ltypes.push(texpr);
		}
		)* '}' '=>'
		'{' id1=printorid
		{
			lids.push(id1);
		}
		(','
		id1=printorid
		{
			lids.push(id1);
		}
		)* '}'
		{
			if(lids.size()!=ltypes.size())
				throw new RuntimeException ("numero di identificatori non corrisponde al numero di valori nella dichiarazione");
			else
				while(!lids.empty()) {
					String id=lids.pop();
					Type t=ltypes.pop();
					if(id.equals("print")) {
						if(t==Type.INT)	code.emit(Opcode.IPRINT);
						else			code.emit(Opcode.BPRINT);
					} else {
						Type type = st.lookupType(id);
						int offset = st.lookupAddress(id);
						if(t!=type)
							throw new RuntimeException ("il tipo di "+id+" era "+type+" e non "+t);
						if(offset==0)
							code.emit(Opcode.istore_0);
						else if(offset==1)
							code.emit(Opcode.istore_1);
						else if(offset==2)
							code.emit(Opcode.istore_2);
						else if(offset==3)
							code.emit(Opcode.istore_3);
						else	code.emit(Opcode.istore,offset);
					}
						
				}
					
		}
	;
	
printorid returns [String id]
	:	id1=ID
		{
			$id=$id1.text;
		}
	|	'print'
		{
			$id="print";
		}
	;

whilestatement [int lstart]
	:	'*' '{' (statement)* '}'
	;
	
forstatement 
@init{
	int a,z;
	String id;
	int offset;
	int lstart=code.getLabel();
	int lnext=code.getLabel();
}
	:
		'#' '{' id1=ID ','
		'[' int1=INT {a=Integer.parseInt($int1.text); } '...' int2=INT {z=Integer.parseInt($int2.text); } ']'
		'}' '=>' '#'
		{
			st.insert(id,Type.INT,a);
			offset=st.lookupAddress(id);
			code.emitLabel(lstart);
			code.emit(Opcode.bipush,z);
			code.emit(Opcode.iload,a);
			code.emit(Opcode.if_icmpgt,lnext);
			
		}
		'{' (statement)* '}'
		{	
			
			code.emit(Opcode.iconst_1);
			code.emit(Opcode.iload,offset);
			code.emit(Opcode.iadd);
			code.emit(Opcode.istore,offset);
			code.emit(Opcode.goto_,lstart);
			code.emitLabel(lnext);
		}
		
	;

ifstatement
@init{
	int lfalse = code.getLabel();
	int lnext = lfalse;
}
	:	'{'
		{
			code.emit(Opcode.ifeq,lfalse);
		}
		(statement)* '}' (':' '{'
		{
			lnext=code.getLabel();
			code.emit(Opcode.goto_,lnext);
			code.emitLabel(lfalse);
		}
		(statement)* '}')?
		{
			code.emitLabel(lnext);
		}
	;


andExpr returns [Type type]
@init {
	int lfalse = code.newLabel();	
}
	:	t1=relExpr { $type=t1;} (op='and' 	{	code.emit(Opcode.ifeq,lfalse);	}
					
					t2=relExpr
					{
						if(!(t1==Type.BOOL && t2==Type.BOOL))
							throw new RuntimeException("Gli operandi di or non sono entrambi booleani");
					})*
		{
			if ($op!=null) {
				code.emit(Opcode.ifeq,lfalse);
				code.emit(Opcode.iconst_1);
				int label_next = code.newLabel();
				code.emit(Opcode.goto_,label_next);
				code.emitLabel(lfalse);
				code.emit(Opcode.iconst_0);
				code.emitLabel(label_next);
			}
		}
	;
expr returns [Type type]
@init {
	int label_true = code.newLabel();
}
	:	t1=andExpr 		{ $type=t1; }
				(op='or'
					{
						code.emit(Opcode.ifne,label_true);
					}
					t2=andExpr
					{
						if(!(t1==Type.BOOL && t2==Type.BOOL))
							throw new RuntimeException("Gli operandi di or non sono entrambi booleani");
					}
					)*
		{
			if ($op!=null) {
				int lfalse=code.newLabel();
				code.emit(Opcode.ifeq,lfalse);
				code.emitLabel(label_true);
				code.emit(Opcode.iconst_1);
				int label_next = code.newLabel();
				code.emit(Opcode.goto_,label_next);
				code.emitLabel(lfalse);
				code.emit(Opcode.iconst_0);
				code.emitLabel(label_next);
			}
		}
	;




relExpr returns [Type type]
	:	t1=addExpr { $type=t1; }
		(	'='  t2=addExpr
			{
				if(t1==t2) $type=t1;
				else	throw new RuntimeException("gli operandi del confronto di uguaglianza hanno tipi diversi");
				int lfalse = code.newLabel();
				code.emit(Opcode.if_icmpne,lfalse);
				code.emit(Opcode.iconst_1);
				int lnext=code.newLabel();
				code.emit(Opcode.goto_,lnext);
				code.emitLabel(lfalse);
				code.emit(Opcode.iconst_0);
				code.emitLabel(lnext);
				$type=Type.BOOL;
			}
		|	'!=' t2=addExpr
			{
				if(t1==t2)	$type=t1;
				else	throw new RuntimeException("gli operandi del confronto di diversita' hanno tipi diversi");
				int lfalse = code.newLabel();
				code.emit(Opcode.if_icmpeq,lfalse);
				code.emit(Opcode.iconst_1);
				int lnext=code.newLabel();
				code.emit(Opcode.goto_,lnext);
				code.emitLabel(lfalse);
				code.emit(Opcode.iconst_0);
				code.emitLabel(lnext);
				$type=Type.BOOL;
			}
		|	'<=' t2=addExpr
			{
				if(t1==t2 && t1==Type.INT)		$type=t1;
				else						throw new RuntimeException("gli operandi del confronto di minore uguale non sono entrambi interi");
				int lfalse = code.newLabel();
				code.emit(Opcode.if_icmpgt,lfalse);
				code.emit(Opcode.iconst_1);
				int lnext=code.newLabel();
				code.emit(Opcode.goto_,lnext);
				code.emitLabel(lfalse);
				code.emit(Opcode.iconst_0);
				code.emitLabel(lnext);
				$type=Type.BOOL;
			}
		|	'>=' t2=addExpr
			{
				if(t1==t2 && t1==Type.INT)		$type=t1;
				else						throw new RuntimeException("gli operandi del confronto di minore uguale non sono entrambi interi");
				int lfalse = code.newLabel();
				code.emit(Opcode.if_icmplt,lfalse);
				code.emit(Opcode.iconst_1);
				int lnext=code.newLabel();
				code.emit(Opcode.goto_,lnext);
				code.emitLabel(lfalse);
				code.emit(Opcode.iconst_0);
				code.emitLabel(lnext);
				$type=Type.BOOL;
			}
		|	'<'  t2=addExpr
			{
				if(t1==t2 && t1==Type.INT)		$type=t1;
				else						throw new RuntimeException("gli operandi del confronto di minore uguale non sono entrambi interi");
				int lfalse = code.newLabel();
				code.emit(Opcode.if_icmpge,lfalse);
				code.emit(Opcode.iconst_1);
				int lnext=code.newLabel();
				code.emit(Opcode.goto_,lnext);
				code.emitLabel(lfalse);
				code.emit(Opcode.iconst_0);
				code.emitLabel(lnext);
				$type=Type.BOOL;
			}
		|	'>'  t2=addExpr
			{
				if(t1==t2 && t1==Type.INT)	$type=t1;
				else					throw new RuntimeException("gli operandi del confronto di minore uguale non sono entrambi interi");
				int lfalse = code.newLabel();
				code.emit(Opcode.if_icmple,lfalse);
				code.emit(Opcode.iconst_1);
				int lnext=code.newLabel();
				code.emit(Opcode.goto_,lnext);
				code.emitLabel(lfalse);
				code.emit(Opcode.iconst_0);
				code.emitLabel(lnext);
				$type=Type.BOOL;
			}
		)?
	;
	
addExpr returns [Type type]
	:	t1=multExpr
			{
				$type=t1;
				//if(t1==Type.INT)		$type=Type.INT;
				//else				throw new RuntimeException("[addexpr] L'operatore non e' intero bensi"+t1);
			}
		(	'+' t2=multExpr
			{	
				if(t2!=Type.INT || $type!=Type.INT ) 		throw new RuntimeException("L'operatore della somma non e' intero bensi"+t1+t2);
				code.emit(Opcode.iadd);
			}
		|	'-' t2=multExpr
			{	
				if(t2!=Type.INT || $type!=Type.INT ) throw new RuntimeException("L'operatore della sottrazione non e' intero bensi"+t1+t2);
				code.emit(Opcode.iadd);
			}
		)*
	;
	
multExpr returns [Type type]
	:	t1=unExpr
			{
				$type=t1;
				//if(t1==Type.INT)		$type=Type.INT;
				//else				throw new RuntimeException("[addexpr] L'operatore non e' intero bensi"+t1);
				
			}
		(	'*' t2=unExpr
			{	
				if(t2!=Type.INT || $type!=Type.INT ) throw new RuntimeException("L'operatore della moltiplicazione non e' intero bensi"+t1);
				code.emit(Opcode.imul);
			}
		|	'/' t2=unExpr
			{	
				if(t2!=Type.INT || $type!=Type.INT ) throw new RuntimeException("L'operatore della divisione non e' intero bensi"+t1);
				code.emit(Opcode.idiv);
			}
		)*
	;
	
unExpr returns [Type type]
	:	'+'   t1=unExpr
			{
				if (t1==Type.INT) $type=t1;
				else	throw new RuntimeException("L'operando unario del + non e' intero bensi"+t1);
			}
	|	'-'   t1=unExpr
			{	
			
				code.emit(Opcode.ineg);
				if (t1==Type.INT) $type=t1;
				else	throw new RuntimeException("L'operando unario del - non e' intero bensi"+t1);
			}
	|	'not' t1=unExpr
		{
			code.emit(Opcode.ineg);
			if (t1==Type.BOOL) $type=t1; 
			else	throw new RuntimeException("L'operando unario del not non e' booleano bensi"+t1);
			
			int lfalse=code.newLabel();
			code.emit(Opcode.ifne, lfalse);
			code.emit(Opcode.iconst_1);
			int lnext = code.newLabel();
			code.emit(Opcode.goto_,lnext);
			code.emitLabel(lfalse);
			code.emit(Opcode.iconst_0);
			code.emitLabel(lnext);
		}
	|	t1=primary
		{
			$type=t1;
		}
	;
	
primary returns [Type type]
	:	'(' t=expr { $type=t; }')'
	|	INT
			{
				$type=Type.INT;
				int v = Integer.parseInt($INT.text);
				boolean x = false;
				switch(v)
				{
					case -1:	
							x=true;
							break;
					case 0:	
							x=true;
							break;
					case 2:	
							x=true;
							break;
					case 3:	
							x=true;
							break;
					case 4:	
							x=true;
							break;
					case 5:	
							x=true;
							break;
					default:	
							x=true;
							break;
				}
				if( v < 128 && !x)	code.emit(Opcode.bipush,v);
				else if(v<32768 && !x)	code.emit(Opcode.bipush,v);
				else if(!x)			code.emit(Opcode.ldc,v);
			}
					
	|	ID
			{	
				$type=st.lookupType($ID.text);
				int offset = st.lookupAddress($ID.text);
				switch(offset)
				{
					case 0:	code.emit(Opcode.iload_0);
							break;
					case 1:	code.emit(Opcode.iload_1);
							break;
					case 2:	code.emit(Opcode.iload_2);
							break;
					case 3:	code.emit(Opcode.iload_3);
							break;
					default:	code.emit(Opcode.iload,offset);
							break;
				}
			}
	|	'true'
			{
				code.emit(Opcode.iconst_1);
				$type=Type.BOOL;
			}
				
	|	'false'
			{ 
				code.emit(Opcode.iconst_0);
				$type=Type.BOOL;
			}
	;
	
ID  :	('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'0'..'9'|'_')*
    ;

INT :	'0'..'9'+
    ;

COMMENT
    :   '//' ~('\n'|'\r')* '\r'? '\n' {$channel=HIDDEN;}
    |   '/*' ( options {greedy=false;} : . )* '*/' {$channel=HIDDEN;}
    ;

WS  :   ( ' '
        | '\t'
        | '\r'
        | '\n'
        ) {$channel=HIDDEN;}
    ;

