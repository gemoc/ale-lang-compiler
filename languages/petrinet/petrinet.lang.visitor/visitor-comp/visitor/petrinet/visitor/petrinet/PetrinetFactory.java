package visitor.petrinet.visitor.petrinet;

import org.eclipse.emf.ecore.EFactory;
import visitor.petrinet.visitor.petrinet.impl.PetrinetFactoryImpl;

public interface PetrinetFactory extends EFactory {
	PetrinetFactory eINSTANCE = PetrinetFactoryImpl.init();

	Petrinet createPetrinet();

	Arc createArc();

	Transition createTransition();

	Place createPlace();

	PetrinetPackage getPetrinetPackage();
}
