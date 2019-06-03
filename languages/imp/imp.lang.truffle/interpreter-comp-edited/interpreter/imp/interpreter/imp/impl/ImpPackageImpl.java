package interpreter.imp.interpreter.imp.impl;

import interpreter.imp.interpreter.imp.ImpFactory;
import interpreter.imp.interpreter.imp.ImpPackage;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;

public class ImpPackageImpl extends EPackageImpl implements ImpPackage {
  private static boolean isInited = false;

  private boolean isCreated = false;

  private boolean isInitialized = false;

  private EClass stmtEClass = null;

  private EClass skipEClass = null;

  private EClass assignEClass = null;

  private EClass exprEClass = null;

  private EClass blockEClass = null;

  private EClass ifEClass = null;

  private EClass whileEClass = null;

  private EClass intConstEClass = null;

  private EClass varEClass = null;

  private EClass unaryEClass = null;

  private EClass binaryEClass = null;

  private EClass storeEClass = null;

  private EClass stringToValueMapEClass = null;

  private EClass valueEClass = null;

  private EClass intValueEClass = null;

  private EClass boolValueEClass = null;

  private EClass arrayValueEClass = null;

  private EClass arrayDeclEClass = null;

  private EClass boolConstEClass = null;

  private EEnum unaryOpEEnum = null;

  private EEnum binaryOpEEnum = null;

  private ImpPackageImpl() {
    super(eNS_URI, ImpFactory.eINSTANCE);
  }

  public static ImpPackage init() {
    if (isInited)
    	return (ImpPackage) EPackage.Registry.INSTANCE.getEPackage(ImpPackage.eNS_URI);

    // Obtain or create and register package
    Object registeredImpPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
    interpreter.imp.interpreter.imp.impl.ImpPackageImpl theImpPackage;
    if(registeredImpPackage instanceof interpreter.imp.interpreter.imp.impl.ImpPackageImpl) {
    	 theImpPackage =  (interpreter.imp.interpreter.imp.impl.ImpPackageImpl) registeredImpPackage;
    } else {
     	theImpPackage = new interpreter.imp.interpreter.imp.impl.ImpPackageImpl();
    }
    isInited = true;
    				
    // Create package meta-data objects
    theImpPackage.createPackageContents();

    // Initialize created meta-data
    theImpPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theImpPackage.freeze();

    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(ImpPackage.eNS_URI, theImpPackage);
    return theImpPackage;
  }

  public void createPackageContents() {
    if(isCreated)
    	return;
    isCreated = true;

    stmtEClass = createEClass(STMT);
    skipEClass = createEClass(SKIP);
    assignEClass = createEClass(ASSIGN);
    createEAttribute(assignEClass, ASSIGN__NAME);
    createEReference(assignEClass, ASSIGN__EXP);
    createEReference(assignEClass, ASSIGN__INDEX);
    exprEClass = createEClass(EXPR);
    blockEClass = createEClass(BLOCK);
    createEReference(blockEClass, BLOCK__STMTS);
    ifEClass = createEClass(IF);
    createEReference(ifEClass, IF__COND);
    createEReference(ifEClass, IF__LHS);
    createEReference(ifEClass, IF__RHS);
    whileEClass = createEClass(WHILE);
    createEReference(whileEClass, WHILE__COND);
    createEReference(whileEClass, WHILE__BODY);
    intConstEClass = createEClass(INT_CONST);
    createEAttribute(intConstEClass, INT_CONST__VALUE);
    varEClass = createEClass(VAR);
    createEAttribute(varEClass, VAR__NAME);
    createEReference(varEClass, VAR__INDEX);
    unaryEClass = createEClass(UNARY);
    createEAttribute(unaryEClass, UNARY__OP);
    createEReference(unaryEClass, UNARY__EXPR);
    binaryEClass = createEClass(BINARY);
    createEReference(binaryEClass, BINARY__LHS);
    createEReference(binaryEClass, BINARY__RHS);
    createEAttribute(binaryEClass, BINARY__OP);
    storeEClass = createEClass(STORE);
    createEReference(storeEClass, STORE__VALUES);
    stringToValueMapEClass = createEClass(STRING_TO_VALUE_MAP);
    createEAttribute(stringToValueMapEClass, STRING_TO_VALUE_MAP__KEY);
    createEReference(stringToValueMapEClass, STRING_TO_VALUE_MAP__VALUE);
    valueEClass = createEClass(VALUE);
    intValueEClass = createEClass(INT_VALUE);
    createEAttribute(intValueEClass, INT_VALUE__VALUE);
    boolValueEClass = createEClass(BOOL_VALUE);
    createEAttribute(boolValueEClass, BOOL_VALUE__VALUE);
    arrayValueEClass = createEClass(ARRAY_VALUE);
    createEReference(arrayValueEClass, ARRAY_VALUE__VALUES);
    arrayDeclEClass = createEClass(ARRAY_DECL);
    createEReference(arrayDeclEClass, ARRAY_DECL__VALUES);
    boolConstEClass = createEClass(BOOL_CONST);
    createEAttribute(boolConstEClass, BOOL_CONST__VALUE);
    unaryOpEEnum = createEEnum(UNARY_OP);
    binaryOpEEnum = createEEnum(BINARY_OP);
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
    skipEClass.getESuperTypes().add(this.getStmt());
    assignEClass.getESuperTypes().add(this.getStmt());
    blockEClass.getESuperTypes().add(this.getStmt());
    ifEClass.getESuperTypes().add(this.getStmt());
    whileEClass.getESuperTypes().add(this.getStmt());
    intConstEClass.getESuperTypes().add(this.getExpr());
    varEClass.getESuperTypes().add(this.getExpr());
    unaryEClass.getESuperTypes().add(this.getExpr());
    binaryEClass.getESuperTypes().add(this.getExpr());
    intValueEClass.getESuperTypes().add(this.getValue());
    boolValueEClass.getESuperTypes().add(this.getValue());
    arrayValueEClass.getESuperTypes().add(this.getValue());
    arrayDeclEClass.getESuperTypes().add(this.getExpr());
    boolConstEClass.getESuperTypes().add(this.getExpr());

    // Initialize classes, features, and operations; add parameters
    initEClass(stmtEClass, interpreter.imp.interpreter.imp.Stmt.class, "Stmt", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEClass(skipEClass, interpreter.imp.interpreter.imp.Skip.class, "Skip", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEClass(assignEClass, interpreter.imp.interpreter.imp.Assign.class, "Assign", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getAssign_Name(), ecorePackage.getEString(), "name", null, 0, 1,  interpreter.imp.interpreter.imp.Assign.class, !IS_TRANSIENT,!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);				
    initEReference(getAssign_Exp(), this.getExpr(),  
    	null, "exp", null, 1, 1,  interpreter.imp.interpreter.imp.Assign.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAssign_Index(), this.getExpr(),  
    	null, "index", null, 0, 1,  interpreter.imp.interpreter.imp.Assign.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEClass(exprEClass, interpreter.imp.interpreter.imp.Expr.class, "Expr", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEClass(blockEClass, interpreter.imp.interpreter.imp.Block.class, "Block", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getBlock_Stmts(), this.getStmt(),  
    	null, "stmts", null, 0, -1,  interpreter.imp.interpreter.imp.Block.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEClass(ifEClass, interpreter.imp.interpreter.imp.If.class, "If", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getIf_Cond(), this.getExpr(),  
    	null, "cond", null, 1, 1,  interpreter.imp.interpreter.imp.If.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getIf_Lhs(), this.getStmt(),  
    	null, "lhs", null, 1, 1,  interpreter.imp.interpreter.imp.If.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getIf_Rhs(), this.getStmt(),  
    	null, "rhs", null, 1, 1,  interpreter.imp.interpreter.imp.If.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEClass(whileEClass, interpreter.imp.interpreter.imp.While.class, "While", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getWhile_Cond(), this.getExpr(),  
    	null, "cond", null, 1, 1,  interpreter.imp.interpreter.imp.While.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getWhile_Body(), this.getStmt(),  
    	null, "body", null, 1, 1,  interpreter.imp.interpreter.imp.While.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEClass(intConstEClass, interpreter.imp.interpreter.imp.IntConst.class, "IntConst", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getInt_const_Value(), ecorePackage.getEInt(), "value", null, 0, 1,  interpreter.imp.interpreter.imp.IntConst.class, !IS_TRANSIENT,!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);				
    initEClass(varEClass, interpreter.imp.interpreter.imp.Var.class, "Var", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getVar_Name(), ecorePackage.getEString(), "name", null, 0, 1,  interpreter.imp.interpreter.imp.Var.class, !IS_TRANSIENT,!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);				
    initEReference(getVar_Index(), this.getExpr(),  
    	null, "index", null, 0, 1,  interpreter.imp.interpreter.imp.Var.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEClass(unaryEClass, interpreter.imp.interpreter.imp.Unary.class, "Unary", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getUnary_Op(), this.getUnaryOp(), "op", null, 0, 1,  interpreter.imp.interpreter.imp.Unary.class, !IS_TRANSIENT,!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getUnary_Expr(), this.getExpr(),  
    	null, "expr", null, 1, 1,  interpreter.imp.interpreter.imp.Unary.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEClass(binaryEClass, interpreter.imp.interpreter.imp.Binary.class, "Binary", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getBinary_Lhs(), this.getExpr(),  
    	null, "lhs", null, 1, 1,  interpreter.imp.interpreter.imp.Binary.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getBinary_Rhs(), this.getExpr(),  
    	null, "rhs", null, 1, 1,  interpreter.imp.interpreter.imp.Binary.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getBinary_Op(), this.getBinaryOp(), "op", null, 0, 1,  interpreter.imp.interpreter.imp.Binary.class, !IS_TRANSIENT,!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEClass(storeEClass, interpreter.imp.interpreter.imp.Store.class, "Store", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getStore_Values(), this.getStringToValueMap(),  
    	null, "values", null, 0, -1,  interpreter.imp.interpreter.imp.Store.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEClass(stringToValueMapEClass, interpreter.imp.interpreter.imp.StringToValueMap.class, "StringToValueMap", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getString_to_value_map_Key(), ecorePackage.getEString(), "key", null, 0, 1,  interpreter.imp.interpreter.imp.StringToValueMap.class, !IS_TRANSIENT,!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);				
    initEReference(getString_to_value_map_Value(), this.getValue(),  
    	null, "value", null, 1, 1,  interpreter.imp.interpreter.imp.StringToValueMap.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEClass(valueEClass, interpreter.imp.interpreter.imp.Value.class, "Value", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEClass(intValueEClass, interpreter.imp.interpreter.imp.IntValue.class, "IntValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getInt_value_Value(), ecorePackage.getEInt(), "value", null, 0, 1,  interpreter.imp.interpreter.imp.IntValue.class, !IS_TRANSIENT,!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);				
    initEClass(boolValueEClass, interpreter.imp.interpreter.imp.BoolValue.class, "BoolValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getBool_value_Value(), ecorePackage.getEBoolean(), "value", null, 0, 1,  interpreter.imp.interpreter.imp.BoolValue.class, !IS_TRANSIENT,!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);				
    initEClass(arrayValueEClass, interpreter.imp.interpreter.imp.ArrayValue.class, "ArrayValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getArray_value_Values(), this.getValue(),  
    	null, "values", null, 0, -1,  interpreter.imp.interpreter.imp.ArrayValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEClass(arrayDeclEClass, interpreter.imp.interpreter.imp.ArrayDecl.class, "ArrayDecl", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getArray_decl_Values(), this.getExpr(),  
    	null, "values", null, 0, -1,  interpreter.imp.interpreter.imp.ArrayDecl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEClass(boolConstEClass, interpreter.imp.interpreter.imp.BoolConst.class, "BoolConst", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getBool_const_Value(), ecorePackage.getEBoolean(), "value", null, 0, 1,  interpreter.imp.interpreter.imp.BoolConst.class, !IS_TRANSIENT,!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);				
    initEEnum(unaryOpEEnum, interpreter.imp.interpreter.imp.UnaryOp.class, "UnaryOp");
    addEEnumLiteral(unaryOpEEnum, interpreter.imp.interpreter.imp.UnaryOp.NEGATE);
    addEEnumLiteral(unaryOpEEnum, interpreter.imp.interpreter.imp.UnaryOp.NOT);
    initEEnum(binaryOpEEnum, interpreter.imp.interpreter.imp.BinaryOp.class, "BinaryOp");
    addEEnumLiteral(binaryOpEEnum, interpreter.imp.interpreter.imp.BinaryOp.ADD);
    addEEnumLiteral(binaryOpEEnum, interpreter.imp.interpreter.imp.BinaryOp.SUB);
    addEEnumLiteral(binaryOpEEnum, interpreter.imp.interpreter.imp.BinaryOp.MUL);
    addEEnumLiteral(binaryOpEEnum, interpreter.imp.interpreter.imp.BinaryOp.LT);
    addEEnumLiteral(binaryOpEEnum, interpreter.imp.interpreter.imp.BinaryOp.LEQ);
    addEEnumLiteral(binaryOpEEnum, interpreter.imp.interpreter.imp.BinaryOp.EQ);
    addEEnumLiteral(binaryOpEEnum, interpreter.imp.interpreter.imp.BinaryOp.GEQ);
    addEEnumLiteral(binaryOpEEnum, interpreter.imp.interpreter.imp.BinaryOp.GT);
    addEEnumLiteral(binaryOpEEnum, interpreter.imp.interpreter.imp.BinaryOp.AND);
    addEEnumLiteral(binaryOpEEnum, interpreter.imp.interpreter.imp.BinaryOp.OR);
    // Create resource
    createResource(eNS_URI);
  }

  public ImpFactory getImpFactory() {
    return (ImpFactory) getEFactoryInstance();
  }

  public EClass getStmt() {
    return stmtEClass;
  }

  public EClass getSkip() {
    return skipEClass;
  }

  public EClass getAssign() {
    return assignEClass;
  }

  public EClass getExpr() {
    return exprEClass;
  }

  public EClass getBlock() {
    return blockEClass;
  }

  public EClass getIf() {
    return ifEClass;
  }

  public EClass getWhile() {
    return whileEClass;
  }

  public EClass getIntConst() {
    return intConstEClass;
  }

  public EClass getVar() {
    return varEClass;
  }

  public EClass getUnary() {
    return unaryEClass;
  }

  public EClass getBinary() {
    return binaryEClass;
  }

  public EClass getStore() {
    return storeEClass;
  }

  public EClass getStringToValueMap() {
    return stringToValueMapEClass;
  }

  public EClass getValue() {
    return valueEClass;
  }

  public EClass getIntValue() {
    return intValueEClass;
  }

  public EClass getBoolValue() {
    return boolValueEClass;
  }

  public EClass getArrayValue() {
    return arrayValueEClass;
  }

  public EClass getArrayDecl() {
    return arrayDeclEClass;
  }

  public EClass getBoolConst() {
    return boolConstEClass;
  }

  public EEnum getUnaryOp() {
    return unaryOpEEnum;
  }

  public EEnum getBinaryOp() {
    return binaryOpEEnum;
  }

  public EAttribute getAssign_Name() {
    return (EAttribute) assignEClass.getEStructuralFeatures().get(0);
  }

  public EReference getAssign_Exp() {
    return (EReference) assignEClass.getEStructuralFeatures().get(1);
  }

  public EReference getAssign_Index() {
    return (EReference) assignEClass.getEStructuralFeatures().get(2);
  }

  public EReference getBlock_Stmts() {
    return (EReference) blockEClass.getEStructuralFeatures().get(0);
  }

  public EReference getIf_Cond() {
    return (EReference) ifEClass.getEStructuralFeatures().get(0);
  }

  public EReference getIf_Lhs() {
    return (EReference) ifEClass.getEStructuralFeatures().get(1);
  }

  public EReference getIf_Rhs() {
    return (EReference) ifEClass.getEStructuralFeatures().get(2);
  }

  public EReference getWhile_Cond() {
    return (EReference) whileEClass.getEStructuralFeatures().get(0);
  }

  public EReference getWhile_Body() {
    return (EReference) whileEClass.getEStructuralFeatures().get(1);
  }

  public EAttribute getInt_const_Value() {
    return (EAttribute) intConstEClass.getEStructuralFeatures().get(0);
  }

  public EAttribute getVar_Name() {
    return (EAttribute) varEClass.getEStructuralFeatures().get(0);
  }

  public EReference getVar_Index() {
    return (EReference) varEClass.getEStructuralFeatures().get(1);
  }

  public EAttribute getUnary_Op() {
    return (EAttribute) unaryEClass.getEStructuralFeatures().get(0);
  }

  public EReference getUnary_Expr() {
    return (EReference) unaryEClass.getEStructuralFeatures().get(1);
  }

  public EReference getBinary_Lhs() {
    return (EReference) binaryEClass.getEStructuralFeatures().get(0);
  }

  public EReference getBinary_Rhs() {
    return (EReference) binaryEClass.getEStructuralFeatures().get(1);
  }

  public EAttribute getBinary_Op() {
    return (EAttribute) binaryEClass.getEStructuralFeatures().get(2);
  }

  public EReference getStore_Values() {
    return (EReference) storeEClass.getEStructuralFeatures().get(0);
  }

  public EAttribute getString_to_value_map_Key() {
    return (EAttribute) stringToValueMapEClass.getEStructuralFeatures().get(0);
  }

  public EReference getString_to_value_map_Value() {
    return (EReference) stringToValueMapEClass.getEStructuralFeatures().get(1);
  }

  public EAttribute getInt_value_Value() {
    return (EAttribute) intValueEClass.getEStructuralFeatures().get(0);
  }

  public EAttribute getBool_value_Value() {
    return (EAttribute) boolValueEClass.getEStructuralFeatures().get(0);
  }

  public EReference getArray_value_Values() {
    return (EReference) arrayValueEClass.getEStructuralFeatures().get(0);
  }

  public EReference getArray_decl_Values() {
    return (EReference) arrayDeclEClass.getEStructuralFeatures().get(0);
  }

  public EAttribute getBool_const_Value() {
    return (EAttribute) boolConstEClass.getEStructuralFeatures().get(0);
  }
}
