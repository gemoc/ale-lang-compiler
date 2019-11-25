package visitor.boa.visitor.boa;

import org.eclipse.emf.ecore.EObject;
import visitor.visitor.AcceptInterface;

public interface ArithOp extends EObject, AcceptInterface, Expr {
  Expr getLhs();

  void setLhs(Expr value);

  Expr getRhs();

  void setRhs(Expr value);
}
