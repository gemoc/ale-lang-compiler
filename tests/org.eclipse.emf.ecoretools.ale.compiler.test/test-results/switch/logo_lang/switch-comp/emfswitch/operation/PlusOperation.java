package emfswitch.operation;

import emfswitch.SwitchImplementation;
import java.lang.Double;
import kmLogo.Plus;
import kmLogo.Turtle;

public class PlusOperation extends BinaryExpOperation {
	private final Plus it;

	private final SwitchImplementation emfswitch;

	public PlusOperation(Plus it, SwitchImplementation emfswitch) {
		super(it, emfswitch);
		this.it = it;
		this.emfswitch = emfswitch;
	}

	public double eval(Turtle turtle) {
		double result;
		result = ((Double) ((((ExpressionOperation) emfswitch.doSwitch(this.it.getLhs())).eval((Turtle) (turtle))) + (((ExpressionOperation) emfswitch.doSwitch(this.it.getRhs())).eval((Turtle) (turtle)))));
		return result;
	}
}
