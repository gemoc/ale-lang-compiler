package visitor.operation.fsm;

import java.lang.String;

public interface BufferOperation {
	void initialize();

	boolean bisEmpty();

	void enqueue(String v);

	String dequeue();
}
