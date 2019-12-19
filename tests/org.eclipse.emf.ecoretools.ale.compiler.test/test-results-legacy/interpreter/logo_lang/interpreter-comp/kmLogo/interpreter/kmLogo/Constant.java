package kmLogo.interpreter.kmLogo;

import org.eclipse.emf.ecore.EObject;

public interface Constant extends EObject, Expression {
	double getValue();

	void setValue(double value);

	double eval(Turtle turtle);
}
