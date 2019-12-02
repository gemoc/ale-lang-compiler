package visitor.operation.kmLogo.impl;

import java.lang.Double;
import kmLogo.visitor.kmLogo.Back;
import kmLogo.visitor.kmLogo.Turtle;
import visitor.VisitorInterface;
import visitor.operation.kmLogo.BackOperation;
import visitor.operation.kmLogo.ExpressionOperation;
import visitor.operation.kmLogo.TurtleOperation;

public class BackOperationImpl extends PrimitiveOperationImpl implements BackOperation {
	private final Back it;

	private final VisitorInterface vis;

	public BackOperationImpl(Back it, VisitorInterface vis) {
		super(it, vis);
		this.it = it;
		this.vis = vis;
	}

	public double eval(Turtle turtle) {
		double result;
		double move = ((double) (((ExpressionOperation)this.it.getSteps().accept(vis)).eval((Turtle) (turtle))));
		((TurtleOperation)turtle.accept(vis)).forward((Double) (-(move)));
		result = 0.0;
		return result;
	}
}
