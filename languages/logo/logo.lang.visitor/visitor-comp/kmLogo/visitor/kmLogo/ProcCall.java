package kmLogo.visitor.kmLogo;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import visitor.AcceptInterface;

public interface ProcCall extends EObject, AcceptInterface, Expression {
	EList<Expression> getActualArgs();

	ProcDeclaration getDeclaration();

	void setDeclaration(ProcDeclaration value);
}
