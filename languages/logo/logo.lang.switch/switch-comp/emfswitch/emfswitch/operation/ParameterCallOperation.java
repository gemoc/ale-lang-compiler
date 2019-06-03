package emfswitch.emfswitch.operation;

import emfswitch.emfswitch.EmfswitchSwitchImplementation;
import kmLogo.ParameterCall;
import kmLogo.StackFrame;
import kmLogo.Turtle;
import kmLogo.Variable;
import org.eclipse.emf.ecoretools.ale.compiler.lib.EqualService;

public class ParameterCallOperation extends ExpressionOperation {
	private final ParameterCall it;

	private final EmfswitchSwitchImplementation emfswitch;

	public ParameterCallOperation(ParameterCall it, EmfswitchSwitchImplementation emfswitch) {
		super(it, emfswitch);
		this.it = it;
		this.emfswitch = emfswitch;
	}

	public double eval(Turtle turtle) {
		double result;
		result = 0.0;
		for (StackFrame frame: turtle.getCallStack().getFrames()) {
			for (Variable var: frame.getVariables()) {
				if(EqualService.equals((var.getName()), (this.it.getParameter().getName()))) {
					result = var.getValue();
				}
			}
		}
		return result;
	}
}
