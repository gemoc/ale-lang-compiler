package visitor.boa.visitor.boa;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import visitor.visitor.AcceptInterface;

public interface BObject extends EObject, AcceptInterface, Expr {
  EList<Field> getFields();
}
