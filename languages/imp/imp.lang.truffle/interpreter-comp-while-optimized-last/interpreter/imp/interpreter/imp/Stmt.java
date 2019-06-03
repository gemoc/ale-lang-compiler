package interpreter.imp.interpreter.imp;

import com.oracle.truffle.api.nodes.NodeInterface;
import org.eclipse.emf.ecore.EObject;

public interface Stmt extends EObject, NodeInterface {
  Store execute(Store s);
}
