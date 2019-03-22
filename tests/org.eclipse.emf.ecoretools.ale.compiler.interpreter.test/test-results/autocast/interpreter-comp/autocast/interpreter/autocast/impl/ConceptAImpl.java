package autocast.interpreter.autocast.impl;

import autocast.interpreter.autocast.AutocastPackage;
import autocast.interpreter.autocast.ConceptA;
import java.lang.Override;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

public class ConceptAImpl extends MinimalEObjectImpl.Container implements ConceptA {
	protected ConceptAImpl() {
		super();
	}

	@Override
	protected EClass eStaticClass() {
		return AutocastPackage.Literals.CONCEPT_A;
	}
}
