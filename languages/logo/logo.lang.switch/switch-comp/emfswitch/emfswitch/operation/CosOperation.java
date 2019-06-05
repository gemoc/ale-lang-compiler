package emfswitch.emfswitch.operation;

import emfswitch.emfswitch.EmfswitchSwitchImplementation;
import kmLogo.Cos;
import kmLogo.Turtle;
import org.eclipse.emf.ecoretools.ale.core.interpreter.services.TrigoServices;

public class CosOperation extends UnaryExpressionOperation {
	private final Cos it;

	private final EmfswitchSwitchImplementation emfswitch;

	public CosOperation(Cos it, EmfswitchSwitchImplementation emfswitch) {
		super(it, emfswitch);
		this.it = it;
		this.emfswitch = emfswitch;
	}

	public double eval(Turtle turtle) {
		double result;
		result = ((double) (TrigoServices.cosinus((double) (((ExpressionOperation) emfswitch.doSwitch(this.it.getExpression())).eval((Turtle) (turtle))))));
		return result;
	}
}
