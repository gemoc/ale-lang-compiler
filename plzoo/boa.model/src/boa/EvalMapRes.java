/**
 */
package boa;

import org.eclipse.emf.common.util.EMap;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Eval Map Res</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link boa.EvalMapRes#getValues <em>Values</em>}</li>
 * </ul>
 *
 * @see boa.BoaPackage#getEvalMapRes()
 * @model
 * @generated
 */
public interface EvalMapRes extends EvalRes {
	/**
	 * Returns the value of the '<em><b>Values</b></em>' map.
	 * The key is of type {@link java.lang.String},
	 * and the value is of type {@link boa.EvalRes},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Values</em>' map isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Values</em>' map.
	 * @see boa.BoaPackage#getEvalMapRes_Values()
	 * @model mapType="boa.StringToEvalResMap&lt;org.eclipse.emf.ecore.EString, boa.EvalRes&gt;"
	 * @generated
	 */
	EMap<String, EvalRes> getValues();

} // EvalMapRes
