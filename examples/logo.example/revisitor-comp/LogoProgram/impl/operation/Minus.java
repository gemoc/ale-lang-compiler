package LogoProgram.impl.operation;

import org.eclipse.emf.ecore.EClassifier;

public interface Minus extends BinaryExp {
  double eval(EClassifier turtle);
}
