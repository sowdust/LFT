import org.antlr.runtime.*;

public class Main {
	public static void main(String[] args) throws Exception {
		ANTLRInputStream input = new ANTLRInputStream(System.in);
		ExprEvaluatorLexer evlexer = new ExprEvaluatorLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(evlexer);
		ExprEvaluatorParser evparser = new ExprEvaluatorParser(tokens);
		evparser.start();
	}
}