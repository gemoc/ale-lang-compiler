package truffle.petrinet.interpreter.petrinet;

import org.eclipse.emf.ecore.EFactory;
import truffle.petrinet.interpreter.petrinet.impl.PetrinetFactoryImpl;

public interface PetrinetFactory extends EFactory {
	PetrinetFactory eINSTANCE = PetrinetFactoryImpl.init();

	Petrinet createPetrinet();

	Arc createArc();

	Transition createTransition();

	Place createPlace();

	PetrinetPackage getPetrinetPackage();
}
