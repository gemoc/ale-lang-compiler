package visitor.boa.visitor.boa.impl;

import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import visitor.boa.visitor.boa.BoaPackage;
import visitor.boa.visitor.boa.Def;
import visitor.boa.visitor.boa.Expr;
import visitor.visitor.VisitorInterface;

public class DefImpl extends TopLevelCmdImpl implements Def {
  protected static final String NAME_EDEFAULT = null;

  protected String name = NAME_EDEFAULT;

  protected Expr expr;

  protected DefImpl() {
    super();
  }

  public String getName() {
    return name;}

  public void setName(String name) {
    this.name = name;}

  public void setExpr(Expr newExpr) {
    if (newExpr != expr) {
    	NotificationChain msgs = null;
    	if (expr != null)
    		msgs = ((InternalEObject)expr).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - visitor.boa.visitor.boa.BoaPackage.DEF__EXPR, null, msgs);
    	if (newExpr != null)
    		msgs = ((InternalEObject)newExpr).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - visitor.boa.visitor.boa.BoaPackage.DEF__EXPR, null, msgs);
    	msgs = basicSetExpr(newExpr, msgs);
    	if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
    	eNotify(new ENotificationImpl(this, Notification.SET, visitor.boa.visitor.boa.BoaPackage.DEF__EXPR, newExpr, newExpr));
  }

  public NotificationChain basicSetExpr(Expr newExpr, NotificationChain msgs) {
    Expr oldExpr = expr;
    expr = newExpr;
    if (eNotificationRequired()) {
    	ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, visitor.boa.visitor.boa.BoaPackage.DEF__EXPR, oldExpr, newExpr);
    	if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  public Expr getExpr() {
    return expr;}

  protected EClass eStaticClass() {
    return BoaPackage.Literals.DEF;}

  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case BoaPackage.DEF__NAME:
    	setName((java.lang.String) newValue);
    return;
    case BoaPackage.DEF__EXPR:
    	setExpr((visitor.boa.visitor.boa.Expr) newValue);
    return;
    }
    super.eSet(featureID, newValue);
  }

  public void eUnset(int featureID) {
    switch (featureID) {
    case BoaPackage.DEF__NAME:
    	setName(NAME_EDEFAULT);
    return;
    case BoaPackage.DEF__EXPR:
    	setExpr((visitor.boa.visitor.boa.Expr) null);
    return;
    }
    super.eUnset(featureID);
  }

  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case BoaPackage.DEF__NAME:
    return getName();
    case BoaPackage.DEF__EXPR:
    return getExpr();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  public boolean eIsSet(int featureID) {
    switch (featureID) {
    case BoaPackage.DEF__NAME:
    	return name != NAME_EDEFAULT;
    case BoaPackage.DEF__EXPR:
    	return expr != null;
    }
    return super.eIsSet(featureID);
  }

  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
      NotificationChain msgs) {
    switch(featureID) {
    case visitor.boa.visitor.boa.BoaPackage.DEF__EXPR:
    	return basicSetExpr(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  @Override
  public Object accept(VisitorInterface visitor) {
    return visitor.visitboa__Def(this);}
}
