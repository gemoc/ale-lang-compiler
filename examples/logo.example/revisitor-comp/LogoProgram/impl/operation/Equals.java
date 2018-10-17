package LogoProgram.impl.operation;

import org.eclipse.emf.ecore.EClassifier;

public interface Equals extends BinaryExp {
  double eval(EClassifier turtle);
}
