package kmLogo.interpreter.kmLogo;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import com.oracle.truffle.api.nodes.NodeInterface;

public interface Turtle extends EObject, NodeInterface {
	double getHeading();

	void setHeading(double value);

	boolean isPenUp();

	void setPenUp(boolean value);

	Point getPosition();

	void setPosition(Point value);

	EList<Segment> getDrawings();

	CallStack getCallStack();

	void setCallStack(CallStack value);

	void move(double dx, double dy);

	void forward(double steps);

	void rotate(double angle);
}
