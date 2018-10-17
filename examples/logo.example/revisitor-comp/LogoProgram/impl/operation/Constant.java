package LogoProgram.impl.operation;

import org.eclipse.emf.ecore.EClassifier;

public interface Constant extends Expression {
  double eval(EClassifier turtle);
}
