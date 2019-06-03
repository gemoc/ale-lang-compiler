package miniJava.interpreter.miniJava.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;

import miniJava.interpreter.miniJava.Context;
import miniJava.interpreter.miniJava.Expression;
import miniJava.interpreter.miniJava.Method;
import miniJava.interpreter.miniJava.MethodCall;
import miniJava.interpreter.miniJava.MethodCall2;
import miniJava.interpreter.miniJava.MiniJavaFactory;
import miniJava.interpreter.miniJava.MiniJavaPackage;
import miniJava.interpreter.miniJava.ObjectInstance;
import miniJava.interpreter.miniJava.ObjectRefValue;
import miniJava.interpreter.miniJava.Parameter;
import miniJava.interpreter.miniJava.State;
import miniJava.interpreter.miniJava.SymbolBinding;
import miniJava.interpreter.miniJava.Value;

public class MethodCallImpl extends ExpressionImpl implements MethodCall {
	protected EList<Expression> args;

	protected Method method;

	protected Expression receiver;

	protected MethodCallImpl() {
		super();
	}

	public NotificationChain basicSetReceiver(Expression newReceiver, NotificationChain msgs) {
		Expression oldReceiver = receiver;
		receiver = newReceiver;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					MiniJavaPackage.METHOD_CALL__RECEIVER, oldReceiver, newReceiver);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
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

	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case MiniJavaPackage.METHOD_CALL__RECEIVER:
			return basicSetReceiver(null, msgs);
		case MiniJavaPackage.METHOD_CALL__ARGS:
			return ((org.eclipse.emf.ecore.util.InternalEList<?>) getArgs()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
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

	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case MiniJavaPackage.METHOD_CALL__RECEIVER:
			setReceiver((Expression) newValue);
			return;
		case MiniJavaPackage.METHOD_CALL__METHOD:
			setMethod((Method) newValue);
			return;
		case MiniJavaPackage.METHOD_CALL__ARGS:
			getArgs().clear();
			getArgs().addAll((java.util.Collection<? extends Expression>) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	protected EClass eStaticClass() {
		return MiniJavaPackage.Literals.METHOD_CALL;
	}

	public void eUnset(int featureID) {
		switch (featureID) {
		case MiniJavaPackage.METHOD_CALL__RECEIVER:
			setReceiver((Expression) null);
			return;
		case MiniJavaPackage.METHOD_CALL__METHOD:
			setMethod((Method) null);
			return;
		case MiniJavaPackage.METHOD_CALL__ARGS:
			getArgs().clear();
			return;
		}
		super.eUnset(featureID);
	}

	public Value evaluateExpression(State state) {
		Value result;
		ObjectRefValue realReceiver0 = ((ObjectRefValue) this.receiver.evaluateExpression(state));
		ObjectInstance realReceiver = ((ObjectInstance) realReceiver0.getInstance());
		Method realMethod = ((Method) this.method.findOverride(realReceiver.getType()));
		Context newContext = ((Context) MiniJavaFactory.eINSTANCE.createContext());
		int argsLength = ((int) org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService.size(this.getArgs()));
		int i = ((int) 0);
		while ((i) <= (argsLength)) {
			Expression arg = ((Expression) this.getArgs().get(i));
			Parameter param = ((Parameter) realMethod.getParams().get(i));
			SymbolBinding binding = ((SymbolBinding) MiniJavaFactory.eINSTANCE.createSymbolBinding());
			binding.setSymbol(param);
			binding.setValue(arg.evaluateExpression(state));
			newContext.getBindings().add(binding);
			i = (i) + (1);
		}
		MethodCall2 call = ((MethodCall2) MiniJavaFactory.eINSTANCE.createMethodCall2());
		call.setMethodcall(this);
		state.pushNewFrame(realReceiver, call, newContext);
		realMethod.call(state);
		Value returnValue = ((Value) state.findCurrentFrame().getReturnValue());
		state.popCurrentFrame();
		result = returnValue;
		;
		return result;
	}

	public EList<Expression> getArgs() {
		if (args == null) {
			args = new EObjectContainmentEList<Expression>(Expression.class, this, MiniJavaPackage.METHOD_CALL__ARGS);
		}
		return args;
	}

	public Method getMethod() {
		return method;
	}

	public Expression getReceiver() {
		return receiver;
	}

	public void setMethod(Method newMethod) {
		Method oldMethod = method;
		method = newMethod;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MiniJavaPackage.METHOD_CALL__METHOD, oldMethod,
					method));
	}

	public void setReceiver(Expression newReceiver) {
		if (newReceiver != receiver) {
			NotificationChain msgs = null;
			if (receiver != null)
				msgs = ((InternalEObject) receiver).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE - MiniJavaPackage.METHOD_CALL__RECEIVER, null, msgs);
			if (newReceiver != null)
				msgs = ((InternalEObject) newReceiver).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - MiniJavaPackage.METHOD_CALL__RECEIVER, null, msgs);
			msgs = basicSetReceiver(newReceiver, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MiniJavaPackage.METHOD_CALL__RECEIVER, newReceiver,
					newReceiver));
	}
}
