package visitor.boa.visitor.boa;

import org.eclipse.emf.ecore.EObject;
import visitor.visitor.AcceptInterface;

public interface Copy extends EObject, AcceptInterface, Expr {
  Expr getCopy();

  void setCopy(Expr value);
}
