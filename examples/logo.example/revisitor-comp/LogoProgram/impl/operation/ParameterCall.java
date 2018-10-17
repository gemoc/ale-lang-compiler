package LogoProgram.impl.operation;

import org.eclipse.emf.ecore.EClassifier;

public interface ParameterCall extends Expression {
  double eval(EClassifier turtle);
}
