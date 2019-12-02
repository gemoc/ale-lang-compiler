package emfrelations.interpreter.emfrelations.impl;

import emfrelations.interpreter.emfrelations.ConceptA0;
import emfrelations.interpreter.emfrelations.ConceptA1;
import emfrelations.interpreter.emfrelations.ConceptA10;
import emfrelations.interpreter.emfrelations.ConceptA11;
import emfrelations.interpreter.emfrelations.ConceptA2;
import emfrelations.interpreter.emfrelations.ConceptA3;
import emfrelations.interpreter.emfrelations.ConceptA4;
import emfrelations.interpreter.emfrelations.ConceptA5;
import emfrelations.interpreter.emfrelations.ConceptA8;
import emfrelations.interpreter.emfrelations.ConceptA9;
import emfrelations.interpreter.emfrelations.ConceptB0;
import emfrelations.interpreter.emfrelations.ConceptB1;
import emfrelations.interpreter.emfrelations.ConceptB10;
import emfrelations.interpreter.emfrelations.ConceptB11;
import emfrelations.interpreter.emfrelations.ConceptB2;
import emfrelations.interpreter.emfrelations.ConceptB3;
import emfrelations.interpreter.emfrelations.ConceptB4;
import emfrelations.interpreter.emfrelations.ConceptB5;
import emfrelations.interpreter.emfrelations.ConceptB8;
import emfrelations.interpreter.emfrelations.ConceptB9;
import emfrelations.interpreter.emfrelations.EmfrelationsFactory;
import emfrelations.interpreter.emfrelations.EmfrelationsPackage;
import java.lang.Deprecated;
import java.lang.IllegalArgumentException;
import java.lang.Override;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

public class EmfrelationsFactoryImpl extends EFactoryImpl implements EmfrelationsFactory {
	public EmfrelationsFactoryImpl() {
		super();
	}

	public static EmfrelationsFactory init() {
		try {
			EmfrelationsFactory theEmfrelationsFactory = (EmfrelationsFactory) EPackage.Registry.INSTANCE.getEFactory(EmfrelationsPackage.eNS_URI);
			if (theEmfrelationsFactory != null) {
				return theEmfrelationsFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new EmfrelationsFactoryImpl();
	}

	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case EmfrelationsPackage.CONCEPT_A0 :
				return createConceptA0();
			case EmfrelationsPackage.CONCEPT_B0 :
				return createConceptB0();
			case EmfrelationsPackage.CONCEPT_A1 :
				return createConceptA1();
			case EmfrelationsPackage.CONCEPT_B1 :
				return createConceptB1();
			case EmfrelationsPackage.CONCEPT_A2 :
				return createConceptA2();
			case EmfrelationsPackage.CONCEPT_B2 :
				return createConceptB2();
			case EmfrelationsPackage.CONCEPT_A3 :
				return createConceptA3();
			case EmfrelationsPackage.CONCEPT_B3 :
				return createConceptB3();
			case EmfrelationsPackage.CONCEPT_A4 :
				return createConceptA4();
			case EmfrelationsPackage.CONCEPT_B4 :
				return createConceptB4();
			case EmfrelationsPackage.CONCEPT_A5 :
				return createConceptA5();
			case EmfrelationsPackage.CONCEPT_B5 :
				return createConceptB5();
			case EmfrelationsPackage.CONCEPT_A8 :
				return createConceptA8();
			case EmfrelationsPackage.CONCEPT_B8 :
				return createConceptB8();
			case EmfrelationsPackage.CONCEPT_A9 :
				return createConceptA9();
			case EmfrelationsPackage.CONCEPT_B9 :
				return createConceptB9();
			case EmfrelationsPackage.CONCEPT_A10 :
				return createConceptA10();
			case EmfrelationsPackage.CONCEPT_B10 :
				return createConceptB10();
			case EmfrelationsPackage.CONCEPT_A11 :
				return createConceptA11();
			case EmfrelationsPackage.CONCEPT_B11 :
				return createConceptB11();
			default :
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	public ConceptA0 createConceptA0() {
		ConceptA0Impl conceptA0 = new ConceptA0Impl();
		return conceptA0;
	}

	public ConceptB0 createConceptB0() {
		ConceptB0Impl conceptB0 = new ConceptB0Impl();
		return conceptB0;
	}

	public ConceptA1 createConceptA1() {
		ConceptA1Impl conceptA1 = new ConceptA1Impl();
		return conceptA1;
	}

	public ConceptB1 createConceptB1() {
		ConceptB1Impl conceptB1 = new ConceptB1Impl();
		return conceptB1;
	}

	public ConceptA2 createConceptA2() {
		ConceptA2Impl conceptA2 = new ConceptA2Impl();
		return conceptA2;
	}

	public ConceptB2 createConceptB2() {
		ConceptB2Impl conceptB2 = new ConceptB2Impl();
		return conceptB2;
	}

	public ConceptA3 createConceptA3() {
		ConceptA3Impl conceptA3 = new ConceptA3Impl();
		return conceptA3;
	}

	public ConceptB3 createConceptB3() {
		ConceptB3Impl conceptB3 = new ConceptB3Impl();
		return conceptB3;
	}

	public ConceptA4 createConceptA4() {
		ConceptA4Impl conceptA4 = new ConceptA4Impl();
		return conceptA4;
	}

	public ConceptB4 createConceptB4() {
		ConceptB4Impl conceptB4 = new ConceptB4Impl();
		return conceptB4;
	}

	public ConceptA5 createConceptA5() {
		ConceptA5Impl conceptA5 = new ConceptA5Impl();
		return conceptA5;
	}

	public ConceptB5 createConceptB5() {
		ConceptB5Impl conceptB5 = new ConceptB5Impl();
		return conceptB5;
	}

	public ConceptA8 createConceptA8() {
		ConceptA8Impl conceptA8 = new ConceptA8Impl();
		return conceptA8;
	}

	public ConceptB8 createConceptB8() {
		ConceptB8Impl conceptB8 = new ConceptB8Impl();
		return conceptB8;
	}

	public ConceptA9 createConceptA9() {
		ConceptA9Impl conceptA9 = new ConceptA9Impl();
		return conceptA9;
	}

	public ConceptB9 createConceptB9() {
		ConceptB9Impl conceptB9 = new ConceptB9Impl();
		return conceptB9;
	}

	public ConceptA10 createConceptA10() {
		ConceptA10Impl conceptA10 = new ConceptA10Impl();
		return conceptA10;
	}

	public ConceptB10 createConceptB10() {
		ConceptB10Impl conceptB10 = new ConceptB10Impl();
		return conceptB10;
	}

	public ConceptA11 createConceptA11() {
		ConceptA11Impl conceptA11 = new ConceptA11Impl();
		return conceptA11;
	}

	public ConceptB11 createConceptB11() {
		ConceptB11Impl conceptB11 = new ConceptB11Impl();
		return conceptB11;
	}

	public EmfrelationsPackage getEmfrelationsPackage() {
		return (EmfrelationsPackage) getEPackage();
	}

	@Deprecated
	public static EmfrelationsPackage getPackage() {
		return EmfrelationsPackage.eINSTANCE;
	}
}
