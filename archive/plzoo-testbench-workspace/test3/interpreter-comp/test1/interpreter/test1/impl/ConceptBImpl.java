package test1.interpreter.test1.impl;

import java.lang.Override;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecoretools.ale.compiler.lib.LogService;
import test1.interpreter.test1.ConceptB;
import test1.interpreter.test1.Test1Package;

public class ConceptBImpl extends ConceptAImpl implements ConceptB {
	protected ConceptBImpl() {
		super();
	}

	@Override
	protected EClass eStaticClass() {
		return Test1Package.Literals.CONCEPT_B;
	}

	public void exec() {
		LogService.log("okb");
	}

	public int execB() {
		int result;
		result = 1;
		return result;
	}
}
