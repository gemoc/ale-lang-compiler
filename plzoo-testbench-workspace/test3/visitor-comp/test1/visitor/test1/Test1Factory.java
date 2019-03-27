package test1.visitor.test1;

import org.eclipse.emf.ecore.EFactory;
import test1.visitor.test1.impl.Test1FactoryImpl;

public interface Test1Factory extends EFactory {
	Test1Factory eINSTANCE = Test1FactoryImpl.init();

	ConceptA createConceptA();

	ConceptB createConceptB();

	ConceptC createConceptC();

	Test1Package getTest1Package();
}
