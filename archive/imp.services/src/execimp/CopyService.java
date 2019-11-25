package execimp;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;

public class CopyService {
	public static <T extends EObject> T emfcopy(T t) {
		return EcoreUtil.copy(t);
	}
}
