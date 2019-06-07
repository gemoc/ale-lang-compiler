package autocast.interpreter.autocast;

import java.lang.String;
import org.eclipse.emf.ecore.EObject;

public interface ConceptB extends EObject, ConceptA {
	String getName();

	void setName(String value);

	void callB();
}
