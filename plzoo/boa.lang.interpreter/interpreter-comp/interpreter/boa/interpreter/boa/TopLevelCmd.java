package interpreter.boa.interpreter.boa;

import org.eclipse.emf.ecore.EObject;

public interface TopLevelCmd extends EObject {
  void nextLine(Ctx ctx);
}
