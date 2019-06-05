package imp.visitor.imp;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import visitor.AcceptInterface;

public interface Block extends EObject, AcceptInterface, Stmt {
	EList<Stmt> getStmts();
}
