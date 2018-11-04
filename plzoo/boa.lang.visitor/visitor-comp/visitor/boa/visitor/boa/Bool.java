package visitor.boa.visitor.boa;

import org.eclipse.emf.ecore.EObject;
import visitor.visitor.AcceptInterface;

public interface Bool extends EObject, AcceptInterface, Expr {
  boolean isValue();

  void setValue(boolean value);
}
