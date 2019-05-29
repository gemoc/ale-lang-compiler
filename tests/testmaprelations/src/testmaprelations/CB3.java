/**
 */
package testmaprelations;

import java.util.Map;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>CB3</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link testmaprelations.CB3#getMapca0tocb0mapentry <em>Mapca0tocb0mapentry</em>}</li>
 * </ul>
 *
 * @see testmaprelations.TestmaprelationsPackage#getCB3()
 * @model
 * @generated
 */
public interface CB3 extends EObject {
	/**
	 * Returns the value of the '<em><b>Mapca0tocb0mapentry</b></em>' reference list.
	 * The list contents are of type {@link java.util.Map.Entry}<code>&lt;org.eclipse.emf.common.util.EList&lt;testmaprelations.CA3&gt;, org.eclipse.emf.common.util.EList&lt;testmaprelations.CB3&gt;&gt;</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mapca0tocb0mapentry</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mapca0tocb0mapentry</em>' reference list.
	 * @see testmaprelations.TestmaprelationsPackage#getCB3_Mapca0tocb0mapentry()
	 * @model mapType="testmaprelations.MapCA3ToCB3MapEntry&lt;testmaprelations.CA3, testmaprelations.CB3&gt;"
	 * @generated
	 */
	EList<Map.Entry<EList<CA3>, EList<CB3>>> getMapca0tocb0mapentry();

} // CB3
