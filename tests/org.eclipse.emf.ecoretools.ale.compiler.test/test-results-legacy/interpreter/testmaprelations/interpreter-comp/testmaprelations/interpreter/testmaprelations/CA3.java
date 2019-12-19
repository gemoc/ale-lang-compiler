package testmaprelations.interpreter.testmaprelations;

import java.util.Map.Entry;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

public interface CA3 extends EObject {
	EList<Entry<EList<CA3>, EList<CB3>>> getMapca0tocb0mapentry();
}
