package visitor.operation.imp.impl;

import imp.visitor.imp.BoolValue;
import imp.visitor.imp.Store;
import imp.visitor.imp.Value;
import imp.visitor.imp.While;
import java.lang.Boolean;
import visitor.VisitorInterface;
import visitor.operation.imp.ExprOperation;
import visitor.operation.imp.StmtOperation;
import visitor.operation.imp.WhileOperation;

public class WhileOperationImpl extends StmtOperationImpl implements WhileOperation {
	private final While it;

	private final VisitorInterface vis;

	public WhileOperationImpl(While it, VisitorInterface vis) {
		super(it, vis);
		this.it = it;
		this.vis = vis;
	}

	public Store execute(Store s) {
		Store result;
		boolean stop = ((boolean) (false));
		Store tmp = ((Store) (s));
		while (!(stop)) {
			Value conde = ((Value) (((ExprOperation)this.it.getCond().accept(vis)).evaluate((Store) (s))));
			if(conde instanceof BoolValue) {
				BoolValue condeb = ((BoolValue) (conde));
				if(condeb.isValue()) {
					tmp = ((Store) (((StmtOperation)this.it.getBody().accept(vis)).execute((Store) (tmp))));
				}
				else {
					stop = ((Boolean) (true));
				}
			}
			else {
				stop = ((Boolean) (true));
			}
		}
		result = ((Store) (tmp));
		return result;
	}
}
