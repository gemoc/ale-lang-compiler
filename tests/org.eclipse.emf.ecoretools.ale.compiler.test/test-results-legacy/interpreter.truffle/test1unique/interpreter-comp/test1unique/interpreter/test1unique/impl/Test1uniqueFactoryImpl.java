package test1unique.interpreter.test1unique.impl;

import java.lang.Deprecated;
import java.lang.IllegalArgumentException;
import java.lang.Override;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import test1unique.interpreter.test1unique.ConceptA;
import test1unique.interpreter.test1unique.Test1uniqueFactory;
import test1unique.interpreter.test1unique.Test1uniquePackage;

public class Test1uniqueFactoryImpl extends EFactoryImpl implements Test1uniqueFactory {
	public Test1uniqueFactoryImpl() {
		super();
	}

	public static Test1uniqueFactory init() {
		try {
			Test1uniqueFactory theTest1uniqueFactory = (Test1uniqueFactory) EPackage.Registry.INSTANCE.getEFactory(Test1uniquePackage.eNS_URI);
			if (theTest1uniqueFactory != null) {
				return theTest1uniqueFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new Test1uniqueFactoryImpl();
	}

	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case Test1uniquePackage.CONCEPT_A :
				return createConceptA();
			default :
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	public ConceptA createConceptA() {
		ConceptAImpl conceptA = new ConceptAImpl();
		return conceptA;
	}

	public Test1uniquePackage getTest1uniquePackage() {
		return (Test1uniquePackage) getEPackage();
	}

	@Deprecated
	public static Test1uniquePackage getPackage() {
		return Test1uniquePackage.eINSTANCE;
	}
}
