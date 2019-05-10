package emfswitch.operation;

import emfswitch.SwitchImplementation;
import kmLogo.Segment;

public class SegmentOperation {
	private final Segment it;

	private final SwitchImplementation emfswitch;

	public SegmentOperation(Segment it, SwitchImplementation emfswitch) {
		this.it = it;
		this.emfswitch = emfswitch;
	}
}
