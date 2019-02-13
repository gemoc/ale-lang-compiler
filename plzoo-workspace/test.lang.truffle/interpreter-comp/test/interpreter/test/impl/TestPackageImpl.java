package test.interpreter.test.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import test.interpreter.test.TestFactory;
import test.interpreter.test.TestPackage;

public class TestPackageImpl extends EPackageImpl implements TestPackage {
  private static boolean isInited = false;

  private boolean isCreated = false;

  private boolean isInitialized = false;

  private EClass aEClass = null;

  private EClass bEClass = null;

  private EClass cEClass = null;

  private EClass programEClass = null;

  private TestPackageImpl() {
    super(eNS_URI, TestFactory.eINSTANCE);
  }

  public static TestPackage init() {
    if (isInited)
    	return (TestPackage) EPackage.Registry.INSTANCE.getEPackage(TestPackage.eNS_URI);

    // Obtain or create and register package
    Object registeredTestPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
    test.interpreter.test.impl.TestPackageImpl theTestPackage;
    if(registeredTestPackage instanceof test.interpreter.test.impl.TestPackageImpl) {
    	 theTestPackage =  (test.interpreter.test.impl.TestPackageImpl) registeredTestPackage;
    } else {
     	theTestPackage = new test.interpreter.test.impl.TestPackageImpl();
    }
    isInited = true;
    				
    // Create package meta-data objects
    theTestPackage.createPackageContents();

    // Initialize created meta-data
    theTestPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theTestPackage.freeze();

    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(TestPackage.eNS_URI, theTestPackage);
    return theTestPackage;
  }

  public void createPackageContents() {
    if(isCreated)
    	return;
    isCreated = true;

    aEClass = createEClass(A);
    bEClass = createEClass(B);
    cEClass = createEClass(C);
    createEReference(cEClass, C__B);
    createEReference(cEClass, C__A);
    programEClass = createEClass(PROGRAM);
    createEReference(programEClass, PROGRAM__AS);
    createEReference(programEClass, PROGRAM__CS);
  }

  public void initializePackageContents() {
    if (isInitialized)
    	return;
    isInitialized = true;

    // Initialize package
    setName(eNAME);
    setNsPrefix(eNS_PREFIX);
    setNsURI(eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes
    bEClass.getESuperTypes().add(this.getA());

    // Initialize classes, features, and operations; add parameters
    initEClass(aEClass, test.interpreter.test.A.class, "A", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEClass(bEClass, test.interpreter.test.B.class, "B", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEClass(cEClass, test.interpreter.test.C.class, "C", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getC_B(), this.getB(),  
    	null, "b", null, 0, 1,  test.interpreter.test.C.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getC_A(), this.getA(),  
    	null, "a", null, 0, 1,  test.interpreter.test.C.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEClass(programEClass, test.interpreter.test.Program.class, "Program", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getProgram_As(), this.getA(),  
    	null, "as", null, 0, -1,  test.interpreter.test.Program.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getProgram_Cs(), this.getC(),  
    	null, "cs", null, 0, -1,  test.interpreter.test.Program.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    // Create resource
    createResource(eNS_URI);
  }

  public TestFactory getTestFactory() {
    return (TestFactory) getEFactoryInstance();
  }

  public EClass getA() {
    return aEClass;
  }

  public EClass getB() {
    return bEClass;
  }

  public EClass getC() {
    return cEClass;
  }

  public EClass getProgram() {
    return programEClass;
  }

  public EReference getC_B() {
    return (EReference) cEClass.getEStructuralFeatures().get(0);
  }

  public EReference getC_A() {
    return (EReference) cEClass.getEStructuralFeatures().get(1);
  }

  public EReference getProgram_As() {
    return (EReference) programEClass.getEStructuralFeatures().get(0);
  }

  public EReference getProgram_Cs() {
    return (EReference) programEClass.getEStructuralFeatures().get(1);
  }
}
