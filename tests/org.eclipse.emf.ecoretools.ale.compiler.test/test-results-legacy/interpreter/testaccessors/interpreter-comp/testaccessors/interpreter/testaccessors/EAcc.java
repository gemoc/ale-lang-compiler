package testaccessors.interpreter.testaccessors;

import java.lang.Boolean;
import java.lang.Integer;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

public interface EAcc extends EObject {
	boolean isB();

	void setB(boolean value);

	int getI();

	void setI(int value);

	EList<Boolean> getBs();

	EList<Integer> getIs();

	void logacc();
}
