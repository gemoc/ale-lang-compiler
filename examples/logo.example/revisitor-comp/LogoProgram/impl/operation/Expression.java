package LogoProgram.impl.operation;

import org.eclipse.emf.ecore.EClassifier;

public interface Expression extends Instruction {
  double eval(EClassifier turtle);
}
