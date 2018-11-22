package kmLogo.interpreter.kmLogo.impl;

import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.nodes.Node.Children;
import com.oracle.truffle.api.nodes.NodeInfo;
import java.lang.Object;
import kmLogo.interpreter.kmLogo.Expression;
import kmLogo.interpreter.kmLogo.KmLogoPackage;
import kmLogo.interpreter.kmLogo.ProcCall;
import kmLogo.interpreter.kmLogo.ProcDeclaration;
import kmLogo.interpreter.kmLogo.Turtle;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;

@NodeInfo(
    description = "ProcCall"
)
public class ProcCallImpl extends ExpressionImpl implements ProcCall {
  protected EList<Expression> actualArgs;

  protected ProcDeclaration declaration;

  @Children
  private Expression[] actualArgsArr;

  private ProcDeclarationDispatchEval dispatchProcDeclarationEval;

  protected ProcCallImpl() {
    super();
    this.dispatchProcDeclarationEval = kmLogo.interpreter.kmLogo.impl.ProcDeclarationDispatchEvalNodeGen.create(); 
  }

  @TruffleBoundary
  public EList<Expression> getActualArgs() {
    if(actualArgs == null) {
    	actualArgs = new EObjectContainmentEList<Expression>(kmLogo.interpreter.kmLogo.Expression.class, this, KmLogoPackage.PROC_CALL__ACTUAL_ARGS);
    }
    return actualArgs;
  }

  @TruffleBoundary
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

  @TruffleBoundary
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

  @TruffleBoundary
  public ProcDeclaration getDeclaration() {
    return declaration;}

  @TruffleBoundary
  protected EClass eStaticClass() {
    return KmLogoPackage.Literals.PROC_CALL;}

  @TruffleBoundary
  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case KmLogoPackage.PROC_CALL__ACTUAL_ARGS:
    	getActualArgs().clear();
    	getActualArgs().addAll((java.util.Collection<? extends kmLogo.interpreter.kmLogo.Expression>) newValue);
    return;
    case KmLogoPackage.PROC_CALL__DECLARATION:
    	setDeclaration((kmLogo.interpreter.kmLogo.ProcDeclaration) newValue);
    return;
    }
    super.eSet(featureID, newValue);
  }

  @TruffleBoundary
  public void eUnset(int featureID) {
    switch (featureID) {
    case KmLogoPackage.PROC_CALL__ACTUAL_ARGS:
    	getActualArgs().clear();
    return;
    case KmLogoPackage.PROC_CALL__DECLARATION:
    	setDeclaration((kmLogo.interpreter.kmLogo.ProcDeclaration) null);
    return;
    }
    super.eUnset(featureID);
  }

  @TruffleBoundary
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case KmLogoPackage.PROC_CALL__ACTUAL_ARGS:
    return getActualArgs();
    case KmLogoPackage.PROC_CALL__DECLARATION:
    return getDeclaration();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  @TruffleBoundary
  public boolean eIsSet(int featureID) {
    switch (featureID) {
    case KmLogoPackage.PROC_CALL__ACTUAL_ARGS:
    	return actualArgs != null && !actualArgs.isEmpty();
    case KmLogoPackage.PROC_CALL__DECLARATION:
    	return declaration != null;
    }
    return super.eIsSet(featureID);
  }

  @TruffleBoundary
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
      NotificationChain msgs) {
    switch(featureID) {
    case kmLogo.interpreter.kmLogo.KmLogoPackage.PROC_CALL__ACTUAL_ARGS:
    	return ((org.eclipse.emf.ecore.util.InternalEList<?>) getActualArgs()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  @TruffleBoundary
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
    if(this.actualArgsArr == null) {
        				com.oracle.truffle.api.CompilerDirectives.transferToInterpreterAndInvalidate();
        				this.actualArgsArr = this.actualArgs.toArray(new kmLogo.interpreter.kmLogo.Expression[0]);
        			};
    org.eclipse.emf.ecoretools.ale.compiler.lib.LogService.log(("Calling ") + (this.declaration.getName()));
        kmLogo.interpreter.kmLogo.StackFrame newFrame = ((kmLogo.interpreter.kmLogo.StackFrame)kmLogo.interpreter.kmLogo.KmLogoFactory.eINSTANCE.createStackFrame());
        int i = ((int)1);
        for(kmLogo.interpreter.kmLogo.Expression exp: this.actualArgsArr) {
          kmLogo.interpreter.kmLogo.Variable newVar = ((kmLogo.interpreter.kmLogo.Variable)kmLogo.interpreter.kmLogo.KmLogoFactory.eINSTANCE.createVariable());
          newVar.setName(org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService.get(this.declaration.getArgs(), i).getName());
          newVar.setValue(exp.eval(turtle));
          newFrame.getVariables().add(newVar);
          i = (i) + (1);
        }
        turtle.getCallStack().getFrames().add(newFrame);
        result = 0.0;
        if(this.declaration instanceof kmLogo.interpreter.kmLogo.ProcDeclaration) {
          kmLogo.interpreter.kmLogo.ProcDeclaration decl = ((kmLogo.interpreter.kmLogo.ProcDeclaration)this.declaration);
          dispatchProcDeclarationEval.executeDispatch(decl.getCachedEval(), new Object[] {turtle});
        }
        turtle.getCallStack().getFrames().remove(newFrame);
        ;
    return result;
  }
}
