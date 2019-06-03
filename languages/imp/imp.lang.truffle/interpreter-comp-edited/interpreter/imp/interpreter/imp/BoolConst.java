package interpreter.imp.interpreter.imp;

import com.oracle.truffle.api.nodes.NodeInterface;
import org.eclipse.emf.ecore.EObject;

public interface BoolConst extends EObject, NodeInterface, Expr {
  boolean isValue();

  void setValue(boolean value);

  Value evaluate(Store s);
}
