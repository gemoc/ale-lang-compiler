package test1.visitor.test1.impl;

import java.lang.Deprecated;
import java.lang.IllegalArgumentException;
import java.lang.Override;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import test1.visitor.test1.ConceptA;
import test1.visitor.test1.ConceptB;
import test1.visitor.test1.Test1Factory;
import test1.visitor.test1.Test1Package;

public class Test1FactoryImpl extends EFactoryImpl implements Test1Factory {
	public Test1FactoryImpl() {
		super();
	}

	public static Test1Factory init() {
		try {
			Test1Factory theTest1Factory = (Test1Factory) EPackage.Registry.INSTANCE.getEFactory(Test1Package.eNS_URI);
			if (theTest1Factory != null) {
				return theTest1Factory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new Test1FactoryImpl();
	}

	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case Test1Package.CONCEPT_A :
				return createConceptA();
			case Test1Package.CONCEPT_B :
				return createConceptB();
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

	public Test1Package getTest1Package() {
		return (Test1Package) getEPackage();
	}

	@Deprecated
	public static Test1Package getPackage() {
		return Test1Package.eINSTANCE;
	}
}
