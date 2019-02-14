package boa.interpreter.boa;

import org.eclipse.emf.ecore.EObject;

public interface EvalBoolRes extends EObject, EvalRes {
  boolean isValue();

  void setValue(boolean value);
}
