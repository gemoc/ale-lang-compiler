package emfswitch.emfswitch.operation;

import emfswitch.emfswitch.EmfswitchSwitchImplementation;
import java.lang.Double;
import kmLogo.Right;
import kmLogo.Turtle;

public class RightOperation extends PrimitiveOperation {
	private final Right it;

	private final EmfswitchSwitchImplementation emfswitch;

	public RightOperation(Right it, EmfswitchSwitchImplementation emfswitch) {
		super(it, emfswitch);
		this.it = it;
		this.emfswitch = emfswitch;
	}

	public double eval(Turtle turtle) {
		double result;
		double angle = ((double) (((ExpressionOperation) emfswitch.doSwitch(this.it.getAngle())).eval((Turtle) (turtle))));
		((TurtleOperation) emfswitch.doSwitch(turtle)).rotate((Double) (-(angle)));
		result = ((Double) (0.0));
		return result;
	}
}
