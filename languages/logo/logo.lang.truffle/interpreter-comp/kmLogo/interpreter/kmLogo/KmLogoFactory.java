package kmLogo.interpreter.kmLogo;

import kmLogo.interpreter.kmLogo.impl.BackImpl;
import kmLogo.interpreter.kmLogo.impl.BlockImpl;
import kmLogo.interpreter.kmLogo.impl.CallStackImpl;
import kmLogo.interpreter.kmLogo.impl.ClearImpl;
import kmLogo.interpreter.kmLogo.impl.ConstantImpl;
import kmLogo.interpreter.kmLogo.impl.ControlStructureImpl;
import kmLogo.interpreter.kmLogo.impl.CosImpl;
import kmLogo.interpreter.kmLogo.impl.DivImpl;
import kmLogo.interpreter.kmLogo.impl.EqualsImpl;
import kmLogo.interpreter.kmLogo.impl.ForwardImpl;
import kmLogo.interpreter.kmLogo.impl.GreaterImpl;
import kmLogo.interpreter.kmLogo.impl.IfImpl;
import kmLogo.interpreter.kmLogo.impl.KmLogoFactoryImpl;
import kmLogo.interpreter.kmLogo.impl.LeftImpl;
import kmLogo.interpreter.kmLogo.impl.LogoProgramImpl;
import kmLogo.interpreter.kmLogo.impl.LowerImpl;
import kmLogo.interpreter.kmLogo.impl.MinusImpl;
import kmLogo.interpreter.kmLogo.impl.MultImpl;
import kmLogo.interpreter.kmLogo.impl.ParameterCallImpl;
import kmLogo.interpreter.kmLogo.impl.ParameterImpl;
import kmLogo.interpreter.kmLogo.impl.PenDownImpl;
import kmLogo.interpreter.kmLogo.impl.PenUpImpl;
import kmLogo.interpreter.kmLogo.impl.PlusImpl;
import kmLogo.interpreter.kmLogo.impl.PointImpl;
import kmLogo.interpreter.kmLogo.impl.ProcCallImpl;
import kmLogo.interpreter.kmLogo.impl.ProcDeclarationImpl;
import kmLogo.interpreter.kmLogo.impl.RepeatImpl;
import kmLogo.interpreter.kmLogo.impl.RightImpl;
import kmLogo.interpreter.kmLogo.impl.SegmentImpl;
import kmLogo.interpreter.kmLogo.impl.SinImpl;
import kmLogo.interpreter.kmLogo.impl.StackFrameImpl;
import kmLogo.interpreter.kmLogo.impl.TanImpl;
import kmLogo.interpreter.kmLogo.impl.TurtleImpl;
import kmLogo.interpreter.kmLogo.impl.VariableImpl;
import kmLogo.interpreter.kmLogo.impl.WhileImpl;
import org.eclipse.emf.ecore.EFactory;

public interface KmLogoFactory extends EFactory {
	KmLogoFactory eINSTANCE = KmLogoFactoryImpl.init();

	BackImpl createBack();

	ForwardImpl createForward();

	LeftImpl createLeft();

	RightImpl createRight();

	PenDownImpl createPenDown();

	PenUpImpl createPenUp();

	ClearImpl createClear();

	ConstantImpl createConstant();

	ProcCallImpl createProcCall();

	ProcDeclarationImpl createProcDeclaration();

	BlockImpl createBlock();

	IfImpl createIf();

	ControlStructureImpl createControlStructure();

	RepeatImpl createRepeat();

	WhileImpl createWhile();

	ParameterImpl createParameter();

	ParameterCallImpl createParameterCall();

	PlusImpl createPlus();

	MinusImpl createMinus();

	MultImpl createMult();

	DivImpl createDiv();

	EqualsImpl createEquals();

	GreaterImpl createGreater();

	LowerImpl createLower();

	CosImpl createCos();

	SinImpl createSin();

	TanImpl createTan();

	LogoProgramImpl createLogoProgram();

	TurtleImpl createTurtle();

	PointImpl createPoint();

	SegmentImpl createSegment();

	CallStackImpl createCallStack();

	StackFrameImpl createStackFrame();

	VariableImpl createVariable();

	KmLogoPackage getKmLogoPackage();
}
