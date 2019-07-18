package miniJava.interpreter.miniJava.impl;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.nodes.Node.Child;
import com.oracle.truffle.api.nodes.Node.Children;
import com.oracle.truffle.api.nodes.NodeInfo;
import java.lang.Object;
import java.lang.Override;
import java.util.Collection;
import miniJava.interpreter.miniJava.MiniJavaFactory;
import miniJava.interpreter.miniJava.MiniJavaPackage;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService;

@NodeInfo(
		description = "MethodCall"
)
public class MethodCallImpl extends ExpressionImpl {
	@Child
	protected ExpressionImpl receiver;

	protected MethodImpl method;

	protected EList<ExpressionImpl> args;

	@Children
	private ExpressionImpl[] argsArr;

	protected MethodCallImpl() {
		super();
	}

	@Override
	@TruffleBoundary
	protected EClass eStaticClass() {
		return MiniJavaPackage.Literals.METHOD_CALL;
	}

	@TruffleBoundary
	public ExpressionImpl getReceiver() {
		return receiver;
	}

	@TruffleBoundary
	public NotificationChain basicSetReceiver(ExpressionImpl newReceiver, NotificationChain msgs) {
		ExpressionImpl oldReceiver = receiver;
		receiver = newReceiver;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MiniJavaPackage.METHOD_CALL__RECEIVER, oldReceiver, newReceiver);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	@TruffleBoundary
	public void setReceiver(ExpressionImpl newReceiver) {
		if (newReceiver != receiver) {
			NotificationChain msgs = null;
			if (receiver != null)
				msgs = ((InternalEObject) receiver).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MiniJavaPackage.METHOD_CALL__RECEIVER, null, msgs);
			if (newReceiver != null)
				msgs = ((InternalEObject) newReceiver).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MiniJavaPackage.METHOD_CALL__RECEIVER, null, msgs);
			msgs = basicSetReceiver(newReceiver, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MiniJavaPackage.METHOD_CALL__RECEIVER, newReceiver, newReceiver));
	}

	@TruffleBoundary
	public MethodImpl getMethod() {
		if (method != null && method.eIsProxy()) {
			InternalEObject oldMethod = (InternalEObject) method;
			method = (MethodImpl) eResolveProxy(oldMethod);
			if (method != oldMethod) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MiniJavaPackage.METHOD_CALL__METHOD, oldMethod, method));
			}
		}
		return method;
	}

	public MethodImpl basicGetMethod() {
		return method;
	}

	@TruffleBoundary
	public void setMethod(MethodImpl newMethod) {
		MethodImpl oldMethod = method;
		method = newMethod;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MiniJavaPackage.METHOD_CALL__METHOD, oldMethod, method));
	}

	@TruffleBoundary
	public EList<ExpressionImpl> getArgs() {
		if (args == null) {
			args = new EObjectContainmentEList<ExpressionImpl>(ExpressionImpl.class, this, MiniJavaPackage.METHOD_CALL__ARGS);
		}
		return args;
	}

	@Override
	@TruffleBoundary
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
			NotificationChain msgs) {
		switch (featureID) {
			case MiniJavaPackage.METHOD_CALL__RECEIVER :
				return basicSetReceiver(null, msgs);
			case MiniJavaPackage.METHOD_CALL__ARGS :
				return ((InternalEList<?>) getArgs()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	@Override
	@TruffleBoundary
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MiniJavaPackage.METHOD_CALL__RECEIVER :
				return getReceiver();
			case MiniJavaPackage.METHOD_CALL__METHOD :
				if (resolve)
					return getMethod();
				return basicGetMethod();
			case MiniJavaPackage.METHOD_CALL__ARGS :
				return getArgs();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	@Override
	@TruffleBoundary
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case MiniJavaPackage.METHOD_CALL__RECEIVER :
				setReceiver((ExpressionImpl) newValue);
				return;
			case MiniJavaPackage.METHOD_CALL__METHOD :
				setMethod((MethodImpl) newValue);
				return;
			case MiniJavaPackage.METHOD_CALL__ARGS :
				getArgs().clear();
				getArgs().addAll((Collection<? extends ExpressionImpl>) newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	@Override
	@TruffleBoundary
	public void eUnset(int featureID) {
		switch (featureID) {
			case MiniJavaPackage.METHOD_CALL__RECEIVER :
				setReceiver((ExpressionImpl) null);
				return;
			case MiniJavaPackage.METHOD_CALL__METHOD :
				setMethod((MethodImpl) null);
				return;
			case MiniJavaPackage.METHOD_CALL__ARGS :
				getArgs().clear();
				return;
		}
		super.eUnset(featureID);
	}

	@Override
	@TruffleBoundary
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case MiniJavaPackage.METHOD_CALL__RECEIVER :
				return receiver != null;
			case MiniJavaPackage.METHOD_CALL__METHOD :
				return method != null;
			case MiniJavaPackage.METHOD_CALL__ARGS :
				return args != null && !args.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	public ValueImpl evaluateExpression(StateImpl state) {
		ValueImpl result;
		if (this.argsArr == null) {
			CompilerDirectives.transferToInterpreterAndInvalidate();
			if (this.args != null) this.argsArr = this.args.toArray(new ExpressionImpl[0]);
			else this.argsArr = new ExpressionImpl[] {};
		}
		ObjectRefValueImpl realReceiver0 = ((ObjectRefValueImpl) (((ObjectRefValueImpl) (((ExpressionImpl) (this.getReceiver())).evaluateExpression((StateImpl) (state))))));
		ObjectInstanceImpl realReceiver = ((ObjectInstanceImpl) (realReceiver0.getInstance()));
		MethodImpl realMethod = ((MethodImpl) (((MethodImpl) (((MethodImpl) (this.getMethod())).findOverride((ClazzImpl) (realReceiver.getType()))))));
		ContextImpl newContext = ((ContextImpl) (MiniJavaFactory.eINSTANCE.createContext()));
		int argsLength = ((int) (CollectionService.size(this.argsArr)));
		int i = ((int) (0));
		while ((i) < (argsLength)) {
			ExpressionImpl arg = ((ExpressionImpl) (CollectionService.get(this.argsArr, i)));
			ParameterImpl param = ((ParameterImpl) (CollectionService.get(realMethod.getParams(), i)));
			SymbolBindingImpl binding = ((SymbolBindingImpl) (MiniJavaFactory.eINSTANCE.createSymbolBinding()));
			binding.setSymbol(param);
			binding.setValue(((ExpressionImpl) (arg)).evaluateExpression((StateImpl) (state)));
			newContext.getBindings().add(binding);
			i = (i) + (1);
		}
		MethodCall2Impl call = ((MethodCall2Impl) (MiniJavaFactory.eINSTANCE.createMethodCall2()));
		call.setMethodcall(this);
		((StateImpl) (state)).pushNewFrame((ObjectInstanceImpl) (realReceiver), (MethodCall2Impl) (call), (ContextImpl) (newContext));
		((MethodCallImpl) (this)).call((MethodImpl) (realMethod), (StateImpl) (state));
		ValueImpl returnValue = ((ValueImpl) (((StateImpl) (state)).findCurrentFrame().getReturnValue()));
		((StateImpl) (state)).popCurrentFrame();
		result = (ValueImpl) (returnValue) ;

		return result;
	}

	public void call(MethodImpl realMethod, StateImpl state) {
		if (this.argsArr == null) {
			CompilerDirectives.transferToInterpreterAndInvalidate();
			if (this.args != null) this.argsArr = this.args.toArray(new ExpressionImpl[0]);
			else this.argsArr = new ExpressionImpl[] {};
		}
		((MethodImpl) (realMethod)).call((StateImpl) (state));

	}
}
