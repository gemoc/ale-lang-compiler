package miniJava.interpreter.miniJava;

import com.oracle.truffle.api.nodes.NodeInterface;
import org.eclipse.emf.ecore.EObject;

public interface ArrayTypeRef extends EObject, NodeInterface, TypeRef {
	SingleTypeRef getTypeRef();

	void setTypeRef(SingleTypeRef value);
}
