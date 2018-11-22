package truffle.petrinet.interpreter.petrinet.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import truffle.petrinet.interpreter.petrinet.PetrinetFactory;
import truffle.petrinet.interpreter.petrinet.PetrinetPackage;

public class PetrinetPackageImpl extends EPackageImpl implements PetrinetPackage {
  private static boolean isInited = false;

  private boolean isCreated = false;

  private boolean isInitialized = false;

  private EClass petrinetEClass = null;

  private EClass nodeEClass = null;

  private EClass arcEClass = null;

  private EClass transitionEClass = null;

  private EClass placeEClass = null;

  private PetrinetPackageImpl() {
    super(eNS_URI, PetrinetFactory.eINSTANCE);
  }

  public static PetrinetPackage init() {
    if (isInited)
    	return (PetrinetPackage) EPackage.Registry.INSTANCE.getEPackage(PetrinetPackage.eNS_URI);

    // Obtain or create and register package
    Object registeredPetrinetPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
    truffle.petrinet.interpreter.petrinet.impl.PetrinetPackageImpl thePetrinetPackage;
    if(registeredPetrinetPackage instanceof truffle.petrinet.interpreter.petrinet.impl.PetrinetPackageImpl) {
    	 thePetrinetPackage =  (truffle.petrinet.interpreter.petrinet.impl.PetrinetPackageImpl) registeredPetrinetPackage;
    } else {
     	thePetrinetPackage = new truffle.petrinet.interpreter.petrinet.impl.PetrinetPackageImpl();
    }
    isInited = true;
    				
    // Create package meta-data objects
    thePetrinetPackage.createPackageContents();

    // Initialize created meta-data
    thePetrinetPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    thePetrinetPackage.freeze();

    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(PetrinetPackage.eNS_URI, thePetrinetPackage);
    return thePetrinetPackage;
  }

  public void createPackageContents() {
    if(isCreated)
    	return;
    isCreated = true;

    petrinetEClass = createEClass(PETRINET);
    createEReference(petrinetEClass, PETRINET__NODES);
    createEReference(petrinetEClass, PETRINET__ARCS);
    nodeEClass = createEClass(NODE);
    createEAttribute(nodeEClass, NODE__NAME);						
    createEReference(nodeEClass, NODE__INCOMMING);
    createEReference(nodeEClass, NODE__OUTGOING);
    arcEClass = createEClass(ARC);
    createEReference(arcEClass, ARC__TARGET);
    createEReference(arcEClass, ARC__SOURCE);
    transitionEClass = createEClass(TRANSITION);
    placeEClass = createEClass(PLACE);
    createEAttribute(placeEClass, PLACE__TOKEN_NB);						
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
    transitionEClass.getESuperTypes().add(this.getNode());
    placeEClass.getESuperTypes().add(this.getNode());

    // Initialize classes, features, and operations; add parameters
    initEClass(petrinetEClass, truffle.petrinet.interpreter.petrinet.Petrinet.class, "Petrinet", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getPetrinet_Nodes(), this.getNode(),  
    	null, "nodes", null, 0, -1,  truffle.petrinet.interpreter.petrinet.Petrinet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getPetrinet_Arcs(), this.getArc(),  
    	null, "arcs", null, 0, -1,  truffle.petrinet.interpreter.petrinet.Petrinet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEClass(nodeEClass, truffle.petrinet.interpreter.petrinet.Node.class, "Node", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getNode_Name(), ecorePackage.getEString(), "name", null, 1, 1,  truffle.petrinet.interpreter.petrinet.Node.class, !IS_TRANSIENT,!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);				
    initEReference(getNode_Incomming(), this.getArc(),  
    	this.getArc_Target(), "incomming", null, 0, -1,  truffle.petrinet.interpreter.petrinet.Node.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getNode_Outgoing(), this.getArc(),  
    	this.getArc_Source(), "outgoing", null, 0, -1,  truffle.petrinet.interpreter.petrinet.Node.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEClass(arcEClass, truffle.petrinet.interpreter.petrinet.Arc.class, "Arc", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getArc_Target(), this.getNode(),  
    	this.getNode_Incomming(), "target", null, 1, 1,  truffle.petrinet.interpreter.petrinet.Arc.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getArc_Source(), this.getNode(),  
    	this.getNode_Outgoing(), "source", null, 1, 1,  truffle.petrinet.interpreter.petrinet.Arc.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEClass(transitionEClass, truffle.petrinet.interpreter.petrinet.Transition.class, "Transition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEClass(placeEClass, truffle.petrinet.interpreter.petrinet.Place.class, "Place", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getPlace_Token_nb(), ecorePackage.getEInt(), "tokenNb", null, 1, 1,  truffle.petrinet.interpreter.petrinet.Place.class, !IS_TRANSIENT,!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);				
    // Create resource
    createResource(eNS_URI);
  }

  public PetrinetFactory getPetrinetFactory() {
    return (PetrinetFactory) getEFactoryInstance();
  }

  public EClass getPetrinet() {
    return petrinetEClass;
  }

  public EClass getNode() {
    return nodeEClass;
  }

  public EClass getArc() {
    return arcEClass;
  }

  public EClass getTransition() {
    return transitionEClass;
  }

  public EClass getPlace() {
    return placeEClass;
  }

  public EReference getPetrinet_Nodes() {
    return (EReference) petrinetEClass.getEStructuralFeatures().get(0);
  }

  public EReference getPetrinet_Arcs() {
    return (EReference) petrinetEClass.getEStructuralFeatures().get(1);
  }

  public EAttribute getNode_Name() {
    return (EAttribute) nodeEClass.getEStructuralFeatures().get(0);
  }

  public EReference getNode_Incomming() {
    return (EReference) nodeEClass.getEStructuralFeatures().get(1);
  }

  public EReference getNode_Outgoing() {
    return (EReference) nodeEClass.getEStructuralFeatures().get(2);
  }

  public EReference getArc_Target() {
    return (EReference) arcEClass.getEStructuralFeatures().get(0);
  }

  public EReference getArc_Source() {
    return (EReference) arcEClass.getEStructuralFeatures().get(1);
  }

  public EAttribute getPlace_Token_nb() {
    return (EAttribute) placeEClass.getEStructuralFeatures().get(0);
  }
}
