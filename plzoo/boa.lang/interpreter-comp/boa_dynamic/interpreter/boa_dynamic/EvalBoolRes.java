package boa_dynamic.interpreter.boa_dynamic;

import org.eclipse.emf.ecore.EObject;

public interface EvalBoolRes extends EObject, EvalRes {
  boolean isValue();

  void setValue(boolean value);
}
