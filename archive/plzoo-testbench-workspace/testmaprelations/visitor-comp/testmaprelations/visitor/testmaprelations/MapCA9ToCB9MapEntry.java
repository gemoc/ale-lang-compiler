package testmaprelations.visitor.testmaprelations;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import visitor.AcceptInterface;

public interface MapCA9ToCB9MapEntry extends EObject, AcceptInterface {
	EList<CA9> getKey();

	EList<CB9> getValue();
}
