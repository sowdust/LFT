package lexer;

public class LexerTest{

	public static void main(String[] args) {
		Lexer lex = new Lexer();
				Token token;
				do {
					token=lex.scan();
					System.out.println("Letto: "+token);
		}while(token.tag!=Tag.EOF);
	}

}