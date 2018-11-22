package kmLogo.interpreter.kmLogo;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

public interface CallStack extends EObject {
  EList<StackFrame> getFrames();
}
