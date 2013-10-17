// $ANTLR 3.5 ExprEvaluator.g 2013-07-29 03:25:16

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class ExprEvaluatorParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "EOFF", "ID", "INT", "WS", "'('", 
		"')'", "'*'", "'+'", "'-'", "'/'"
	};
	public static final int EOF=-1;
	public static final int T__8=8;
	public static final int T__9=9;
	public static final int T__10=10;
	public static final int T__11=11;
	public static final int T__12=12;
	public static final int T__13=13;
	public static final int EOFF=4;
	public static final int ID=5;
	public static final int INT=6;
	public static final int WS=7;

	// delegates
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public ExprEvaluatorParser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}
	public ExprEvaluatorParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);
	}

	@Override public String[] getTokenNames() { return ExprEvaluatorParser.tokenNames; }
	@Override public String getGrammarFileName() { return "ExprEvaluator.g"; }



	// $ANTLR start "start"
	// ExprEvaluator.g:4:1: start :vexpr= expr EOFF ;
	public final void start() throws RecognitionException {
		int vexpr =0;

		try {
			// ExprEvaluator.g:4:7: (vexpr= expr EOFF )
			// ExprEvaluator.g:4:9: vexpr= expr EOFF
			{

						System.out.println("Valore espressione: "+vexpr);
					
			pushFollow(FOLLOW_expr_in_start18);
			vexpr=expr();
			state._fsp--;

			match(input,EOFF,FOLLOW_EOFF_in_start23); 
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
	// ExprEvaluator.g:11:1: expr returns [int val] : vterm= term vexprp= exprp[vterm] ;
	public final int expr() throws RecognitionException {
		int val = 0;


		int vterm =0;
		int vexprp =0;

		try {
			// ExprEvaluator.g:12:2: (vterm= term vexprp= exprp[vterm] )
			// ExprEvaluator.g:12:4: vterm= term vexprp= exprp[vterm]
			{
			pushFollow(FOLLOW_term_in_expr40);
			vterm=term();
			state._fsp--;

			pushFollow(FOLLOW_exprp_in_expr44);
			vexprp=exprp(vterm);
			state._fsp--;


						System.out.println("expr -> term exprp");

						val =vexprp;
					
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



	// $ANTLR start "exprp"
	// ExprEvaluator.g:20:1: exprp[int i] returns [int val] : ( '+' vterm= term vexprp= exprp[vterm+$i] | '-' vterm= term vexprp= exprp[$i-vterm] |);
	public final int exprp(int i) throws RecognitionException {
		int val = 0;


		int vterm =0;
		int vexprp =0;

		try {
			// ExprEvaluator.g:21:2: ( '+' vterm= term vexprp= exprp[vterm+$i] | '-' vterm= term vexprp= exprp[$i-vterm] |)
			int alt1=3;
			switch ( input.LA(1) ) {
			case 11:
				{
				alt1=1;
				}
				break;
			case 12:
				{
				alt1=2;
				}
				break;
			case EOFF:
			case 9:
				{
				alt1=3;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 1, 0, input);
				throw nvae;
			}
			switch (alt1) {
				case 1 :
					// ExprEvaluator.g:21:4: '+' vterm= term vexprp= exprp[vterm+$i]
					{
					match(input,11,FOLLOW_11_in_exprp65); 
					pushFollow(FOLLOW_term_in_exprp69);
					vterm=term();
					state._fsp--;

					pushFollow(FOLLOW_exprp_in_exprp73);
					vexprp=exprp(vterm+i);
					state._fsp--;


								System.out.println("exprp -> + term exprp");
								val =vexprp;
							
					}
					break;
				case 2 :
					// ExprEvaluator.g:26:4: '-' vterm= term vexprp= exprp[$i-vterm]
					{
					match(input,12,FOLLOW_12_in_exprp83); 
					pushFollow(FOLLOW_term_in_exprp87);
					vterm=term();
					state._fsp--;

					pushFollow(FOLLOW_exprp_in_exprp91);
					vexprp=exprp(i-vterm);
					state._fsp--;


								System.out.println("exprp -> - term exprp");
								val =vexprp;
										
					}
					break;
				case 3 :
					// ExprEvaluator.g:31:4: 
					{
					 System.out.println("exprp -> epsilon"); val =i; 
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
	// $ANTLR end "exprp"



	// $ANTLR start "term"
	// ExprEvaluator.g:34:1: term returns [int val] : vfact= fact vtermp= termp[vfact] ;
	public final int term() throws RecognitionException {
		int val = 0;


		int vfact =0;
		int vtermp =0;

		try {
			// ExprEvaluator.g:35:2: (vfact= fact vtermp= termp[vfact] )
			// ExprEvaluator.g:35:4: vfact= fact vtermp= termp[vfact]
			{
			pushFollow(FOLLOW_fact_in_term117);
			vfact=fact();
			state._fsp--;

			pushFollow(FOLLOW_termp_in_term121);
			vtermp=termp(vfact);
			state._fsp--;


						System.out.println("term -> fact termp");
						val =vtermp;
						
					
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



	// $ANTLR start "termp"
	// ExprEvaluator.g:43:1: termp[int i] returns [int val] : ( '*' vfact= fact vtermp= termp[$i * vfact] | '/' vfact= fact vtermp= termp[$i / vfact] |);
	public final int termp(int i) throws RecognitionException {
		int val = 0;


		int vfact =0;
		int vtermp =0;

		try {
			// ExprEvaluator.g:44:2: ( '*' vfact= fact vtermp= termp[$i * vfact] | '/' vfact= fact vtermp= termp[$i / vfact] |)
			int alt2=3;
			switch ( input.LA(1) ) {
			case 10:
				{
				alt2=1;
				}
				break;
			case 13:
				{
				alt2=2;
				}
				break;
			case EOFF:
			case 9:
			case 11:
			case 12:
				{
				alt2=3;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 2, 0, input);
				throw nvae;
			}
			switch (alt2) {
				case 1 :
					// ExprEvaluator.g:44:4: '*' vfact= fact vtermp= termp[$i * vfact]
					{
					match(input,10,FOLLOW_10_in_termp141); 
					pushFollow(FOLLOW_fact_in_termp145);
					vfact=fact();
					state._fsp--;

					pushFollow(FOLLOW_termp_in_termp149);
					vtermp=termp(i * vfact);
					state._fsp--;


								System.out.println("termp -> * fact termp");
								val =vtermp;
											
							
					}
					break;
				case 2 :
					// ExprEvaluator.g:50:4: '/' vfact= fact vtermp= termp[$i / vfact]
					{
					match(input,13,FOLLOW_13_in_termp159); 
					pushFollow(FOLLOW_fact_in_termp163);
					vfact=fact();
					state._fsp--;

					pushFollow(FOLLOW_termp_in_termp167);
					vtermp=termp(i / vfact);
					state._fsp--;


								System.out.println("termp -> / fact termp");
								val =vtermp;
								
							
					}
					break;
				case 3 :
					// ExprEvaluator.g:56:4: 
					{

								System.out.println("termp -> epsilon");
								val =i;
								
							
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
	// $ANTLR end "termp"



	// $ANTLR start "fact"
	// ExprEvaluator.g:63:1: fact returns [int val] : ( '(' vexpr= expr ')' | INT | ID );
	public final int fact() throws RecognitionException {
		int val = 0;


		Token INT1=null;
		int vexpr =0;

		try {
			// ExprEvaluator.g:64:2: ( '(' vexpr= expr ')' | INT | ID )
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
					// ExprEvaluator.g:64:4: '(' vexpr= expr ')'
					{
					match(input,8,FOLLOW_8_in_fact193); 
					pushFollow(FOLLOW_expr_in_fact197);
					vexpr=expr();
					state._fsp--;

					match(input,9,FOLLOW_9_in_fact199); 

								System.out.println("fact -> ( expr )");
								val =vexpr;
								
							
					}
					break;
				case 2 :
					// ExprEvaluator.g:70:4: INT
					{
					INT1=(Token)match(input,INT,FOLLOW_INT_in_fact208); 

								
								System.out.println("fact -> NUM");
								val =Integer.parseInt((INT1!=null?INT1.getText():null));
							
					}
					break;
				case 3 :
					// ExprEvaluator.g:76:4: ID
					{
					match(input,ID,FOLLOW_ID_in_fact217); 

								val =0;
								System.out.println("fact -> ID");
							
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



	public static final BitSet FOLLOW_expr_in_start18 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_EOFF_in_start23 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_term_in_expr40 = new BitSet(new long[]{0x0000000000001800L});
	public static final BitSet FOLLOW_exprp_in_expr44 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_11_in_exprp65 = new BitSet(new long[]{0x0000000000000160L});
	public static final BitSet FOLLOW_term_in_exprp69 = new BitSet(new long[]{0x0000000000001800L});
	public static final BitSet FOLLOW_exprp_in_exprp73 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_12_in_exprp83 = new BitSet(new long[]{0x0000000000000160L});
	public static final BitSet FOLLOW_term_in_exprp87 = new BitSet(new long[]{0x0000000000001800L});
	public static final BitSet FOLLOW_exprp_in_exprp91 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_fact_in_term117 = new BitSet(new long[]{0x0000000000002400L});
	public static final BitSet FOLLOW_termp_in_term121 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_10_in_termp141 = new BitSet(new long[]{0x0000000000000160L});
	public static final BitSet FOLLOW_fact_in_termp145 = new BitSet(new long[]{0x0000000000002400L});
	public static final BitSet FOLLOW_termp_in_termp149 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_13_in_termp159 = new BitSet(new long[]{0x0000000000000160L});
	public static final BitSet FOLLOW_fact_in_termp163 = new BitSet(new long[]{0x0000000000002400L});
	public static final BitSet FOLLOW_termp_in_termp167 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_8_in_fact193 = new BitSet(new long[]{0x0000000000000160L});
	public static final BitSet FOLLOW_expr_in_fact197 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_9_in_fact199 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INT_in_fact208 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_fact217 = new BitSet(new long[]{0x0000000000000002L});
}
