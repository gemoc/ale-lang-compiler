package emfrelations.visitor.emfrelations;

import emfrelations.visitor.emfrelations.impl.EmfrelationsFactoryImpl;
import org.eclipse.emf.ecore.EFactory;

public interface EmfrelationsFactory extends EFactory {
	EmfrelationsFactory eINSTANCE = EmfrelationsFactoryImpl.init();

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

	ConceptA8 createConceptA8();

	ConceptB8 createConceptB8();

	ConceptA9 createConceptA9();

	ConceptB9 createConceptB9();

	ConceptA10 createConceptA10();

	ConceptB10 createConceptB10();

	ConceptA11 createConceptA11();

	ConceptB11 createConceptB11();

	EmfrelationsPackage getEmfrelationsPackage();
}
