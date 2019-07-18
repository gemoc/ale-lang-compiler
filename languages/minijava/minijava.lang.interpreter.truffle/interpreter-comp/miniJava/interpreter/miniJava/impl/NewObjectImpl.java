package miniJava.interpreter.miniJava.impl;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
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
import org.eclipse.emf.ecoretools.ale.compiler.lib.EqualService;

@NodeInfo(
		description = "NewObject"
)
public class NewObjectImpl extends ExpressionImpl {
	protected ClazzImpl type;

	protected EList<ExpressionImpl> args;

	@Children
	private ExpressionImpl[] argsArr;

	protected NewObjectImpl() {
		super();
	}

	@Override
	@TruffleBoundary
	protected EClass eStaticClass() {
		return MiniJavaPackage.Literals.NEW_OBJECT;
	}

	@TruffleBoundary
	public ClazzImpl getType() {
		if (type != null && type.eIsProxy()) {
			InternalEObject oldType = (InternalEObject) type;
			type = (ClazzImpl) eResolveProxy(oldType);
			if (type != oldType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MiniJavaPackage.NEW_OBJECT__TYPE, oldType, type));
			}
		}
		return type;
	}

	public ClazzImpl basicGetType() {
		return type;
	}

	@TruffleBoundary
	public void setType(ClazzImpl newType) {
		ClazzImpl oldType = type;
		type = newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MiniJavaPackage.NEW_OBJECT__TYPE, oldType, type));
	}

	@TruffleBoundary
	public EList<ExpressionImpl> getArgs() {
		if (args == null) {
			args = new EObjectContainmentEList<ExpressionImpl>(ExpressionImpl.class, this, MiniJavaPackage.NEW_OBJECT__ARGS);
		}
		return args;
	}

	@Override
	@TruffleBoundary
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
			NotificationChain msgs) {
		switch (featureID) {
			case MiniJavaPackage.NEW_OBJECT__ARGS :
				return ((InternalEList<?>) getArgs()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	@Override
	@TruffleBoundary
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MiniJavaPackage.NEW_OBJECT__TYPE :
				if (resolve)
					return getType();
				return basicGetType();
			case MiniJavaPackage.NEW_OBJECT__ARGS :
				return getArgs();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	@Override
	@TruffleBoundary
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case MiniJavaPackage.NEW_OBJECT__TYPE :
				setType((ClazzImpl) newValue);
				return;
			case MiniJavaPackage.NEW_OBJECT__ARGS :
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
			case MiniJavaPackage.NEW_OBJECT__TYPE :
				setType((ClazzImpl) null);
				return;
			case MiniJavaPackage.NEW_OBJECT__ARGS :
				getArgs().clear();
				return;
		}
		super.eUnset(featureID);
	}

	@Override
	@TruffleBoundary
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case MiniJavaPackage.NEW_OBJECT__TYPE :
				return type != null;
			case MiniJavaPackage.NEW_OBJECT__ARGS :
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
		ObjectInstanceImpl res = ((ObjectInstanceImpl) (MiniJavaFactory.eINSTANCE.createObjectInstance()));
		res.setType(this.getType());
		state.getObjectsHeap().add(res);
		int i = ((int) (0));
		int z = ((int) (CollectionService.size(res.getType().getMembers())));
		while ((i) < (z)) {
			MemberImpl m = ((MemberImpl) (CollectionService.get(res.getType().getMembers(), i)));
			if (m instanceof FieldImpl) {
				FieldImpl f = ((FieldImpl) (m));
				if (!EqualService.equals((f.getDefaultValue()), (null))) {
					ValueImpl v = ((ValueImpl) (((ExpressionImpl) (f.getDefaultValue())).evaluateExpression((StateImpl) (state))));
					FieldBindingImpl fb = ((FieldBindingImpl) (MiniJavaFactory.eINSTANCE.createFieldBinding()));
					fb.setField(f);
					fb.setValue(v);
					res.getFieldbindings().add(fb);
				}
			}
			i = (i) + (1);
		}
		i = 0;
		MethodImpl constructor = ((MethodImpl) (null));
		while ((((i) < (z)) && (EqualService.equals((constructor), (null))))) {
			MemberImpl m = ((MemberImpl) (CollectionService.get(res.getType().getMembers(), i)));
			if (m instanceof MethodImpl) {
				MethodImpl mtd = ((MethodImpl) (m));
				if (((EqualService.equals((mtd.getName()), (null))) && (EqualService.equals((CollectionService.size(mtd.getParams())), (CollectionService.size(this.argsArr)))))) {
					constructor = mtd;
				}
			}
			i = (i) + (1);
		}
		if (!EqualService.equals((constructor), (null))) {
			ContextImpl newContext = ((ContextImpl) (MiniJavaFactory.eINSTANCE.createContext()));
			i = 0;
			z = CollectionService.size(this.argsArr);
			while ((i) < (z)) {
				ExpressionImpl arg = ((ExpressionImpl) (CollectionService.get(this.argsArr, i)));
				ParameterImpl param = ((ParameterImpl) (CollectionService.get(constructor.getParams(), i)));
				SymbolBindingImpl binding = ((SymbolBindingImpl) (MiniJavaFactory.eINSTANCE.createSymbolBinding()));
				binding.setSymbol(param);
				binding.setValue(((ExpressionImpl) (arg)).evaluateExpression((StateImpl) (state)));
				i = (i) + (1);
				newContext.getBindings().add(binding);
			}
			NewCallImpl call = ((NewCallImpl) (MiniJavaFactory.eINSTANCE.createNewCall()));
			call.setNewz(this);
			((StateImpl) (state)).pushNewFrame((ObjectInstanceImpl) (res), (NewCallImpl) (call), (ContextImpl) (newContext));
			BlockImpl bd = ((BlockImpl) (constructor.getBody()));
			bd.evaluateStatement((StateImpl) (state));
			((StateImpl) (state)).popCurrentFrame();
		}
		ObjectRefValueImpl tmp = ((ObjectRefValueImpl) (MiniJavaFactory.eINSTANCE.createObjectRefValue()));
		tmp.setInstance(res);
		result = (ValueImpl) (tmp) ;

		return result;
	}
}
