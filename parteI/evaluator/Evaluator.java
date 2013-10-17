package evaluator;
import java.io.*;
import lexer.*;

public class Evaluator {
	public static final boolean colored_text=true;
	private Lexer lex;
	private Token current;
	private int tab;

	public Evaluator(Lexer lex) {
		this.lex=lex;
	}
	void move() {
		current=lex.scan();
		if(colored_text)
			System.out.println("\033[32m{ current token = " + current + " } \033[0m");
		else
			System.out.println("{ current token = " + current + " } ");
	}
	void error(String e) {
		throw new Error("ERROR at lexer line "+lex.get_line()+": "+e);
	}
	void match(Tag t) {
		if(t==current.tag) {
			if(current.tag!=Tag.EOF) move();
		}else error("syntax error");
	}
	void tabba() {
		int i=0;
		for(i=0;i<=this.tab;++i)
			System.out.print("  ");
	}
	void more_tab() {
		++this.tab;
	}
	void less_tab() {
		--this.tab;
	}
	void stampa(String s) {
		tabba();
		System.out.println(s);
	}
	

	public int start() {
		stampa("start");
		move();
		int expr=expr();
		match(Tag.EOF);
		return expr;
	}
	private int expr() {
		more_tab();
		stampa("expr");
		int term=term();
		int expr=exprp(term);
		stampa("expr: "+expr);
		less_tab();
		return expr;
	}
	private int exprp(int given) {
		more_tab();
		stampa("exprp");
		int term, exprp;
		switch(current.tag) {
			case PIU:
				match(Tag.PIU);
				term=term();
				exprp=exprp(given+term);
				break;
			case MENO:
				match(Tag.MENO);
				term=term();
				exprp=exprp(given-term);
				break;
			default:
				stampa("epsilon");
				exprp=given;
				break;
		}
		stampa("exprp: "+exprp);
		less_tab();
		return exprp;
	}
	private int term() {
		
		more_tab();
		stampa("term");
		int fact=fact();
		int term=termp(fact);
		stampa("term: "+term);
		less_tab();
		return term;
	}
	private int termp(int given) {
		more_tab();
		stampa("termp");
		int fact, termp;
		switch(current.tag) {
			case PER:
				match(Tag.PER);
				fact=fact();
				termp=termp(given*fact);
				break;
			case DIV:
				match(Tag.DIV);
				fact=fact();
				termp=termp(given/fact);
				break;
			default:
				stampa("epsilon");
				termp=given;
				break;
		}
		stampa("termp: "+termp);
		less_tab();
		return termp;
	}
	private int fact() {
		more_tab();
		stampa("fact");
		more_tab();
		int fact;
		switch(current.tag) {
			case NUM:
				stampa("NUM");
				stampa(current.value);
				fact=Integer.parseInt(current.value);
				match(Tag.NUM);
				break;
			case LPAR:
				match(Tag.LPAR);
				fact=expr();
				match(Tag.RPAR);
				break;
			case ID:
				stampa("ID");
				fact=0;
				match(Tag.ID);
				break;
			default:
				throw new RuntimeException("Default in fact: "+current.tag);
		}
		stampa("fact: "+fact);
		less_tab();
		less_tab();
		return fact;
	}
}