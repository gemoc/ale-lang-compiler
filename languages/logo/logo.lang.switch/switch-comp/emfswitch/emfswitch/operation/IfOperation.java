package emfswitch.emfswitch.operation;

import emfswitch.emfswitch.EmfswitchSwitchImplementation;
import java.lang.Double;
import kmLogo.If;
import kmLogo.Turtle;
import org.eclipse.emf.ecoretools.ale.compiler.lib.EqualService;

public class IfOperation extends ControlStructureOperation {
	private final If it;

	private final EmfswitchSwitchImplementation emfswitch;

	public IfOperation(If it, EmfswitchSwitchImplementation emfswitch) {
		super(it, emfswitch);
		this.it = it;
		this.emfswitch = emfswitch;
	}

	public double eval(Turtle turtle) {
		double result;
		if(!EqualService.equals((((ExpressionOperation) emfswitch.doSwitch(this.it.getCondition())).eval((Turtle) (turtle))), (0.0))) {
			result = ((double) (((BlockOperation) emfswitch.doSwitch(this.it.getThenPart())).eval((Turtle) (turtle))));
		}
		else {
			if(!EqualService.equals((this.it.getElsePart()), (null))) {
				result = ((double) (((BlockOperation) emfswitch.doSwitch(this.it.getElsePart())).eval((Turtle) (turtle))));
			}
			else {
				result = ((Double) (0.0));
			}
		}
		return result;
	}
}
