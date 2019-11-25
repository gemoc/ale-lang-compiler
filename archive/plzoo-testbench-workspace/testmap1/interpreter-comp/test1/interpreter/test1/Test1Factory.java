package test1.interpreter.test1;

import org.eclipse.emf.ecore.EFactory;
import test1.interpreter.test1.impl.Test1FactoryImpl;

public interface Test1Factory extends EFactory {
	Test1Factory eINSTANCE = Test1FactoryImpl.init();

	ConceptA createConceptA();

	Test1Package getTest1Package();
}
