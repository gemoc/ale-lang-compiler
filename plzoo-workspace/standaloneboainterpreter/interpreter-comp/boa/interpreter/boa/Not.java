package boa.interpreter.boa;

import com.oracle.truffle.api.nodes.NodeInterface;
import org.eclipse.emf.ecore.EObject;

public interface Not extends EObject, NodeInterface, Expr {
  Expr getValue();

  void setValue(Expr value);
}
