package kmLogo.visitor.kmLogo;

import org.eclipse.emf.ecore.EObject;
import visitor.AcceptInterface;

public interface BinaryExp extends EObject, AcceptInterface, Expression {
	Expression getLhs();

	void setLhs(Expression value);

	Expression getRhs();

	void setRhs(Expression value);
}
