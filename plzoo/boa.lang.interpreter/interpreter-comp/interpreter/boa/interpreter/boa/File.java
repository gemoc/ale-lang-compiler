package interpreter.boa.interpreter.boa;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

public interface File extends EObject {
  EList<TopLevelCmd> getCommands();

  void eval();
}
