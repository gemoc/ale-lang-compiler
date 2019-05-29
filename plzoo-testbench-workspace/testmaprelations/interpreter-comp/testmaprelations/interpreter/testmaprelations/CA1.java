package testmaprelations.interpreter.testmaprelations;

import java.util.Map.Entry;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

public interface CA1 extends EObject {
	Entry<EList<CA1>, EList<CB1>> getMapca0tocb0mapentry();

	void setMapca0tocb0mapentry(Entry<EList<CA1>, EList<CB1>> value);
}
