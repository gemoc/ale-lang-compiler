/**
 */
package testmaprelations;

import java.util.Map;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>CA5</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link testmaprelations.CA5#getMapca0tocb0mapentry <em>Mapca0tocb0mapentry</em>}</li>
 * </ul>
 *
 * @see testmaprelations.TestmaprelationsPackage#getCA5()
 * @model
 * @generated
 */
public interface CA5 extends EObject {
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
	 * @see testmaprelations.TestmaprelationsPackage#getCA5_Mapca0tocb0mapentry()
	 * @model mapType="testmaprelations.MapCA5ToCB5MapEntry&lt;testmaprelations.CA5, testmaprelations.CB5&gt;"
	 * @generated
	 */
	Map.Entry<EList<CA5>, EList<CB5>> getMapca0tocb0mapentry();

	/**
	 * Sets the value of the '{@link testmaprelations.CA5#getMapca0tocb0mapentry <em>Mapca0tocb0mapentry</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mapca0tocb0mapentry</em>' container reference.
	 * @see #getMapca0tocb0mapentry()
	 * @generated
	 */
	void setMapca0tocb0mapentry(Map.Entry<EList<CA5>, EList<CB5>> value);

} // CA5
