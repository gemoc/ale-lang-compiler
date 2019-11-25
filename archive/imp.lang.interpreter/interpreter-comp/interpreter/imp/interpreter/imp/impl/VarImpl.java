package interpreter.imp.interpreter.imp.impl;

import interpreter.imp.interpreter.imp.Expr;
import interpreter.imp.interpreter.imp.ImpPackage;
import interpreter.imp.interpreter.imp.Store;
import interpreter.imp.interpreter.imp.Value;
import interpreter.imp.interpreter.imp.Var;
import java.lang.Object;
import java.lang.String;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

public class VarImpl extends ExprImpl implements Var {
  protected static final String NAME_EDEFAULT = null;

  protected String name = NAME_EDEFAULT;

  protected Expr index;

  protected VarImpl() {
    super();
  }

  public String getName() {
    return name;}

  public void setName(String name) {
    this.name = name;}

  public void setIndex(Expr newIndex) {
    if (newIndex != index) {
    	NotificationChain msgs = null;
    	if (index != null)
    		msgs = ((InternalEObject)index).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - interpreter.imp.interpreter.imp.ImpPackage.VAR__INDEX, null, msgs);
    	if (newIndex != null)
    		msgs = ((InternalEObject)newIndex).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - interpreter.imp.interpreter.imp.ImpPackage.VAR__INDEX, null, msgs);
    	msgs = basicSetIndex(newIndex, msgs);
    	if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
    	eNotify(new ENotificationImpl(this, Notification.SET, interpreter.imp.interpreter.imp.ImpPackage.VAR__INDEX, newIndex, newIndex));
  }

  public NotificationChain basicSetIndex(Expr newIndex, NotificationChain msgs) {
    Expr oldIndex = index;
    index = newIndex;
    if (eNotificationRequired()) {
    	ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, interpreter.imp.interpreter.imp.ImpPackage.VAR__INDEX, oldIndex, newIndex);
    	if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  public Expr getIndex() {
    return index;}

  protected EClass eStaticClass() {
    return ImpPackage.Literals.VAR;}

  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case ImpPackage.VAR__NAME:
    	setName((java.lang.String) newValue);
    return;
    case ImpPackage.VAR__INDEX:
    	setIndex((interpreter.imp.interpreter.imp.Expr) newValue);
    return;
    }
    super.eSet(featureID, newValue);
  }

  public void eUnset(int featureID) {
    switch (featureID) {
    case ImpPackage.VAR__NAME:
    	setName(NAME_EDEFAULT);
    return;
    case ImpPackage.VAR__INDEX:
    	setIndex((interpreter.imp.interpreter.imp.Expr) null);
    return;
    }
    super.eUnset(featureID);
  }

  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case ImpPackage.VAR__NAME:
    return getName();
    case ImpPackage.VAR__INDEX:
    return getIndex();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  public boolean eIsSet(int featureID) {
    switch (featureID) {
    case ImpPackage.VAR__NAME:
    	return name != NAME_EDEFAULT;
    case ImpPackage.VAR__INDEX:
    	return index != null;
    }
    return super.eIsSet(featureID);
  }

  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
      NotificationChain msgs) {
    switch(featureID) {
    case interpreter.imp.interpreter.imp.ImpPackage.VAR__INDEX:
    	return basicSetIndex(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  public Value evaluate(Store s) {
    Value result;
    result = interpreter.imp.interpreter.imp.ImpFactory.eINSTANCE.createIntValue();
        if(!(java.util.Objects.equals((this.index), (null)))) {
          interpreter.imp.interpreter.imp.Value idx = ((interpreter.imp.interpreter.imp.Value)this.index.evaluate(s));
          interpreter.imp.interpreter.imp.Value elem = ((interpreter.imp.interpreter.imp.Value)execimp.MapService.getFromMap(s.getValues(), this.name));
          if(elem instanceof interpreter.imp.interpreter.imp.ArrayValue) {
            interpreter.imp.interpreter.imp.ArrayValue aelem = ((interpreter.imp.interpreter.imp.ArrayValue)elem);
            if(idx instanceof interpreter.imp.interpreter.imp.IntValue) {
              interpreter.imp.interpreter.imp.IntValue iidx = ((interpreter.imp.interpreter.imp.IntValue)idx);
              result = aelem.getValues().get(iidx.getValue());
            }
          }
        }
        else {
          result = execimp.MapService.getFromMap(s.getValues(), this.name);
        }
        ;
    return result;
  }
}
