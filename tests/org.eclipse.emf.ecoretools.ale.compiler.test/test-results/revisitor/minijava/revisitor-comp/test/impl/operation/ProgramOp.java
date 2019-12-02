package test.impl.operation;

import miniJava.Method;
import miniJava.State;
import org.eclipse.emf.common.util.EList;

public interface ProgramOp {
	void main();

	void initialize(EList args);

	State execute();

	Method findMain();
}
