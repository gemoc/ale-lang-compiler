package kmLogo.interpreter.kmLogo;

import org.eclipse.emf.ecore.EObject;

import com.oracle.truffle.api.nodes.NodeInterface;

public interface Constant extends EObject, NodeInterface, Expression {
	double getValue();

	void setValue(double value);

	double eval(Turtle turtle);
}
