package emapvselistentry.visitor.emapvselistentry.impl;

import emapvselistentry.visitor.emapvselistentry.EmapvselistentryPackage;
import emapvselistentry.visitor.emapvselistentry.NewEClass1;
import java.lang.Boolean;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.InternalEList;
import visitor.VisitorInterface;

public class NewEClass1Impl extends MinimalEObjectImpl.Container implements NewEClass1 {
	protected EList<Entry<Integer, Boolean>> neweclass2;

	protected EMap<Integer, Boolean> neweclass3;

	protected Entry<Integer, Boolean> neweclass4;

	protected Entry<Integer, Boolean> neweclass5;

	protected NewEClass1Impl() {
		super();
	}

	@Override
	protected EClass eStaticClass() {
		return EmapvselistentryPackage.Literals.NEW_ECLASS1;
	}

	public EList<Entry<Integer, Boolean>> getNeweclass2() {
		if (neweclass2 == null) {
			neweclass2 = new EObjectResolvingEList<Entry<Integer, Boolean>>(Entry.class, this, EmapvselistentryPackage.NEW_ECLASS1__NEWECLASS2);
		}
		return neweclass2;
	}

	public EMap<Integer, Boolean> getNeweclass3() {
		if (neweclass3 == null) {
			neweclass3 = new EcoreEMap<Integer, Boolean>(EmapvselistentryPackage.Literals.NEW_ECLASS3, NewEClass3Impl.class, this, EmapvselistentryPackage.NEW_ECLASS1__NEWECLASS3);
		}
		return neweclass3;
	}

	public Entry<Integer, Boolean> getNeweclass4() {
		if (neweclass4 != null && ((EObject) neweclass4).eIsProxy()) {
			InternalEObject oldNeweclass4 = (InternalEObject) neweclass4;
			neweclass4 = (Entry<Integer, Boolean>) eResolveProxy(oldNeweclass4);
			if (neweclass4 != oldNeweclass4) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EmapvselistentryPackage.NEW_ECLASS1__NEWECLASS4, oldNeweclass4, neweclass4));
			}
		}
		return neweclass4;
	}

	public Entry<Integer, Boolean> basicGetNeweclass4() {
		return neweclass4;
	}

	public void setNeweclass4(Entry<Integer, Boolean> newNeweclass4) {
		Entry<Integer, Boolean> oldNeweclass4 = neweclass4;
		neweclass4 = newNeweclass4;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmapvselistentryPackage.NEW_ECLASS1__NEWECLASS4, oldNeweclass4, neweclass4));
	}

	public Entry<Integer, Boolean> getNeweclass5() {
		return neweclass5;
	}

	public NotificationChain basicSetNeweclass5(Entry<Integer, Boolean> newNeweclass5,
			NotificationChain msgs) {
		Entry<Integer, Boolean> oldNeweclass5 = neweclass5;
		neweclass5 = newNeweclass5;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EmapvselistentryPackage.NEW_ECLASS1__NEWECLASS5, oldNeweclass5, newNeweclass5);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	public void setNeweclass5(Entry<Integer, Boolean> newNeweclass5) {
		if (newNeweclass5 != neweclass5) {
			NotificationChain msgs = null;
			if (neweclass5 != null)
				msgs = ((InternalEObject) neweclass5).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EmapvselistentryPackage.NEW_ECLASS1__NEWECLASS5, null, msgs);
			if (newNeweclass5 != null)
				msgs = ((InternalEObject) newNeweclass5).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EmapvselistentryPackage.NEW_ECLASS1__NEWECLASS5, null, msgs);
			msgs = basicSetNeweclass5(newNeweclass5, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EmapvselistentryPackage.NEW_ECLASS1__NEWECLASS5, newNeweclass5, newNeweclass5));
	}

	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
			NotificationChain msgs) {
		switch (featureID) {
			case EmapvselistentryPackage.NEW_ECLASS1__NEWECLASS3 :
				return ((InternalEList<?>) getNeweclass3()).basicRemove(otherEnd, msgs);
			case EmapvselistentryPackage.NEW_ECLASS1__NEWECLASS5 :
				return basicSetNeweclass5(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EmapvselistentryPackage.NEW_ECLASS1__NEWECLASS2 :
				return getNeweclass2();
			case EmapvselistentryPackage.NEW_ECLASS1__NEWECLASS3 :
				if (coreType) return getNeweclass3();
				else return getNeweclass3().map();
			case EmapvselistentryPackage.NEW_ECLASS1__NEWECLASS4 :
				if (resolve)
					return getNeweclass4();
				return basicGetNeweclass4();
			case EmapvselistentryPackage.NEW_ECLASS1__NEWECLASS5 :
				return getNeweclass5();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case EmapvselistentryPackage.NEW_ECLASS1__NEWECLASS2 :
				getNeweclass2().clear();
				getNeweclass2().addAll((Collection<? extends Entry<Integer, Boolean>>) newValue);
				return;
			case EmapvselistentryPackage.NEW_ECLASS1__NEWECLASS3 :
				((Setting)getNeweclass3()).set(newValue);
				return;
			case EmapvselistentryPackage.NEW_ECLASS1__NEWECLASS4 :
				setNeweclass4((Entry<Integer, Boolean>) newValue);
				return;
			case EmapvselistentryPackage.NEW_ECLASS1__NEWECLASS5 :
				setNeweclass5((Entry<Integer, Boolean>) newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case EmapvselistentryPackage.NEW_ECLASS1__NEWECLASS2 :
				getNeweclass2().clear();
				return;
			case EmapvselistentryPackage.NEW_ECLASS1__NEWECLASS3 :
				getNeweclass3().clear();
				return;
			case EmapvselistentryPackage.NEW_ECLASS1__NEWECLASS4 :
				setNeweclass4((Entry<Integer, Boolean>) null);
				return;
			case EmapvselistentryPackage.NEW_ECLASS1__NEWECLASS5 :
				setNeweclass5((Entry<Integer, Boolean>) null);
				return;
		}
		super.eUnset(featureID);
	}

	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case EmapvselistentryPackage.NEW_ECLASS1__NEWECLASS2 :
				return neweclass2 != null && !neweclass2.isEmpty();
			case EmapvselistentryPackage.NEW_ECLASS1__NEWECLASS3 :
				return neweclass3 != null && !neweclass3.isEmpty();
			case EmapvselistentryPackage.NEW_ECLASS1__NEWECLASS4 :
				return neweclass4 != null;
			case EmapvselistentryPackage.NEW_ECLASS1__NEWECLASS5 :
				return neweclass5 != null;
		}
		return super.eIsSet(featureID);
	}

	@Override
	public Object accept(VisitorInterface visitor) {
		return visitor.visitemapvselistentry__NewEClass1(this);
	}
}
