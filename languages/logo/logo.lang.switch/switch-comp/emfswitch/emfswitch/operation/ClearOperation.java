package emfswitch.emfswitch.operation;

import emfswitch.emfswitch.EmfswitchSwitchImplementation;
import kmLogo.Clear;
import kmLogo.Turtle;

public class ClearOperation extends PrimitiveOperation {
	private final Clear it;

	private final EmfswitchSwitchImplementation emfswitch;

	public ClearOperation(Clear it, EmfswitchSwitchImplementation emfswitch) {
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
