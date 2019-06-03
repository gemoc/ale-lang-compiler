package interpreter.imp.interpreter.imp;

import com.oracle.truffle.api.nodes.NodeInterface;
import org.eclipse.emf.ecore.EObject;

public interface IntConst extends EObject, NodeInterface, Expr {
  int getValue();

  void setValue(int value);

  Value evaluate(Store s);
}
