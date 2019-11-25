/**
 */
package test1;

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
 * @see test1.Test1Factory
 * @model kind="package"
 * @generated
 */
public interface Test1Package extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "test1";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://test111";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "test1";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	Test1Package eINSTANCE = test1.impl.Test1PackageImpl.init();

	/**
	 * The meta object id for the '{@link test1.impl.ConceptAImpl <em>Concept A</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see test1.impl.ConceptAImpl
	 * @see test1.impl.Test1PackageImpl#getConceptA()
	 * @generated
	 */
	int CONCEPT_A = 0;

	/**
	 * The feature id for the '<em><b>Cs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCEPT_A__CS = 0;

	/**
	 * The number of structural features of the '<em>Concept A</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCEPT_A_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Concept A</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCEPT_A_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link test1.impl.ConceptBImpl <em>Concept B</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see test1.impl.ConceptBImpl
	 * @see test1.impl.Test1PackageImpl#getConceptB()
	 * @generated
	 */
	int CONCEPT_B = 1;

	/**
	 * The feature id for the '<em><b>Cs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCEPT_B__CS = CONCEPT_A__CS;

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
	 * The meta object id for the '{@link test1.impl.ConceptCImpl <em>Concept C</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see test1.impl.ConceptCImpl
	 * @see test1.impl.Test1PackageImpl#getConceptC()
	 * @generated
	 */
	int CONCEPT_C = 2;

	/**
	 * The feature id for the '<em><b>Nbr</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCEPT_C__NBR = 0;

	/**
	 * The feature id for the '<em><b>Cool</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCEPT_C__COOL = 1;

	/**
	 * The number of structural features of the '<em>Concept C</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCEPT_C_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Concept C</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCEPT_C_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link test1.ConceptA <em>Concept A</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Concept A</em>'.
	 * @see test1.ConceptA
	 * @generated
	 */
	EClass getConceptA();

	/**
	 * Returns the meta object for the containment reference list '{@link test1.ConceptA#getCs <em>Cs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Cs</em>'.
	 * @see test1.ConceptA#getCs()
	 * @see #getConceptA()
	 * @generated
	 */
	EReference getConceptA_Cs();

	/**
	 * Returns the meta object for class '{@link test1.ConceptB <em>Concept B</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Concept B</em>'.
	 * @see test1.ConceptB
	 * @generated
	 */
	EClass getConceptB();

	/**
	 * Returns the meta object for class '{@link test1.ConceptC <em>Concept C</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Concept C</em>'.
	 * @see test1.ConceptC
	 * @generated
	 */
	EClass getConceptC();

	/**
	 * Returns the meta object for the attribute '{@link test1.ConceptC#getNbr <em>Nbr</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Nbr</em>'.
	 * @see test1.ConceptC#getNbr()
	 * @see #getConceptC()
	 * @generated
	 */
	EAttribute getConceptC_Nbr();

	/**
	 * Returns the meta object for the attribute '{@link test1.ConceptC#isCool <em>Cool</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Cool</em>'.
	 * @see test1.ConceptC#isCool()
	 * @see #getConceptC()
	 * @generated
	 */
	EAttribute getConceptC_Cool();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	Test1Factory getTest1Factory();

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
		 * The meta object literal for the '{@link test1.impl.ConceptAImpl <em>Concept A</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see test1.impl.ConceptAImpl
		 * @see test1.impl.Test1PackageImpl#getConceptA()
		 * @generated
		 */
		EClass CONCEPT_A = eINSTANCE.getConceptA();

		/**
		 * The meta object literal for the '<em><b>Cs</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONCEPT_A__CS = eINSTANCE.getConceptA_Cs();

		/**
		 * The meta object literal for the '{@link test1.impl.ConceptBImpl <em>Concept B</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see test1.impl.ConceptBImpl
		 * @see test1.impl.Test1PackageImpl#getConceptB()
		 * @generated
		 */
		EClass CONCEPT_B = eINSTANCE.getConceptB();

		/**
		 * The meta object literal for the '{@link test1.impl.ConceptCImpl <em>Concept C</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see test1.impl.ConceptCImpl
		 * @see test1.impl.Test1PackageImpl#getConceptC()
		 * @generated
		 */
		EClass CONCEPT_C = eINSTANCE.getConceptC();

		/**
		 * The meta object literal for the '<em><b>Nbr</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONCEPT_C__NBR = eINSTANCE.getConceptC_Nbr();

		/**
		 * The meta object literal for the '<em><b>Cool</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONCEPT_C__COOL = eINSTANCE.getConceptC_Cool();

	}

} //Test1Package
