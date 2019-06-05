package visitor.operation.imp.impl;

import imp.visitor.imp.Store;
import imp.visitor.imp.Value;
import imp.visitor.imp.Var;
import java.lang.String;
import visitor.VisitorInterface;
import visitor.operation.imp.VarOperation;

public class VarOperationImpl extends ExprOperationImpl implements VarOperation {
	private final Var it;

	private final VisitorInterface vis;

	public VarOperationImpl(Var it, VisitorInterface vis) {
		super(it, vis);
		this.it = it;
		this.vis = vis;
	}

	public Value evaluate(Store s) {
		Value result;
		result = ((Value) (s.getValues().get((String) (this.it.getName()))));
		return result;
	}
}
