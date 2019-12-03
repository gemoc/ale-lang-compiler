package emfswitch.operation;

import emfswitch.SwitchImplementation;
import miniJava.State;
import miniJava.Symbol;
import miniJava.SymbolRef;
import miniJava.Value;

public class SymbolRefOperation extends ExpressionOperation {
	private final SymbolRef it;

	private final SwitchImplementation emfswitch;

	public SymbolRefOperation(SymbolRef it, SwitchImplementation emfswitch) {
		super(it, emfswitch);
		this.it = it;
		this.emfswitch = emfswitch;
	}

	public Value evaluateExpression(State state) {
		Value result;
		result = ((Value) (((ValueOperation) emfswitch.doSwitch(((ContextOperation) emfswitch.doSwitch(((StateOperation) emfswitch.doSwitch(state)).findCurrentContext())).findBinding((Symbol) (this.it.getSymbol())).getValue())).copyj()));
		return result;
	}
}
