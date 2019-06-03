package boa.visitor.boa;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import visitor.AcceptInterface;

public interface BObject extends EObject, AcceptInterface, Expr {
	EList<Field> getFields();
}
