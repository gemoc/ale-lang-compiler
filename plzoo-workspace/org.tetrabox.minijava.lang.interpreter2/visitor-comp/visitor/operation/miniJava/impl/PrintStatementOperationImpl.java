package visitor.operation.miniJava.impl;

import java.lang.String;
import miniJava.visitor.miniJava.PrintStatement;
import miniJava.visitor.miniJava.State;
import visitor.VisitorInterface;
import visitor.operation.miniJava.ExpressionOperation;
import visitor.operation.miniJava.PrintStatementOperation;
import visitor.operation.miniJava.StateOperation;

public class PrintStatementOperationImpl extends StatementOperationImpl implements PrintStatementOperation {
	private final PrintStatement it;

	private final VisitorInterface vis;

	public PrintStatementOperationImpl(PrintStatement it, VisitorInterface vis) {
		super(it, vis);
		this.it = it;
		this.vis = vis;
	}

	public void evaluateStatement(State state) {
		String res = ((String) (((ExpressionOperation)this.it.getExpression().accept(vis)).evaluateExpression((State) (state)).customToString()));
		((StateOperation)state.accept(vis)).println((String) (res));
	}
}
