package visitor.operation.miniJava.impl;

import miniJava.visitor.miniJava.State;
import miniJava.visitor.miniJava.SymbolRef;
import miniJava.visitor.miniJava.Value;
import visitor.VisitorInterface;
import visitor.operation.miniJava.SymbolRefOperation;

public class SymbolRefOperationImpl extends ExpressionOperationImpl implements SymbolRefOperation {
	private final SymbolRef it;

	private final VisitorInterface vis;

	public SymbolRefOperationImpl(SymbolRef it, VisitorInterface vis) {
		super(it, vis);
		this.it = it;
		this.vis = vis;
	}

	public Value evaluateExpression(State state) {
		Value result;
		result = ((visitor.operation.miniJava.ContextOperation)((visitor.operation.miniJava.StateOperation)state.accept(vis)).findCurrentContext().accept(vis)).findBinding((org.eclipse.acceleo.query.runtime.impl.Nothing) (this.it.getSymbol())).getValue().copyj();
		return result;
	}
}
