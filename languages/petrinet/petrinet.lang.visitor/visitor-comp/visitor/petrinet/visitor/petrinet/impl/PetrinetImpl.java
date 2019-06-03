package visitor.petrinet.visitor.petrinet.impl;

import java.lang.Object;
import java.lang.Override;
import java.util.Collection;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import visitor.petrinet.visitor.petrinet.Arc;
import visitor.petrinet.visitor.petrinet.Node;
import visitor.petrinet.visitor.petrinet.Petrinet;
import visitor.petrinet.visitor.petrinet.PetrinetPackage;
import visitor.visitor.VisitorInterface;

public class PetrinetImpl extends MinimalEObjectImpl.Container implements Petrinet {
	protected EList<Node> nodes;

	protected EList<Arc> arcs;

	protected PetrinetImpl() {
		super();
	}

	@Override
	protected EClass eStaticClass() {
		return PetrinetPackage.Literals.PETRINET;
	}

	public EList<Node> getNodes() {
		if (nodes == null) {
			nodes = new EObjectContainmentEList<Node>(Node.class, this, PetrinetPackage.PETRINET__NODES);
		}
		return nodes;
	}

	public EList<Arc> getArcs() {
		if (arcs == null) {
			arcs = new EObjectContainmentEList<Arc>(Arc.class, this, PetrinetPackage.PETRINET__ARCS);
		}
		return arcs;
	}

	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
			NotificationChain msgs) {
		switch (featureID) {
			case PetrinetPackage.PETRINET__NODES :
				return ((InternalEList<?>) getNodes()).basicRemove(otherEnd, msgs);
			case PetrinetPackage.PETRINET__ARCS :
				return ((InternalEList<?>) getArcs()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case PetrinetPackage.PETRINET__NODES :
				return getNodes();
			case PetrinetPackage.PETRINET__ARCS :
				return getArcs();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case PetrinetPackage.PETRINET__NODES :
				getNodes().clear();
				getNodes().addAll((Collection<? extends Node>) newValue);
				return;
			case PetrinetPackage.PETRINET__ARCS :
				getArcs().clear();
				getArcs().addAll((Collection<? extends Arc>) newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case PetrinetPackage.PETRINET__NODES :
				getNodes().clear();
				return;
			case PetrinetPackage.PETRINET__ARCS :
				getArcs().clear();
				return;
		}
		super.eUnset(featureID);
	}

	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case PetrinetPackage.PETRINET__NODES :
				return nodes != null && !nodes.isEmpty();
			case PetrinetPackage.PETRINET__ARCS :
				return arcs != null && !arcs.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	@Override
	public Object accept(VisitorInterface visitor) {
		return visitor.visitpetrinet__Petrinet(this);
	}
}
