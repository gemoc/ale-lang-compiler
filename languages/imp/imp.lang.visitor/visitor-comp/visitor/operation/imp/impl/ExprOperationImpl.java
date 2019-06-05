package visitor.operation.imp.impl;

import imp.visitor.imp.Expr;
import imp.visitor.imp.ImpFactory;
import imp.visitor.imp.IntValue;
import imp.visitor.imp.Store;
import imp.visitor.imp.Value;
import visitor.VisitorInterface;
import visitor.operation.imp.ExprOperation;

public abstract class ExprOperationImpl implements ExprOperation {
	private final Expr it;

	private final VisitorInterface vis;

	public ExprOperationImpl(Expr it, VisitorInterface vis) {
		this.it = it;
		this.vis = vis;
	}

	public Value evaluate(Store s) {
		Value result;
		result = ((IntValue) (ImpFactory.eINSTANCE.createIntValue()));
		return result;
	}
}
