package visitor.operation.kmLogo.impl;

import kmLogo.visitor.kmLogo.Cos;
import kmLogo.visitor.kmLogo.Turtle;
import org.eclipse.emf.ecoretools.ale.core.interpreter.services.TrigoServices;
import visitor.VisitorInterface;
import visitor.operation.kmLogo.CosOperation;
import visitor.operation.kmLogo.ExpressionOperation;

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
		result = ((double) (TrigoServices.cosinus((double) (((ExpressionOperation)this.it.getExpression().accept(vis)).eval((Turtle) (turtle))))));
		return result;
	}
}
