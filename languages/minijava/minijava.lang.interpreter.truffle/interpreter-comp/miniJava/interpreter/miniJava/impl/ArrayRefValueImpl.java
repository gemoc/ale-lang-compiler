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
import org.eclipse.emf.ecoretools.ale.compiler.lib.CollectionService;

public class ArrayRefValueImpl extends ValueImpl {
	protected ArrayInstanceImpl instance;

	protected ArrayRefValueImpl() {
		super();
	}

	@Override
	@TruffleBoundary
	protected EClass eStaticClass() {
		return MiniJavaPackage.Literals.ARRAY_REF_VALUE;
	}

	@TruffleBoundary
	public ArrayInstanceImpl getInstance() {
		if (instance != null && instance.eIsProxy()) {
			InternalEObject oldInstance = (InternalEObject) instance;
			instance = (ArrayInstanceImpl) eResolveProxy(oldInstance);
			if (instance != oldInstance) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MiniJavaPackage.ARRAY_REF_VALUE__INSTANCE, oldInstance, instance));
			}
		}
		return instance;
	}

	public ArrayInstanceImpl basicGetInstance() {
		return instance;
	}

	@TruffleBoundary
	public void setInstance(ArrayInstanceImpl newInstance) {
		ArrayInstanceImpl oldInstance = instance;
		instance = newInstance;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MiniJavaPackage.ARRAY_REF_VALUE__INSTANCE, oldInstance, instance));
	}

	@Override
	@TruffleBoundary
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MiniJavaPackage.ARRAY_REF_VALUE__INSTANCE :
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
			case MiniJavaPackage.ARRAY_REF_VALUE__INSTANCE :
				setInstance((ArrayInstanceImpl) newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	@Override
	@TruffleBoundary
	public void eUnset(int featureID) {
		switch (featureID) {
			case MiniJavaPackage.ARRAY_REF_VALUE__INSTANCE :
				setInstance((ArrayInstanceImpl) null);
				return;
		}
		super.eUnset(featureID);
	}

	@Override
	@TruffleBoundary
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case MiniJavaPackage.ARRAY_REF_VALUE__INSTANCE :
				return instance != null;
		}
		return super.eIsSet(featureID);
	}

	@TruffleBoundary
	public ValueImpl copyj() {
		ValueImpl result;
		ArrayRefValueImpl tmp = ((ArrayRefValueImpl) (MiniJavaFactory.eINSTANCE.createArrayRefValue()));
		tmp.setInstance(this.getInstance());
		result = (ValueImpl) (tmp) ;
		return result;
	}

	@TruffleBoundary
	public String customToString() {
		String result;
		String res = ((String) ("["));
		int i = ((int) (0));
		int lgt = ((int) (CollectionService.size(this.getInstance().getValue())));
		while ((i) < (lgt)) {
			ValueImpl tmpv = ((ValueImpl) (CollectionService.get(this.getInstance().getValue(), i)));
			res = (res) + (((ValueImpl) (tmpv)).customToString());
			if ((i) < ((lgt) - (1))) {
				res = (res) + (", ");
			}
			i = (i) + (1);
		}
		res = (res) + ("]");
		result = (String) (res) ;
		return result;
	}
}
