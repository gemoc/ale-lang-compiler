package test1unique.interpreter.test1unique.impl;

import java.lang.Boolean;
import java.lang.Object;
import java.lang.Override;
import java.util.Collection;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecoretools.ale.compiler.lib.LogService;
import test1unique.interpreter.test1unique.ConceptA;
import test1unique.interpreter.test1unique.Test1uniquePackage;

public class ConceptAImpl extends MinimalEObjectImpl.Container implements ConceptA {
	protected EList<Boolean> bs;

	protected ConceptAImpl() {
		super();
	}

	public EList<Boolean> getBs() {
		if (bs == null) {
			bs = new EDataTypeUniqueEList<Boolean>(Boolean.class, this, test1unique.interpreter.test1unique.Test1uniquePackage.CONCEPT_A__BS);
		}
		return bs;
	}

	@Override
	protected EClass eStaticClass() {
		return Test1uniquePackage.Literals.CONCEPT_A;
	}

	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case Test1uniquePackage.CONCEPT_A__BS :
				return getBs();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case Test1uniquePackage.CONCEPT_A__BS :
				getBs().clear();
				getBs().addAll((Collection<? extends Boolean>) newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case Test1uniquePackage.CONCEPT_A__BS :
				getBs().clear();
				return;
		}
		super.eUnset(featureID);
	}

	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case Test1uniquePackage.CONCEPT_A__BS :
				return bs != null && !bs.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	public void exec() {
		LogService.log("ok");
	}
}
