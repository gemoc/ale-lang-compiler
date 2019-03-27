/**
 */
package testoperationbody;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see testoperationbody.TestoperationbodyPackage
 * @generated
 */
public interface TestoperationbodyFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	TestoperationbodyFactory eINSTANCE = testoperationbody.impl.TestoperationbodyFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Main</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Main</em>'.
	 * @generated
	 */
	Main createMain();

	/**
	 * Returns a new object of class '<em>Concept A</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Concept A</em>'.
	 * @generated
	 */
	ConceptA createConceptA();

	/**
	 * Returns a new object of class '<em>Child A</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Child A</em>'.
	 * @generated
	 */
	ChildA createChildA();

	/**
	 * Returns a new object of class '<em>Child B</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Child B</em>'.
	 * @generated
	 */
	ChildB createChildB();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	TestoperationbodyPackage getTestoperationbodyPackage();

} //TestoperationbodyFactory
