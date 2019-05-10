package kmLogo.visitor.kmLogo;

import org.eclipse.emf.ecore.EObject;
import visitor.AcceptInterface;

public interface Constant extends EObject, AcceptInterface, Expression {
	double getValue();

	void setValue(double value);
}
