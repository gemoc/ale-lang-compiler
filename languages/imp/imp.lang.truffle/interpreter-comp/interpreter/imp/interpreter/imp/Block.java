package interpreter.imp.interpreter.imp;

import com.oracle.truffle.api.nodes.NodeInterface;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

public interface Block extends EObject, NodeInterface, Stmt {
	EList<Stmt> getStmts();

	Store execute(Store s);
}
