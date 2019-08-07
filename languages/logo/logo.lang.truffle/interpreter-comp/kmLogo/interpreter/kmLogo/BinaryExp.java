package kmLogo.interpreter.kmLogo;

import com.oracle.truffle.api.nodes.NodeInterface;
import org.eclipse.emf.ecore.EObject;

public interface BinaryExp extends EObject, NodeInterface, Expression {
	Expression getLhs();

	void setLhs(Expression value);

	Expression getRhs();

	void setRhs(Expression value);
}
