package miniJava.interpreter.miniJava.impl;

import java.lang.Object;
import miniJava.interpreter.miniJava.Expression;
import miniJava.interpreter.miniJava.Method;
import miniJava.interpreter.miniJava.MethodCall;
import miniJava.interpreter.miniJava.MiniJavaPackage;
import miniJava.interpreter.miniJava.State;
import miniJava.interpreter.miniJava.Value;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;

public class MethodCallImpl extends ExpressionImpl implements MethodCall {
  protected Expression receiver;

  protected Method method;

  protected EList<Expression> args;

  protected MethodCallImpl() {
    super();
  }

  public void setReceiver(Expression newReceiver) {
    if (newReceiver != receiver) {
    	NotificationChain msgs = null;
    	if (receiver != null)
    		msgs = ((InternalEObject)receiver).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - miniJava.interpreter.miniJava.MiniJavaPackage.METHOD_CALL__RECEIVER, null, msgs);
    	if (newReceiver != null)
    		msgs = ((InternalEObject)newReceiver).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - miniJava.interpreter.miniJava.MiniJavaPackage.METHOD_CALL__RECEIVER, null, msgs);
    	msgs = basicSetReceiver(newReceiver, msgs);
    	if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
    	eNotify(new ENotificationImpl(this, Notification.SET, miniJava.interpreter.miniJava.MiniJavaPackage.METHOD_CALL__RECEIVER, newReceiver, newReceiver));
  }

  public NotificationChain basicSetReceiver(Expression newReceiver, NotificationChain msgs) {
    Expression oldReceiver = receiver;
    receiver = newReceiver;
    if (eNotificationRequired()) {
    	ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, miniJava.interpreter.miniJava.MiniJavaPackage.METHOD_CALL__RECEIVER, oldReceiver, newReceiver);
    	if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  public Expression getReceiver() {
    return receiver;
  }

  public void setMethod(Method newMethod) {
    Method oldMethod = method;
    method = newMethod;
    if (eNotificationRequired())
    	eNotify(new ENotificationImpl(this, Notification.SET, MiniJavaPackage.METHOD_CALL__METHOD, oldMethod, method));
  }

  public Method getMethod() {
    if (method != null && method.eIsProxy()) {
    	InternalEObject oldmethod = (InternalEObject) method;
    	method = (Method) eResolveProxy(oldmethod);
    	if (method != oldmethod) {
    		if (eNotificationRequired())
    			eNotify(new ENotificationImpl(this, Notification.RESOLVE, MiniJavaPackage.METHOD_CALL__METHOD,
    					oldmethod, method));
    	}
    }
    return method;
  }

  public EList<Expression> getArgs() {
    if(args == null) {
    	args = new EObjectContainmentEList<Expression>(miniJava.interpreter.miniJava.Expression.class, this, MiniJavaPackage.METHOD_CALL__ARGS);
    }
    return args;
  }

  protected EClass eStaticClass() {
    return MiniJavaPackage.Literals.METHOD_CALL;}

  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
    case MiniJavaPackage.METHOD_CALL__RECEIVER:
    	setReceiver((miniJava.interpreter.miniJava.Expression) newValue);
    return;
    case MiniJavaPackage.METHOD_CALL__METHOD:
    	setMethod((miniJava.interpreter.miniJava.Method) newValue);
    return;
    case MiniJavaPackage.METHOD_CALL__ARGS:
    	getArgs().clear();
    	getArgs().addAll((java.util.Collection<? extends miniJava.interpreter.miniJava.Expression>) newValue);
    return;
    }
    super.eSet(featureID, newValue);
  }

  public void eUnset(int featureID) {
    switch (featureID) {
    case MiniJavaPackage.METHOD_CALL__RECEIVER:
    	setReceiver((miniJava.interpreter.miniJava.Expression) null);
    return;
    case MiniJavaPackage.METHOD_CALL__METHOD:
    	setMethod((miniJava.interpreter.miniJava.Method) null);
    return;
    case MiniJavaPackage.METHOD_CALL__ARGS:
    	getArgs().clear();
    return;
    }
    super.eUnset(featureID);
  }

  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
    case MiniJavaPackage.METHOD_CALL__RECEIVER:
    return getReceiver();
    case MiniJavaPackage.METHOD_CALL__METHOD:
    return getMethod();
    case MiniJavaPackage.METHOD_CALL__ARGS:
    return getArgs();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  public boolean eIsSet(int featureID) {
    switch (featureID) {
    case MiniJavaPackage.METHOD_CALL__RECEIVER:
    	return receiver != null;
    case MiniJavaPackage.METHOD_CALL__METHOD:
    	return method != null;
    case MiniJavaPackage.METHOD_CALL__ARGS:
    	return args != null && !args.isEmpty();
    }
    return super.eIsSet(featureID);
  }

  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
      NotificationChain msgs) {
    switch(featureID) {
    case miniJava.interpreter.miniJava.MiniJavaPackage.METHOD_CALL__RECEIVER:
    	return basicSetReceiver(null, msgs);
    case miniJava.interpreter.miniJava.MiniJavaPackage.METHOD_CALL__ARGS:
    	return ((org.eclipse.emf.ecore.util.InternalEList<?>) getArgs()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  public Value evaluateExpression(State state) {
    Value result;
    miniJava.interpreter.miniJava.ObjectRefValue realReceiver0 = ((miniJava.interpreter.miniJava.ObjectRefValue)this.receiver.evaluateExpression(state));
        miniJava.interpreter.miniJava.ObjectInstance realReceiver = ((miniJava.interpreter.miniJava.ObjectInstance)realReceiver0.getInstance());
        miniJava.interpreter.miniJava.Method realMethod = ((miniJava.interpreter.miniJava.Method)this.getMethod().findOverride(realReceiver.getType()));
        miniJava.interpreter.miniJava.Context newContext = ((miniJava.interpreter.miniJava.Context)miniJava.interpreter.miniJava.MiniJavaFactory.eINSTANCE.createContext());
        int argsLength = ((int)org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService.size(this.getArgs()));
        int i = ((int)0);
        while ((i) < (argsLength)) {
          miniJava.interpreter.miniJava.Expression arg = ((miniJava.interpreter.miniJava.Expression)this.getArgs().get(i));
          miniJava.interpreter.miniJava.Parameter param = ((miniJava.interpreter.miniJava.Parameter)realMethod.getParams().get(i));
          miniJava.interpreter.miniJava.SymbolBinding binding = ((miniJava.interpreter.miniJava.SymbolBinding)miniJava.interpreter.miniJava.MiniJavaFactory.eINSTANCE.createSymbolBinding());
          binding.setSymbol(param);
          binding.setValue(arg.evaluateExpression(state));
          newContext.getBindings().add(binding);
          i = (i) + (1);
        }
        miniJava.interpreter.miniJava.MethodCall2 call = ((miniJava.interpreter.miniJava.MethodCall2)miniJava.interpreter.miniJava.MiniJavaFactory.eINSTANCE.createMethodCall2());
        call.setMethodcall(this);
        state.pushNewFrame(realReceiver,call,newContext);
        realMethod.call(state);
        miniJava.interpreter.miniJava.Value returnValue = ((miniJava.interpreter.miniJava.Value)state.findCurrentFrame().getReturnValue());
        state.popCurrentFrame();
        result = returnValue;
        ;
    return result;
  }
}
