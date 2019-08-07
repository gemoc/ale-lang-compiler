package interpreter.boa.interpreter.boa;

import com.oracle.truffle.api.nodes.NodeInterface;
import org.eclipse.emf.ecore.EObject;

public interface ArithOpTimes extends EObject, NodeInterface, ArithOp {
	EvalRes eval(Ctx ctx);
}
