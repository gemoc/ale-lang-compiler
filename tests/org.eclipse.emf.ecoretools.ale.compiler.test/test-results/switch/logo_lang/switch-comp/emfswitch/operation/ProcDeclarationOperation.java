package emfswitch.operation;

import emfswitch.SwitchImplementation;
import java.lang.Double;
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
		result = ((Double) (0.0));
		for (Instruction instr: this.it.getInstructions()) {
			result = ((double) (((InstructionOperation) emfswitch.doSwitch(instr)).eval((Turtle) (turtle))));
		}
		return result;
	}

	public double deval(Turtle turtle) {
		double result;
		result = ((double) (((ProcDeclarationOperation) emfswitch.doSwitch(this.it)).eval((Turtle) (turtle))));
		return result;
	}
}
