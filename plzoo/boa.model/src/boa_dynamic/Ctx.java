/**
 */
package boa_dynamic;

import org.eclipse.emf.common.util.EMap;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ctx</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link boa_dynamic.Ctx#getEnv <em>Env</em>}</li>
 *   <li>{@link boa_dynamic.Ctx#getTh <em>Th</em>}</li>
 * </ul>
 *
 * @see boa_dynamic.Boa_dynamicPackage#getCtx()
 * @model
 * @generated
 */
public interface Ctx extends EObject {
	/**
	 * Returns the value of the '<em><b>Env</b></em>' map.
	 * The key is of type {@link java.lang.String},
	 * and the value is of type {@link boa_dynamic.EvalRes},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Env</em>' map isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Env</em>' map.
	 * @see boa_dynamic.Boa_dynamicPackage#getCtx_Env()
	 * @model mapType="boa_dynamic.StringToEvalResMap&lt;org.eclipse.emf.ecore.EString, boa_dynamic.EvalRes&gt;"
	 * @generated
	 */
	EMap<String, EvalRes> getEnv();

	/**
	 * Returns the value of the '<em><b>Th</b></em>' map.
	 * The key is of type {@link java.lang.String},
	 * and the value is of type {@link boa_dynamic.EvalRes},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Th</em>' map isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Th</em>' map.
	 * @see boa_dynamic.Boa_dynamicPackage#getCtx_Th()
	 * @model mapType="boa_dynamic.StringToEvalResMap&lt;org.eclipse.emf.ecore.EString, boa_dynamic.EvalRes&gt;"
	 * @generated
	 */
	EMap<String, EvalRes> getTh();

} // Ctx
