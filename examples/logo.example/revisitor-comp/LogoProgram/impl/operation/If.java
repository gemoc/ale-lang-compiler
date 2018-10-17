package LogoProgram.impl.operation;

import org.eclipse.emf.ecore.EClassifier;

public interface If extends ControlStructure {
  double eval(EClassifier turtle);
}
