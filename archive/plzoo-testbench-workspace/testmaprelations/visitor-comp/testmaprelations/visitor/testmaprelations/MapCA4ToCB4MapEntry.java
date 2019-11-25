package testmaprelations.visitor.testmaprelations;

import org.eclipse.emf.ecore.EObject;
import visitor.AcceptInterface;

public interface MapCA4ToCB4MapEntry extends EObject, AcceptInterface {
	CA4 getKey();

	void setKey(CA4 value);

	CB4 getValue();

	void setValue(CB4 value);
}
