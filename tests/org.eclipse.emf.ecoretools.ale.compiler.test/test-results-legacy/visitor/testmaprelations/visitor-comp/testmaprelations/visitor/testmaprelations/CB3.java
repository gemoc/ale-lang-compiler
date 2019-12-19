package testmaprelations.visitor.testmaprelations;

import java.util.Map.Entry;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import visitor.AcceptInterface;

public interface CB3 extends EObject, AcceptInterface {
	EList<Entry<EList<CA3>, EList<CB3>>> getMapca0tocb0mapentry();
}
