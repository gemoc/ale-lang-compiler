package visitor.operation.imp.impl;

import imp.visitor.imp.Assign;
import imp.visitor.imp.Store;
import imp.visitor.imp.Value;
import java.lang.String;
import visitor.VisitorInterface;
import visitor.operation.imp.AssignOperation;
import visitor.operation.imp.ExprOperation;

public class AssignOperationImpl extends StmtOperationImpl implements AssignOperation {
	private final Assign it;

	private final VisitorInterface vis;

	public AssignOperationImpl(Assign it, VisitorInterface vis) {
		super(it, vis);
		this.it = it;
		this.vis = vis;
	}

	public Store execute(Store s) {
		Store result;
		s.getValues().put((String) (this.it.getName()), (Value) (((ExprOperation)this.it.getExp().accept(vis)).evaluate((Store) (s))));
		result = ((Store) (s));
		return result;
	}
}
