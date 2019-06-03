package emfswitch.emfswitch.operation;

import emfswitch.emfswitch.EmfswitchSwitchImplementation;
import kmLogo.Greater;
import kmLogo.Turtle;

public class GreaterOperation extends BinaryExpOperation {
	private final Greater it;

	private final EmfswitchSwitchImplementation emfswitch;

	public GreaterOperation(Greater it, EmfswitchSwitchImplementation emfswitch) {
		super(it, emfswitch);
		this.it = it;
		this.emfswitch = emfswitch;
	}

	public double eval(Turtle turtle) {
		double result;
		if((((ExpressionOperation) emfswitch.doSwitch(this.it.getLhs())).eval((Turtle) (turtle))) > (((ExpressionOperation) emfswitch.doSwitch(this.it.getRhs())).eval((Turtle) (turtle)))) {
			result = 1.0;
		}
		else {
			result = 0.0;
		}
		return result;
	}
}
