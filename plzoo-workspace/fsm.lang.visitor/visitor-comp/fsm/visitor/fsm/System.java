package fsm.visitor.fsm;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import visitor.AcceptInterface;

public interface System extends EObject, AcceptInterface {
	EList<FSM> getOwnedFsms();

	EList<Buffer> getOwnedBuffers();
}
