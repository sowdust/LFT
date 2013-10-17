import org.antlr.runtime.*;

public class MathTest {
    public static void main(String[] args) throws Exception {
        ANTLRInputStream input = new ANTLRInputStream(System.in);
        mathLexer lexer = new mathLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        mathParser parser = new mathParser(tokens);
        parser.start();
    }
}