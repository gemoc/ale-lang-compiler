package kmLogo.interpreter.kmLogo;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import com.oracle.truffle.api.nodes.NodeInterface;

public interface CallStack extends EObject, NodeInterface {
	EList<StackFrame> getFrames();
}
