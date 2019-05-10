package emfswitch.operation;

import emfswitch.SwitchImplementation;
import kmLogo.Point;

public class PointOperation {
	private final Point it;

	private final SwitchImplementation emfswitch;

	public PointOperation(Point it, SwitchImplementation emfswitch) {
		this.it = it;
		this.emfswitch = emfswitch;
	}
}
