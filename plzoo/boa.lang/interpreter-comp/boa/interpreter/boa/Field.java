package boa.interpreter.boa;

import java.lang.String;
import org.eclipse.emf.ecore.EObject;

public interface Field extends EObject {
  String getName();

  void setName(String value);

  Expr getValue();

  void setValue(Expr value);
}
