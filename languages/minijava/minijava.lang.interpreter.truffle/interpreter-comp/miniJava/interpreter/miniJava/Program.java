package miniJava.interpreter.miniJava;

import com.oracle.truffle.api.nodes.NodeInterface;
import java.lang.String;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

public interface Program extends EObject, NodeInterface {
	String getName();

	void setName(String value);

	EList<Import> getImports();

	EList<TypeDeclaration> getClasses();

	State getState();

	void setState(State value);

	void main();

	void initialize(EList args);

	State execute();

	Method findMain();
}
