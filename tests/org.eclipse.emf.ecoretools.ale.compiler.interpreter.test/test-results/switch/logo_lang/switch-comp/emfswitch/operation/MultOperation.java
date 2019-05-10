package emfswitch.operation;

import emfswitch.SwitchImplementation;
import kmLogo.Mult;
import kmLogo.Turtle;

public class MultOperation extends BinaryExpOperation {
	private final Mult it;

	private final SwitchImplementation emfswitch;

	public MultOperation(Mult it, SwitchImplementation emfswitch) {
		super(it, emfswitch);
		this.it = it;
		this.emfswitch = emfswitch;
	}

	public double eval(Turtle turtle) {
		double result;
		result = (((ExpressionOperation) emfswitch.doSwitch(this.it.getLhs())).eval((Turtle) turtle)) * (((ExpressionOperation) emfswitch.doSwitch(this.it.getRhs())).eval((Turtle) turtle));
		return result;
	}
}
