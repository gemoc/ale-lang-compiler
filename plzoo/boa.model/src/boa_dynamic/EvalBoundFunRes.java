/**
 */
package boa_dynamic;

import org.eclipse.emf.common.util.EMap;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Eval Bound Fun Res</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link boa_dynamic.EvalBoundFunRes#getTh <em>Th</em>}</li>
 * </ul>
 *
 * @see boa_dynamic.Boa_dynamicPackage#getEvalBoundFunRes()
 * @model
 * @generated
 */
public interface EvalBoundFunRes extends EvalFunRes {

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
	 * @see boa_dynamic.Boa_dynamicPackage#getEvalBoundFunRes_Th()
	 * @model mapType="boa_dynamic.StringToEvalResMap&lt;org.eclipse.emf.ecore.EString, boa_dynamic.EvalRes&gt;"
	 * @generated
	 */
	EMap<String, EvalRes> getTh();
} // EvalBoundFunRes
