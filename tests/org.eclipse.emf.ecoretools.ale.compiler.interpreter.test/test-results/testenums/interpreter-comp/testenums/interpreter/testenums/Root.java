package testenums.interpreter.testenums;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

public interface Root extends EObject {
	Enum1 getEnum();

	void setEnum(Enum1 value);

	EList<Enum1> getEnums();
}
