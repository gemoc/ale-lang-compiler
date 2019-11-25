/**
 */
package boa;

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
 *   <li>{@link boa.Ctx#getEnv <em>Env</em>}</li>
 *   <li>{@link boa.Ctx#getTh <em>Th</em>}</li>
 * </ul>
 *
 * @see boa.BoaPackage#getCtx()
 * @model
 * @generated
 */
public interface Ctx extends EObject {
	/**
	 * Returns the value of the '<em><b>Env</b></em>' map.
	 * The key is of type {@link java.lang.String},
	 * and the value is of type {@link boa.EvalRes},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Env</em>' map isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Env</em>' map.
	 * @see boa.BoaPackage#getCtx_Env()
	 * @model mapType="boa.StringToEvalResMap&lt;org.eclipse.emf.ecore.EString, boa.EvalRes&gt;"
	 * @generated
	 */
	EMap<String, EvalRes> getEnv();

	/**
	 * Returns the value of the '<em><b>Th</b></em>' map.
	 * The key is of type {@link java.lang.String},
	 * and the value is of type {@link boa.EvalRes},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Th</em>' map isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Th</em>' map.
	 * @see boa.BoaPackage#getCtx_Th()
	 * @model mapType="boa.StringToEvalResMap&lt;org.eclipse.emf.ecore.EString, boa.EvalRes&gt;"
	 * @generated
	 */
	EMap<String, EvalRes> getTh();

} // Ctx
