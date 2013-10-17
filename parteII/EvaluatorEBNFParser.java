// $ANTLR 3.5 EvaluatorEBNF.g 2013-07-29 03:25:17

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class EvaluatorEBNFParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "Endoffile", "ID", "INT", "WS", 
		"'('", "')'", "'*'", "'+'", "'-'", "'/'"
	};
	public static final int EOF=-1;
	public static final int T__8=8;
	public static final int T__9=9;
	public static final int T__10=10;
	public static final int T__11=11;
	public static final int T__12=12;
	public static final int T__13=13;
	public static final int Endoffile=4;
	public static final int ID=5;
	public static final int INT=6;
	public static final int WS=7;

	// delegates
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public EvaluatorEBNFParser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}
	public EvaluatorEBNFParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);
	}

	@Override public String[] getTokenNames() { return EvaluatorEBNFParser.tokenNames; }
	@Override public String getGrammarFileName() { return "EvaluatorEBNF.g"; }



	// $ANTLR start "start"
	// EvaluatorEBNF.g:3:1: start :val= expr Endoffile ;
	public final void start() throws RecognitionException {
		int val =0;

		try {
			// EvaluatorEBNF.g:3:7: (val= expr Endoffile )
			// EvaluatorEBNF.g:4:3: val= expr Endoffile
			{
			 System.out.println("start -> expr EOF "); 
			pushFollow(FOLLOW_expr_in_start19);
			val=expr();
			state._fsp--;

			 System.out.println("Valore espressione: "+val); 
			match(input,Endoffile,FOLLOW_Endoffile_in_start28); 
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



	// $ANTLR start "expr"
	// EvaluatorEBNF.g:9:1: expr returns [int val] :t0= term ( '+' t= term | '-' t= term )* ;
	public final int expr() throws RecognitionException {
		int val = 0;


		int t0 =0;
		int t =0;

		try {
			// EvaluatorEBNF.g:10:2: (t0= term ( '+' t= term | '-' t= term )* )
			// EvaluatorEBNF.g:10:4: t0= term ( '+' t= term | '-' t= term )*
			{
			 System.out.println("expr -> term [ +term | - term ]*"); 
			pushFollow(FOLLOW_term_in_expr47);
			t0=term();
			state._fsp--;

			 val =t0; 
			// EvaluatorEBNF.g:12:3: ( '+' t= term | '-' t= term )*
			loop1:
			while (true) {
				int alt1=3;
				int LA1_0 = input.LA(1);
				if ( (LA1_0==11) ) {
					alt1=1;
				}
				else if ( (LA1_0==12) ) {
					alt1=2;
				}

				switch (alt1) {
				case 1 :
					// EvaluatorEBNF.g:13:4: '+' t= term
					{
					match(input,11,FOLLOW_11_in_expr60); 
					pushFollow(FOLLOW_term_in_expr64);
					t=term();
					state._fsp--;

					 val+=t; 
					}
					break;
				case 2 :
					// EvaluatorEBNF.g:14:7: '-' t= term
					{
					match(input,12,FOLLOW_12_in_expr74); 
					pushFollow(FOLLOW_term_in_expr78);
					t=term();
					state._fsp--;

					 val-=t; 
					}
					break;

				default :
					break loop1;
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
		return val;
	}
	// $ANTLR end "expr"



	// $ANTLR start "term"
	// EvaluatorEBNF.g:17:1: term returns [int val] :f0= fact ( '*' f= fact | '/' f= fact )* ;
	public final int term() throws RecognitionException {
		int val = 0;


		int f0 =0;
		int f =0;

		try {
			// EvaluatorEBNF.g:18:2: (f0= fact ( '*' f= fact | '/' f= fact )* )
			// EvaluatorEBNF.g:18:4: f0= fact ( '*' f= fact | '/' f= fact )*
			{
			 System.out.println("term -> fact [ *fact | /fact ]*"); 
			pushFollow(FOLLOW_fact_in_term105);
			f0=fact();
			state._fsp--;

			 val =f0; 
			// EvaluatorEBNF.g:20:3: ( '*' f= fact | '/' f= fact )*
			loop2:
			while (true) {
				int alt2=3;
				int LA2_0 = input.LA(1);
				if ( (LA2_0==10) ) {
					alt2=1;
				}
				else if ( (LA2_0==13) ) {
					alt2=2;
				}

				switch (alt2) {
				case 1 :
					// EvaluatorEBNF.g:21:4: '*' f= fact
					{
					match(input,10,FOLLOW_10_in_term118); 
					pushFollow(FOLLOW_fact_in_term122);
					f=fact();
					state._fsp--;

					 val =val*f; 
					}
					break;
				case 2 :
					// EvaluatorEBNF.g:22:7: '/' f= fact
					{
					match(input,13,FOLLOW_13_in_term132); 
					pushFollow(FOLLOW_fact_in_term136);
					f=fact();
					state._fsp--;

					 val =val/f; 
					}
					break;

				default :
					break loop2;
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
		return val;
	}
	// $ANTLR end "term"



	// $ANTLR start "fact"
	// EvaluatorEBNF.g:25:1: fact returns [int val] : ( '(' e= expr ')' | INT | ID );
	public final int fact() throws RecognitionException {
		int val = 0;


		Token INT1=null;
		int e =0;

		try {
			// EvaluatorEBNF.g:26:2: ( '(' e= expr ')' | INT | ID )
			int alt3=3;
			switch ( input.LA(1) ) {
			case 8:
				{
				alt3=1;
				}
				break;
			case INT:
				{
				alt3=2;
				}
				break;
			case ID:
				{
				alt3=3;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 3, 0, input);
				throw nvae;
			}
			switch (alt3) {
				case 1 :
					// EvaluatorEBNF.g:27:3: '(' e= expr ')'
					{
					 System.out.println("fact -> ( expr ) | NUM | ID "); 
					match(input,8,FOLLOW_8_in_fact162); 
					pushFollow(FOLLOW_expr_in_fact166);
					e=expr();
					state._fsp--;

					match(input,9,FOLLOW_9_in_fact168); 
					 val =e; 
					}
					break;
				case 2 :
					// EvaluatorEBNF.g:29:5: INT
					{
					INT1=(Token)match(input,INT,FOLLOW_INT_in_fact177); 
					 val =Integer.parseInt((INT1!=null?INT1.getText():null)); 
					}
					break;
				case 3 :
					// EvaluatorEBNF.g:30:4: ID
					{
					match(input,ID,FOLLOW_ID_in_fact185); 
					 val =0; 
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
		return val;
	}
	// $ANTLR end "fact"

	// Delegated rules



	public static final BitSet FOLLOW_expr_in_start19 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_Endoffile_in_start28 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_term_in_expr47 = new BitSet(new long[]{0x0000000000001802L});
	public static final BitSet FOLLOW_11_in_expr60 = new BitSet(new long[]{0x0000000000000160L});
	public static final BitSet FOLLOW_term_in_expr64 = new BitSet(new long[]{0x0000000000001802L});
	public static final BitSet FOLLOW_12_in_expr74 = new BitSet(new long[]{0x0000000000000160L});
	public static final BitSet FOLLOW_term_in_expr78 = new BitSet(new long[]{0x0000000000001802L});
	public static final BitSet FOLLOW_fact_in_term105 = new BitSet(new long[]{0x0000000000002402L});
	public static final BitSet FOLLOW_10_in_term118 = new BitSet(new long[]{0x0000000000000160L});
	public static final BitSet FOLLOW_fact_in_term122 = new BitSet(new long[]{0x0000000000002402L});
	public static final BitSet FOLLOW_13_in_term132 = new BitSet(new long[]{0x0000000000000160L});
	public static final BitSet FOLLOW_fact_in_term136 = new BitSet(new long[]{0x0000000000002402L});
	public static final BitSet FOLLOW_8_in_fact162 = new BitSet(new long[]{0x0000000000000160L});
	public static final BitSet FOLLOW_expr_in_fact166 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_9_in_fact168 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INT_in_fact177 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_fact185 = new BitSet(new long[]{0x0000000000000002L});
}
