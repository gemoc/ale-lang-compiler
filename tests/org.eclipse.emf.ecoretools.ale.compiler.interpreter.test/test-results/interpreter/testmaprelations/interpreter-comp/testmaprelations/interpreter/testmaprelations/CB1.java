package testmaprelations.interpreter.testmaprelations;

import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

public interface CB1 extends EObject {
	Map.Entry<EList<CA1>, EList<CB1>> getMapca0tocb0mapentry();

	void setMapca0tocb0mapentry(Map.Entry<EList<CA1>, EList<CB1>> value);
}
