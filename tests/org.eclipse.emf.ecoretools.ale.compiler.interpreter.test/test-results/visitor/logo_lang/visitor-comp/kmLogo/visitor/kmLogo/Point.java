package kmLogo.visitor.kmLogo;

import org.eclipse.emf.ecore.EObject;
import visitor.AcceptInterface;

public interface Point extends EObject, AcceptInterface {
	double getX();

	void setX(double value);

	double getY();

	void setY(double value);
}
