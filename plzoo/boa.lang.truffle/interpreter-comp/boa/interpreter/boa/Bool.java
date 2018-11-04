package boa.interpreter.boa;

import com.oracle.truffle.api.nodes.NodeInterface;
import org.eclipse.emf.ecore.EObject;

public interface Bool extends EObject, NodeInterface, Expr {
  boolean isValue();

  void setValue(boolean value);

  EvalRes eval(Ctx ctx);
}
