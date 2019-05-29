package interpreter.kmLogo.interpreter.kmLogo;

import org.eclipse.emf.ecore.EObject;

public interface If extends EObject, ControlStructure {
	Block getThenPart();

	void setThenPart(Block value);

	Block getElsePart();

	void setElsePart(Block value);

	double eval(Turtle turtle);
}
