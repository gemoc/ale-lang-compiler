package testmaprelations.visitor.testmaprelations;

import java.util.Map.Entry;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import visitor.AcceptInterface;

public interface CA2 extends EObject, AcceptInterface {
	EList<Entry<CA2, CB2>> getMapca0tocb0mapentry();
}
