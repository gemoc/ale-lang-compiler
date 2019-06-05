package emfswitch.emfswitch.operation;

import emfswitch.emfswitch.EmfswitchSwitchImplementation;
import kmLogo.Tan;
import kmLogo.Turtle;
import org.eclipse.emf.ecoretools.ale.core.interpreter.services.TrigoServices;

public class TanOperation extends UnaryExpressionOperation {
	private final Tan it;

	private final EmfswitchSwitchImplementation emfswitch;

	public TanOperation(Tan it, EmfswitchSwitchImplementation emfswitch) {
		super(it, emfswitch);
		this.it = it;
		this.emfswitch = emfswitch;
	}

	public double eval(Turtle turtle) {
		double result;
		result = ((double) (TrigoServices.tan((double) (((ExpressionOperation) emfswitch.doSwitch(this.it.getExpression())).eval((Turtle) (turtle))))));
		return result;
	}
}
