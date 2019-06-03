package kmLogo.visitor.kmLogo;

import org.eclipse.emf.ecore.EObject;
import visitor.AcceptInterface;

public interface ParameterCall extends EObject, AcceptInterface, Expression {
	Parameter getParameter();

	void setParameter(Parameter value);
}
