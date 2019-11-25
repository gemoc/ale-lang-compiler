package functioncall.interpreter.functioncall.impl;

import functioncall.interpreter.functioncall.ConceptA;
import functioncall.interpreter.functioncall.ConceptB;
import functioncall.interpreter.functioncall.ConceptC;
import functioncall.interpreter.functioncall.FunctioncallFactory;
import functioncall.interpreter.functioncall.FunctioncallPackage;
import java.lang.Deprecated;
import java.lang.IllegalArgumentException;
import java.lang.Override;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

public class FunctioncallFactoryImpl extends EFactoryImpl implements FunctioncallFactory {
	public FunctioncallFactoryImpl() {
		super();
	}

	public static FunctioncallFactory init() {
		try {
			FunctioncallFactory theFunctioncallFactory = (FunctioncallFactory) EPackage.Registry.INSTANCE.getEFactory(FunctioncallPackage.eNS_URI);
			if (theFunctioncallFactory != null) {
				return theFunctioncallFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new FunctioncallFactoryImpl();
	}

	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case FunctioncallPackage.CONCEPT_A :
				return createConceptA();
			case FunctioncallPackage.CONCEPT_B :
				return createConceptB();
			case FunctioncallPackage.CONCEPT_C :
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

	public FunctioncallPackage getFunctioncallPackage() {
		return (FunctioncallPackage) getEPackage();
	}

	@Deprecated
	public static FunctioncallPackage getPackage() {
		return FunctioncallPackage.eINSTANCE;
	}
}
