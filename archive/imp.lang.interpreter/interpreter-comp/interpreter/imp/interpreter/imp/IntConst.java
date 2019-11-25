package interpreter.imp.interpreter.imp;

import org.eclipse.emf.ecore.EObject;

public interface IntConst extends EObject, Expr {
  int getValue();

  void setValue(int value);

  Value evaluate(Store s);
}
