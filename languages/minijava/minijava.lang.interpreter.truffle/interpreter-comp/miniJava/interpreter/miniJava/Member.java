package miniJava.interpreter.miniJava;

import com.oracle.truffle.api.nodes.NodeInterface;
import org.eclipse.emf.ecore.EObject;

public interface Member extends EObject, NodeInterface, TypedDeclaration {
	AccessLevel getAccess();

	void setAccess(AccessLevel value);
}
