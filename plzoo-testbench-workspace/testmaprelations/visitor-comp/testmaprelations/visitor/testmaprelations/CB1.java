package testmaprelations.visitor.testmaprelations;

import java.util.Map.Entry;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import visitor.AcceptInterface;

public interface CB1 extends EObject, AcceptInterface {
	Entry<EList<CA1>, EList<CB1>> getMapca0tocb0mapentry();

	void setMapca0tocb0mapentry(Entry<EList<CA1>, EList<CB1>> value);
}
