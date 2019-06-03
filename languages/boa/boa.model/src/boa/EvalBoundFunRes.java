/**
 */
package boa;

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
 *   <li>{@link boa.EvalBoundFunRes#getTh <em>Th</em>}</li>
 * </ul>
 *
 * @see boa.BoaPackage#getEvalBoundFunRes()
 * @model
 * @generated
 */
public interface EvalBoundFunRes extends EvalFunRes {
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
	 * @see boa.BoaPackage#getEvalBoundFunRes_Th()
	 * @model mapType="boa.StringToEvalResMap&lt;org.eclipse.emf.ecore.EString, boa.EvalRes&gt;"
	 * @generated
	 */
	EMap<String, EvalRes> getTh();

} // EvalBoundFunRes
