package visitor.boa.visitor.boa;

import org.eclipse.emf.ecore.EObject;
import visitor.visitor.AcceptInterface;

public interface If extends EObject, AcceptInterface, Expr {
  Expr getCond();

  void setCond(Expr value);

  Expr getThn();

  void setThn(Expr value);

  Expr getEls();

  void setEls(Expr value);
}
