
package emapvselistentry;

import org.eclipse.emf.ecore.EFactory;

public interface EmapvselistentryFactory extends EFactory {

	EmapvselistentryFactory eINSTANCE = emapvselistentry.impl.EmapvselistentryFactoryImpl.init();

	NewEClass1 createNewEClass1();

	EmapvselistentryPackage getEmapvselistentryPackage();

} // EmapvselistentryFactory
