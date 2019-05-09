package testmaprelations.visitor.testmaprelations;

import java.util.Map.Entry;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import visitor.AcceptInterface;

public interface CB5 extends EObject, AcceptInterface {
	Entry<EList<CA5>, EList<CB5>> getMapca0tocb0mapentry();

	void setMapca0tocb0mapentry(Entry<EList<CA5>, EList<CB5>> value);
}
