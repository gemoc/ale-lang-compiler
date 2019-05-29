package interpreter.kmLogo.interpreter.kmLogo;

import org.eclipse.emf.ecore.EObject;

public interface Segment extends EObject {
	Point getBegin();

	void setBegin(Point value);

	Point getEnd();

	void setEnd(Point value);
}
