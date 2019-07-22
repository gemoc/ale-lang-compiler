package kmLogo.interpreter.kmLogo.impl;

import kmLogo.interpreter.kmLogo.KmLogoFactory;
import kmLogo.interpreter.kmLogo.KmLogoPackage;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;

public class KmLogoPackageImpl extends EPackageImpl implements KmLogoPackage {
	private static boolean isInited = false;

	private EEnum integerEEnum = null;

	private EEnum booleanEEnum = null;

	private EEnum stringEEnum = null;

	private EClass instructionEClass = null;

	private EClass primitiveEClass = null;

	private EClass backEClass = null;

	private EClass forwardEClass = null;

	private EClass leftEClass = null;

	private EClass rightEClass = null;

	private EClass penDownEClass = null;

	private EClass penUpEClass = null;

	private EClass clearEClass = null;

	private EClass expressionEClass = null;

	private EClass binaryExpEClass = null;

	private EClass unaryExpressionEClass = null;

	private EClass constantEClass = null;

	private EClass procCallEClass = null;

	private EClass procDeclarationEClass = null;

	private EClass blockEClass = null;

	private EClass ifEClass = null;

	private EClass controlStructureEClass = null;

	private EClass repeatEClass = null;

	private EClass whileEClass = null;

	private EClass parameterEClass = null;

	private EClass parameterCallEClass = null;

	private EClass plusEClass = null;

	private EClass minusEClass = null;

	private EClass multEClass = null;

	private EClass divEClass = null;

	private EClass equalsEClass = null;

	private EClass greaterEClass = null;

	private EClass lowerEClass = null;

	private EClass cosEClass = null;

	private EClass sinEClass = null;

	private EClass tanEClass = null;

	private EClass logoProgramEClass = null;

	private EClass turtleEClass = null;

	private EClass pointEClass = null;

	private EClass segmentEClass = null;

	private EClass callStackEClass = null;

	private EClass stackFrameEClass = null;

	private EClass variableEClass = null;

	private boolean isCreated = false;

	private boolean isInitialized = false;

	private KmLogoPackageImpl() {
		super(eNS_URI, KmLogoFactory.eINSTANCE);
	}

	public static KmLogoPackage init() {
		if (isInited)
			return (KmLogoPackage) EPackage.Registry.INSTANCE.getEPackage(KmLogoPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredKmLogoPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		KmLogoPackageImpl theKmLogoPackage = registeredKmLogoPackage instanceof KmLogoPackageImpl
				? (KmLogoPackageImpl) registeredKmLogoPackage
				: new KmLogoPackageImpl();

		isInited = true;

		// Create package meta-data objects
		theKmLogoPackage.createPackageContents();

		// Initialize created meta-data
		theKmLogoPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theKmLogoPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(KmLogoPackage.eNS_URI, theKmLogoPackage);
		return theKmLogoPackage;
	}

	public EEnum getInteger() {
		return integerEEnum;
	}

	public EEnum getBoolean() {
		return booleanEEnum;
	}

	public EEnum getString() {
		return stringEEnum;
	}

	public EClass getInstruction() {
		return instructionEClass;
	}

	public EClass getPrimitive() {
		return primitiveEClass;
	}

	public EClass getBack() {
		return backEClass;
	}

	public EReference getBack_Steps() {
		return (EReference) backEClass.getEStructuralFeatures().get(0);
	}

	public EClass getForward() {
		return forwardEClass;
	}

	public EReference getForward_Steps() {
		return (EReference) forwardEClass.getEStructuralFeatures().get(0);
	}

	public EClass getLeft() {
		return leftEClass;
	}

	public EReference getLeft_Angle() {
		return (EReference) leftEClass.getEStructuralFeatures().get(0);
	}

	public EClass getRight() {
		return rightEClass;
	}

	public EReference getRight_Angle() {
		return (EReference) rightEClass.getEStructuralFeatures().get(0);
	}

	public EClass getPenDown() {
		return penDownEClass;
	}

	public EClass getPenUp() {
		return penUpEClass;
	}

	public EClass getClear() {
		return clearEClass;
	}

	public EClass getExpression() {
		return expressionEClass;
	}

	public EClass getBinaryExp() {
		return binaryExpEClass;
	}

	public EReference getBinaryExp_Lhs() {
		return (EReference) binaryExpEClass.getEStructuralFeatures().get(0);
	}

	public EReference getBinaryExp_Rhs() {
		return (EReference) binaryExpEClass.getEStructuralFeatures().get(1);
	}

	public EClass getUnaryExpression() {
		return unaryExpressionEClass;
	}

	public EReference getUnaryExpression_Expression() {
		return (EReference) unaryExpressionEClass.getEStructuralFeatures().get(0);
	}

	public EClass getConstant() {
		return constantEClass;
	}

	public EAttribute getConstant_Value() {
		return (EAttribute) constantEClass.getEStructuralFeatures().get(0);
	}

	public EClass getProcCall() {
		return procCallEClass;
	}

	public EReference getProcCall_ActualArgs() {
		return (EReference) procCallEClass.getEStructuralFeatures().get(0);
	}

	public EReference getProcCall_Declaration() {
		return (EReference) procCallEClass.getEStructuralFeatures().get(1);
	}

	public EClass getProcDeclaration() {
		return procDeclarationEClass;
	}

	public EAttribute getProcDeclaration_Name() {
		return (EAttribute) procDeclarationEClass.getEStructuralFeatures().get(0);
	}

	public EReference getProcDeclaration_Args() {
		return (EReference) procDeclarationEClass.getEStructuralFeatures().get(1);
	}

	public EReference getProcDeclaration_ProcCall() {
		return (EReference) procDeclarationEClass.getEStructuralFeatures().get(2);
	}

	public EReference getProcDeclaration_Instructions() {
		return (EReference) procDeclarationEClass.getEStructuralFeatures().get(3);
	}

	public EClass getBlock() {
		return blockEClass;
	}

	public EReference getBlock_Instructions() {
		return (EReference) blockEClass.getEStructuralFeatures().get(0);
	}

	public EClass getIf() {
		return ifEClass;
	}

	public EReference getIf_ThenPart() {
		return (EReference) ifEClass.getEStructuralFeatures().get(0);
	}

	public EReference getIf_ElsePart() {
		return (EReference) ifEClass.getEStructuralFeatures().get(1);
	}

	public EClass getControlStructure() {
		return controlStructureEClass;
	}

	public EReference getControlStructure_Condition() {
		return (EReference) controlStructureEClass.getEStructuralFeatures().get(0);
	}

	public EClass getRepeat() {
		return repeatEClass;
	}

	public EReference getRepeat_Block() {
		return (EReference) repeatEClass.getEStructuralFeatures().get(0);
	}

	public EClass getWhile() {
		return whileEClass;
	}

	public EReference getWhile_Block() {
		return (EReference) whileEClass.getEStructuralFeatures().get(0);
	}

	public EClass getParameter() {
		return parameterEClass;
	}

	public EAttribute getParameter_Name() {
		return (EAttribute) parameterEClass.getEStructuralFeatures().get(0);
	}

	public EClass getParameterCall() {
		return parameterCallEClass;
	}

	public EReference getParameterCall_Parameter() {
		return (EReference) parameterCallEClass.getEStructuralFeatures().get(0);
	}

	public EClass getPlus() {
		return plusEClass;
	}

	public EClass getMinus() {
		return minusEClass;
	}

	public EClass getMult() {
		return multEClass;
	}

	public EClass getDiv() {
		return divEClass;
	}

	public EClass getEquals() {
		return equalsEClass;
	}

	public EClass getGreater() {
		return greaterEClass;
	}

	public EClass getLower() {
		return lowerEClass;
	}

	public EClass getCos() {
		return cosEClass;
	}

	public EClass getSin() {
		return sinEClass;
	}

	public EClass getTan() {
		return tanEClass;
	}

	public EClass getLogoProgram() {
		return logoProgramEClass;
	}

	public EReference getLogoProgram_Instructions() {
		return (EReference) logoProgramEClass.getEStructuralFeatures().get(0);
	}

	public EClass getTurtle() {
		return turtleEClass;
	}

	public EReference getTurtle_Position() {
		return (EReference) turtleEClass.getEStructuralFeatures().get(0);
	}

	public EAttribute getTurtle_Heading() {
		return (EAttribute) turtleEClass.getEStructuralFeatures().get(1);
	}

	public EAttribute getTurtle_PenUp() {
		return (EAttribute) turtleEClass.getEStructuralFeatures().get(2);
	}

	public EReference getTurtle_Drawings() {
		return (EReference) turtleEClass.getEStructuralFeatures().get(3);
	}

	public EReference getTurtle_CallStack() {
		return (EReference) turtleEClass.getEStructuralFeatures().get(4);
	}

	public EClass getPoint() {
		return pointEClass;
	}

	public EAttribute getPoint_X() {
		return (EAttribute) pointEClass.getEStructuralFeatures().get(0);
	}

	public EAttribute getPoint_Y() {
		return (EAttribute) pointEClass.getEStructuralFeatures().get(1);
	}

	public EClass getSegment() {
		return segmentEClass;
	}

	public EReference getSegment_Begin() {
		return (EReference) segmentEClass.getEStructuralFeatures().get(0);
	}

	public EReference getSegment_End() {
		return (EReference) segmentEClass.getEStructuralFeatures().get(1);
	}

	public EClass getCallStack() {
		return callStackEClass;
	}

	public EReference getCallStack_Frames() {
		return (EReference) callStackEClass.getEStructuralFeatures().get(0);
	}

	public EClass getStackFrame() {
		return stackFrameEClass;
	}

	public EReference getStackFrame_Variables() {
		return (EReference) stackFrameEClass.getEStructuralFeatures().get(0);
	}

	public EClass getVariable() {
		return variableEClass;
	}

	public EAttribute getVariable_Name() {
		return (EAttribute) variableEClass.getEStructuralFeatures().get(0);
	}

	public EAttribute getVariable_Value() {
		return (EAttribute) variableEClass.getEStructuralFeatures().get(1);
	}

	public KmLogoFactory getKmLogoFactory() {
		return (KmLogoFactory) getEFactoryInstance();
	}

	public void createPackageContents() {
		if (isCreated)
			return;
		isCreated = true;

		// Create classes and their features
		instructionEClass = createEClass(INSTRUCTION);

		primitiveEClass = createEClass(PRIMITIVE);

		backEClass = createEClass(BACK);
		createEReference(backEClass, BACK__STEPS);

		forwardEClass = createEClass(FORWARD);
		createEReference(forwardEClass, FORWARD__STEPS);

		leftEClass = createEClass(LEFT);
		createEReference(leftEClass, LEFT__ANGLE);

		rightEClass = createEClass(RIGHT);
		createEReference(rightEClass, RIGHT__ANGLE);

		penDownEClass = createEClass(PEN_DOWN);

		penUpEClass = createEClass(PEN_UP);

		clearEClass = createEClass(CLEAR);

		expressionEClass = createEClass(EXPRESSION);

		binaryExpEClass = createEClass(BINARY_EXP);
		createEReference(binaryExpEClass, BINARY_EXP__LHS);
		createEReference(binaryExpEClass, BINARY_EXP__RHS);

		unaryExpressionEClass = createEClass(UNARY_EXPRESSION);
		createEReference(unaryExpressionEClass, UNARY_EXPRESSION__EXPRESSION);

		constantEClass = createEClass(CONSTANT);
		createEAttribute(constantEClass, CONSTANT__VALUE);

		procCallEClass = createEClass(PROC_CALL);
		createEReference(procCallEClass, PROC_CALL__ACTUAL_ARGS);
		createEReference(procCallEClass, PROC_CALL__DECLARATION);

		procDeclarationEClass = createEClass(PROC_DECLARATION);
		createEAttribute(procDeclarationEClass, PROC_DECLARATION__NAME);
		createEReference(procDeclarationEClass, PROC_DECLARATION__ARGS);
		createEReference(procDeclarationEClass, PROC_DECLARATION__PROC_CALL);
		createEReference(procDeclarationEClass, PROC_DECLARATION__INSTRUCTIONS);

		blockEClass = createEClass(BLOCK);
		createEReference(blockEClass, BLOCK__INSTRUCTIONS);

		ifEClass = createEClass(IF);
		createEReference(ifEClass, IF__THEN_PART);
		createEReference(ifEClass, IF__ELSE_PART);

		controlStructureEClass = createEClass(CONTROL_STRUCTURE);
		createEReference(controlStructureEClass, CONTROL_STRUCTURE__CONDITION);

		repeatEClass = createEClass(REPEAT);
		createEReference(repeatEClass, REPEAT__BLOCK);

		whileEClass = createEClass(WHILE);
		createEReference(whileEClass, WHILE__BLOCK);

		parameterEClass = createEClass(PARAMETER);
		createEAttribute(parameterEClass, PARAMETER__NAME);

		parameterCallEClass = createEClass(PARAMETER_CALL);
		createEReference(parameterCallEClass, PARAMETER_CALL__PARAMETER);

		plusEClass = createEClass(PLUS);

		minusEClass = createEClass(MINUS);

		multEClass = createEClass(MULT);

		divEClass = createEClass(DIV);

		equalsEClass = createEClass(EQUALS);

		greaterEClass = createEClass(GREATER);

		lowerEClass = createEClass(LOWER);

		cosEClass = createEClass(COS);

		sinEClass = createEClass(SIN);

		tanEClass = createEClass(TAN);

		logoProgramEClass = createEClass(LOGO_PROGRAM);
		createEReference(logoProgramEClass, LOGO_PROGRAM__INSTRUCTIONS);

		turtleEClass = createEClass(TURTLE);
		createEReference(turtleEClass, TURTLE__POSITION);
		createEAttribute(turtleEClass, TURTLE__HEADING);
		createEAttribute(turtleEClass, TURTLE__PEN_UP);
		createEReference(turtleEClass, TURTLE__DRAWINGS);
		createEReference(turtleEClass, TURTLE__CALL_STACK);

		pointEClass = createEClass(POINT);
		createEAttribute(pointEClass, POINT__X);
		createEAttribute(pointEClass, POINT__Y);

		segmentEClass = createEClass(SEGMENT);
		createEReference(segmentEClass, SEGMENT__BEGIN);
		createEReference(segmentEClass, SEGMENT__END);

		callStackEClass = createEClass(CALL_STACK);
		createEReference(callStackEClass, CALL_STACK__FRAMES);

		stackFrameEClass = createEClass(STACK_FRAME);
		createEReference(stackFrameEClass, STACK_FRAME__VARIABLES);

		variableEClass = createEClass(VARIABLE);
		createEAttribute(variableEClass, VARIABLE__NAME);
		createEAttribute(variableEClass, VARIABLE__VALUE);
	}

	public void initializePackageContents() {
		if (isInitialized)
			return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		primitiveEClass.getESuperTypes().add(this.getInstruction());
		backEClass.getESuperTypes().add(this.getPrimitive());
		forwardEClass.getESuperTypes().add(this.getPrimitive());
		leftEClass.getESuperTypes().add(this.getPrimitive());
		rightEClass.getESuperTypes().add(this.getPrimitive());
		penDownEClass.getESuperTypes().add(this.getPrimitive());
		penUpEClass.getESuperTypes().add(this.getPrimitive());
		clearEClass.getESuperTypes().add(this.getPrimitive());
		expressionEClass.getESuperTypes().add(this.getInstruction());
		binaryExpEClass.getESuperTypes().add(this.getExpression());
		unaryExpressionEClass.getESuperTypes().add(this.getExpression());
		constantEClass.getESuperTypes().add(this.getExpression());
		procCallEClass.getESuperTypes().add(this.getExpression());
		procDeclarationEClass.getESuperTypes().add(this.getInstruction());
		blockEClass.getESuperTypes().add(this.getInstruction());
		ifEClass.getESuperTypes().add(this.getControlStructure());
		controlStructureEClass.getESuperTypes().add(this.getInstruction());
		repeatEClass.getESuperTypes().add(this.getControlStructure());
		whileEClass.getESuperTypes().add(this.getControlStructure());
		parameterCallEClass.getESuperTypes().add(this.getExpression());
		plusEClass.getESuperTypes().add(this.getBinaryExp());
		minusEClass.getESuperTypes().add(this.getBinaryExp());
		multEClass.getESuperTypes().add(this.getBinaryExp());
		divEClass.getESuperTypes().add(this.getBinaryExp());
		equalsEClass.getESuperTypes().add(this.getBinaryExp());
		greaterEClass.getESuperTypes().add(this.getBinaryExp());
		lowerEClass.getESuperTypes().add(this.getBinaryExp());
		cosEClass.getESuperTypes().add(this.getUnaryExpression());
		sinEClass.getESuperTypes().add(this.getUnaryExpression());
		tanEClass.getESuperTypes().add(this.getUnaryExpression());

		// Initialize classes, features, and operations; add parameters
		initEClass(instructionEClass, InstructionImpl.class, "Instruction", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(primitiveEClass, PrimitiveImpl.class, "Primitive", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(backEClass, BackImpl.class, "Back", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBack_Steps(), this.getExpression(), null, "steps", null, 1, 1, BackImpl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(forwardEClass, ForwardImpl.class, "Forward", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getForward_Steps(), this.getExpression(), null, "steps", null, 1, 1, ForwardImpl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(leftEClass, LeftImpl.class, "Left", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getLeft_Angle(), this.getExpression(), null, "angle", null, 0, 1, LeftImpl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(rightEClass, RightImpl.class, "Right", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRight_Angle(), this.getExpression(), null, "angle", null, 0, 1, RightImpl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(penDownEClass, PenDownImpl.class, "PenDown", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(penUpEClass, PenUpImpl.class, "PenUp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(clearEClass, ClearImpl.class, "Clear", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(expressionEClass, ExpressionImpl.class, "Expression", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(binaryExpEClass, BinaryExpImpl.class, "BinaryExp", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBinaryExp_Lhs(), this.getExpression(), null, "lhs", null, 1, 1, BinaryExpImpl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBinaryExp_Rhs(), this.getExpression(), null, "rhs", null, 1, 1, BinaryExpImpl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(unaryExpressionEClass, UnaryExpressionImpl.class, "UnaryExpression", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getUnaryExpression_Expression(), this.getExpression(), null, "expression", null, 1, 1, UnaryExpressionImpl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(constantEClass, ConstantImpl.class, "Constant", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getConstant_Value(), ecorePackage.getEDouble(), "value", null, 0, 1, ConstantImpl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(procCallEClass, ProcCallImpl.class, "ProcCall", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getProcCall_ActualArgs(), this.getExpression(), null, "actualArgs", null, 0, -1, ProcCallImpl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getProcCall_Declaration(), this.getProcDeclaration(), this.getProcDeclaration_ProcCall(), "declaration", null, 1, 1, ProcCallImpl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(procDeclarationEClass, ProcDeclarationImpl.class, "ProcDeclaration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getProcDeclaration_Name(), ecorePackage.getEString(), "name", null, 0, 1, ProcDeclarationImpl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getProcDeclaration_Args(), this.getParameter(), null, "args", null, 0, -1, ProcDeclarationImpl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getProcDeclaration_ProcCall(), this.getProcCall(), this.getProcCall_Declaration(), "procCall", null, 0, -1, ProcDeclarationImpl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getProcDeclaration_Instructions(), this.getInstruction(), null, "instructions", null, 0, -1, ProcDeclarationImpl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(blockEClass, BlockImpl.class, "Block", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBlock_Instructions(), this.getInstruction(), null, "instructions", null, 0, -1, BlockImpl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(ifEClass, IfImpl.class, "If", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getIf_ThenPart(), this.getBlock(), null, "thenPart", null, 1, 1, IfImpl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIf_ElsePart(), this.getBlock(), null, "elsePart", null, 0, 1, IfImpl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(controlStructureEClass, ControlStructureImpl.class, "ControlStructure", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getControlStructure_Condition(), this.getExpression(), null, "condition", null, 0, 1, ControlStructureImpl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(repeatEClass, RepeatImpl.class, "Repeat", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRepeat_Block(), this.getBlock(), null, "block", null, 1, 1, RepeatImpl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(whileEClass, WhileImpl.class, "While", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getWhile_Block(), this.getBlock(), null, "block", null, 1, 1, WhileImpl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(parameterEClass, ParameterImpl.class, "Parameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getParameter_Name(), ecorePackage.getEString(), "name", null, 0, 1, ParameterImpl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(parameterCallEClass, ParameterCallImpl.class, "ParameterCall", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getParameterCall_Parameter(), this.getParameter(), null, "parameter", null, 1, 1, ParameterCallImpl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(plusEClass, PlusImpl.class, "Plus", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(minusEClass, MinusImpl.class, "Minus", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(multEClass, MultImpl.class, "Mult", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(divEClass, DivImpl.class, "Div", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(equalsEClass, EqualsImpl.class, "Equals", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(greaterEClass, GreaterImpl.class, "Greater", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(lowerEClass, LowerImpl.class, "Lower", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(cosEClass, CosImpl.class, "Cos", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(sinEClass, SinImpl.class, "Sin", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(tanEClass, TanImpl.class, "Tan", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(logoProgramEClass, LogoProgramImpl.class, "LogoProgram", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getLogoProgram_Instructions(), this.getInstruction(), null, "instructions", null, 0, -1, LogoProgramImpl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(turtleEClass, TurtleImpl.class, "Turtle", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTurtle_Position(), this.getPoint(), null, "position", null, 1, 1, TurtleImpl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTurtle_Heading(), ecorePackage.getEDouble(), "heading", null, 0, 1, TurtleImpl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTurtle_PenUp(), ecorePackage.getEBoolean(), "penUp", null, 0, 1, TurtleImpl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTurtle_Drawings(), this.getSegment(), null, "drawings", null, 0, -1, TurtleImpl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTurtle_CallStack(), this.getCallStack(), null, "callStack", null, 1, 1, TurtleImpl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(pointEClass, PointImpl.class, "Point", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPoint_X(), ecorePackage.getEDouble(), "x", null, 0, 1, PointImpl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPoint_Y(), ecorePackage.getEDouble(), "y", null, 0, 1, PointImpl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(segmentEClass, SegmentImpl.class, "Segment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSegment_Begin(), this.getPoint(), null, "begin", null, 1, 1, SegmentImpl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSegment_End(), this.getPoint(), null, "end", null, 1, 1, SegmentImpl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(callStackEClass, CallStackImpl.class, "CallStack", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCallStack_Frames(), this.getStackFrame(), null, "frames", null, 0, -1, CallStackImpl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(stackFrameEClass, StackFrameImpl.class, "StackFrame", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getStackFrame_Variables(), this.getVariable(), null, "variables", null, 0, -1, StackFrameImpl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(variableEClass, VariableImpl.class, "Variable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getVariable_Name(), ecorePackage.getEString(), "name", null, 1, 1, VariableImpl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVariable_Value(), ecorePackage.getEDouble(), "value", null, 1, 1, VariableImpl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}
}
