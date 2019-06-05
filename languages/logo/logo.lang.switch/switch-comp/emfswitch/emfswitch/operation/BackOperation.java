package emfswitch.emfswitch.operation;

import emfswitch.emfswitch.EmfswitchSwitchImplementation;
import java.lang.Double;
import kmLogo.Back;
import kmLogo.Turtle;

public class BackOperation extends PrimitiveOperation {
	private final Back it;

	private final EmfswitchSwitchImplementation emfswitch;

	public BackOperation(Back it, EmfswitchSwitchImplementation emfswitch) {
		super(it, emfswitch);
		this.it = it;
		this.emfswitch = emfswitch;
	}

	public double eval(Turtle turtle) {
		double result;
		double move = ((double) (((ExpressionOperation) emfswitch.doSwitch(this.it.getSteps())).eval((Turtle) (turtle))));
		((TurtleOperation) emfswitch.doSwitch(turtle)).forward((Double) (-(move)));
		result = ((Double) (0.0));
		return result;
	}
}
