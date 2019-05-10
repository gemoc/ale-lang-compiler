package emfswitch.operation;

import emfswitch.SwitchImplementation;
import kmLogo.Expression;
import kmLogo.Turtle;

public class ExpressionOperation extends InstructionOperation {
	private final Expression it;

	private final SwitchImplementation emfswitch;

	public ExpressionOperation(Expression it, SwitchImplementation emfswitch) {
		super(it, emfswitch);
		this.it = it;
		this.emfswitch = emfswitch;
	}

	public double eval(Turtle turtle) {
		double result;
		result = 0.0;
		return result;
	}
}
