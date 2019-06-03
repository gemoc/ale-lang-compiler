package kmLogo.visitor.kmLogo;

import org.eclipse.emf.ecore.EObject;
import visitor.AcceptInterface;

public interface Segment extends EObject, AcceptInterface {
	Point getBegin();

	void setBegin(Point value);

	Point getEnd();

	void setEnd(Point value);
}
