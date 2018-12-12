package interpreter.imp.interpreter.imp;

import com.oracle.truffle.api.nodes.NodeInterface;
import org.eclipse.emf.ecore.EObject;

public interface Skip extends EObject, NodeInterface, Stmt {
  Store execute(Store s);
}
