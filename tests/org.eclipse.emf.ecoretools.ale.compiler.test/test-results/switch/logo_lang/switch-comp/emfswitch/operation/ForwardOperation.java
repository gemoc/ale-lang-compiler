package emfswitch.operation;

import emfswitch.SwitchImplementation;
import kmLogo.Forward;
import kmLogo.Turtle;

public class ForwardOperation extends PrimitiveOperation {
	private final Forward it;

	private final SwitchImplementation emfswitch;

	public ForwardOperation(Forward it, SwitchImplementation emfswitch) {
		super(it, emfswitch);
		this.it = it;
		this.emfswitch = emfswitch;
	}

	public double eval(Turtle turtle) {
		double result;
		double move = ((double) (((ExpressionOperation) emfswitch.doSwitch(this.it.getSteps())).eval((Turtle) turtle)));
		((TurtleOperation) emfswitch.doSwitch(turtle)).forward((double) move);
		result = 0.0;
		return result;
	}
}
