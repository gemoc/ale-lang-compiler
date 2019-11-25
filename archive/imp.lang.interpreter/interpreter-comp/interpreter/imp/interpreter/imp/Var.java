package interpreter.imp.interpreter.imp;

import java.lang.String;
import org.eclipse.emf.ecore.EObject;

public interface Var extends EObject, Expr {
  String getName();

  void setName(String value);

  Expr getIndex();

  void setIndex(Expr value);

  Value evaluate(Store s);
}
