package miniJava.interpreter.miniJava.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;

import miniJava.interpreter.miniJava.Clazz;
import miniJava.interpreter.miniJava.Context;
import miniJava.interpreter.miniJava.Expression;
import miniJava.interpreter.miniJava.Field;
import miniJava.interpreter.miniJava.FieldBinding;
import miniJava.interpreter.miniJava.Member;
import miniJava.interpreter.miniJava.Method;
import miniJava.interpreter.miniJava.MiniJavaFactory;
import miniJava.interpreter.miniJava.MiniJavaPackage;
import miniJava.interpreter.miniJava.NewCall;
import miniJava.interpreter.miniJava.NewObject;
import miniJava.interpreter.miniJava.ObjectInstance;
import miniJava.interpreter.miniJava.ObjectRefValue;
import miniJava.interpreter.miniJava.Parameter;
import miniJava.interpreter.miniJava.State;
import miniJava.interpreter.miniJava.SymbolBinding;
import miniJava.interpreter.miniJava.Value;

public class NewObjectImpl extends ExpressionImpl implements NewObject {
	protected EList<Expression> args;

	protected Clazz type;

	protected NewObjectImpl() {
		super();
	}

	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case MiniJavaPackage.NEW_OBJECT__TYPE:
			return getType();
		case MiniJavaPackage.NEW_OBJECT__ARGS:
			return getArgs();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case MiniJavaPackage.NEW_OBJECT__ARGS:
			return ((org.eclipse.emf.ecore.util.InternalEList<?>) getArgs()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case MiniJavaPackage.NEW_OBJECT__TYPE:
			return type != null;
		case MiniJavaPackage.NEW_OBJECT__ARGS:
			return args != null && !args.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case MiniJavaPackage.NEW_OBJECT__TYPE:
			setType((Clazz) newValue);
			return;
		case MiniJavaPackage.NEW_OBJECT__ARGS:
			getArgs().clear();
			getArgs().addAll((java.util.Collection<? extends Expression>) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	protected EClass eStaticClass() {
		return MiniJavaPackage.Literals.NEW_OBJECT;
	}

	public void eUnset(int featureID) {
		switch (featureID) {
		case MiniJavaPackage.NEW_OBJECT__TYPE:
			setType((Clazz) null);
			return;
		case MiniJavaPackage.NEW_OBJECT__ARGS:
			getArgs().clear();
			return;
		}
		super.eUnset(featureID);
	}

	public Value evaluateExpression(State state) {
		Value result;
		ObjectInstance res = ((ObjectInstance) MiniJavaFactory.eINSTANCE.createObjectInstance());
		res.setType(this.type);
		state.getObjectsHeap().add(res);
		int i = ((int) 0);
		int z = ((int) org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService.size(res.getType().getMembers()));
		while ((i) < (z)) {
			Member m = ((Member) org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService
					.get(res.getType().getMembers(), i));
			if (m instanceof Field) {
				Field f = ((Field) m);
				if ((f.getDefaultValue()) != (null)) {
					Value v = ((Value) f.getDefaultValue().evaluateExpression(state));
					FieldBinding fb = ((FieldBinding) MiniJavaFactory.eINSTANCE.createFieldBinding());
					fb.setField(f);
					fb.setValue(v);
					res.getFieldbindings().add(fb);
				}
			}
			i = (i) + (1);
		}
		i = 0;
		Method constructor = ((Method) null);
		while ((((i) < (z)) && (java.util.Objects.equals((constructor), (null))))) {
			Member m = ((Member) org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService
					.get(res.getType().getMembers(), i));
			if (m instanceof Method) {
				Method mtd = ((Method) m);
				if (((java.util.Objects.equals((mtd.getName()), (null))) && (java.util.Objects.equals(
						(org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService.size(mtd.getParams())),
						(org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService.size(this.getArgs())))))) {
					constructor = mtd;
				}
			}
		}
		if ((constructor) != (null)) {
			Context newContext = ((Context) MiniJavaFactory.eINSTANCE.createContext());
			i = 0;
			z = org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService.size(this.getArgs());
			while ((i) < (z)) {
				Expression arg = ((Expression) org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService
						.get(this.getArgs(), i));
				Parameter param = ((Parameter) org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService
						.get(constructor.getParams(), i));
				SymbolBinding binding = ((SymbolBinding) MiniJavaFactory.eINSTANCE.createSymbolBinding());
				binding.setSymbol(param);
				binding.setValue(arg.evaluateExpression(state));
				i = (i) + (1);
				newContext.getBindings().add(binding);
			}
			NewCall call = ((NewCall) MiniJavaFactory.eINSTANCE.createNewCall());
			call.setNewz(this);
			state.pushNewFrame(res, call, newContext);
			constructor.getBody().evaluateStatement(state);
			state.popCurrentFrame();
		}
		ObjectRefValue tmp = ((ObjectRefValue) MiniJavaFactory.eINSTANCE.createObjectRefValue());
		tmp.setInstance(res);
		result = tmp;
		;
		return result;
	}

	public EList<Expression> getArgs() {
		if (args == null) {
			args = new EObjectContainmentEList<Expression>(Expression.class, this, MiniJavaPackage.NEW_OBJECT__ARGS);
		}
		return args;
	}

	public Clazz getType() {
		return type;
	}

	public void setType(Clazz newType) {
		Clazz oldType = type;
		type = newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MiniJavaPackage.NEW_OBJECT__TYPE, oldType, type));
	}
}
