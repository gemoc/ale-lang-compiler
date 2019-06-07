package functioncall.interpreter.functioncall.impl;

import functioncall.interpreter.functioncall.ConceptB;
import functioncall.interpreter.functioncall.FunctioncallFactory;
import functioncall.interpreter.functioncall.FunctioncallPackage;
import java.lang.Override;
import org.eclipse.emf.ecore.EClass;

public class ConceptBImpl extends ConceptAImpl implements ConceptB {
	protected ConceptBImpl() {
		super();
	}

	@Override
	protected EClass eStaticClass() {
		return FunctioncallPackage.Literals.CONCEPT_B;
	}

	public ConceptB fct2() {
		ConceptB result;
		result = (ConceptB) (FunctioncallFactory.eINSTANCE.createConceptB()) ;
		return result;
	}
}
