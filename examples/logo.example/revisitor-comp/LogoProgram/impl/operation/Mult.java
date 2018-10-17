package LogoProgram.impl.operation;

import org.eclipse.emf.ecore.EClassifier;

public interface Mult extends BinaryExp {
  double eval(EClassifier turtle);
}
