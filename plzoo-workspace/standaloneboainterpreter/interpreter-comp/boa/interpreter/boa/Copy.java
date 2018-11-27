package boa.interpreter.boa;

import com.oracle.truffle.api.nodes.NodeInterface;
import org.eclipse.emf.ecore.EObject;

public interface Copy extends EObject, NodeInterface, Expr {
  Expr getCopy();

  void setCopy(Expr value);
}
