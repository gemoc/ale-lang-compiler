package emfswitch.emfswitch.operation;

import emfswitch.emfswitch.EmfswitchSwitchImplementation;
import java.lang.Double;
import kmLogo.Forward;
import kmLogo.Turtle;

public class ForwardOperation extends PrimitiveOperation {
	private final Forward it;

	private final EmfswitchSwitchImplementation emfswitch;

	public ForwardOperation(Forward it, EmfswitchSwitchImplementation emfswitch) {
		super(it, emfswitch);
		this.it = it;
		this.emfswitch = emfswitch;
	}

	public double eval(Turtle turtle) {
		double result;
		double move = ((double) (((ExpressionOperation) emfswitch.doSwitch(this.it.getSteps())).eval((Turtle) (turtle))));
		((TurtleOperation) emfswitch.doSwitch(turtle)).forward((double) (move));
		result = ((Double) (0.0));
		return result;
	}
}
