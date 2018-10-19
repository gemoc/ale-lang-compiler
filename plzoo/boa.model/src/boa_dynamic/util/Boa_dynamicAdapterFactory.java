/**
 */
package boa_dynamic.util;

import boa_dynamic.*;

import java.util.Map;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see boa_dynamic.Boa_dynamicPackage
 * @generated
 */
public class Boa_dynamicAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static Boa_dynamicPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Boa_dynamicAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = Boa_dynamicPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Boa_dynamicSwitch<Adapter> modelSwitch =
		new Boa_dynamicSwitch<Adapter>() {
			@Override
			public Adapter caseCtx(Ctx object) {
				return createCtxAdapter();
			}
			@Override
			public Adapter caseStringToEvalResMap(Map.Entry<String, EvalRes> object) {
				return createStringToEvalResMapAdapter();
			}
			@Override
			public Adapter caseEvalRes(EvalRes object) {
				return createEvalResAdapter();
			}
			@Override
			public Adapter caseEvalMapRes(EvalMapRes object) {
				return createEvalMapResAdapter();
			}
			@Override
			public Adapter caseEvalFunRes(EvalFunRes object) {
				return createEvalFunResAdapter();
			}
			@Override
			public Adapter caseEvalBoundFunRes(EvalBoundFunRes object) {
				return createEvalBoundFunResAdapter();
			}
			@Override
			public Adapter caseEvalIntRes(EvalIntRes object) {
				return createEvalIntResAdapter();
			}
			@Override
			public Adapter caseEvalBoolRes(EvalBoolRes object) {
				return createEvalBoolResAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link boa_dynamic.Ctx <em>Ctx</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see boa_dynamic.Ctx
	 * @generated
	 */
	public Adapter createCtxAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link java.util.Map.Entry <em>String To Eval Res Map</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see java.util.Map.Entry
	 * @generated
	 */
	public Adapter createStringToEvalResMapAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link boa_dynamic.EvalRes <em>Eval Res</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see boa_dynamic.EvalRes
	 * @generated
	 */
	public Adapter createEvalResAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link boa_dynamic.EvalMapRes <em>Eval Map Res</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see boa_dynamic.EvalMapRes
	 * @generated
	 */
	public Adapter createEvalMapResAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link boa_dynamic.EvalFunRes <em>Eval Fun Res</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see boa_dynamic.EvalFunRes
	 * @generated
	 */
	public Adapter createEvalFunResAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link boa_dynamic.EvalBoundFunRes <em>Eval Bound Fun Res</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see boa_dynamic.EvalBoundFunRes
	 * @generated
	 */
	public Adapter createEvalBoundFunResAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link boa_dynamic.EvalIntRes <em>Eval Int Res</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see boa_dynamic.EvalIntRes
	 * @generated
	 */
	public Adapter createEvalIntResAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link boa_dynamic.EvalBoolRes <em>Eval Bool Res</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see boa_dynamic.EvalBoolRes
	 * @generated
	 */
	public Adapter createEvalBoolResAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //Boa_dynamicAdapterFactory
