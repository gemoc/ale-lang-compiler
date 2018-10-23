package kmLogo.interpreter.kmLogo.impl;

import java.lang.Object;
import kmLogo.interpreter.kmLogo.Expression;
import kmLogo.interpreter.kmLogo.Instruction;
import kmLogo.interpreter.kmLogo.KmLogoPackage;
import kmLogo.interpreter.kmLogo.ProcCall;
import kmLogo.interpreter.kmLogo.ProcDeclaration;
import kmLogo.interpreter.kmLogo.StackFrame;
import kmLogo.interpreter.kmLogo.Turtle;
import kmLogo.interpreter.kmLogo.Variable;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;

public class ProcCallImpl extends ExpressionImpl implements ProcCall {
  private EList<Expression> actualArgs;

  private ProcDeclaration declaration;

  public EList<Expression> getActualArgs() {
    if(actualArgs == null) {
    	actualArgs = new EObjectContainmentEList<Expression>(kmLogo.interpreter.kmLogo.Expression.class, this, KmLogoPackage.PROC_CALL__ACTUAL_ARGS);
    }
    return actualArgs;
  }

  public void setDeclaration(ProcDeclaration newDeclaration) {
    if (newDeclaration != declaration) {
    	NotificationChain msgs = null;
    	if (declaration != null)
    		msgs = ((InternalEObject) declaration).eInverseRemove(this, KmLogoPackage.PROC_DECLARATION__PROC_CALL, kmLogo.interpreter.kmLogo.ProcDeclaration.class, msgs);
    	if (newDeclaration != null)
    		msgs = ((InternalEObject) newDeclaration).eInverseAdd(this, KmLogoPackage.PROC_DECLARATION__PROC_CALL, kmLogo.interpreter.kmLogo.ProcDeclaration.class,
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
    	getActualArgs().addAll((java.util.Collection<? extends kmLogo.interpreter.kmLogo.impl.ExpressionImpl>) newValue);
    return;
    case KmLogoPackage.PROC_CALL__DECLARATION:
    	setDeclaration((kmLogo.interpreter.kmLogo.impl.ProcDeclarationImpl) newValue);
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
    	setDeclaration((kmLogo.interpreter.kmLogo.impl.ProcDeclarationImpl) null);
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
    	return actualArgs != null;
    case KmLogoPackage.PROC_CALL__DECLARATION:
    	return declaration != null;
    }
    return super.eIsSet(featureID);
  }

  public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID,
      NotificationChain msgs2) {
    NotificationChain msgs = msgs2;
    switch (featureID) {

    case KmLogoPackage.PROC_CALL__DECLARATION:
    	if (declaration != null)
    		msgs = ((org.eclipse.emf.ecore.InternalEObject) declaration).eInverseRemove(this, KmLogoPackage.PROC_DECLARATION__PROC_CALL, ProcDeclaration.class,
    				msgs);
    	return basicSetDeclaration((kmLogo.interpreter.kmLogo.ProcDeclaration) otherEnd, msgs);
    }
    return super.eInverseAdd(otherEnd, featureID, msgs);
  }

  public double eval(Turtle turtle) {
    double result;
    org.eclipse.emf.ecoretools.ale.compiler.lib.LogService.log(("Calling ") + (this.getDeclaration().getName()));
    StackFrame newFrame = ((StackFrame)kmLogo.interpreter.kmLogo.KmLogoFactory.eINSTANCE.createStackFrame());
    int i = ((int)1);
    for(Expression exp: this.getActualArgs()) {
      Variable newVar = ((Variable)kmLogo.interpreter.kmLogo.KmLogoFactory.eINSTANCE.createVariable());
      newVar.setName(org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService.get(this.getDeclaration().getArgs(), i).getName());
      newVar.setValue(exp.eval(turtle));
      newFrame.getVariables().add(newVar);
      i = (i) + (1);
    }
    turtle.getCallStack().getFrames().add(newFrame);
    result = 0.0;
    for(Instruction instr: this.getDeclaration().getInstructions()) {
      result = instr.eval(turtle);
    }
    turtle.getCallStack().getFrames().remove(newFrame);
    return result;
  }
}
