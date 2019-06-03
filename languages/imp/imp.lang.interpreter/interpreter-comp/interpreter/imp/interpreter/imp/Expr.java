package interpreter.imp.interpreter.imp;

import org.eclipse.emf.ecore.EObject;

public interface Expr extends EObject {
	Value evaluate(Store s);
}
