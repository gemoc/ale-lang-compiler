package factorydeclorder.visitor.factorydeclorder;

import factorydeclorder.visitor.factorydeclorder.impl.FactorydeclorderFactoryImpl;
import org.eclipse.emf.ecore.EFactory;

public interface FactorydeclorderFactory extends EFactory {
	FactorydeclorderFactory eINSTANCE = FactorydeclorderFactoryImpl.init();

	C createC();

	A createA();

	B createB();

	D createD();

	FactorydeclorderPackage getFactorydeclorderPackage();
}
