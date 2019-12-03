package emfswitch.operation;

import emfswitch.SwitchImplementation;
import java.lang.Double;
import kmLogo.Lower;
import kmLogo.Turtle;

public class LowerOperation extends BinaryExpOperation {
	private final Lower it;

	private final SwitchImplementation emfswitch;

	public LowerOperation(Lower it, SwitchImplementation emfswitch) {
		super(it, emfswitch);
		this.it = it;
		this.emfswitch = emfswitch;
	}

	public double eval(Turtle turtle) {
		double result;
		if((((ExpressionOperation) emfswitch.doSwitch(this.it.getLhs())).eval((Turtle) (turtle))) < (((ExpressionOperation) emfswitch.doSwitch(this.it.getRhs())).eval((Turtle) (turtle)))) {
			result = ((Double) (1.0));
		}
		else {
			result = ((Double) (0.0));
		}
		return result;
	}
}
