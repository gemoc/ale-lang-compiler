package miniJava.interpreter.miniJava;

import java.lang.String;
import miniJava.interpreter.miniJava.impl.MiniJavaPackageImpl;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

public interface MiniJavaPackage extends EPackage {
	interface Literals {
		EClass AND = eINSTANCE.getAnd();

		EReference AND__LEFT = eINSTANCE.getAnd_Left();

		EReference AND__RIGHT = eINSTANCE.getAnd_Right();

		EClass ARRAY_ACCESS = eINSTANCE.getArrayAccess();

		EReference ARRAY_ACCESS__INDEX = eINSTANCE.getArrayAccess_Index();

		EReference ARRAY_ACCESS__OBJECT = eINSTANCE.getArrayAccess_Object();

		EClass ARRAY_INSTANCE = eINSTANCE.getArrayInstance();

		EAttribute ARRAY_INSTANCE__SIZE = eINSTANCE.getArrayInstance_Size();

		EReference ARRAY_INSTANCE__VALUE = eINSTANCE.getArrayInstance_Value();

		EClass ARRAY_LENGTH = eINSTANCE.getArrayLength();

		EReference ARRAY_LENGTH__ARRAY = eINSTANCE.getArrayLength_Array();

		EClass ARRAY_REF_VALUE = eINSTANCE.getArrayRefValue();

		EReference ARRAY_REF_VALUE__INSTANCE = eINSTANCE.getArrayRefValue_Instance();

		EClass ARRAY_TYPE_REF = eINSTANCE.getArrayTypeRef();

		EReference ARRAY_TYPE_REF__TYPE_REF = eINSTANCE.getArrayTypeRef_TypeRef();

		EClass ASSIGNEE = eINSTANCE.getAssignee();

		EClass ASSIGNMENT = eINSTANCE.getAssignment();

		EReference ASSIGNMENT__ASSIGNEE = eINSTANCE.getAssignment_Assignee();

		EReference ASSIGNMENT__VALUE = eINSTANCE.getAssignment_Value();

		EClass BLOCK = eINSTANCE.getBlock();

		EReference BLOCK__STATEMENTS = eINSTANCE.getBlock_Statements();

		EClass BOOL_CONSTANT = eINSTANCE.getBoolConstant();

		EAttribute BOOL_CONSTANT__VALUE = eINSTANCE.getBoolConstant_Value();

		EClass BOOLEAN_TYPE_REF = eINSTANCE.getBooleanTypeRef();

		EClass BOOLEAN_VALUE = eINSTANCE.getBooleanValue();

		EAttribute BOOLEAN_VALUE__VALUE = eINSTANCE.getBooleanValue_Value();

		EClass CALL = eINSTANCE.getCall();

		EClass CLASS_REF = eINSTANCE.getClassRef();

		EReference CLASS_REF__REFERENCED_CLASS = eINSTANCE.getClassRef_ReferencedClass();

		EClass CLAZZ = eINSTANCE.getClazz();

		EAttribute CLAZZ__ISABSTRACT = eINSTANCE.getClazz_Isabstract();

		EReference CLAZZ__SUPER_CLASS = eINSTANCE.getClazz_SuperClass();

		EClass CONTEXT = eINSTANCE.getContext();

		EReference CONTEXT__BINDINGS = eINSTANCE.getContext_Bindings();

		EReference CONTEXT__CACHE = eINSTANCE.getContext_Cache();

		EReference CONTEXT__CHILD_CONTEXT = eINSTANCE.getContext_ChildContext();

		EReference CONTEXT__PARENT_CONTEXT = eINSTANCE.getContext_ParentContext();

		EClass DIVISION = eINSTANCE.getDivision();

		EReference DIVISION__LEFT = eINSTANCE.getDivision_Left();

		EReference DIVISION__RIGHT = eINSTANCE.getDivision_Right();

		EClass EQUALITY = eINSTANCE.getEquality();

		EReference EQUALITY__LEFT = eINSTANCE.getEquality_Left();

		EReference EQUALITY__RIGHT = eINSTANCE.getEquality_Right();

		EClass EXPRESSION = eINSTANCE.getExpression();

		EClass FIELD = eINSTANCE.getField();

		EReference FIELD__DEFAULT_VALUE = eINSTANCE.getField_DefaultValue();

		EClass FIELD_ACCESS = eINSTANCE.getFieldAccess();

		EReference FIELD_ACCESS__FIELD = eINSTANCE.getFieldAccess_Field();

		EReference FIELD_ACCESS__RECEIVER = eINSTANCE.getFieldAccess_Receiver();

		EClass FIELD_BINDING = eINSTANCE.getFieldBinding();

		EReference FIELD_BINDING__FIELD = eINSTANCE.getFieldBinding_Field();

		EReference FIELD_BINDING__VALUE = eINSTANCE.getFieldBinding_Value();

		EClass FOR_STATEMENT = eINSTANCE.getForStatement();

		EReference FOR_STATEMENT__BLOCK = eINSTANCE.getForStatement_Block();

		EReference FOR_STATEMENT__CONDITION = eINSTANCE.getForStatement_Condition();

		EReference FOR_STATEMENT__DECLARATION = eINSTANCE.getForStatement_Declaration();

		EReference FOR_STATEMENT__PROGRESSION = eINSTANCE.getForStatement_Progression();

		EClass FRAME = eINSTANCE.getFrame();

		EReference FRAME__CALL = eINSTANCE.getFrame_Call();

		EReference FRAME__CHILD_FRAME = eINSTANCE.getFrame_ChildFrame();

		EReference FRAME__INSTANCE = eINSTANCE.getFrame_Instance();

		EReference FRAME__PARENT_FRAME = eINSTANCE.getFrame_ParentFrame();

		EReference FRAME__RETURN_VALUE = eINSTANCE.getFrame_ReturnValue();

		EReference FRAME__ROOT_CONTEXT = eINSTANCE.getFrame_RootContext();

		EClass IF_STATEMENT = eINSTANCE.getIfStatement();

		EReference IF_STATEMENT__ELSE_BLOCK = eINSTANCE.getIfStatement_ElseBlock();

		EReference IF_STATEMENT__EXPRESSION = eINSTANCE.getIfStatement_Expression();

		EReference IF_STATEMENT__THEN_BLOCK = eINSTANCE.getIfStatement_ThenBlock();

		EClass IMPORT = eINSTANCE.getImport();

		EAttribute IMPORT__IMPORTED_NAMESPACE = eINSTANCE.getImport_ImportedNamespace();

		EClass INEQUALITY = eINSTANCE.getInequality();

		EReference INEQUALITY__LEFT = eINSTANCE.getInequality_Left();

		EReference INEQUALITY__RIGHT = eINSTANCE.getInequality_Right();

		EClass INFERIOR = eINSTANCE.getInferior();

		EReference INFERIOR__LEFT = eINSTANCE.getInferior_Left();

		EReference INFERIOR__RIGHT = eINSTANCE.getInferior_Right();

		EClass INFERIOR_OR_EQUAL = eINSTANCE.getInferiorOrEqual();

		EReference INFERIOR_OR_EQUAL__LEFT = eINSTANCE.getInferiorOrEqual_Left();

		EReference INFERIOR_OR_EQUAL__RIGHT = eINSTANCE.getInferiorOrEqual_Right();

		EClass INT_CONSTANT = eINSTANCE.getIntConstant();

		EAttribute INT_CONSTANT__VALUE = eINSTANCE.getIntConstant_Value();

		EClass INTEGER_TYPE_REF = eINSTANCE.getIntegerTypeRef();

		EClass INTEGER_VALUE = eINSTANCE.getIntegerValue();

		EAttribute INTEGER_VALUE__VALUE = eINSTANCE.getIntegerValue_Value();

		EClass INTERFACE = eINSTANCE.getInterface();

		EClass MEMBER = eINSTANCE.getMember();

		EAttribute MEMBER__ACCESS = eINSTANCE.getMember_Access();

		EClass METHOD = eINSTANCE.getMethod();

		EReference METHOD__BODY = eINSTANCE.getMethod_Body();

		EAttribute METHOD__ISABSTRACT = eINSTANCE.getMethod_Isabstract();

		EAttribute METHOD__ISSTATIC = eINSTANCE.getMethod_Isstatic();

		EReference METHOD__PARAMS = eINSTANCE.getMethod_Params();

		EClass METHOD_CALL = eINSTANCE.getMethodCall();

		EReference METHOD_CALL__ARGS = eINSTANCE.getMethodCall_Args();

		EReference METHOD_CALL__METHOD = eINSTANCE.getMethodCall_Method();

		EReference METHOD_CALL__RECEIVER = eINSTANCE.getMethodCall_Receiver();

		EClass METHOD_CALL2 = eINSTANCE.getMethodCall2();

		EReference METHOD_CALL2__METHODCALL = eINSTANCE.getMethodCall2_Methodcall();

		EClass MINUS = eINSTANCE.getMinus();

		EReference MINUS__LEFT = eINSTANCE.getMinus_Left();

		EReference MINUS__RIGHT = eINSTANCE.getMinus_Right();

		EClass MULTIPLICATION = eINSTANCE.getMultiplication();

		EReference MULTIPLICATION__LEFT = eINSTANCE.getMultiplication_Left();

		EReference MULTIPLICATION__RIGHT = eINSTANCE.getMultiplication_Right();

		EClass NAMED_ELEMENT = eINSTANCE.getNamedElement();

		EAttribute NAMED_ELEMENT__NAME = eINSTANCE.getNamedElement_Name();

		EClass NEG = eINSTANCE.getNeg();

		EReference NEG__EXPRESSION = eINSTANCE.getNeg_Expression();

		EClass NEW_ARRAY = eINSTANCE.getNewArray();

		EReference NEW_ARRAY__SIZE = eINSTANCE.getNewArray_Size();

		EReference NEW_ARRAY__TYPE = eINSTANCE.getNewArray_Type();

		EClass NEW_CALL = eINSTANCE.getNewCall();

		EReference NEW_CALL__NEWZ = eINSTANCE.getNewCall_Newz();

		EClass NEW_OBJECT = eINSTANCE.getNewObject();

		EReference NEW_OBJECT__ARGS = eINSTANCE.getNewObject_Args();

		EReference NEW_OBJECT__TYPE = eINSTANCE.getNewObject_Type();

		EClass NOT = eINSTANCE.getNot();

		EReference NOT__EXPRESSION = eINSTANCE.getNot_Expression();

		EClass NULL = eINSTANCE.getNull();

		EClass NULL_VALUE = eINSTANCE.getNullValue();

		EClass OBJECT_INSTANCE = eINSTANCE.getObjectInstance();

		EReference OBJECT_INSTANCE__FIELDBINDINGS = eINSTANCE.getObjectInstance_Fieldbindings();

		EReference OBJECT_INSTANCE__TYPE = eINSTANCE.getObjectInstance_Type();

		EClass OBJECT_REF_VALUE = eINSTANCE.getObjectRefValue();

		EReference OBJECT_REF_VALUE__INSTANCE = eINSTANCE.getObjectRefValue_Instance();

		EClass OR = eINSTANCE.getOr();

		EReference OR__LEFT = eINSTANCE.getOr_Left();

		EReference OR__RIGHT = eINSTANCE.getOr_Right();

		EClass OUTPUT_STREAM = eINSTANCE.getOutputStream();

		EAttribute OUTPUT_STREAM__STREAM = eINSTANCE.getOutputStream_Stream();

		EClass PARAMETER = eINSTANCE.getParameter();

		EClass PLUS = eINSTANCE.getPlus();

		EReference PLUS__LEFT = eINSTANCE.getPlus_Left();

		EReference PLUS__RIGHT = eINSTANCE.getPlus_Right();

		EClass PRINT_STATEMENT = eINSTANCE.getPrintStatement();

		EReference PRINT_STATEMENT__EXPRESSION = eINSTANCE.getPrintStatement_Expression();

		EClass PROGRAM = eINSTANCE.getProgram();

		EReference PROGRAM__CLASSES = eINSTANCE.getProgram_Classes();

		EReference PROGRAM__IMPORTS = eINSTANCE.getProgram_Imports();

		EAttribute PROGRAM__NAME = eINSTANCE.getProgram_Name();

		EReference PROGRAM__STATE = eINSTANCE.getProgram_State();

		EClass RETURN = eINSTANCE.getReturn();

		EReference RETURN__EXPRESSION = eINSTANCE.getReturn_Expression();

		EClass SINGLE_TYPE_REF = eINSTANCE.getSingleTypeRef();

		EClass STATE = eINSTANCE.getState();

		EReference STATE__ARRAYS_HEAP = eINSTANCE.getState_ArraysHeap();

		EReference STATE__CONTEXT_CACHE = eINSTANCE.getState_ContextCache();

		EReference STATE__FRAME_CACHE = eINSTANCE.getState_FrameCache();

		EReference STATE__OBJECTS_HEAP = eINSTANCE.getState_ObjectsHeap();

		EReference STATE__OUTPUT_STREAM = eINSTANCE.getState_OutputStream();

		EReference STATE__ROOT_FRAME = eINSTANCE.getState_RootFrame();

		EClass STATEMENT = eINSTANCE.getStatement();

		EClass STRING_CONSTANT = eINSTANCE.getStringConstant();

		EAttribute STRING_CONSTANT__VALUE = eINSTANCE.getStringConstant_Value();

		EClass STRING_TYPE_REF = eINSTANCE.getStringTypeRef();

		EClass STRING_VALUE = eINSTANCE.getStringValue();

		EAttribute STRING_VALUE__VALUE = eINSTANCE.getStringValue_Value();

		EClass SUPER = eINSTANCE.getSuper();

		EClass SUPERIOR = eINSTANCE.getSuperior();

		EReference SUPERIOR__LEFT = eINSTANCE.getSuperior_Left();

		EReference SUPERIOR__RIGHT = eINSTANCE.getSuperior_Right();

		EClass SUPERIOR_OR_EQUAL = eINSTANCE.getSuperiorOrEqual();

		EReference SUPERIOR_OR_EQUAL__LEFT = eINSTANCE.getSuperiorOrEqual_Left();

		EReference SUPERIOR_OR_EQUAL__RIGHT = eINSTANCE.getSuperiorOrEqual_Right();

		EClass SYMBOL = eINSTANCE.getSymbol();

		EClass SYMBOL_BINDING = eINSTANCE.getSymbolBinding();

		EReference SYMBOL_BINDING__SYMBOL = eINSTANCE.getSymbolBinding_Symbol();

		EReference SYMBOL_BINDING__VALUE = eINSTANCE.getSymbolBinding_Value();

		EClass SYMBOL_REF = eINSTANCE.getSymbolRef();

		EReference SYMBOL_REF__SYMBOL = eINSTANCE.getSymbolRef_Symbol();

		EClass SYMBOL_TO_SYMBOL_BINDING_MAP = eINSTANCE.getSymbolToSymbolBindingMap();

		EReference SYMBOL_TO_SYMBOL_BINDING_MAP__KEY = eINSTANCE.getSymbolToSymbolBindingMap_Key();

		EReference SYMBOL_TO_SYMBOL_BINDING_MAP__VALUE = eINSTANCE.getSymbolToSymbolBindingMap_Value();

		EClass THIS = eINSTANCE.getThis();

		EClass TYPE_DECLARATION = eINSTANCE.getTypeDeclaration();

		EAttribute TYPE_DECLARATION__ACCESS_LEVEL = eINSTANCE.getTypeDeclaration_AccessLevel();

		EReference TYPE_DECLARATION__IMPLEMENTZ = eINSTANCE.getTypeDeclaration_Implementz();

		EReference TYPE_DECLARATION__MEMBERS = eINSTANCE.getTypeDeclaration_Members();

		EClass TYPE_REF = eINSTANCE.getTypeRef();

		EClass TYPED_DECLARATION = eINSTANCE.getTypedDeclaration();

		EReference TYPED_DECLARATION__TYPE_REF = eINSTANCE.getTypedDeclaration_TypeRef();

		EClass VALUE = eINSTANCE.getValue();

		EClass VARIABLE_DECLARATION = eINSTANCE.getVariableDeclaration();

		EClass VOID_TYPE_REF = eINSTANCE.getVoidTypeRef();

		EClass WHILE_STATEMENT = eINSTANCE.getWhileStatement();

		EReference WHILE_STATEMENT__BLOCK = eINSTANCE.getWhileStatement_Block();

		EReference WHILE_STATEMENT__CONDITION = eINSTANCE.getWhileStatement_Condition();
	}

	int ACCESS_LEVEL = 77;

	int AND = 32;

	int AND__LEFT = 0;

	int AND__RIGHT = 1;

	int ARRAY_ACCESS = 43;

	int ARRAY_ACCESS__INDEX = 1;

	int ARRAY_ACCESS__OBJECT = 0;

	int ARRAY_INSTANCE = 73;

	int ARRAY_INSTANCE__SIZE = 1;

	int ARRAY_INSTANCE__VALUE = 0;

	int ARRAY_LENGTH = 44;

	int ARRAY_LENGTH__ARRAY = 0;

	int ARRAY_REF_VALUE = 75;

	int ARRAY_REF_VALUE__INSTANCE = 0;

	int ARRAY_TYPE_REF = 26;

	int ARRAY_TYPE_REF__TYPE_REF = 0;

	int ASSIGNEE = 24;

	int ASSIGNMENT = 23;

	int ASSIGNMENT__ASSIGNEE = 0;

	int ASSIGNMENT__VALUE = 1;

	int BLOCK = 9;

	int BLOCK__STATEMENTS = 0;

	int BOOL_CONSTANT = 51;

	int BOOL_CONSTANT__VALUE = 0;

	int BOOLEAN_TYPE_REF = 28;

	int BOOLEAN_VALUE = 64;

	int BOOLEAN_VALUE__VALUE = 0;

	int CALL = 69;

	int CLASS_REF = 18;

	int CLASS_REF__REFERENCED_CLASS = 0;

	int CLAZZ = 3;

	int CLAZZ__ISABSTRACT = 4;

	int CLAZZ__SUPER_CLASS = 5;

	int CONTEXT = 58;

	int CONTEXT__BINDINGS = 0;

	int CONTEXT__CACHE = 3;

	int CONTEXT__CHILD_CONTEXT = 2;

	int CONTEXT__PARENT_CONTEXT = 1;

	int DIVISION = 42;

	int DIVISION__LEFT = 0;

	int DIVISION__RIGHT = 1;

	MiniJavaPackage eINSTANCE = MiniJavaPackageImpl.init();

	String eNAME = "miniJava";

	String eNS_PREFIX = "miniJava";

	String eNS_URI = "http://miniJava.miniJava.miniJava/";

	int EQUALITY = 33;

	int EQUALITY__LEFT = 0;

	int EQUALITY__RIGHT = 1;

	int EXPRESSION = 25;

	int FIELD = 8;

	int FIELD__DEFAULT_VALUE = 3;

	int FIELD_ACCESS = 47;

	int FIELD_ACCESS__FIELD = 1;

	int FIELD_ACCESS__RECEIVER = 0;

	int FIELD_BINDING = 62;

	int FIELD_BINDING__FIELD = 0;

	int FIELD_BINDING__VALUE = 1;

	int FOR_STATEMENT = 15;

	int FOR_STATEMENT__BLOCK = 3;

	int FOR_STATEMENT__CONDITION = 1;

	int FOR_STATEMENT__DECLARATION = 0;

	int FOR_STATEMENT__PROGRESSION = 2;

	int FRAME = 67;

	int FRAME__CALL = 0;

	int FRAME__CHILD_FRAME = 2;

	int FRAME__INSTANCE = 1;

	int FRAME__PARENT_FRAME = 3;

	int FRAME__RETURN_VALUE = 5;

	int FRAME__ROOT_CONTEXT = 4;

	int IF_STATEMENT = 13;

	int IF_STATEMENT__ELSE_BLOCK = 2;

	int IF_STATEMENT__EXPRESSION = 0;

	int IF_STATEMENT__THEN_BLOCK = 1;

	int IMPORT = 1;

	int IMPORT__IMPORTED_NAMESPACE = 0;

	int INEQUALITY = 34;

	int INEQUALITY__LEFT = 0;

	int INEQUALITY__RIGHT = 1;

	int INFERIOR = 38;

	int INFERIOR__LEFT = 0;

	int INFERIOR__RIGHT = 1;

	int INFERIOR_OR_EQUAL = 36;

	int INFERIOR_OR_EQUAL__LEFT = 0;

	int INFERIOR_OR_EQUAL__RIGHT = 1;

	int INT_CONSTANT = 50;

	int INT_CONSTANT__VALUE = 0;

	int INTEGER_TYPE_REF = 27;

	int INTEGER_VALUE = 60;

	int INTEGER_VALUE__VALUE = 0;

	int INTERFACE = 4;

	int MEMBER = 5;

	int MEMBER__ACCESS = 2;

	int METHOD = 6;

	int METHOD__BODY = 6;

	int METHOD__ISABSTRACT = 3;

	int METHOD__ISSTATIC = 4;

	int METHOD__PARAMS = 5;

	int METHOD_CALL = 48;

	int METHOD_CALL__ARGS = 2;

	int METHOD_CALL__METHOD = 1;

	int METHOD_CALL__RECEIVER = 0;

	int METHOD_CALL2 = 71;

	int METHOD_CALL2__METHODCALL = 0;

	int MINUS = 40;

	int MINUS__LEFT = 0;

	int MINUS__RIGHT = 1;

	int MULTIPLICATION = 41;

	int MULTIPLICATION__LEFT = 0;

	int MULTIPLICATION__RIGHT = 1;

	int NAMED_ELEMENT = 19;

	int NAMED_ELEMENT__NAME = 0;

	int NEG = 46;

	int NEG__EXPRESSION = 0;

	int NEW_ARRAY = 56;

	int NEW_ARRAY__SIZE = 1;

	int NEW_ARRAY__TYPE = 0;

	int NEW_CALL = 70;

	int NEW_CALL__NEWZ = 0;

	int NEW_OBJECT = 55;

	int NEW_OBJECT__ARGS = 1;

	int NEW_OBJECT__TYPE = 0;

	int NOT = 45;

	int NOT__EXPRESSION = 0;

	int NULL = 54;

	int NULL_VALUE = 68;

	int OBJECT_INSTANCE = 72;

	int OBJECT_INSTANCE__FIELDBINDINGS = 0;

	int OBJECT_INSTANCE__TYPE = 1;

	int OBJECT_REF_VALUE = 74;

	int OBJECT_REF_VALUE__INSTANCE = 0;

	int OR = 31;

	int OR__LEFT = 0;

	int OR__RIGHT = 1;

	int OUTPUT_STREAM = 65;

	int OUTPUT_STREAM__STREAM = 0;

	int PARAMETER = 7;

	int PLUS = 39;

	int PLUS__LEFT = 0;

	int PLUS__RIGHT = 1;

	int PRINT_STATEMENT = 11;

	int PRINT_STATEMENT__EXPRESSION = 0;

	int PROGRAM = 0;

	int PROGRAM__CLASSES = 2;

	int PROGRAM__IMPORTS = 1;

	int PROGRAM__NAME = 0;

	int PROGRAM__STATE = 3;

	int RETURN = 12;

	int RETURN__EXPRESSION = 0;

	int SINGLE_TYPE_REF = 17;

	int STATE = 66;

	int STATE__ARRAYS_HEAP = 3;

	int STATE__CONTEXT_CACHE = 4;

	int STATE__FRAME_CACHE = 5;

	int STATE__OBJECTS_HEAP = 1;

	int STATE__OUTPUT_STREAM = 2;

	int STATE__ROOT_FRAME = 0;

	int STATEMENT = 10;

	int STRING_CONSTANT = 49;

	int STRING_CONSTANT__VALUE = 0;

	int STRING_TYPE_REF = 29;

	int STRING_VALUE = 63;

	int STRING_VALUE__VALUE = 0;

	int SUPER = 53;

	int SUPERIOR = 37;

	int SUPERIOR__LEFT = 0;

	int SUPERIOR__RIGHT = 1;

	int SUPERIOR_OR_EQUAL = 35;

	int SUPERIOR_OR_EQUAL__LEFT = 0;

	int SUPERIOR_OR_EQUAL__RIGHT = 1;

	int SYMBOL = 21;

	int SYMBOL_BINDING = 61;

	int SYMBOL_BINDING__SYMBOL = 1;

	int SYMBOL_BINDING__VALUE = 0;

	int SYMBOL_REF = 57;

	int SYMBOL_REF__SYMBOL = 0;

	int SYMBOL_TO_SYMBOL_BINDING_MAP = 76;

	int SYMBOL_TO_SYMBOL_BINDING_MAP__KEY = 0;

	int SYMBOL_TO_SYMBOL_BINDING_MAP__VALUE = 1;

	int THIS = 52;

	int TYPE_DECLARATION = 2;

	int TYPE_DECLARATION__ACCESS_LEVEL = 1;

	int TYPE_DECLARATION__IMPLEMENTZ = 2;

	int TYPE_DECLARATION__MEMBERS = 3;

	int TYPE_REF = 16;

	int TYPED_DECLARATION = 20;

	int TYPED_DECLARATION__TYPE_REF = 1;

	int VALUE = 59;

	int VARIABLE_DECLARATION = 22;

	int VOID_TYPE_REF = 30;

	int WHILE_STATEMENT = 14;

	int WHILE_STATEMENT__BLOCK = 1;

	int WHILE_STATEMENT__CONDITION = 0;

	EEnum getAccessLevel();

	EClass getAnd();

	EReference getAnd_Left();

	EReference getAnd_Right();

	EClass getArrayAccess();

	EReference getArrayAccess_Index();

	EReference getArrayAccess_Object();

	EClass getArrayInstance();

	EAttribute getArrayInstance_Size();

	EReference getArrayInstance_Value();

	EClass getArrayLength();

	EReference getArrayLength_Array();

	EClass getArrayRefValue();

	EReference getArrayRefValue_Instance();

	EClass getArrayTypeRef();

	EReference getArrayTypeRef_TypeRef();

	EClass getAssignee();

	EClass getAssignment();

	EReference getAssignment_Assignee();

	EReference getAssignment_Value();

	EClass getBlock();

	EReference getBlock_Statements();

	EClass getBoolConstant();

	EAttribute getBoolConstant_Value();

	EClass getBooleanTypeRef();

	EClass getBooleanValue();

	EAttribute getBooleanValue_Value();

	EClass getCall();

	EClass getClassRef();

	EReference getClassRef_ReferencedClass();

	EClass getClazz();

	EAttribute getClazz_Isabstract();

	EReference getClazz_SuperClass();

	EClass getContext();

	EReference getContext_Bindings();

	EReference getContext_Cache();

	EReference getContext_ChildContext();

	EReference getContext_ParentContext();

	EClass getDivision();

	EReference getDivision_Left();

	EReference getDivision_Right();

	EClass getEquality();

	EReference getEquality_Left();

	EReference getEquality_Right();

	EClass getExpression();

	EClass getField();

	EReference getField_DefaultValue();

	EClass getFieldAccess();

	EReference getFieldAccess_Field();

	EReference getFieldAccess_Receiver();

	EClass getFieldBinding();

	EReference getFieldBinding_Field();

	EReference getFieldBinding_Value();

	EClass getForStatement();

	EReference getForStatement_Block();

	EReference getForStatement_Condition();

	EReference getForStatement_Declaration();

	EReference getForStatement_Progression();

	EClass getFrame();

	EReference getFrame_Call();

	EReference getFrame_ChildFrame();

	EReference getFrame_Instance();

	EReference getFrame_ParentFrame();

	EReference getFrame_ReturnValue();

	EReference getFrame_RootContext();

	EClass getIfStatement();

	EReference getIfStatement_ElseBlock();

	EReference getIfStatement_Expression();

	EReference getIfStatement_ThenBlock();

	EClass getImport();

	EAttribute getImport_ImportedNamespace();

	EClass getInequality();

	EReference getInequality_Left();

	EReference getInequality_Right();

	EClass getInferior();

	EReference getInferior_Left();

	EReference getInferior_Right();

	EClass getInferiorOrEqual();

	EReference getInferiorOrEqual_Left();

	EReference getInferiorOrEqual_Right();

	EClass getIntConstant();

	EAttribute getIntConstant_Value();

	EClass getIntegerTypeRef();

	EClass getIntegerValue();

	EAttribute getIntegerValue_Value();

	EClass getInterface();

	EClass getMember();

	EAttribute getMember_Access();

	EClass getMethod();

	EReference getMethod_Body();

	EAttribute getMethod_Isabstract();

	EAttribute getMethod_Isstatic();

	EReference getMethod_Params();

	EClass getMethodCall();

	EReference getMethodCall_Args();

	EReference getMethodCall_Method();

	EReference getMethodCall_Receiver();

	EClass getMethodCall2();

	EReference getMethodCall2_Methodcall();

	MiniJavaFactory getMiniJavaFactory();

	EClass getMinus();

	EReference getMinus_Left();

	EReference getMinus_Right();

	EClass getMultiplication();

	EReference getMultiplication_Left();

	EReference getMultiplication_Right();

	EClass getNamedElement();

	EAttribute getNamedElement_Name();

	EClass getNeg();

	EReference getNeg_Expression();

	EClass getNewArray();

	EReference getNewArray_Size();

	EReference getNewArray_Type();

	EClass getNewCall();

	EReference getNewCall_Newz();

	EClass getNewObject();

	EReference getNewObject_Args();

	EReference getNewObject_Type();

	EClass getNot();

	EReference getNot_Expression();

	EClass getNull();

	EClass getNullValue();

	EClass getObjectInstance();

	EReference getObjectInstance_Fieldbindings();

	EReference getObjectInstance_Type();

	EClass getObjectRefValue();

	EReference getObjectRefValue_Instance();

	EClass getOr();

	EReference getOr_Left();

	EReference getOr_Right();

	EClass getOutputStream();

	EAttribute getOutputStream_Stream();

	EClass getParameter();

	EClass getPlus();

	EReference getPlus_Left();

	EReference getPlus_Right();

	EClass getPrintStatement();

	EReference getPrintStatement_Expression();

	EClass getProgram();

	EReference getProgram_Classes();

	EReference getProgram_Imports();

	EAttribute getProgram_Name();

	EReference getProgram_State();

	EClass getReturn();

	EReference getReturn_Expression();

	EClass getSingleTypeRef();

	EClass getState();

	EReference getState_ArraysHeap();

	EReference getState_ContextCache();

	EReference getState_FrameCache();

	EReference getState_ObjectsHeap();

	EReference getState_OutputStream();

	EReference getState_RootFrame();

	EClass getStatement();

	EClass getStringConstant();

	EAttribute getStringConstant_Value();

	EClass getStringTypeRef();

	EClass getStringValue();

	EAttribute getStringValue_Value();

	EClass getSuper();

	EClass getSuperior();

	EReference getSuperior_Left();

	EReference getSuperior_Right();

	EClass getSuperiorOrEqual();

	EReference getSuperiorOrEqual_Left();

	EReference getSuperiorOrEqual_Right();

	EClass getSymbol();

	EClass getSymbolBinding();

	EReference getSymbolBinding_Symbol();

	EReference getSymbolBinding_Value();

	EClass getSymbolRef();

	EReference getSymbolRef_Symbol();

	EClass getSymbolToSymbolBindingMap();

	EReference getSymbolToSymbolBindingMap_Key();

	EReference getSymbolToSymbolBindingMap_Value();

	EClass getThis();

	EClass getTypedDeclaration();

	EReference getTypedDeclaration_TypeRef();

	EClass getTypeDeclaration();

	EAttribute getTypeDeclaration_AccessLevel();

	EReference getTypeDeclaration_Implementz();

	EReference getTypeDeclaration_Members();

	EClass getTypeRef();

	EClass getValue();

	EClass getVariableDeclaration();

	EClass getVoidTypeRef();

	EClass getWhileStatement();

	EReference getWhileStatement_Block();

	EReference getWhileStatement_Condition();
}
