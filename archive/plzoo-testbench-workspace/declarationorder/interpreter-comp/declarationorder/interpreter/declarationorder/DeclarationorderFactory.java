package declarationorder.interpreter.declarationorder;

import declarationorder.interpreter.declarationorder.impl.DeclarationorderFactoryImpl;
import org.eclipse.emf.ecore.EFactory;

public interface DeclarationorderFactory extends EFactory {
	DeclarationorderFactory eINSTANCE = DeclarationorderFactoryImpl.init();

	Child createChild();

	S createS();

	DeclarationorderPackage getDeclarationorderPackage();
}
