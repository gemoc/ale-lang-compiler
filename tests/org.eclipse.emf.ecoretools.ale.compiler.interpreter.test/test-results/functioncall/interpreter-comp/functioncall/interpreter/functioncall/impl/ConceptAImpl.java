package functioncall.interpreter.functioncall.impl;

import functioncall.interpreter.functioncall.ConceptA;
import functioncall.interpreter.functioncall.FunctioncallFactory;
import functioncall.interpreter.functioncall.FunctioncallPackage;
import java.lang.Override;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

public class ConceptAImpl extends MinimalEObjectImpl.Container implements ConceptA {
	protected ConceptAImpl() {
		super();
	}

	@Override
	protected EClass eStaticClass() {
		return FunctioncallPackage.Literals.CONCEPT_A;
	}

	public void fct1() {
	}

	public ConceptA fct2() {
		ConceptA result;
		result = FunctioncallFactory.eINSTANCE.createConceptA();
		return result;
	}
}
