package minijava_exec.impl.operation;

import miniJava.Clazz;
import miniJava.Method;
import miniJava.State;

public interface MethodOp extends MemberOp {
	void evaluateStatement(State state);

	Method findOverride(Clazz c);

	void call(State state);
}
