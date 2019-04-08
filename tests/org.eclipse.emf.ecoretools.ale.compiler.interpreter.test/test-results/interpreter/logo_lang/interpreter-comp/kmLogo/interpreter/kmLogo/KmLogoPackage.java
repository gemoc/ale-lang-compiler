package kmLogo.interpreter.kmLogo;

import java.lang.String;
import kmLogo.interpreter.kmLogo.impl.KmLogoPackageImpl;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

public interface KmLogoPackage extends EPackage {
	String eNAME = "kmLogo";

	String eNS_URI = "http://kmLogo.kmLogo.kmLogo/";

	String eNS_PREFIX = "kmLogo";

	KmLogoPackage eINSTANCE = KmLogoPackageImpl.init();

	int INSTRUCTION = 0;

	int INSTRUCTION_FEATURE_COUNT = 0;

	int INSTRUCTION_OPERATION_COUNT = 0;

	int PRIMITIVE = 1;

	int PRIMITIVE_FEATURE_COUNT = INSTRUCTION_FEATURE_COUNT + 0;

	int PRIMITIVE_OPERATION_COUNT = INSTRUCTION_OPERATION_COUNT + 0;

	int BACK = 2;

	int BACK__STEPS = PRIMITIVE_FEATURE_COUNT + 0;

	int BACK_FEATURE_COUNT = PRIMITIVE_FEATURE_COUNT + 1;

	int BACK_OPERATION_COUNT = PRIMITIVE_OPERATION_COUNT + 0;

	int FORWARD = 3;

	int FORWARD__STEPS = PRIMITIVE_FEATURE_COUNT + 0;

	int FORWARD_FEATURE_COUNT = PRIMITIVE_FEATURE_COUNT + 1;

	int FORWARD_OPERATION_COUNT = PRIMITIVE_OPERATION_COUNT + 0;

	int LEFT = 4;

	int LEFT__ANGLE = PRIMITIVE_FEATURE_COUNT + 0;

	int LEFT_FEATURE_COUNT = PRIMITIVE_FEATURE_COUNT + 1;

	int LEFT_OPERATION_COUNT = PRIMITIVE_OPERATION_COUNT + 0;

	int RIGHT = 5;

	int RIGHT__ANGLE = PRIMITIVE_FEATURE_COUNT + 0;

	int RIGHT_FEATURE_COUNT = PRIMITIVE_FEATURE_COUNT + 1;

	int RIGHT_OPERATION_COUNT = PRIMITIVE_OPERATION_COUNT + 0;

	int PEN_DOWN = 6;

	int PEN_DOWN_FEATURE_COUNT = PRIMITIVE_FEATURE_COUNT + 0;

	int PEN_DOWN_OPERATION_COUNT = PRIMITIVE_OPERATION_COUNT + 0;

	int PEN_UP = 7;

	int PEN_UP_FEATURE_COUNT = PRIMITIVE_FEATURE_COUNT + 0;

	int PEN_UP_OPERATION_COUNT = PRIMITIVE_OPERATION_COUNT + 0;

	int CLEAR = 8;

	int CLEAR_FEATURE_COUNT = PRIMITIVE_FEATURE_COUNT + 0;

	int CLEAR_OPERATION_COUNT = PRIMITIVE_OPERATION_COUNT + 0;

	int EXPRESSION = 9;

	int EXPRESSION_FEATURE_COUNT = INSTRUCTION_FEATURE_COUNT + 0;

	int EXPRESSION_OPERATION_COUNT = INSTRUCTION_OPERATION_COUNT + 0;

	int BINARY_EXP = 10;

	int BINARY_EXP__LHS = EXPRESSION_FEATURE_COUNT + 0;

	int BINARY_EXP__RHS = EXPRESSION_FEATURE_COUNT + 1;

	int BINARY_EXP_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

	int BINARY_EXP_OPERATION_COUNT = EXPRESSION_OPERATION_COUNT + 0;

	int UNARY_EXPRESSION = 11;

	int UNARY_EXPRESSION__EXPRESSION = EXPRESSION_FEATURE_COUNT + 0;

	int UNARY_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

	int UNARY_EXPRESSION_OPERATION_COUNT = EXPRESSION_OPERATION_COUNT + 0;

	int CONSTANT = 12;

	int CONSTANT__VALUE = EXPRESSION_FEATURE_COUNT + 0;

	int CONSTANT_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

	int CONSTANT_OPERATION_COUNT = EXPRESSION_OPERATION_COUNT + 0;

	int PROC_CALL = 13;

	int PROC_CALL__ACTUAL_ARGS = EXPRESSION_FEATURE_COUNT + 0;

	int PROC_CALL__DECLARATION = EXPRESSION_FEATURE_COUNT + 1;

	int PROC_CALL_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

	int PROC_CALL_OPERATION_COUNT = EXPRESSION_OPERATION_COUNT + 0;

	int PROC_DECLARATION = 14;

	int PROC_DECLARATION__NAME = INSTRUCTION_FEATURE_COUNT + 0;

	int PROC_DECLARATION__ARGS = INSTRUCTION_FEATURE_COUNT + 1;

	int PROC_DECLARATION__PROC_CALL = INSTRUCTION_FEATURE_COUNT + 2;

	int PROC_DECLARATION__INSTRUCTIONS = INSTRUCTION_FEATURE_COUNT + 3;

	int PROC_DECLARATION_FEATURE_COUNT = INSTRUCTION_FEATURE_COUNT + 4;

	int PROC_DECLARATION_OPERATION_COUNT = INSTRUCTION_OPERATION_COUNT + 0;

	int BLOCK = 15;

	int BLOCK__INSTRUCTIONS = INSTRUCTION_FEATURE_COUNT + 0;

	int BLOCK_FEATURE_COUNT = INSTRUCTION_FEATURE_COUNT + 1;

	int BLOCK_OPERATION_COUNT = INSTRUCTION_OPERATION_COUNT + 0;

	int CONTROL_STRUCTURE = 17;

	int CONTROL_STRUCTURE__CONDITION = INSTRUCTION_FEATURE_COUNT + 0;

	int CONTROL_STRUCTURE_FEATURE_COUNT = INSTRUCTION_FEATURE_COUNT + 1;

	int CONTROL_STRUCTURE_OPERATION_COUNT = INSTRUCTION_OPERATION_COUNT + 0;

	int IF = 16;

	int IF__CONDITION = CONTROL_STRUCTURE__CONDITION;

	int IF__THEN_PART = CONTROL_STRUCTURE_FEATURE_COUNT + 0;

	int IF__ELSE_PART = CONTROL_STRUCTURE_FEATURE_COUNT + 1;

	int IF_FEATURE_COUNT = CONTROL_STRUCTURE_FEATURE_COUNT + 2;

	int IF_OPERATION_COUNT = CONTROL_STRUCTURE_OPERATION_COUNT + 0;

	int REPEAT = 18;

	int REPEAT__CONDITION = CONTROL_STRUCTURE__CONDITION;

	int REPEAT__BLOCK = CONTROL_STRUCTURE_FEATURE_COUNT + 0;

	int REPEAT_FEATURE_COUNT = CONTROL_STRUCTURE_FEATURE_COUNT + 1;

	int REPEAT_OPERATION_COUNT = CONTROL_STRUCTURE_OPERATION_COUNT + 0;

	int WHILE = 19;

	int WHILE__CONDITION = CONTROL_STRUCTURE__CONDITION;

	int WHILE__BLOCK = CONTROL_STRUCTURE_FEATURE_COUNT + 0;

	int WHILE_FEATURE_COUNT = CONTROL_STRUCTURE_FEATURE_COUNT + 1;

	int WHILE_OPERATION_COUNT = CONTROL_STRUCTURE_OPERATION_COUNT + 0;

	int PARAMETER = 20;

	int PARAMETER__NAME = 0;

	int PARAMETER_FEATURE_COUNT = 1;

	int PARAMETER_OPERATION_COUNT = 0;

	int PARAMETER_CALL = 21;

	int PARAMETER_CALL__PARAMETER = EXPRESSION_FEATURE_COUNT + 0;

	int PARAMETER_CALL_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

	int PARAMETER_CALL_OPERATION_COUNT = EXPRESSION_OPERATION_COUNT + 0;

	int PLUS = 22;

	int PLUS__LHS = BINARY_EXP__LHS;

	int PLUS__RHS = BINARY_EXP__RHS;

	int PLUS_FEATURE_COUNT = BINARY_EXP_FEATURE_COUNT + 0;

	int PLUS_OPERATION_COUNT = BINARY_EXP_OPERATION_COUNT + 0;

	int MINUS = 23;

	int MINUS__LHS = BINARY_EXP__LHS;

	int MINUS__RHS = BINARY_EXP__RHS;

	int MINUS_FEATURE_COUNT = BINARY_EXP_FEATURE_COUNT + 0;

	int MINUS_OPERATION_COUNT = BINARY_EXP_OPERATION_COUNT + 0;

	int MULT = 24;

	int MULT__LHS = BINARY_EXP__LHS;

	int MULT__RHS = BINARY_EXP__RHS;

	int MULT_FEATURE_COUNT = BINARY_EXP_FEATURE_COUNT + 0;

	int MULT_OPERATION_COUNT = BINARY_EXP_OPERATION_COUNT + 0;

	int DIV = 25;

	int DIV__LHS = BINARY_EXP__LHS;

	int DIV__RHS = BINARY_EXP__RHS;

	int DIV_FEATURE_COUNT = BINARY_EXP_FEATURE_COUNT + 0;

	int DIV_OPERATION_COUNT = BINARY_EXP_OPERATION_COUNT + 0;

	int EQUALS = 26;

	int EQUALS__LHS = BINARY_EXP__LHS;

	int EQUALS__RHS = BINARY_EXP__RHS;

	int EQUALS_FEATURE_COUNT = BINARY_EXP_FEATURE_COUNT + 0;

	int EQUALS_OPERATION_COUNT = BINARY_EXP_OPERATION_COUNT + 0;

	int GREATER = 27;

	int GREATER__LHS = BINARY_EXP__LHS;

	int GREATER__RHS = BINARY_EXP__RHS;

	int GREATER_FEATURE_COUNT = BINARY_EXP_FEATURE_COUNT + 0;

	int GREATER_OPERATION_COUNT = BINARY_EXP_OPERATION_COUNT + 0;

	int LOWER = 28;

	int LOWER__LHS = BINARY_EXP__LHS;

	int LOWER__RHS = BINARY_EXP__RHS;

	int LOWER_FEATURE_COUNT = BINARY_EXP_FEATURE_COUNT + 0;

	int LOWER_OPERATION_COUNT = BINARY_EXP_OPERATION_COUNT + 0;

	int COS = 29;

	int COS__EXPRESSION = UNARY_EXPRESSION__EXPRESSION;

	int COS_FEATURE_COUNT = UNARY_EXPRESSION_FEATURE_COUNT + 0;

	int COS_OPERATION_COUNT = UNARY_EXPRESSION_OPERATION_COUNT + 0;

	int SIN = 30;

	int SIN__EXPRESSION = UNARY_EXPRESSION__EXPRESSION;

	int SIN_FEATURE_COUNT = UNARY_EXPRESSION_FEATURE_COUNT + 0;

	int SIN_OPERATION_COUNT = UNARY_EXPRESSION_OPERATION_COUNT + 0;

	int TAN = 31;

	int TAN__EXPRESSION = UNARY_EXPRESSION__EXPRESSION;

	int TAN_FEATURE_COUNT = UNARY_EXPRESSION_FEATURE_COUNT + 0;

	int TAN_OPERATION_COUNT = UNARY_EXPRESSION_OPERATION_COUNT + 0;

	int LOGO_PROGRAM = 32;

	int LOGO_PROGRAM__INSTRUCTIONS = 0;

	int LOGO_PROGRAM_FEATURE_COUNT = 1;

	int LOGO_PROGRAM_OPERATION_COUNT = 0;

	int TURTLE = 33;

	int TURTLE__POSITION = 0;

	int TURTLE__HEADING = 1;

	int TURTLE__PEN_UP = 2;

	int TURTLE__DRAWINGS = 3;

	int TURTLE__CALL_STACK = 4;

	int TURTLE_FEATURE_COUNT = 5;

	int TURTLE_OPERATION_COUNT = 0;

	int POINT = 34;

	int POINT__X = 0;

	int POINT__Y = 1;

	int POINT_FEATURE_COUNT = 2;

	int POINT_OPERATION_COUNT = 0;

	int SEGMENT = 35;

	int SEGMENT__BEGIN = 0;

	int SEGMENT__END = 1;

	int SEGMENT_FEATURE_COUNT = 2;

	int SEGMENT_OPERATION_COUNT = 0;

	int CALL_STACK = 36;

	int CALL_STACK__FRAMES = 0;

	int CALL_STACK_FEATURE_COUNT = 1;

	int CALL_STACK_OPERATION_COUNT = 0;

	int STACK_FRAME = 37;

	int STACK_FRAME__VARIABLES = 0;

	int STACK_FRAME_FEATURE_COUNT = 1;

	int STACK_FRAME_OPERATION_COUNT = 0;

	int VARIABLE = 38;

	int VARIABLE__NAME = 0;

	int VARIABLE__VALUE = 1;

	int VARIABLE_FEATURE_COUNT = 2;

	int VARIABLE_OPERATION_COUNT = 0;

	int INTEGER = 39;

	int BOOLEAN = 40;

	int STRING = 41;

	EClass getInstruction();

	EClass getPrimitive();

	EClass getBack();

	EReference getBack_Steps();

	EClass getForward();

	EReference getForward_Steps();

	EClass getLeft();

	EReference getLeft_Angle();

	EClass getRight();

	EReference getRight_Angle();

	EClass getPenDown();

	EClass getPenUp();

	EClass getClear();

	EClass getExpression();

	EClass getBinaryExp();

	EReference getBinaryExp_Lhs();

	EReference getBinaryExp_Rhs();

	EClass getUnaryExpression();

	EReference getUnaryExpression_Expression();

	EClass getConstant();

	EAttribute getConstant_Value();

	EClass getProcCall();

	EReference getProcCall_ActualArgs();

	EReference getProcCall_Declaration();

	EClass getProcDeclaration();

	EAttribute getProcDeclaration_Name();

	EReference getProcDeclaration_Args();

	EReference getProcDeclaration_ProcCall();

	EReference getProcDeclaration_Instructions();

	EClass getBlock();

	EReference getBlock_Instructions();

	EClass getIf();

	EReference getIf_ThenPart();

	EReference getIf_ElsePart();

	EClass getControlStructure();

	EReference getControlStructure_Condition();

	EClass getRepeat();

	EReference getRepeat_Block();

	EClass getWhile();

	EReference getWhile_Block();

	EClass getParameter();

	EAttribute getParameter_Name();

	EClass getParameterCall();

	EReference getParameterCall_Parameter();

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

	EReference getLogoProgram_Instructions();

	EClass getTurtle();

	EReference getTurtle_Position();

	EAttribute getTurtle_Heading();

	EAttribute getTurtle_PenUp();

	EReference getTurtle_Drawings();

	EReference getTurtle_CallStack();

	EClass getPoint();

	EAttribute getPoint_X();

	EAttribute getPoint_Y();

	EClass getSegment();

	EReference getSegment_Begin();

	EReference getSegment_End();

	EClass getCallStack();

	EReference getCallStack_Frames();

	EClass getStackFrame();

	EReference getStackFrame_Variables();

	EClass getVariable();

	EAttribute getVariable_Name();

	EAttribute getVariable_Value();

	EDataType getInteger();

	EDataType getBoolean();

	EDataType getString();

	KmLogoFactory getKmLogoFactory();

	interface Literals {
		EClass INSTRUCTION = eINSTANCE.getInstruction();

		EClass PRIMITIVE = eINSTANCE.getPrimitive();

		EClass BACK = eINSTANCE.getBack();

		EReference BACK__STEPS = eINSTANCE.getBack_Steps();

		EClass FORWARD = eINSTANCE.getForward();

		EReference FORWARD__STEPS = eINSTANCE.getForward_Steps();

		EClass LEFT = eINSTANCE.getLeft();

		EReference LEFT__ANGLE = eINSTANCE.getLeft_Angle();

		EClass RIGHT = eINSTANCE.getRight();

		EReference RIGHT__ANGLE = eINSTANCE.getRight_Angle();

		EClass PEN_DOWN = eINSTANCE.getPenDown();

		EClass PEN_UP = eINSTANCE.getPenUp();

		EClass CLEAR = eINSTANCE.getClear();

		EClass EXPRESSION = eINSTANCE.getExpression();

		EClass BINARY_EXP = eINSTANCE.getBinaryExp();

		EReference BINARY_EXP__LHS = eINSTANCE.getBinaryExp_Lhs();

		EReference BINARY_EXP__RHS = eINSTANCE.getBinaryExp_Rhs();

		EClass UNARY_EXPRESSION = eINSTANCE.getUnaryExpression();

		EReference UNARY_EXPRESSION__EXPRESSION = eINSTANCE.getUnaryExpression_Expression();

		EClass CONSTANT = eINSTANCE.getConstant();

		EAttribute CONSTANT__VALUE = eINSTANCE.getConstant_Value();

		EClass PROC_CALL = eINSTANCE.getProcCall();

		EReference PROC_CALL__ACTUAL_ARGS = eINSTANCE.getProcCall_ActualArgs();

		EReference PROC_CALL__DECLARATION = eINSTANCE.getProcCall_Declaration();

		EClass PROC_DECLARATION = eINSTANCE.getProcDeclaration();

		EAttribute PROC_DECLARATION__NAME = eINSTANCE.getProcDeclaration_Name();

		EReference PROC_DECLARATION__ARGS = eINSTANCE.getProcDeclaration_Args();

		EReference PROC_DECLARATION__PROC_CALL = eINSTANCE.getProcDeclaration_ProcCall();

		EReference PROC_DECLARATION__INSTRUCTIONS = eINSTANCE.getProcDeclaration_Instructions();

		EClass BLOCK = eINSTANCE.getBlock();

		EReference BLOCK__INSTRUCTIONS = eINSTANCE.getBlock_Instructions();

		EClass IF = eINSTANCE.getIf();

		EReference IF__THEN_PART = eINSTANCE.getIf_ThenPart();

		EReference IF__ELSE_PART = eINSTANCE.getIf_ElsePart();

		EClass CONTROL_STRUCTURE = eINSTANCE.getControlStructure();

		EReference CONTROL_STRUCTURE__CONDITION = eINSTANCE.getControlStructure_Condition();

		EClass REPEAT = eINSTANCE.getRepeat();

		EReference REPEAT__BLOCK = eINSTANCE.getRepeat_Block();

		EClass WHILE = eINSTANCE.getWhile();

		EReference WHILE__BLOCK = eINSTANCE.getWhile_Block();

		EClass PARAMETER = eINSTANCE.getParameter();

		EAttribute PARAMETER__NAME = eINSTANCE.getParameter_Name();

		EClass PARAMETER_CALL = eINSTANCE.getParameterCall();

		EReference PARAMETER_CALL__PARAMETER = eINSTANCE.getParameterCall_Parameter();

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

		EClass LOGO_PROGRAM = eINSTANCE.getLogoProgram();

		EReference LOGO_PROGRAM__INSTRUCTIONS = eINSTANCE.getLogoProgram_Instructions();

		EClass TURTLE = eINSTANCE.getTurtle();

		EReference TURTLE__POSITION = eINSTANCE.getTurtle_Position();

		EAttribute TURTLE__HEADING = eINSTANCE.getTurtle_Heading();

		EAttribute TURTLE__PEN_UP = eINSTANCE.getTurtle_PenUp();

		EReference TURTLE__DRAWINGS = eINSTANCE.getTurtle_Drawings();

		EReference TURTLE__CALL_STACK = eINSTANCE.getTurtle_CallStack();

		EClass POINT = eINSTANCE.getPoint();

		EAttribute POINT__X = eINSTANCE.getPoint_X();

		EAttribute POINT__Y = eINSTANCE.getPoint_Y();

		EClass SEGMENT = eINSTANCE.getSegment();

		EReference SEGMENT__BEGIN = eINSTANCE.getSegment_Begin();

		EReference SEGMENT__END = eINSTANCE.getSegment_End();

		EClass CALL_STACK = eINSTANCE.getCallStack();

		EReference CALL_STACK__FRAMES = eINSTANCE.getCallStack_Frames();

		EClass STACK_FRAME = eINSTANCE.getStackFrame();

		EReference STACK_FRAME__VARIABLES = eINSTANCE.getStackFrame_Variables();

		EClass VARIABLE = eINSTANCE.getVariable();

		EAttribute VARIABLE__NAME = eINSTANCE.getVariable_Name();

		EAttribute VARIABLE__VALUE = eINSTANCE.getVariable_Value();

		EDataType INTEGER = eINSTANCE.getInteger();

		EDataType BOOLEAN = eINSTANCE.getBoolean();

		EDataType STRING = eINSTANCE.getString();
	}
}
