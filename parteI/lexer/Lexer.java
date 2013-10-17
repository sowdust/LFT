package lexer;
import java.io.*;

public class Lexer{
	private static int line=1;
	private char peek=' ';

	public int get_line() {
		return this.line;
	}

	private void read_next_ch() {
		try { 	peek = (char) System.in.read(); }
		catch(IOException exc)
		{		peek = (char) -1;	}
	}
	private int one_more_line() { return ++this.line;}

	public Token scan() {
		while(' '==peek || '\t'==peek || '\n'==peek)	{
			if ('\n'==peek) one_more_line();
			read_next_ch();
		}
		switch(peek) {
			case '$':
				peek='$';
				return new Token(Tag.EOF,"$");
			case '(':
				peek=' ';
				return new Token(Tag.LPAR,"(");
			case ')':
				peek=' ';
				return new Token(Tag.RPAR,")");
			case '+':
				peek=' ';
				return new Token(Tag.PIU,"+");
			case '-':
				peek=' ';
				return new Token(Tag.MENO,"-");
			case '*':
				peek=' ';
				return new Token(Tag.PER,"*");
			case '/':
				peek=' ';
				return new Token(Tag.DIV,"/");
			default:
				if (Character.isDigit(peek))	{
					String s="";
					do{	s+=peek;	read_next_ch(); }
					while(Character.isDigit(peek));
					return new Token(Tag.NUM,s);
				}if (Character.isJavaIdentifierStart(peek) && peek!='$' ) 	{
					String s="";
					do{ s+=peek; read_next_ch(); }
					while(Character.isJavaIdentifierPart(peek) && peek!='$');
					return new Token(Tag.ID,s);
				}
				String s="";
				do{ s+=peek; read_next_ch(); }
				while(peek!=' ' && peek!='\t' && peek!='\n');
				return new Token(Tag.OTHER,s);

		}
	}
}


