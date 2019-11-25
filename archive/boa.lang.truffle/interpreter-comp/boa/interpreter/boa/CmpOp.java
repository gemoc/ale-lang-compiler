package boa.interpreter.boa;

import com.oracle.truffle.api.nodes.NodeInterface;
import org.eclipse.emf.ecore.EObject;

public interface CmpOp extends EObject, NodeInterface, Expr {
  Expr getLhs();

  void setLhs(Expr value);

  Expr getRhs();

  void setRhs(Expr value);
}
