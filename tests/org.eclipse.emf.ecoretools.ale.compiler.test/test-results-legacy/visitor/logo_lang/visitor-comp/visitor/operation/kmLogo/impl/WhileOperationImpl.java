package visitor.operation.kmLogo.impl;

import java.lang.Double;
import kmLogo.visitor.kmLogo.Turtle;
import kmLogo.visitor.kmLogo.While;
import visitor.VisitorInterface;
import visitor.operation.kmLogo.BlockOperation;
import visitor.operation.kmLogo.ExpressionOperation;
import visitor.operation.kmLogo.WhileOperation;

public class WhileOperationImpl extends ControlStructureOperationImpl implements WhileOperation {
	private final While it;

	private final VisitorInterface vis;

	public WhileOperationImpl(While it, VisitorInterface vis) {
		super(it, vis);
		this.it = it;
		this.vis = vis;
	}

	public double eval(Turtle turtle) {
		double result;
		while ((((ExpressionOperation)this.it.getCondition().accept(vis)).eval((Turtle) (turtle))) > (0.0)) {
			((BlockOperation)this.it.getBlock().accept(vis)).eval((Turtle) (turtle));
		}
		result = ((Double) (0.0));
		return result;
	}
}
