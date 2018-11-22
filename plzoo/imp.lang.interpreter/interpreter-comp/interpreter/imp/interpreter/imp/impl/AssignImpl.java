package interpreter.imp.interpreter.imp.impl;

import interpreter.imp.interpreter.imp.Assign;
import interpreter.imp.interpreter.imp.Expr;
import interpreter.imp.interpreter.imp.ImpPackage;
import interpreter.imp.interpreter.imp.Store;
import java.lang.Object;
import java.lang.String;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

public class AssignImpl extends StmtImpl implements Assign {
  protected static final String NAME_EDEFAULT = null;

  protected String name = NAME_EDEFAULT;

  protected Expr exp;

  protected AssignImpl() {
    super();
  }

  public String getName() {
    return name;}

  public void setName(String name) {
    this.name = name;}

  public void setExp(Expr newExp) {
    if (newExp != exp) {
    	NotificationChain msgs = null;
    	if (exp != null)
    		msgs = ((InternalEObject)exp).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - interpreter.imp.interpreter.imp.ImpPackage.ASSIGN__EXP, null, msgs);
    	if (newExp != null)
    		msgs = ((InternalEObject)newExp).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - interpreter.imp.interpreter.imp.ImpPackage.ASSIGN__EXP, null, msgs);
    	msgs = basicSetExp(newExp, msgs);
    	if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
    	eNotify(new ENotificationImpl(this, Notification.SET, interpreter.imp.interpreter.imp.ImpPackage.ASSIGN__EXP, newExp, newExp));
  }

  public NotificationChain basicSetExp(Expr newExp, NotificationChain msgs) {
    Expr oldExp = exp;
    exp = newExp;
    if (eNotificationRequired()) {
    	ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, interpreter.imp.interpreter.imp.ImpPackage.ASSIGN__EXP, oldExp, newExp);
    	if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  public Expr getExp() {
    return exp;}

  protected EClass eStaticClass() {
    return ImpPackage.Literals.ASSIGN;}

  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case ImpPackage.ASSIGN__NAME:
    	setName((java.lang.String) newValue);
    return;
    case ImpPackage.ASSIGN__EXP:
    	setExp((interpreter.imp.interpreter.imp.Expr) newValue);
    return;
    }
    super.eSet(featureID, newValue);
  }

  public void eUnset(int featureID) {
    switch (featureID) {
    case ImpPackage.ASSIGN__NAME:
    	setName(NAME_EDEFAULT);
    return;
    case ImpPackage.ASSIGN__EXP:
    	setExp((interpreter.imp.interpreter.imp.Expr) null);
    return;
    }
    super.eUnset(featureID);
  }

  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case ImpPackage.ASSIGN__NAME:
    return getName();
    case ImpPackage.ASSIGN__EXP:
    return getExp();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  public boolean eIsSet(int featureID) {
    switch (featureID) {
    case ImpPackage.ASSIGN__NAME:
    	return name != NAME_EDEFAULT;
    case ImpPackage.ASSIGN__EXP:
    	return exp != null;
    }
    return super.eIsSet(featureID);
  }

  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
      NotificationChain msgs) {
    switch(featureID) {
    case interpreter.imp.interpreter.imp.ImpPackage.ASSIGN__EXP:
    	return basicSetExp(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  public Store execute(Store s) {
    Store result;
    execimp.MapService.put(s.getValues(), this.name, this.exp.evaluate(s));
        result = s;
        ;
    return result;
  }
}
