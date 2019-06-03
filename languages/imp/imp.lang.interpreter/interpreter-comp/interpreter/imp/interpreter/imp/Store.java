package interpreter.imp.interpreter.imp;

import java.lang.String;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EObject;

public interface Store extends EObject {
	EMap<String, Value> getValues();
}
