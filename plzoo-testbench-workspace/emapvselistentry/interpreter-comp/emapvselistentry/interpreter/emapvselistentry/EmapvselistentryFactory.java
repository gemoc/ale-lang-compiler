package emapvselistentry.interpreter.emapvselistentry;

import emapvselistentry.interpreter.emapvselistentry.impl.EmapvselistentryFactoryImpl;
import org.eclipse.emf.ecore.EFactory;

public interface EmapvselistentryFactory extends EFactory {
	EmapvselistentryFactory eINSTANCE = EmapvselistentryFactoryImpl.init();

	NewEClass1 createNewEClass1();

	EmapvselistentryPackage getEmapvselistentryPackage();
}
