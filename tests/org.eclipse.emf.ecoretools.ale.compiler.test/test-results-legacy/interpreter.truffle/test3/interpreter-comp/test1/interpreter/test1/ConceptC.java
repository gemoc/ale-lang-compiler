package test1.interpreter.test1;

import org.eclipse.emf.ecore.EObject;

public interface ConceptC extends EObject {
	int getNbr();

	void setNbr(int value);

	boolean isCool();

	void setCool(boolean value);

	void call();
}
