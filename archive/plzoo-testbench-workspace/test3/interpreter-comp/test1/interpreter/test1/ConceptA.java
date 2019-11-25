package test1.interpreter.test1;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

public interface ConceptA extends EObject {
	EList<ConceptC> getCs();

	void exec();
}
