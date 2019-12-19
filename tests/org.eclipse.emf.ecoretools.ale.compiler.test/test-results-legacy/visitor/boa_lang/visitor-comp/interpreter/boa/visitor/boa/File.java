package interpreter.boa.visitor.boa;

import interpreter.visitor.AcceptInterface;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

public interface File extends EObject, AcceptInterface {
	EList<TopLevelCmd> getCommands();
}
