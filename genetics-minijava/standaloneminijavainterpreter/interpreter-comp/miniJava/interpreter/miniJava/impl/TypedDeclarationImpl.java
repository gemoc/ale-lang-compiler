package miniJava.interpreter.miniJava.impl;

import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.nodes.Node.Child;
import com.oracle.truffle.api.nodes.NodeInfo;
import java.lang.Object;
import miniJava.interpreter.miniJava.MiniJavaPackage;
import miniJava.interpreter.miniJava.TypeRef;
import miniJava.interpreter.miniJava.TypedDeclaration;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

@NodeInfo(
    description = "TypedDeclaration"
)
public class TypedDeclarationImpl extends NamedElementImpl implements TypedDeclaration {
  
  protected TypeRef typeRef;

  protected TypedDeclarationImpl() {
    super();
  }

  
  public void setTypeRef(TypeRef newTypeRef) {
    if (newTypeRef != typeRef) {
    	NotificationChain msgs = null;
    	if (typeRef != null)
    		msgs = ((InternalEObject)typeRef).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - miniJava.interpreter.miniJava.MiniJavaPackage.TYPED_DECLARATION__TYPE_REF, null, msgs);
    	if (newTypeRef != null)
    		msgs = ((InternalEObject)newTypeRef).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - miniJava.interpreter.miniJava.MiniJavaPackage.TYPED_DECLARATION__TYPE_REF, null, msgs);
    	msgs = basicSetTypeRef(newTypeRef, msgs);
    	if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
    	eNotify(new ENotificationImpl(this, Notification.SET, miniJava.interpreter.miniJava.MiniJavaPackage.TYPED_DECLARATION__TYPE_REF, newTypeRef, newTypeRef));
  }

  
  public NotificationChain basicSetTypeRef(TypeRef newTypeRef, NotificationChain msgs) {
    TypeRef oldTypeRef = typeRef;
    typeRef = newTypeRef;
    if (eNotificationRequired()) {
    	ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, miniJava.interpreter.miniJava.MiniJavaPackage.TYPED_DECLARATION__TYPE_REF, oldTypeRef, newTypeRef);
    	if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  
  public TypeRef getTypeRef() {
    return typeRef;
  }

  
  protected EClass eStaticClass() {
    return MiniJavaPackage.Literals.TYPED_DECLARATION;}

  
  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case MiniJavaPackage.TYPED_DECLARATION__TYPE_REF:
    	setTypeRef((miniJava.interpreter.miniJava.TypeRef) newValue);
    return;
    }
    super.eSet(featureID, newValue);
  }

  
  public void eUnset(int featureID) {
    switch (featureID) {
    case MiniJavaPackage.TYPED_DECLARATION__TYPE_REF:
    	setTypeRef((miniJava.interpreter.miniJava.TypeRef) null);
    return;
    }
    super.eUnset(featureID);
  }

  
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case MiniJavaPackage.TYPED_DECLARATION__TYPE_REF:
    return getTypeRef();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  
  public boolean eIsSet(int featureID) {
    switch (featureID) {
    case MiniJavaPackage.TYPED_DECLARATION__TYPE_REF:
    	return typeRef != null;
    }
    return super.eIsSet(featureID);
  }

  
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
      NotificationChain msgs) {
    switch(featureID) {
    case miniJava.interpreter.miniJava.MiniJavaPackage.TYPED_DECLARATION__TYPE_REF:
    	return basicSetTypeRef(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }
}
