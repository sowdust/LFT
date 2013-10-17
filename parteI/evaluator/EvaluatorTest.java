package evaluator;

import java.io.*;
import lexer.*;

public class EvaluatorTest {
	public static void main(String[] args) {
		Lexer lex = new Lexer();
		Evaluator eval = new Evaluator(lex);
		System.out.println(eval.start());
	}
}