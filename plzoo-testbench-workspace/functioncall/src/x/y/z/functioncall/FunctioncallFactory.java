/**
 */
package x.y.z.functioncall;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see x.y.z.functioncall.FunctioncallPackage
 * @generated
 */
public interface FunctioncallFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	FunctioncallFactory eINSTANCE = x.y.z.functioncall.impl.FunctioncallFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Concept A</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Concept A</em>'.
	 * @generated
	 */
	ConceptA createConceptA();

	/**
	 * Returns a new object of class '<em>Concept B</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Concept B</em>'.
	 * @generated
	 */
	ConceptB createConceptB();

	/**
	 * Returns a new object of class '<em>Concept C</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Concept C</em>'.
	 * @generated
	 */
	ConceptC createConceptC();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	FunctioncallPackage getFunctioncallPackage();

} //FunctioncallFactory
