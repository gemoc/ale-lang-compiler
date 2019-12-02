package emfswitch.operation;

import emfswitch.SwitchImplementation;
import kmLogo.ControlStructure;

public class ControlStructureOperation extends InstructionOperation {
	private final ControlStructure it;

	private final SwitchImplementation emfswitch;

	public ControlStructureOperation(ControlStructure it, SwitchImplementation emfswitch) {
		super(it, emfswitch);
		this.it = it;
		this.emfswitch = emfswitch;
	}
}
