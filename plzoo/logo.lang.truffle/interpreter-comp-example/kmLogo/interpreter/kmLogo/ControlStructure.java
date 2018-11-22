package kmLogo.interpreter.kmLogo;

import org.eclipse.emf.ecore.EObject;

import com.oracle.truffle.api.nodes.NodeInterface;

public interface ControlStructure extends EObject, NodeInterface, Instruction {
	Expression getCondition();

	void setCondition(Expression value);
}
