/**
 */
package testbidirectionalrelation;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

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
 * @see testbidirectionalrelation.TestbidirectionalrelationFactory
 * @model kind="package"
 * @generated
 */
public interface TestbidirectionalrelationPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "testbidirectionalrelation";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://testbidirectionalrelation_sub";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "testbidirectionalrelation";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	TestbidirectionalrelationPackage eINSTANCE = testbidirectionalrelation.impl.TestbidirectionalrelationPackageImpl.init();

	/**
	 * The meta object id for the '{@link testbidirectionalrelation.impl.ConceptAImpl <em>Concept A</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see testbidirectionalrelation.impl.ConceptAImpl
	 * @see testbidirectionalrelation.impl.TestbidirectionalrelationPackageImpl#getConceptA()
	 * @generated
	 */
	int CONCEPT_A = 0;

	/**
	 * The feature id for the '<em><b>Conceptb</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCEPT_A__CONCEPTB = 0;

	/**
	 * The feature id for the '<em><b>Conceptc</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCEPT_A__CONCEPTC = 1;

	/**
	 * The feature id for the '<em><b>Conceptd</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCEPT_A__CONCEPTD = 2;

	/**
	 * The feature id for the '<em><b>Concepte</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCEPT_A__CONCEPTE = 3;

	/**
	 * The feature id for the '<em><b>Conceptf</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCEPT_A__CONCEPTF = 4;

	/**
	 * The feature id for the '<em><b>Conceptg</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCEPT_A__CONCEPTG = 5;

	/**
	 * The number of structural features of the '<em>Concept A</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCEPT_A_FEATURE_COUNT = 6;

	/**
	 * The number of operations of the '<em>Concept A</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCEPT_A_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link testbidirectionalrelation.impl.ConceptBImpl <em>Concept B</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see testbidirectionalrelation.impl.ConceptBImpl
	 * @see testbidirectionalrelation.impl.TestbidirectionalrelationPackageImpl#getConceptB()
	 * @generated
	 */
	int CONCEPT_B = 1;

	/**
	 * The feature id for the '<em><b>Conceptc</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCEPT_B__CONCEPTC = 0;

	/**
	 * The number of structural features of the '<em>Concept B</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCEPT_B_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Concept B</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCEPT_B_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link testbidirectionalrelation.impl.ConceptCImpl <em>Concept C</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see testbidirectionalrelation.impl.ConceptCImpl
	 * @see testbidirectionalrelation.impl.TestbidirectionalrelationPackageImpl#getConceptC()
	 * @generated
	 */
	int CONCEPT_C = 2;

	/**
	 * The feature id for the '<em><b>Conceptb</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCEPT_C__CONCEPTB = 0;

	/**
	 * The number of structural features of the '<em>Concept C</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCEPT_C_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Concept C</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCEPT_C_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link testbidirectionalrelation.impl.ConceptDImpl <em>Concept D</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see testbidirectionalrelation.impl.ConceptDImpl
	 * @see testbidirectionalrelation.impl.TestbidirectionalrelationPackageImpl#getConceptD()
	 * @generated
	 */
	int CONCEPT_D = 3;

	/**
	 * The feature id for the '<em><b>Concepte</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCEPT_D__CONCEPTE = 0;

	/**
	 * The number of structural features of the '<em>Concept D</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCEPT_D_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Concept D</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCEPT_D_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link testbidirectionalrelation.impl.ConceptEImpl <em>Concept E</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see testbidirectionalrelation.impl.ConceptEImpl
	 * @see testbidirectionalrelation.impl.TestbidirectionalrelationPackageImpl#getConceptE()
	 * @generated
	 */
	int CONCEPT_E = 4;

	/**
	 * The feature id for the '<em><b>Conceptd</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCEPT_E__CONCEPTD = 0;

	/**
	 * The number of structural features of the '<em>Concept E</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCEPT_E_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Concept E</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCEPT_E_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link testbidirectionalrelation.impl.ConceptFImpl <em>Concept F</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see testbidirectionalrelation.impl.ConceptFImpl
	 * @see testbidirectionalrelation.impl.TestbidirectionalrelationPackageImpl#getConceptF()
	 * @generated
	 */
	int CONCEPT_F = 5;

	/**
	 * The feature id for the '<em><b>Conceptg</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCEPT_F__CONCEPTG = 0;

	/**
	 * The number of structural features of the '<em>Concept F</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCEPT_F_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Concept F</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCEPT_F_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link testbidirectionalrelation.impl.ConceptGImpl <em>Concept G</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see testbidirectionalrelation.impl.ConceptGImpl
	 * @see testbidirectionalrelation.impl.TestbidirectionalrelationPackageImpl#getConceptG()
	 * @generated
	 */
	int CONCEPT_G = 6;

	/**
	 * The feature id for the '<em><b>Conceptf</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCEPT_G__CONCEPTF = 0;

	/**
	 * The number of structural features of the '<em>Concept G</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCEPT_G_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Concept G</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCEPT_G_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link testbidirectionalrelation.ConceptA <em>Concept A</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Concept A</em>'.
	 * @see testbidirectionalrelation.ConceptA
	 * @generated
	 */
	EClass getConceptA();

	/**
	 * Returns the meta object for the containment reference list '{@link testbidirectionalrelation.ConceptA#getConceptb <em>Conceptb</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Conceptb</em>'.
	 * @see testbidirectionalrelation.ConceptA#getConceptb()
	 * @see #getConceptA()
	 * @generated
	 */
	EReference getConceptA_Conceptb();

	/**
	 * Returns the meta object for the containment reference list '{@link testbidirectionalrelation.ConceptA#getConceptc <em>Conceptc</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Conceptc</em>'.
	 * @see testbidirectionalrelation.ConceptA#getConceptc()
	 * @see #getConceptA()
	 * @generated
	 */
	EReference getConceptA_Conceptc();

	/**
	 * Returns the meta object for the containment reference list '{@link testbidirectionalrelation.ConceptA#getConceptd <em>Conceptd</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Conceptd</em>'.
	 * @see testbidirectionalrelation.ConceptA#getConceptd()
	 * @see #getConceptA()
	 * @generated
	 */
	EReference getConceptA_Conceptd();

	/**
	 * Returns the meta object for the containment reference list '{@link testbidirectionalrelation.ConceptA#getConcepte <em>Concepte</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Concepte</em>'.
	 * @see testbidirectionalrelation.ConceptA#getConcepte()
	 * @see #getConceptA()
	 * @generated
	 */
	EReference getConceptA_Concepte();

	/**
	 * Returns the meta object for the containment reference list '{@link testbidirectionalrelation.ConceptA#getConceptf <em>Conceptf</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Conceptf</em>'.
	 * @see testbidirectionalrelation.ConceptA#getConceptf()
	 * @see #getConceptA()
	 * @generated
	 */
	EReference getConceptA_Conceptf();

	/**
	 * Returns the meta object for the containment reference list '{@link testbidirectionalrelation.ConceptA#getConceptg <em>Conceptg</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Conceptg</em>'.
	 * @see testbidirectionalrelation.ConceptA#getConceptg()
	 * @see #getConceptA()
	 * @generated
	 */
	EReference getConceptA_Conceptg();

	/**
	 * Returns the meta object for class '{@link testbidirectionalrelation.ConceptB <em>Concept B</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Concept B</em>'.
	 * @see testbidirectionalrelation.ConceptB
	 * @generated
	 */
	EClass getConceptB();

	/**
	 * Returns the meta object for the reference '{@link testbidirectionalrelation.ConceptB#getConceptc <em>Conceptc</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Conceptc</em>'.
	 * @see testbidirectionalrelation.ConceptB#getConceptc()
	 * @see #getConceptB()
	 * @generated
	 */
	EReference getConceptB_Conceptc();

	/**
	 * Returns the meta object for class '{@link testbidirectionalrelation.ConceptC <em>Concept C</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Concept C</em>'.
	 * @see testbidirectionalrelation.ConceptC
	 * @generated
	 */
	EClass getConceptC();

	/**
	 * Returns the meta object for the reference '{@link testbidirectionalrelation.ConceptC#getConceptb <em>Conceptb</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Conceptb</em>'.
	 * @see testbidirectionalrelation.ConceptC#getConceptb()
	 * @see #getConceptC()
	 * @generated
	 */
	EReference getConceptC_Conceptb();

	/**
	 * Returns the meta object for class '{@link testbidirectionalrelation.ConceptD <em>Concept D</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Concept D</em>'.
	 * @see testbidirectionalrelation.ConceptD
	 * @generated
	 */
	EClass getConceptD();

	/**
	 * Returns the meta object for the reference '{@link testbidirectionalrelation.ConceptD#getConcepte <em>Concepte</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Concepte</em>'.
	 * @see testbidirectionalrelation.ConceptD#getConcepte()
	 * @see #getConceptD()
	 * @generated
	 */
	EReference getConceptD_Concepte();

	/**
	 * Returns the meta object for class '{@link testbidirectionalrelation.ConceptE <em>Concept E</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Concept E</em>'.
	 * @see testbidirectionalrelation.ConceptE
	 * @generated
	 */
	EClass getConceptE();

	/**
	 * Returns the meta object for the reference list '{@link testbidirectionalrelation.ConceptE#getConceptd <em>Conceptd</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Conceptd</em>'.
	 * @see testbidirectionalrelation.ConceptE#getConceptd()
	 * @see #getConceptE()
	 * @generated
	 */
	EReference getConceptE_Conceptd();

	/**
	 * Returns the meta object for class '{@link testbidirectionalrelation.ConceptF <em>Concept F</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Concept F</em>'.
	 * @see testbidirectionalrelation.ConceptF
	 * @generated
	 */
	EClass getConceptF();

	/**
	 * Returns the meta object for the reference list '{@link testbidirectionalrelation.ConceptF#getConceptg <em>Conceptg</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Conceptg</em>'.
	 * @see testbidirectionalrelation.ConceptF#getConceptg()
	 * @see #getConceptF()
	 * @generated
	 */
	EReference getConceptF_Conceptg();

	/**
	 * Returns the meta object for class '{@link testbidirectionalrelation.ConceptG <em>Concept G</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Concept G</em>'.
	 * @see testbidirectionalrelation.ConceptG
	 * @generated
	 */
	EClass getConceptG();

	/**
	 * Returns the meta object for the reference list '{@link testbidirectionalrelation.ConceptG#getConceptf <em>Conceptf</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Conceptf</em>'.
	 * @see testbidirectionalrelation.ConceptG#getConceptf()
	 * @see #getConceptG()
	 * @generated
	 */
	EReference getConceptG_Conceptf();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	TestbidirectionalrelationFactory getTestbidirectionalrelationFactory();

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
		 * The meta object literal for the '{@link testbidirectionalrelation.impl.ConceptAImpl <em>Concept A</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see testbidirectionalrelation.impl.ConceptAImpl
		 * @see testbidirectionalrelation.impl.TestbidirectionalrelationPackageImpl#getConceptA()
		 * @generated
		 */
		EClass CONCEPT_A = eINSTANCE.getConceptA();

		/**
		 * The meta object literal for the '<em><b>Conceptb</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONCEPT_A__CONCEPTB = eINSTANCE.getConceptA_Conceptb();

		/**
		 * The meta object literal for the '<em><b>Conceptc</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONCEPT_A__CONCEPTC = eINSTANCE.getConceptA_Conceptc();

		/**
		 * The meta object literal for the '<em><b>Conceptd</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONCEPT_A__CONCEPTD = eINSTANCE.getConceptA_Conceptd();

		/**
		 * The meta object literal for the '<em><b>Concepte</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONCEPT_A__CONCEPTE = eINSTANCE.getConceptA_Concepte();

		/**
		 * The meta object literal for the '<em><b>Conceptf</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONCEPT_A__CONCEPTF = eINSTANCE.getConceptA_Conceptf();

		/**
		 * The meta object literal for the '<em><b>Conceptg</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONCEPT_A__CONCEPTG = eINSTANCE.getConceptA_Conceptg();

		/**
		 * The meta object literal for the '{@link testbidirectionalrelation.impl.ConceptBImpl <em>Concept B</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see testbidirectionalrelation.impl.ConceptBImpl
		 * @see testbidirectionalrelation.impl.TestbidirectionalrelationPackageImpl#getConceptB()
		 * @generated
		 */
		EClass CONCEPT_B = eINSTANCE.getConceptB();

		/**
		 * The meta object literal for the '<em><b>Conceptc</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONCEPT_B__CONCEPTC = eINSTANCE.getConceptB_Conceptc();

		/**
		 * The meta object literal for the '{@link testbidirectionalrelation.impl.ConceptCImpl <em>Concept C</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see testbidirectionalrelation.impl.ConceptCImpl
		 * @see testbidirectionalrelation.impl.TestbidirectionalrelationPackageImpl#getConceptC()
		 * @generated
		 */
		EClass CONCEPT_C = eINSTANCE.getConceptC();

		/**
		 * The meta object literal for the '<em><b>Conceptb</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONCEPT_C__CONCEPTB = eINSTANCE.getConceptC_Conceptb();

		/**
		 * The meta object literal for the '{@link testbidirectionalrelation.impl.ConceptDImpl <em>Concept D</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see testbidirectionalrelation.impl.ConceptDImpl
		 * @see testbidirectionalrelation.impl.TestbidirectionalrelationPackageImpl#getConceptD()
		 * @generated
		 */
		EClass CONCEPT_D = eINSTANCE.getConceptD();

		/**
		 * The meta object literal for the '<em><b>Concepte</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONCEPT_D__CONCEPTE = eINSTANCE.getConceptD_Concepte();

		/**
		 * The meta object literal for the '{@link testbidirectionalrelation.impl.ConceptEImpl <em>Concept E</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see testbidirectionalrelation.impl.ConceptEImpl
		 * @see testbidirectionalrelation.impl.TestbidirectionalrelationPackageImpl#getConceptE()
		 * @generated
		 */
		EClass CONCEPT_E = eINSTANCE.getConceptE();

		/**
		 * The meta object literal for the '<em><b>Conceptd</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONCEPT_E__CONCEPTD = eINSTANCE.getConceptE_Conceptd();

		/**
		 * The meta object literal for the '{@link testbidirectionalrelation.impl.ConceptFImpl <em>Concept F</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see testbidirectionalrelation.impl.ConceptFImpl
		 * @see testbidirectionalrelation.impl.TestbidirectionalrelationPackageImpl#getConceptF()
		 * @generated
		 */
		EClass CONCEPT_F = eINSTANCE.getConceptF();

		/**
		 * The meta object literal for the '<em><b>Conceptg</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONCEPT_F__CONCEPTG = eINSTANCE.getConceptF_Conceptg();

		/**
		 * The meta object literal for the '{@link testbidirectionalrelation.impl.ConceptGImpl <em>Concept G</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see testbidirectionalrelation.impl.ConceptGImpl
		 * @see testbidirectionalrelation.impl.TestbidirectionalrelationPackageImpl#getConceptG()
		 * @generated
		 */
		EClass CONCEPT_G = eINSTANCE.getConceptG();

		/**
		 * The meta object literal for the '<em><b>Conceptf</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONCEPT_G__CONCEPTF = eINSTANCE.getConceptG_Conceptf();

	}

} //TestbidirectionalrelationPackage
