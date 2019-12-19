package miniJava.interpreter.miniJava;

import java.util.Map.Entry;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

public interface Method extends EObject, Member {
	boolean isIsabstract();

	void setIsabstract(boolean value);

	boolean isIsstatic();

	void setIsstatic(boolean value);

	EList<Parameter> getParams();

	Block getBody();

	void setBody(Block value);

	EList<Entry<Clazz, Method>> getCache();

	void evaluateStatement(State state);

	Method findOverride(Clazz c);

	void call(State state);
}
