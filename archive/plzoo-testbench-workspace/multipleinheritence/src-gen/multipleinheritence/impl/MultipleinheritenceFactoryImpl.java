/**
 */
package multipleinheritence.impl;

import multipleinheritence.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class MultipleinheritenceFactoryImpl extends EFactoryImpl implements MultipleinheritenceFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static MultipleinheritenceFactory init() {
		try {
			MultipleinheritenceFactory theMultipleinheritenceFactory = (MultipleinheritenceFactory) EPackage.Registry.INSTANCE
					.getEFactory(MultipleinheritencePackage.eNS_URI);
			if (theMultipleinheritenceFactory != null) {
				return theMultipleinheritenceFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new MultipleinheritenceFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MultipleinheritenceFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
		case MultipleinheritencePackage.NEW_ECLASS1:
			return createNewEClass1();
		case MultipleinheritencePackage.NEW_ECLASS2:
			return createNewEClass2();
		case MultipleinheritencePackage.NEW_ECLASS3:
			return createNewEClass3();
		case MultipleinheritencePackage.NEW_ECLASS4:
			return createNewEClass4();
		case MultipleinheritencePackage.NEW_ECLASS5:
			return createNewEClass5();
		default:
			throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NewEClass1 createNewEClass1() {
		NewEClass1Impl newEClass1 = new NewEClass1Impl();
		return newEClass1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NewEClass2 createNewEClass2() {
		NewEClass2Impl newEClass2 = new NewEClass2Impl();
		return newEClass2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NewEClass3 createNewEClass3() {
		NewEClass3Impl newEClass3 = new NewEClass3Impl();
		return newEClass3;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NewEClass4 createNewEClass4() {
		NewEClass4Impl newEClass4 = new NewEClass4Impl();
		return newEClass4;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NewEClass5 createNewEClass5() {
		NewEClass5Impl newEClass5 = new NewEClass5Impl();
		return newEClass5;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MultipleinheritencePackage getMultipleinheritencePackage() {
		return (MultipleinheritencePackage) getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static MultipleinheritencePackage getPackage() {
		return MultipleinheritencePackage.eINSTANCE;
	}

} //MultipleinheritenceFactoryImpl
