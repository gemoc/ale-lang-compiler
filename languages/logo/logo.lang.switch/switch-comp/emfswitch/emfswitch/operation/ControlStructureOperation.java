package emfswitch.emfswitch.operation;

import emfswitch.emfswitch.EmfswitchSwitchImplementation;
import kmLogo.ControlStructure;

public class ControlStructureOperation extends InstructionOperation {
	private final ControlStructure it;

	private final EmfswitchSwitchImplementation emfswitch;

	public ControlStructureOperation(ControlStructure it, EmfswitchSwitchImplementation emfswitch) {
		super(it, emfswitch);
		this.it = it;
		this.emfswitch = emfswitch;
	}
}
