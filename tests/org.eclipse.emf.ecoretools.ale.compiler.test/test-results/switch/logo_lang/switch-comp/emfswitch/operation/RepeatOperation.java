package emfswitch.operation;

import emfswitch.SwitchImplementation;
import kmLogo.Repeat;
import kmLogo.Turtle;

public class RepeatOperation extends ControlStructureOperation {
	private final Repeat it;

	private final SwitchImplementation emfswitch;

	public RepeatOperation(Repeat it, SwitchImplementation emfswitch) {
		super(it, emfswitch);
		this.it = it;
		this.emfswitch = emfswitch;
	}

	public double eval(Turtle turtle) {
		double result;
		double time = ((double) (((ExpressionOperation) emfswitch.doSwitch(this.it.getCondition())).eval((Turtle) turtle)));
		while ((time) > (0.0)) {
			((BlockOperation) emfswitch.doSwitch(this.it.getBlock())).eval((Turtle) turtle);
			time = (time) - (1.0);
		}
		result = 0.0;
		return result;
	}
}
