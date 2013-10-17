public class Instruction {
	private Opcode opcode;
	private Integer operand;

	public Instruction(Opcode op) {
		opcode=op;
	}

	public Instruction(Opcode op, int ope) {
		opcode=op;
		operand=ope;
	}

	public String toJasmin() {
		switch (opcode) {
		case IPRINT: return "  invokestatic Output/printInt(I)V";
		case BPRINT: return "  invokestatic Output/printBool(I)V";
		case LABEL: return "L" + operand + ":";
		case goto_: return "  goto L" + operand;
		case ifeq:
		case ifne:
		case if_icmpeq:
		case if_icmpne:
		case if_icmpge:
		case if_icmpgt:
		case if_icmple:
		case if_icmplt: return "  " + opcode + " L" + operand;
		default: return "  " + toString();
		}
	}
	public String toString() {
		if (operand == null)
			return "" + opcode;
		else
			return opcode + " " + operand;
	}
}