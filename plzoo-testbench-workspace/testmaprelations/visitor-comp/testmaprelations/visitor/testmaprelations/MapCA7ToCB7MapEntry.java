package testmaprelations.visitor.testmaprelations;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import visitor.AcceptInterface;

public interface MapCA7ToCB7MapEntry extends EObject, AcceptInterface {
	EList<CA7> getKey();

	EList<CB7> getValue();
}
