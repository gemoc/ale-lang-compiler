package testmaprelations.visitor.testmaprelations;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import visitor.AcceptInterface;

public interface MapCA1ToCB1MapEntry extends EObject, AcceptInterface {
	EList<CA1> getKey();

	EList<CB1> getValue();
}
