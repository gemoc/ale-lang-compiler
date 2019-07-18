package miniJava.interpreter.miniJava.impl;

import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import miniJava.interpreter.miniJava.MiniJavaFactory;
import miniJava.interpreter.miniJava.MiniJavaPackage;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

public class ObjectRefValueImpl extends ValueImpl {
	protected ObjectInstanceImpl instance;

	protected ObjectRefValueImpl() {
		super();
	}

	@Override
	@TruffleBoundary
	protected EClass eStaticClass() {
		return MiniJavaPackage.Literals.OBJECT_REF_VALUE;
	}

	@TruffleBoundary
	public ObjectInstanceImpl getInstance() {
		if (instance != null && instance.eIsProxy()) {
			InternalEObject oldInstance = (InternalEObject) instance;
			instance = (ObjectInstanceImpl) eResolveProxy(oldInstance);
			if (instance != oldInstance) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MiniJavaPackage.OBJECT_REF_VALUE__INSTANCE, oldInstance, instance));
			}
		}
		return instance;
	}

	public ObjectInstanceImpl basicGetInstance() {
		return instance;
	}

	@TruffleBoundary
	public void setInstance(ObjectInstanceImpl newInstance) {
		ObjectInstanceImpl oldInstance = instance;
		instance = newInstance;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MiniJavaPackage.OBJECT_REF_VALUE__INSTANCE, oldInstance, instance));
	}

	@Override
	@TruffleBoundary
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MiniJavaPackage.OBJECT_REF_VALUE__INSTANCE :
				if (resolve)
					return getInstance();
				return basicGetInstance();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	@Override
	@TruffleBoundary
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case MiniJavaPackage.OBJECT_REF_VALUE__INSTANCE :
				setInstance((ObjectInstanceImpl) newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	@Override
	@TruffleBoundary
	public void eUnset(int featureID) {
		switch (featureID) {
			case MiniJavaPackage.OBJECT_REF_VALUE__INSTANCE :
				setInstance((ObjectInstanceImpl) null);
				return;
		}
		super.eUnset(featureID);
	}

	@Override
	@TruffleBoundary
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case MiniJavaPackage.OBJECT_REF_VALUE__INSTANCE :
				return instance != null;
		}
		return super.eIsSet(featureID);
	}

	@TruffleBoundary
	public String customToString() {
		String result;
		result = (String) (this.getInstance().toString()) ;
		return result;
	}

	@TruffleBoundary
	public ValueImpl copyj() {
		ValueImpl result;
		ObjectRefValueImpl tmp = ((ObjectRefValueImpl) (MiniJavaFactory.eINSTANCE.createObjectRefValue()));
		tmp.setInstance(this.getInstance());
		result = (ValueImpl) (tmp) ;
		return result;
	}
}
