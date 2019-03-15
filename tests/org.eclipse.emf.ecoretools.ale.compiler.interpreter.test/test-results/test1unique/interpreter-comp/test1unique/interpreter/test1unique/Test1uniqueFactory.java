package test1unique.interpreter.test1unique;

import org.eclipse.emf.ecore.EFactory;
import test1unique.interpreter.test1unique.impl.Test1uniqueFactoryImpl;

public interface Test1uniqueFactory extends EFactory {
	Test1uniqueFactory eINSTANCE = Test1uniqueFactoryImpl.init();

	ConceptA createConceptA();

	Test1uniquePackage getTest1uniquePackage();
}
