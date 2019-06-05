package imp.visitor.imp.impl;

import imp.visitor.imp.Assign;
import imp.visitor.imp.Binary;
import imp.visitor.imp.BinaryOp;
import imp.visitor.imp.Block;
import imp.visitor.imp.BoolValue;
import imp.visitor.imp.Expr;
import imp.visitor.imp.If;
import imp.visitor.imp.ImpFactory;
import imp.visitor.imp.ImpPackage;
import imp.visitor.imp.IntConst;
import imp.visitor.imp.IntValue;
import imp.visitor.imp.Skip;
import imp.visitor.imp.Stmt;
import imp.visitor.imp.Store;
import imp.visitor.imp.Unary;
import imp.visitor.imp.UnaryOp;
import imp.visitor.imp.Value;
import imp.visitor.imp.Var;
import imp.visitor.imp.While;
import java.util.Map.Entry;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;

public class ImpPackageImpl extends EPackageImpl implements ImpPackage {
	private static boolean isInited = false;

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

	private EEnum unaryOpEEnum = null;

	private EEnum binaryOpEEnum = null;

	private EClass storeEClass = null;

	private EClass stringToValueMapEClass = null;

	private EClass valueEClass = null;

	private EClass intValueEClass = null;

	private EClass boolValueEClass = null;

	private boolean isCreated = false;

	private boolean isInitialized = false;

	private ImpPackageImpl() {
		super(eNS_URI, ImpFactory.eINSTANCE);
	}

	public static ImpPackage init() {
		if (isInited)
			return (ImpPackage) EPackage.Registry.INSTANCE.getEPackage(ImpPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredImpPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		ImpPackageImpl theImpPackage = registeredImpPackage instanceof ImpPackageImpl
				? (ImpPackageImpl) registeredImpPackage
				: new ImpPackageImpl();

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

	public EClass getStmt() {
		return stmtEClass;
	}

	public EClass getSkip() {
		return skipEClass;
	}

	public EClass getAssign() {
		return assignEClass;
	}

	public EAttribute getAssign_Name() {
		return (EAttribute) assignEClass.getEStructuralFeatures().get(0);
	}

	public EReference getAssign_Exp() {
		return (EReference) assignEClass.getEStructuralFeatures().get(1);
	}

	public EClass getExpr() {
		return exprEClass;
	}

	public EClass getBlock() {
		return blockEClass;
	}

	public EReference getBlock_Stmts() {
		return (EReference) blockEClass.getEStructuralFeatures().get(0);
	}

	public EClass getIf() {
		return ifEClass;
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

	public EClass getWhile() {
		return whileEClass;
	}

	public EReference getWhile_Cond() {
		return (EReference) whileEClass.getEStructuralFeatures().get(0);
	}

	public EReference getWhile_Body() {
		return (EReference) whileEClass.getEStructuralFeatures().get(1);
	}

	public EClass getIntConst() {
		return intConstEClass;
	}

	public EAttribute getIntConst_Value() {
		return (EAttribute) intConstEClass.getEStructuralFeatures().get(0);
	}

	public EClass getVar() {
		return varEClass;
	}

	public EAttribute getVar_Name() {
		return (EAttribute) varEClass.getEStructuralFeatures().get(0);
	}

	public EClass getUnary() {
		return unaryEClass;
	}

	public EAttribute getUnary_Op() {
		return (EAttribute) unaryEClass.getEStructuralFeatures().get(0);
	}

	public EReference getUnary_Expr() {
		return (EReference) unaryEClass.getEStructuralFeatures().get(1);
	}

	public EClass getBinary() {
		return binaryEClass;
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

	public EEnum getUnaryOp() {
		return unaryOpEEnum;
	}

	public EEnum getBinaryOp() {
		return binaryOpEEnum;
	}

	public EClass getStore() {
		return storeEClass;
	}

	public EReference getStore_Values() {
		return (EReference) storeEClass.getEStructuralFeatures().get(0);
	}

	public EClass getStringToValueMap() {
		return stringToValueMapEClass;
	}

	public EAttribute getStringToValueMap_Key() {
		return (EAttribute) stringToValueMapEClass.getEStructuralFeatures().get(0);
	}

	public EReference getStringToValueMap_Value() {
		return (EReference) stringToValueMapEClass.getEStructuralFeatures().get(1);
	}

	public EClass getValue() {
		return valueEClass;
	}

	public EClass getIntValue() {
		return intValueEClass;
	}

	public EAttribute getIntValue_Value() {
		return (EAttribute) intValueEClass.getEStructuralFeatures().get(0);
	}

	public EClass getBoolValue() {
		return boolValueEClass;
	}

	public EAttribute getBoolValue_Value() {
		return (EAttribute) boolValueEClass.getEStructuralFeatures().get(0);
	}

	public ImpFactory getImpFactory() {
		return (ImpFactory) getEFactoryInstance();
	}

	public void createPackageContents() {
		if (isCreated)
			return;
		isCreated = true;

		// Create classes and their features
		stmtEClass = createEClass(STMT);

		skipEClass = createEClass(SKIP);

		assignEClass = createEClass(ASSIGN);
		createEAttribute(assignEClass, ASSIGN__NAME);
		createEReference(assignEClass, ASSIGN__EXP);

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

		// Create enums
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

		// Initialize classes, features, and operations; add parameters
		initEClass(stmtEClass, Stmt.class, "Stmt", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(skipEClass, Skip.class, "Skip", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(assignEClass, Assign.class, "Assign", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAssign_Name(), ecorePackage.getEString(), "name", null, 0, 1, Assign.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAssign_Exp(), this.getExpr(), null, "exp", null, 1, 1, Assign.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(exprEClass, Expr.class, "Expr", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(blockEClass, Block.class, "Block", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBlock_Stmts(), this.getStmt(), null, "stmts", null, 0, -1, Block.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(ifEClass, If.class, "If", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getIf_Cond(), this.getExpr(), null, "cond", null, 1, 1, If.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIf_Lhs(), this.getStmt(), null, "lhs", null, 1, 1, If.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIf_Rhs(), this.getStmt(), null, "rhs", null, 1, 1, If.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(whileEClass, While.class, "While", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getWhile_Cond(), this.getExpr(), null, "cond", null, 1, 1, While.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getWhile_Body(), this.getStmt(), null, "body", null, 1, 1, While.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(intConstEClass, IntConst.class, "IntConst", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIntConst_Value(), ecorePackage.getEInt(), "value", null, 0, 1, IntConst.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(varEClass, Var.class, "Var", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getVar_Name(), ecorePackage.getEString(), "name", null, 0, 1, Var.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(unaryEClass, Unary.class, "Unary", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getUnary_Op(), this.getUnaryOp(), "op", null, 0, 1, Unary.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getUnary_Expr(), this.getExpr(), null, "expr", null, 1, 1, Unary.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(binaryEClass, Binary.class, "Binary", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBinary_Lhs(), this.getExpr(), null, "lhs", null, 1, 1, Binary.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBinary_Rhs(), this.getExpr(), null, "rhs", null, 1, 1, Binary.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBinary_Op(), this.getBinaryOp(), "op", null, 0, 1, Binary.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(storeEClass, Store.class, "Store", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getStore_Values(), this.getStringToValueMap(), null, "values", null, 0, -1, Store.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(stringToValueMapEClass, Entry.class, "StringToValueMap", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getStringToValueMap_Key(), ecorePackage.getEString(), "key", null, 0, 1, Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStringToValueMap_Value(), this.getValue(), null, "value", null, 1, 1, Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(valueEClass, Value.class, "Value", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(intValueEClass, IntValue.class, "IntValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIntValue_Value(), ecorePackage.getEInt(), "value", null, 0, 1, IntValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(boolValueEClass, BoolValue.class, "BoolValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getBoolValue_Value(), ecorePackage.getEBoolean(), "value", null, 0, 1, BoolValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(unaryOpEEnum, UnaryOp.class, "UnaryOp");
		addEEnumLiteral(unaryOpEEnum, UnaryOp.NEGATE);
		addEEnumLiteral(unaryOpEEnum, UnaryOp.NOT);
		initEEnum(binaryOpEEnum, BinaryOp.class, "BinaryOp");
		addEEnumLiteral(binaryOpEEnum, BinaryOp.ADD);
		addEEnumLiteral(binaryOpEEnum, BinaryOp.SUB);
		addEEnumLiteral(binaryOpEEnum, BinaryOp.MUL);
		addEEnumLiteral(binaryOpEEnum, BinaryOp.LT);
		addEEnumLiteral(binaryOpEEnum, BinaryOp.LEQ);
		addEEnumLiteral(binaryOpEEnum, BinaryOp.EQ);
		addEEnumLiteral(binaryOpEEnum, BinaryOp.GEQ);
		addEEnumLiteral(binaryOpEEnum, BinaryOp.GT);
		addEEnumLiteral(binaryOpEEnum, BinaryOp.AND);
		addEEnumLiteral(binaryOpEEnum, BinaryOp.OR);

		// Create resource
		createResource(eNS_URI);
	}
}
