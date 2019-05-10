package interpreter.visitor.operation.boa;

import interpreter.boa.visitor.boa.Ctx;

public interface DefOperation extends TopLevelCmdOperation {
	void nextLine(Ctx ctx);
}
