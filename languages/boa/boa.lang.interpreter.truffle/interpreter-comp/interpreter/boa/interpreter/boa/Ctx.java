package interpreter.boa.interpreter.boa;

import com.oracle.truffle.api.nodes.NodeInterface;
import java.lang.String;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EObject;

public interface Ctx extends EObject, NodeInterface {
	EMap<String, EvalRes> getEnv();

	EMap<String, EvalRes> getTh();
}
