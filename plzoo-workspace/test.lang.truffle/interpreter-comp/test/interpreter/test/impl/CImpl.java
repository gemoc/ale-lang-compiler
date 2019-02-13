package test.interpreter.test.impl;

import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.nodes.Node.Child;
import com.oracle.truffle.api.nodes.NodeInfo;
import java.lang.Object;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecoretools.ale.compiler.truffle.MinimalTruffleEObjectImpl;
import test.interpreter.test.A;
import test.interpreter.test.B;
import test.interpreter.test.C;
import test.interpreter.test.TestPackage;

@NodeInfo(
    description = "C"
)
public class CImpl extends MinimalTruffleEObjectImpl.TruffleContainer implements C {
  protected B b;

  protected A a;

  @Child
  private ADispatchEval dispatchAEval;

  protected CImpl() {
    super();
    this.dispatchAEval = test.interpreter.test.impl.ADispatchEvalNodeGen.create(); 
  }

  @TruffleBoundary
  public void setB(B newB) {
    B oldB = b;
    b = newB;
    if (eNotificationRequired())
    	eNotify(new ENotificationImpl(this, Notification.SET, TestPackage.C__B, oldB, b));
  }

  @TruffleBoundary
  public B getB() {
    if (b != null && b.eIsProxy()) {
    	InternalEObject oldb = (InternalEObject) b;
    	b = (B) eResolveProxy(oldb);
    	if (b != oldb) {
    		if (eNotificationRequired())
    			eNotify(new ENotificationImpl(this, Notification.RESOLVE, TestPackage.C__B,
    					oldb, b));
    	}
    }
    return b;
  }

  @TruffleBoundary
  public void setA(A newA) {
    A oldA = a;
    a = newA;
    if (eNotificationRequired())
    	eNotify(new ENotificationImpl(this, Notification.SET, TestPackage.C__A, oldA, a));
  }

  @TruffleBoundary
  public A getA() {
    if (a != null && a.eIsProxy()) {
    	InternalEObject olda = (InternalEObject) a;
    	a = (A) eResolveProxy(olda);
    	if (a != olda) {
    		if (eNotificationRequired())
    			eNotify(new ENotificationImpl(this, Notification.RESOLVE, TestPackage.C__A,
    					olda, a));
    	}
    }
    return a;
  }

  @TruffleBoundary
  protected EClass eStaticClass() {
    return TestPackage.Literals.C;}

  @TruffleBoundary
  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case TestPackage.C__B:
    	setB((test.interpreter.test.B) newValue);
    return;
    case TestPackage.C__A:
    	setA((test.interpreter.test.A) newValue);
    return;
    }
    super.eSet(featureID, newValue);
  }

  @TruffleBoundary
  public void eUnset(int featureID) {
    switch (featureID) {
    case TestPackage.C__B:
    	setB((test.interpreter.test.B) null);
    return;
    case TestPackage.C__A:
    	setA((test.interpreter.test.A) null);
    return;
    }
    super.eUnset(featureID);
  }

  @TruffleBoundary
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case TestPackage.C__B:
    return getB();
    case TestPackage.C__A:
    return getA();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  @TruffleBoundary
  public boolean eIsSet(int featureID) {
    switch (featureID) {
    case TestPackage.C__B:
    	return b != null;
    case TestPackage.C__A:
    	return a != null;
    }
    return super.eIsSet(featureID);
  }

  @TruffleBoundary
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
      NotificationChain msgs) {
    switch(featureID) {
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  public void run() {
    dispatchAEval.executeDispatch(this.a.getCachedEval(), new Object[] {});
        dispatchAEval.executeDispatch(this.b.getCachedEval(), new Object[] {});
        ;
  }
}
