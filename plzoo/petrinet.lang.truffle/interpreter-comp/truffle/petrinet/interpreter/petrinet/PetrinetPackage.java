package truffle.petrinet.interpreter.petrinet;

import java.lang.String;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import truffle.petrinet.interpreter.petrinet.impl.PetrinetPackageImpl;

public interface PetrinetPackage extends EPackage {
  PetrinetPackage eINSTANCE = PetrinetPackageImpl.init();

  String eNS_URI = "http://petrinet.petrinet.petrinet/";

  String eNAME = "petrinet";

  String eNS_PREFIX = "petrinet";

  int PETRINET = 0;

  int NODE = 1;

  int ARC = 2;

  int TRANSITION = 3;

  int PLACE = 4;

  int PETRINET__NODES = 0;

  int PETRINET__ARCS = 1;

  int NODE__NAME = 0;

  int NODE__INCOMMING = 1;

  int NODE__OUTGOING = 2;

  int ARC__TARGET = 0;

  int ARC__SOURCE = 1;

  int PLACE__TOKEN_NB = 3;

  EClass getPetrinet();

  EClass getNode();

  EClass getArc();

  EClass getTransition();

  EClass getPlace();

  EReference getPetrinet_Nodes();

  EReference getPetrinet_Arcs();

  EReference getNode_Incomming();

  EReference getNode_Outgoing();

  EReference getArc_Target();

  EReference getArc_Source();

  EAttribute getNode_Name();

  EAttribute getPlace_Token_nb();

  PetrinetFactory getPetrinetFactory();

  interface Literals {
    EClass PETRINET = eINSTANCE.getPetrinet();

    EClass NODE = eINSTANCE.getNode();

    EClass ARC = eINSTANCE.getArc();

    EClass TRANSITION = eINSTANCE.getTransition();

    EClass PLACE = eINSTANCE.getPlace();

    EReference PETRINET__NODES = eINSTANCE.getPetrinet_Nodes();

    EReference PETRINET__ARCS = eINSTANCE.getPetrinet_Arcs();

    EReference NODE__INCOMMING = eINSTANCE.getNode_Incomming();

    EReference NODE__OUTGOING = eINSTANCE.getNode_Outgoing();

    EReference ARC__TARGET = eINSTANCE.getArc_Target();

    EReference ARC__SOURCE = eINSTANCE.getArc_Source();

    EAttribute NODE__NAME = eINSTANCE.getNode_Name();

    EAttribute PLACE__TOKEN_NB = eINSTANCE.getPlace_Token_nb();
  }
}
