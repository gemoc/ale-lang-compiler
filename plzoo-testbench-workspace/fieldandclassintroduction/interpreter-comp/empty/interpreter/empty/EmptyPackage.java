package empty.interpreter.empty;

import empty.interpreter.empty.impl.EmptyPackageImpl;
import java.lang.String;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

public interface EmptyPackage extends EPackage {
	String eNAME = "empty";

	String eNS_URI = "http://empty.empty.empty/";

	String eNS_PREFIX = "empty";

	EmptyPackage eINSTANCE = EmptyPackageImpl.init();

	int EXISTING = 0;

	int EXISTING_FEATURE_COUNT = 0;

	int EXISTING_OPERATION_COUNT = 0;

	EClass getExisting();

	EmptyFactory getEmptyFactory();

	interface Literals {
		EClass EXISTING = eINSTANCE.getExisting();
	}
}
