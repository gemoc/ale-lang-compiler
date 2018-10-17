package LogoProgram.impl.operation;

import org.eclipse.emf.ecore.EClassifier;

public interface Block extends Instruction {
  double eval(EClassifier turtle);
}
