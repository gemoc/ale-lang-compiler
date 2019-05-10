package emfswitch.operation;

import emfswitch.SwitchImplementation;
import java.lang.Double;
import kmLogo.Right;
import kmLogo.Turtle;

public class RightOperation extends PrimitiveOperation {
	private final Right it;

	private final SwitchImplementation emfswitch;

	public RightOperation(Right it, SwitchImplementation emfswitch) {
		super(it, emfswitch);
		this.it = it;
		this.emfswitch = emfswitch;
	}

	public double eval(Turtle turtle) {
		double result;
		double angle = ((double) (((ExpressionOperation) emfswitch.doSwitch(this.it.getAngle())).eval((Turtle) turtle)));
		((TurtleOperation) emfswitch.doSwitch(turtle)).rotate((Double) (-(angle)));
		result = 0.0;
		return result;
	}
}
