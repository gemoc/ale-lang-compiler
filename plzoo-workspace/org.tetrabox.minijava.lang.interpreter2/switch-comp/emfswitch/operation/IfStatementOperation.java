package emfswitch.operation;

import org.eclipse.emf.ecoretools.ale.compiler.lib.EqualService;

import emfswitch.SwitchImplementation;
import miniJava.BooleanValue;
import miniJava.IfStatement;
import miniJava.State;

public class IfStatementOperation extends StatementOperation {
	private final IfStatement it;

	private final SwitchImplementation emfswitch;

	public IfStatementOperation(IfStatement it, SwitchImplementation emfswitch) {
		super(it, emfswitch);
		this.it = it;
		this.emfswitch = emfswitch;
	}

	public void evaluateStatement(State state) {
		BooleanValue booleanValue = ((BooleanValue) (((BooleanValue) (((ExpressionOperation) emfswitch.doSwitch(this.it.getExpression())).evaluateExpression((State) (state))))));
		if(booleanValue.isValue()) {
			((BlockOperation) emfswitch.doSwitch(this.it.getThenBlock())).evaluateStatement((State) (state));
		}
		else {
			if(!EqualService.equals((this.it.getElseBlock()), (null))) {
				((BlockOperation) emfswitch.doSwitch(this.it.getElseBlock())).evaluateStatement((State) (state));
			}
		}
	}
}
