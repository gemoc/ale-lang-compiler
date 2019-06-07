package test1.interpreter.test1.impl;

import java.lang.Override;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecoretools.ale.compiler.lib.LogService;
import test1.interpreter.test1.ConceptA;
import test1.interpreter.test1.Test1Package;

public class ConceptAImpl extends MinimalEObjectImpl.Container implements ConceptA {
	protected ConceptAImpl() {
		super();
	}

	@Override
	protected EClass eStaticClass() {
		return Test1Package.Literals.CONCEPT_A;
	}

	public void exec() {
		LogService.log("ok");
	}
}
