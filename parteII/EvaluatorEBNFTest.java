import org.antlr.runtime.*;

public class EvaluatorEBNFTest {
	public static void main(String[] args) throws Exception {
		ANTLRInputStream input = new ANTLRInputStream(System.in);
		EvaluatorEBNFLexer lexer = new EvaluatorEBNFLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		EvaluatorEBNFParser parser = new EvaluatorEBNFParser(tokens);
		parser.start();
	}
}