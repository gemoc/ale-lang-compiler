package test1.interpreter.test1.impl;

import java.lang.Boolean;
import java.lang.Long;
import java.lang.Object;
import java.lang.Override;
import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EDataTypeEList;
import test1.interpreter.test1.ConceptA;
import test1.interpreter.test1.Test1Package;

public class ConceptAImpl extends MinimalEObjectImpl.Container implements ConceptA {
	protected static final long B_EDEFAULT = 0;

	protected EList<Boolean> bs;

	protected long b = B_EDEFAULT;

	protected ConceptAImpl() {
		super();
	}

	public EList<Boolean> getBs() {
		if (bs == null) {
			bs = new EDataTypeEList<Boolean>(Boolean.class, this, test1.interpreter.test1.Test1Package.CONCEPT_A__BS);
		}
		return bs;
	}

	public long getB() {
		return b;
	}

	public void setB(long newB) {
		long oldB = b;
		b = newB;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Test1Package.CONCEPT_A__B, oldB, b));
	}

	@Override
	protected EClass eStaticClass() {
		return Test1Package.Literals.CONCEPT_A;
	}

	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case Test1Package.CONCEPT_A__BS :
				return getBs();
			case Test1Package.CONCEPT_A__B :
				return getB();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case Test1Package.CONCEPT_A__BS :
				getBs().clear();
				getBs().addAll((Collection<? extends Boolean>) newValue);
				return;
			case Test1Package.CONCEPT_A__B :
				setB((Long) newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case Test1Package.CONCEPT_A__BS :
				getBs().clear();
				return;
			case Test1Package.CONCEPT_A__B :
				setB(B_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case Test1Package.CONCEPT_A__BS :
				return bs != null && !bs.isEmpty();
			case Test1Package.CONCEPT_A__B :
				return b != B_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	public void exec() {
		org.eclipse.emf.ecoretools.ale.compiler.lib.LogService.log("ok");
		int a = ((int) 1);
		this.setB(42);
	}
}
