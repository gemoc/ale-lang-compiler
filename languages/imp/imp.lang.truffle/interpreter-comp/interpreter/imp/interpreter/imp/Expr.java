package interpreter.imp.interpreter.imp;

import com.oracle.truffle.api.nodes.NodeInterface;
import org.eclipse.emf.ecore.EObject;

public interface Expr extends EObject, NodeInterface {
	Value evaluate(Store s);
}
