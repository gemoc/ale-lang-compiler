package interpreter.imp.interpreter.imp.impl;

import interpreter.imp.interpreter.imp.Expr;
import interpreter.imp.interpreter.imp.ImpPackage;
import interpreter.imp.interpreter.imp.Store;
import interpreter.imp.interpreter.imp.Unary;
import interpreter.imp.interpreter.imp.UnaryOp;
import interpreter.imp.interpreter.imp.Value;
import java.lang.Object;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

public class UnaryImpl extends ExprImpl implements Unary {
  protected static final UnaryOp OP_EDEFAULT = interpreter.imp.interpreter.imp.UnaryOp.NEGATE;

  protected UnaryOp op = OP_EDEFAULT;

  protected Expr expr;

  protected UnaryImpl() {
    super();
  }

  public UnaryOp getOp() {
    return op;}

  public void setOp(UnaryOp op) {
    this.op = op;}

  public void setExpr(Expr newExpr) {
    if (newExpr != expr) {
    	NotificationChain msgs = null;
    	if (expr != null)
    		msgs = ((InternalEObject)expr).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - interpreter.imp.interpreter.imp.ImpPackage.UNARY__EXPR, null, msgs);
    	if (newExpr != null)
    		msgs = ((InternalEObject)newExpr).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - interpreter.imp.interpreter.imp.ImpPackage.UNARY__EXPR, null, msgs);
    	msgs = basicSetExpr(newExpr, msgs);
    	if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
    	eNotify(new ENotificationImpl(this, Notification.SET, interpreter.imp.interpreter.imp.ImpPackage.UNARY__EXPR, newExpr, newExpr));
  }

  public NotificationChain basicSetExpr(Expr newExpr, NotificationChain msgs) {
    Expr oldExpr = expr;
    expr = newExpr;
    if (eNotificationRequired()) {
    	ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, interpreter.imp.interpreter.imp.ImpPackage.UNARY__EXPR, oldExpr, newExpr);
    	if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  public Expr getExpr() {
    return expr;}

  protected EClass eStaticClass() {
    return ImpPackage.Literals.UNARY;}

  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case ImpPackage.UNARY__OP:
    	setOp((interpreter.imp.interpreter.imp.UnaryOp) newValue);
    return;
    case ImpPackage.UNARY__EXPR:
    	setExpr((interpreter.imp.interpreter.imp.Expr) newValue);
    return;
    }
    super.eSet(featureID, newValue);
  }

  public void eUnset(int featureID) {
    switch (featureID) {
    case ImpPackage.UNARY__OP:
    	setOp(OP_EDEFAULT);
    return;
    case ImpPackage.UNARY__EXPR:
    	setExpr((interpreter.imp.interpreter.imp.Expr) null);
    return;
    }
    super.eUnset(featureID);
  }

  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case ImpPackage.UNARY__OP:
    return getOp();
    case ImpPackage.UNARY__EXPR:
    return getExpr();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  public boolean eIsSet(int featureID) {
    switch (featureID) {
    case ImpPackage.UNARY__OP:
    	return op != OP_EDEFAULT;
    case ImpPackage.UNARY__EXPR:
    	return expr != null;
    }
    return super.eIsSet(featureID);
  }

  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
      NotificationChain msgs) {
    switch(featureID) {
    case interpreter.imp.interpreter.imp.ImpPackage.UNARY__EXPR:
    	return basicSetExpr(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  public Value evaluate(Store s) {
    Value result;
    interpreter.imp.interpreter.imp.Value ev = ((interpreter.imp.interpreter.imp.Value)this.expr.evaluate(s));
        result = interpreter.imp.interpreter.imp.ImpFactory.eINSTANCE.createIntValue();
        if(java.util.Objects.equals((this.op.getValue()), (0))) {
          if(ev instanceof interpreter.imp.interpreter.imp.IntValue) {
            interpreter.imp.interpreter.imp.IntValue tmp = ((interpreter.imp.interpreter.imp.IntValue)ev);
            interpreter.imp.interpreter.imp.IntValue tmp2 = ((interpreter.imp.interpreter.imp.IntValue)interpreter.imp.interpreter.imp.ImpFactory.eINSTANCE.createIntValue());
            tmp2.setValue(-(tmp.getValue()));
            result = tmp2;
          }
        }
        else {
          if(java.util.Objects.equals((this.op.getValue()), (1))) {
            if(ev instanceof interpreter.imp.interpreter.imp.BoolValue) {
              interpreter.imp.interpreter.imp.BoolValue tmp = ((interpreter.imp.interpreter.imp.BoolValue)ev);
              interpreter.imp.interpreter.imp.BoolValue tmp2 = ((interpreter.imp.interpreter.imp.BoolValue)interpreter.imp.interpreter.imp.ImpFactory.eINSTANCE.createBoolValue());
              tmp2.setValue(!(tmp.isValue()));
              result = tmp2;
            }
          }
        }
        ;
    return result;
  }
}
