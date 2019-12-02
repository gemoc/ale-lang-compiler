package test.impl.operation;

import java.lang.String;
import miniJava.Call;
import miniJava.Context;
import miniJava.Frame;
import miniJava.ObjectInstance;

public interface StateOp {
	Frame findCurrentFrame();

	Context findCurrentContext();

	void pushNewContext();

	void popCurrentContext();

	void println(String str);

	void pushNewFrame(ObjectInstance receiver, Call c, Context newContext);

	void popCurrentFrame();
}
