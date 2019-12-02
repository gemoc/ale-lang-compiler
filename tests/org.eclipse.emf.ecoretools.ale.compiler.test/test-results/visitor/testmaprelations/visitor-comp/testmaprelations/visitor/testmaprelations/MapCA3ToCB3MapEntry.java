package testmaprelations.visitor.testmaprelations;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import visitor.AcceptInterface;

public interface MapCA3ToCB3MapEntry extends EObject, AcceptInterface {
	EList<CA3> getKey();

	EList<CB3> getValue();
}
