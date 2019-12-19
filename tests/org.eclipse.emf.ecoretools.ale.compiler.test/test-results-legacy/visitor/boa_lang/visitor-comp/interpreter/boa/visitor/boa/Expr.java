package interpreter.boa.visitor.boa;

import interpreter.visitor.AcceptInterface;
import org.eclipse.emf.ecore.EObject;

public interface Expr extends EObject, AcceptInterface, TopLevelCmd {
}
