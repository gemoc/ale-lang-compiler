package interpreter.imp.interpreter.imp.impl;

import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.nodes.LoopNode;
import com.oracle.truffle.api.nodes.Node.Child;
import com.oracle.truffle.api.nodes.NodeInfo;
import interpreter.imp.interpreter.imp.Expr;
import interpreter.imp.interpreter.imp.ImpPackage;
import interpreter.imp.interpreter.imp.Stmt;
import interpreter.imp.interpreter.imp.Store;
import interpreter.imp.interpreter.imp.While;
import java.lang.Object;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

@NodeInfo(
    description = "While"
)
public class WhileImpl extends StmtImpl implements While {
  @Child
  protected Expr cond;

  @Child
  protected Stmt body;


  protected WhileImpl() {
    super();
  }

  @TruffleBoundary
  public void setCond(Expr newCond) {
    if (newCond != cond) {
    	NotificationChain msgs = null;
    	if (cond != null)
    		msgs = ((InternalEObject)cond).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - interpreter.imp.interpreter.imp.ImpPackage.WHILE__COND, null, msgs);
    	if (newCond != null)
    		msgs = ((InternalEObject)newCond).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - interpreter.imp.interpreter.imp.ImpPackage.WHILE__COND, null, msgs);
    	msgs = basicSetCond(newCond, msgs);
    	if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
    	eNotify(new ENotificationImpl(this, Notification.SET, interpreter.imp.interpreter.imp.ImpPackage.WHILE__COND, newCond, newCond));
  }

  @TruffleBoundary
  public NotificationChain basicSetCond(Expr newCond, NotificationChain msgs) {
    Expr oldCond = cond;
    cond = newCond;
    if (eNotificationRequired()) {
    	ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, interpreter.imp.interpreter.imp.ImpPackage.WHILE__COND, oldCond, newCond);
    	if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  @TruffleBoundary
  public Expr getCond() {
    return cond;}

  @TruffleBoundary
  public void setBody(Stmt newBody) {
    if (newBody != body) {
    	NotificationChain msgs = null;
    	if (body != null)
    		msgs = ((InternalEObject)body).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - interpreter.imp.interpreter.imp.ImpPackage.WHILE__BODY, null, msgs);
    	if (newBody != null)
    		msgs = ((InternalEObject)newBody).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - interpreter.imp.interpreter.imp.ImpPackage.WHILE__BODY, null, msgs);
    	msgs = basicSetBody(newBody, msgs);
    	if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
    	eNotify(new ENotificationImpl(this, Notification.SET, interpreter.imp.interpreter.imp.ImpPackage.WHILE__BODY, newBody, newBody));
  }

  @TruffleBoundary
  public NotificationChain basicSetBody(Stmt newBody, NotificationChain msgs) {
    Stmt oldBody = body;
    body = newBody;
    if (eNotificationRequired()) {
    	ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, interpreter.imp.interpreter.imp.ImpPackage.WHILE__BODY, oldBody, newBody);
    	if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  @TruffleBoundary
  public Stmt getBody() {
    return body;}

  @TruffleBoundary
  protected EClass eStaticClass() {
    return ImpPackage.Literals.WHILE;}

  @TruffleBoundary
  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case ImpPackage.WHILE__COND:
    	setCond((interpreter.imp.interpreter.imp.Expr) newValue);
    return;
    case ImpPackage.WHILE__BODY:
    	setBody((interpreter.imp.interpreter.imp.Stmt) newValue);
    return;
    }
    super.eSet(featureID, newValue);
  }

  @TruffleBoundary
  public void eUnset(int featureID) {
    switch (featureID) {
    case ImpPackage.WHILE__COND:
    	setCond((interpreter.imp.interpreter.imp.Expr) null);
    return;
    case ImpPackage.WHILE__BODY:
    	setBody((interpreter.imp.interpreter.imp.Stmt) null);
    return;
    }
    super.eUnset(featureID);
  }

  @TruffleBoundary
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case ImpPackage.WHILE__COND:
    return getCond();
    case ImpPackage.WHILE__BODY:
    return getBody();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  @TruffleBoundary
  public boolean eIsSet(int featureID) {
    switch (featureID) {
    case ImpPackage.WHILE__COND:
    	return cond != null;
    case ImpPackage.WHILE__BODY:
    	return body != null;
    }
    return super.eIsSet(featureID);
  }

  @TruffleBoundary
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
      NotificationChain msgs) {
    switch(featureID) {
    case interpreter.imp.interpreter.imp.ImpPackage.WHILE__COND:
    	return basicSetCond(null, msgs);
    case interpreter.imp.interpreter.imp.ImpPackage.WHILE__BODY:
    	return basicSetBody(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  public Store execute(Store s) {
    Store result;
    boolean stop = ((boolean)false);
        interpreter.imp.interpreter.imp.Store tmp = ((interpreter.imp.interpreter.imp.Store)s);
        while (!(stop)) {
          interpreter.imp.interpreter.imp.Value conde = ((interpreter.imp.interpreter.imp.Value)this.cond.evaluate(s));
          if(conde instanceof interpreter.imp.interpreter.imp.BoolValue) {
            interpreter.imp.interpreter.imp.BoolValue condeb = ((interpreter.imp.interpreter.imp.BoolValue)conde);
            if(condeb.isValue()) {
              tmp = this.body.execute(tmp);
            }
            else {
              stop = true;
            }
          }
          else {
            stop = true;
          }
        }
        result = tmp;
        ;
    return result;
  }
}
