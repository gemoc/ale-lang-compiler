package kmLogo.interpreter.kmLogo;

import org.eclipse.emf.ecore.EObject;

import com.oracle.truffle.api.nodes.NodeInterface;

public interface Segment extends EObject, NodeInterface {
	Point getBegin();

	void setBegin(Point value);

	Point getEnd();

	void setEnd(Point value);
}
