package boa_dynamic.interpreter.boa_dynamic;

import java.lang.String;
import org.eclipse.emf.ecore.EObject;

public interface StringToEvalResMap extends EObject {
  String getKey();

  void setKey(String value);

  EvalRes getValue();

  void setValue(EvalRes value);
}
