package testmaprelations.visitor.testmaprelations;

import org.eclipse.emf.ecore.EObject;
import visitor.AcceptInterface;

public interface MapCA2ToCB2MapEntry extends EObject, AcceptInterface {
	CA2 getKey();

	void setKey(CA2 value);

	CB2 getValue();

	void setValue(CB2 value);
}
