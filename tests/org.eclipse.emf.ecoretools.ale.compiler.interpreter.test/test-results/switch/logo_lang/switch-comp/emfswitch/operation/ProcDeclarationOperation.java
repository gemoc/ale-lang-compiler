package emfswitch.operation;

import emfswitch.SwitchImplementation;
import kmLogo.Instruction;
import kmLogo.ProcDeclaration;
import kmLogo.Turtle;

public class ProcDeclarationOperation extends InstructionOperation {
	private final ProcDeclaration it;

	private final SwitchImplementation emfswitch;

	public ProcDeclarationOperation(ProcDeclaration it, SwitchImplementation emfswitch) {
		super(it, emfswitch);
		this.it = it;
		this.emfswitch = emfswitch;
	}

	public double eval(Turtle turtle) {
		double result;
		result = 0.0;
		for (Instruction instr: this.it.getInstructions()) {
			result = ((InstructionOperation) emfswitch.doSwitch(instr)).eval((Turtle) turtle);
		}
		return result;
	}

	public double deval(Turtle turtle) {
		double result;
		result = ((ProcDeclarationOperation) emfswitch.doSwitch(this.it)).eval((Turtle) turtle);
		return result;
	}
}
