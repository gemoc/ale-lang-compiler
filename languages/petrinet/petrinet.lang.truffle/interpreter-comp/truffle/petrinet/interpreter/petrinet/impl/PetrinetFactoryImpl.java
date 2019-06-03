package truffle.petrinet.interpreter.petrinet.impl;

import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import java.lang.Deprecated;
import java.lang.IllegalArgumentException;
import java.lang.Override;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import truffle.petrinet.interpreter.petrinet.Arc;
import truffle.petrinet.interpreter.petrinet.Petrinet;
import truffle.petrinet.interpreter.petrinet.PetrinetFactory;
import truffle.petrinet.interpreter.petrinet.PetrinetPackage;
import truffle.petrinet.interpreter.petrinet.Place;
import truffle.petrinet.interpreter.petrinet.Transition;

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
	@TruffleBoundary
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

	@TruffleBoundary
	public Petrinet createPetrinet() {
		PetrinetImpl petrinet = new PetrinetImpl();
		return petrinet;
	}

	@TruffleBoundary
	public Arc createArc() {
		ArcImpl arc = new ArcImpl();
		return arc;
	}

	@TruffleBoundary
	public Transition createTransition() {
		TransitionImpl transition = new TransitionImpl();
		return transition;
	}

	@TruffleBoundary
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
