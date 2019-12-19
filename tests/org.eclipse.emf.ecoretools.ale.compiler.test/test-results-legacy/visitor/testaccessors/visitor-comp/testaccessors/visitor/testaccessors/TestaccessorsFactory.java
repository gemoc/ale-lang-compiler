package testaccessors.visitor.testaccessors;

import org.eclipse.emf.ecore.EFactory;
import testaccessors.visitor.testaccessors.impl.TestaccessorsFactoryImpl;

public interface TestaccessorsFactory extends EFactory {
	TestaccessorsFactory eINSTANCE = TestaccessorsFactoryImpl.init();

	EAcc createEAcc();

	TestaccessorsPackage getTestaccessorsPackage();
}
