package interpreter.boa.interpreter.boa;

import com.oracle.truffle.api.nodes.NodeInterface;
import org.eclipse.emf.ecore.EObject;

public interface CmpOpUnequal extends EObject, NodeInterface, CmpOp {
	EvalRes eval(Ctx ctx);
}
