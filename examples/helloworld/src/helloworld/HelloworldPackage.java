/**
 */
package helloworld;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
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
 * @see helloworld.HelloworldFactory
 * @model kind="package"
 * @generated
 */
public interface HelloworldPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "helloworld";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://ale/helloworld";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "helloworld";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	HelloworldPackage eINSTANCE = helloworld.impl.HelloworldPackageImpl.init();

	/**
	 * The meta object id for the '{@link helloworld.impl.HelloWorldImpl <em>Hello World</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see helloworld.impl.HelloWorldImpl
	 * @see helloworld.impl.HelloworldPackageImpl#getHelloWorld()
	 * @generated
	 */
	int HELLO_WORLD = 0;

	/**
	 * The number of structural features of the '<em>Hello World</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HELLO_WORLD_FEATURE_COUNT = 0;

	/**
	 * The operation id for the '<em>Greeting</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HELLO_WORLD___GREETING = 0;

	/**
	 * The number of operations of the '<em>Hello World</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HELLO_WORLD_OPERATION_COUNT = 1;


	/**
	 * Returns the meta object for class '{@link helloworld.HelloWorld <em>Hello World</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Hello World</em>'.
	 * @see helloworld.HelloWorld
	 * @generated
	 */
	EClass getHelloWorld();

	/**
	 * Returns the meta object for the '{@link helloworld.HelloWorld#greeting() <em>Greeting</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Greeting</em>' operation.
	 * @see helloworld.HelloWorld#greeting()
	 * @generated
	 */
	EOperation getHelloWorld__Greeting();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	HelloworldFactory getHelloworldFactory();

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
		 * The meta object literal for the '{@link helloworld.impl.HelloWorldImpl <em>Hello World</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see helloworld.impl.HelloWorldImpl
		 * @see helloworld.impl.HelloworldPackageImpl#getHelloWorld()
		 * @generated
		 */
		EClass HELLO_WORLD = eINSTANCE.getHelloWorld();

		/**
		 * The meta object literal for the '<em><b>Greeting</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation HELLO_WORLD___GREETING = eINSTANCE.getHelloWorld__Greeting();

	}

} //HelloworldPackage
