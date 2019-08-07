package miniJava.interpreter.miniJava;

import com.oracle.truffle.api.nodes.NodeInterface;
import org.eclipse.emf.ecore.EObject;

public interface Field extends EObject, NodeInterface, Member {
	Expression getDefaultValue();

	void setDefaultValue(Expression value);
}
