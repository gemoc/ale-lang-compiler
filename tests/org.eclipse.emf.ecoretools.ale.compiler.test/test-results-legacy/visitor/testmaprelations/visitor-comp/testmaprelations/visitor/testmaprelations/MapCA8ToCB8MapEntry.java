package testmaprelations.visitor.testmaprelations;

import org.eclipse.emf.ecore.EObject;
import visitor.AcceptInterface;

public interface MapCA8ToCB8MapEntry extends EObject, AcceptInterface {
	CA8 getKey();

	void setKey(CA8 value);

	CB8 getValue();

	void setValue(CB8 value);
}
