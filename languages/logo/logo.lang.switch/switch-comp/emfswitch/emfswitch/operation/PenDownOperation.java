package emfswitch.emfswitch.operation;

import emfswitch.emfswitch.EmfswitchSwitchImplementation;
import kmLogo.PenDown;
import kmLogo.Turtle;

public class PenDownOperation extends PrimitiveOperation {
	private final PenDown it;

	private final EmfswitchSwitchImplementation emfswitch;

	public PenDownOperation(PenDown it, EmfswitchSwitchImplementation emfswitch) {
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
