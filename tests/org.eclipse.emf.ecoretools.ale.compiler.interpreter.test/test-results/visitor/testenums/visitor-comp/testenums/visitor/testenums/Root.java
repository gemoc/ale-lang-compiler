package testenums.visitor.testenums;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import visitor.AcceptInterface;

public interface Root extends EObject, AcceptInterface {
	Enum1 getEnum();

	void setEnum(Enum1 value);

	EList<Enum1> getEnums();
}
