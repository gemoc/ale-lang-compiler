package empty.interpreter.empty;

import empty.interpreter.empty.impl.EmptyFactoryImpl;
import org.eclipse.emf.ecore.EFactory;

public interface EmptyFactory extends EFactory {
	EmptyFactory eINSTANCE = EmptyFactoryImpl.init();

	Existing2 createExisting();

	EmptyPackage getEmptyPackage();
}
