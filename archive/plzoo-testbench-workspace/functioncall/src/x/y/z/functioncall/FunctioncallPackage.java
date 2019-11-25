/**
 */
package x.y.z.functioncall;

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
 * @see x.y.z.functioncall.FunctioncallFactory
 * @model kind="package"
 * @generated
 */
public interface FunctioncallPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "functioncall";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://functioncall";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "functioncall";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	FunctioncallPackage eINSTANCE = x.y.z.functioncall.impl.FunctioncallPackageImpl.init();

	/**
	 * The meta object id for the '{@link x.y.z.functioncall.impl.ConceptAImpl <em>Concept A</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see x.y.z.functioncall.impl.ConceptAImpl
	 * @see x.y.z.functioncall.impl.FunctioncallPackageImpl#getConceptA()
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
	 * The meta object id for the '{@link x.y.z.functioncall.impl.ConceptBImpl <em>Concept B</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see x.y.z.functioncall.impl.ConceptBImpl
	 * @see x.y.z.functioncall.impl.FunctioncallPackageImpl#getConceptB()
	 * @generated
	 */
	int CONCEPT_B = 1;

	/**
	 * The number of structural features of the '<em>Concept B</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCEPT_B_FEATURE_COUNT = CONCEPT_A_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Concept B</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCEPT_B_OPERATION_COUNT = CONCEPT_A_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link x.y.z.functioncall.impl.ConceptCImpl <em>Concept C</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see x.y.z.functioncall.impl.ConceptCImpl
	 * @see x.y.z.functioncall.impl.FunctioncallPackageImpl#getConceptC()
	 * @generated
	 */
	int CONCEPT_C = 2;

	/**
	 * The feature id for the '<em><b>Concepta2</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCEPT_C__CONCEPTA2 = 0;

	/**
	 * The feature id for the '<em><b>Concepta1</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCEPT_C__CONCEPTA1 = 1;

	/**
	 * The feature id for the '<em><b>Conceptb</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCEPT_C__CONCEPTB = 2;

	/**
	 * The number of structural features of the '<em>Concept C</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCEPT_C_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Concept C</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCEPT_C_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link x.y.z.functioncall.ConceptA <em>Concept A</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Concept A</em>'.
	 * @see x.y.z.functioncall.ConceptA
	 * @generated
	 */
	EClass getConceptA();

	/**
	 * Returns the meta object for class '{@link x.y.z.functioncall.ConceptB <em>Concept B</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Concept B</em>'.
	 * @see x.y.z.functioncall.ConceptB
	 * @generated
	 */
	EClass getConceptB();

	/**
	 * Returns the meta object for class '{@link x.y.z.functioncall.ConceptC <em>Concept C</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Concept C</em>'.
	 * @see x.y.z.functioncall.ConceptC
	 * @generated
	 */
	EClass getConceptC();

	/**
	 * Returns the meta object for the containment reference '{@link x.y.z.functioncall.ConceptC#getConcepta2 <em>Concepta2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Concepta2</em>'.
	 * @see x.y.z.functioncall.ConceptC#getConcepta2()
	 * @see #getConceptC()
	 * @generated
	 */
	EReference getConceptC_Concepta2();

	/**
	 * Returns the meta object for the containment reference '{@link x.y.z.functioncall.ConceptC#getConcepta1 <em>Concepta1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Concepta1</em>'.
	 * @see x.y.z.functioncall.ConceptC#getConcepta1()
	 * @see #getConceptC()
	 * @generated
	 */
	EReference getConceptC_Concepta1();

	/**
	 * Returns the meta object for the containment reference '{@link x.y.z.functioncall.ConceptC#getConceptb <em>Conceptb</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Conceptb</em>'.
	 * @see x.y.z.functioncall.ConceptC#getConceptb()
	 * @see #getConceptC()
	 * @generated
	 */
	EReference getConceptC_Conceptb();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	FunctioncallFactory getFunctioncallFactory();

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
		 * The meta object literal for the '{@link x.y.z.functioncall.impl.ConceptAImpl <em>Concept A</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see x.y.z.functioncall.impl.ConceptAImpl
		 * @see x.y.z.functioncall.impl.FunctioncallPackageImpl#getConceptA()
		 * @generated
		 */
		EClass CONCEPT_A = eINSTANCE.getConceptA();

		/**
		 * The meta object literal for the '{@link x.y.z.functioncall.impl.ConceptBImpl <em>Concept B</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see x.y.z.functioncall.impl.ConceptBImpl
		 * @see x.y.z.functioncall.impl.FunctioncallPackageImpl#getConceptB()
		 * @generated
		 */
		EClass CONCEPT_B = eINSTANCE.getConceptB();

		/**
		 * The meta object literal for the '{@link x.y.z.functioncall.impl.ConceptCImpl <em>Concept C</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see x.y.z.functioncall.impl.ConceptCImpl
		 * @see x.y.z.functioncall.impl.FunctioncallPackageImpl#getConceptC()
		 * @generated
		 */
		EClass CONCEPT_C = eINSTANCE.getConceptC();

		/**
		 * The meta object literal for the '<em><b>Concepta2</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONCEPT_C__CONCEPTA2 = eINSTANCE.getConceptC_Concepta2();

		/**
		 * The meta object literal for the '<em><b>Concepta1</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONCEPT_C__CONCEPTA1 = eINSTANCE.getConceptC_Concepta1();

		/**
		 * The meta object literal for the '<em><b>Conceptb</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONCEPT_C__CONCEPTB = eINSTANCE.getConceptC_Conceptb();

	}

} //FunctioncallPackage
