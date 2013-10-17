import java.util.*;
public class Code {

	private Vector<Instruction> instructions = new Vector<Instruction>();
	private int counter=0;



	public Instruction emit(Opcode op)	{
		Instruction ist = new Instruction(op);
		instructions.add(ist);
		return ist;
	}
	public Instruction emit(Opcode op, int operando) {
		Instruction ist = new Instruction(op,operando);
		instructions.add(ist);
		return ist;
	}

	public void emitLabel(int label) {
		emit(Opcode.LABEL,label);
	}

	public int newLabel() {
			return counter++;
	}

	public int getLabel() {
			return counter++;
	}

	public String toString() {
		String s="";
		for(Instruction ist: instructions)
			s+=ist+"\n";
		return s;
	}
	public String toJasmin() {
    	String temp = "";
    	temp += header;
        for (Instruction ist : instructions)
            temp += ist.toJasmin() + "\n";
        temp += footer;
        return temp;
    }

	private static final String header = ".class public "
			+ "Output"
			+ "\n"
			+ ".super java/lang/Object\n"
			+ "\n"
			+ ".method public <init>()V\n"
			+ "  aload_0\n"
			+ "  invokenonvirtual java/lang/Object/<init>()V\n"
			+ "  return\n"
			+ ".end method\n"
			+ "\n"
			+ ".method public static printBool(I)V\n"
			+ "  .limit stack 3\n"
			+ "  getstatic java/lang/System/out Ljava/io/PrintStream;\n"
			+ "  iload_0\n"
			+ "  bipush 1\n"
			+ "  if_icmpeq Ltrue\n"
			+ "  ldc \"false\"\n"
			+ "  goto Lnext\n"
			+ "Ltrue:\n"
			+ "  ldc \"true\"\n"
			+ "Lnext:\n"
			+ "  invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V\n"
			+ "  return\n"
			+ ".end method\n"
			+ "\n"
			+ ".method public static printInt(I)V\n"
			+ "  .limit stack 2\n"
			+ "  getstatic java/lang/System/out Ljava/io/PrintStream;\n"
			+ "  iload_0\n"
			+ "  invokestatic java/lang/Integer/toString(I)Ljava/lang/String;\n"
			+ "  invokevirtual java/io/PrintStream/println(Ljava/lang/String;)V\n"
			+ "  return\n" + ".end method\n" + "\n"
			+ ".method public static run()V\n" + "  .limit stack 1024\n"
			+ "  .limit locals 256\n";
	private static final String footer = "  return\n" + ".end method\n" + "\n"
			+ ".method public static main([Ljava/lang/String;)V\n"
			+ "  invokestatic Output/run()V\n" + "  return\n" + ".end method\n";

}
