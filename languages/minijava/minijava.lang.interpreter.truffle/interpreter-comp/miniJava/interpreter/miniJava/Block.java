package miniJava.interpreter.miniJava;

import com.oracle.truffle.api.nodes.NodeInterface;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

public interface Block extends EObject, NodeInterface, Statement {
	EList<Statement> getStatements();

	void evaluateStatementKeepContext(State state);

	void evaluateStatement(State state);
}
