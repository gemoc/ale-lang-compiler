package kmLogo.interpreter.kmLogo;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

public interface StackFrame extends EObject {
  EList<Variable> getVariables();
}
