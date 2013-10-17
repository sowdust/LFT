package lexer;
public class Token {
	public Tag tag;
	public String value;

	public Token(Tag tag, String value) {
		this.tag=tag; this.value=value;
	}
	public String toString() {
		return "<"+this.tag+","+this.value+">";
	}
}