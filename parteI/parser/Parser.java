package parser;
import java.io.*;
import lexer.*;

public class Parser {
	public static final boolean colored_text=true;
	private Lexer lex;
	private Token current;
	private int tab;

	public Parser(Lexer lex) {
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
	

	public void start() {
		stampa("start -> expr");
		move();
		expr();
		match(Tag.EOF);
	}
	private void expr() {
		more_tab();
		stampa("expr -> exprp");
		term();
		exprp();
		less_tab();
	}
	private void exprp() {
		more_tab();
		switch(current.tag) {
			case PIU:
				stampa("exprp -> + term exprp");
				match(Tag.PIU);
				term();
				exprp();
				break;
			case MENO:
				stampa("exprp -> - term exprp");
				match(Tag.MENO);
				term();
				exprp();
				break;
			default:
				stampa("exprp -> epsilon");
				break;
		}
		less_tab();
	}
	private void term() {
		more_tab();
		stampa("term -> fact termp");
		fact();
		termp();
		less_tab();
	}
	private void termp() {
		more_tab();
		switch(current.tag) {
			case PER:
				stampa("termp -> * fact termp");
				match(Tag.PER);
				fact();
				termp();
				break;
			case DIV:
				stampa("termp -> / fact termp");
				match(Tag.DIV);
				fact();
				termp();
				break;
			default:
				stampa("termp -> epsilon");
				break;
		}
		less_tab();
	}
	private void fact() {
		more_tab();
		switch(current.tag) {
			case NUM:
				stampa("fact -> NUM");
				more_tab();
				stampa(current.value);
				less_tab();
				match(Tag.NUM);
				break;
			case LPAR:
				stampa("fact -> ( expr )");
				match(Tag.LPAR);
				expr();
				match(Tag.RPAR);
				break;
			case ID:
				stampa("fact -> ID");
				more_tab();
				stampa(current.value);
				less_tab();
				match(Tag.ID);
				break;
			default:
				stampa("fact -> epsilon");
				break;
		}
		less_tab();
	}
}