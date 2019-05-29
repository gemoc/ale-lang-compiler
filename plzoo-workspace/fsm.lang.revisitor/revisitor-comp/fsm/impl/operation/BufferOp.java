package fsm.impl.operation;

import java.lang.String;

public interface BufferOp {
	void initialize();

	boolean bisEmpty();

	void enqueue(String v);

	String dequeue();
}
