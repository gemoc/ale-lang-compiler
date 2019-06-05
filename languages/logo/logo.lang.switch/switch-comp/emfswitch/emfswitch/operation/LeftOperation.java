package emfswitch.emfswitch.operation;

import emfswitch.emfswitch.EmfswitchSwitchImplementation;
import java.lang.Double;
import kmLogo.Left;
import kmLogo.Turtle;

public class LeftOperation extends PrimitiveOperation {
	private final Left it;

	private final EmfswitchSwitchImplementation emfswitch;

	public LeftOperation(Left it, EmfswitchSwitchImplementation emfswitch) {
		super(it, emfswitch);
		this.it = it;
		this.emfswitch = emfswitch;
	}

	public double eval(Turtle turtle) {
		double result;
		double angle = ((double) (((ExpressionOperation) emfswitch.doSwitch(this.it.getAngle())).eval((Turtle) (turtle))));
		((TurtleOperation) emfswitch.doSwitch(turtle)).rotate((double) (angle));
		result = ((Double) (0.0));
		return result;
	}
}
