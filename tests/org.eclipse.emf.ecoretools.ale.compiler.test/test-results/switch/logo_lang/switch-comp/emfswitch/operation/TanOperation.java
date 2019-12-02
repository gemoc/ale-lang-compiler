package emfswitch.operation;

import emfswitch.SwitchImplementation;
import kmLogo.Tan;
import kmLogo.Turtle;
import org.eclipse.emf.ecoretools.ale.core.interpreter.services.TrigoServices;

public class TanOperation extends UnaryExpressionOperation {
	private final Tan it;

	private final SwitchImplementation emfswitch;

	public TanOperation(Tan it, SwitchImplementation emfswitch) {
		super(it, emfswitch);
		this.it = it;
		this.emfswitch = emfswitch;
	}

	public double eval(Turtle turtle) {
		double result;
		result = TrigoServices.tan((double) (((ExpressionOperation) emfswitch.doSwitch(this.it.getExpression())).eval((Turtle) (turtle))));
		return result;
	}
}
