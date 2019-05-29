/**
 */
package testoperationbody;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
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
 * @see testoperationbody.TestoperationbodyFactory
 * @model kind="package"
 * @generated
 */
public interface TestoperationbodyPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "testoperationbody";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://testoperationbody_sub";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "testoperationbody";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	TestoperationbodyPackage eINSTANCE = testoperationbody.impl.TestoperationbodyPackageImpl.init();

	/**
	 * The meta object id for the '{@link testoperationbody.impl.MainImpl <em>Main</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see testoperationbody.impl.MainImpl
	 * @see testoperationbody.impl.TestoperationbodyPackageImpl#getMain()
	 * @generated
	 */
	int MAIN = 0;

	/**
	 * The feature id for the '<em><b>Listint</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAIN__LISTINT = 0;

	/**
	 * The feature id for the '<em><b>Listconcepta</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAIN__LISTCONCEPTA = 1;

	/**
	 * The feature id for the '<em><b>Singlebool</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAIN__SINGLEBOOL = 2;

	/**
	 * The feature id for the '<em><b>Singleconcepta</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAIN__SINGLECONCEPTA = 3;

	/**
	 * The feature id for the '<em><b>Children</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAIN__CHILDREN = 4;

	/**
	 * The number of structural features of the '<em>Main</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAIN_FEATURE_COUNT = 5;

	/**
	 * The number of operations of the '<em>Main</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAIN_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link testoperationbody.impl.ConceptAImpl <em>Concept A</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see testoperationbody.impl.ConceptAImpl
	 * @see testoperationbody.impl.TestoperationbodyPackageImpl#getConceptA()
	 * @generated
	 */
	int CONCEPT_A = 1;

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
	 * The meta object id for the '{@link testoperationbody.impl.ParentImpl <em>Parent</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see testoperationbody.impl.ParentImpl
	 * @see testoperationbody.impl.TestoperationbodyPackageImpl#getParent()
	 * @generated
	 */
	int PARENT = 2;

	/**
	 * The number of structural features of the '<em>Parent</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARENT_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Parent</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link testoperationbody.impl.ChildAImpl <em>Child A</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see testoperationbody.impl.ChildAImpl
	 * @see testoperationbody.impl.TestoperationbodyPackageImpl#getChildA()
	 * @generated
	 */
	int CHILD_A = 3;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHILD_A__VALUE = PARENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Child A</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHILD_A_FEATURE_COUNT = PARENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Child A</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHILD_A_OPERATION_COUNT = PARENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link testoperationbody.impl.ChildBImpl <em>Child B</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see testoperationbody.impl.ChildBImpl
	 * @see testoperationbody.impl.TestoperationbodyPackageImpl#getChildB()
	 * @generated
	 */
	int CHILD_B = 4;

	/**
	 * The number of structural features of the '<em>Child B</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHILD_B_FEATURE_COUNT = PARENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Child B</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHILD_B_OPERATION_COUNT = PARENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link testoperationbody.EnumA <em>Enum A</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see testoperationbody.EnumA
	 * @see testoperationbody.impl.TestoperationbodyPackageImpl#getEnumA()
	 * @generated
	 */
	int ENUM_A = 5;


	/**
	 * Returns the meta object for class '{@link testoperationbody.Main <em>Main</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Main</em>'.
	 * @see testoperationbody.Main
	 * @generated
	 */
	EClass getMain();

	/**
	 * Returns the meta object for the attribute list '{@link testoperationbody.Main#getListint <em>Listint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Listint</em>'.
	 * @see testoperationbody.Main#getListint()
	 * @see #getMain()
	 * @generated
	 */
	EAttribute getMain_Listint();

	/**
	 * Returns the meta object for the containment reference list '{@link testoperationbody.Main#getListconcepta <em>Listconcepta</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Listconcepta</em>'.
	 * @see testoperationbody.Main#getListconcepta()
	 * @see #getMain()
	 * @generated
	 */
	EReference getMain_Listconcepta();

	/**
	 * Returns the meta object for the attribute '{@link testoperationbody.Main#isSinglebool <em>Singlebool</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Singlebool</em>'.
	 * @see testoperationbody.Main#isSinglebool()
	 * @see #getMain()
	 * @generated
	 */
	EAttribute getMain_Singlebool();

	/**
	 * Returns the meta object for the reference '{@link testoperationbody.Main#getSingleconcepta <em>Singleconcepta</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Singleconcepta</em>'.
	 * @see testoperationbody.Main#getSingleconcepta()
	 * @see #getMain()
	 * @generated
	 */
	EReference getMain_Singleconcepta();

	/**
	 * Returns the meta object for the containment reference list '{@link testoperationbody.Main#getChildren <em>Children</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Children</em>'.
	 * @see testoperationbody.Main#getChildren()
	 * @see #getMain()
	 * @generated
	 */
	EReference getMain_Children();

	/**
	 * Returns the meta object for class '{@link testoperationbody.ConceptA <em>Concept A</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Concept A</em>'.
	 * @see testoperationbody.ConceptA
	 * @generated
	 */
	EClass getConceptA();

	/**
	 * Returns the meta object for class '{@link testoperationbody.Parent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parent</em>'.
	 * @see testoperationbody.Parent
	 * @generated
	 */
	EClass getParent();

	/**
	 * Returns the meta object for class '{@link testoperationbody.ChildA <em>Child A</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Child A</em>'.
	 * @see testoperationbody.ChildA
	 * @generated
	 */
	EClass getChildA();

	/**
	 * Returns the meta object for the attribute '{@link testoperationbody.ChildA#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see testoperationbody.ChildA#getValue()
	 * @see #getChildA()
	 * @generated
	 */
	EAttribute getChildA_Value();

	/**
	 * Returns the meta object for class '{@link testoperationbody.ChildB <em>Child B</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Child B</em>'.
	 * @see testoperationbody.ChildB
	 * @generated
	 */
	EClass getChildB();

	/**
	 * Returns the meta object for enum '{@link testoperationbody.EnumA <em>Enum A</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Enum A</em>'.
	 * @see testoperationbody.EnumA
	 * @generated
	 */
	EEnum getEnumA();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	TestoperationbodyFactory getTestoperationbodyFactory();

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
		 * The meta object literal for the '{@link testoperationbody.impl.MainImpl <em>Main</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see testoperationbody.impl.MainImpl
		 * @see testoperationbody.impl.TestoperationbodyPackageImpl#getMain()
		 * @generated
		 */
		EClass MAIN = eINSTANCE.getMain();

		/**
		 * The meta object literal for the '<em><b>Listint</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MAIN__LISTINT = eINSTANCE.getMain_Listint();

		/**
		 * The meta object literal for the '<em><b>Listconcepta</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAIN__LISTCONCEPTA = eINSTANCE.getMain_Listconcepta();

		/**
		 * The meta object literal for the '<em><b>Singlebool</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MAIN__SINGLEBOOL = eINSTANCE.getMain_Singlebool();

		/**
		 * The meta object literal for the '<em><b>Singleconcepta</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAIN__SINGLECONCEPTA = eINSTANCE.getMain_Singleconcepta();

		/**
		 * The meta object literal for the '<em><b>Children</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAIN__CHILDREN = eINSTANCE.getMain_Children();

		/**
		 * The meta object literal for the '{@link testoperationbody.impl.ConceptAImpl <em>Concept A</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see testoperationbody.impl.ConceptAImpl
		 * @see testoperationbody.impl.TestoperationbodyPackageImpl#getConceptA()
		 * @generated
		 */
		EClass CONCEPT_A = eINSTANCE.getConceptA();

		/**
		 * The meta object literal for the '{@link testoperationbody.impl.ParentImpl <em>Parent</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see testoperationbody.impl.ParentImpl
		 * @see testoperationbody.impl.TestoperationbodyPackageImpl#getParent()
		 * @generated
		 */
		EClass PARENT = eINSTANCE.getParent();

		/**
		 * The meta object literal for the '{@link testoperationbody.impl.ChildAImpl <em>Child A</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see testoperationbody.impl.ChildAImpl
		 * @see testoperationbody.impl.TestoperationbodyPackageImpl#getChildA()
		 * @generated
		 */
		EClass CHILD_A = eINSTANCE.getChildA();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CHILD_A__VALUE = eINSTANCE.getChildA_Value();

		/**
		 * The meta object literal for the '{@link testoperationbody.impl.ChildBImpl <em>Child B</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see testoperationbody.impl.ChildBImpl
		 * @see testoperationbody.impl.TestoperationbodyPackageImpl#getChildB()
		 * @generated
		 */
		EClass CHILD_B = eINSTANCE.getChildB();

		/**
		 * The meta object literal for the '{@link testoperationbody.EnumA <em>Enum A</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see testoperationbody.EnumA
		 * @see testoperationbody.impl.TestoperationbodyPackageImpl#getEnumA()
		 * @generated
		 */
		EEnum ENUM_A = eINSTANCE.getEnumA();

	}

} //TestoperationbodyPackage
