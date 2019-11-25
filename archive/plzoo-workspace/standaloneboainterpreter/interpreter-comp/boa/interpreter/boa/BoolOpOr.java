package boa.interpreter.boa;

import com.oracle.truffle.api.nodes.NodeInterface;
import org.eclipse.emf.ecore.EObject;

public interface BoolOpOr extends EObject, NodeInterface, BoolOp {
  Expr getLhs();

  void setLhs(Expr value);

  Expr getRhs();

  void setRhs(Expr value);
}
