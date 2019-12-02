package emfswitch.operation;

import emfswitch.SwitchImplementation;
import kmLogo.PenDown;
import kmLogo.Turtle;

public class PenDownOperation extends PrimitiveOperation {
	private final PenDown it;

	private final SwitchImplementation emfswitch;

	public PenDownOperation(PenDown it, SwitchImplementation emfswitch) {
		super(it, emfswitch);
		this.it = it;
		this.emfswitch = emfswitch;
	}

	public double eval(Turtle turtle) {
		double result;
		turtle.setPenUp(false);
		result = 0.0;
		return result;
	}
}
