/**
 */
package autocast;

import org.eclipse.emf.ecore.EAttribute;
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
 * @see autocast.AutocastFactory
 * @model kind="package"
 * @generated
 */
public interface AutocastPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "autocast";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://autocast";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "autocast";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	AutocastPackage eINSTANCE = autocast.impl.AutocastPackageImpl.init();

	/**
	 * The meta object id for the '{@link autocast.impl.ConceptAImpl <em>Concept A</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see autocast.impl.ConceptAImpl
	 * @see autocast.impl.AutocastPackageImpl#getConceptA()
	 * @generated
	 */
	int CONCEPT_A = 0;

	/**
	 * The number of structural features of the '<em>Concept A</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCEPT_A_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Concept A</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCEPT_A_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link autocast.impl.ConceptBImpl <em>Concept B</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see autocast.impl.ConceptBImpl
	 * @see autocast.impl.AutocastPackageImpl#getConceptB()
	 * @generated
	 */
	int CONCEPT_B = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCEPT_B__NAME = CONCEPT_A_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Concept B</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCEPT_B_FEATURE_COUNT = CONCEPT_A_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Concept B</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCEPT_B_OPERATION_COUNT = CONCEPT_A_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link autocast.impl.ConceptCImpl <em>Concept C</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see autocast.impl.ConceptCImpl
	 * @see autocast.impl.AutocastPackageImpl#getConceptC()
	 * @generated
	 */
	int CONCEPT_C = 2;

	/**
	 * The feature id for the '<em><b>Ax</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCEPT_C__AX = 0;

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
	 * Returns the meta object for class '{@link autocast.ConceptA <em>Concept A</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Concept A</em>'.
	 * @see autocast.ConceptA
	 * @generated
	 */
	EClass getConceptA();

	/**
	 * Returns the meta object for class '{@link autocast.ConceptB <em>Concept B</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Concept B</em>'.
	 * @see autocast.ConceptB
	 * @generated
	 */
	EClass getConceptB();

	/**
	 * Returns the meta object for the attribute '{@link autocast.ConceptB#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see autocast.ConceptB#getName()
	 * @see #getConceptB()
	 * @generated
	 */
	EAttribute getConceptB_Name();

	/**
	 * Returns the meta object for class '{@link autocast.ConceptC <em>Concept C</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Concept C</em>'.
	 * @see autocast.ConceptC
	 * @generated
	 */
	EClass getConceptC();

	/**
	 * Returns the meta object for the containment reference list '{@link autocast.ConceptC#getAx <em>Ax</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Ax</em>'.
	 * @see autocast.ConceptC#getAx()
	 * @see #getConceptC()
	 * @generated
	 */
	EReference getConceptC_Ax();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	AutocastFactory getAutocastFactory();

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
		 * The meta object literal for the '{@link autocast.impl.ConceptAImpl <em>Concept A</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see autocast.impl.ConceptAImpl
		 * @see autocast.impl.AutocastPackageImpl#getConceptA()
		 * @generated
		 */
		EClass CONCEPT_A = eINSTANCE.getConceptA();

		/**
		 * The meta object literal for the '{@link autocast.impl.ConceptBImpl <em>Concept B</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see autocast.impl.ConceptBImpl
		 * @see autocast.impl.AutocastPackageImpl#getConceptB()
		 * @generated
		 */
		EClass CONCEPT_B = eINSTANCE.getConceptB();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONCEPT_B__NAME = eINSTANCE.getConceptB_Name();

		/**
		 * The meta object literal for the '{@link autocast.impl.ConceptCImpl <em>Concept C</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see autocast.impl.ConceptCImpl
		 * @see autocast.impl.AutocastPackageImpl#getConceptC()
		 * @generated
		 */
		EClass CONCEPT_C = eINSTANCE.getConceptC();

		/**
		 * The meta object literal for the '<em><b>Ax</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONCEPT_C__AX = eINSTANCE.getConceptC_Ax();

	}

} //AutocastPackage
