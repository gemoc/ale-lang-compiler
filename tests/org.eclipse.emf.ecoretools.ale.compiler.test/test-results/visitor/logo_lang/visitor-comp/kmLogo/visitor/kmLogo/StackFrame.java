package kmLogo.visitor.kmLogo;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import visitor.AcceptInterface;

public interface StackFrame extends EObject, AcceptInterface {
	EList<Variable> getVariables();
}
