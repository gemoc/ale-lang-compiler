package emfswitch.operation;

import emfswitch.SwitchImplementation;
import kmLogo.Minus;
import kmLogo.Turtle;

public class MinusOperation extends BinaryExpOperation {
	private final Minus it;

	private final SwitchImplementation emfswitch;

	public MinusOperation(Minus it, SwitchImplementation emfswitch) {
		super(it, emfswitch);
		this.it = it;
		this.emfswitch = emfswitch;
	}

	public double eval(Turtle turtle) {
		double result;
		result = (((ExpressionOperation) emfswitch.doSwitch(this.it.getLhs())).eval((Turtle) turtle)) - (((ExpressionOperation) emfswitch.doSwitch(this.it.getRhs())).eval((Turtle) turtle));
		return result;
	}
}
