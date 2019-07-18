package miniJava.interpreter.miniJava.impl;

import java.util.Map.Entry;
import miniJava.interpreter.miniJava.AccessLevel;
import miniJava.interpreter.miniJava.MiniJavaFactory;
import miniJava.interpreter.miniJava.MiniJavaPackage;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;

public class MiniJavaPackageImpl extends EPackageImpl implements MiniJavaPackage {
	private static boolean isInited = false;

	private EClass programEClass = null;

	private EClass importEClass = null;

	private EClass typeDeclarationEClass = null;

	private EClass clazzEClass = null;

	private EClass interfaceEClass = null;

	private EClass memberEClass = null;

	private EClass methodEClass = null;

	private EClass parameterEClass = null;

	private EClass fieldEClass = null;

	private EEnum accessLevelEEnum = null;

	private EClass blockEClass = null;

	private EClass statementEClass = null;

	private EClass printStatementEClass = null;

	private EClass returnEClass = null;

	private EClass ifStatementEClass = null;

	private EClass whileStatementEClass = null;

	private EClass forStatementEClass = null;

	private EClass typeRefEClass = null;

	private EClass singleTypeRefEClass = null;

	private EClass classRefEClass = null;

	private EClass namedElementEClass = null;

	private EClass typedDeclarationEClass = null;

	private EClass symbolEClass = null;

	private EClass variableDeclarationEClass = null;

	private EClass assignmentEClass = null;

	private EClass assigneeEClass = null;

	private EClass expressionEClass = null;

	private EClass arrayTypeRefEClass = null;

	private EClass integerTypeRefEClass = null;

	private EClass booleanTypeRefEClass = null;

	private EClass stringTypeRefEClass = null;

	private EClass voidTypeRefEClass = null;

	private EClass orEClass = null;

	private EClass andEClass = null;

	private EClass equalityEClass = null;

	private EClass inequalityEClass = null;

	private EClass superiorOrEqualEClass = null;

	private EClass inferiorOrEqualEClass = null;

	private EClass superiorEClass = null;

	private EClass inferiorEClass = null;

	private EClass plusEClass = null;

	private EClass minusEClass = null;

	private EClass multiplicationEClass = null;

	private EClass divisionEClass = null;

	private EClass arrayAccessEClass = null;

	private EClass arrayLengthEClass = null;

	private EClass notEClass = null;

	private EClass negEClass = null;

	private EClass fieldAccessEClass = null;

	private EClass methodCallEClass = null;

	private EClass stringConstantEClass = null;

	private EClass intConstantEClass = null;

	private EClass boolConstantEClass = null;

	private EClass thisEClass = null;

	private EClass superEClass = null;

	private EClass nullEClass = null;

	private EClass newObjectEClass = null;

	private EClass newArrayEClass = null;

	private EClass symbolRefEClass = null;

	private EClass contextEClass = null;

	private EClass valueEClass = null;

	private EClass integerValueEClass = null;

	private EClass symbolBindingEClass = null;

	private EClass fieldBindingEClass = null;

	private EClass stringValueEClass = null;

	private EClass booleanValueEClass = null;

	private EClass outputStreamEClass = null;

	private EClass stateEClass = null;

	private EClass frameEClass = null;

	private EClass nullValueEClass = null;

	private EClass callEClass = null;

	private EClass newCallEClass = null;

	private EClass methodCall2EClass = null;

	private EClass objectInstanceEClass = null;

	private EClass arrayInstanceEClass = null;

	private EClass objectRefValueEClass = null;

	private EClass arrayRefValueEClass = null;

	private EClass symbolToSymbolBindingMapEClass = null;

	private EClass clazzToMethodMapEClass = null;

	private EClass moduloEClass = null;

	private boolean isCreated = false;

	private boolean isInitialized = false;

	private MiniJavaPackageImpl() {
		super(eNS_URI, MiniJavaFactory.eINSTANCE);
	}

	public static MiniJavaPackage init() {
		if (isInited)
			return (MiniJavaPackage) EPackage.Registry.INSTANCE.getEPackage(MiniJavaPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredMiniJavaPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		MiniJavaPackageImpl theMiniJavaPackage = registeredMiniJavaPackage instanceof MiniJavaPackageImpl
				? (MiniJavaPackageImpl) registeredMiniJavaPackage
				: new MiniJavaPackageImpl();

		isInited = true;

		// Create package meta-data objects
		theMiniJavaPackage.createPackageContents();

		// Initialize created meta-data
		theMiniJavaPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theMiniJavaPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(MiniJavaPackage.eNS_URI, theMiniJavaPackage);
		return theMiniJavaPackage;
	}

	public EClass getProgram() {
		return programEClass;
	}

	public EAttribute getProgram_Name() {
		return (EAttribute) programEClass.getEStructuralFeatures().get(0);
	}

	public EReference getProgram_Imports() {
		return (EReference) programEClass.getEStructuralFeatures().get(1);
	}

	public EReference getProgram_Classes() {
		return (EReference) programEClass.getEStructuralFeatures().get(2);
	}

	public EReference getProgram_State() {
		return (EReference) programEClass.getEStructuralFeatures().get(3);
	}

	public EClass getImport() {
		return importEClass;
	}

	public EAttribute getImport_ImportedNamespace() {
		return (EAttribute) importEClass.getEStructuralFeatures().get(0);
	}

	public EClass getTypeDeclaration() {
		return typeDeclarationEClass;
	}

	public EAttribute getTypeDeclaration_AccessLevel() {
		return (EAttribute) typeDeclarationEClass.getEStructuralFeatures().get(0);
	}

	public EReference getTypeDeclaration_Implementz() {
		return (EReference) typeDeclarationEClass.getEStructuralFeatures().get(1);
	}

	public EReference getTypeDeclaration_Members() {
		return (EReference) typeDeclarationEClass.getEStructuralFeatures().get(2);
	}

	public EClass getClazz() {
		return clazzEClass;
	}

	public EAttribute getClazz_Isabstract() {
		return (EAttribute) clazzEClass.getEStructuralFeatures().get(0);
	}

	public EReference getClazz_SuperClass() {
		return (EReference) clazzEClass.getEStructuralFeatures().get(1);
	}

	public EClass getInterface() {
		return interfaceEClass;
	}

	public EClass getMember() {
		return memberEClass;
	}

	public EAttribute getMember_Access() {
		return (EAttribute) memberEClass.getEStructuralFeatures().get(0);
	}

	public EClass getMethod() {
		return methodEClass;
	}

	public EAttribute getMethod_Isabstract() {
		return (EAttribute) methodEClass.getEStructuralFeatures().get(0);
	}

	public EAttribute getMethod_Isstatic() {
		return (EAttribute) methodEClass.getEStructuralFeatures().get(1);
	}

	public EReference getMethod_Params() {
		return (EReference) methodEClass.getEStructuralFeatures().get(2);
	}

	public EReference getMethod_Body() {
		return (EReference) methodEClass.getEStructuralFeatures().get(3);
	}

	public EReference getMethod_Cache() {
		return (EReference) methodEClass.getEStructuralFeatures().get(4);
	}

	public EClass getParameter() {
		return parameterEClass;
	}

	public EClass getField() {
		return fieldEClass;
	}

	public EReference getField_DefaultValue() {
		return (EReference) fieldEClass.getEStructuralFeatures().get(0);
	}

	public EEnum getAccessLevel() {
		return accessLevelEEnum;
	}

	public EClass getBlock() {
		return blockEClass;
	}

	public EReference getBlock_Statements() {
		return (EReference) blockEClass.getEStructuralFeatures().get(0);
	}

	public EClass getStatement() {
		return statementEClass;
	}

	public EClass getPrintStatement() {
		return printStatementEClass;
	}

	public EReference getPrintStatement_Expression() {
		return (EReference) printStatementEClass.getEStructuralFeatures().get(0);
	}

	public EClass getReturn() {
		return returnEClass;
	}

	public EReference getReturn_Expression() {
		return (EReference) returnEClass.getEStructuralFeatures().get(0);
	}

	public EClass getIfStatement() {
		return ifStatementEClass;
	}

	public EReference getIfStatement_Expression() {
		return (EReference) ifStatementEClass.getEStructuralFeatures().get(0);
	}

	public EReference getIfStatement_ThenBlock() {
		return (EReference) ifStatementEClass.getEStructuralFeatures().get(1);
	}

	public EReference getIfStatement_ElseBlock() {
		return (EReference) ifStatementEClass.getEStructuralFeatures().get(2);
	}

	public EClass getWhileStatement() {
		return whileStatementEClass;
	}

	public EReference getWhileStatement_Condition() {
		return (EReference) whileStatementEClass.getEStructuralFeatures().get(0);
	}

	public EReference getWhileStatement_Block() {
		return (EReference) whileStatementEClass.getEStructuralFeatures().get(1);
	}

	public EClass getForStatement() {
		return forStatementEClass;
	}

	public EReference getForStatement_Declaration() {
		return (EReference) forStatementEClass.getEStructuralFeatures().get(0);
	}

	public EReference getForStatement_Condition() {
		return (EReference) forStatementEClass.getEStructuralFeatures().get(1);
	}

	public EReference getForStatement_Progression() {
		return (EReference) forStatementEClass.getEStructuralFeatures().get(2);
	}

	public EReference getForStatement_Block() {
		return (EReference) forStatementEClass.getEStructuralFeatures().get(3);
	}

	public EClass getTypeRef() {
		return typeRefEClass;
	}

	public EClass getSingleTypeRef() {
		return singleTypeRefEClass;
	}

	public EClass getClassRef() {
		return classRefEClass;
	}

	public EReference getClassRef_ReferencedClass() {
		return (EReference) classRefEClass.getEStructuralFeatures().get(0);
	}

	public EClass getNamedElement() {
		return namedElementEClass;
	}

	public EAttribute getNamedElement_Name() {
		return (EAttribute) namedElementEClass.getEStructuralFeatures().get(0);
	}

	public EClass getTypedDeclaration() {
		return typedDeclarationEClass;
	}

	public EReference getTypedDeclaration_TypeRef() {
		return (EReference) typedDeclarationEClass.getEStructuralFeatures().get(0);
	}

	public EClass getSymbol() {
		return symbolEClass;
	}

	public EClass getVariableDeclaration() {
		return variableDeclarationEClass;
	}

	public EClass getAssignment() {
		return assignmentEClass;
	}

	public EReference getAssignment_Assignee() {
		return (EReference) assignmentEClass.getEStructuralFeatures().get(0);
	}

	public EReference getAssignment_Value() {
		return (EReference) assignmentEClass.getEStructuralFeatures().get(1);
	}

	public EClass getAssignee() {
		return assigneeEClass;
	}

	public EClass getExpression() {
		return expressionEClass;
	}

	public EClass getArrayTypeRef() {
		return arrayTypeRefEClass;
	}

	public EReference getArrayTypeRef_TypeRef() {
		return (EReference) arrayTypeRefEClass.getEStructuralFeatures().get(0);
	}

	public EClass getIntegerTypeRef() {
		return integerTypeRefEClass;
	}

	public EClass getBooleanTypeRef() {
		return booleanTypeRefEClass;
	}

	public EClass getStringTypeRef() {
		return stringTypeRefEClass;
	}

	public EClass getVoidTypeRef() {
		return voidTypeRefEClass;
	}

	public EClass getOr() {
		return orEClass;
	}

	public EReference getOr_Left() {
		return (EReference) orEClass.getEStructuralFeatures().get(0);
	}

	public EReference getOr_Right() {
		return (EReference) orEClass.getEStructuralFeatures().get(1);
	}

	public EClass getAnd() {
		return andEClass;
	}

	public EReference getAnd_Left() {
		return (EReference) andEClass.getEStructuralFeatures().get(0);
	}

	public EReference getAnd_Right() {
		return (EReference) andEClass.getEStructuralFeatures().get(1);
	}

	public EClass getEquality() {
		return equalityEClass;
	}

	public EReference getEquality_Left() {
		return (EReference) equalityEClass.getEStructuralFeatures().get(0);
	}

	public EReference getEquality_Right() {
		return (EReference) equalityEClass.getEStructuralFeatures().get(1);
	}

	public EClass getInequality() {
		return inequalityEClass;
	}

	public EReference getInequality_Left() {
		return (EReference) inequalityEClass.getEStructuralFeatures().get(0);
	}

	public EReference getInequality_Right() {
		return (EReference) inequalityEClass.getEStructuralFeatures().get(1);
	}

	public EClass getSuperiorOrEqual() {
		return superiorOrEqualEClass;
	}

	public EReference getSuperiorOrEqual_Left() {
		return (EReference) superiorOrEqualEClass.getEStructuralFeatures().get(0);
	}

	public EReference getSuperiorOrEqual_Right() {
		return (EReference) superiorOrEqualEClass.getEStructuralFeatures().get(1);
	}

	public EClass getInferiorOrEqual() {
		return inferiorOrEqualEClass;
	}

	public EReference getInferiorOrEqual_Left() {
		return (EReference) inferiorOrEqualEClass.getEStructuralFeatures().get(0);
	}

	public EReference getInferiorOrEqual_Right() {
		return (EReference) inferiorOrEqualEClass.getEStructuralFeatures().get(1);
	}

	public EClass getSuperior() {
		return superiorEClass;
	}

	public EReference getSuperior_Left() {
		return (EReference) superiorEClass.getEStructuralFeatures().get(0);
	}

	public EReference getSuperior_Right() {
		return (EReference) superiorEClass.getEStructuralFeatures().get(1);
	}

	public EClass getInferior() {
		return inferiorEClass;
	}

	public EReference getInferior_Left() {
		return (EReference) inferiorEClass.getEStructuralFeatures().get(0);
	}

	public EReference getInferior_Right() {
		return (EReference) inferiorEClass.getEStructuralFeatures().get(1);
	}

	public EClass getPlus() {
		return plusEClass;
	}

	public EReference getPlus_Left() {
		return (EReference) plusEClass.getEStructuralFeatures().get(0);
	}

	public EReference getPlus_Right() {
		return (EReference) plusEClass.getEStructuralFeatures().get(1);
	}

	public EClass getMinus() {
		return minusEClass;
	}

	public EReference getMinus_Left() {
		return (EReference) minusEClass.getEStructuralFeatures().get(0);
	}

	public EReference getMinus_Right() {
		return (EReference) minusEClass.getEStructuralFeatures().get(1);
	}

	public EClass getMultiplication() {
		return multiplicationEClass;
	}

	public EReference getMultiplication_Left() {
		return (EReference) multiplicationEClass.getEStructuralFeatures().get(0);
	}

	public EReference getMultiplication_Right() {
		return (EReference) multiplicationEClass.getEStructuralFeatures().get(1);
	}

	public EClass getDivision() {
		return divisionEClass;
	}

	public EReference getDivision_Left() {
		return (EReference) divisionEClass.getEStructuralFeatures().get(0);
	}

	public EReference getDivision_Right() {
		return (EReference) divisionEClass.getEStructuralFeatures().get(1);
	}

	public EClass getArrayAccess() {
		return arrayAccessEClass;
	}

	public EReference getArrayAccess_Object() {
		return (EReference) arrayAccessEClass.getEStructuralFeatures().get(0);
	}

	public EReference getArrayAccess_Index() {
		return (EReference) arrayAccessEClass.getEStructuralFeatures().get(1);
	}

	public EClass getArrayLength() {
		return arrayLengthEClass;
	}

	public EReference getArrayLength_Array() {
		return (EReference) arrayLengthEClass.getEStructuralFeatures().get(0);
	}

	public EClass getNot() {
		return notEClass;
	}

	public EReference getNot_Expression() {
		return (EReference) notEClass.getEStructuralFeatures().get(0);
	}

	public EClass getNeg() {
		return negEClass;
	}

	public EReference getNeg_Expression() {
		return (EReference) negEClass.getEStructuralFeatures().get(0);
	}

	public EClass getFieldAccess() {
		return fieldAccessEClass;
	}

	public EReference getFieldAccess_Receiver() {
		return (EReference) fieldAccessEClass.getEStructuralFeatures().get(0);
	}

	public EReference getFieldAccess_Field() {
		return (EReference) fieldAccessEClass.getEStructuralFeatures().get(1);
	}

	public EClass getMethodCall() {
		return methodCallEClass;
	}

	public EReference getMethodCall_Receiver() {
		return (EReference) methodCallEClass.getEStructuralFeatures().get(0);
	}

	public EReference getMethodCall_Method() {
		return (EReference) methodCallEClass.getEStructuralFeatures().get(1);
	}

	public EReference getMethodCall_Args() {
		return (EReference) methodCallEClass.getEStructuralFeatures().get(2);
	}

	public EClass getStringConstant() {
		return stringConstantEClass;
	}

	public EAttribute getStringConstant_Value() {
		return (EAttribute) stringConstantEClass.getEStructuralFeatures().get(0);
	}

	public EClass getIntConstant() {
		return intConstantEClass;
	}

	public EAttribute getIntConstant_Value() {
		return (EAttribute) intConstantEClass.getEStructuralFeatures().get(0);
	}

	public EClass getBoolConstant() {
		return boolConstantEClass;
	}

	public EAttribute getBoolConstant_Value() {
		return (EAttribute) boolConstantEClass.getEStructuralFeatures().get(0);
	}

	public EClass getThis() {
		return thisEClass;
	}

	public EClass getSuper() {
		return superEClass;
	}

	public EClass getNull() {
		return nullEClass;
	}

	public EClass getNewObject() {
		return newObjectEClass;
	}

	public EReference getNewObject_Type() {
		return (EReference) newObjectEClass.getEStructuralFeatures().get(0);
	}

	public EReference getNewObject_Args() {
		return (EReference) newObjectEClass.getEStructuralFeatures().get(1);
	}

	public EClass getNewArray() {
		return newArrayEClass;
	}

	public EReference getNewArray_Type() {
		return (EReference) newArrayEClass.getEStructuralFeatures().get(0);
	}

	public EReference getNewArray_Size() {
		return (EReference) newArrayEClass.getEStructuralFeatures().get(1);
	}

	public EClass getSymbolRef() {
		return symbolRefEClass;
	}

	public EReference getSymbolRef_Symbol() {
		return (EReference) symbolRefEClass.getEStructuralFeatures().get(0);
	}

	public EClass getContext() {
		return contextEClass;
	}

	public EReference getContext_Bindings() {
		return (EReference) contextEClass.getEStructuralFeatures().get(0);
	}

	public EReference getContext_ParentContext() {
		return (EReference) contextEClass.getEStructuralFeatures().get(1);
	}

	public EReference getContext_ChildContext() {
		return (EReference) contextEClass.getEStructuralFeatures().get(2);
	}

	public EReference getContext_Cache() {
		return (EReference) contextEClass.getEStructuralFeatures().get(3);
	}

	public EClass getValue() {
		return valueEClass;
	}

	public EClass getIntegerValue() {
		return integerValueEClass;
	}

	public EAttribute getIntegerValue_Value() {
		return (EAttribute) integerValueEClass.getEStructuralFeatures().get(0);
	}

	public EClass getSymbolBinding() {
		return symbolBindingEClass;
	}

	public EReference getSymbolBinding_Value() {
		return (EReference) symbolBindingEClass.getEStructuralFeatures().get(0);
	}

	public EReference getSymbolBinding_Symbol() {
		return (EReference) symbolBindingEClass.getEStructuralFeatures().get(1);
	}

	public EClass getFieldBinding() {
		return fieldBindingEClass;
	}

	public EReference getFieldBinding_Field() {
		return (EReference) fieldBindingEClass.getEStructuralFeatures().get(0);
	}

	public EReference getFieldBinding_Value() {
		return (EReference) fieldBindingEClass.getEStructuralFeatures().get(1);
	}

	public EClass getStringValue() {
		return stringValueEClass;
	}

	public EAttribute getStringValue_Value() {
		return (EAttribute) stringValueEClass.getEStructuralFeatures().get(0);
	}

	public EClass getBooleanValue() {
		return booleanValueEClass;
	}

	public EAttribute getBooleanValue_Value() {
		return (EAttribute) booleanValueEClass.getEStructuralFeatures().get(0);
	}

	public EClass getOutputStream() {
		return outputStreamEClass;
	}

	public EAttribute getOutputStream_Stream() {
		return (EAttribute) outputStreamEClass.getEStructuralFeatures().get(0);
	}

	public EClass getState() {
		return stateEClass;
	}

	public EReference getState_RootFrame() {
		return (EReference) stateEClass.getEStructuralFeatures().get(0);
	}

	public EReference getState_ObjectsHeap() {
		return (EReference) stateEClass.getEStructuralFeatures().get(1);
	}

	public EReference getState_OutputStream() {
		return (EReference) stateEClass.getEStructuralFeatures().get(2);
	}

	public EReference getState_ArraysHeap() {
		return (EReference) stateEClass.getEStructuralFeatures().get(3);
	}

	public EReference getState_ContextCache() {
		return (EReference) stateEClass.getEStructuralFeatures().get(4);
	}

	public EReference getState_FrameCache() {
		return (EReference) stateEClass.getEStructuralFeatures().get(5);
	}

	public EClass getFrame() {
		return frameEClass;
	}

	public EReference getFrame_Call() {
		return (EReference) frameEClass.getEStructuralFeatures().get(0);
	}

	public EReference getFrame_Instance() {
		return (EReference) frameEClass.getEStructuralFeatures().get(1);
	}

	public EReference getFrame_ChildFrame() {
		return (EReference) frameEClass.getEStructuralFeatures().get(2);
	}

	public EReference getFrame_ParentFrame() {
		return (EReference) frameEClass.getEStructuralFeatures().get(3);
	}

	public EReference getFrame_RootContext() {
		return (EReference) frameEClass.getEStructuralFeatures().get(4);
	}

	public EReference getFrame_ReturnValue() {
		return (EReference) frameEClass.getEStructuralFeatures().get(5);
	}

	public EClass getNullValue() {
		return nullValueEClass;
	}

	public EClass getCall() {
		return callEClass;
	}

	public EClass getNewCall() {
		return newCallEClass;
	}

	public EReference getNewCall_Newz() {
		return (EReference) newCallEClass.getEStructuralFeatures().get(0);
	}

	public EClass getMethodCall2() {
		return methodCall2EClass;
	}

	public EReference getMethodCall2_Methodcall() {
		return (EReference) methodCall2EClass.getEStructuralFeatures().get(0);
	}

	public EClass getObjectInstance() {
		return objectInstanceEClass;
	}

	public EReference getObjectInstance_Fieldbindings() {
		return (EReference) objectInstanceEClass.getEStructuralFeatures().get(0);
	}

	public EReference getObjectInstance_Type() {
		return (EReference) objectInstanceEClass.getEStructuralFeatures().get(1);
	}

	public EClass getArrayInstance() {
		return arrayInstanceEClass;
	}

	public EReference getArrayInstance_Value() {
		return (EReference) arrayInstanceEClass.getEStructuralFeatures().get(0);
	}

	public EAttribute getArrayInstance_Size() {
		return (EAttribute) arrayInstanceEClass.getEStructuralFeatures().get(1);
	}

	public EClass getObjectRefValue() {
		return objectRefValueEClass;
	}

	public EReference getObjectRefValue_Instance() {
		return (EReference) objectRefValueEClass.getEStructuralFeatures().get(0);
	}

	public EClass getArrayRefValue() {
		return arrayRefValueEClass;
	}

	public EReference getArrayRefValue_Instance() {
		return (EReference) arrayRefValueEClass.getEStructuralFeatures().get(0);
	}

	public EClass getSymbolToSymbolBindingMap() {
		return symbolToSymbolBindingMapEClass;
	}

	public EReference getSymbolToSymbolBindingMap_Key() {
		return (EReference) symbolToSymbolBindingMapEClass.getEStructuralFeatures().get(0);
	}

	public EReference getSymbolToSymbolBindingMap_Value() {
		return (EReference) symbolToSymbolBindingMapEClass.getEStructuralFeatures().get(1);
	}

	public EClass getClazzToMethodMap() {
		return clazzToMethodMapEClass;
	}

	public EReference getClazzToMethodMap_Key() {
		return (EReference) clazzToMethodMapEClass.getEStructuralFeatures().get(0);
	}

	public EReference getClazzToMethodMap_Value() {
		return (EReference) clazzToMethodMapEClass.getEStructuralFeatures().get(1);
	}

	public EClass getModulo() {
		return moduloEClass;
	}

	public EReference getModulo_Left() {
		return (EReference) moduloEClass.getEStructuralFeatures().get(0);
	}

	public EReference getModulo_Right() {
		return (EReference) moduloEClass.getEStructuralFeatures().get(1);
	}

	public MiniJavaFactory getMiniJavaFactory() {
		return (MiniJavaFactory) getEFactoryInstance();
	}

	public void createPackageContents() {
		if (isCreated)
			return;
		isCreated = true;

		// Create classes and their features
		programEClass = createEClass(PROGRAM);
		createEAttribute(programEClass, PROGRAM__NAME);
		createEReference(programEClass, PROGRAM__IMPORTS);
		createEReference(programEClass, PROGRAM__CLASSES);
		createEReference(programEClass, PROGRAM__STATE);

		importEClass = createEClass(IMPORT);
		createEAttribute(importEClass, IMPORT__IMPORTED_NAMESPACE);

		typeDeclarationEClass = createEClass(TYPE_DECLARATION);
		createEAttribute(typeDeclarationEClass, TYPE_DECLARATION__ACCESS_LEVEL);
		createEReference(typeDeclarationEClass, TYPE_DECLARATION__IMPLEMENTZ);
		createEReference(typeDeclarationEClass, TYPE_DECLARATION__MEMBERS);

		clazzEClass = createEClass(CLAZZ);
		createEAttribute(clazzEClass, CLAZZ__ISABSTRACT);
		createEReference(clazzEClass, CLAZZ__SUPER_CLASS);

		interfaceEClass = createEClass(INTERFACE);

		memberEClass = createEClass(MEMBER);
		createEAttribute(memberEClass, MEMBER__ACCESS);

		methodEClass = createEClass(METHOD);
		createEAttribute(methodEClass, METHOD__ISABSTRACT);
		createEAttribute(methodEClass, METHOD__ISSTATIC);
		createEReference(methodEClass, METHOD__PARAMS);
		createEReference(methodEClass, METHOD__BODY);
		createEReference(methodEClass, METHOD__CACHE);

		parameterEClass = createEClass(PARAMETER);

		fieldEClass = createEClass(FIELD);
		createEReference(fieldEClass, FIELD__DEFAULT_VALUE);

		blockEClass = createEClass(BLOCK);
		createEReference(blockEClass, BLOCK__STATEMENTS);

		statementEClass = createEClass(STATEMENT);

		printStatementEClass = createEClass(PRINT_STATEMENT);
		createEReference(printStatementEClass, PRINT_STATEMENT__EXPRESSION);

		returnEClass = createEClass(RETURN);
		createEReference(returnEClass, RETURN__EXPRESSION);

		ifStatementEClass = createEClass(IF_STATEMENT);
		createEReference(ifStatementEClass, IF_STATEMENT__EXPRESSION);
		createEReference(ifStatementEClass, IF_STATEMENT__THEN_BLOCK);
		createEReference(ifStatementEClass, IF_STATEMENT__ELSE_BLOCK);

		whileStatementEClass = createEClass(WHILE_STATEMENT);
		createEReference(whileStatementEClass, WHILE_STATEMENT__CONDITION);
		createEReference(whileStatementEClass, WHILE_STATEMENT__BLOCK);

		forStatementEClass = createEClass(FOR_STATEMENT);
		createEReference(forStatementEClass, FOR_STATEMENT__DECLARATION);
		createEReference(forStatementEClass, FOR_STATEMENT__CONDITION);
		createEReference(forStatementEClass, FOR_STATEMENT__PROGRESSION);
		createEReference(forStatementEClass, FOR_STATEMENT__BLOCK);

		typeRefEClass = createEClass(TYPE_REF);

		singleTypeRefEClass = createEClass(SINGLE_TYPE_REF);

		classRefEClass = createEClass(CLASS_REF);
		createEReference(classRefEClass, CLASS_REF__REFERENCED_CLASS);

		namedElementEClass = createEClass(NAMED_ELEMENT);
		createEAttribute(namedElementEClass, NAMED_ELEMENT__NAME);

		typedDeclarationEClass = createEClass(TYPED_DECLARATION);
		createEReference(typedDeclarationEClass, TYPED_DECLARATION__TYPE_REF);

		symbolEClass = createEClass(SYMBOL);

		variableDeclarationEClass = createEClass(VARIABLE_DECLARATION);

		assignmentEClass = createEClass(ASSIGNMENT);
		createEReference(assignmentEClass, ASSIGNMENT__ASSIGNEE);
		createEReference(assignmentEClass, ASSIGNMENT__VALUE);

		assigneeEClass = createEClass(ASSIGNEE);

		expressionEClass = createEClass(EXPRESSION);

		arrayTypeRefEClass = createEClass(ARRAY_TYPE_REF);
		createEReference(arrayTypeRefEClass, ARRAY_TYPE_REF__TYPE_REF);

		integerTypeRefEClass = createEClass(INTEGER_TYPE_REF);

		booleanTypeRefEClass = createEClass(BOOLEAN_TYPE_REF);

		stringTypeRefEClass = createEClass(STRING_TYPE_REF);

		voidTypeRefEClass = createEClass(VOID_TYPE_REF);

		orEClass = createEClass(OR);
		createEReference(orEClass, OR__LEFT);
		createEReference(orEClass, OR__RIGHT);

		andEClass = createEClass(AND);
		createEReference(andEClass, AND__LEFT);
		createEReference(andEClass, AND__RIGHT);

		equalityEClass = createEClass(EQUALITY);
		createEReference(equalityEClass, EQUALITY__LEFT);
		createEReference(equalityEClass, EQUALITY__RIGHT);

		inequalityEClass = createEClass(INEQUALITY);
		createEReference(inequalityEClass, INEQUALITY__LEFT);
		createEReference(inequalityEClass, INEQUALITY__RIGHT);

		superiorOrEqualEClass = createEClass(SUPERIOR_OR_EQUAL);
		createEReference(superiorOrEqualEClass, SUPERIOR_OR_EQUAL__LEFT);
		createEReference(superiorOrEqualEClass, SUPERIOR_OR_EQUAL__RIGHT);

		inferiorOrEqualEClass = createEClass(INFERIOR_OR_EQUAL);
		createEReference(inferiorOrEqualEClass, INFERIOR_OR_EQUAL__LEFT);
		createEReference(inferiorOrEqualEClass, INFERIOR_OR_EQUAL__RIGHT);

		superiorEClass = createEClass(SUPERIOR);
		createEReference(superiorEClass, SUPERIOR__LEFT);
		createEReference(superiorEClass, SUPERIOR__RIGHT);

		inferiorEClass = createEClass(INFERIOR);
		createEReference(inferiorEClass, INFERIOR__LEFT);
		createEReference(inferiorEClass, INFERIOR__RIGHT);

		plusEClass = createEClass(PLUS);
		createEReference(plusEClass, PLUS__LEFT);
		createEReference(plusEClass, PLUS__RIGHT);

		minusEClass = createEClass(MINUS);
		createEReference(minusEClass, MINUS__LEFT);
		createEReference(minusEClass, MINUS__RIGHT);

		multiplicationEClass = createEClass(MULTIPLICATION);
		createEReference(multiplicationEClass, MULTIPLICATION__LEFT);
		createEReference(multiplicationEClass, MULTIPLICATION__RIGHT);

		divisionEClass = createEClass(DIVISION);
		createEReference(divisionEClass, DIVISION__LEFT);
		createEReference(divisionEClass, DIVISION__RIGHT);

		arrayAccessEClass = createEClass(ARRAY_ACCESS);
		createEReference(arrayAccessEClass, ARRAY_ACCESS__OBJECT);
		createEReference(arrayAccessEClass, ARRAY_ACCESS__INDEX);

		arrayLengthEClass = createEClass(ARRAY_LENGTH);
		createEReference(arrayLengthEClass, ARRAY_LENGTH__ARRAY);

		notEClass = createEClass(NOT);
		createEReference(notEClass, NOT__EXPRESSION);

		negEClass = createEClass(NEG);
		createEReference(negEClass, NEG__EXPRESSION);

		fieldAccessEClass = createEClass(FIELD_ACCESS);
		createEReference(fieldAccessEClass, FIELD_ACCESS__RECEIVER);
		createEReference(fieldAccessEClass, FIELD_ACCESS__FIELD);

		methodCallEClass = createEClass(METHOD_CALL);
		createEReference(methodCallEClass, METHOD_CALL__RECEIVER);
		createEReference(methodCallEClass, METHOD_CALL__METHOD);
		createEReference(methodCallEClass, METHOD_CALL__ARGS);

		stringConstantEClass = createEClass(STRING_CONSTANT);
		createEAttribute(stringConstantEClass, STRING_CONSTANT__VALUE);

		intConstantEClass = createEClass(INT_CONSTANT);
		createEAttribute(intConstantEClass, INT_CONSTANT__VALUE);

		boolConstantEClass = createEClass(BOOL_CONSTANT);
		createEAttribute(boolConstantEClass, BOOL_CONSTANT__VALUE);

		thisEClass = createEClass(THIS);

		superEClass = createEClass(SUPER);

		nullEClass = createEClass(NULL);

		newObjectEClass = createEClass(NEW_OBJECT);
		createEReference(newObjectEClass, NEW_OBJECT__TYPE);
		createEReference(newObjectEClass, NEW_OBJECT__ARGS);

		newArrayEClass = createEClass(NEW_ARRAY);
		createEReference(newArrayEClass, NEW_ARRAY__TYPE);
		createEReference(newArrayEClass, NEW_ARRAY__SIZE);

		symbolRefEClass = createEClass(SYMBOL_REF);
		createEReference(symbolRefEClass, SYMBOL_REF__SYMBOL);

		contextEClass = createEClass(CONTEXT);
		createEReference(contextEClass, CONTEXT__BINDINGS);
		createEReference(contextEClass, CONTEXT__PARENT_CONTEXT);
		createEReference(contextEClass, CONTEXT__CHILD_CONTEXT);
		createEReference(contextEClass, CONTEXT__CACHE);

		valueEClass = createEClass(VALUE);

		integerValueEClass = createEClass(INTEGER_VALUE);
		createEAttribute(integerValueEClass, INTEGER_VALUE__VALUE);

		symbolBindingEClass = createEClass(SYMBOL_BINDING);
		createEReference(symbolBindingEClass, SYMBOL_BINDING__VALUE);
		createEReference(symbolBindingEClass, SYMBOL_BINDING__SYMBOL);

		fieldBindingEClass = createEClass(FIELD_BINDING);
		createEReference(fieldBindingEClass, FIELD_BINDING__FIELD);
		createEReference(fieldBindingEClass, FIELD_BINDING__VALUE);

		stringValueEClass = createEClass(STRING_VALUE);
		createEAttribute(stringValueEClass, STRING_VALUE__VALUE);

		booleanValueEClass = createEClass(BOOLEAN_VALUE);
		createEAttribute(booleanValueEClass, BOOLEAN_VALUE__VALUE);

		outputStreamEClass = createEClass(OUTPUT_STREAM);
		createEAttribute(outputStreamEClass, OUTPUT_STREAM__STREAM);

		stateEClass = createEClass(STATE);
		createEReference(stateEClass, STATE__ROOT_FRAME);
		createEReference(stateEClass, STATE__OBJECTS_HEAP);
		createEReference(stateEClass, STATE__OUTPUT_STREAM);
		createEReference(stateEClass, STATE__ARRAYS_HEAP);
		createEReference(stateEClass, STATE__CONTEXT_CACHE);
		createEReference(stateEClass, STATE__FRAME_CACHE);

		frameEClass = createEClass(FRAME);
		createEReference(frameEClass, FRAME__CALL);
		createEReference(frameEClass, FRAME__INSTANCE);
		createEReference(frameEClass, FRAME__CHILD_FRAME);
		createEReference(frameEClass, FRAME__PARENT_FRAME);
		createEReference(frameEClass, FRAME__ROOT_CONTEXT);
		createEReference(frameEClass, FRAME__RETURN_VALUE);

		nullValueEClass = createEClass(NULL_VALUE);

		callEClass = createEClass(CALL);

		newCallEClass = createEClass(NEW_CALL);
		createEReference(newCallEClass, NEW_CALL__NEWZ);

		methodCall2EClass = createEClass(METHOD_CALL2);
		createEReference(methodCall2EClass, METHOD_CALL2__METHODCALL);

		objectInstanceEClass = createEClass(OBJECT_INSTANCE);
		createEReference(objectInstanceEClass, OBJECT_INSTANCE__FIELDBINDINGS);
		createEReference(objectInstanceEClass, OBJECT_INSTANCE__TYPE);

		arrayInstanceEClass = createEClass(ARRAY_INSTANCE);
		createEReference(arrayInstanceEClass, ARRAY_INSTANCE__VALUE);
		createEAttribute(arrayInstanceEClass, ARRAY_INSTANCE__SIZE);

		objectRefValueEClass = createEClass(OBJECT_REF_VALUE);
		createEReference(objectRefValueEClass, OBJECT_REF_VALUE__INSTANCE);

		arrayRefValueEClass = createEClass(ARRAY_REF_VALUE);
		createEReference(arrayRefValueEClass, ARRAY_REF_VALUE__INSTANCE);

		symbolToSymbolBindingMapEClass = createEClass(SYMBOL_TO_SYMBOL_BINDING_MAP);
		createEReference(symbolToSymbolBindingMapEClass, SYMBOL_TO_SYMBOL_BINDING_MAP__KEY);
		createEReference(symbolToSymbolBindingMapEClass, SYMBOL_TO_SYMBOL_BINDING_MAP__VALUE);

		clazzToMethodMapEClass = createEClass(CLAZZ_TO_METHOD_MAP);
		createEReference(clazzToMethodMapEClass, CLAZZ_TO_METHOD_MAP__KEY);
		createEReference(clazzToMethodMapEClass, CLAZZ_TO_METHOD_MAP__VALUE);

		moduloEClass = createEClass(MODULO);
		createEReference(moduloEClass, MODULO__LEFT);
		createEReference(moduloEClass, MODULO__RIGHT);

		// Create enums
		accessLevelEEnum = createEEnum(ACCESS_LEVEL);
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
		typeDeclarationEClass.getESuperTypes().add(this.getNamedElement());
		clazzEClass.getESuperTypes().add(this.getTypeDeclaration());
		interfaceEClass.getESuperTypes().add(this.getTypeDeclaration());
		memberEClass.getESuperTypes().add(this.getTypedDeclaration());
		methodEClass.getESuperTypes().add(this.getMember());
		parameterEClass.getESuperTypes().add(this.getSymbol());
		fieldEClass.getESuperTypes().add(this.getMember());
		blockEClass.getESuperTypes().add(this.getStatement());
		printStatementEClass.getESuperTypes().add(this.getStatement());
		returnEClass.getESuperTypes().add(this.getStatement());
		ifStatementEClass.getESuperTypes().add(this.getStatement());
		whileStatementEClass.getESuperTypes().add(this.getStatement());
		forStatementEClass.getESuperTypes().add(this.getStatement());
		singleTypeRefEClass.getESuperTypes().add(this.getTypeRef());
		classRefEClass.getESuperTypes().add(this.getSingleTypeRef());
		typedDeclarationEClass.getESuperTypes().add(this.getNamedElement());
		symbolEClass.getESuperTypes().add(this.getTypedDeclaration());
		variableDeclarationEClass.getESuperTypes().add(this.getSymbol());
		variableDeclarationEClass.getESuperTypes().add(this.getAssignee());
		assignmentEClass.getESuperTypes().add(this.getStatement());
		expressionEClass.getESuperTypes().add(this.getStatement());
		expressionEClass.getESuperTypes().add(this.getAssignee());
		arrayTypeRefEClass.getESuperTypes().add(this.getTypeRef());
		integerTypeRefEClass.getESuperTypes().add(this.getSingleTypeRef());
		booleanTypeRefEClass.getESuperTypes().add(this.getSingleTypeRef());
		stringTypeRefEClass.getESuperTypes().add(this.getSingleTypeRef());
		voidTypeRefEClass.getESuperTypes().add(this.getSingleTypeRef());
		orEClass.getESuperTypes().add(this.getExpression());
		andEClass.getESuperTypes().add(this.getExpression());
		equalityEClass.getESuperTypes().add(this.getExpression());
		inequalityEClass.getESuperTypes().add(this.getExpression());
		superiorOrEqualEClass.getESuperTypes().add(this.getExpression());
		inferiorOrEqualEClass.getESuperTypes().add(this.getExpression());
		superiorEClass.getESuperTypes().add(this.getExpression());
		inferiorEClass.getESuperTypes().add(this.getExpression());
		plusEClass.getESuperTypes().add(this.getExpression());
		minusEClass.getESuperTypes().add(this.getExpression());
		multiplicationEClass.getESuperTypes().add(this.getExpression());
		divisionEClass.getESuperTypes().add(this.getExpression());
		arrayAccessEClass.getESuperTypes().add(this.getExpression());
		arrayLengthEClass.getESuperTypes().add(this.getExpression());
		notEClass.getESuperTypes().add(this.getExpression());
		negEClass.getESuperTypes().add(this.getExpression());
		fieldAccessEClass.getESuperTypes().add(this.getExpression());
		methodCallEClass.getESuperTypes().add(this.getExpression());
		stringConstantEClass.getESuperTypes().add(this.getExpression());
		intConstantEClass.getESuperTypes().add(this.getExpression());
		boolConstantEClass.getESuperTypes().add(this.getExpression());
		thisEClass.getESuperTypes().add(this.getExpression());
		superEClass.getESuperTypes().add(this.getExpression());
		nullEClass.getESuperTypes().add(this.getExpression());
		newObjectEClass.getESuperTypes().add(this.getExpression());
		newArrayEClass.getESuperTypes().add(this.getExpression());
		symbolRefEClass.getESuperTypes().add(this.getExpression());
		integerValueEClass.getESuperTypes().add(this.getValue());
		stringValueEClass.getESuperTypes().add(this.getValue());
		booleanValueEClass.getESuperTypes().add(this.getValue());
		nullValueEClass.getESuperTypes().add(this.getValue());
		newCallEClass.getESuperTypes().add(this.getCall());
		methodCall2EClass.getESuperTypes().add(this.getCall());
		objectRefValueEClass.getESuperTypes().add(this.getValue());
		arrayRefValueEClass.getESuperTypes().add(this.getValue());
		moduloEClass.getESuperTypes().add(this.getExpression());

		// Initialize classes, features, and operations; add parameters
		initEClass(programEClass, ProgramImpl.class, "Program", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getProgram_Name(), ecorePackage.getEString(), "name", null, 0, 1, ProgramImpl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getProgram_Imports(), this.getImport(), null, "imports", null, 0, -1, ProgramImpl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getProgram_Classes(), this.getTypeDeclaration(), null, "classes", null, 0, -1, ProgramImpl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getProgram_State(), this.getState(), null, "state", null, 0, 1, ProgramImpl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(importEClass, ImportImpl.class, "Import", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getImport_ImportedNamespace(), ecorePackage.getEString(), "importedNamespace", null, 0, 1, ImportImpl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(typeDeclarationEClass, TypeDeclarationImpl.class, "TypeDeclaration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTypeDeclaration_AccessLevel(), this.getAccessLevel(), "accessLevel", null, 0, 1, TypeDeclarationImpl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTypeDeclaration_Implementz(), this.getInterface(), null, "implementz", null, 0, -1, TypeDeclarationImpl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTypeDeclaration_Members(), this.getMember(), null, "members", null, 0, -1, TypeDeclarationImpl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(clazzEClass, ClazzImpl.class, "Clazz", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getClazz_Isabstract(), ecorePackage.getEBoolean(), "isabstract", null, 0, 1, ClazzImpl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getClazz_SuperClass(), this.getClazz(), null, "superClass", null, 0, 1, ClazzImpl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(interfaceEClass, InterfaceImpl.class, "Interface", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(memberEClass, MemberImpl.class, "Member", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMember_Access(), this.getAccessLevel(), "access", null, 0, 1, MemberImpl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(methodEClass, MethodImpl.class, "Method", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMethod_Isabstract(), ecorePackage.getEBoolean(), "isabstract", null, 0, 1, MethodImpl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMethod_Isstatic(), ecorePackage.getEBoolean(), "isstatic", null, 0, 1, MethodImpl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMethod_Params(), this.getParameter(), null, "params", null, 0, -1, MethodImpl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMethod_Body(), this.getBlock(), null, "body", null, 0, 1, MethodImpl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMethod_Cache(), this.getClazzToMethodMap(), null, "cache", null, 0, -1, MethodImpl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(parameterEClass, ParameterImpl.class, "Parameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(fieldEClass, FieldImpl.class, "Field", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getField_DefaultValue(), this.getExpression(), null, "defaultValue", null, 0, 1, FieldImpl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(blockEClass, BlockImpl.class, "Block", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBlock_Statements(), this.getStatement(), null, "statements", null, 0, -1, BlockImpl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(statementEClass, StatementImpl.class, "Statement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(printStatementEClass, PrintStatementImpl.class, "PrintStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPrintStatement_Expression(), this.getExpression(), null, "expression", null, 0, 1, PrintStatementImpl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(returnEClass, ReturnImpl.class, "Return", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getReturn_Expression(), this.getExpression(), null, "expression", null, 0, 1, ReturnImpl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(ifStatementEClass, IfStatementImpl.class, "IfStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getIfStatement_Expression(), this.getExpression(), null, "expression", null, 0, 1, IfStatementImpl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIfStatement_ThenBlock(), this.getBlock(), null, "thenBlock", null, 0, 1, IfStatementImpl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIfStatement_ElseBlock(), this.getBlock(), null, "elseBlock", null, 0, 1, IfStatementImpl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(whileStatementEClass, WhileStatementImpl.class, "WhileStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getWhileStatement_Condition(), this.getExpression(), null, "condition", null, 0, 1, WhileStatementImpl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getWhileStatement_Block(), this.getBlock(), null, "block", null, 0, 1, WhileStatementImpl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(forStatementEClass, ForStatementImpl.class, "ForStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getForStatement_Declaration(), this.getAssignment(), null, "declaration", null, 0, 1, ForStatementImpl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getForStatement_Condition(), this.getExpression(), null, "condition", null, 0, 1, ForStatementImpl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getForStatement_Progression(), this.getAssignment(), null, "progression", null, 0, 1, ForStatementImpl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getForStatement_Block(), this.getBlock(), null, "block", null, 0, 1, ForStatementImpl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(typeRefEClass, TypeRefImpl.class, "TypeRef", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(singleTypeRefEClass, SingleTypeRefImpl.class, "SingleTypeRef", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(classRefEClass, ClassRefImpl.class, "ClassRef", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getClassRef_ReferencedClass(), this.getTypeDeclaration(), null, "referencedClass", null, 0, 1, ClassRefImpl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(namedElementEClass, NamedElementImpl.class, "NamedElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getNamedElement_Name(), ecorePackage.getEString(), "name", null, 0, 1, NamedElementImpl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(typedDeclarationEClass, TypedDeclarationImpl.class, "TypedDeclaration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTypedDeclaration_TypeRef(), this.getTypeRef(), null, "typeRef", null, 0, 1, TypedDeclarationImpl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(symbolEClass, SymbolImpl.class, "Symbol", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(variableDeclarationEClass, VariableDeclarationImpl.class, "VariableDeclaration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(assignmentEClass, AssignmentImpl.class, "Assignment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAssignment_Assignee(), this.getAssignee(), null, "assignee", null, 0, 1, AssignmentImpl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAssignment_Value(), this.getExpression(), null, "value", null, 0, 1, AssignmentImpl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(assigneeEClass, AssigneeImpl.class, "Assignee", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(expressionEClass, ExpressionImpl.class, "Expression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(arrayTypeRefEClass, ArrayTypeRefImpl.class, "ArrayTypeRef", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getArrayTypeRef_TypeRef(), this.getSingleTypeRef(), null, "typeRef", null, 0, 1, ArrayTypeRefImpl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(integerTypeRefEClass, IntegerTypeRefImpl.class, "IntegerTypeRef", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(booleanTypeRefEClass, BooleanTypeRefImpl.class, "BooleanTypeRef", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(stringTypeRefEClass, StringTypeRefImpl.class, "StringTypeRef", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(voidTypeRefEClass, VoidTypeRefImpl.class, "VoidTypeRef", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(orEClass, OrImpl.class, "Or", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOr_Left(), this.getExpression(), null, "left", null, 0, 1, OrImpl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOr_Right(), this.getExpression(), null, "right", null, 0, 1, OrImpl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(andEClass, AndImpl.class, "And", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAnd_Left(), this.getExpression(), null, "left", null, 0, 1, AndImpl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAnd_Right(), this.getExpression(), null, "right", null, 0, 1, AndImpl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(equalityEClass, EqualityImpl.class, "Equality", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEquality_Left(), this.getExpression(), null, "left", null, 0, 1, EqualityImpl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEquality_Right(), this.getExpression(), null, "right", null, 0, 1, EqualityImpl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(inequalityEClass, InequalityImpl.class, "Inequality", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInequality_Left(), this.getExpression(), null, "left", null, 0, 1, InequalityImpl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInequality_Right(), this.getExpression(), null, "right", null, 0, 1, InequalityImpl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(superiorOrEqualEClass, SuperiorOrEqualImpl.class, "SuperiorOrEqual", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSuperiorOrEqual_Left(), this.getExpression(), null, "left", null, 0, 1, SuperiorOrEqualImpl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSuperiorOrEqual_Right(), this.getExpression(), null, "right", null, 0, 1, SuperiorOrEqualImpl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(inferiorOrEqualEClass, InferiorOrEqualImpl.class, "InferiorOrEqual", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInferiorOrEqual_Left(), this.getExpression(), null, "left", null, 0, 1, InferiorOrEqualImpl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInferiorOrEqual_Right(), this.getExpression(), null, "right", null, 0, 1, InferiorOrEqualImpl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(superiorEClass, SuperiorImpl.class, "Superior", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSuperior_Left(), this.getExpression(), null, "left", null, 0, 1, SuperiorImpl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSuperior_Right(), this.getExpression(), null, "right", null, 0, 1, SuperiorImpl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(inferiorEClass, InferiorImpl.class, "Inferior", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInferior_Left(), this.getExpression(), null, "left", null, 0, 1, InferiorImpl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInferior_Right(), this.getExpression(), null, "right", null, 0, 1, InferiorImpl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(plusEClass, PlusImpl.class, "Plus", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPlus_Left(), this.getExpression(), null, "left", null, 0, 1, PlusImpl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPlus_Right(), this.getExpression(), null, "right", null, 0, 1, PlusImpl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(minusEClass, MinusImpl.class, "Minus", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMinus_Left(), this.getExpression(), null, "left", null, 0, 1, MinusImpl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMinus_Right(), this.getExpression(), null, "right", null, 0, 1, MinusImpl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(multiplicationEClass, MultiplicationImpl.class, "Multiplication", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMultiplication_Left(), this.getExpression(), null, "left", null, 0, 1, MultiplicationImpl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMultiplication_Right(), this.getExpression(), null, "right", null, 0, 1, MultiplicationImpl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(divisionEClass, DivisionImpl.class, "Division", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDivision_Left(), this.getExpression(), null, "left", null, 0, 1, DivisionImpl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDivision_Right(), this.getExpression(), null, "right", null, 0, 1, DivisionImpl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(arrayAccessEClass, ArrayAccessImpl.class, "ArrayAccess", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getArrayAccess_Object(), this.getExpression(), null, "object", null, 0, 1, ArrayAccessImpl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getArrayAccess_Index(), this.getExpression(), null, "index", null, 0, 1, ArrayAccessImpl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(arrayLengthEClass, ArrayLengthImpl.class, "ArrayLength", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getArrayLength_Array(), this.getExpression(), null, "array", null, 0, 1, ArrayLengthImpl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(notEClass, NotImpl.class, "Not", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getNot_Expression(), this.getExpression(), null, "expression", null, 0, 1, NotImpl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(negEClass, NegImpl.class, "Neg", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getNeg_Expression(), this.getExpression(), null, "expression", null, 0, 1, NegImpl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(fieldAccessEClass, FieldAccessImpl.class, "FieldAccess", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFieldAccess_Receiver(), this.getExpression(), null, "receiver", null, 0, 1, FieldAccessImpl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFieldAccess_Field(), this.getField(), null, "field", null, 0, 1, FieldAccessImpl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(methodCallEClass, MethodCallImpl.class, "MethodCall", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMethodCall_Receiver(), this.getExpression(), null, "receiver", null, 0, 1, MethodCallImpl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMethodCall_Method(), this.getMethod(), null, "method", null, 0, 1, MethodCallImpl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMethodCall_Args(), this.getExpression(), null, "args", null, 0, -1, MethodCallImpl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(stringConstantEClass, StringConstantImpl.class, "StringConstant", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getStringConstant_Value(), ecorePackage.getEString(), "value", null, 0, 1, StringConstantImpl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(intConstantEClass, IntConstantImpl.class, "IntConstant", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIntConstant_Value(), ecorePackage.getEInt(), "value", null, 0, 1, IntConstantImpl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(boolConstantEClass, BoolConstantImpl.class, "BoolConstant", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getBoolConstant_Value(), ecorePackage.getEString(), "value", null, 0, 1, BoolConstantImpl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(thisEClass, ThisImpl.class, "This", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(superEClass, SuperImpl.class, "Super", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(nullEClass, NullImpl.class, "Null", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(newObjectEClass, NewObjectImpl.class, "NewObject", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getNewObject_Type(), this.getClazz(), null, "type", null, 0, 1, NewObjectImpl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNewObject_Args(), this.getExpression(), null, "args", null, 0, -1, NewObjectImpl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(newArrayEClass, NewArrayImpl.class, "NewArray", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getNewArray_Type(), this.getTypeRef(), null, "type", null, 0, 1, NewArrayImpl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNewArray_Size(), this.getExpression(), null, "size", null, 0, 1, NewArrayImpl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(symbolRefEClass, SymbolRefImpl.class, "SymbolRef", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSymbolRef_Symbol(), this.getSymbol(), null, "symbol", null, 0, 1, SymbolRefImpl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(contextEClass, ContextImpl.class, "Context", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getContext_Bindings(), this.getSymbolBinding(), null, "bindings", null, 0, -1, ContextImpl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getContext_ParentContext(), this.getContext(), this.getContext_ChildContext(), "parentContext", null, 0, 1, ContextImpl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getContext_ChildContext(), this.getContext(), this.getContext_ParentContext(), "childContext", null, 0, 1, ContextImpl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getContext_Cache(), this.getSymbolToSymbolBindingMap(), null, "cache", null, 0, -1, ContextImpl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(valueEClass, ValueImpl.class, "Value", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(integerValueEClass, IntegerValueImpl.class, "IntegerValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIntegerValue_Value(), ecorePackage.getEInt(), "value", null, 0, 1, IntegerValueImpl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(symbolBindingEClass, SymbolBindingImpl.class, "SymbolBinding", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSymbolBinding_Value(), this.getValue(), null, "value", null, 0, 1, SymbolBindingImpl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSymbolBinding_Symbol(), this.getSymbol(), null, "symbol", null, 1, 1, SymbolBindingImpl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(fieldBindingEClass, FieldBindingImpl.class, "FieldBinding", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFieldBinding_Field(), this.getField(), null, "field", null, 1, 1, FieldBindingImpl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFieldBinding_Value(), this.getValue(), null, "value", null, 0, 1, FieldBindingImpl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(stringValueEClass, StringValueImpl.class, "StringValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getStringValue_Value(), ecorePackage.getEString(), "value", null, 0, 1, StringValueImpl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(booleanValueEClass, BooleanValueImpl.class, "BooleanValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getBooleanValue_Value(), ecorePackage.getEBoolean(), "value", null, 0, 1, BooleanValueImpl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(outputStreamEClass, OutputStreamImpl.class, "OutputStream", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getOutputStream_Stream(), ecorePackage.getEString(), "stream", null, 0, -1, OutputStreamImpl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(stateEClass, StateImpl.class, "State", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getState_RootFrame(), this.getFrame(), null, "rootFrame", null, 0, 1, StateImpl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getState_ObjectsHeap(), this.getObjectInstance(), null, "objectsHeap", null, 0, -1, StateImpl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getState_OutputStream(), this.getOutputStream(), null, "outputStream", null, 0, 1, StateImpl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getState_ArraysHeap(), this.getArrayInstance(), null, "arraysHeap", null, 0, -1, StateImpl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getState_ContextCache(), this.getContext(), null, "contextCache", null, 0, 1, StateImpl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getState_FrameCache(), this.getFrame(), null, "frameCache", null, 0, 1, StateImpl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(frameEClass, FrameImpl.class, "Frame", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFrame_Call(), this.getCall(), null, "call", null, 0, 1, FrameImpl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFrame_Instance(), this.getObjectInstance(), null, "instance", null, 0, 1, FrameImpl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFrame_ChildFrame(), this.getFrame(), this.getFrame_ParentFrame(), "childFrame", null, 0, 1, FrameImpl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFrame_ParentFrame(), this.getFrame(), this.getFrame_ChildFrame(), "parentFrame", null, 0, 1, FrameImpl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFrame_RootContext(), this.getContext(), null, "rootContext", null, 0, 1, FrameImpl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFrame_ReturnValue(), this.getValue(), null, "returnValue", null, 0, 1, FrameImpl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(nullValueEClass, NullValueImpl.class, "NullValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(callEClass, CallImpl.class, "Call", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(newCallEClass, NewCallImpl.class, "NewCall", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getNewCall_Newz(), this.getNewObject(), null, "newz", null, 1, 1, NewCallImpl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(methodCall2EClass, MethodCall2Impl.class, "MethodCall2", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMethodCall2_Methodcall(), this.getMethodCall(), null, "methodcall", null, 1, 1, MethodCall2Impl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(objectInstanceEClass, ObjectInstanceImpl.class, "ObjectInstance", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getObjectInstance_Fieldbindings(), this.getFieldBinding(), null, "fieldbindings", null, 0, -1, ObjectInstanceImpl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getObjectInstance_Type(), this.getClazz(), null, "type", null, 1, 1, ObjectInstanceImpl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(arrayInstanceEClass, ArrayInstanceImpl.class, "ArrayInstance", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getArrayInstance_Value(), this.getValue(), null, "value", null, 0, -1, ArrayInstanceImpl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getArrayInstance_Size(), ecorePackage.getEInt(), "size", null, 0, 1, ArrayInstanceImpl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(objectRefValueEClass, ObjectRefValueImpl.class, "ObjectRefValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getObjectRefValue_Instance(), this.getObjectInstance(), null, "instance", null, 0, 1, ObjectRefValueImpl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(arrayRefValueEClass, ArrayRefValueImpl.class, "ArrayRefValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getArrayRefValue_Instance(), this.getArrayInstance(), null, "instance", null, 0, 1, ArrayRefValueImpl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(symbolToSymbolBindingMapEClass, Entry.class, "SymbolToSymbolBindingMap", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSymbolToSymbolBindingMap_Key(), this.getSymbol(), null, "key", null, 0, 1, Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSymbolToSymbolBindingMap_Value(), this.getSymbolBinding(), null, "value", null, 0, 1, Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(clazzToMethodMapEClass, Entry.class, "ClazzToMethodMap", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);
		initEReference(getClazzToMethodMap_Key(), this.getClazz(), null, "key", null, 0, 1, Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getClazzToMethodMap_Value(), this.getMethod(), null, "value", null, 0, 1, Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(moduloEClass, ModuloImpl.class, "Modulo", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getModulo_Left(), this.getExpression(), null, "left", null, 0, 1, ModuloImpl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getModulo_Right(), this.getExpression(), null, "right", null, 0, 1, ModuloImpl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(accessLevelEEnum, AccessLevel.class, "AccessLevel");
		addEEnumLiteral(accessLevelEEnum, AccessLevel.PRIVATE);
		addEEnumLiteral(accessLevelEEnum, AccessLevel.PROTECTED);
		addEEnumLiteral(accessLevelEEnum, AccessLevel.PUBLIC);

		// Create resource
		createResource(eNS_URI);
	}
}
