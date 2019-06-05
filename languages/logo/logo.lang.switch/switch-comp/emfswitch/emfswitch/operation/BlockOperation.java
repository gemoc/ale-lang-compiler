package emfswitch.emfswitch.operation;

import emfswitch.emfswitch.EmfswitchSwitchImplementation;
import java.lang.Double;
import kmLogo.Block;
import kmLogo.Instruction;
import kmLogo.Turtle;

public class BlockOperation extends InstructionOperation {
	private final Block it;

	private final EmfswitchSwitchImplementation emfswitch;

	public BlockOperation(Block it, EmfswitchSwitchImplementation emfswitch) {
		super(it, emfswitch);
		this.it = it;
		this.emfswitch = emfswitch;
	}

	public double eval(Turtle turtle) {
		double result;
		for (Instruction inst: this.it.getInstructions()) {
			((InstructionOperation) emfswitch.doSwitch(inst)).eval((Turtle) (turtle));
		}
		result = ((Double) (0.0));
		return result;
	}
}
