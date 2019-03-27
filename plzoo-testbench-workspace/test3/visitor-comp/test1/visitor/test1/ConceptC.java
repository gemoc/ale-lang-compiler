package test1.visitor.test1;

import org.eclipse.emf.ecore.EObject;
import visitor.AcceptInterface;

public interface ConceptC extends EObject, AcceptInterface {
	int getNbr();

	void setNbr(int value);

	boolean isCool();

	void setCool(boolean value);
}
