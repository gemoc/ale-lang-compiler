package autocast.visitor.autocast;

import java.lang.String;
import org.eclipse.emf.ecore.EObject;
import visitor.AcceptInterface;

public interface ConceptB extends EObject, AcceptInterface, ConceptA {
	String getName();

	void setName(String value);
}
