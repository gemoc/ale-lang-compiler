package kmLogo.visitor.kmLogo.impl;

import java.lang.Object;
import java.lang.Override;
import kmLogo.visitor.kmLogo.Expression;
import kmLogo.visitor.kmLogo.KmLogoPackage;
import kmLogo.visitor.kmLogo.ProcCall;
import kmLogo.visitor.kmLogo.ProcDeclaration;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import visitor.VisitorInterface;

public class ProcCallImpl extends ExpressionImpl implements ProcCall {
  protected EList<Expression> actualArgs;

  protected ProcDeclaration declaration;

  protected ProcCallImpl() {
    super();
  }

  public EList<Expression> getActualArgs() {
    if(actualArgs == null) {
    	actualArgs = new EObjectContainmentEList<Expression>(kmLogo.visitor.kmLogo.Expression.class, this, KmLogoPackage.PROC_CALL__ACTUAL_ARGS);
    }
    return actualArgs;
  }

  public void setDeclaration(ProcDeclaration newDeclaration) {
    if (newDeclaration != declaration) {
    	NotificationChain msgs = null;
    	if (declaration != null)
    		msgs = ((InternalEObject) declaration).eInverseRemove(this, KmLogoPackage.PROC_DECLARATION__PROC_CALL, kmLogo.visitor.kmLogo.ProcDeclaration.class, msgs);
    	if (newDeclaration != null)
    		msgs = ((InternalEObject) newDeclaration).eInverseAdd(this, KmLogoPackage.PROC_DECLARATION__PROC_CALL, kmLogo.visitor.kmLogo.ProcDeclaration.class,
    				msgs);
    	msgs = basicSetDeclaration(newDeclaration, msgs);
    	if (msgs != null)
    		msgs.dispatch();
    } else if (eNotificationRequired())
    	eNotify(new ENotificationImpl(this, Notification.SET, KmLogoPackage.PROC_CALL__DECLARATION, newDeclaration, newDeclaration));
  }

  private NotificationChain basicSetDeclaration(ProcDeclaration newDeclaration,
      NotificationChain msgsp) {
    NotificationChain msgs = msgsp;
    ProcDeclaration oldDeclaration = declaration;
    declaration = newDeclaration;
    if (eNotificationRequired()) {
    	ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, KmLogoPackage.PROC_CALL__DECLARATION,
    			oldDeclaration, newDeclaration);
    	if (msgs == null)
    		msgs = notification;
    	else
    		msgs.add(notification);
    }
    return msgs;
  }

  public ProcDeclaration getDeclaration() {
    return declaration;}

  protected EClass eStaticClass() {
    return KmLogoPackage.Literals.PROC_CALL;}

  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case KmLogoPackage.PROC_CALL__ACTUAL_ARGS:
    	getActualArgs().clear();
    	getActualArgs().addAll((java.util.Collection<? extends kmLogo.visitor.kmLogo.Expression>) newValue);
    return;
    case KmLogoPackage.PROC_CALL__DECLARATION:
    	setDeclaration((kmLogo.visitor.kmLogo.ProcDeclaration) newValue);
    return;
    }
    super.eSet(featureID, newValue);
  }

  public void eUnset(int featureID) {
    switch (featureID) {
    case KmLogoPackage.PROC_CALL__ACTUAL_ARGS:
    	getActualArgs().clear();
    return;
    case KmLogoPackage.PROC_CALL__DECLARATION:
    	setDeclaration((kmLogo.visitor.kmLogo.ProcDeclaration) null);
    return;
    }
    super.eUnset(featureID);
  }

  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case KmLogoPackage.PROC_CALL__ACTUAL_ARGS:
    return getActualArgs();
    case KmLogoPackage.PROC_CALL__DECLARATION:
    return getDeclaration();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  public boolean eIsSet(int featureID) {
    switch (featureID) {
    case KmLogoPackage.PROC_CALL__ACTUAL_ARGS:
    	return actualArgs != null && !actualArgs.isEmpty();
    case KmLogoPackage.PROC_CALL__DECLARATION:
    	return declaration != null;
    }
    return super.eIsSet(featureID);
  }

  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
      NotificationChain msgs) {
    switch(featureID) {
    case kmLogo.visitor.kmLogo.KmLogoPackage.PROC_CALL__ACTUAL_ARGS:
    	return ((org.eclipse.emf.ecore.util.InternalEList<?>) getActualArgs()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID,
      NotificationChain msgs2) {
    NotificationChain msgs = msgs2;
    switch (featureID) {

    case KmLogoPackage.PROC_CALL__DECLARATION:
    	if (declaration != null)
    		msgs = ((org.eclipse.emf.ecore.InternalEObject) declaration).eInverseRemove(this, KmLogoPackage.PROC_DECLARATION__PROC_CALL, ProcDeclaration.class,
    				msgs);
    	return basicSetDeclaration((kmLogo.visitor.kmLogo.ProcDeclaration) otherEnd, msgs);
    }
    return super.eInverseAdd(otherEnd, featureID, msgs);
  }

  @Override
  public Object accept(VisitorInterface visitor) {
    return visitor.visitkmLogo__ProcCall(this);}
}
