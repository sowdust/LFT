package parser;

import java.io.*;
import lexer.*;

public class ParserTest{
	public static void main(String[] args) {
		Lexer lex = new Lexer();
		Parser parser = new Parser(lex);
		parser.start();
		//parser_old.start();
	}
}