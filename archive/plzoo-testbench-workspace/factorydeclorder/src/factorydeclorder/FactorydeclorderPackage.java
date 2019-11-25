/**
 */
package factorydeclorder;

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
 * @see factorydeclorder.FactorydeclorderFactory
 * @model kind="package"
 * @generated
 */
public interface FactorydeclorderPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "factorydeclorder";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://factorydeclorder";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "factorydeclorder";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	FactorydeclorderPackage eINSTANCE = factorydeclorder.impl.FactorydeclorderPackageImpl.init();

	/**
	 * The meta object id for the '{@link factorydeclorder.impl.BImpl <em>B</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see factorydeclorder.impl.BImpl
	 * @see factorydeclorder.impl.FactorydeclorderPackageImpl#getB()
	 * @generated
	 */
	int B = 2;

	/**
	 * The feature id for the '<em><b>Fb</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int B__FB = 0;

	/**
	 * The number of structural features of the '<em>B</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int B_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>B</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int B_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link factorydeclorder.impl.CImpl <em>C</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see factorydeclorder.impl.CImpl
	 * @see factorydeclorder.impl.FactorydeclorderPackageImpl#getC()
	 * @generated
	 */
	int C = 0;

	/**
	 * The feature id for the '<em><b>Fb</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int C__FB = B__FB;

	/**
	 * The feature id for the '<em><b>Fa</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int C__FA = B_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Fc</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int C__FC = B_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>C</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int C_FEATURE_COUNT = B_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>C</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int C_OPERATION_COUNT = B_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link factorydeclorder.impl.DImpl <em>D</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see factorydeclorder.impl.DImpl
	 * @see factorydeclorder.impl.FactorydeclorderPackageImpl#getD()
	 * @generated
	 */
	int D = 3;

	/**
	 * The number of structural features of the '<em>D</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int D_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>D</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int D_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link factorydeclorder.impl.AImpl <em>A</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see factorydeclorder.impl.AImpl
	 * @see factorydeclorder.impl.FactorydeclorderPackageImpl#getA()
	 * @generated
	 */
	int A = 1;

	/**
	 * The feature id for the '<em><b>Fb</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int A__FB = D_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Fa</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int A__FA = D_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>A</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int A_FEATURE_COUNT = D_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>A</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int A_OPERATION_COUNT = D_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link factorydeclorder.C <em>C</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>C</em>'.
	 * @see factorydeclorder.C
	 * @generated
	 */
	EClass getC();

	/**
	 * Returns the meta object for the attribute '{@link factorydeclorder.C#isFc <em>Fc</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Fc</em>'.
	 * @see factorydeclorder.C#isFc()
	 * @see #getC()
	 * @generated
	 */
	EAttribute getC_Fc();

	/**
	 * Returns the meta object for class '{@link factorydeclorder.A <em>A</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>A</em>'.
	 * @see factorydeclorder.A
	 * @generated
	 */
	EClass getA();

	/**
	 * Returns the meta object for the attribute '{@link factorydeclorder.A#getFa <em>Fa</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Fa</em>'.
	 * @see factorydeclorder.A#getFa()
	 * @see #getA()
	 * @generated
	 */
	EAttribute getA_Fa();

	/**
	 * Returns the meta object for class '{@link factorydeclorder.B <em>B</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>B</em>'.
	 * @see factorydeclorder.B
	 * @generated
	 */
	EClass getB();

	/**
	 * Returns the meta object for the attribute '{@link factorydeclorder.B#getFb <em>Fb</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Fb</em>'.
	 * @see factorydeclorder.B#getFb()
	 * @see #getB()
	 * @generated
	 */
	EAttribute getB_Fb();

	/**
	 * Returns the meta object for class '{@link factorydeclorder.D <em>D</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>D</em>'.
	 * @see factorydeclorder.D
	 * @generated
	 */
	EClass getD();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	FactorydeclorderFactory getFactorydeclorderFactory();

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
		 * The meta object literal for the '{@link factorydeclorder.impl.CImpl <em>C</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see factorydeclorder.impl.CImpl
		 * @see factorydeclorder.impl.FactorydeclorderPackageImpl#getC()
		 * @generated
		 */
		EClass C = eINSTANCE.getC();

		/**
		 * The meta object literal for the '<em><b>Fc</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute C__FC = eINSTANCE.getC_Fc();

		/**
		 * The meta object literal for the '{@link factorydeclorder.impl.AImpl <em>A</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see factorydeclorder.impl.AImpl
		 * @see factorydeclorder.impl.FactorydeclorderPackageImpl#getA()
		 * @generated
		 */
		EClass A = eINSTANCE.getA();

		/**
		 * The meta object literal for the '<em><b>Fa</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute A__FA = eINSTANCE.getA_Fa();

		/**
		 * The meta object literal for the '{@link factorydeclorder.impl.BImpl <em>B</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see factorydeclorder.impl.BImpl
		 * @see factorydeclorder.impl.FactorydeclorderPackageImpl#getB()
		 * @generated
		 */
		EClass B = eINSTANCE.getB();

		/**
		 * The meta object literal for the '<em><b>Fb</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute B__FB = eINSTANCE.getB_Fb();

		/**
		 * The meta object literal for the '{@link factorydeclorder.impl.DImpl <em>D</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see factorydeclorder.impl.DImpl
		 * @see factorydeclorder.impl.FactorydeclorderPackageImpl#getD()
		 * @generated
		 */
		EClass D = eINSTANCE.getD();

	}

} //FactorydeclorderPackage
