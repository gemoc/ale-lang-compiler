package kmlogo.interpreter;

import ecore.interpreter.EClassifier;
import org.eclipse.emf.ecore.EObject;

public interface Clear extends EObject, Primitive {
  double eval(EClassifier turtle);
}
