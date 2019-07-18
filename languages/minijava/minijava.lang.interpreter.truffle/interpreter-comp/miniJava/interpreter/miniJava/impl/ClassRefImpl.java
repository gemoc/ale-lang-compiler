package miniJava.interpreter.miniJava.impl;

import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.nodes.NodeInfo;
import java.lang.Object;
import java.lang.Override;
import miniJava.interpreter.miniJava.MiniJavaPackage;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecoretools.ale.compiler.lib.EqualService;

@NodeInfo(
		description = "ClassRef"
)
public class ClassRefImpl extends SingleTypeRefImpl {
	protected TypeDeclarationImpl referencedClass;

	protected ClassRefImpl() {
		super();
	}

	@Override
	@TruffleBoundary
	protected EClass eStaticClass() {
		return MiniJavaPackage.Literals.CLASS_REF;
	}

	@TruffleBoundary
	public TypeDeclarationImpl getReferencedClass() {
		if (referencedClass != null && referencedClass.eIsProxy()) {
			InternalEObject oldReferencedClass = (InternalEObject) referencedClass;
			referencedClass = (TypeDeclarationImpl) eResolveProxy(oldReferencedClass);
			if (referencedClass != oldReferencedClass) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MiniJavaPackage.CLASS_REF__REFERENCED_CLASS, oldReferencedClass, referencedClass));
			}
		}
		return referencedClass;
	}

	public TypeDeclarationImpl basicGetReferencedClass() {
		return referencedClass;
	}

	@TruffleBoundary
	public void setReferencedClass(TypeDeclarationImpl newReferencedClass) {
		TypeDeclarationImpl oldReferencedClass = referencedClass;
		referencedClass = newReferencedClass;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MiniJavaPackage.CLASS_REF__REFERENCED_CLASS, oldReferencedClass, referencedClass));
	}

	@Override
	@TruffleBoundary
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MiniJavaPackage.CLASS_REF__REFERENCED_CLASS :
				if (resolve)
					return getReferencedClass();
				return basicGetReferencedClass();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	@Override
	@TruffleBoundary
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case MiniJavaPackage.CLASS_REF__REFERENCED_CLASS :
				setReferencedClass((TypeDeclarationImpl) newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	@Override
	@TruffleBoundary
	public void eUnset(int featureID) {
		switch (featureID) {
			case MiniJavaPackage.CLASS_REF__REFERENCED_CLASS :
				setReferencedClass((TypeDeclarationImpl) null);
				return;
		}
		super.eUnset(featureID);
	}

	@Override
	@TruffleBoundary
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case MiniJavaPackage.CLASS_REF__REFERENCED_CLASS :
				return referencedClass != null;
		}
		return super.eIsSet(featureID);
	}

	public boolean compare(TypeRefImpl other) {
		boolean result;
		if (other instanceof ClassRefImpl) {
			ClassRefImpl ocr = ((ClassRefImpl) (other));
			result = (boolean) (EqualService.equals((this.getReferencedClass()), (ocr.getReferencedClass()))) ;
		}
		else {
			result = (boolean) (false) ;
		}
		return result;
	}
}
