package interpreter.imp.interpreter.imp;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

public interface Block extends EObject, Stmt {
	EList<Stmt> getStmts();

	Store execute(Store s);
}
