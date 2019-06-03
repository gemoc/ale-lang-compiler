package visitor.operation.kmLogo.impl;

import kmLogo.visitor.kmLogo.If;
import kmLogo.visitor.kmLogo.Turtle;
import org.eclipse.emf.ecoretools.ale.compiler.lib.EqualService;
import visitor.VisitorInterface;
import visitor.operation.kmLogo.BlockOperation;
import visitor.operation.kmLogo.ExpressionOperation;
import visitor.operation.kmLogo.IfOperation;

public class IfOperationImpl extends ControlStructureOperationImpl implements IfOperation {
	private final If it;

	private final VisitorInterface vis;

	public IfOperationImpl(If it, VisitorInterface vis) {
		super(it, vis);
		this.it = it;
		this.vis = vis;
	}

	public double eval(Turtle turtle) {
		double result;
		if(!EqualService.equals((((ExpressionOperation)this.it.getCondition().accept(vis)).eval((Turtle) (turtle))), (0.0))) {
			result = ((BlockOperation)this.it.getThenPart().accept(vis)).eval((Turtle) (turtle));
		}
		else {
			if(!EqualService.equals((this.it.getElsePart()), (null))) {
				result = ((BlockOperation)this.it.getElsePart().accept(vis)).eval((Turtle) (turtle));
			}
			else {
				result = 0.0;
			}
		}
		return result;
	}
}
