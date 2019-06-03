package visitor.petrinet.visitor.petrinet.impl;

import java.lang.Object;
import java.lang.Override;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import visitor.petrinet.visitor.petrinet.Arc;
import visitor.petrinet.visitor.petrinet.Node;
import visitor.petrinet.visitor.petrinet.PetrinetPackage;
import visitor.visitor.VisitorInterface;

public class ArcImpl extends MinimalEObjectImpl.Container implements Arc {
	protected Node target;

	protected Node source;

	protected ArcImpl() {
		super();
	}

	@Override
	protected EClass eStaticClass() {
		return PetrinetPackage.Literals.ARC;
	}

	public Node getTarget() {
		if (target != null && target.eIsProxy()) {
			InternalEObject oldTarget = (InternalEObject) target;
			target = (Node) eResolveProxy(oldTarget);
			if (target != oldTarget) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PetrinetPackage.ARC__TARGET, oldTarget, target));
			}
		}
		return target;
	}

	public Node basicGetTarget() {
		return target;
	}

	public NotificationChain basicSetTarget(Node newTarget, NotificationChain msgs) {
		Node oldTarget = target;
		target = newTarget;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PetrinetPackage.ARC__TARGET, oldTarget, newTarget);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	public void setTarget(Node newTarget) {
		if (newTarget != target) {
			NotificationChain msgs = null;
			if (target != null)
				msgs = ((InternalEObject) target).eInverseRemove(this, PetrinetPackage.NODE__INCOMMING, Node.class, msgs);
			if (newTarget != null)
				msgs = ((InternalEObject) newTarget).eInverseAdd(this, PetrinetPackage.NODE__INCOMMING, Node.class, msgs);
			msgs = basicSetTarget(newTarget, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PetrinetPackage.ARC__TARGET, newTarget, newTarget));
	}

	public Node getSource() {
		if (source != null && source.eIsProxy()) {
			InternalEObject oldSource = (InternalEObject) source;
			source = (Node) eResolveProxy(oldSource);
			if (source != oldSource) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PetrinetPackage.ARC__SOURCE, oldSource, source));
			}
		}
		return source;
	}

	public Node basicGetSource() {
		return source;
	}

	public NotificationChain basicSetSource(Node newSource, NotificationChain msgs) {
		Node oldSource = source;
		source = newSource;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PetrinetPackage.ARC__SOURCE, oldSource, newSource);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	public void setSource(Node newSource) {
		if (newSource != source) {
			NotificationChain msgs = null;
			if (source != null)
				msgs = ((InternalEObject) source).eInverseRemove(this, PetrinetPackage.NODE__OUTGOING, Node.class, msgs);
			if (newSource != null)
				msgs = ((InternalEObject) newSource).eInverseAdd(this, PetrinetPackage.NODE__OUTGOING, Node.class, msgs);
			msgs = basicSetSource(newSource, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PetrinetPackage.ARC__SOURCE, newSource, newSource));
	}

	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID,
			NotificationChain msgs) {
		switch (featureID) {
			case PetrinetPackage.ARC__TARGET :
				if (target != null)
					msgs = ((InternalEObject) target).eInverseRemove(this, PetrinetPackage.NODE__INCOMMING, Node.class, msgs);
				return basicSetTarget((Node) otherEnd, msgs);
			case PetrinetPackage.ARC__SOURCE :
				if (source != null)
					msgs = ((InternalEObject) source).eInverseRemove(this, PetrinetPackage.NODE__OUTGOING, Node.class, msgs);
				return basicSetSource((Node) otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
			NotificationChain msgs) {
		switch (featureID) {
			case PetrinetPackage.ARC__TARGET :
				return basicSetTarget(null, msgs);
			case PetrinetPackage.ARC__SOURCE :
				return basicSetSource(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case PetrinetPackage.ARC__TARGET :
				if (resolve)
					return getTarget();
				return basicGetTarget();
			case PetrinetPackage.ARC__SOURCE :
				if (resolve)
					return getSource();
				return basicGetSource();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case PetrinetPackage.ARC__TARGET :
				setTarget((Node) newValue);
				return;
			case PetrinetPackage.ARC__SOURCE :
				setSource((Node) newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case PetrinetPackage.ARC__TARGET :
				setTarget((Node) null);
				return;
			case PetrinetPackage.ARC__SOURCE :
				setSource((Node) null);
				return;
		}
		super.eUnset(featureID);
	}

	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case PetrinetPackage.ARC__TARGET :
				return target != null;
			case PetrinetPackage.ARC__SOURCE :
				return source != null;
		}
		return super.eIsSet(featureID);
	}

	@Override
	public Object accept(VisitorInterface visitor) {
		return visitor.visitpetrinet__Arc(this);
	}
}
