package emfswitch.operation;

import emfswitch.SwitchImplementation;
import kmLogo.Constant;
import kmLogo.Turtle;

public class ConstantOperation extends ExpressionOperation {
	private final Constant it;

	private final SwitchImplementation emfswitch;

	public ConstantOperation(Constant it, SwitchImplementation emfswitch) {
		super(it, emfswitch);
		this.it = it;
		this.emfswitch = emfswitch;
	}

	public double eval(Turtle turtle) {
		double result;
		result = ((double) (this.it.getValue()));
		return result;
	}
}
