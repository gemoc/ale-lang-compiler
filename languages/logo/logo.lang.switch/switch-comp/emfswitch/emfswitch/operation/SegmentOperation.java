package emfswitch.emfswitch.operation;

import emfswitch.emfswitch.EmfswitchSwitchImplementation;
import kmLogo.Segment;

public class SegmentOperation {
	private final Segment it;

	private final EmfswitchSwitchImplementation emfswitch;

	public SegmentOperation(Segment it, EmfswitchSwitchImplementation emfswitch) {
		this.it = it;
		this.emfswitch = emfswitch;
	}
}
