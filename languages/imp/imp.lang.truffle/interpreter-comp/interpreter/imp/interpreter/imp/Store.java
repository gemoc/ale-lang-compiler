package interpreter.imp.interpreter.imp;

import com.oracle.truffle.api.nodes.NodeInterface;
import java.lang.String;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EObject;

public interface Store extends EObject, NodeInterface {
	EMap<String, Value> getValues();
}
