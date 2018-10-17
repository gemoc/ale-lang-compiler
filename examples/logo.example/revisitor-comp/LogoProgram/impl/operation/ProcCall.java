package LogoProgram.impl.operation;

import org.eclipse.emf.ecore.EClassifier;

public interface ProcCall extends Expression {
  double eval(EClassifier turtle);
}
