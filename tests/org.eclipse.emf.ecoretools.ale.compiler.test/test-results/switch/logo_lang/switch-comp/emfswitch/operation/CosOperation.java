package emfswitch.operation;

import emfswitch.SwitchImplementation;
import kmLogo.Cos;
import kmLogo.Turtle;
import org.eclipse.emf.ecoretools.ale.core.interpreter.services.TrigoServices;

public class CosOperation extends UnaryExpressionOperation {
	private final Cos it;

	private final SwitchImplementation emfswitch;

	public CosOperation(Cos it, SwitchImplementation emfswitch) {
		super(it, emfswitch);
		this.it = it;
		this.emfswitch = emfswitch;
	}

	public double eval(Turtle turtle) {
		double result;
		result = TrigoServices.cosinus((double) (((ExpressionOperation) emfswitch.doSwitch(this.it.getExpression())).eval((Turtle) (turtle))));
		return result;
	}
}
