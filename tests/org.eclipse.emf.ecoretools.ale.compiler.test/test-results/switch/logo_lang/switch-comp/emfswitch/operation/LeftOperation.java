package emfswitch.operation;

import emfswitch.SwitchImplementation;
import java.lang.Double;
import kmLogo.Left;
import kmLogo.Turtle;

public class LeftOperation extends PrimitiveOperation {
	private final Left it;

	private final SwitchImplementation emfswitch;

	public LeftOperation(Left it, SwitchImplementation emfswitch) {
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
