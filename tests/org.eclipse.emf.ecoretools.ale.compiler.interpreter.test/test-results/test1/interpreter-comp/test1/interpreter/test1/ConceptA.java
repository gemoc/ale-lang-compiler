package test1.interpreter.test1;

import java.lang.Boolean;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

public interface ConceptA extends EObject {
	EList<Boolean> getBs();

	long getB();

	void setB(long value);

	void exec();
}
