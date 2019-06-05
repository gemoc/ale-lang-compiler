package visitor.operation.imp.impl;

import imp.visitor.imp.ImpFactory;
import imp.visitor.imp.IntConst;
import imp.visitor.imp.IntValue;
import imp.visitor.imp.Store;
import imp.visitor.imp.Value;
import visitor.VisitorInterface;
import visitor.operation.imp.IntConstOperation;

public class IntConstOperationImpl extends ExprOperationImpl implements IntConstOperation {
	private final IntConst it;

	private final VisitorInterface vis;

	public IntConstOperationImpl(IntConst it, VisitorInterface vis) {
		super(it, vis);
		this.it = it;
		this.vis = vis;
	}

	public Value evaluate(Store s) {
		Value result;
		IntValue tmp = ((IntValue) (ImpFactory.eINSTANCE.createIntValue()));
		tmp.setValue(this.it.getValue());
		result = ((IntValue) (tmp));
		return result;
	}
}
