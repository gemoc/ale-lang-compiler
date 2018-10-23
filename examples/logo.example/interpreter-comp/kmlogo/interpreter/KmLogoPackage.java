package kmlogo.interpreter;

import java.lang.String;
import kmlogo.interpreter.impl.KmLogoPackageImpl;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

public interface KmLogoPackage extends EPackage {
  KmLogoPackage eINSTANCE = KmLogoPackageImpl.init();

  String eNS_URI = "http://kmLogo.kmLogo.kmLogo/";

  String eNAME = "kmLogo";

  String eNS_PREFIX = "kmLogo";

  int KMLOGO_FEATURE_COUNT = 0;

  int INSTRUCTION = 0;

  int PRIMITIVE = 1;

  int BACK = 2;

  int FORWARD = 3;

  int LEFT = 4;

  int RIGHT = 5;

  int PEN_DOWN = 6;

  int PEN_UP = 7;

  int CLEAR = 8;

  int EXPRESSION = 9;

  int BINARY_EXP = 10;

  int UNARY_EXPRESSION = 11;

  int CONSTANT = 12;

  int PROC_CALL = 13;

  int PROC_DECLARATION = 14;

  int BLOCK = 15;

  int IF = 16;

  int CONTROL_STRUCTURE = 17;

  int REPEAT = 18;

  int WHILE = 19;

  int PARAMETER = 20;

  int PARAMETER_CALL = 21;

  int PLUS = 22;

  int MINUS = 23;

  int MULT = 24;

  int DIV = 25;

  int EQUALS = 26;

  int GREATER = 27;

  int LOWER = 28;

  int COS = 29;

  int SIN = 30;

  int TAN = 31;

  int LOGO_PROGRAM = 32;

  int TURTLE = 33;

  int POINT = 34;

  int SEGMENT = 35;

  int CALL_STACK = 36;

  int STACK_FRAME = 37;

  int VARIABLE = 38;

  int BACK__STEPS = 0;

  int FORWARD__STEPS = 0;

  int LEFT__ANGLE = 0;

  int RIGHT__ANGLE = 0;

  int BINARY_EXP__LHS = 0;

  int BINARY_EXP__RHS = 1;

  int UNARY_EXPRESSION__EXPRESSION = 0;

  int CONSTANT__VALUE = 0;

  int PROC_CALL__ACTUAL_ARGS = 0;

  int PROC_CALL__DECLARATION = 1;

  int PROC_DECLARATION__ARGS = 0;

  int PROC_DECLARATION__PROC_CALL = 1;

  int PROC_DECLARATION__INSTRUCTIONS = 2;

  int PROC_DECLARATION__NAME = 3;

  int BLOCK__INSTRUCTIONS = 0;

  int IF__THEN_PART = 0;

  int IF__ELSE_PART = 1;

  int CONTROL_STRUCTURE__CONDITION = 0;

  int REPEAT__BLOCK = 0;

  int WHILE__BLOCK = 0;

  int PARAMETER__NAME = 0;

  int PARAMETER_CALL__PARAMETER = 0;

  int LOGO_PROGRAM__INSTRUCTIONS = 0;

  int TURTLE__POSITION = 0;

  int TURTLE__DRAWINGS = 1;

  int TURTLE__CALL_STACK = 2;

  int TURTLE__HEADING = 3;

  int TURTLE__PEN_UP = 4;

  int POINT__X = 0;

  int POINT__Y = 1;

  int SEGMENT__BEGIN = 0;

  int SEGMENT__END = 1;

  int CALL_STACK__FRAMES = 0;

  int STACK_FRAME__VARIABLES = 0;

  int VARIABLE__NAME = 0;

  int VARIABLE__VALUE = 1;

  EClass getInstruction();

  EClass getPrimitive();

  EClass getBack();

  EClass getForward();

  EClass getLeft();

  EClass getRight();

  EClass getPenDown();

  EClass getPenUp();

  EClass getClear();

  EClass getExpression();

  EClass getBinaryExp();

  EClass getUnaryExpression();

  EClass getConstant();

  EClass getProcCall();

  EClass getProcDeclaration();

  EClass getBlock();

  EClass getIf();

  EClass getControlStructure();

  EClass getRepeat();

  EClass getWhile();

  EClass getParameter();

  EClass getParameterCall();

  EClass getPlus();

  EClass getMinus();

  EClass getMult();

  EClass getDiv();

  EClass getEquals();

  EClass getGreater();

  EClass getLower();

  EClass getCos();

  EClass getSin();

  EClass getTan();

  EClass getLogoProgram();

  EClass getTurtle();

  EClass getPoint();

  EClass getSegment();

  EClass getCallStack();

  EClass getStackFrame();

  EClass getVariable();

  EReference getBack_Steps();

  EReference getForward_Steps();

  EReference getLeft_Angle();

  EReference getRight_Angle();

  EReference getBinary_exp_Lhs();

  EReference getBinary_exp_Rhs();

  EReference getUnary_expression_Expression();

  EReference getProc_call_Actual_args();

  EReference getProc_call_Declaration();

  EReference getProc_declaration_Args();

  EReference getProc_declaration_Proc_call();

  EReference getProc_declaration_Instructions();

  EReference getBlock_Instructions();

  EReference getIf_Then_part();

  EReference getIf_Else_part();

  EReference getControl_structure_Condition();

  EReference getRepeat_Block();

  EReference getWhile_Block();

  EReference getParameter_call_Parameter();

  EReference getLogo_program_Instructions();

  EReference getTurtle_Position();

  EReference getTurtle_Drawings();

  EReference getTurtle_Call_stack();

  EReference getSegment_Begin();

  EReference getSegment_End();

  EReference getCall_stack_Frames();

  EReference getStack_frame_Variables();

  EAttribute getConstant_Value();

  EAttribute getProc_declaration_Name();

  EAttribute getParameter_Name();

  EAttribute getTurtle_Heading();

  EAttribute getTurtle_Pen_up();

  EAttribute getPoint_X();

  EAttribute getPoint_Y();

  EAttribute getVariable_Name();

  EAttribute getVariable_Value();

  interface Literals {
    EClass INSTRUCTION = eINSTANCE.getInstruction();

    EClass PRIMITIVE = eINSTANCE.getPrimitive();

    EClass BACK = eINSTANCE.getBack();

    EClass FORWARD = eINSTANCE.getForward();

    EClass LEFT = eINSTANCE.getLeft();

    EClass RIGHT = eINSTANCE.getRight();

    EClass PENDOWN = eINSTANCE.getPenDown();

    EClass PENUP = eINSTANCE.getPenUp();

    EClass CLEAR = eINSTANCE.getClear();

    EClass EXPRESSION = eINSTANCE.getExpression();

    EClass BINARYEXP = eINSTANCE.getBinaryExp();

    EClass UNARYEXPRESSION = eINSTANCE.getUnaryExpression();

    EClass CONSTANT = eINSTANCE.getConstant();

    EClass PROCCALL = eINSTANCE.getProcCall();

    EClass PROCDECLARATION = eINSTANCE.getProcDeclaration();

    EClass BLOCK = eINSTANCE.getBlock();

    EClass IF = eINSTANCE.getIf();

    EClass CONTROLSTRUCTURE = eINSTANCE.getControlStructure();

    EClass REPEAT = eINSTANCE.getRepeat();

    EClass WHILE = eINSTANCE.getWhile();

    EClass PARAMETER = eINSTANCE.getParameter();

    EClass PARAMETERCALL = eINSTANCE.getParameterCall();

    EClass PLUS = eINSTANCE.getPlus();

    EClass MINUS = eINSTANCE.getMinus();

    EClass MULT = eINSTANCE.getMult();

    EClass DIV = eINSTANCE.getDiv();

    EClass EQUALS = eINSTANCE.getEquals();

    EClass GREATER = eINSTANCE.getGreater();

    EClass LOWER = eINSTANCE.getLower();

    EClass COS = eINSTANCE.getCos();

    EClass SIN = eINSTANCE.getSin();

    EClass TAN = eINSTANCE.getTan();

    EClass LOGOPROGRAM = eINSTANCE.getLogoProgram();

    EClass TURTLE = eINSTANCE.getTurtle();

    EClass POINT = eINSTANCE.getPoint();

    EClass SEGMENT = eINSTANCE.getSegment();

    EClass CALLSTACK = eINSTANCE.getCallStack();

    EClass STACKFRAME = eINSTANCE.getStackFrame();

    EClass VARIABLE = eINSTANCE.getVariable();

    EReference BACK__STEPS = eINSTANCE.getBack_Steps();

    EReference FORWARD__STEPS = eINSTANCE.getForward_Steps();

    EReference LEFT__ANGLE = eINSTANCE.getLeft_Angle();

    EReference RIGHT__ANGLE = eINSTANCE.getRight_Angle();

    EReference BINARY_EXP__LHS = eINSTANCE.getBinary_exp_Lhs();

    EReference BINARY_EXP__RHS = eINSTANCE.getBinary_exp_Rhs();

    EReference UNARY_EXPRESSION__EXPRESSION = eINSTANCE.getUnary_expression_Expression();

    EReference PROC_CALL__ACTUAL_ARGS = eINSTANCE.getProc_call_Actual_args();

    EReference PROC_CALL__DECLARATION = eINSTANCE.getProc_call_Declaration();

    EReference PROC_DECLARATION__ARGS = eINSTANCE.getProc_declaration_Args();

    EReference PROC_DECLARATION__PROC_CALL = eINSTANCE.getProc_declaration_Proc_call();

    EReference PROC_DECLARATION__INSTRUCTIONS = eINSTANCE.getProc_declaration_Instructions();

    EReference BLOCK__INSTRUCTIONS = eINSTANCE.getBlock_Instructions();

    EReference IF__THEN_PART = eINSTANCE.getIf_Then_part();

    EReference IF__ELSE_PART = eINSTANCE.getIf_Else_part();

    EReference CONTROL_STRUCTURE__CONDITION = eINSTANCE.getControl_structure_Condition();

    EReference REPEAT__BLOCK = eINSTANCE.getRepeat_Block();

    EReference WHILE__BLOCK = eINSTANCE.getWhile_Block();

    EReference PARAMETER_CALL__PARAMETER = eINSTANCE.getParameter_call_Parameter();

    EReference LOGO_PROGRAM__INSTRUCTIONS = eINSTANCE.getLogo_program_Instructions();

    EReference TURTLE__POSITION = eINSTANCE.getTurtle_Position();

    EReference TURTLE__DRAWINGS = eINSTANCE.getTurtle_Drawings();

    EReference TURTLE__CALL_STACK = eINSTANCE.getTurtle_Call_stack();

    EReference SEGMENT__BEGIN = eINSTANCE.getSegment_Begin();

    EReference SEGMENT__END = eINSTANCE.getSegment_End();

    EReference CALL_STACK__FRAMES = eINSTANCE.getCall_stack_Frames();

    EReference STACK_FRAME__VARIABLES = eINSTANCE.getStack_frame_Variables();

    EAttribute CONSTANT__VALUE = eINSTANCE.getConstant_Value();

    EAttribute PROC_DECLARATION__NAME = eINSTANCE.getProc_declaration_Name();

    EAttribute PARAMETER__NAME = eINSTANCE.getParameter_Name();

    EAttribute TURTLE__HEADING = eINSTANCE.getTurtle_Heading();

    EAttribute TURTLE__PEN_UP = eINSTANCE.getTurtle_Pen_up();

    EAttribute POINT__X = eINSTANCE.getPoint_X();

    EAttribute POINT__Y = eINSTANCE.getPoint_Y();

    EAttribute VARIABLE__NAME = eINSTANCE.getVariable_Name();

    EAttribute VARIABLE__VALUE = eINSTANCE.getVariable_Value();
  }
}
