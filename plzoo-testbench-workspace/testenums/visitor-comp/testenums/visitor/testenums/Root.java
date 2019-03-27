package testenums.visitor.testenums;

import org.eclipse.emf.ecore.EObject;
import visitor.AcceptInterface;

public interface Root extends EObject, AcceptInterface {
	Enum1 getEnum();

	void setEnum(Enum1 value);

	Enum1 getEnums();

	void setEnums(Enum1 value);
}
