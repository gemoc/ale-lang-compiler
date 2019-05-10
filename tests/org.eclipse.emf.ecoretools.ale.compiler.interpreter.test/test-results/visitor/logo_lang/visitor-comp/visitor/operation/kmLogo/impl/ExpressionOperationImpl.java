package visitor.operation.kmLogo.impl;

import kmLogo.visitor.kmLogo.Expression;
import kmLogo.visitor.kmLogo.Turtle;
import visitor.VisitorInterface;
import visitor.operation.kmLogo.ExpressionOperation;

public abstract class ExpressionOperationImpl extends InstructionOperationImpl implements ExpressionOperation {
	private final Expression it;

	private final VisitorInterface vis;

	public ExpressionOperationImpl(Expression it, VisitorInterface vis) {
		super(it, vis);
		this.it = it;
		this.vis = vis;
	}

	public double eval(Turtle turtle) {
		double result;
		result = 0.0;
		return result;
	}
}
