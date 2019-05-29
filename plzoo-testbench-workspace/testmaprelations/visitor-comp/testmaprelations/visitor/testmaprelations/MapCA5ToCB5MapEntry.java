package testmaprelations.visitor.testmaprelations;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import visitor.AcceptInterface;

public interface MapCA5ToCB5MapEntry extends EObject, AcceptInterface {
	EList<CA5> getKey();

	EList<CB5> getValue();
}
