package kmLogo.visitor.kmLogo;

import java.lang.String;
import org.eclipse.emf.ecore.EObject;
import visitor.AcceptInterface;

public interface Parameter extends EObject, AcceptInterface {
	String getName();

	void setName(String value);
}
