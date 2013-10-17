// $ANTLR 3.5 Expr.g 2013-07-29 03:25:14

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class ExprParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "DIV", "ENDOF", "ID", "LPAR", 
		"MINUS", "MULT", "NUM", "PLUS", "RPAR", "WS"
	};
	public static final int EOF=-1;
	public static final int DIV=4;
	public static final int ENDOF=5;
	public static final int ID=6;
	public static final int LPAR=7;
	public static final int MINUS=8;
	public static final int MULT=9;
	public static final int NUM=10;
	public static final int PLUS=11;
	public static final int RPAR=12;
	public static final int WS=13;

	// delegates
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public ExprParser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}
	public ExprParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);
	}

	@Override public String[] getTokenNames() { return ExprParser.tokenNames; }
	@Override public String getGrammarFileName() { return "Expr.g"; }



	// $ANTLR start "start"
	// Expr.g:3:1: start : expr ENDOF ;
	public final void start() throws RecognitionException {
		try {
			// Expr.g:4:2: ( expr ENDOF )
			// Expr.g:4:4: expr ENDOF
			{
			 System.out.println(" start -> expr "); 
			pushFollow(FOLLOW_expr_in_start15);
			expr();
			state._fsp--;

			match(input,ENDOF,FOLLOW_ENDOF_in_start17); 
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
	// Expr.g:8:1: expr : term exprp ;
	public final void expr() throws RecognitionException {
		try {
			// Expr.g:9:2: ( term exprp )
			// Expr.g:9:4: term exprp
			{
			 System.out.println(" expr -> term exprp "); 
			pushFollow(FOLLOW_term_in_expr32);
			term();
			state._fsp--;

			pushFollow(FOLLOW_exprp_in_expr34);
			exprp();
			state._fsp--;

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
	// $ANTLR end "expr"



	// $ANTLR start "exprp"
	// Expr.g:13:1: exprp : ( PLUS term exprp | MINUS term exprp |);
	public final void exprp() throws RecognitionException {
		try {
			// Expr.g:14:2: ( PLUS term exprp | MINUS term exprp |)
			int alt1=3;
			switch ( input.LA(1) ) {
			case PLUS:
				{
				alt1=1;
				}
				break;
			case MINUS:
				{
				alt1=2;
				}
				break;
			case ENDOF:
			case RPAR:
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
					// Expr.g:14:4: PLUS term exprp
					{
					 System.out.println(" exprp -> + term exprp "); 
					match(input,PLUS,FOLLOW_PLUS_in_exprp52); 
					pushFollow(FOLLOW_term_in_exprp54);
					term();
					state._fsp--;

					pushFollow(FOLLOW_exprp_in_exprp56);
					exprp();
					state._fsp--;

					}
					break;
				case 2 :
					// Expr.g:16:4: MINUS term exprp
					{
					 System.out.println(" exprp -> - term exprp "); 
					match(input,MINUS,FOLLOW_MINUS_in_exprp65); 
					pushFollow(FOLLOW_term_in_exprp67);
					term();
					state._fsp--;

					pushFollow(FOLLOW_exprp_in_exprp69);
					exprp();
					state._fsp--;

					}
					break;
				case 3 :
					// Expr.g:18:4: 
					{
					 System.out.println(" exprp -> epsilon "); 
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
	// $ANTLR end "exprp"



	// $ANTLR start "term"
	// Expr.g:21:1: term : fact termp ;
	public final void term() throws RecognitionException {
		try {
			// Expr.g:22:2: ( fact termp )
			// Expr.g:22:4: fact termp
			{
			 System.out.println(" term -> fact termp "); 
			pushFollow(FOLLOW_fact_in_term89);
			fact();
			state._fsp--;

			pushFollow(FOLLOW_termp_in_term91);
			termp();
			state._fsp--;

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
	// $ANTLR end "term"



	// $ANTLR start "termp"
	// Expr.g:26:1: termp : ( MULT fact termp | DIV fact termp |);
	public final void termp() throws RecognitionException {
		try {
			// Expr.g:27:2: ( MULT fact termp | DIV fact termp |)
			int alt2=3;
			switch ( input.LA(1) ) {
			case MULT:
				{
				alt2=1;
				}
				break;
			case DIV:
				{
				alt2=2;
				}
				break;
			case ENDOF:
			case MINUS:
			case PLUS:
			case RPAR:
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
					// Expr.g:27:4: MULT fact termp
					{
					 System.out.println(" termp -> * fact termp"); 
					match(input,MULT,FOLLOW_MULT_in_termp109); 
					pushFollow(FOLLOW_fact_in_termp111);
					fact();
					state._fsp--;

					pushFollow(FOLLOW_termp_in_termp113);
					termp();
					state._fsp--;

					}
					break;
				case 2 :
					// Expr.g:29:4: DIV fact termp
					{
					 System.out.println(" termp -> / fact termp"); 
					match(input,DIV,FOLLOW_DIV_in_termp123); 
					pushFollow(FOLLOW_fact_in_termp125);
					fact();
					state._fsp--;

					pushFollow(FOLLOW_termp_in_termp127);
					termp();
					state._fsp--;

					}
					break;
				case 3 :
					// Expr.g:31:7: 
					{
					 System.out.println(" termp -> epsilon "); 
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
	// $ANTLR end "termp"



	// $ANTLR start "fact"
	// Expr.g:34:1: fact : ( LPAR expr RPAR | ID | NUM );
	public final void fact() throws RecognitionException {
		try {
			// Expr.g:35:2: ( LPAR expr RPAR | ID | NUM )
			int alt3=3;
			switch ( input.LA(1) ) {
			case LPAR:
				{
				alt3=1;
				}
				break;
			case ID:
				{
				alt3=2;
				}
				break;
			case NUM:
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
					// Expr.g:35:4: LPAR expr RPAR
					{
					 System.out.println(" fact -> ( expr ) "); 
					match(input,LPAR,FOLLOW_LPAR_in_fact152); 
					pushFollow(FOLLOW_expr_in_fact154);
					expr();
					state._fsp--;

					match(input,RPAR,FOLLOW_RPAR_in_fact156); 
					}
					break;
				case 2 :
					// Expr.g:37:4: ID
					{
					match(input,ID,FOLLOW_ID_in_fact161); 
					 System.out.println(" fact -> ID "); 
					}
					break;
				case 3 :
					// Expr.g:38:4: NUM
					{
					match(input,NUM,FOLLOW_NUM_in_fact170); 
					 System.out.println(" fact -> NUM "); 
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
	// $ANTLR end "fact"

	// Delegated rules



	public static final BitSet FOLLOW_expr_in_start15 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ENDOF_in_start17 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_term_in_expr32 = new BitSet(new long[]{0x0000000000000900L});
	public static final BitSet FOLLOW_exprp_in_expr34 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PLUS_in_exprp52 = new BitSet(new long[]{0x00000000000004C0L});
	public static final BitSet FOLLOW_term_in_exprp54 = new BitSet(new long[]{0x0000000000000900L});
	public static final BitSet FOLLOW_exprp_in_exprp56 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MINUS_in_exprp65 = new BitSet(new long[]{0x00000000000004C0L});
	public static final BitSet FOLLOW_term_in_exprp67 = new BitSet(new long[]{0x0000000000000900L});
	public static final BitSet FOLLOW_exprp_in_exprp69 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_fact_in_term89 = new BitSet(new long[]{0x0000000000000210L});
	public static final BitSet FOLLOW_termp_in_term91 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MULT_in_termp109 = new BitSet(new long[]{0x00000000000004C0L});
	public static final BitSet FOLLOW_fact_in_termp111 = new BitSet(new long[]{0x0000000000000210L});
	public static final BitSet FOLLOW_termp_in_termp113 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DIV_in_termp123 = new BitSet(new long[]{0x00000000000004C0L});
	public static final BitSet FOLLOW_fact_in_termp125 = new BitSet(new long[]{0x0000000000000210L});
	public static final BitSet FOLLOW_termp_in_termp127 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAR_in_fact152 = new BitSet(new long[]{0x00000000000004C0L});
	public static final BitSet FOLLOW_expr_in_fact154 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_RPAR_in_fact156 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_fact161 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NUM_in_fact170 = new BitSet(new long[]{0x0000000000000002L});
}
