package interpreter.imp.interpreter.imp;

import org.eclipse.emf.ecore.EObject;

public interface Stmt extends EObject {
  Store execute(Store s);
}
