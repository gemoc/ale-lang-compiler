package test1.visitor.test1;

import java.lang.Integer;
import java.lang.String;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EObject;
import visitor.AcceptInterface;

public interface ConceptA extends EObject, AcceptInterface {
	EMap<String, Integer> getCs();
}
