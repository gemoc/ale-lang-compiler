package LogoProgram.impl.operation;

import org.eclipse.emf.ecore.EClassifier;

public interface Div extends BinaryExp {
  double eval(EClassifier turtle);
}
