package visitor.operation.kmLogo.impl;

import kmLogo.visitor.kmLogo.Tan;
import kmLogo.visitor.kmLogo.Turtle;
import org.eclipse.emf.ecoretools.ale.core.interpreter.services.TrigoServices;
import visitor.VisitorInterface;
import visitor.operation.kmLogo.ExpressionOperation;
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
		result = TrigoServices.tan((double) (((ExpressionOperation)this.it.getExpression().accept(vis)).eval((Turtle) (turtle))));
		return result;
	}
}
