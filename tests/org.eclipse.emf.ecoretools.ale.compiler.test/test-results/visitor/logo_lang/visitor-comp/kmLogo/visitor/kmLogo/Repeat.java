package kmLogo.visitor.kmLogo;

import org.eclipse.emf.ecore.EObject;
import visitor.AcceptInterface;

public interface Repeat extends EObject, AcceptInterface, ControlStructure {
	Block getBlock();

	void setBlock(Block value);
}
