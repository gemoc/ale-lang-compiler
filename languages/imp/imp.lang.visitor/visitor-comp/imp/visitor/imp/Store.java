package imp.visitor.imp;

import java.lang.String;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EObject;
import visitor.AcceptInterface;

public interface Store extends EObject, AcceptInterface {
	EMap<String, Value> getValues();
}
