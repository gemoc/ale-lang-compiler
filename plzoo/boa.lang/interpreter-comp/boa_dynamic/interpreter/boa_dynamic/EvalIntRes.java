package boa_dynamic.interpreter.boa_dynamic;

import org.eclipse.emf.ecore.EObject;

public interface EvalIntRes extends EObject, EvalRes {
  int getValue();

  void setValue(int value);
}
