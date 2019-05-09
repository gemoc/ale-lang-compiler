package testmaprelations.visitor.testmaprelations;

import org.eclipse.emf.ecore.EObject;
import visitor.AcceptInterface;

public interface MapCA6ToCB6MapEntry extends EObject, AcceptInterface {
	CA6 getKey();

	void setKey(CA6 value);

	CB6 getValue();

	void setValue(CB6 value);
}
