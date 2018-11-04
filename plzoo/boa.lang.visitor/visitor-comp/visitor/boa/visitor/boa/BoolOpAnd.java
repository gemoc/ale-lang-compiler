package visitor.boa.visitor.boa;

import org.eclipse.emf.ecore.EObject;
import visitor.visitor.AcceptInterface;

public interface BoolOpAnd extends EObject, AcceptInterface, BoolOp {
  Expr getLhs();

  void setLhs(Expr value);

  Expr getRhs();

  void setRhs(Expr value);
}
