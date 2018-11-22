package interpreter.boa.interpreter.boa;

import org.eclipse.emf.ecore.EObject;

public interface EvalIntRes extends EObject, EvalRes {
  int getValue();

  void setValue(int value);
}
