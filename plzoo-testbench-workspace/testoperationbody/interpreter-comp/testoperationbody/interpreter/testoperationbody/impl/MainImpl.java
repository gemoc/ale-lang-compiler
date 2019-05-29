package testoperationbody.interpreter.testoperationbody.impl;

import java.lang.Boolean;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService;
import org.eclipse.emf.ecoretools.ale.compiler.lib.EqualService;
import org.eclipse.emf.ecoretools.ale.compiler.lib.LogService;
import testoperationbody.interpreter.testoperationbody.ChildA;
import testoperationbody.interpreter.testoperationbody.ConceptA;
import testoperationbody.interpreter.testoperationbody.Main;
import testoperationbody.interpreter.testoperationbody.Parent;
import testoperationbody.interpreter.testoperationbody.TestoperationbodyFactory;
import testoperationbody.interpreter.testoperationbody.TestoperationbodyPackage;

public class MainImpl extends MinimalEObjectImpl.Container implements Main {
	protected static final boolean SINGLEBOOL_EDEFAULT = false;

	protected EList<Integer> listint;

	protected boolean singlebool = SINGLEBOOL_EDEFAULT;

	protected EList<ConceptA> listconcepta;

	protected ConceptA singleconcepta;

	protected EList<Parent> children;

	protected MainImpl() {
		super();
	}

	@Override
	protected EClass eStaticClass() {
		return TestoperationbodyPackage.Literals.MAIN;
	}

	public EList<Integer> getListint() {
		if (listint == null) {
			listint = new EDataTypeUniqueEList<Integer>(Integer.class, this, TestoperationbodyPackage.MAIN__LISTINT);
		}
		return listint;
	}

	public EList<ConceptA> getListconcepta() {
		if (listconcepta == null) {
			listconcepta = new EObjectContainmentEList<ConceptA>(ConceptA.class, this, TestoperationbodyPackage.MAIN__LISTCONCEPTA);
		}
		return listconcepta;
	}

	public boolean isSinglebool() {
		return singlebool;
	}

	public void setSinglebool(boolean newSinglebool) {
		boolean oldSinglebool = singlebool;
		singlebool = newSinglebool;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TestoperationbodyPackage.MAIN__SINGLEBOOL, oldSinglebool, singlebool));
	}

	public ConceptA getSingleconcepta() {
		if (singleconcepta != null && singleconcepta.eIsProxy()) {
			InternalEObject oldSingleconcepta = (InternalEObject) singleconcepta;
			singleconcepta = (ConceptA) eResolveProxy(oldSingleconcepta);
			if (singleconcepta != oldSingleconcepta) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TestoperationbodyPackage.MAIN__SINGLECONCEPTA,
							oldSingleconcepta, singleconcepta));
			}
		}
		return singleconcepta;
	}

	public ConceptA basicGetSingleconcepta() {
		return singleconcepta;
	}

	public void setSingleconcepta(ConceptA newSingleconcepta) {
		ConceptA oldSingleconcepta = singleconcepta;
		singleconcepta = newSingleconcepta;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TestoperationbodyPackage.MAIN__SINGLECONCEPTA, oldSingleconcepta, singleconcepta));
	}

	public EList<Parent> getChildren() {
		if (children == null) {
			children = new EObjectContainmentEList<Parent>(Parent.class, this, TestoperationbodyPackage.MAIN__CHILDREN);
		}
		return children;
	}

	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
			NotificationChain msgs) {
		switch (featureID) {
			case TestoperationbodyPackage.MAIN__LISTCONCEPTA :
				return ((InternalEList<?>) getListconcepta()).basicRemove(otherEnd, msgs);
			case TestoperationbodyPackage.MAIN__CHILDREN :
				return ((InternalEList<?>) getChildren()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TestoperationbodyPackage.MAIN__LISTINT :
				return getListint();
			case TestoperationbodyPackage.MAIN__LISTCONCEPTA :
				return getListconcepta();
			case TestoperationbodyPackage.MAIN__SINGLEBOOL :
				return isSinglebool();
			case TestoperationbodyPackage.MAIN__SINGLECONCEPTA :
				if (resolve)
					return getSingleconcepta();
				return basicGetSingleconcepta();
			case TestoperationbodyPackage.MAIN__CHILDREN :
				return getChildren();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case TestoperationbodyPackage.MAIN__LISTINT :
				getListint().clear();
				getListint().addAll((Collection<? extends Integer>) newValue);
				return;
			case TestoperationbodyPackage.MAIN__LISTCONCEPTA :
				getListconcepta().clear();
				getListconcepta().addAll((Collection<? extends ConceptA>) newValue);
				return;
			case TestoperationbodyPackage.MAIN__SINGLEBOOL :
				setSinglebool((Boolean) newValue);
				return;
			case TestoperationbodyPackage.MAIN__SINGLECONCEPTA :
				setSingleconcepta((ConceptA) newValue);
				return;
			case TestoperationbodyPackage.MAIN__CHILDREN :
				getChildren().clear();
				getChildren().addAll((Collection<? extends Parent>) newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case TestoperationbodyPackage.MAIN__LISTINT :
				getListint().clear();
				return;
			case TestoperationbodyPackage.MAIN__LISTCONCEPTA :
				getListconcepta().clear();
				return;
			case TestoperationbodyPackage.MAIN__SINGLEBOOL :
				setSinglebool(SINGLEBOOL_EDEFAULT);
				return;
			case TestoperationbodyPackage.MAIN__SINGLECONCEPTA :
				setSingleconcepta((ConceptA) null);
				return;
			case TestoperationbodyPackage.MAIN__CHILDREN :
				getChildren().clear();
				return;
		}
		super.eUnset(featureID);
	}

	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case TestoperationbodyPackage.MAIN__LISTINT :
				return listint != null && !listint.isEmpty();
			case TestoperationbodyPackage.MAIN__LISTCONCEPTA :
				return listconcepta != null && !listconcepta.isEmpty();
			case TestoperationbodyPackage.MAIN__SINGLEBOOL :
				return singlebool != SINGLEBOOL_EDEFAULT;
			case TestoperationbodyPackage.MAIN__SINGLECONCEPTA :
				return singleconcepta != null;
			case TestoperationbodyPackage.MAIN__CHILDREN :
				return children != null && !children.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	public void testPolymorphism() {
		this.getChildren().add(TestoperationbodyFactory.eINSTANCE.createChildA());
		this.getChildren().add(TestoperationbodyFactory.eINSTANCE.createChildB());
		for (Parent child : this.getChildren()) {
			((Parent) (child)).overriden();
			((Parent) (child)).notOverriden();
			if (child instanceof ChildA) {
				((ChildA) (child)).onlyA();
			}
		}
	}

	public void main() {
		this.getListint().add(1);
		this.getListint().remove(1);
		this.getListconcepta().add(TestoperationbodyFactory.eINSTANCE.createConceptA());
		this.getListconcepta().remove(TestoperationbodyFactory.eINSTANCE.createConceptA());
		this.setSinglebool(false);
		this.setSingleconcepta(TestoperationbodyFactory.eINSTANCE.createConceptA());
		int a = ((int) (1));
		ConceptA b = ((ConceptA) (TestoperationbodyFactory.eINSTANCE.createConceptA()));
		EList<String> events = ((EList<String>) (CollectionService.createEList("event1", "event2")));
		EList<Integer> ax = ((EList<Integer>) (CollectionService.createEList(1)));
		for (int i1: this.listint) {
			CollectionService.size(this.listint);
			CollectionService.get(this.listint, 0);
			CollectionService.head(this.listint);
			CollectionService.isEmpty(this.listint);
			CollectionService.select(this.listint, (x) -> (x) > (3));
			CollectionService.exists(this.listint, (x) -> (x) > (3));
		}
		for (ConceptA i2 : this.getListconcepta()) {
			CollectionService.size(this.getListconcepta());
			CollectionService.get(this.getListconcepta(), 0);
			CollectionService.head(this.getListconcepta());
			CollectionService.isEmpty(this.getListconcepta());
			CollectionService.select(this.getListconcepta(), (x) -> ((ConceptA) (x)).op());
			CollectionService.exists(this.getListconcepta(), (x) -> ((ConceptA) (x)).op());
		}
		for (String i3: events) {
			CollectionService.size(events);
			CollectionService.get(events, 0);
			CollectionService.head(events);
			CollectionService.isEmpty(events);
			CollectionService.select(events, (x) -> !EqualService.equals((x), ("ok")));
			CollectionService.exists(events, (x) -> !EqualService.equals((x), ("ok")));
		}
		for (Integer i4: ax) {
			CollectionService.size(ax);
			CollectionService.get(ax, 0);
			CollectionService.head(ax);
			CollectionService.isEmpty(ax);
			CollectionService.select(ax, (x) -> (x) < (0));
			CollectionService.exists(ax, (x) -> (x) < (0));
		}
		LogService.log(((Main) (this)).ma());
		if ((((Main) (this)).ma()) < (12)) {
			LogService.log("ok");
		}
		else {
			LogService.log("fail");
		}
		int cptr = ((int) (1));
		while ((cptr) < (((Main) (this)).ma())) {
			cptr = (cptr) + (1);
		}
		boolean truz = ((boolean) (!(false)));
		boolean gt = ((boolean) ((1) > (2)));
		boolean ne = ((boolean) (!EqualService.equals((((Main) (this)).ma()), (42))));
		int x = ((int) ((CollectionService.get(this.listint, 0)) - (1)));
		int xd = ((int) ((43) / (3)));
		boolean eq = ((boolean) (EqualService.equals((((Main) (this)).ma()), (CollectionService.head(this.listint)))));
		boolean leq = ((boolean) ((12) <= (11)));
		boolean geq = ((boolean) ((12.3) >= (11)));
		double multpl = ((double) ((12.3) * (11.4)));
		int neg = ((int) (-(xd)));
	}

	public int ma() {
		int result;
		result = 452;
		return result;
	}
}
