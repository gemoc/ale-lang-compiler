package interpreter.imp.interpreter.imp.impl;

import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.nodes.Node.Child;
import com.oracle.truffle.api.nodes.NodeInfo;
import interpreter.imp.interpreter.imp.Expr;
import interpreter.imp.interpreter.imp.If;
import interpreter.imp.interpreter.imp.ImpPackage;
import interpreter.imp.interpreter.imp.Stmt;
import interpreter.imp.interpreter.imp.Store;
import java.lang.Object;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

@NodeInfo(
    description = "If"
)
public class IfImpl extends StmtImpl implements If {
  @Child
  protected Expr cond;

  @Child
  protected Stmt lhs;

  @Child
  protected Stmt rhs;

  protected IfImpl() {
    super();
  }

  @TruffleBoundary
  public void setCond(Expr newCond) {
    if (newCond != cond) {
    	NotificationChain msgs = null;
    	if (cond != null)
    		msgs = ((InternalEObject)cond).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - interpreter.imp.interpreter.imp.ImpPackage.IF__COND, null, msgs);
    	if (newCond != null)
    		msgs = ((InternalEObject)newCond).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - interpreter.imp.interpreter.imp.ImpPackage.IF__COND, null, msgs);
    	msgs = basicSetCond(newCond, msgs);
    	if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
    	eNotify(new ENotificationImpl(this, Notification.SET, interpreter.imp.interpreter.imp.ImpPackage.IF__COND, newCond, newCond));
  }

  @TruffleBoundary
  public NotificationChain basicSetCond(Expr newCond, NotificationChain msgs) {
    Expr oldCond = cond;
    cond = newCond;
    if (eNotificationRequired()) {
    	ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, interpreter.imp.interpreter.imp.ImpPackage.IF__COND, oldCond, newCond);
    	if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  @TruffleBoundary
  public Expr getCond() {
    return cond;}

  @TruffleBoundary
  public void setLhs(Stmt newLhs) {
    if (newLhs != lhs) {
    	NotificationChain msgs = null;
    	if (lhs != null)
    		msgs = ((InternalEObject)lhs).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - interpreter.imp.interpreter.imp.ImpPackage.IF__LHS, null, msgs);
    	if (newLhs != null)
    		msgs = ((InternalEObject)newLhs).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - interpreter.imp.interpreter.imp.ImpPackage.IF__LHS, null, msgs);
    	msgs = basicSetLhs(newLhs, msgs);
    	if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
    	eNotify(new ENotificationImpl(this, Notification.SET, interpreter.imp.interpreter.imp.ImpPackage.IF__LHS, newLhs, newLhs));
  }

  @TruffleBoundary
  public NotificationChain basicSetLhs(Stmt newLhs, NotificationChain msgs) {
    Stmt oldLhs = lhs;
    lhs = newLhs;
    if (eNotificationRequired()) {
    	ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, interpreter.imp.interpreter.imp.ImpPackage.IF__LHS, oldLhs, newLhs);
    	if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  @TruffleBoundary
  public Stmt getLhs() {
    return lhs;}

  @TruffleBoundary
  public void setRhs(Stmt newRhs) {
    if (newRhs != rhs) {
    	NotificationChain msgs = null;
    	if (rhs != null)
    		msgs = ((InternalEObject)rhs).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - interpreter.imp.interpreter.imp.ImpPackage.IF__RHS, null, msgs);
    	if (newRhs != null)
    		msgs = ((InternalEObject)newRhs).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - interpreter.imp.interpreter.imp.ImpPackage.IF__RHS, null, msgs);
    	msgs = basicSetRhs(newRhs, msgs);
    	if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
    	eNotify(new ENotificationImpl(this, Notification.SET, interpreter.imp.interpreter.imp.ImpPackage.IF__RHS, newRhs, newRhs));
  }

  @TruffleBoundary
  public NotificationChain basicSetRhs(Stmt newRhs, NotificationChain msgs) {
    Stmt oldRhs = rhs;
    rhs = newRhs;
    if (eNotificationRequired()) {
    	ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, interpreter.imp.interpreter.imp.ImpPackage.IF__RHS, oldRhs, newRhs);
    	if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  @TruffleBoundary
  public Stmt getRhs() {
    return rhs;}

  @TruffleBoundary
  protected EClass eStaticClass() {
    return ImpPackage.Literals.IF;}

  @TruffleBoundary
  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case ImpPackage.IF__COND:
    	setCond((interpreter.imp.interpreter.imp.Expr) newValue);
    return;
    case ImpPackage.IF__LHS:
    	setLhs((interpreter.imp.interpreter.imp.Stmt) newValue);
    return;
    case ImpPackage.IF__RHS:
    	setRhs((interpreter.imp.interpreter.imp.Stmt) newValue);
    return;
    }
    super.eSet(featureID, newValue);
  }

  @TruffleBoundary
  public void eUnset(int featureID) {
    switch (featureID) {
    case ImpPackage.IF__COND:
    	setCond((interpreter.imp.interpreter.imp.Expr) null);
    return;
    case ImpPackage.IF__LHS:
    	setLhs((interpreter.imp.interpreter.imp.Stmt) null);
    return;
    case ImpPackage.IF__RHS:
    	setRhs((interpreter.imp.interpreter.imp.Stmt) null);
    return;
    }
    super.eUnset(featureID);
  }

  @TruffleBoundary
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case ImpPackage.IF__COND:
    return getCond();
    case ImpPackage.IF__LHS:
    return getLhs();
    case ImpPackage.IF__RHS:
    return getRhs();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  @TruffleBoundary
  public boolean eIsSet(int featureID) {
    switch (featureID) {
    case ImpPackage.IF__COND:
    	return cond != null;
    case ImpPackage.IF__LHS:
    	return lhs != null;
    case ImpPackage.IF__RHS:
    	return rhs != null;
    }
    return super.eIsSet(featureID);
  }

  @TruffleBoundary
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
      NotificationChain msgs) {
    switch(featureID) {
    case interpreter.imp.interpreter.imp.ImpPackage.IF__COND:
    	return basicSetCond(null, msgs);
    case interpreter.imp.interpreter.imp.ImpPackage.IF__LHS:
    	return basicSetLhs(null, msgs);
    case interpreter.imp.interpreter.imp.ImpPackage.IF__RHS:
    	return basicSetRhs(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  public Store execute(Store s) {
    Store result;
    interpreter.imp.interpreter.imp.Value conde = ((interpreter.imp.interpreter.imp.Value)this.cond.evaluate(s));
        result = s;
        if(conde instanceof interpreter.imp.interpreter.imp.BoolValue) {
          interpreter.imp.interpreter.imp.BoolValue condeb = ((interpreter.imp.interpreter.imp.BoolValue)conde);
          if(condeb.isValue()) {
            result = this.lhs.execute(s);
          }
          else {
            result = this.rhs.execute(s);
          }
        }
        ;
    return result;
  }
}
