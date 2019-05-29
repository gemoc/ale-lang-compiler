/**
 */
package testmaprelations;

import java.util.Map;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>CA4</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link testmaprelations.CA4#getMapca0tocb0mapentry <em>Mapca0tocb0mapentry</em>}</li>
 * </ul>
 *
 * @see testmaprelations.TestmaprelationsPackage#getCA4()
 * @model
 * @generated
 */
public interface CA4 extends EObject {
	/**
	 * Returns the value of the '<em><b>Mapca0tocb0mapentry</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mapca0tocb0mapentry</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mapca0tocb0mapentry</em>' container reference.
	 * @see #setMapca0tocb0mapentry(Map.Entry)
	 * @see testmaprelations.TestmaprelationsPackage#getCA4_Mapca0tocb0mapentry()
	 * @model mapType="testmaprelations.MapCA4ToCB4MapEntry&lt;testmaprelations.CA4, testmaprelations.CB4&gt;"
	 * @generated
	 */
	Map.Entry<CA4, CB4> getMapca0tocb0mapentry();

	/**
	 * Sets the value of the '{@link testmaprelations.CA4#getMapca0tocb0mapentry <em>Mapca0tocb0mapentry</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mapca0tocb0mapentry</em>' container reference.
	 * @see #getMapca0tocb0mapentry()
	 * @generated
	 */
	void setMapca0tocb0mapentry(Map.Entry<CA4, CB4> value);

} // CA4
