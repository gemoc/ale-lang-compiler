/**
 */
package testaccessors;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see testaccessors.TestaccessorsFactory
 * @model kind="package"
 * @generated
 */
public interface TestaccessorsPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "testaccessors";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://testaccessors2";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "testaccessors2";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	TestaccessorsPackage eINSTANCE = testaccessors.impl.TestaccessorsPackageImpl.init();

	/**
	 * The meta object id for the '{@link testaccessors.impl.EAccImpl <em>EAcc</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see testaccessors.impl.EAccImpl
	 * @see testaccessors.impl.TestaccessorsPackageImpl#getEAcc()
	 * @generated
	 */
	int EACC = 0;

	/**
	 * The feature id for the '<em><b>B</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EACC__B = 0;

	/**
	 * The feature id for the '<em><b>I</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EACC__I = 1;

	/**
	 * The feature id for the '<em><b>Bs</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EACC__BS = 2;

	/**
	 * The feature id for the '<em><b>Is</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EACC__IS = 3;

	/**
	 * The number of structural features of the '<em>EAcc</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EACC_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>EAcc</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EACC_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link testaccessors.EAcc <em>EAcc</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EAcc</em>'.
	 * @see testaccessors.EAcc
	 * @generated
	 */
	EClass getEAcc();

	/**
	 * Returns the meta object for the attribute '{@link testaccessors.EAcc#isB <em>B</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>B</em>'.
	 * @see testaccessors.EAcc#isB()
	 * @see #getEAcc()
	 * @generated
	 */
	EAttribute getEAcc_B();

	/**
	 * Returns the meta object for the attribute '{@link testaccessors.EAcc#getI <em>I</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>I</em>'.
	 * @see testaccessors.EAcc#getI()
	 * @see #getEAcc()
	 * @generated
	 */
	EAttribute getEAcc_I();

	/**
	 * Returns the meta object for the attribute list '{@link testaccessors.EAcc#getBs <em>Bs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Bs</em>'.
	 * @see testaccessors.EAcc#getBs()
	 * @see #getEAcc()
	 * @generated
	 */
	EAttribute getEAcc_Bs();

	/**
	 * Returns the meta object for the attribute list '{@link testaccessors.EAcc#getIs <em>Is</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Is</em>'.
	 * @see testaccessors.EAcc#getIs()
	 * @see #getEAcc()
	 * @generated
	 */
	EAttribute getEAcc_Is();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	TestaccessorsFactory getTestaccessorsFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link testaccessors.impl.EAccImpl <em>EAcc</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see testaccessors.impl.EAccImpl
		 * @see testaccessors.impl.TestaccessorsPackageImpl#getEAcc()
		 * @generated
		 */
		EClass EACC = eINSTANCE.getEAcc();

		/**
		 * The meta object literal for the '<em><b>B</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EACC__B = eINSTANCE.getEAcc_B();

		/**
		 * The meta object literal for the '<em><b>I</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EACC__I = eINSTANCE.getEAcc_I();

		/**
		 * The meta object literal for the '<em><b>Bs</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EACC__BS = eINSTANCE.getEAcc_Bs();

		/**
		 * The meta object literal for the '<em><b>Is</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EACC__IS = eINSTANCE.getEAcc_Is();

	}

} //TestaccessorsPackage
