package boa.interpreter.boa;

import boa_dynamic.interpreter.boa_dynamic.Ctx;
import org.eclipse.emf.ecore.EObject;

public interface TopLevelCmd extends EObject {
  void nextLine(Ctx ctx);
}
