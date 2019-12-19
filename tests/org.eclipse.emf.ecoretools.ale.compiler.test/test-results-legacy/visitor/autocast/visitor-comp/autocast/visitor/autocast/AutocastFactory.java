package autocast.visitor.autocast;

import autocast.visitor.autocast.impl.AutocastFactoryImpl;
import org.eclipse.emf.ecore.EFactory;

public interface AutocastFactory extends EFactory {
	AutocastFactory eINSTANCE = AutocastFactoryImpl.init();

	ConceptA createConceptA();

	ConceptB createConceptB();

	ConceptC createConceptC();

	AutocastPackage getAutocastPackage();
}
