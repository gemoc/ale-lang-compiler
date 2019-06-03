package visitor.operation.kmLogo.impl;

import kmLogo.visitor.kmLogo.ParameterCall;
import kmLogo.visitor.kmLogo.StackFrame;
import kmLogo.visitor.kmLogo.Turtle;
import kmLogo.visitor.kmLogo.Variable;
import org.eclipse.emf.ecoretools.ale.compiler.lib.EqualService;
import visitor.VisitorInterface;
import visitor.operation.kmLogo.ParameterCallOperation;

public class ParameterCallOperationImpl extends ExpressionOperationImpl implements ParameterCallOperation {
	private final ParameterCall it;

	private final VisitorInterface vis;

	public ParameterCallOperationImpl(ParameterCall it, VisitorInterface vis) {
		super(it, vis);
		this.it = it;
		this.vis = vis;
	}

	public double eval(Turtle turtle) {
		double result;
		result = 0.0;
		for(StackFrame frame: turtle.getCallStack().getFrames()) {
			for(Variable var: frame.getVariables()) {
				if(EqualService.equals((var.getName()), (this.it.getParameter().getName()))) {
					result = var.getValue();
				}
			}
		}
		return result;
	}
}
