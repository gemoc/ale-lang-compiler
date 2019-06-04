package fsm.interpreter.fsm;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

public interface System extends EObject {
	EList<FSM> getOwnedFsms();

	EList<Buffer> getOwnedBuffers();

	void intialize();

	void main(int limit);
}
