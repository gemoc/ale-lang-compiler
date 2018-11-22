package kmLogo.interpreter.kmLogo;

import org.eclipse.emf.ecore.EObject;

public interface PenDown extends EObject, Primitive {
  double eval(Turtle turtle);
}
