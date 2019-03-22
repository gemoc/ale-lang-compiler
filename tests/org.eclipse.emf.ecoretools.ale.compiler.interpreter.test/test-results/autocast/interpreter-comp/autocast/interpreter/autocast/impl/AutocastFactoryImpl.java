package autocast.interpreter.autocast.impl;

import autocast.interpreter.autocast.AutocastFactory;
import autocast.interpreter.autocast.AutocastPackage;
import autocast.interpreter.autocast.ConceptA;
import autocast.interpreter.autocast.ConceptB;
import autocast.interpreter.autocast.ConceptC;
import java.lang.Deprecated;
import java.lang.IllegalArgumentException;
import java.lang.Override;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

public class AutocastFactoryImpl extends EFactoryImpl implements AutocastFactory {
	public AutocastFactoryImpl() {
		super();
	}

	public static AutocastFactory init() {
		try {
			AutocastFactory theAutocastFactory = (AutocastFactory) EPackage.Registry.INSTANCE.getEFactory(AutocastPackage.eNS_URI);
			if (theAutocastFactory != null) {
				return theAutocastFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new AutocastFactoryImpl();
	}

	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case AutocastPackage.CONCEPT_A :
				return createConceptA();
			case AutocastPackage.CONCEPT_B :
				return createConceptB();
			case AutocastPackage.CONCEPT_C :
				return createConceptC();
			default :
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	public ConceptA createConceptA() {
		ConceptAImpl conceptA = new ConceptAImpl();
		return conceptA;
	}

	public ConceptB createConceptB() {
		ConceptBImpl conceptB = new ConceptBImpl();
		return conceptB;
	}

	public ConceptC createConceptC() {
		ConceptCImpl conceptC = new ConceptCImpl();
		return conceptC;
	}

	public AutocastPackage getAutocastPackage() {
		return (AutocastPackage) getEPackage();
	}

	@Deprecated
	public static AutocastPackage getPackage() {
		return AutocastPackage.eINSTANCE;
	}
}
