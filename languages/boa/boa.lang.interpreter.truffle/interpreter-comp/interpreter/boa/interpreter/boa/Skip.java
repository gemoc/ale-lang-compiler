package interpreter.boa.interpreter.boa;

import com.oracle.truffle.api.nodes.NodeInterface;
import org.eclipse.emf.ecore.EObject;

public interface Skip extends EObject, NodeInterface, Expr {
	EvalRes eval(Ctx ctx);
}
