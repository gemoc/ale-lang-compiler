package emfswitch.emfswitch.operation;

import emfswitch.emfswitch.EmfswitchSwitchImplementation;
import kmLogo.Lower;
import kmLogo.Turtle;

public class LowerOperation extends BinaryExpOperation {
	private final Lower it;

	private final EmfswitchSwitchImplementation emfswitch;

	public LowerOperation(Lower it, EmfswitchSwitchImplementation emfswitch) {
		super(it, emfswitch);
		this.it = it;
		this.emfswitch = emfswitch;
	}

	public double eval(Turtle turtle) {
		double result;
		if((((ExpressionOperation) emfswitch.doSwitch(this.it.getLhs())).eval((Turtle) (turtle))) < (((ExpressionOperation) emfswitch.doSwitch(this.it.getRhs())).eval((Turtle) (turtle)))) {
			result = 1.0;
		}
		else {
			result = 0.0;
		}
		return result;
	}
}
