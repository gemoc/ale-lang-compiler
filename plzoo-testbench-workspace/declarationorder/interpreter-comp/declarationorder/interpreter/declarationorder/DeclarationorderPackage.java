package declarationorder.interpreter.declarationorder;

import declarationorder.interpreter.declarationorder.impl.DeclarationorderPackageImpl;
import java.lang.String;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

public interface DeclarationorderPackage extends EPackage {
	String eNAME = "declarationorder";

	String eNS_URI = "http://declarationorder.declarationorder.declarationorder/";

	String eNS_PREFIX = "declarationorder";

	DeclarationorderPackage eINSTANCE = DeclarationorderPackageImpl.init();

	int S = 0;

	int S_FEATURE_COUNT = 0;

	int S_OPERATION_COUNT = 0;

	int CHILD = 1;

	int CHILD_FEATURE_COUNT = S_FEATURE_COUNT + 0;

	int CHILD_OPERATION_COUNT = S_OPERATION_COUNT + 0;

	EClass getChild();

	EClass getS();

	DeclarationorderFactory getDeclarationorderFactory();

	interface Literals {
		EClass S = eINSTANCE.getS();

		EClass CHILD = eINSTANCE.getChild();
	}
}
