package emfrelations.interpreter.emfrelations;

import org.eclipse.emf.ecore.EFactory;

public interface EmfrelationsFactory extends EFactory {
	EmfrelationsFactory eINSTANCE = fr.mleduc.xp.emfrelations.impl.EmfrelationsFactoryImpl.init();

	ConceptA0 createConceptA0();

	ConceptB0 createConceptB0();

	ConceptA1 createConceptA1();

	ConceptB1 createConceptB1();

	ConceptA2 createConceptA2();

	ConceptB2 createConceptB2();

	ConceptA3 createConceptA3();

	ConceptB3 createConceptB3();

	ConceptA4 createConceptA4();

	ConceptB4 createConceptB4();

	ConceptA5 createConceptA5();

	ConceptB5 createConceptB5();

	EmfrelationsPackage getEmfrelationsPackage();
}
