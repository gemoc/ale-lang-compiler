package test1.interpreter.test1;

import java.lang.Integer;
import java.lang.String;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EObject;

public interface ConceptA extends EObject {
	EMap<String, Integer> getCs();

	void exec();
}
