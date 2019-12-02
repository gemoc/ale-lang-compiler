package emfswitch.operation;

import emfswitch.SwitchImplementation;
import kmLogo.Clear;
import kmLogo.Turtle;

public class ClearOperation extends PrimitiveOperation {
	private final Clear it;

	private final SwitchImplementation emfswitch;

	public ClearOperation(Clear it, SwitchImplementation emfswitch) {
		super(it, emfswitch);
		this.it = it;
		this.emfswitch = emfswitch;
	}

	public double eval(Turtle turtle) {
		double result;
		result = 0.0;
		return result;
	}
}
