package kmLogo.visitor.kmLogo;

import org.eclipse.emf.ecore.EObject;
import visitor.AcceptInterface;

public interface Right extends EObject, AcceptInterface, Primitive {
	Expression getAngle();

	void setAngle(Expression value);
}
