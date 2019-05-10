package emfswitch.operation;

import emfswitch.SwitchImplementation;
import kmLogo.PenUp;
import kmLogo.Turtle;

public class PenUpOperation extends PrimitiveOperation {
	private final PenUp it;

	private final SwitchImplementation emfswitch;

	public PenUpOperation(PenUp it, SwitchImplementation emfswitch) {
		super(it, emfswitch);
		this.it = it;
		this.emfswitch = emfswitch;
	}

	public double eval(Turtle turtle) {
		double result;
		turtle.setPenUp(true);
		result = 0.0;
		return result;
	}
}
