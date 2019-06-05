package visitor.operation.imp.impl;

import imp.visitor.imp.BoolValue;
import imp.visitor.imp.If;
import imp.visitor.imp.Store;
import imp.visitor.imp.Value;
import visitor.VisitorInterface;
import visitor.operation.imp.ExprOperation;
import visitor.operation.imp.IfOperation;
import visitor.operation.imp.StmtOperation;

public class IfOperationImpl extends StmtOperationImpl implements IfOperation {
	private final If it;

	private final VisitorInterface vis;

	public IfOperationImpl(If it, VisitorInterface vis) {
		super(it, vis);
		this.it = it;
		this.vis = vis;
	}

	public Store execute(Store s) {
		Store result;
		Value conde = ((Value) (((ExprOperation)this.it.getCond().accept(vis)).evaluate((Store) (s))));
		result = ((Store) (s));
		if(conde instanceof BoolValue) {
			BoolValue condeb = ((BoolValue) (conde));
			if(condeb.isValue()) {
				result = ((Store) (((StmtOperation)this.it.getLhs().accept(vis)).execute((Store) (s))));
			}
			else {
				result = ((Store) (((StmtOperation)this.it.getRhs().accept(vis)).execute((Store) (s))));
			}
		}
		return result;
	}
}
