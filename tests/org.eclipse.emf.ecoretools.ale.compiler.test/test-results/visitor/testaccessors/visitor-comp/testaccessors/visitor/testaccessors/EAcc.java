package testaccessors.visitor.testaccessors;

import java.lang.Boolean;
import java.lang.Integer;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import visitor.AcceptInterface;

public interface EAcc extends EObject, AcceptInterface {
	boolean isB();

	void setB(boolean value);

	int getI();

	void setI(int value);

	EList<Boolean> getBs();

	EList<Integer> getIs();
}
