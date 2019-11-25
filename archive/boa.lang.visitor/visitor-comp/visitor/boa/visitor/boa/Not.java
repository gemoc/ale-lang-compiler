package visitor.boa.visitor.boa;

import org.eclipse.emf.ecore.EObject;
import visitor.visitor.AcceptInterface;

public interface Not extends EObject, AcceptInterface, Expr {
  Expr getValue();

  void setValue(Expr value);
}
