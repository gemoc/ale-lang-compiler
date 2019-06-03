package interpreter.imp.interpreter.imp;

import org.eclipse.emf.ecore.EObject;

public interface Skip extends EObject, Stmt {
	Store execute(Store s);
}
