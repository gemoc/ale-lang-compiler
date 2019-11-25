package functioncall.visitor.functioncall;

import functioncall.visitor.functioncall.impl.FunctioncallFactoryImpl;
import org.eclipse.emf.ecore.EFactory;

public interface FunctioncallFactory extends EFactory {
	FunctioncallFactory eINSTANCE = FunctioncallFactoryImpl.init();

	ConceptA createConceptA();

	ConceptB createConceptB();

	ConceptC createConceptC();

	FunctioncallPackage getFunctioncallPackage();
}
