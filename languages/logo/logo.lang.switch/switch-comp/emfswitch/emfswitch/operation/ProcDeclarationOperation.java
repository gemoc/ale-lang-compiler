package emfswitch.emfswitch.operation;

import emfswitch.emfswitch.EmfswitchSwitchImplementation;
import java.lang.Double;
import kmLogo.Instruction;
import kmLogo.ProcDeclaration;
import kmLogo.Turtle;

public class ProcDeclarationOperation extends InstructionOperation {
	private final ProcDeclaration it;

	private final EmfswitchSwitchImplementation emfswitch;

	public ProcDeclarationOperation(ProcDeclaration it, EmfswitchSwitchImplementation emfswitch) {
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
}
