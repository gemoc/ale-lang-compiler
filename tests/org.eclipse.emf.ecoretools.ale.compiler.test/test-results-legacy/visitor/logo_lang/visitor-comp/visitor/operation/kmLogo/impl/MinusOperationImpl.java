package visitor.operation.kmLogo.impl;

import java.lang.Double;
import kmLogo.visitor.kmLogo.Minus;
import kmLogo.visitor.kmLogo.Turtle;
import visitor.VisitorInterface;
import visitor.operation.kmLogo.ExpressionOperation;
import visitor.operation.kmLogo.MinusOperation;

public class MinusOperationImpl extends BinaryExpOperationImpl implements MinusOperation {
	private final Minus it;

	private final VisitorInterface vis;

	public MinusOperationImpl(Minus it, VisitorInterface vis) {
		super(it, vis);
		this.it = it;
		this.vis = vis;
	}

	public double eval(Turtle turtle) {
		double result;
		result = ((Double) ((((ExpressionOperation)this.it.getLhs().accept(vis)).eval((Turtle) (turtle))) - (((ExpressionOperation)this.it.getRhs().accept(vis)).eval((Turtle) (turtle)))));
		return result;
	}
}
