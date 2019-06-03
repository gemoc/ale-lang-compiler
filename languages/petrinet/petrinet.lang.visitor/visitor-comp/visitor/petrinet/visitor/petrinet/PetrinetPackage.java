package visitor.petrinet.visitor.petrinet;

import java.lang.String;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import visitor.petrinet.visitor.petrinet.impl.PetrinetPackageImpl;

public interface PetrinetPackage extends EPackage {
	String eNAME = "petrinet";

	String eNS_URI = "http://petrinet.petrinet.petrinet/";

	String eNS_PREFIX = "petrinet";

	PetrinetPackage eINSTANCE = PetrinetPackageImpl.init();

	int PETRINET = 0;

	int PETRINET__NODES = 0;

	int PETRINET__ARCS = 1;

	int PETRINET_FEATURE_COUNT = 2;

	int PETRINET_OPERATION_COUNT = 0;

	int NODE = 1;

	int NODE__NAME = 0;

	int NODE__INCOMMING = 1;

	int NODE__OUTGOING = 2;

	int NODE_FEATURE_COUNT = 3;

	int NODE_OPERATION_COUNT = 0;

	int ARC = 2;

	int ARC__TARGET = 0;

	int ARC__SOURCE = 1;

	int ARC_FEATURE_COUNT = 2;

	int ARC_OPERATION_COUNT = 0;

	int TRANSITION = 3;

	int TRANSITION__NAME = NODE__NAME;

	int TRANSITION__INCOMMING = NODE__INCOMMING;

	int TRANSITION__OUTGOING = NODE__OUTGOING;

	int TRANSITION_FEATURE_COUNT = NODE_FEATURE_COUNT + 0;

	int TRANSITION_OPERATION_COUNT = NODE_OPERATION_COUNT + 0;

	int PLACE = 4;

	int PLACE__NAME = NODE__NAME;

	int PLACE__INCOMMING = NODE__INCOMMING;

	int PLACE__OUTGOING = NODE__OUTGOING;

	int PLACE__TOKEN_NB = 3;

	int PLACE_FEATURE_COUNT = NODE_FEATURE_COUNT + 1;

	int PLACE_OPERATION_COUNT = NODE_OPERATION_COUNT + 0;

	EClass getPetrinet();

	EReference getPetrinet_Nodes();

	EReference getPetrinet_Arcs();

	EClass getNode();

	EAttribute getNode_Name();

	EReference getNode_Incomming();

	EReference getNode_Outgoing();

	EClass getArc();

	EReference getArc_Target();

	EReference getArc_Source();

	EClass getTransition();

	EClass getPlace();

	EAttribute getPlace_TokenNb();

	PetrinetFactory getPetrinetFactory();

	interface Literals {
		EClass PETRINET = eINSTANCE.getPetrinet();

		EReference PETRINET__NODES = eINSTANCE.getPetrinet_Nodes();

		EReference PETRINET__ARCS = eINSTANCE.getPetrinet_Arcs();

		EClass NODE = eINSTANCE.getNode();

		EAttribute NODE__NAME = eINSTANCE.getNode_Name();

		EReference NODE__INCOMMING = eINSTANCE.getNode_Incomming();

		EReference NODE__OUTGOING = eINSTANCE.getNode_Outgoing();

		EClass ARC = eINSTANCE.getArc();

		EReference ARC__TARGET = eINSTANCE.getArc_Target();

		EReference ARC__SOURCE = eINSTANCE.getArc_Source();

		EClass TRANSITION = eINSTANCE.getTransition();

		EClass PLACE = eINSTANCE.getPlace();

		EAttribute PLACE__TOKEN_NB = eINSTANCE.getPlace_TokenNb();
	}
}
