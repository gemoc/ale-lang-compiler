package visitor.boa.visitor.boa.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import visitor.boa.visitor.boa.BoaFactory;
import visitor.boa.visitor.boa.BoaPackage;

public class BoaPackageImpl extends EPackageImpl implements BoaPackage {
  private static boolean isInited = false;

  private boolean isCreated = false;

  private boolean isInitialized = false;

  private EClass fileEClass = null;

  private EClass topLevelCmdEClass = null;

  private EClass exprEClass = null;

  private EClass defEClass = null;

  private EClass appEClass = null;

  private EClass varEClass = null;

  private EClass thisEClass = null;

  private EClass boolEClass = null;

  private EClass intEClass = null;

  private EClass skipEClass = null;

  private EClass projectEClass = null;

  private EClass bObjectEClass = null;

  private EClass fieldEClass = null;

  private EClass copyEClass = null;

  private EClass withEClass = null;

  private EClass arithOpEClass = null;

  private EClass notEClass = null;

  private EClass cmpOpEClass = null;

  private EClass boolOpEClass = null;

  private EClass ifEClass = null;

  private EClass letEClass = null;

  private EClass funEClass = null;

  private EClass assignEClass = null;

  private EClass arithOpPlusEClass = null;

  private EClass arithOpMinusEClass = null;

  private EClass arithOpTimesEClass = null;

  private EClass arithOpDivideEClass = null;

  private EClass arithOpRemainderEClass = null;

  private EClass boolOpAndEClass = null;

  private EClass boolOpOrEClass = null;

  private EClass seqEClass = null;

  private EClass cmpOpEqualEClass = null;

  private EClass cmpOpUnequalEClass = null;

  private EClass cmpOpLessEClass = null;

  private EClass ctxEClass = null;

  private EClass stringToEvalResMapEClass = null;

  private EClass evalResEClass = null;

  private EClass evalMapResEClass = null;

  private EClass evalFunResEClass = null;

  private EClass evalBoundFunResEClass = null;

  private EClass evalIntResEClass = null;

  private EClass evalBoolResEClass = null;

  private BoaPackageImpl() {
    super(eNS_URI, BoaFactory.eINSTANCE);
  }

  public static BoaPackage init() {
    if (isInited)
    	return (BoaPackage) EPackage.Registry.INSTANCE.getEPackage(BoaPackage.eNS_URI);

    // Obtain or create and register package
    Object registeredBoaPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
    visitor.boa.visitor.boa.impl.BoaPackageImpl theBoaPackage;
    if(registeredBoaPackage instanceof visitor.boa.visitor.boa.impl.BoaPackageImpl) {
    	 theBoaPackage =  (visitor.boa.visitor.boa.impl.BoaPackageImpl) registeredBoaPackage;
    } else {
     	theBoaPackage = new visitor.boa.visitor.boa.impl.BoaPackageImpl();
    }
    isInited = true;
    				
    // Create package meta-data objects
    theBoaPackage.createPackageContents();

    // Initialize created meta-data
    theBoaPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theBoaPackage.freeze();

    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(BoaPackage.eNS_URI, theBoaPackage);
    return theBoaPackage;
  }

  public void createPackageContents() {
    if(isCreated)
    	return;
    isCreated = true;

    fileEClass = createEClass(FILE);
    createEReference(fileEClass, FILE__COMMANDS);
    topLevelCmdEClass = createEClass(TOP_LEVEL_CMD);
    exprEClass = createEClass(EXPR);
    defEClass = createEClass(DEF);
    createEAttribute(defEClass, DEF__NAME);						
    createEReference(defEClass, DEF__EXPR);
    appEClass = createEClass(APP);
    createEReference(appEClass, APP__LHS);
    createEReference(appEClass, APP__RHS);
    varEClass = createEClass(VAR);
    createEAttribute(varEClass, VAR__NAME);						
    thisEClass = createEClass(THIS);
    boolEClass = createEClass(BOOL);
    createEAttribute(boolEClass, BOOL__VALUE);						
    intEClass = createEClass(INT);
    createEAttribute(intEClass, INT__VALUE);						
    skipEClass = createEClass(SKIP);
    projectEClass = createEClass(PROJECT);
    createEReference(projectEClass, PROJECT__EXP);
    createEAttribute(projectEClass, PROJECT__NAME);						
    bObjectEClass = createEClass(BOBJECT);
    createEReference(bObjectEClass, BOBJECT__FIELDS);
    fieldEClass = createEClass(FIELD);
    createEAttribute(fieldEClass, FIELD__NAME);						
    createEReference(fieldEClass, FIELD__VALUE);
    copyEClass = createEClass(COPY);
    createEReference(copyEClass, COPY__COPY);
    withEClass = createEClass(WITH);
    createEReference(withEClass, WITH__LHS);
    createEReference(withEClass, WITH__RHS);
    arithOpEClass = createEClass(ARITH_OP);
    createEReference(arithOpEClass, ARITH_OP__LHS);
    createEReference(arithOpEClass, ARITH_OP__RHS);
    notEClass = createEClass(NOT);
    createEReference(notEClass, NOT__VALUE);
    cmpOpEClass = createEClass(CMP_OP);
    createEReference(cmpOpEClass, CMP_OP__LHS);
    createEReference(cmpOpEClass, CMP_OP__RHS);
    boolOpEClass = createEClass(BOOL_OP);
    ifEClass = createEClass(IF);
    createEReference(ifEClass, IF__COND);
    createEReference(ifEClass, IF__THN);
    createEReference(ifEClass, IF__ELS);
    letEClass = createEClass(LET);
    createEAttribute(letEClass, LET__NAME);						
    createEReference(letEClass, LET__LHS);
    createEReference(letEClass, LET__RHS);
    funEClass = createEClass(FUN);
    createEAttribute(funEClass, FUN__NAME);						
    createEReference(funEClass, FUN__BODY);
    assignEClass = createEClass(ASSIGN);
    createEReference(assignEClass, ASSIGN__LHS);
    createEReference(assignEClass, ASSIGN__RHS);
    createEAttribute(assignEClass, ASSIGN__NAME);						
    arithOpPlusEClass = createEClass(ARITH_OP_PLUS);
    arithOpMinusEClass = createEClass(ARITH_OP_MINUS);
    arithOpTimesEClass = createEClass(ARITH_OP_TIMES);
    arithOpDivideEClass = createEClass(ARITH_OP_DIVIDE);
    arithOpRemainderEClass = createEClass(ARITH_OP_REMAINDER);
    boolOpAndEClass = createEClass(BOOL_OP_AND);
    createEReference(boolOpAndEClass, BOOL_OP_AND__LHS);
    createEReference(boolOpAndEClass, BOOL_OP_AND__RHS);
    boolOpOrEClass = createEClass(BOOL_OP_OR);
    createEReference(boolOpOrEClass, BOOL_OP_OR__LHS);
    createEReference(boolOpOrEClass, BOOL_OP_OR__RHS);
    seqEClass = createEClass(SEQ);
    createEReference(seqEClass, SEQ__LHS);
    createEReference(seqEClass, SEQ__RHS);
    cmpOpEqualEClass = createEClass(CMP_OP_EQUAL);
    cmpOpUnequalEClass = createEClass(CMP_OP_UNEQUAL);
    cmpOpLessEClass = createEClass(CMP_OP_LESS);
    ctxEClass = createEClass(CTX);
    createEReference(ctxEClass, CTX__ENV);
    createEReference(ctxEClass, CTX__TH);
    stringToEvalResMapEClass = createEClass(STRING_TO_EVAL_RES_MAP);
    createEAttribute(stringToEvalResMapEClass, STRING_TO_EVAL_RES_MAP__KEY);						
    createEReference(stringToEvalResMapEClass, STRING_TO_EVAL_RES_MAP__VALUE);
    evalResEClass = createEClass(EVAL_RES);
    evalMapResEClass = createEClass(EVAL_MAP_RES);
    createEReference(evalMapResEClass, EVAL_MAP_RES__VALUES);
    evalFunResEClass = createEClass(EVAL_FUN_RES);
    createEReference(evalFunResEClass, EVAL_FUN_RES__EXP);
    createEReference(evalFunResEClass, EVAL_FUN_RES__CTX);
    createEAttribute(evalFunResEClass, EVAL_FUN_RES__NAME);						
    evalBoundFunResEClass = createEClass(EVAL_BOUND_FUN_RES);
    createEReference(evalBoundFunResEClass, EVAL_BOUND_FUN_RES__TH);
    evalIntResEClass = createEClass(EVAL_INT_RES);
    createEAttribute(evalIntResEClass, EVAL_INT_RES__VALUE);						
    evalBoolResEClass = createEClass(EVAL_BOOL_RES);
    createEAttribute(evalBoolResEClass, EVAL_BOOL_RES__VALUE);						
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
    exprEClass.getESuperTypes().add(this.getTopLevelCmd());
    defEClass.getESuperTypes().add(this.getTopLevelCmd());
    appEClass.getESuperTypes().add(this.getExpr());
    varEClass.getESuperTypes().add(this.getExpr());
    thisEClass.getESuperTypes().add(this.getExpr());
    boolEClass.getESuperTypes().add(this.getExpr());
    intEClass.getESuperTypes().add(this.getExpr());
    skipEClass.getESuperTypes().add(this.getExpr());
    projectEClass.getESuperTypes().add(this.getExpr());
    bObjectEClass.getESuperTypes().add(this.getExpr());
    copyEClass.getESuperTypes().add(this.getExpr());
    withEClass.getESuperTypes().add(this.getExpr());
    arithOpEClass.getESuperTypes().add(this.getExpr());
    notEClass.getESuperTypes().add(this.getExpr());
    cmpOpEClass.getESuperTypes().add(this.getExpr());
    boolOpEClass.getESuperTypes().add(this.getExpr());
    ifEClass.getESuperTypes().add(this.getExpr());
    letEClass.getESuperTypes().add(this.getExpr());
    funEClass.getESuperTypes().add(this.getExpr());
    assignEClass.getESuperTypes().add(this.getExpr());
    arithOpPlusEClass.getESuperTypes().add(this.getArithOp());
    arithOpMinusEClass.getESuperTypes().add(this.getArithOp());
    arithOpTimesEClass.getESuperTypes().add(this.getArithOp());
    arithOpDivideEClass.getESuperTypes().add(this.getArithOp());
    arithOpRemainderEClass.getESuperTypes().add(this.getArithOp());
    boolOpAndEClass.getESuperTypes().add(this.getBoolOp());
    boolOpOrEClass.getESuperTypes().add(this.getBoolOp());
    seqEClass.getESuperTypes().add(this.getExpr());
    cmpOpEqualEClass.getESuperTypes().add(this.getCmpOp());
    cmpOpUnequalEClass.getESuperTypes().add(this.getCmpOp());
    cmpOpLessEClass.getESuperTypes().add(this.getCmpOp());
    evalMapResEClass.getESuperTypes().add(this.getEvalRes());
    evalFunResEClass.getESuperTypes().add(this.getEvalRes());
    evalBoundFunResEClass.getESuperTypes().add(this.getEvalFunRes());
    evalIntResEClass.getESuperTypes().add(this.getEvalRes());
    evalBoolResEClass.getESuperTypes().add(this.getEvalRes());

    // Initialize classes, features, and operations; add parameters
    initEClass(fileEClass, visitor.boa.visitor.boa.File.class, "File", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getFile_Commands(), this.getTopLevelCmd(),  
    	null, "commands", null, 0, -1,  visitor.boa.visitor.boa.File.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEClass(topLevelCmdEClass, visitor.boa.visitor.boa.TopLevelCmd.class, "TopLevelCmd", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEClass(exprEClass, visitor.boa.visitor.boa.Expr.class, "Expr", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEClass(defEClass, visitor.boa.visitor.boa.Def.class, "Def", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getDef_Name(), ecorePackage.getEString(), "name", null, 0, 1,  visitor.boa.visitor.boa.Def.class, !IS_TRANSIENT,!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);				
    initEReference(getDef_Expr(), this.getExpr(),  
    	null, "expr", null, 1, 1,  visitor.boa.visitor.boa.Def.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEClass(appEClass, visitor.boa.visitor.boa.App.class, "App", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getApp_Lhs(), this.getExpr(),  
    	null, "lhs", null, 1, 1,  visitor.boa.visitor.boa.App.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getApp_Rhs(), this.getExpr(),  
    	null, "rhs", null, 1, 1,  visitor.boa.visitor.boa.App.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEClass(varEClass, visitor.boa.visitor.boa.Var.class, "Var", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getVar_Name(), ecorePackage.getEString(), "name", null, 0, 1,  visitor.boa.visitor.boa.Var.class, !IS_TRANSIENT,!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);				
    initEClass(thisEClass, visitor.boa.visitor.boa.This.class, "This", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEClass(boolEClass, visitor.boa.visitor.boa.Bool.class, "Bool", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getBool_Value(), ecorePackage.getEBoolean(), "value", null, 0, 1,  visitor.boa.visitor.boa.Bool.class, !IS_TRANSIENT,!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);				
    initEClass(intEClass, visitor.boa.visitor.boa.Int.class, "Int", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getInt_Value(), ecorePackage.getEInt(), "value", null, 0, 1,  visitor.boa.visitor.boa.Int.class, !IS_TRANSIENT,!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);				
    initEClass(skipEClass, visitor.boa.visitor.boa.Skip.class, "Skip", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEClass(projectEClass, visitor.boa.visitor.boa.Project.class, "Project", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getProject_Exp(), this.getExpr(),  
    	null, "exp", null, 1, 1,  visitor.boa.visitor.boa.Project.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getProject_Name(), ecorePackage.getEString(), "name", null, 0, 1,  visitor.boa.visitor.boa.Project.class, !IS_TRANSIENT,!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);				
    initEClass(bObjectEClass, visitor.boa.visitor.boa.BObject.class, "BObject", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getBobject_Fields(), this.getField(),  
    	null, "fields", null, 0, -1,  visitor.boa.visitor.boa.BObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEClass(fieldEClass, visitor.boa.visitor.boa.Field.class, "Field", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getField_Name(), ecorePackage.getEString(), "name", null, 0, 1,  visitor.boa.visitor.boa.Field.class, !IS_TRANSIENT,!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);				
    initEReference(getField_Value(), this.getExpr(),  
    	null, "value", null, 1, 1,  visitor.boa.visitor.boa.Field.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEClass(copyEClass, visitor.boa.visitor.boa.Copy.class, "Copy", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getCopy_Copy(), this.getExpr(),  
    	null, "copy", null, 1, 1,  visitor.boa.visitor.boa.Copy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEClass(withEClass, visitor.boa.visitor.boa.With.class, "With", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getWith_Lhs(), this.getExpr(),  
    	null, "lhs", null, 1, 1,  visitor.boa.visitor.boa.With.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getWith_Rhs(), this.getExpr(),  
    	null, "rhs", null, 1, 1,  visitor.boa.visitor.boa.With.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEClass(arithOpEClass, visitor.boa.visitor.boa.ArithOp.class, "ArithOp", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getArith_op_Lhs(), this.getExpr(),  
    	null, "lhs", null, 1, 1,  visitor.boa.visitor.boa.ArithOp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getArith_op_Rhs(), this.getExpr(),  
    	null, "rhs", null, 1, 1,  visitor.boa.visitor.boa.ArithOp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEClass(notEClass, visitor.boa.visitor.boa.Not.class, "Not", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getNot_Value(), this.getExpr(),  
    	null, "value", null, 1, 1,  visitor.boa.visitor.boa.Not.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEClass(cmpOpEClass, visitor.boa.visitor.boa.CmpOp.class, "CmpOp", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getCmp_op_Lhs(), this.getExpr(),  
    	null, "lhs", null, 1, 1,  visitor.boa.visitor.boa.CmpOp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getCmp_op_Rhs(), this.getExpr(),  
    	null, "rhs", null, 1, 1,  visitor.boa.visitor.boa.CmpOp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEClass(boolOpEClass, visitor.boa.visitor.boa.BoolOp.class, "BoolOp", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEClass(ifEClass, visitor.boa.visitor.boa.If.class, "If", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getIf_Cond(), this.getExpr(),  
    	null, "cond", null, 1, 1,  visitor.boa.visitor.boa.If.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getIf_Thn(), this.getExpr(),  
    	null, "thn", null, 1, 1,  visitor.boa.visitor.boa.If.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getIf_Els(), this.getExpr(),  
    	null, "els", null, 1, 1,  visitor.boa.visitor.boa.If.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEClass(letEClass, visitor.boa.visitor.boa.Let.class, "Let", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getLet_Name(), ecorePackage.getEString(), "name", null, 0, 1,  visitor.boa.visitor.boa.Let.class, !IS_TRANSIENT,!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);				
    initEReference(getLet_Lhs(), this.getExpr(),  
    	null, "lhs", null, 1, 1,  visitor.boa.visitor.boa.Let.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getLet_Rhs(), this.getExpr(),  
    	null, "rhs", null, 1, 1,  visitor.boa.visitor.boa.Let.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEClass(funEClass, visitor.boa.visitor.boa.Fun.class, "Fun", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getFun_Name(), ecorePackage.getEString(), "name", null, 0, 1,  visitor.boa.visitor.boa.Fun.class, !IS_TRANSIENT,!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);				
    initEReference(getFun_Body(), this.getExpr(),  
    	null, "body", null, 1, 1,  visitor.boa.visitor.boa.Fun.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEClass(assignEClass, visitor.boa.visitor.boa.Assign.class, "Assign", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getAssign_Lhs(), this.getExpr(),  
    	null, "lhs", null, 1, 1,  visitor.boa.visitor.boa.Assign.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAssign_Rhs(), this.getExpr(),  
    	null, "rhs", null, 1, 1,  visitor.boa.visitor.boa.Assign.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getAssign_Name(), ecorePackage.getEString(), "name", null, 0, 1,  visitor.boa.visitor.boa.Assign.class, !IS_TRANSIENT,!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);				
    initEClass(arithOpPlusEClass, visitor.boa.visitor.boa.ArithOpPlus.class, "ArithOpPlus", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEClass(arithOpMinusEClass, visitor.boa.visitor.boa.ArithOpMinus.class, "ArithOpMinus", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEClass(arithOpTimesEClass, visitor.boa.visitor.boa.ArithOpTimes.class, "ArithOpTimes", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEClass(arithOpDivideEClass, visitor.boa.visitor.boa.ArithOpDivide.class, "ArithOpDivide", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEClass(arithOpRemainderEClass, visitor.boa.visitor.boa.ArithOpRemainder.class, "ArithOpRemainder", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEClass(boolOpAndEClass, visitor.boa.visitor.boa.BoolOpAnd.class, "BoolOpAnd", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getBool_op_and_Lhs(), this.getExpr(),  
    	null, "lhs", null, 1, 1,  visitor.boa.visitor.boa.BoolOpAnd.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getBool_op_and_Rhs(), this.getExpr(),  
    	null, "rhs", null, 1, 1,  visitor.boa.visitor.boa.BoolOpAnd.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEClass(boolOpOrEClass, visitor.boa.visitor.boa.BoolOpOr.class, "BoolOpOr", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getBool_op_or_Lhs(), this.getExpr(),  
    	null, "lhs", null, 1, 1,  visitor.boa.visitor.boa.BoolOpOr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getBool_op_or_Rhs(), this.getExpr(),  
    	null, "rhs", null, 1, 1,  visitor.boa.visitor.boa.BoolOpOr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEClass(seqEClass, visitor.boa.visitor.boa.Seq.class, "Seq", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getSeq_Lhs(), this.getExpr(),  
    	null, "lhs", null, 1, 1,  visitor.boa.visitor.boa.Seq.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSeq_Rhs(), this.getExpr(),  
    	null, "rhs", null, 1, 1,  visitor.boa.visitor.boa.Seq.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEClass(cmpOpEqualEClass, visitor.boa.visitor.boa.CmpOpEqual.class, "CmpOpEqual", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEClass(cmpOpUnequalEClass, visitor.boa.visitor.boa.CmpOpUnequal.class, "CmpOpUnequal", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEClass(cmpOpLessEClass, visitor.boa.visitor.boa.CmpOpLess.class, "CmpOpLess", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEClass(ctxEClass, visitor.boa.visitor.boa.Ctx.class, "Ctx", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getCtx_Env(), this.getStringToEvalResMap(),  
    	null, "env", null, 0, -1,  visitor.boa.visitor.boa.Ctx.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getCtx_Th(), this.getStringToEvalResMap(),  
    	null, "th", null, 0, -1,  visitor.boa.visitor.boa.Ctx.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEClass(stringToEvalResMapEClass, visitor.boa.visitor.boa.StringToEvalResMap.class, "StringToEvalResMap", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getString_to_eval_res_map_Key(), ecorePackage.getEString(), "key", null, 0, 1,  visitor.boa.visitor.boa.StringToEvalResMap.class, !IS_TRANSIENT,!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);				
    initEReference(getString_to_eval_res_map_Value(), this.getEvalRes(),  
    	null, "value", null, 1, 1,  visitor.boa.visitor.boa.StringToEvalResMap.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEClass(evalResEClass, visitor.boa.visitor.boa.EvalRes.class, "EvalRes", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEClass(evalMapResEClass, visitor.boa.visitor.boa.EvalMapRes.class, "EvalMapRes", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getEval_map_res_Values(), this.getStringToEvalResMap(),  
    	null, "values", null, 0, -1,  visitor.boa.visitor.boa.EvalMapRes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEClass(evalFunResEClass, visitor.boa.visitor.boa.EvalFunRes.class, "EvalFunRes", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getEval_fun_res_Exp(), this.getExpr(),  
    	null, "exp", null, 1, 1,  visitor.boa.visitor.boa.EvalFunRes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getEval_fun_res_Ctx(), this.getCtx(),  
    	null, "ctx", null, 1, 1,  visitor.boa.visitor.boa.EvalFunRes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getEval_fun_res_Name(), ecorePackage.getEString(), "name", null, 0, 1,  visitor.boa.visitor.boa.EvalFunRes.class, !IS_TRANSIENT,!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);				
    initEClass(evalBoundFunResEClass, visitor.boa.visitor.boa.EvalBoundFunRes.class, "EvalBoundFunRes", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getEval_bound_fun_res_Th(), this.getStringToEvalResMap(),  
    	null, "th", null, 0, -1,  visitor.boa.visitor.boa.EvalBoundFunRes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEClass(evalIntResEClass, visitor.boa.visitor.boa.EvalIntRes.class, "EvalIntRes", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getEval_int_res_Value(), ecorePackage.getEInt(), "value", null, 0, 1,  visitor.boa.visitor.boa.EvalIntRes.class, !IS_TRANSIENT,!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);				
    initEClass(evalBoolResEClass, visitor.boa.visitor.boa.EvalBoolRes.class, "EvalBoolRes", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getEval_bool_res_Value(), ecorePackage.getEBoolean(), "value", null, 0, 1,  visitor.boa.visitor.boa.EvalBoolRes.class, !IS_TRANSIENT,!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);				
    // Create resource
    createResource(eNS_URI);
  }

  public BoaFactory getBoaFactory() {
    return (BoaFactory) getEFactoryInstance();
  }

  public EClass getFile() {
    return fileEClass;
  }

  public EClass getTopLevelCmd() {
    return topLevelCmdEClass;
  }

  public EClass getExpr() {
    return exprEClass;
  }

  public EClass getDef() {
    return defEClass;
  }

  public EClass getApp() {
    return appEClass;
  }

  public EClass getVar() {
    return varEClass;
  }

  public EClass getThis() {
    return thisEClass;
  }

  public EClass getBool() {
    return boolEClass;
  }

  public EClass getInt() {
    return intEClass;
  }

  public EClass getSkip() {
    return skipEClass;
  }

  public EClass getProject() {
    return projectEClass;
  }

  public EClass getBObject() {
    return bObjectEClass;
  }

  public EClass getField() {
    return fieldEClass;
  }

  public EClass getCopy() {
    return copyEClass;
  }

  public EClass getWith() {
    return withEClass;
  }

  public EClass getArithOp() {
    return arithOpEClass;
  }

  public EClass getNot() {
    return notEClass;
  }

  public EClass getCmpOp() {
    return cmpOpEClass;
  }

  public EClass getBoolOp() {
    return boolOpEClass;
  }

  public EClass getIf() {
    return ifEClass;
  }

  public EClass getLet() {
    return letEClass;
  }

  public EClass getFun() {
    return funEClass;
  }

  public EClass getAssign() {
    return assignEClass;
  }

  public EClass getArithOpPlus() {
    return arithOpPlusEClass;
  }

  public EClass getArithOpMinus() {
    return arithOpMinusEClass;
  }

  public EClass getArithOpTimes() {
    return arithOpTimesEClass;
  }

  public EClass getArithOpDivide() {
    return arithOpDivideEClass;
  }

  public EClass getArithOpRemainder() {
    return arithOpRemainderEClass;
  }

  public EClass getBoolOpAnd() {
    return boolOpAndEClass;
  }

  public EClass getBoolOpOr() {
    return boolOpOrEClass;
  }

  public EClass getSeq() {
    return seqEClass;
  }

  public EClass getCmpOpEqual() {
    return cmpOpEqualEClass;
  }

  public EClass getCmpOpUnequal() {
    return cmpOpUnequalEClass;
  }

  public EClass getCmpOpLess() {
    return cmpOpLessEClass;
  }

  public EClass getCtx() {
    return ctxEClass;
  }

  public EClass getStringToEvalResMap() {
    return stringToEvalResMapEClass;
  }

  public EClass getEvalRes() {
    return evalResEClass;
  }

  public EClass getEvalMapRes() {
    return evalMapResEClass;
  }

  public EClass getEvalFunRes() {
    return evalFunResEClass;
  }

  public EClass getEvalBoundFunRes() {
    return evalBoundFunResEClass;
  }

  public EClass getEvalIntRes() {
    return evalIntResEClass;
  }

  public EClass getEvalBoolRes() {
    return evalBoolResEClass;
  }

  public EReference getFile_Commands() {
    return (EReference) fileEClass.getEStructuralFeatures().get(0);
  }

  public EAttribute getDef_Name() {
    return (EAttribute) defEClass.getEStructuralFeatures().get(0);
  }

  public EReference getDef_Expr() {
    return (EReference) defEClass.getEStructuralFeatures().get(1);
  }

  public EReference getApp_Lhs() {
    return (EReference) appEClass.getEStructuralFeatures().get(0);
  }

  public EReference getApp_Rhs() {
    return (EReference) appEClass.getEStructuralFeatures().get(1);
  }

  public EAttribute getVar_Name() {
    return (EAttribute) varEClass.getEStructuralFeatures().get(0);
  }

  public EAttribute getBool_Value() {
    return (EAttribute) boolEClass.getEStructuralFeatures().get(0);
  }

  public EAttribute getInt_Value() {
    return (EAttribute) intEClass.getEStructuralFeatures().get(0);
  }

  public EReference getProject_Exp() {
    return (EReference) projectEClass.getEStructuralFeatures().get(0);
  }

  public EAttribute getProject_Name() {
    return (EAttribute) projectEClass.getEStructuralFeatures().get(1);
  }

  public EReference getBobject_Fields() {
    return (EReference) bObjectEClass.getEStructuralFeatures().get(0);
  }

  public EAttribute getField_Name() {
    return (EAttribute) fieldEClass.getEStructuralFeatures().get(0);
  }

  public EReference getField_Value() {
    return (EReference) fieldEClass.getEStructuralFeatures().get(1);
  }

  public EReference getCopy_Copy() {
    return (EReference) copyEClass.getEStructuralFeatures().get(0);
  }

  public EReference getWith_Lhs() {
    return (EReference) withEClass.getEStructuralFeatures().get(0);
  }

  public EReference getWith_Rhs() {
    return (EReference) withEClass.getEStructuralFeatures().get(1);
  }

  public EReference getArith_op_Lhs() {
    return (EReference) arithOpEClass.getEStructuralFeatures().get(0);
  }

  public EReference getArith_op_Rhs() {
    return (EReference) arithOpEClass.getEStructuralFeatures().get(1);
  }

  public EReference getNot_Value() {
    return (EReference) notEClass.getEStructuralFeatures().get(0);
  }

  public EReference getCmp_op_Lhs() {
    return (EReference) cmpOpEClass.getEStructuralFeatures().get(0);
  }

  public EReference getCmp_op_Rhs() {
    return (EReference) cmpOpEClass.getEStructuralFeatures().get(1);
  }

  public EReference getIf_Cond() {
    return (EReference) ifEClass.getEStructuralFeatures().get(0);
  }

  public EReference getIf_Thn() {
    return (EReference) ifEClass.getEStructuralFeatures().get(1);
  }

  public EReference getIf_Els() {
    return (EReference) ifEClass.getEStructuralFeatures().get(2);
  }

  public EAttribute getLet_Name() {
    return (EAttribute) letEClass.getEStructuralFeatures().get(0);
  }

  public EReference getLet_Lhs() {
    return (EReference) letEClass.getEStructuralFeatures().get(1);
  }

  public EReference getLet_Rhs() {
    return (EReference) letEClass.getEStructuralFeatures().get(2);
  }

  public EAttribute getFun_Name() {
    return (EAttribute) funEClass.getEStructuralFeatures().get(0);
  }

  public EReference getFun_Body() {
    return (EReference) funEClass.getEStructuralFeatures().get(1);
  }

  public EReference getAssign_Lhs() {
    return (EReference) assignEClass.getEStructuralFeatures().get(0);
  }

  public EReference getAssign_Rhs() {
    return (EReference) assignEClass.getEStructuralFeatures().get(1);
  }

  public EAttribute getAssign_Name() {
    return (EAttribute) assignEClass.getEStructuralFeatures().get(2);
  }

  public EReference getBool_op_and_Lhs() {
    return (EReference) boolOpAndEClass.getEStructuralFeatures().get(0);
  }

  public EReference getBool_op_and_Rhs() {
    return (EReference) boolOpAndEClass.getEStructuralFeatures().get(1);
  }

  public EReference getBool_op_or_Lhs() {
    return (EReference) boolOpOrEClass.getEStructuralFeatures().get(0);
  }

  public EReference getBool_op_or_Rhs() {
    return (EReference) boolOpOrEClass.getEStructuralFeatures().get(1);
  }

  public EReference getSeq_Lhs() {
    return (EReference) seqEClass.getEStructuralFeatures().get(0);
  }

  public EReference getSeq_Rhs() {
    return (EReference) seqEClass.getEStructuralFeatures().get(1);
  }

  public EReference getCtx_Env() {
    return (EReference) ctxEClass.getEStructuralFeatures().get(0);
  }

  public EReference getCtx_Th() {
    return (EReference) ctxEClass.getEStructuralFeatures().get(1);
  }

  public EAttribute getString_to_eval_res_map_Key() {
    return (EAttribute) stringToEvalResMapEClass.getEStructuralFeatures().get(0);
  }

  public EReference getString_to_eval_res_map_Value() {
    return (EReference) stringToEvalResMapEClass.getEStructuralFeatures().get(1);
  }

  public EReference getEval_map_res_Values() {
    return (EReference) evalMapResEClass.getEStructuralFeatures().get(0);
  }

  public EReference getEval_fun_res_Exp() {
    return (EReference) evalFunResEClass.getEStructuralFeatures().get(0);
  }

  public EReference getEval_fun_res_Ctx() {
    return (EReference) evalFunResEClass.getEStructuralFeatures().get(1);
  }

  public EAttribute getEval_fun_res_Name() {
    return (EAttribute) evalFunResEClass.getEStructuralFeatures().get(2);
  }

  public EReference getEval_bound_fun_res_Th() {
    return (EReference) evalBoundFunResEClass.getEStructuralFeatures().get(0);
  }

  public EAttribute getEval_int_res_Value() {
    return (EAttribute) evalIntResEClass.getEStructuralFeatures().get(0);
  }

  public EAttribute getEval_bool_res_Value() {
    return (EAttribute) evalBoolResEClass.getEStructuralFeatures().get(0);
  }
}
