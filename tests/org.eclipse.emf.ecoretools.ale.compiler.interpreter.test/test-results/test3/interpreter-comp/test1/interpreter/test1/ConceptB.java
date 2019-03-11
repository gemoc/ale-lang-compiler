package test1.interpreter.test1;

import org.eclipse.emf.ecore.EObject;

public interface ConceptB extends EObject, ConceptA {
  void exec();

  int execB();
}
