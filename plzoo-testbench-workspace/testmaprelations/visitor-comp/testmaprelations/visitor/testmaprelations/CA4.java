package testmaprelations.visitor.testmaprelations;

import java.util.Map.Entry;
import org.eclipse.emf.ecore.EObject;
import visitor.AcceptInterface;

public interface CA4 extends EObject, AcceptInterface {
	Entry<CA4, CB4> getMapca0tocb0mapentry();

	void setMapca0tocb0mapentry(Entry<CA4, CB4> value);
}
