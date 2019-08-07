package miniJava.interpreter.miniJava;

import com.oracle.truffle.api.nodes.NodeInterface;
import org.eclipse.emf.ecore.EObject;

public interface WhileStatement extends EObject, NodeInterface, Statement {
	Expression getCondition();

	void setCondition(Expression value);

	Block getBlock();

	void setBlock(Block value);

	void evaluateStatement(State state);
}
