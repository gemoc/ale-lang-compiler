package emfswitch.operation;

import emfswitch.SwitchImplementation;
import kmLogo.Sin;
import kmLogo.Turtle;
import org.eclipse.emf.ecoretools.ale.core.interpreter.services.TrigoServices;

public class SinOperation extends UnaryExpressionOperation {
	private final Sin it;

	private final SwitchImplementation emfswitch;

	public SinOperation(Sin it, SwitchImplementation emfswitch) {
		super(it, emfswitch);
		this.it = it;
		this.emfswitch = emfswitch;
	}

	public double eval(Turtle turtle) {
		double result;
		result = ((double) (TrigoServices.sinus((double) (((ExpressionOperation) emfswitch.doSwitch(this.it.getExpression())).eval((Turtle) (turtle))))));
		return result;
	}
}
