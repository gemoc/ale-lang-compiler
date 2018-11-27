package boa.interpreter.boa;

import com.oracle.truffle.api.nodes.NodeInterface;
import org.eclipse.emf.ecore.EObject;

public interface Int extends EObject, NodeInterface, Expr {
  int getValue();

  void setValue(int value);
}
