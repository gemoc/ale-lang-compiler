package emfswitch.operation;

import emfswitch.SwitchImplementation;
import java.lang.Double;
import kmLogo.Turtle;
import kmLogo.While;

public class WhileOperation extends ControlStructureOperation {
	private final While it;

	private final SwitchImplementation emfswitch;

	public WhileOperation(While it, SwitchImplementation emfswitch) {
		super(it, emfswitch);
		this.it = it;
		this.emfswitch = emfswitch;
	}

	public double eval(Turtle turtle) {
		double result;
		while ((((ExpressionOperation) emfswitch.doSwitch(this.it.getCondition())).eval((Turtle) (turtle))) > (0.0)) {
			((BlockOperation) emfswitch.doSwitch(this.it.getBlock())).eval((Turtle) (turtle));
		}
		result = ((Double) (0.0));
		return result;
	}
}
