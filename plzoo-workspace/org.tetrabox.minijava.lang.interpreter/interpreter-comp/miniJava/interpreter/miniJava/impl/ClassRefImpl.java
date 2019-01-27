package miniJava.interpreter.miniJava.impl;

import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.nodes.NodeInfo;
import java.lang.Object;
import miniJava.interpreter.miniJava.ClassRef;
import miniJava.interpreter.miniJava.MiniJavaPackage;
import miniJava.interpreter.miniJava.TypeDeclaration;
import miniJava.interpreter.miniJava.TypeRef;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

@NodeInfo(
    description = "ClassRef"
)
public class ClassRefImpl extends SingleTypeRefImpl implements ClassRef {
  protected TypeDeclaration referencedClass;

  protected ClassRefImpl() {
    super();
  }

  @TruffleBoundary
  public void setReferencedClass(TypeDeclaration newReferencedClass) {
    TypeDeclaration oldReferencedClass = referencedClass;
    referencedClass = newReferencedClass;
    if (eNotificationRequired())
    	eNotify(new ENotificationImpl(this, Notification.SET, MiniJavaPackage.CLASS_REF__REFERENCED_CLASS, oldReferencedClass, referencedClass));
  }

  @TruffleBoundary
  public TypeDeclaration getReferencedClass() {
    if (referencedClass != null && referencedClass.eIsProxy()) {
    	InternalEObject oldreferencedClass = (InternalEObject) referencedClass;
    	referencedClass = (TypeDeclaration) eResolveProxy(oldreferencedClass);
    	if (referencedClass != oldreferencedClass) {
    		if (eNotificationRequired())
    			eNotify(new ENotificationImpl(this, Notification.RESOLVE, MiniJavaPackage.CLASS_REF__REFERENCED_CLASS,
    					oldreferencedClass, referencedClass));
    	}
    }
    return referencedClass;
  }

  @TruffleBoundary
  protected EClass eStaticClass() {
    return MiniJavaPackage.Literals.CLASS_REF;}

  @TruffleBoundary
  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case MiniJavaPackage.CLASS_REF__REFERENCED_CLASS:
    	setReferencedClass((miniJava.interpreter.miniJava.TypeDeclaration) newValue);
    return;
    }
    super.eSet(featureID, newValue);
  }

  @TruffleBoundary
  public void eUnset(int featureID) {
    switch (featureID) {
    case MiniJavaPackage.CLASS_REF__REFERENCED_CLASS:
    	setReferencedClass((miniJava.interpreter.miniJava.TypeDeclaration) null);
    return;
    }
    super.eUnset(featureID);
  }

  @TruffleBoundary
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case MiniJavaPackage.CLASS_REF__REFERENCED_CLASS:
    return getReferencedClass();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  @TruffleBoundary
  public boolean eIsSet(int featureID) {
    switch (featureID) {
    case MiniJavaPackage.CLASS_REF__REFERENCED_CLASS:
    	return referencedClass != null;
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

  public boolean compare(TypeRef other) {
    boolean result;
    if(other instanceof miniJava.interpreter.miniJava.ClassRef) {
          miniJava.interpreter.miniJava.ClassRef ocr = ((miniJava.interpreter.miniJava.ClassRef)other);
          result = org.eclipse.emf.ecoretools.ale.compiler.lib.EqualService.equals((this.referencedClass), (ocr.getReferencedClass()));
        }
        else {
          result = false;
        }
        ;
    return result;
  }
}
