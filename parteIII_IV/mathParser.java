// $ANTLR 3.5 math.g 2013-07-22 12:08:03

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class mathParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "COMMENT", "ID", "INT", "WS", 
		"'!='", "'#'", "'('", "')'", "'*'", "'+'", "','", "'-'", "'...'", "'/'", 
		"':'", "'<'", "'<='", "'='", "'=>'", "'>'", "'>='", "'?'", "'['", "']'", 
		"'and'", "'bool'", "'false'", "'int'", "'not'", "'or'", "'print'", "'true'", 
		"'{'", "'}'"
	};
	public static final int EOF=-1;
	public static final int T__8=8;
	public static final int T__9=9;
	public static final int T__10=10;
	public static final int T__11=11;
	public static final int T__12=12;
	public static final int T__13=13;
	public static final int T__14=14;
	public static final int T__15=15;
	public static final int T__16=16;
	public static final int T__17=17;
	public static final int T__18=18;
	public static final int T__19=19;
	public static final int T__20=20;
	public static final int T__21=21;
	public static final int T__22=22;
	public static final int T__23=23;
	public static final int T__24=24;
	public static final int T__25=25;
	public static final int T__26=26;
	public static final int T__27=27;
	public static final int T__28=28;
	public static final int T__29=29;
	public static final int T__30=30;
	public static final int T__31=31;
	public static final int T__32=32;
	public static final int T__33=33;
	public static final int T__34=34;
	public static final int T__35=35;
	public static final int T__36=36;
	public static final int T__37=37;
	public static final int COMMENT=4;
	public static final int ID=5;
	public static final int INT=6;
	public static final int WS=7;

	// delegates
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public mathParser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}
	public mathParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);
	}

	@Override public String[] getTokenNames() { return mathParser.tokenNames; }
	@Override public String getGrammarFileName() { return "math.g"; }


		private SymbleTable st = new SymbleTable();
		private Code code = new Code();
		private int offset = 0;



	// $ANTLR start "start"
	// math.g:12:1: start : ( statement )* EOF ;
	public final void start() throws RecognitionException {
		try {
			// math.g:13:2: ( ( statement )* EOF )
			// math.g:13:4: ( statement )* EOF
			{
			// math.g:13:4: ( statement )*
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( (LA1_0==9||LA1_0==25||LA1_0==36) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// math.g:13:5: statement
					{
					pushFollow(FOLLOW_statement_in_start22);
					statement();
					state._fsp--;

					}
					break;

				default :
					break loop1;
				}
			}

			match(input,EOF,FOLLOW_EOF_in_start26); 
				System.out.println(code.toJasmin());	
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "start"



	// $ANTLR start "statement"
	// math.g:17:1: statement : ( declaration | assignment | '?' '{' texpr= expr '}' '=>' ( whilestatement[lstart] | ifstatement ) | forstatement );
	public final void statement() throws RecognitionException {
		Type texpr =null;


			int lstart = code.getLabel();

		try {
			// math.g:21:2: ( declaration | assignment | '?' '{' texpr= expr '}' '=>' ( whilestatement[lstart] | ifstatement ) | forstatement )
			int alt3=4;
			switch ( input.LA(1) ) {
			case 36:
				{
				int LA3_1 = input.LA(2);
				if ( (LA3_1==29||LA3_1==31) ) {
					alt3=1;
				}
				else if ( ((LA3_1 >= ID && LA3_1 <= INT)||LA3_1==10||LA3_1==13||LA3_1==15||LA3_1==30||LA3_1==32||LA3_1==35) ) {
					alt3=2;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 3, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case 25:
				{
				alt3=3;
				}
				break;
			case 9:
				{
				alt3=4;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 3, 0, input);
				throw nvae;
			}
			switch (alt3) {
				case 1 :
					// math.g:21:4: declaration
					{
					pushFollow(FOLLOW_declaration_in_statement46);
					declaration();
					state._fsp--;

					}
					break;
				case 2 :
					// math.g:22:4: assignment
					{
					pushFollow(FOLLOW_assignment_in_statement51);
					assignment();
					state._fsp--;

					}
					break;
				case 3 :
					// math.g:23:4: '?' '{' texpr= expr '}' '=>' ( whilestatement[lstart] | ifstatement )
					{
					match(input,25,FOLLOW_25_in_statement56); 

								code.emitLabel(lstart);
							
					match(input,36,FOLLOW_36_in_statement64); 
					pushFollow(FOLLOW_expr_in_statement68);
					texpr=expr();
					state._fsp--;

					match(input,37,FOLLOW_37_in_statement70); 

								if(texpr!=Type.BOOL) throw new RuntimeException(" l espressione da valutare non e booleana");
							
					match(input,22,FOLLOW_22_in_statement78); 
					// math.g:31:8: ( whilestatement[lstart] | ifstatement )
					int alt2=2;
					int LA2_0 = input.LA(1);
					if ( (LA2_0==12) ) {
						alt2=1;
					}
					else if ( (LA2_0==36) ) {
						alt2=2;
					}

					else {
						NoViableAltException nvae =
							new NoViableAltException("", 2, 0, input);
						throw nvae;
					}

					switch (alt2) {
						case 1 :
							// math.g:31:10: whilestatement[lstart]
							{
							pushFollow(FOLLOW_whilestatement_in_statement82);
							whilestatement(lstart);
							state._fsp--;

							}
							break;
						case 2 :
							// math.g:31:36: ifstatement
							{
							pushFollow(FOLLOW_ifstatement_in_statement88);
							ifstatement();
							state._fsp--;

							}
							break;

					}

					}
					break;
				case 4 :
					// math.g:32:4: forstatement
					{
					pushFollow(FOLLOW_forstatement_in_statement94);
					forstatement();
					state._fsp--;

					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "statement"



	// $ANTLR start "declaration"
	// math.g:36:1: declaration : '{' ( 'int' | 'bool' ) ( ',' ( 'int' | 'bool' ) )* '}' '=>' '{' id1= ID ( ',' id2= ID )* '}' ;
	public final void declaration() throws RecognitionException {
		Token id1=null;
		Token id2=null;


			// per dichiarare variabili locali al metodo
			java.util.Stack<Type> ltypes = new java.util.Stack<Type>();
			java.util.Stack<String> lids = new java.util.Stack<String>();
			Type t=null;

		try {
			// math.g:43:2: ( '{' ( 'int' | 'bool' ) ( ',' ( 'int' | 'bool' ) )* '}' '=>' '{' id1= ID ( ',' id2= ID )* '}' )
			// math.g:43:4: '{' ( 'int' | 'bool' ) ( ',' ( 'int' | 'bool' ) )* '}' '=>' '{' id1= ID ( ',' id2= ID )* '}'
			{
			match(input,36,FOLLOW_36_in_declaration112); 
			// math.g:43:8: ( 'int' | 'bool' )
			int alt4=2;
			int LA4_0 = input.LA(1);
			if ( (LA4_0==31) ) {
				alt4=1;
			}
			else if ( (LA4_0==29) ) {
				alt4=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 4, 0, input);
				throw nvae;
			}

			switch (alt4) {
				case 1 :
					// math.g:43:9: 'int'
					{
					match(input,31,FOLLOW_31_in_declaration115); 
					 t=Type.INT; 
					}
					break;
				case 2 :
					// math.g:43:33: 'bool'
					{
					match(input,29,FOLLOW_29_in_declaration121); 
					 t=Type.BOOL; 
					}
					break;

			}

				ltypes.push(t);	
			// math.g:46:3: ( ',' ( 'int' | 'bool' ) )*
			loop6:
			while (true) {
				int alt6=2;
				int LA6_0 = input.LA(1);
				if ( (LA6_0==14) ) {
					alt6=1;
				}

				switch (alt6) {
				case 1 :
					// math.g:46:4: ',' ( 'int' | 'bool' )
					{
					match(input,14,FOLLOW_14_in_declaration138); 
					// math.g:46:7: ( 'int' | 'bool' )
					int alt5=2;
					int LA5_0 = input.LA(1);
					if ( (LA5_0==31) ) {
						alt5=1;
					}
					else if ( (LA5_0==29) ) {
						alt5=2;
					}

					else {
						NoViableAltException nvae =
							new NoViableAltException("", 5, 0, input);
						throw nvae;
					}

					switch (alt5) {
						case 1 :
							// math.g:46:8: 'int'
							{
							match(input,31,FOLLOW_31_in_declaration140); 
							 t=Type.INT; 
							}
							break;
						case 2 :
							// math.g:46:32: 'bool'
							{
							match(input,29,FOLLOW_29_in_declaration146); 
							 t=Type.BOOL; 
							}
							break;

					}

						ltypes.push(t);	
					}
					break;

				default :
					break loop6;
				}
			}

			match(input,37,FOLLOW_37_in_declaration162); 
			match(input,22,FOLLOW_22_in_declaration164); 
			match(input,36,FOLLOW_36_in_declaration168); 
			id1=(Token)match(input,ID,FOLLOW_ID_in_declaration172); 
				lids.push((id1!=null?id1.getText():null));	
			// math.g:49:40: ( ',' id2= ID )*
			loop7:
			while (true) {
				int alt7=2;
				int LA7_0 = input.LA(1);
				if ( (LA7_0==14) ) {
					alt7=1;
				}

				switch (alt7) {
				case 1 :
					// math.g:49:41: ',' id2= ID
					{
					match(input,14,FOLLOW_14_in_declaration177); 
					id2=(Token)match(input,ID,FOLLOW_ID_in_declaration181); 
						lids.push((id2!=null?id2.getText():null));	
					}
					break;

				default :
					break loop7;
				}
			}

			match(input,37,FOLLOW_37_in_declaration189); 

							if(lids.size()==ltypes.size())
								while(!lids.empty())
									st.insert(lids.pop(),ltypes.pop(),offset++);
							else
								throw new RuntimeException("Nell'assegnazione il numero di variabili non corrisponde al numero dei tipi");
						
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "declaration"



	// $ANTLR start "assignment"
	// math.g:59:1: assignment : '{' texpr= expr ( ',' texpr= expr )* '}' '=>' '{' id1= printorid ( ',' id1= printorid )* '}' ;
	public final void assignment() throws RecognitionException {
		Type texpr =null;
		String id1 =null;


			java.util.Stack<Type>ltypes=new java.util.Stack<Type>();	
			java.util.Stack<String>lids=new java.util.Stack<String>();

		try {
			// math.g:64:2: ( '{' texpr= expr ( ',' texpr= expr )* '}' '=>' '{' id1= printorid ( ',' id1= printorid )* '}' )
			// math.g:64:4: '{' texpr= expr ( ',' texpr= expr )* '}' '=>' '{' id1= printorid ( ',' id1= printorid )* '}'
			{
			match(input,36,FOLLOW_36_in_assignment210); 
			pushFollow(FOLLOW_expr_in_assignment216);
			texpr=expr();
			state._fsp--;


						ltypes.push(texpr);
					
			// math.g:69:3: ( ',' texpr= expr )*
			loop8:
			while (true) {
				int alt8=2;
				int LA8_0 = input.LA(1);
				if ( (LA8_0==14) ) {
					alt8=1;
				}

				switch (alt8) {
				case 1 :
					// math.g:69:4: ',' texpr= expr
					{
					match(input,14,FOLLOW_14_in_assignment225); 
					pushFollow(FOLLOW_expr_in_assignment231);
					texpr=expr();
					state._fsp--;


								ltypes.push(texpr);
							
					}
					break;

				default :
					break loop8;
				}
			}

			match(input,37,FOLLOW_37_in_assignment242); 
			match(input,22,FOLLOW_22_in_assignment244); 
			match(input,36,FOLLOW_36_in_assignment248); 
			pushFollow(FOLLOW_printorid_in_assignment252);
			id1=printorid();
			state._fsp--;


						lids.push(id1);
					
			// math.g:79:3: ( ',' id1= printorid )*
			loop9:
			while (true) {
				int alt9=2;
				int LA9_0 = input.LA(1);
				if ( (LA9_0==14) ) {
					alt9=1;
				}

				switch (alt9) {
				case 1 :
					// math.g:79:4: ',' id1= printorid
					{
					match(input,14,FOLLOW_14_in_assignment261); 
					pushFollow(FOLLOW_printorid_in_assignment267);
					id1=printorid();
					state._fsp--;


								lids.push(id1);
							
					}
					break;

				default :
					break loop9;
				}
			}

			match(input,37,FOLLOW_37_in_assignment278); 

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

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "assignment"



	// $ANTLR start "printorid"
	// math.g:116:1: printorid returns [String id] : (id1= ID | 'print' );
	public final String printorid() throws RecognitionException {
		String id = null;


		Token id1=null;

		try {
			// math.g:117:2: (id1= ID | 'print' )
			int alt10=2;
			int LA10_0 = input.LA(1);
			if ( (LA10_0==ID) ) {
				alt10=1;
			}
			else if ( (LA10_0==34) ) {
				alt10=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 10, 0, input);
				throw nvae;
			}

			switch (alt10) {
				case 1 :
					// math.g:117:4: id1= ID
					{
					id1=(Token)match(input,ID,FOLLOW_ID_in_printorid300); 

								id =(id1!=null?id1.getText():null);
							
					}
					break;
				case 2 :
					// math.g:121:4: 'print'
					{
					match(input,34,FOLLOW_34_in_printorid309); 

								id ="print";
							
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return id;
	}
	// $ANTLR end "printorid"



	// $ANTLR start "whilestatement"
	// math.g:127:1: whilestatement[int lstart] : '*' '{' ( statement )* '}' ;
	public final void whilestatement(int lstart) throws RecognitionException {
		try {
			// math.g:128:2: ( '*' '{' ( statement )* '}' )
			// math.g:128:4: '*' '{' ( statement )* '}'
			{
			match(input,12,FOLLOW_12_in_whilestatement326); 
			match(input,36,FOLLOW_36_in_whilestatement328); 
			// math.g:128:12: ( statement )*
			loop11:
			while (true) {
				int alt11=2;
				int LA11_0 = input.LA(1);
				if ( (LA11_0==9||LA11_0==25||LA11_0==36) ) {
					alt11=1;
				}

				switch (alt11) {
				case 1 :
					// math.g:128:13: statement
					{
					pushFollow(FOLLOW_statement_in_whilestatement331);
					statement();
					state._fsp--;

					}
					break;

				default :
					break loop11;
				}
			}

			match(input,37,FOLLOW_37_in_whilestatement335); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "whilestatement"



	// $ANTLR start "forstatement"
	// math.g:131:1: forstatement : '#' '{' id1= ID ',' '[' int1= INT '...' int2= INT ']' '}' '=>' '#' '{' ( statement )* '}' ;
	public final void forstatement() throws RecognitionException {
		Token id1=null;
		Token int1=null;
		Token int2=null;


			int a,z;
			String id;
			int offset;
			int lstart=code.getLabel();
			int lnext=code.getLabel();

		try {
			// math.g:139:2: ( '#' '{' id1= ID ',' '[' int1= INT '...' int2= INT ']' '}' '=>' '#' '{' ( statement )* '}' )
			// math.g:140:3: '#' '{' id1= ID ',' '[' int1= INT '...' int2= INT ']' '}' '=>' '#' '{' ( statement )* '}'
			{
			match(input,9,FOLLOW_9_in_forstatement354); 
			match(input,36,FOLLOW_36_in_forstatement356); 
			id1=(Token)match(input,ID,FOLLOW_ID_in_forstatement360); 
			id=Integer.parseInt((id1!=null?id1.getText():null)); 
			match(input,14,FOLLOW_14_in_forstatement365); 
			match(input,26,FOLLOW_26_in_forstatement369); 
			int1=(Token)match(input,INT,FOLLOW_INT_in_forstatement373); 
			a=Integer.parseInt((int1!=null?int1.getText():null)); 
			match(input,16,FOLLOW_16_in_forstatement377); 
			int2=(Token)match(input,INT,FOLLOW_INT_in_forstatement381); 
			z=Integer.parseInt((int2!=null?int2.getText():null)); 
			match(input,27,FOLLOW_27_in_forstatement385); 
			match(input,37,FOLLOW_37_in_forstatement389); 
			match(input,22,FOLLOW_22_in_forstatement391); 
			match(input,9,FOLLOW_9_in_forstatement393); 

						st.insert(id,Type.INT,a);
						offset=st.lookupAddress(id);
						code.emitLabel(lstart);
						code.emit(Opcode.bipush,z);
						code.emit(Opcode.iload,a);
						code.emit(Opcode.if_icmpgt,lnext);
						
					
			match(input,36,FOLLOW_36_in_forstatement401); 
			// math.g:152:7: ( statement )*
			loop12:
			while (true) {
				int alt12=2;
				int LA12_0 = input.LA(1);
				if ( (LA12_0==9||LA12_0==25||LA12_0==36) ) {
					alt12=1;
				}

				switch (alt12) {
				case 1 :
					// math.g:152:8: statement
					{
					pushFollow(FOLLOW_statement_in_forstatement404);
					statement();
					state._fsp--;

					}
					break;

				default :
					break loop12;
				}
			}

			match(input,37,FOLLOW_37_in_forstatement408); 
				
						
						code.emit(Opcode.iconst_1);
						code.emit(Opcode.iload,offset);
						code.emit(Opcode.iadd);
						code.emit(Opcode.istore,offset);
						code.emit(Opcode.goto_,lstart);
						code.emitLabel(lnext);
					
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "forstatement"



	// $ANTLR start "ifstatement"
	// math.g:165:1: ifstatement : '{' ( statement )* '}' ( ':' '{' ( statement )* '}' )? ;
	public final void ifstatement() throws RecognitionException {

			int lfalse = code.getLabel();
			int lnext = lfalse;

		try {
			// math.g:170:2: ( '{' ( statement )* '}' ( ':' '{' ( statement )* '}' )? )
			// math.g:170:4: '{' ( statement )* '}' ( ':' '{' ( statement )* '}' )?
			{
			match(input,36,FOLLOW_36_in_ifstatement430); 

						code.emit(Opcode.ifeq,lfalse);
					
			// math.g:174:3: ( statement )*
			loop13:
			while (true) {
				int alt13=2;
				int LA13_0 = input.LA(1);
				if ( (LA13_0==9||LA13_0==25||LA13_0==36) ) {
					alt13=1;
				}

				switch (alt13) {
				case 1 :
					// math.g:174:4: statement
					{
					pushFollow(FOLLOW_statement_in_ifstatement439);
					statement();
					state._fsp--;

					}
					break;

				default :
					break loop13;
				}
			}

			match(input,37,FOLLOW_37_in_ifstatement443); 
			// math.g:174:20: ( ':' '{' ( statement )* '}' )?
			int alt15=2;
			int LA15_0 = input.LA(1);
			if ( (LA15_0==18) ) {
				alt15=1;
			}
			switch (alt15) {
				case 1 :
					// math.g:174:21: ':' '{' ( statement )* '}'
					{
					match(input,18,FOLLOW_18_in_ifstatement446); 
					match(input,36,FOLLOW_36_in_ifstatement448); 

								lnext=code.getLabel();
								code.emit(Opcode.goto_,lnext);
								code.emitLabel(lfalse);
							
					// math.g:180:3: ( statement )*
					loop14:
					while (true) {
						int alt14=2;
						int LA14_0 = input.LA(1);
						if ( (LA14_0==9||LA14_0==25||LA14_0==36) ) {
							alt14=1;
						}

						switch (alt14) {
						case 1 :
							// math.g:180:4: statement
							{
							pushFollow(FOLLOW_statement_in_ifstatement457);
							statement();
							state._fsp--;

							}
							break;

						default :
							break loop14;
						}
					}

					match(input,37,FOLLOW_37_in_ifstatement461); 
					}
					break;

			}


						code.emitLabel(lnext);
					
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ifstatement"



	// $ANTLR start "andExpr"
	// math.g:187:1: andExpr returns [Type type] : t1= relExpr (op= 'and' t2= relExpr )* ;
	public final Type andExpr() throws RecognitionException {
		Type type = null;


		Token op=null;
		Type t1 =null;
		Type t2 =null;


			int lfalse = code.newLabel();	

		try {
			// math.g:191:2: (t1= relExpr (op= 'and' t2= relExpr )* )
			// math.g:191:4: t1= relExpr (op= 'and' t2= relExpr )*
			{
			pushFollow(FOLLOW_relExpr_in_andExpr490);
			t1=relExpr();
			state._fsp--;

			 type =t1;
			// math.g:191:28: (op= 'and' t2= relExpr )*
			loop16:
			while (true) {
				int alt16=2;
				int LA16_0 = input.LA(1);
				if ( (LA16_0==28) ) {
					alt16=1;
				}

				switch (alt16) {
				case 1 :
					// math.g:191:29: op= 'and' t2= relExpr
					{
					op=(Token)match(input,28,FOLLOW_28_in_andExpr497); 
						code.emit(Opcode.ifeq,lfalse);	
					pushFollow(FOLLOW_relExpr_in_andExpr515);
					t2=relExpr();
					state._fsp--;


											if(!(t1==Type.BOOL && t2==Type.BOOL))
												throw new RuntimeException("Gli operandi di or non sono entrambi booleani");
										
					}
					break;

				default :
					break loop16;
				}
			}


						if (op!=null) {
							code.emit(Opcode.ifeq,lfalse);
							code.emit(Opcode.iconst_1);
							int label_next = code.newLabel();
							code.emit(Opcode.goto_,label_next);
							code.emitLabel(lfalse);
							code.emit(Opcode.iconst_0);
							code.emitLabel(label_next);
						}
					
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return type;
	}
	// $ANTLR end "andExpr"



	// $ANTLR start "expr"
	// math.g:210:1: expr returns [Type type] : t1= andExpr (op= 'or' t2= andExpr )* ;
	public final Type expr() throws RecognitionException {
		Type type = null;


		Token op=null;
		Type t1 =null;
		Type t2 =null;


			int label_true = code.newLabel();

		try {
			// math.g:214:2: (t1= andExpr (op= 'or' t2= andExpr )* )
			// math.g:214:4: t1= andExpr (op= 'or' t2= andExpr )*
			{
			pushFollow(FOLLOW_andExpr_in_expr549);
			t1=andExpr();
			state._fsp--;

			 type =t1; 
			// math.g:215:5: (op= 'or' t2= andExpr )*
			loop17:
			while (true) {
				int alt17=2;
				int LA17_0 = input.LA(1);
				if ( (LA17_0==33) ) {
					alt17=1;
				}

				switch (alt17) {
				case 1 :
					// math.g:215:6: op= 'or' t2= andExpr
					{
					op=(Token)match(input,33,FOLLOW_33_in_expr562); 

											code.emit(Opcode.ifne,label_true);
										
					pushFollow(FOLLOW_andExpr_in_expr578);
					t2=andExpr();
					state._fsp--;


											if(!(t1==Type.BOOL && t2==Type.BOOL))
												throw new RuntimeException("Gli operandi di or non sono entrambi booleani");
										
					}
					break;

				default :
					break loop17;
				}
			}


						if (op!=null) {
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

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return type;
	}
	// $ANTLR end "expr"



	// $ANTLR start "relExpr"
	// math.g:243:1: relExpr returns [Type type] : t1= addExpr ( '=' t2= addExpr | '!=' t2= addExpr | '<=' t2= addExpr | '>=' t2= addExpr | '<' t2= addExpr | '>' t2= addExpr )? ;
	public final Type relExpr() throws RecognitionException {
		Type type = null;


		Type t1 =null;
		Type t2 =null;

		try {
			// math.g:244:2: (t1= addExpr ( '=' t2= addExpr | '!=' t2= addExpr | '<=' t2= addExpr | '>=' t2= addExpr | '<' t2= addExpr | '>' t2= addExpr )? )
			// math.g:244:4: t1= addExpr ( '=' t2= addExpr | '!=' t2= addExpr | '<=' t2= addExpr | '>=' t2= addExpr | '<' t2= addExpr | '>' t2= addExpr )?
			{
			pushFollow(FOLLOW_addExpr_in_relExpr617);
			t1=addExpr();
			state._fsp--;

			 type =t1; 
			// math.g:245:3: ( '=' t2= addExpr | '!=' t2= addExpr | '<=' t2= addExpr | '>=' t2= addExpr | '<' t2= addExpr | '>' t2= addExpr )?
			int alt18=7;
			switch ( input.LA(1) ) {
				case 21:
					{
					alt18=1;
					}
					break;
				case 8:
					{
					alt18=2;
					}
					break;
				case 20:
					{
					alt18=3;
					}
					break;
				case 24:
					{
					alt18=4;
					}
					break;
				case 19:
					{
					alt18=5;
					}
					break;
				case 23:
					{
					alt18=6;
					}
					break;
			}
			switch (alt18) {
				case 1 :
					// math.g:245:5: '=' t2= addExpr
					{
					match(input,21,FOLLOW_21_in_relExpr625); 
					pushFollow(FOLLOW_addExpr_in_relExpr630);
					t2=addExpr();
					state._fsp--;


									if(t1==t2) type =t1;
									else	throw new RuntimeException("gli operandi del confronto di uguaglianza hanno tipi diversi");
									int lfalse = code.newLabel();
									code.emit(Opcode.if_icmpne,lfalse);
									code.emit(Opcode.iconst_1);
									int lnext=code.newLabel();
									code.emit(Opcode.goto_,lnext);
									code.emitLabel(lfalse);
									code.emit(Opcode.iconst_0);
									code.emitLabel(lnext);
									type =Type.BOOL;
								
					}
					break;
				case 2 :
					// math.g:259:5: '!=' t2= addExpr
					{
					match(input,8,FOLLOW_8_in_relExpr641); 
					pushFollow(FOLLOW_addExpr_in_relExpr645);
					t2=addExpr();
					state._fsp--;


									if(t1==t2)	type =t1;
									else	throw new RuntimeException("gli operandi del confronto di diversita' hanno tipi diversi");
									int lfalse = code.newLabel();
									code.emit(Opcode.if_icmpeq,lfalse);
									code.emit(Opcode.iconst_1);
									int lnext=code.newLabel();
									code.emit(Opcode.goto_,lnext);
									code.emitLabel(lfalse);
									code.emit(Opcode.iconst_0);
									code.emitLabel(lnext);
									type =Type.BOOL;
								
					}
					break;
				case 3 :
					// math.g:273:5: '<=' t2= addExpr
					{
					match(input,20,FOLLOW_20_in_relExpr656); 
					pushFollow(FOLLOW_addExpr_in_relExpr660);
					t2=addExpr();
					state._fsp--;


									if(t1==t2 && t1==Type.INT)		type =t1;
									else						throw new RuntimeException("gli operandi del confronto di minore uguale non sono entrambi interi");
									int lfalse = code.newLabel();
									code.emit(Opcode.if_icmpgt,lfalse);
									code.emit(Opcode.iconst_1);
									int lnext=code.newLabel();
									code.emit(Opcode.goto_,lnext);
									code.emitLabel(lfalse);
									code.emit(Opcode.iconst_0);
									code.emitLabel(lnext);
									type =Type.BOOL;
								
					}
					break;
				case 4 :
					// math.g:287:5: '>=' t2= addExpr
					{
					match(input,24,FOLLOW_24_in_relExpr671); 
					pushFollow(FOLLOW_addExpr_in_relExpr675);
					t2=addExpr();
					state._fsp--;


									if(t1==t2 && t1==Type.INT)		type =t1;
									else						throw new RuntimeException("gli operandi del confronto di minore uguale non sono entrambi interi");
									int lfalse = code.newLabel();
									code.emit(Opcode.if_icmplt,lfalse);
									code.emit(Opcode.iconst_1);
									int lnext=code.newLabel();
									code.emit(Opcode.goto_,lnext);
									code.emitLabel(lfalse);
									code.emit(Opcode.iconst_0);
									code.emitLabel(lnext);
									type =Type.BOOL;
								
					}
					break;
				case 5 :
					// math.g:301:5: '<' t2= addExpr
					{
					match(input,19,FOLLOW_19_in_relExpr686); 
					pushFollow(FOLLOW_addExpr_in_relExpr691);
					t2=addExpr();
					state._fsp--;


									if(t1==t2 && t1==Type.INT)		type =t1;
									else						throw new RuntimeException("gli operandi del confronto di minore uguale non sono entrambi interi");
									int lfalse = code.newLabel();
									code.emit(Opcode.if_icmpge,lfalse);
									code.emit(Opcode.iconst_1);
									int lnext=code.newLabel();
									code.emit(Opcode.goto_,lnext);
									code.emitLabel(lfalse);
									code.emit(Opcode.iconst_0);
									code.emitLabel(lnext);
									type =Type.BOOL;
								
					}
					break;
				case 6 :
					// math.g:315:5: '>' t2= addExpr
					{
					match(input,23,FOLLOW_23_in_relExpr702); 
					pushFollow(FOLLOW_addExpr_in_relExpr707);
					t2=addExpr();
					state._fsp--;


									if(t1==t2 && t1==Type.INT)	type =t1;
									else					throw new RuntimeException("gli operandi del confronto di minore uguale non sono entrambi interi");
									int lfalse = code.newLabel();
									code.emit(Opcode.if_icmple,lfalse);
									code.emit(Opcode.iconst_1);
									int lnext=code.newLabel();
									code.emit(Opcode.goto_,lnext);
									code.emitLabel(lfalse);
									code.emit(Opcode.iconst_0);
									code.emitLabel(lnext);
									type =Type.BOOL;
								
					}
					break;

			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return type;
	}
	// $ANTLR end "relExpr"



	// $ANTLR start "addExpr"
	// math.g:332:1: addExpr returns [Type type] : t1= multExpr ( '+' t2= multExpr | '-' t2= multExpr )* ;
	public final Type addExpr() throws RecognitionException {
		Type type = null;


		Type t1 =null;
		Type t2 =null;

		try {
			// math.g:333:2: (t1= multExpr ( '+' t2= multExpr | '-' t2= multExpr )* )
			// math.g:333:4: t1= multExpr ( '+' t2= multExpr | '-' t2= multExpr )*
			{
			pushFollow(FOLLOW_multExpr_in_addExpr735);
			t1=multExpr();
			state._fsp--;


							type =t1;
							//if(t1==Type.INT)		type =Type.INT;
							//else				throw new RuntimeException("[addexpr] L'operatore non e' intero bensi"+t1);
						
			// math.g:339:3: ( '+' t2= multExpr | '-' t2= multExpr )*
			loop19:
			while (true) {
				int alt19=3;
				int LA19_0 = input.LA(1);
				if ( (LA19_0==13) ) {
					alt19=1;
				}
				else if ( (LA19_0==15) ) {
					alt19=2;
				}

				switch (alt19) {
				case 1 :
					// math.g:339:5: '+' t2= multExpr
					{
					match(input,13,FOLLOW_13_in_addExpr746); 
					pushFollow(FOLLOW_multExpr_in_addExpr750);
					t2=multExpr();
					state._fsp--;

						
									if(t2!=Type.INT || type!=Type.INT ) 		throw new RuntimeException("L'operatore della somma non e' intero bensi"+t1+t2);
									code.emit(Opcode.iadd);
								
					}
					break;
				case 2 :
					// math.g:344:5: '-' t2= multExpr
					{
					match(input,15,FOLLOW_15_in_addExpr761); 
					pushFollow(FOLLOW_multExpr_in_addExpr765);
					t2=multExpr();
					state._fsp--;

						
									if(t2!=Type.INT || type!=Type.INT ) throw new RuntimeException("L'operatore della sottrazione non e' intero bensi"+t1+t2);
									code.emit(Opcode.iadd);
								
					}
					break;

				default :
					break loop19;
				}
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return type;
	}
	// $ANTLR end "addExpr"



	// $ANTLR start "multExpr"
	// math.g:352:1: multExpr returns [Type type] : t1= unExpr ( '*' t2= unExpr | '/' t2= unExpr )* ;
	public final Type multExpr() throws RecognitionException {
		Type type = null;


		Type t1 =null;
		Type t2 =null;

		try {
			// math.g:353:2: (t1= unExpr ( '*' t2= unExpr | '/' t2= unExpr )* )
			// math.g:353:4: t1= unExpr ( '*' t2= unExpr | '/' t2= unExpr )*
			{
			pushFollow(FOLLOW_unExpr_in_multExpr793);
			t1=unExpr();
			state._fsp--;


							type =t1;
							//if(t1==Type.INT)		type =Type.INT;
							//else				throw new RuntimeException("[addexpr] L'operatore non e' intero bensi"+t1);
							
						
			// math.g:360:3: ( '*' t2= unExpr | '/' t2= unExpr )*
			loop20:
			while (true) {
				int alt20=3;
				int LA20_0 = input.LA(1);
				if ( (LA20_0==12) ) {
					alt20=1;
				}
				else if ( (LA20_0==17) ) {
					alt20=2;
				}

				switch (alt20) {
				case 1 :
					// math.g:360:5: '*' t2= unExpr
					{
					match(input,12,FOLLOW_12_in_multExpr804); 
					pushFollow(FOLLOW_unExpr_in_multExpr808);
					t2=unExpr();
					state._fsp--;

						
									if(t2!=Type.INT || type!=Type.INT ) throw new RuntimeException("L'operatore della moltiplicazione non e' intero bensi"+t1);
									code.emit(Opcode.imul);
								
					}
					break;
				case 2 :
					// math.g:365:5: '/' t2= unExpr
					{
					match(input,17,FOLLOW_17_in_multExpr819); 
					pushFollow(FOLLOW_unExpr_in_multExpr823);
					t2=unExpr();
					state._fsp--;

						
									if(t2!=Type.INT || type!=Type.INT ) throw new RuntimeException("L'operatore della divisione non e' intero bensi"+t1);
									code.emit(Opcode.idiv);
								
					}
					break;

				default :
					break loop20;
				}
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return type;
	}
	// $ANTLR end "multExpr"



	// $ANTLR start "unExpr"
	// math.g:373:1: unExpr returns [Type type] : ( '+' t1= unExpr | '-' t1= unExpr | 'not' t1= unExpr |t1= primary );
	public final Type unExpr() throws RecognitionException {
		Type type = null;


		Type t1 =null;

		try {
			// math.g:374:2: ( '+' t1= unExpr | '-' t1= unExpr | 'not' t1= unExpr |t1= primary )
			int alt21=4;
			switch ( input.LA(1) ) {
			case 13:
				{
				alt21=1;
				}
				break;
			case 15:
				{
				alt21=2;
				}
				break;
			case 32:
				{
				alt21=3;
				}
				break;
			case ID:
			case INT:
			case 10:
			case 30:
			case 35:
				{
				alt21=4;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 21, 0, input);
				throw nvae;
			}
			switch (alt21) {
				case 1 :
					// math.g:374:4: '+' t1= unExpr
					{
					match(input,13,FOLLOW_13_in_unExpr849); 
					pushFollow(FOLLOW_unExpr_in_unExpr855);
					t1=unExpr();
					state._fsp--;


									if (t1==Type.INT) type =t1;
									else	throw new RuntimeException("L'operando unario del + non e' intero bensi"+t1);
								
					}
					break;
				case 2 :
					// math.g:379:4: '-' t1= unExpr
					{
					match(input,15,FOLLOW_15_in_unExpr865); 
					pushFollow(FOLLOW_unExpr_in_unExpr871);
					t1=unExpr();
					state._fsp--;

						
								
									code.emit(Opcode.ineg);
									if (t1==Type.INT) type =t1;
									else	throw new RuntimeException("L'operando unario del - non e' intero bensi"+t1);
								
					}
					break;
				case 3 :
					// math.g:386:4: 'not' t1= unExpr
					{
					match(input,32,FOLLOW_32_in_unExpr881); 
					pushFollow(FOLLOW_unExpr_in_unExpr885);
					t1=unExpr();
					state._fsp--;


								code.emit(Opcode.ineg);
								if (t1==Type.BOOL) type =t1; 
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
					break;
				case 4 :
					// math.g:401:4: t1= primary
					{
					pushFollow(FOLLOW_primary_in_unExpr896);
					t1=primary();
					state._fsp--;


								type =t1;
							
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return type;
	}
	// $ANTLR end "unExpr"



	// $ANTLR start "primary"
	// math.g:407:1: primary returns [Type type] : ( '(' t= expr ')' | INT | ID | 'true' | 'false' );
	public final Type primary() throws RecognitionException {
		Type type = null;


		Token INT1=null;
		Token ID2=null;
		Type t =null;

		try {
			// math.g:408:2: ( '(' t= expr ')' | INT | ID | 'true' | 'false' )
			int alt22=5;
			switch ( input.LA(1) ) {
			case 10:
				{
				alt22=1;
				}
				break;
			case INT:
				{
				alt22=2;
				}
				break;
			case ID:
				{
				alt22=3;
				}
				break;
			case 35:
				{
				alt22=4;
				}
				break;
			case 30:
				{
				alt22=5;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 22, 0, input);
				throw nvae;
			}
			switch (alt22) {
				case 1 :
					// math.g:408:4: '(' t= expr ')'
					{
					match(input,10,FOLLOW_10_in_primary916); 
					pushFollow(FOLLOW_expr_in_primary920);
					t=expr();
					state._fsp--;

					 type =t; 
					match(input,11,FOLLOW_11_in_primary923); 
					}
					break;
				case 2 :
					// math.g:409:4: INT
					{
					INT1=(Token)match(input,INT,FOLLOW_INT_in_primary928); 

									type =Type.INT;
									int v = Integer.parseInt((INT1!=null?INT1.getText():null));
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
					break;
				case 3 :
					// math.g:443:4: ID
					{
					ID2=(Token)match(input,ID,FOLLOW_ID_in_primary944); 
						
									type =st.lookupType((ID2!=null?ID2.getText():null));
									int offset = st.lookupAddress((ID2!=null?ID2.getText():null));
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
					break;
				case 4 :
					// math.g:461:4: 'true'
					{
					match(input,35,FOLLOW_35_in_primary954); 

									code.emit(Opcode.iconst_1);
									type =Type.BOOL;
								
					}
					break;
				case 5 :
					// math.g:467:4: 'false'
					{
					match(input,30,FOLLOW_30_in_primary969); 
					 
									code.emit(Opcode.iconst_0);
									type =Type.BOOL;
								
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return type;
	}
	// $ANTLR end "primary"

	// Delegated rules



	public static final BitSet FOLLOW_statement_in_start22 = new BitSet(new long[]{0x0000001002000200L});
	public static final BitSet FOLLOW_EOF_in_start26 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_declaration_in_statement46 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_assignment_in_statement51 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_25_in_statement56 = new BitSet(new long[]{0x0000001000000000L});
	public static final BitSet FOLLOW_36_in_statement64 = new BitSet(new long[]{0x000000094000A460L});
	public static final BitSet FOLLOW_expr_in_statement68 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_37_in_statement70 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_22_in_statement78 = new BitSet(new long[]{0x0000001000001000L});
	public static final BitSet FOLLOW_whilestatement_in_statement82 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ifstatement_in_statement88 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_forstatement_in_statement94 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_36_in_declaration112 = new BitSet(new long[]{0x00000000A0000000L});
	public static final BitSet FOLLOW_31_in_declaration115 = new BitSet(new long[]{0x0000002000004000L});
	public static final BitSet FOLLOW_29_in_declaration121 = new BitSet(new long[]{0x0000002000004000L});
	public static final BitSet FOLLOW_14_in_declaration138 = new BitSet(new long[]{0x00000000A0000000L});
	public static final BitSet FOLLOW_31_in_declaration140 = new BitSet(new long[]{0x0000002000004000L});
	public static final BitSet FOLLOW_29_in_declaration146 = new BitSet(new long[]{0x0000002000004000L});
	public static final BitSet FOLLOW_37_in_declaration162 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_22_in_declaration164 = new BitSet(new long[]{0x0000001000000000L});
	public static final BitSet FOLLOW_36_in_declaration168 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ID_in_declaration172 = new BitSet(new long[]{0x0000002000004000L});
	public static final BitSet FOLLOW_14_in_declaration177 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ID_in_declaration181 = new BitSet(new long[]{0x0000002000004000L});
	public static final BitSet FOLLOW_37_in_declaration189 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_36_in_assignment210 = new BitSet(new long[]{0x000000094000A460L});
	public static final BitSet FOLLOW_expr_in_assignment216 = new BitSet(new long[]{0x0000002000004000L});
	public static final BitSet FOLLOW_14_in_assignment225 = new BitSet(new long[]{0x000000094000A460L});
	public static final BitSet FOLLOW_expr_in_assignment231 = new BitSet(new long[]{0x0000002000004000L});
	public static final BitSet FOLLOW_37_in_assignment242 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_22_in_assignment244 = new BitSet(new long[]{0x0000001000000000L});
	public static final BitSet FOLLOW_36_in_assignment248 = new BitSet(new long[]{0x0000000400000020L});
	public static final BitSet FOLLOW_printorid_in_assignment252 = new BitSet(new long[]{0x0000002000004000L});
	public static final BitSet FOLLOW_14_in_assignment261 = new BitSet(new long[]{0x0000000400000020L});
	public static final BitSet FOLLOW_printorid_in_assignment267 = new BitSet(new long[]{0x0000002000004000L});
	public static final BitSet FOLLOW_37_in_assignment278 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_printorid300 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_34_in_printorid309 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_12_in_whilestatement326 = new BitSet(new long[]{0x0000001000000000L});
	public static final BitSet FOLLOW_36_in_whilestatement328 = new BitSet(new long[]{0x0000003002000200L});
	public static final BitSet FOLLOW_statement_in_whilestatement331 = new BitSet(new long[]{0x0000003002000200L});
	public static final BitSet FOLLOW_37_in_whilestatement335 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_9_in_forstatement354 = new BitSet(new long[]{0x0000001000000000L});
	public static final BitSet FOLLOW_36_in_forstatement356 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ID_in_forstatement360 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_14_in_forstatement365 = new BitSet(new long[]{0x0000000004000000L});
	public static final BitSet FOLLOW_26_in_forstatement369 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_INT_in_forstatement373 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_16_in_forstatement377 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_INT_in_forstatement381 = new BitSet(new long[]{0x0000000008000000L});
	public static final BitSet FOLLOW_27_in_forstatement385 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_37_in_forstatement389 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_22_in_forstatement391 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_9_in_forstatement393 = new BitSet(new long[]{0x0000001000000000L});
	public static final BitSet FOLLOW_36_in_forstatement401 = new BitSet(new long[]{0x0000003002000200L});
	public static final BitSet FOLLOW_statement_in_forstatement404 = new BitSet(new long[]{0x0000003002000200L});
	public static final BitSet FOLLOW_37_in_forstatement408 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_36_in_ifstatement430 = new BitSet(new long[]{0x0000003002000200L});
	public static final BitSet FOLLOW_statement_in_ifstatement439 = new BitSet(new long[]{0x0000003002000200L});
	public static final BitSet FOLLOW_37_in_ifstatement443 = new BitSet(new long[]{0x0000000000040002L});
	public static final BitSet FOLLOW_18_in_ifstatement446 = new BitSet(new long[]{0x0000001000000000L});
	public static final BitSet FOLLOW_36_in_ifstatement448 = new BitSet(new long[]{0x0000003002000200L});
	public static final BitSet FOLLOW_statement_in_ifstatement457 = new BitSet(new long[]{0x0000003002000200L});
	public static final BitSet FOLLOW_37_in_ifstatement461 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_relExpr_in_andExpr490 = new BitSet(new long[]{0x0000000010000002L});
	public static final BitSet FOLLOW_28_in_andExpr497 = new BitSet(new long[]{0x000000094000A460L});
	public static final BitSet FOLLOW_relExpr_in_andExpr515 = new BitSet(new long[]{0x0000000010000002L});
	public static final BitSet FOLLOW_andExpr_in_expr549 = new BitSet(new long[]{0x0000000200000002L});
	public static final BitSet FOLLOW_33_in_expr562 = new BitSet(new long[]{0x000000094000A460L});
	public static final BitSet FOLLOW_andExpr_in_expr578 = new BitSet(new long[]{0x0000000200000002L});
	public static final BitSet FOLLOW_addExpr_in_relExpr617 = new BitSet(new long[]{0x0000000001B80102L});
	public static final BitSet FOLLOW_21_in_relExpr625 = new BitSet(new long[]{0x000000094000A460L});
	public static final BitSet FOLLOW_addExpr_in_relExpr630 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_8_in_relExpr641 = new BitSet(new long[]{0x000000094000A460L});
	public static final BitSet FOLLOW_addExpr_in_relExpr645 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_20_in_relExpr656 = new BitSet(new long[]{0x000000094000A460L});
	public static final BitSet FOLLOW_addExpr_in_relExpr660 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_24_in_relExpr671 = new BitSet(new long[]{0x000000094000A460L});
	public static final BitSet FOLLOW_addExpr_in_relExpr675 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_19_in_relExpr686 = new BitSet(new long[]{0x000000094000A460L});
	public static final BitSet FOLLOW_addExpr_in_relExpr691 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_23_in_relExpr702 = new BitSet(new long[]{0x000000094000A460L});
	public static final BitSet FOLLOW_addExpr_in_relExpr707 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_multExpr_in_addExpr735 = new BitSet(new long[]{0x000000000000A002L});
	public static final BitSet FOLLOW_13_in_addExpr746 = new BitSet(new long[]{0x000000094000A460L});
	public static final BitSet FOLLOW_multExpr_in_addExpr750 = new BitSet(new long[]{0x000000000000A002L});
	public static final BitSet FOLLOW_15_in_addExpr761 = new BitSet(new long[]{0x000000094000A460L});
	public static final BitSet FOLLOW_multExpr_in_addExpr765 = new BitSet(new long[]{0x000000000000A002L});
	public static final BitSet FOLLOW_unExpr_in_multExpr793 = new BitSet(new long[]{0x0000000000021002L});
	public static final BitSet FOLLOW_12_in_multExpr804 = new BitSet(new long[]{0x000000094000A460L});
	public static final BitSet FOLLOW_unExpr_in_multExpr808 = new BitSet(new long[]{0x0000000000021002L});
	public static final BitSet FOLLOW_17_in_multExpr819 = new BitSet(new long[]{0x000000094000A460L});
	public static final BitSet FOLLOW_unExpr_in_multExpr823 = new BitSet(new long[]{0x0000000000021002L});
	public static final BitSet FOLLOW_13_in_unExpr849 = new BitSet(new long[]{0x000000094000A460L});
	public static final BitSet FOLLOW_unExpr_in_unExpr855 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_15_in_unExpr865 = new BitSet(new long[]{0x000000094000A460L});
	public static final BitSet FOLLOW_unExpr_in_unExpr871 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_32_in_unExpr881 = new BitSet(new long[]{0x000000094000A460L});
	public static final BitSet FOLLOW_unExpr_in_unExpr885 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_primary_in_unExpr896 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_10_in_primary916 = new BitSet(new long[]{0x000000094000A460L});
	public static final BitSet FOLLOW_expr_in_primary920 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_11_in_primary923 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INT_in_primary928 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_primary944 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_35_in_primary954 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_30_in_primary969 = new BitSet(new long[]{0x0000000000000002L});
}
