package interpreter.imp.interpreter.imp.impl;

import interpreter.imp.interpreter.imp.ArrayDecl;
import interpreter.imp.interpreter.imp.Expr;
import interpreter.imp.interpreter.imp.ImpPackage;
import java.lang.Object;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;

public class ArrayDeclImpl extends ExprImpl implements ArrayDecl {
  protected EList<Expr> values;

  protected ArrayDeclImpl() {
    super();
  }

  public EList<Expr> getValues() {
    if(values == null) {
    	values = new EObjectContainmentEList<Expr>(interpreter.imp.interpreter.imp.Expr.class, this, ImpPackage.ARRAY_DECL__VALUES);
    }
    return values;
  }

  protected EClass eStaticClass() {
    return ImpPackage.Literals.ARRAY_DECL;}

  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case ImpPackage.ARRAY_DECL__VALUES:
    	getValues().clear();
    	getValues().addAll((java.util.Collection<? extends interpreter.imp.interpreter.imp.Expr>) newValue);
    return;
    }
    super.eSet(featureID, newValue);
  }

  public void eUnset(int featureID) {
    switch (featureID) {
    case ImpPackage.ARRAY_DECL__VALUES:
    	getValues().clear();
    return;
    }
    super.eUnset(featureID);
  }

  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case ImpPackage.ARRAY_DECL__VALUES:
    return getValues();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  public boolean eIsSet(int featureID) {
    switch (featureID) {
    case ImpPackage.ARRAY_DECL__VALUES:
    	return values != null && !values.isEmpty();
    }
    return super.eIsSet(featureID);
  }

  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
      NotificationChain msgs) {
    switch(featureID) {
    case interpreter.imp.interpreter.imp.ImpPackage.ARRAY_DECL__VALUES:
    	return ((org.eclipse.emf.ecore.util.InternalEList<?>) getValues()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }
}
