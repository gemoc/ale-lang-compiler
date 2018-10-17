package LogoProgram.impl.operation;

import org.eclipse.emf.ecore.EClassifier;

public interface ProcDeclaration extends Instruction {
  double eval(EClassifier turtle);
}
