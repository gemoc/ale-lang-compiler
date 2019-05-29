package visitor.operation.miniJava.impl;

import java.lang.String;
import miniJava.visitor.miniJava.PrintStatement;
import miniJava.visitor.miniJava.State;
import org.eclipse.acceleo.query.runtime.impl.Nothing;
import visitor.VisitorInterface;
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
		String res = ((String) (((visitor.operation.miniJava.ExpressionOperation)this.it.getExpression().accept(vis)).evaluateExpression((miniJava.visitor.miniJava.State) (state)).customToString()));
		((StateOperation)state.accept(vis)).println((Nothing) (res));
	}
}
