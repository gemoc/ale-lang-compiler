package visitor.petrinet.visitor.petrinet.impl;

import java.lang.Deprecated;
import java.lang.IllegalArgumentException;
import java.lang.Override;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import visitor.petrinet.visitor.petrinet.Arc;
import visitor.petrinet.visitor.petrinet.Petrinet;
import visitor.petrinet.visitor.petrinet.PetrinetFactory;
import visitor.petrinet.visitor.petrinet.PetrinetPackage;
import visitor.petrinet.visitor.petrinet.Place;
import visitor.petrinet.visitor.petrinet.Transition;

public class PetrinetFactoryImpl extends EFactoryImpl implements PetrinetFactory {
	public PetrinetFactoryImpl() {
		super();
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

	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case PetrinetPackage.PETRINET :
				return createPetrinet();
			case PetrinetPackage.ARC :
				return createArc();
			case PetrinetPackage.TRANSITION :
				return createTransition();
			case PetrinetPackage.PLACE :
				return createPlace();
			default :
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	public Petrinet createPetrinet() {
		PetrinetImpl petrinet = new PetrinetImpl();
		return petrinet;
	}

	public Arc createArc() {
		ArcImpl arc = new ArcImpl();
		return arc;
	}

	public Transition createTransition() {
		TransitionImpl transition = new TransitionImpl();
		return transition;
	}

	public Place createPlace() {
		PlaceImpl place = new PlaceImpl();
		return place;
	}

	public PetrinetPackage getPetrinetPackage() {
		return (PetrinetPackage) getEPackage();
	}

	@Deprecated
	public static PetrinetPackage getPackage() {
		return PetrinetPackage.eINSTANCE;
	}
}
