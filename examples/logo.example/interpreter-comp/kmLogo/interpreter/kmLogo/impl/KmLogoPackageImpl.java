package kmLogo.interpreter.kmLogo.impl;

import kmLogo.interpreter.kmLogo.KmLogoFactory;
import kmLogo.interpreter.kmLogo.KmLogoPackage;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;

public class KmLogoPackageImpl extends EPackageImpl implements KmLogoPackage {
  private static boolean isInited = false;

  private static boolean isCreated = false;

  private static boolean isInitialized = false;

  private EClass instructionEClass;

  private EClass primitiveEClass;

  private EClass backEClass;

  private EClass forwardEClass;

  private EClass leftEClass;

  private EClass rightEClass;

  private EClass penDownEClass;

  private EClass penUpEClass;

  private EClass clearEClass;

  private EClass expressionEClass;

  private EClass binaryExpEClass;

  private EClass unaryExpressionEClass;

  private EClass constantEClass;

  private EClass procCallEClass;

  private EClass procDeclarationEClass;

  private EClass blockEClass;

  private EClass ifEClass;

  private EClass controlStructureEClass;

  private EClass repeatEClass;

  private EClass whileEClass;

  private EClass parameterEClass;

  private EClass parameterCallEClass;

  private EClass plusEClass;

  private EClass minusEClass;

  private EClass multEClass;

  private EClass divEClass;

  private EClass equalsEClass;

  private EClass greaterEClass;

  private EClass lowerEClass;

  private EClass cosEClass;

  private EClass sinEClass;

  private EClass tanEClass;

  private EClass logoProgramEClass;

  private EClass turtleEClass;

  private EClass pointEClass;

  private EClass segmentEClass;

  private EClass callStackEClass;

  private EClass stackFrameEClass;

  private EClass variableEClass;

  private KmLogoPackageImpl() {
    super(eNS_URI, KmLogoFactory.eINSTANCE);}

  public static KmLogoPackage init() {
    if (isInited)
    	return (KmLogoPackage) EPackage.Registry.INSTANCE.getEPackage(KmLogoPackage.eNS_URI);

    // Obtain or create and register package
    Object registeredKmLogoPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
    kmLogo.interpreter.kmLogo.impl.KmLogoPackageImpl theKmLogoPackage;
    if(registeredKmLogoPackage instanceof kmLogo.interpreter.kmLogo.impl.KmLogoPackageImpl) {
    	 theKmLogoPackage =  (kmLogo.interpreter.kmLogo.impl.KmLogoPackageImpl) registeredKmLogoPackage;
    } else {
     	theKmLogoPackage = new kmLogo.interpreter.kmLogo.impl.KmLogoPackageImpl();
    }
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

  public void createPackageContents() {
    if(isCreated) return;
    isCreated = true;

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
    createEAttribute(turtleEClass, TURTLE__HEADING);
    createEAttribute(turtleEClass, TURTLE__PEN_UP);
    createEReference(turtleEClass, TURTLE__POSITION);
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
    //
    // Initialize package
    setName(eNAME);
    setNsPrefix(eNS_PREFIX);
    setNsURI(eNS_URI);
    //
    // Create type parameters
    //
    // Set bounds for type parameters
    //
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
    //
    // Initialize classes, features, and operations; add parameters
    initEClass(backEClass, kmLogo.interpreter.kmLogo.Back.class, "Back", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getBack_Steps(), this.getExpression(), null, "steps", null, 1, 1,  kmLogo.interpreter.kmLogo.Back.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEClass(forwardEClass, kmLogo.interpreter.kmLogo.Forward.class, "Forward", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getForward_Steps(), this.getExpression(), null, "steps", null, 1, 1,  kmLogo.interpreter.kmLogo.Forward.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEClass(leftEClass, kmLogo.interpreter.kmLogo.Left.class, "Left", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getLeft_Angle(), this.getExpression(), null, "angle", null, 0, 1,  kmLogo.interpreter.kmLogo.Left.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEClass(rightEClass, kmLogo.interpreter.kmLogo.Right.class, "Right", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getRight_Angle(), this.getExpression(), null, "angle", null, 0, 1,  kmLogo.interpreter.kmLogo.Right.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEClass(penDownEClass, kmLogo.interpreter.kmLogo.PenDown.class, "PenDown", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEClass(penUpEClass, kmLogo.interpreter.kmLogo.PenUp.class, "PenUp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEClass(clearEClass, kmLogo.interpreter.kmLogo.Clear.class, "Clear", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEClass(constantEClass, kmLogo.interpreter.kmLogo.Constant.class, "Constant", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getConstant_Value(), ecorePackage.getEDouble(), "value", null, 0, 1,  kmLogo.interpreter.kmLogo.Constant.class, !IS_TRANSIENT,!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);				
    initEClass(procCallEClass, kmLogo.interpreter.kmLogo.ProcCall.class, "ProcCall", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getProc_call_Actual_args(), this.getExpression(), null, "actualArgs", null, 0, -1,  kmLogo.interpreter.kmLogo.ProcCall.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getProc_call_Declaration(), this.getProcDeclaration(), null, "declaration", null, 1, 1,  kmLogo.interpreter.kmLogo.ProcCall.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEClass(procDeclarationEClass, kmLogo.interpreter.kmLogo.ProcDeclaration.class, "ProcDeclaration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getProc_declaration_Name(), ecorePackage.getEString(), "name", null, 0, 1,  kmLogo.interpreter.kmLogo.ProcDeclaration.class, !IS_TRANSIENT,!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);				
    initEReference(getProc_declaration_Args(), this.getParameter(), null, "args", null, 0, -1,  kmLogo.interpreter.kmLogo.ProcDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getProc_declaration_Proc_call(), this.getProcCall(), null, "procCall", null, 0, -1,  kmLogo.interpreter.kmLogo.ProcDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getProc_declaration_Instructions(), this.getInstruction(), null, "instructions", null, 0, -1,  kmLogo.interpreter.kmLogo.ProcDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEClass(blockEClass, kmLogo.interpreter.kmLogo.Block.class, "Block", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getBlock_Instructions(), this.getInstruction(), null, "instructions", null, 0, -1,  kmLogo.interpreter.kmLogo.Block.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEClass(ifEClass, kmLogo.interpreter.kmLogo.If.class, "If", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getIf_Then_part(), this.getBlock(), null, "thenPart", null, 1, 1,  kmLogo.interpreter.kmLogo.If.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getIf_Else_part(), this.getBlock(), null, "elsePart", null, 0, 1,  kmLogo.interpreter.kmLogo.If.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEClass(controlStructureEClass, kmLogo.interpreter.kmLogo.ControlStructure.class, "ControlStructure", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getControl_structure_Condition(), this.getExpression(), null, "condition", null, 0, 1,  kmLogo.interpreter.kmLogo.ControlStructure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEClass(repeatEClass, kmLogo.interpreter.kmLogo.Repeat.class, "Repeat", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getRepeat_Block(), this.getBlock(), null, "block", null, 1, 1,  kmLogo.interpreter.kmLogo.Repeat.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEClass(whileEClass, kmLogo.interpreter.kmLogo.While.class, "While", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getWhile_Block(), this.getBlock(), null, "block", null, 1, 1,  kmLogo.interpreter.kmLogo.While.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEClass(parameterEClass, kmLogo.interpreter.kmLogo.Parameter.class, "Parameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getParameter_Name(), ecorePackage.getEString(), "name", null, 0, 1,  kmLogo.interpreter.kmLogo.Parameter.class, !IS_TRANSIENT,!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);				
    initEClass(parameterCallEClass, kmLogo.interpreter.kmLogo.ParameterCall.class, "ParameterCall", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getParameter_call_Parameter(), this.getParameter(), null, "parameter", null, 1, 1,  kmLogo.interpreter.kmLogo.ParameterCall.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEClass(plusEClass, kmLogo.interpreter.kmLogo.Plus.class, "Plus", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEClass(minusEClass, kmLogo.interpreter.kmLogo.Minus.class, "Minus", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEClass(multEClass, kmLogo.interpreter.kmLogo.Mult.class, "Mult", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEClass(divEClass, kmLogo.interpreter.kmLogo.Div.class, "Div", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEClass(equalsEClass, kmLogo.interpreter.kmLogo.Equals.class, "Equals", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEClass(greaterEClass, kmLogo.interpreter.kmLogo.Greater.class, "Greater", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEClass(lowerEClass, kmLogo.interpreter.kmLogo.Lower.class, "Lower", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEClass(cosEClass, kmLogo.interpreter.kmLogo.Cos.class, "Cos", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEClass(sinEClass, kmLogo.interpreter.kmLogo.Sin.class, "Sin", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEClass(tanEClass, kmLogo.interpreter.kmLogo.Tan.class, "Tan", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEClass(logoProgramEClass, kmLogo.interpreter.kmLogo.LogoProgram.class, "LogoProgram", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getLogo_program_Instructions(), this.getInstruction(), null, "instructions", null, 0, -1,  kmLogo.interpreter.kmLogo.LogoProgram.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEClass(turtleEClass, kmLogo.interpreter.kmLogo.Turtle.class, "Turtle", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getTurtle_Heading(), ecorePackage.getEDouble(), "heading", null, 0, 1,  kmLogo.interpreter.kmLogo.Turtle.class, !IS_TRANSIENT,!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);				
    initEAttribute(getTurtle_Pen_up(), ecorePackage.getEBoolean(), "penUp", null, 0, 1,  kmLogo.interpreter.kmLogo.Turtle.class, !IS_TRANSIENT,!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);				
    initEReference(getTurtle_Position(), this.getPoint(), null, "position", null, 1, 1,  kmLogo.interpreter.kmLogo.Turtle.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTurtle_Drawings(), this.getSegment(), null, "drawings", null, 0, -1,  kmLogo.interpreter.kmLogo.Turtle.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTurtle_Call_stack(), this.getCallStack(), null, "callStack", null, 1, 1,  kmLogo.interpreter.kmLogo.Turtle.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEClass(pointEClass, kmLogo.interpreter.kmLogo.Point.class, "Point", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getPoint_X(), ecorePackage.getEDouble(), "x", null, 0, 1,  kmLogo.interpreter.kmLogo.Point.class, !IS_TRANSIENT,!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);				
    initEAttribute(getPoint_Y(), ecorePackage.getEDouble(), "y", null, 0, 1,  kmLogo.interpreter.kmLogo.Point.class, !IS_TRANSIENT,!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);				
    initEClass(segmentEClass, kmLogo.interpreter.kmLogo.Segment.class, "Segment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getSegment_Begin(), this.getPoint(), null, "begin", null, 1, 1,  kmLogo.interpreter.kmLogo.Segment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSegment_End(), this.getPoint(), null, "end", null, 1, 1,  kmLogo.interpreter.kmLogo.Segment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEClass(callStackEClass, kmLogo.interpreter.kmLogo.CallStack.class, "CallStack", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getCall_stack_Frames(), this.getStackFrame(), null, "frames", null, 0, -1,  kmLogo.interpreter.kmLogo.CallStack.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEClass(stackFrameEClass, kmLogo.interpreter.kmLogo.StackFrame.class, "StackFrame", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getStack_frame_Variables(), this.getVariable(), null, "variables", null, 0, -1,  kmLogo.interpreter.kmLogo.StackFrame.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEClass(variableEClass, kmLogo.interpreter.kmLogo.Variable.class, "Variable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getVariable_Name(), ecorePackage.getEString(), "name", null, 1, 1,  kmLogo.interpreter.kmLogo.Variable.class, !IS_TRANSIENT,!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);				
    initEAttribute(getVariable_Value(), ecorePackage.getEDouble(), "value", null, 1, 1,  kmLogo.interpreter.kmLogo.Variable.class, !IS_TRANSIENT,!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);				
    // Create resource
    createResource(eNS_URI);
  }

  public EClass getInstruction() {
    return instructionEClass;}

  public EClass getPrimitive() {
    return primitiveEClass;}

  public EClass getBack() {
    return backEClass;}

  public EClass getForward() {
    return forwardEClass;}

  public EClass getLeft() {
    return leftEClass;}

  public EClass getRight() {
    return rightEClass;}

  public EClass getPenDown() {
    return penDownEClass;}

  public EClass getPenUp() {
    return penUpEClass;}

  public EClass getClear() {
    return clearEClass;}

  public EClass getExpression() {
    return expressionEClass;}

  public EClass getBinaryExp() {
    return binaryExpEClass;}

  public EClass getUnaryExpression() {
    return unaryExpressionEClass;}

  public EClass getConstant() {
    return constantEClass;}

  public EClass getProcCall() {
    return procCallEClass;}

  public EClass getProcDeclaration() {
    return procDeclarationEClass;}

  public EClass getBlock() {
    return blockEClass;}

  public EClass getIf() {
    return ifEClass;}

  public EClass getControlStructure() {
    return controlStructureEClass;}

  public EClass getRepeat() {
    return repeatEClass;}

  public EClass getWhile() {
    return whileEClass;}

  public EClass getParameter() {
    return parameterEClass;}

  public EClass getParameterCall() {
    return parameterCallEClass;}

  public EClass getPlus() {
    return plusEClass;}

  public EClass getMinus() {
    return minusEClass;}

  public EClass getMult() {
    return multEClass;}

  public EClass getDiv() {
    return divEClass;}

  public EClass getEquals() {
    return equalsEClass;}

  public EClass getGreater() {
    return greaterEClass;}

  public EClass getLower() {
    return lowerEClass;}

  public EClass getCos() {
    return cosEClass;}

  public EClass getSin() {
    return sinEClass;}

  public EClass getTan() {
    return tanEClass;}

  public EClass getLogoProgram() {
    return logoProgramEClass;}

  public EClass getTurtle() {
    return turtleEClass;}

  public EClass getPoint() {
    return pointEClass;}

  public EClass getSegment() {
    return segmentEClass;}

  public EClass getCallStack() {
    return callStackEClass;}

  public EClass getStackFrame() {
    return stackFrameEClass;}

  public EClass getVariable() {
    return variableEClass;}

  public EReference getBack_Steps() {
    return (EReference) backEClass.getEStructuralFeatures().get(0);}

  public EReference getForward_Steps() {
    return (EReference) forwardEClass.getEStructuralFeatures().get(0);}

  public EReference getLeft_Angle() {
    return (EReference) leftEClass.getEStructuralFeatures().get(0);}

  public EReference getRight_Angle() {
    return (EReference) rightEClass.getEStructuralFeatures().get(0);}

  public EReference getBinary_exp_Lhs() {
    return (EReference) binaryExpEClass.getEStructuralFeatures().get(0);}

  public EReference getBinary_exp_Rhs() {
    return (EReference) binaryExpEClass.getEStructuralFeatures().get(1);}

  public EReference getUnary_expression_Expression() {
    return (EReference) unaryExpressionEClass.getEStructuralFeatures().get(0);}

  public EAttribute getConstant_Value() {
    return (EAttribute) constantEClass.getEStructuralFeatures().get(0);}

  public EReference getProc_call_Actual_args() {
    return (EReference) procCallEClass.getEStructuralFeatures().get(0);}

  public EReference getProc_call_Declaration() {
    return (EReference) procCallEClass.getEStructuralFeatures().get(1);}

  public EAttribute getProc_declaration_Name() {
    return (EAttribute) procDeclarationEClass.getEStructuralFeatures().get(0);}

  public EReference getProc_declaration_Args() {
    return (EReference) procDeclarationEClass.getEStructuralFeatures().get(1);}

  public EReference getProc_declaration_Proc_call() {
    return (EReference) procDeclarationEClass.getEStructuralFeatures().get(2);}

  public EReference getProc_declaration_Instructions() {
    return (EReference) procDeclarationEClass.getEStructuralFeatures().get(3);}

  public EReference getBlock_Instructions() {
    return (EReference) blockEClass.getEStructuralFeatures().get(0);}

  public EReference getIf_Then_part() {
    return (EReference) ifEClass.getEStructuralFeatures().get(0);}

  public EReference getIf_Else_part() {
    return (EReference) ifEClass.getEStructuralFeatures().get(1);}

  public EReference getControl_structure_Condition() {
    return (EReference) controlStructureEClass.getEStructuralFeatures().get(0);}

  public EReference getRepeat_Block() {
    return (EReference) repeatEClass.getEStructuralFeatures().get(0);}

  public EReference getWhile_Block() {
    return (EReference) whileEClass.getEStructuralFeatures().get(0);}

  public EAttribute getParameter_Name() {
    return (EAttribute) parameterEClass.getEStructuralFeatures().get(0);}

  public EReference getParameter_call_Parameter() {
    return (EReference) parameterCallEClass.getEStructuralFeatures().get(0);}

  public EReference getLogo_program_Instructions() {
    return (EReference) logoProgramEClass.getEStructuralFeatures().get(0);}

  public EAttribute getTurtle_Heading() {
    return (EAttribute) turtleEClass.getEStructuralFeatures().get(0);}

  public EAttribute getTurtle_Pen_up() {
    return (EAttribute) turtleEClass.getEStructuralFeatures().get(1);}

  public EReference getTurtle_Position() {
    return (EReference) turtleEClass.getEStructuralFeatures().get(2);}

  public EReference getTurtle_Drawings() {
    return (EReference) turtleEClass.getEStructuralFeatures().get(3);}

  public EReference getTurtle_Call_stack() {
    return (EReference) turtleEClass.getEStructuralFeatures().get(4);}

  public EAttribute getPoint_X() {
    return (EAttribute) pointEClass.getEStructuralFeatures().get(0);}

  public EAttribute getPoint_Y() {
    return (EAttribute) pointEClass.getEStructuralFeatures().get(1);}

  public EReference getSegment_Begin() {
    return (EReference) segmentEClass.getEStructuralFeatures().get(0);}

  public EReference getSegment_End() {
    return (EReference) segmentEClass.getEStructuralFeatures().get(1);}

  public EReference getCall_stack_Frames() {
    return (EReference) callStackEClass.getEStructuralFeatures().get(0);}

  public EReference getStack_frame_Variables() {
    return (EReference) stackFrameEClass.getEStructuralFeatures().get(0);}

  public EAttribute getVariable_Name() {
    return (EAttribute) variableEClass.getEStructuralFeatures().get(0);}

  public EAttribute getVariable_Value() {
    return (EAttribute) variableEClass.getEStructuralFeatures().get(1);}
}
