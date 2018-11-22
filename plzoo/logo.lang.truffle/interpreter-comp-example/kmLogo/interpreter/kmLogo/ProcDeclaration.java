package kmLogo.interpreter.kmLogo;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import com.oracle.truffle.api.nodes.NodeInterface;

import kmLogo.interpreter.kmLogo.impl.ProcDeclarationDispatchWrapperEval;

public interface ProcDeclaration extends EObject, NodeInterface, Instruction {
	String getName();

	void setName(String value);

	EList<Parameter> getArgs();

	EList<ProcCall> getProcCall();

	EList<Instruction> getInstructions();

	ProcDeclarationDispatchWrapperEval getCached();
}
