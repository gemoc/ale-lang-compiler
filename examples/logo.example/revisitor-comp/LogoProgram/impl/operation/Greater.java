package LogoProgram.impl.operation;

import org.eclipse.emf.ecore.EClassifier;

public interface Greater extends BinaryExp {
  double eval(EClassifier turtle);
}
