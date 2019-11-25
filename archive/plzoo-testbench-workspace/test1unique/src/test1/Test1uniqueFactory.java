/**
 */
package test1;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see test1.Test1uniquePackage
 * @generated
 */
public interface Test1uniqueFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	Test1uniqueFactory eINSTANCE = test1.impl.Test1uniqueFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Concept A</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Concept A</em>'.
	 * @generated
	 */
	ConceptA createConceptA();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	Test1uniquePackage getTest1uniquePackage();

} //Test1uniqueFactory
