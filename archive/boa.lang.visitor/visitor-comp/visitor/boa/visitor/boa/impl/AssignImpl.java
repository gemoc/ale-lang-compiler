package visitor.boa.visitor.boa.impl;

import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import visitor.boa.visitor.boa.Assign;
import visitor.boa.visitor.boa.BoaPackage;
import visitor.boa.visitor.boa.Expr;
import visitor.visitor.VisitorInterface;

public class AssignImpl extends ExprImpl implements Assign {
  protected static final String NAME_EDEFAULT = null;

  protected String name = NAME_EDEFAULT;

  protected Expr lhs;

  protected Expr rhs;

  protected AssignImpl() {
    super();
  }

  public String getName() {
    return name;}

  public void setName(String name) {
    this.name = name;}

  public void setLhs(Expr newLhs) {
    if (newLhs != lhs) {
    	NotificationChain msgs = null;
    	if (lhs != null)
    		msgs = ((InternalEObject)lhs).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - visitor.boa.visitor.boa.BoaPackage.ASSIGN__LHS, null, msgs);
    	if (newLhs != null)
    		msgs = ((InternalEObject)newLhs).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - visitor.boa.visitor.boa.BoaPackage.ASSIGN__LHS, null, msgs);
    	msgs = basicSetLhs(newLhs, msgs);
    	if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
    	eNotify(new ENotificationImpl(this, Notification.SET, visitor.boa.visitor.boa.BoaPackage.ASSIGN__LHS, newLhs, newLhs));
  }

  public NotificationChain basicSetLhs(Expr newLhs, NotificationChain msgs) {
    Expr oldLhs = lhs;
    lhs = newLhs;
    if (eNotificationRequired()) {
    	ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, visitor.boa.visitor.boa.BoaPackage.ASSIGN__LHS, oldLhs, newLhs);
    	if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  public Expr getLhs() {
    return lhs;}

  public void setRhs(Expr newRhs) {
    if (newRhs != rhs) {
    	NotificationChain msgs = null;
    	if (rhs != null)
    		msgs = ((InternalEObject)rhs).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - visitor.boa.visitor.boa.BoaPackage.ASSIGN__RHS, null, msgs);
    	if (newRhs != null)
    		msgs = ((InternalEObject)newRhs).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - visitor.boa.visitor.boa.BoaPackage.ASSIGN__RHS, null, msgs);
    	msgs = basicSetRhs(newRhs, msgs);
    	if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
    	eNotify(new ENotificationImpl(this, Notification.SET, visitor.boa.visitor.boa.BoaPackage.ASSIGN__RHS, newRhs, newRhs));
  }

  public NotificationChain basicSetRhs(Expr newRhs, NotificationChain msgs) {
    Expr oldRhs = rhs;
    rhs = newRhs;
    if (eNotificationRequired()) {
    	ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, visitor.boa.visitor.boa.BoaPackage.ASSIGN__RHS, oldRhs, newRhs);
    	if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  public Expr getRhs() {
    return rhs;}

  protected EClass eStaticClass() {
    return BoaPackage.Literals.ASSIGN;}

  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case BoaPackage.ASSIGN__LHS:
    	setLhs((visitor.boa.visitor.boa.Expr) newValue);
    return;
    case BoaPackage.ASSIGN__RHS:
    	setRhs((visitor.boa.visitor.boa.Expr) newValue);
    return;
    case BoaPackage.ASSIGN__NAME:
    	setName((java.lang.String) newValue);
    return;
    }
    super.eSet(featureID, newValue);
  }

  public void eUnset(int featureID) {
    switch (featureID) {
    case BoaPackage.ASSIGN__LHS:
    	setLhs((visitor.boa.visitor.boa.Expr) null);
    return;
    case BoaPackage.ASSIGN__RHS:
    	setRhs((visitor.boa.visitor.boa.Expr) null);
    return;
    case BoaPackage.ASSIGN__NAME:
    	setName(NAME_EDEFAULT);
    return;
    }
    super.eUnset(featureID);
  }

  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case BoaPackage.ASSIGN__LHS:
    return getLhs();
    case BoaPackage.ASSIGN__RHS:
    return getRhs();
    case BoaPackage.ASSIGN__NAME:
    return getName();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  public boolean eIsSet(int featureID) {
    switch (featureID) {
    case BoaPackage.ASSIGN__LHS:
    	return lhs != null;
    case BoaPackage.ASSIGN__RHS:
    	return rhs != null;
    case BoaPackage.ASSIGN__NAME:
    	return name != NAME_EDEFAULT;
    }
    return super.eIsSet(featureID);
  }

  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
      NotificationChain msgs) {
    switch(featureID) {
    case visitor.boa.visitor.boa.BoaPackage.ASSIGN__LHS:
    	return basicSetLhs(null, msgs);
    case visitor.boa.visitor.boa.BoaPackage.ASSIGN__RHS:
    	return basicSetRhs(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  @Override
  public Object accept(VisitorInterface visitor) {
    return visitor.visitboa__Assign(this);}
}
