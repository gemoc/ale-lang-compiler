package visitor.operation.kmLogo.impl;

import kmLogo.visitor.kmLogo.Cos;
import kmLogo.visitor.kmLogo.Turtle;
import visitor.VisitorInterface;
import visitor.operation.kmLogo.CosOperation;

public class CosOperationImpl extends UnaryExpressionOperationImpl implements CosOperation {
	private final Cos it;

	private final VisitorInterface vis;

	public CosOperationImpl(Cos it, VisitorInterface vis) {
		super(it, vis);
		this.it = it;
		this.vis = vis;
	}

	public double eval(Turtle turtle) {
		double result;
		result = org.eclipse.emf.ecoretools.ale.core.interpreter.services.TrigoServices.cosinus(((visitor.operation.kmLogo.ExpressionOperation)this.it.getExpression().accept(vis)).eval((kmLogo.visitor.kmLogo.Turtle) (turtle)));
		return result;
	}
}
