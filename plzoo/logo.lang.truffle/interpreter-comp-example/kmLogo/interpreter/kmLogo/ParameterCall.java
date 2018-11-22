package kmLogo.interpreter.kmLogo;

import org.eclipse.emf.ecore.EObject;

import com.oracle.truffle.api.nodes.NodeInterface;

public interface ParameterCall extends EObject, NodeInterface, Expression {
	Parameter getParameter();

	void setParameter(Parameter value);

	double eval(Turtle turtle);
}
