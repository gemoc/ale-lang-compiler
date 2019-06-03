package kmLogo.visitor.kmLogo;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import visitor.AcceptInterface;

public interface LogoProgram extends EObject, AcceptInterface {
	EList<Instruction> getInstructions();
}
