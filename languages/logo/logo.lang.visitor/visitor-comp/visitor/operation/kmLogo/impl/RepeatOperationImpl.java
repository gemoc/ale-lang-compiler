package visitor.operation.kmLogo.impl;

import java.lang.Double;
import kmLogo.visitor.kmLogo.Repeat;
import kmLogo.visitor.kmLogo.Turtle;
import visitor.VisitorInterface;
import visitor.operation.kmLogo.BlockOperation;
import visitor.operation.kmLogo.ExpressionOperation;
import visitor.operation.kmLogo.RepeatOperation;

public class RepeatOperationImpl extends ControlStructureOperationImpl implements RepeatOperation {
	private final Repeat it;

	private final VisitorInterface vis;

	public RepeatOperationImpl(Repeat it, VisitorInterface vis) {
		super(it, vis);
		this.it = it;
		this.vis = vis;
	}

	public double eval(Turtle turtle) {
		double result;
		double time = ((double) (((ExpressionOperation)this.it.getCondition().accept(vis)).eval((Turtle) (turtle))));
		while ((time) > (0.0)) {
			((BlockOperation)this.it.getBlock().accept(vis)).eval((Turtle) (turtle));
			time = ((Double) ((time) - (1.0)));
		}
		result = ((Double) (0.0));
		return result;
	}
}
