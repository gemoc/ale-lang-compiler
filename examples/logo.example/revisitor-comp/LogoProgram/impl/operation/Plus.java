package LogoProgram.impl.operation;

import org.eclipse.emf.ecore.EClassifier;

public interface Plus extends BinaryExp {
  double eval(EClassifier turtle);
}
