package emfswitch.operation;

import emfswitch.SwitchImplementation;
import kmLogo.Instruction;
import kmLogo.Turtle;

public class InstructionOperation {
	private final Instruction it;

	private final SwitchImplementation emfswitch;

	public InstructionOperation(Instruction it, SwitchImplementation emfswitch) {
		this.it = it;
		this.emfswitch = emfswitch;
	}

	public double eval(Turtle turtle) {
		double result;
		result = 0.0;
		return result;
	}
}
