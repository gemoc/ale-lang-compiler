package interpreter.boa.visitor.boa;

import interpreter.visitor.AcceptInterface;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

public interface BObject extends EObject, AcceptInterface, Expr {
	EList<Field> getFields();
}
