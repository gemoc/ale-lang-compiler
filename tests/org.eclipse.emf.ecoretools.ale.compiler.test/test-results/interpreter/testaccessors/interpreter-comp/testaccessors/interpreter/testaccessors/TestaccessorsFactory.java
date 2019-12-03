package testaccessors.interpreter.testaccessors;

import org.eclipse.emf.ecore.EFactory;
import testaccessors.interpreter.testaccessors.impl.TestaccessorsFactoryImpl;

public interface TestaccessorsFactory extends EFactory {
	TestaccessorsFactory eINSTANCE = TestaccessorsFactoryImpl.init();

	EAcc createEAcc();

	TestaccessorsPackage getTestaccessorsPackage();
}
