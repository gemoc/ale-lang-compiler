package kmLogo.interpreter.kmLogo.impl;

import com.oracle.truffle.api.CompilerDirectives.TruffleBoundary;
import com.oracle.truffle.api.nodes.NodeInfo;
import java.lang.Override;
import kmLogo.interpreter.kmLogo.KmLogoPackage;
import kmLogo.interpreter.kmLogo.Primitive;
import org.eclipse.emf.ecore.EClass;

@NodeInfo(
		description = "Primitive"
)
public abstract class PrimitiveImpl extends InstructionImpl implements Primitive {
	protected PrimitiveImpl() {
		super();
	}

	@Override
	@TruffleBoundary
	protected EClass eStaticClass() {
		return KmLogoPackage.Literals.PRIMITIVE;
	}
}
