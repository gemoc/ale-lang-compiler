package interpreter.imp.interpreter.imp;

import org.eclipse.emf.ecore.EObject;

public interface BoolConst extends EObject, Expr {
  boolean isValue();

  void setValue(boolean value);

  Value evaluate(Store s);
}
