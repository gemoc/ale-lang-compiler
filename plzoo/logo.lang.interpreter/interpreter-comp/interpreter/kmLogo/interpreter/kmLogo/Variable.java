package interpreter.kmLogo.interpreter.kmLogo;

import java.lang.String;
import org.eclipse.emf.ecore.EObject;

public interface Variable extends EObject {
	String getName();

	void setName(String value);

	double getValue();

	void setValue(double value);
}
