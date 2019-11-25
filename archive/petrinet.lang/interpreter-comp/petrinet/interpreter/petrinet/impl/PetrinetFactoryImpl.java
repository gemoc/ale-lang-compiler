package petrinet.interpreter.petrinet.impl;

import java.lang.IllegalArgumentException;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import petrinet.interpreter.petrinet.Arc;
import petrinet.interpreter.petrinet.Petrinet;
import petrinet.interpreter.petrinet.PetrinetFactory;
import petrinet.interpreter.petrinet.PetrinetPackage;
import petrinet.interpreter.petrinet.Place;
import petrinet.interpreter.petrinet.Transition;

public class PetrinetFactoryImpl extends EFactoryImpl implements PetrinetFactory {
  private PetrinetFactoryImpl() {
  }

  public static PetrinetFactory init() {
    try {
    	PetrinetFactory thePetrinetFactory = (PetrinetFactory) EPackage.Registry.INSTANCE.getEFactory(PetrinetPackage.eNS_URI);
    	if (thePetrinetFactory != null) {
    		return thePetrinetFactory;
    	}
    } catch (Exception exception) {
    	EcorePlugin.INSTANCE.log(exception);
    }
    return new PetrinetFactoryImpl();
  }

  public EObject create(EClass eClass) {
    switch (eClass.getClassifierID()) {
    case PetrinetPackage.PETRINET:
    	return createPetrinet();
    case PetrinetPackage.ARC:
    	return createArc();
    case PetrinetPackage.TRANSITION:
    	return createTransition();
    case PetrinetPackage.PLACE:
    	return createPlace();
    default:
    	throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  public Petrinet createPetrinet() {
    PetrinetImpl ret = new PetrinetImpl();
    return ret;
  }

  public Arc createArc() {
    ArcImpl ret = new ArcImpl();
    return ret;
  }

  public Transition createTransition() {
    TransitionImpl ret = new TransitionImpl();
    return ret;
  }

  public Place createPlace() {
    PlaceImpl ret = new PlaceImpl();
    return ret;
  }
}
