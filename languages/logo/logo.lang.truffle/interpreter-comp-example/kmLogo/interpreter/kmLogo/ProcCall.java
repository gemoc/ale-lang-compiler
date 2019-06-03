package kmLogo.interpreter.kmLogo;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import com.oracle.truffle.api.nodes.NodeInterface;

public interface ProcCall extends EObject, NodeInterface, Expression {
	EList<Expression> getActualArgs();

	ProcDeclaration getDeclaration();

	void setDeclaration(ProcDeclaration value);

	double eval(Turtle turtle);
}
