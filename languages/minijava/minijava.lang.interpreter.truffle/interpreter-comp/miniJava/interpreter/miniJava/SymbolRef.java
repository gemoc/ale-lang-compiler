package miniJava.interpreter.miniJava;

import com.oracle.truffle.api.nodes.NodeInterface;
import org.eclipse.emf.ecore.EObject;

public interface SymbolRef extends EObject, NodeInterface, Expression {
	Symbol getSymbol();

	void setSymbol(Symbol value);

	Value evaluateExpression(State state);
}
