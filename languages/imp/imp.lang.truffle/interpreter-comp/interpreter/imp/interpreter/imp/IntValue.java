package interpreter.imp.interpreter.imp;

import com.oracle.truffle.api.nodes.NodeInterface;
import org.eclipse.emf.ecore.EObject;

public interface IntValue extends EObject, NodeInterface, Value {
	int getValue();

	void setValue(int value);
}
