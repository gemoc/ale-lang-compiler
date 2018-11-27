package boa.interpreter.boa;

import com.oracle.truffle.api.nodes.NodeInterface;
import org.eclipse.emf.ecore.EObject;

public interface Expr extends EObject, NodeInterface, TopLevelCmd {
}
