package visitor.operation.kmLogo.impl;

import kmLogo.visitor.kmLogo.Tan;
import kmLogo.visitor.kmLogo.Turtle;
import visitor.VisitorInterface;
import visitor.operation.kmLogo.TanOperation;

public class TanOperationImpl extends UnaryExpressionOperationImpl implements TanOperation {
	private final Tan it;

	private final VisitorInterface vis;

	public TanOperationImpl(Tan it, VisitorInterface vis) {
		super(it, vis);
		this.it = it;
		this.vis = vis;
	}

	public double eval(Turtle turtle) {
		double result;
		result = org.eclipse.emf.ecoretools.ale.core.interpreter.services.TrigoServices.tan(((visitor.operation.kmLogo.ExpressionOperation)this.it.getExpression().accept(vis)).eval((kmLogo.visitor.kmLogo.Turtle) (turtle)));
		return result;
	}
}
