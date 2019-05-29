package visitor.operation.miniJava.impl;

import miniJava.visitor.miniJava.Return;
import miniJava.visitor.miniJava.State;
import miniJava.visitor.miniJava.Value;
import visitor.VisitorInterface;
import visitor.operation.miniJava.ExpressionOperation;
import visitor.operation.miniJava.ReturnOperation;

public class ReturnOperationImpl extends StatementOperationImpl implements ReturnOperation {
	private final Return it;

	private final VisitorInterface vis;

	public ReturnOperationImpl(Return it, VisitorInterface vis) {
		super(it, vis);
		this.it = it;
		this.vis = vis;
	}

	public void evaluateStatement(State state) {
		Value value = ((Value) (((ExpressionOperation)this.it.getExpression().accept(vis)).evaluateExpression((State) (state))));
		((visitor.operation.miniJava.StateOperation)state.accept(vis)).findCurrentFrame().setReturnValue(value);
	}
}
