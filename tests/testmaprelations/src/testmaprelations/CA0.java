/**
 */
package testmaprelations;

import java.util.Map;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>CA0</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link testmaprelations.CA0#getMapca0tocb0mapentry <em>Mapca0tocb0mapentry</em>}</li>
 * </ul>
 *
 * @see testmaprelations.TestmaprelationsPackage#getCA0()
 * @model
 * @generated
 */
public interface CA0 extends EObject {
	/**
	 * Returns the value of the '<em><b>Mapca0tocb0mapentry</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mapca0tocb0mapentry</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mapca0tocb0mapentry</em>' reference.
	 * @see #setMapca0tocb0mapentry(Map.Entry)
	 * @see testmaprelations.TestmaprelationsPackage#getCA0_Mapca0tocb0mapentry()
	 * @model mapType="testmaprelations.MapCA0ToCB0MapEntry&lt;testmaprelations.CA0, testmaprelations.CB0&gt;"
	 * @generated
	 */
	Map.Entry<CA0, CB0> getMapca0tocb0mapentry();

	/**
	 * Sets the value of the '{@link testmaprelations.CA0#getMapca0tocb0mapentry <em>Mapca0tocb0mapentry</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mapca0tocb0mapentry</em>' reference.
	 * @see #getMapca0tocb0mapentry()
	 * @generated
	 */
	void setMapca0tocb0mapentry(Map.Entry<CA0, CB0> value);

} // CA0
