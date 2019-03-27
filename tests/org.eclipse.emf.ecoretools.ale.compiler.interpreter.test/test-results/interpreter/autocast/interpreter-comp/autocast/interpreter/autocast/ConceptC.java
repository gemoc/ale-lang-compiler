package autocast.interpreter.autocast;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

public interface ConceptC extends EObject {
	EList<ConceptA> getAx();

	void execB(ConceptB b);

	void exec1();

	void exec2();
	
	void exec3();
}
