package boa.interpreter.boa;

import java.lang.String;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EObject;

public interface EvalBoundFunRes extends EObject, EvalFunRes {
  EMap<String, EvalRes> getTh();
}
