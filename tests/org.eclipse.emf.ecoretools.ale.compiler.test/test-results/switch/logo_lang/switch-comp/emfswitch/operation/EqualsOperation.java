package emfswitch.operation;

import emfswitch.SwitchImplementation;
import java.lang.Double;
import kmLogo.Equals;
import kmLogo.Turtle;
import org.eclipse.emf.ecoretools.ale.compiler.lib.EqualService;

public class EqualsOperation extends BinaryExpOperation {
	private final Equals it;

	private final SwitchImplementation emfswitch;

	public EqualsOperation(Equals it, SwitchImplementation emfswitch) {
		super(it, emfswitch);
		this.it = it;
		this.emfswitch = emfswitch;
	}

	public double eval(Turtle turtle) {
		double result;
		if(EqualService.equals((((ExpressionOperation) emfswitch.doSwitch(this.it.getLhs())).eval((Turtle) (turtle))), (((ExpressionOperation) emfswitch.doSwitch(this.it.getRhs())).eval((Turtle) (turtle))))) {
			result = ((Double) (1.0));
		}
		else {
			result = ((Double) (0.0));
		}
		return result;
	}
}
