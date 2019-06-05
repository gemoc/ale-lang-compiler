package emfswitch.emfswitch.operation;

import emfswitch.emfswitch.EmfswitchSwitchImplementation;
import java.lang.Double;
import kmLogo.Div;
import kmLogo.Turtle;
import org.eclipse.emf.ecoretools.ale.compiler.lib.EqualService;

public class DivOperation extends BinaryExpOperation {
	private final Div it;

	private final EmfswitchSwitchImplementation emfswitch;

	public DivOperation(Div it, EmfswitchSwitchImplementation emfswitch) {
		super(it, emfswitch);
		this.it = it;
		this.emfswitch = emfswitch;
	}

	public double eval(Turtle turtle) {
		double result;
		if(!EqualService.equals((((ExpressionOperation) emfswitch.doSwitch(this.it.getRhs())).eval((Turtle) (turtle))), (0.0))) {
			result = ((Double) ((((ExpressionOperation) emfswitch.doSwitch(this.it.getLhs())).eval((Turtle) (turtle))) / (((ExpressionOperation) emfswitch.doSwitch(this.it.getRhs())).eval((Turtle) (turtle)))));
		}
		else {
			result = ((Double) (0.0));
		}
		return result;
	}
}
