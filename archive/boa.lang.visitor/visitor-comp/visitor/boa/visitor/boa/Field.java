package visitor.boa.visitor.boa;

import java.lang.String;
import org.eclipse.emf.ecore.EObject;
import visitor.visitor.AcceptInterface;

public interface Field extends EObject, AcceptInterface {
  String getName();

  void setName(String value);

  Expr getValue();

  void setValue(Expr value);
}
