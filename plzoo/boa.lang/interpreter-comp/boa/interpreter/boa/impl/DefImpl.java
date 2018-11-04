package boa.interpreter.boa.impl;

import boa.interpreter.boa.BoaPackage;
import boa.interpreter.boa.Ctx;
import boa.interpreter.boa.Def;
import boa.interpreter.boa.EvalRes;
import boa.interpreter.boa.Expr;
import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import java.lang.Object;
import java.lang.String;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

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

  @TruffleBoundary
  public void setExpr(Expr newExpr) {
    if (newExpr != expr) {
    	NotificationChain msgs = null;
    	if (expr != null)
    		msgs = ((InternalEObject)expr).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - boa.interpreter.boa.BoaPackage.DEF__EXPR, null, msgs);
    	if (newExpr != null)
    		msgs = ((InternalEObject)newExpr).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - boa.interpreter.boa.BoaPackage.DEF__EXPR, null, msgs);
    	msgs = basicSetExpr(newExpr, msgs);
    	if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
    	eNotify(new ENotificationImpl(this, Notification.SET, boa.interpreter.boa.BoaPackage.DEF__EXPR, newExpr, newExpr));
  }

  @TruffleBoundary
  public NotificationChain basicSetExpr(Expr newExpr, NotificationChain msgs) {
    Expr oldExpr = expr;
    expr = newExpr;
    if (eNotificationRequired()) {
    	ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, boa.interpreter.boa.BoaPackage.DEF__EXPR, oldExpr, newExpr);
    	if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  @TruffleBoundary
  public Expr getExpr() {
    return expr;}

  @TruffleBoundary
  protected EClass eStaticClass() {
    return BoaPackage.Literals.DEF;}

  @TruffleBoundary
  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case BoaPackage.DEF__NAME:
    	setName((java.lang.String) newValue);
    return;
    case BoaPackage.DEF__EXPR:
    	setExpr((boa.interpreter.boa.Expr) newValue);
    return;
    }
    super.eSet(featureID, newValue);
  }

  @TruffleBoundary
  public void eUnset(int featureID) {
    switch (featureID) {
    case BoaPackage.DEF__NAME:
    	setName(NAME_EDEFAULT);
    return;
    case BoaPackage.DEF__EXPR:
    	setExpr((boa.interpreter.boa.Expr) null);
    return;
    }
    super.eUnset(featureID);
  }

  @TruffleBoundary
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case BoaPackage.DEF__NAME:
    return getName();
    case BoaPackage.DEF__EXPR:
    return getExpr();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  @TruffleBoundary
  public boolean eIsSet(int featureID) {
    switch (featureID) {
    case BoaPackage.DEF__NAME:
    	return name != NAME_EDEFAULT;
    case BoaPackage.DEF__EXPR:
    	return expr != null;
    }
    return super.eIsSet(featureID);
  }

  @TruffleBoundary
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
      NotificationChain msgs) {
    switch(featureID) {
    case boa.interpreter.boa.BoaPackage.DEF__EXPR:
    	return basicSetExpr(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  public void nextLine(Ctx ctx) {
    EvalRes e = ((EvalRes)this.getExpr().eval(ctx));
    org.eclipse.emf.ecoretools.ale.compiler.lib.LogService.log(((this.getName()) + (" = ")) + (execboa.SerializeService.serialize(e)));
    execboa.MapService.put(ctx.getEnv(), this.getName(), e);
  }
}
