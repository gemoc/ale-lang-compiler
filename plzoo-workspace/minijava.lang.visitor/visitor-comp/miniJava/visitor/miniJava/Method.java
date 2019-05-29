package miniJava.visitor.miniJava;

import java.util.Map.Entry;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import visitor.AcceptInterface;

public interface Method extends EObject, AcceptInterface, Member {
	boolean isIsabstract();

	void setIsabstract(boolean value);

	boolean isIsstatic();

	void setIsstatic(boolean value);

	EList<Parameter> getParams();

	Block getBody();

	void setBody(Block value);

	EList<Map.Entry<Clazz, Method>> getCache();
}
