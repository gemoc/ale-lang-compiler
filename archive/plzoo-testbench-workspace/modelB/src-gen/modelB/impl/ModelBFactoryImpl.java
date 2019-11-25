/**
 */
package modelB.impl;

import modelB.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import modelA.B;
import modelA.ModelAFactory;
import modelA.ModelAPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ModelBFactoryImpl extends EFactoryImpl implements ModelBFactory, ModelAFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ModelBFactory init() {
		try {
			ModelBFactory theModelBFactory = (ModelBFactory) EPackage.Registry.INSTANCE
					.getEFactory(ModelBPackage.eNS_URI);
			if (theModelBFactory != null) {
				return theModelBFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ModelBFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelBFactoryImpl() {
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
		case ModelBPackage.A:
			return createA();
		default:
			throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public A createA() {
		AImpl a = new AImpl();
		return a;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelBPackage getModelBPackage() {
		return (ModelBPackage) getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ModelBPackage getPackage() {
		return ModelBPackage.eINSTANCE;
	}

	@Override
	public B createB() {
		return ModelAFactory.eINSTANCE.createB();
	}

	@Override
	public ModelAPackage getModelAPackage() {
		return ModelAFactory.eINSTANCE.getModelAPackage();
	}

} //ModelBFactoryImpl
