package miniJava.interpreter.miniJava;

import java.lang.String;
import miniJava.interpreter.miniJava.impl.MiniJavaPackageImpl;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

public interface MiniJavaPackage extends EPackage {
  MiniJavaPackage eINSTANCE = MiniJavaPackageImpl.init();

  String eNS_URI = "http://miniJava.miniJava.miniJava/";

  String eNAME = "miniJava";

  String eNS_PREFIX = "miniJava";

  int PROGRAM = 0;

  int IMPORT = 1;

  int TYPE_DECLARATION = 2;

  int CLAZZ = 3;

  int INTERFACE = 4;

  int MEMBER = 5;

  int METHOD = 6;

  int PARAMETER = 7;

  int FIELD = 8;

  int BLOCK = 9;

  int STATEMENT = 10;

  int PRINT_STATEMENT = 11;

  int RETURN = 12;

  int IF_STATEMENT = 13;

  int WHILE_STATEMENT = 14;

  int FOR_STATEMENT = 15;

  int TYPE_REF = 16;

  int SINGLE_TYPE_REF = 17;

  int CLASS_REF = 18;

  int NAMED_ELEMENT = 19;

  int TYPED_DECLARATION = 20;

  int SYMBOL = 21;

  int VARIABLE_DECLARATION = 22;

  int ASSIGNMENT = 23;

  int ASSIGNEE = 24;

  int EXPRESSION = 25;

  int ARRAY_TYPE_REF = 26;

  int INTEGER_TYPE_REF = 27;

  int BOOLEAN_TYPE_REF = 28;

  int STRING_TYPE_REF = 29;

  int VOID_TYPE_REF = 30;

  int OR = 31;

  int AND = 32;

  int EQUALITY = 33;

  int INEQUALITY = 34;

  int SUPERIOR_OR_EQUAL = 35;

  int INFERIOR_OR_EQUAL = 36;

  int SUPERIOR = 37;

  int INFERIOR = 38;

  int PLUS = 39;

  int MINUS = 40;

  int MULTIPLICATION = 41;

  int DIVISION = 42;

  int ARRAY_ACCESS = 43;

  int ARRAY_LENGTH = 44;

  int NOT = 45;

  int NEG = 46;

  int FIELD_ACCESS = 47;

  int METHOD_CALL = 48;

  int STRING_CONSTANT = 49;

  int INT_CONSTANT = 50;

  int BOOL_CONSTANT = 51;

  int THIS = 52;

  int SUPER = 53;

  int NULL = 54;

  int NEW_OBJECT = 55;

  int NEW_ARRAY = 56;

  int SYMBOL_REF = 57;

  int CONTEXT = 58;

  int VALUE = 59;

  int INTEGER_VALUE = 60;

  int SYMBOL_BINDING = 61;

  int FIELD_BINDING = 62;

  int STRING_VALUE = 63;

  int BOOLEAN_VALUE = 64;

  int OUTPUT_STREAM = 65;

  int STATE = 66;

  int FRAME = 67;

  int NULL_VALUE = 68;

  int CALL = 69;

  int NEW_CALL = 70;

  int METHOD_CALL2 = 71;

  int OBJECT_INSTANCE = 72;

  int ARRAY_INSTANCE = 73;

  int OBJECT_REF_VALUE = 74;

  int ARRAY_REF_VALUE = 75;

  int SYMBOL_TO_SYMBOL_BINDING_MAP = 76;

  int ACCESS_LEVEL = 77;

  int PROGRAM__NAME = 0;

  int PROGRAM__IMPORTS = 1;

  int PROGRAM__CLASSES = 2;

  int PROGRAM__STATE = 3;

  int IMPORT__IMPORTED_NAMESPACE = 0;

  int TYPE_DECLARATION__ACCESS_LEVEL = 1;

  int TYPE_DECLARATION__IMPLEMENTZ = 2;

  int TYPE_DECLARATION__MEMBERS = 3;

  int CLAZZ__ISABSTRACT = 4;

  int CLAZZ__SUPER_CLASS = 5;

  int MEMBER__ACCESS = 2;

  int METHOD__ISABSTRACT = 3;

  int METHOD__ISSTATIC = 4;

  int METHOD__PARAMS = 5;

  int METHOD__BODY = 6;

  int FIELD__DEFAULT_VALUE = 3;

  int BLOCK__STATEMENTS = 0;

  int PRINT_STATEMENT__EXPRESSION = 0;

  int RETURN__EXPRESSION = 0;

  int IF_STATEMENT__EXPRESSION = 0;

  int IF_STATEMENT__THEN_BLOCK = 1;

  int IF_STATEMENT__ELSE_BLOCK = 2;

  int WHILE_STATEMENT__CONDITION = 0;

  int WHILE_STATEMENT__BLOCK = 1;

  int FOR_STATEMENT__DECLARATION = 0;

  int FOR_STATEMENT__CONDITION = 1;

  int FOR_STATEMENT__PROGRESSION = 2;

  int FOR_STATEMENT__BLOCK = 3;

  int CLASS_REF__REFERENCED_CLASS = 0;

  int NAMED_ELEMENT__NAME = 0;

  int TYPED_DECLARATION__TYPE_REF = 1;

  int ASSIGNMENT__ASSIGNEE = 0;

  int ASSIGNMENT__VALUE = 1;

  int ARRAY_TYPE_REF__TYPE_REF = 0;

  int OR__LEFT = 0;

  int OR__RIGHT = 1;

  int AND__LEFT = 0;

  int AND__RIGHT = 1;

  int EQUALITY__LEFT = 0;

  int EQUALITY__RIGHT = 1;

  int INEQUALITY__LEFT = 0;

  int INEQUALITY__RIGHT = 1;

  int SUPERIOR_OR_EQUAL__LEFT = 0;

  int SUPERIOR_OR_EQUAL__RIGHT = 1;

  int INFERIOR_OR_EQUAL__LEFT = 0;

  int INFERIOR_OR_EQUAL__RIGHT = 1;

  int SUPERIOR__LEFT = 0;

  int SUPERIOR__RIGHT = 1;

  int INFERIOR__LEFT = 0;

  int INFERIOR__RIGHT = 1;

  int PLUS__LEFT = 0;

  int PLUS__RIGHT = 1;

  int MINUS__LEFT = 0;

  int MINUS__RIGHT = 1;

  int MULTIPLICATION__LEFT = 0;

  int MULTIPLICATION__RIGHT = 1;

  int DIVISION__LEFT = 0;

  int DIVISION__RIGHT = 1;

  int ARRAY_ACCESS__OBJECT = 0;

  int ARRAY_ACCESS__INDEX = 1;

  int ARRAY_LENGTH__ARRAY = 0;

  int NOT__EXPRESSION = 0;

  int NEG__EXPRESSION = 0;

  int FIELD_ACCESS__RECEIVER = 0;

  int FIELD_ACCESS__FIELD = 1;

  int METHOD_CALL__RECEIVER = 0;

  int METHOD_CALL__METHOD = 1;

  int METHOD_CALL__ARGS = 2;

  int STRING_CONSTANT__VALUE = 0;

  int INT_CONSTANT__VALUE = 0;

  int BOOL_CONSTANT__VALUE = 0;

  int NEW_OBJECT__TYPE = 0;

  int NEW_OBJECT__ARGS = 1;

  int NEW_ARRAY__TYPE = 0;

  int NEW_ARRAY__SIZE = 1;

  int SYMBOL_REF__SYMBOL = 0;

  int CONTEXT__BINDINGS = 0;

  int CONTEXT__PARENT_CONTEXT = 1;

  int CONTEXT__CHILD_CONTEXT = 2;

  int CONTEXT__CACHE = 3;

  int INTEGER_VALUE__VALUE = 0;

  int SYMBOL_BINDING__VALUE = 0;

  int SYMBOL_BINDING__SYMBOL = 1;

  int FIELD_BINDING__FIELD = 0;

  int FIELD_BINDING__VALUE = 1;

  int STRING_VALUE__VALUE = 0;

  int BOOLEAN_VALUE__VALUE = 0;

  int OUTPUT_STREAM__STREAM = 0;

  int STATE__ROOT_FRAME = 0;

  int STATE__OBJECTS_HEAP = 1;

  int STATE__OUTPUT_STREAM = 2;

  int STATE__ARRAYS_HEAP = 3;

  int STATE__CONTEXT_CACHE = 4;

  int STATE__FRAME_CACHE = 5;

  int FRAME__CALL = 0;

  int FRAME__INSTANCE = 1;

  int FRAME__CHILD_FRAME = 2;

  int FRAME__PARENT_FRAME = 3;

  int FRAME__ROOT_CONTEXT = 4;

  int FRAME__RETURN_VALUE = 5;

  int NEW_CALL__NEWZ = 0;

  int METHOD_CALL2__METHODCALL = 0;

  int OBJECT_INSTANCE__FIELDBINDINGS = 0;

  int OBJECT_INSTANCE__TYPE = 1;

  int ARRAY_INSTANCE__VALUE = 0;

  int ARRAY_INSTANCE__SIZE = 1;

  int OBJECT_REF_VALUE__INSTANCE = 0;

  int ARRAY_REF_VALUE__INSTANCE = 0;

  int SYMBOL_TO_SYMBOL_BINDING_MAP__KEY = 0;

  int SYMBOL_TO_SYMBOL_BINDING_MAP__VALUE = 1;

  EClass getProgram();

  EClass getImport();

  EClass getTypeDeclaration();

  EClass getClazz();

  EClass getInterface();

  EClass getMember();

  EClass getMethod();

  EClass getParameter();

  EClass getField();

  EClass getBlock();

  EClass getStatement();

  EClass getPrintStatement();

  EClass getReturn();

  EClass getIfStatement();

  EClass getWhileStatement();

  EClass getForStatement();

  EClass getTypeRef();

  EClass getSingleTypeRef();

  EClass getClassRef();

  EClass getNamedElement();

  EClass getTypedDeclaration();

  EClass getSymbol();

  EClass getVariableDeclaration();

  EClass getAssignment();

  EClass getAssignee();

  EClass getExpression();

  EClass getArrayTypeRef();

  EClass getIntegerTypeRef();

  EClass getBooleanTypeRef();

  EClass getStringTypeRef();

  EClass getVoidTypeRef();

  EClass getOr();

  EClass getAnd();

  EClass getEquality();

  EClass getInequality();

  EClass getSuperiorOrEqual();

  EClass getInferiorOrEqual();

  EClass getSuperior();

  EClass getInferior();

  EClass getPlus();

  EClass getMinus();

  EClass getMultiplication();

  EClass getDivision();

  EClass getArrayAccess();

  EClass getArrayLength();

  EClass getNot();

  EClass getNeg();

  EClass getFieldAccess();

  EClass getMethodCall();

  EClass getStringConstant();

  EClass getIntConstant();

  EClass getBoolConstant();

  EClass getThis();

  EClass getSuper();

  EClass getNull();

  EClass getNewObject();

  EClass getNewArray();

  EClass getSymbolRef();

  EClass getContext();

  EClass getValue();

  EClass getIntegerValue();

  EClass getSymbolBinding();

  EClass getFieldBinding();

  EClass getStringValue();

  EClass getBooleanValue();

  EClass getOutputStream();

  EClass getState();

  EClass getFrame();

  EClass getNullValue();

  EClass getCall();

  EClass getNewCall();

  EClass getMethodCall2();

  EClass getObjectInstance();

  EClass getArrayInstance();

  EClass getObjectRefValue();

  EClass getArrayRefValue();

  EClass getSymbolToSymbolBindingMap();

  EEnum getAccessLevel();

  EReference getProgram_Imports();

  EReference getProgram_Classes();

  EReference getProgram_State();

  EReference getTypeDeclaration_Implementz();

  EReference getTypeDeclaration_Members();

  EReference getClazz_SuperClass();

  EReference getMethod_Params();

  EReference getMethod_Body();

  EReference getField_DefaultValue();

  EReference getBlock_Statements();

  EReference getPrintStatement_Expression();

  EReference getReturn_Expression();

  EReference getIfStatement_Expression();

  EReference getIfStatement_ThenBlock();

  EReference getIfStatement_ElseBlock();

  EReference getWhileStatement_Condition();

  EReference getWhileStatement_Block();

  EReference getForStatement_Declaration();

  EReference getForStatement_Condition();

  EReference getForStatement_Progression();

  EReference getForStatement_Block();

  EReference getClassRef_ReferencedClass();

  EReference getTypedDeclaration_TypeRef();

  EReference getAssignment_Assignee();

  EReference getAssignment_Value();

  EReference getArrayTypeRef_TypeRef();

  EReference getOr_Left();

  EReference getOr_Right();

  EReference getAnd_Left();

  EReference getAnd_Right();

  EReference getEquality_Left();

  EReference getEquality_Right();

  EReference getInequality_Left();

  EReference getInequality_Right();

  EReference getSuperiorOrEqual_Left();

  EReference getSuperiorOrEqual_Right();

  EReference getInferiorOrEqual_Left();

  EReference getInferiorOrEqual_Right();

  EReference getSuperior_Left();

  EReference getSuperior_Right();

  EReference getInferior_Left();

  EReference getInferior_Right();

  EReference getPlus_Left();

  EReference getPlus_Right();

  EReference getMinus_Left();

  EReference getMinus_Right();

  EReference getMultiplication_Left();

  EReference getMultiplication_Right();

  EReference getDivision_Left();

  EReference getDivision_Right();

  EReference getArrayAccess_Object();

  EReference getArrayAccess_Index();

  EReference getArrayLength_Array();

  EReference getNot_Expression();

  EReference getNeg_Expression();

  EReference getFieldAccess_Receiver();

  EReference getFieldAccess_Field();

  EReference getMethodCall_Receiver();

  EReference getMethodCall_Method();

  EReference getMethodCall_Args();

  EReference getNewObject_Type();

  EReference getNewObject_Args();

  EReference getNewArray_Type();

  EReference getNewArray_Size();

  EReference getSymbolRef_Symbol();

  EReference getContext_Bindings();

  EReference getContext_ParentContext();

  EReference getContext_ChildContext();

  EReference getContext_Cache();

  EReference getSymbolBinding_Value();

  EReference getSymbolBinding_Symbol();

  EReference getFieldBinding_Field();

  EReference getFieldBinding_Value();

  EReference getState_RootFrame();

  EReference getState_ObjectsHeap();

  EReference getState_OutputStream();

  EReference getState_ArraysHeap();

  EReference getState_ContextCache();

  EReference getState_FrameCache();

  EReference getFrame_Call();

  EReference getFrame_Instance();

  EReference getFrame_ChildFrame();

  EReference getFrame_ParentFrame();

  EReference getFrame_RootContext();

  EReference getFrame_ReturnValue();

  EReference getNewCall_Newz();

  EReference getMethodCall2_Methodcall();

  EReference getObjectInstance_Fieldbindings();

  EReference getObjectInstance_Type();

  EReference getArrayInstance_Value();

  EReference getObjectRefValue_Instance();

  EReference getArrayRefValue_Instance();

  EReference getSymbolToSymbolBindingMap_Key();

  EReference getSymbolToSymbolBindingMap_Value();

  EAttribute getProgram_Name();

  EAttribute getImport_ImportedNamespace();

  EAttribute getTypeDeclaration_AccessLevel();

  EAttribute getClazz_Isabstract();

  EAttribute getMember_Access();

  EAttribute getMethod_Isabstract();

  EAttribute getMethod_Isstatic();

  EAttribute getNamedElement_Name();

  EAttribute getStringConstant_Value();

  EAttribute getIntConstant_Value();

  EAttribute getBoolConstant_Value();

  EAttribute getIntegerValue_Value();

  EAttribute getStringValue_Value();

  EAttribute getBooleanValue_Value();

  EAttribute getOutputStream_Stream();

  EAttribute getArrayInstance_Size();

  MiniJavaFactory getMiniJavaFactory();

  interface Literals {
    EClass PROGRAM = eINSTANCE.getProgram();

    EClass IMPORT = eINSTANCE.getImport();

    EClass TYPE_DECLARATION = eINSTANCE.getTypeDeclaration();

    EClass CLAZZ = eINSTANCE.getClazz();

    EClass INTERFACE = eINSTANCE.getInterface();

    EClass MEMBER = eINSTANCE.getMember();

    EClass METHOD = eINSTANCE.getMethod();

    EClass PARAMETER = eINSTANCE.getParameter();

    EClass FIELD = eINSTANCE.getField();

    EClass BLOCK = eINSTANCE.getBlock();

    EClass STATEMENT = eINSTANCE.getStatement();

    EClass PRINT_STATEMENT = eINSTANCE.getPrintStatement();

    EClass RETURN = eINSTANCE.getReturn();

    EClass IF_STATEMENT = eINSTANCE.getIfStatement();

    EClass WHILE_STATEMENT = eINSTANCE.getWhileStatement();

    EClass FOR_STATEMENT = eINSTANCE.getForStatement();

    EClass TYPE_REF = eINSTANCE.getTypeRef();

    EClass SINGLE_TYPE_REF = eINSTANCE.getSingleTypeRef();

    EClass CLASS_REF = eINSTANCE.getClassRef();

    EClass NAMED_ELEMENT = eINSTANCE.getNamedElement();

    EClass TYPED_DECLARATION = eINSTANCE.getTypedDeclaration();

    EClass SYMBOL = eINSTANCE.getSymbol();

    EClass VARIABLE_DECLARATION = eINSTANCE.getVariableDeclaration();

    EClass ASSIGNMENT = eINSTANCE.getAssignment();

    EClass ASSIGNEE = eINSTANCE.getAssignee();

    EClass EXPRESSION = eINSTANCE.getExpression();

    EClass ARRAY_TYPE_REF = eINSTANCE.getArrayTypeRef();

    EClass INTEGER_TYPE_REF = eINSTANCE.getIntegerTypeRef();

    EClass BOOLEAN_TYPE_REF = eINSTANCE.getBooleanTypeRef();

    EClass STRING_TYPE_REF = eINSTANCE.getStringTypeRef();

    EClass VOID_TYPE_REF = eINSTANCE.getVoidTypeRef();

    EClass OR = eINSTANCE.getOr();

    EClass AND = eINSTANCE.getAnd();

    EClass EQUALITY = eINSTANCE.getEquality();

    EClass INEQUALITY = eINSTANCE.getInequality();

    EClass SUPERIOR_OR_EQUAL = eINSTANCE.getSuperiorOrEqual();

    EClass INFERIOR_OR_EQUAL = eINSTANCE.getInferiorOrEqual();

    EClass SUPERIOR = eINSTANCE.getSuperior();

    EClass INFERIOR = eINSTANCE.getInferior();

    EClass PLUS = eINSTANCE.getPlus();

    EClass MINUS = eINSTANCE.getMinus();

    EClass MULTIPLICATION = eINSTANCE.getMultiplication();

    EClass DIVISION = eINSTANCE.getDivision();

    EClass ARRAY_ACCESS = eINSTANCE.getArrayAccess();

    EClass ARRAY_LENGTH = eINSTANCE.getArrayLength();

    EClass NOT = eINSTANCE.getNot();

    EClass NEG = eINSTANCE.getNeg();

    EClass FIELD_ACCESS = eINSTANCE.getFieldAccess();

    EClass METHOD_CALL = eINSTANCE.getMethodCall();

    EClass STRING_CONSTANT = eINSTANCE.getStringConstant();

    EClass INT_CONSTANT = eINSTANCE.getIntConstant();

    EClass BOOL_CONSTANT = eINSTANCE.getBoolConstant();

    EClass THIS = eINSTANCE.getThis();

    EClass SUPER = eINSTANCE.getSuper();

    EClass NULL = eINSTANCE.getNull();

    EClass NEW_OBJECT = eINSTANCE.getNewObject();

    EClass NEW_ARRAY = eINSTANCE.getNewArray();

    EClass SYMBOL_REF = eINSTANCE.getSymbolRef();

    EClass CONTEXT = eINSTANCE.getContext();

    EClass VALUE = eINSTANCE.getValue();

    EClass INTEGER_VALUE = eINSTANCE.getIntegerValue();

    EClass SYMBOL_BINDING = eINSTANCE.getSymbolBinding();

    EClass FIELD_BINDING = eINSTANCE.getFieldBinding();

    EClass STRING_VALUE = eINSTANCE.getStringValue();

    EClass BOOLEAN_VALUE = eINSTANCE.getBooleanValue();

    EClass OUTPUT_STREAM = eINSTANCE.getOutputStream();

    EClass STATE = eINSTANCE.getState();

    EClass FRAME = eINSTANCE.getFrame();

    EClass NULL_VALUE = eINSTANCE.getNullValue();

    EClass CALL = eINSTANCE.getCall();

    EClass NEW_CALL = eINSTANCE.getNewCall();

    EClass METHOD_CALL2 = eINSTANCE.getMethodCall2();

    EClass OBJECT_INSTANCE = eINSTANCE.getObjectInstance();

    EClass ARRAY_INSTANCE = eINSTANCE.getArrayInstance();

    EClass OBJECT_REF_VALUE = eINSTANCE.getObjectRefValue();

    EClass ARRAY_REF_VALUE = eINSTANCE.getArrayRefValue();

    EClass SYMBOL_TO_SYMBOL_BINDING_MAP = eINSTANCE.getSymbolToSymbolBindingMap();

    EReference PROGRAM__IMPORTS = eINSTANCE.getProgram_Imports();

    EReference PROGRAM__CLASSES = eINSTANCE.getProgram_Classes();

    EReference PROGRAM__STATE = eINSTANCE.getProgram_State();

    EReference TYPE_DECLARATION__IMPLEMENTZ = eINSTANCE.getTypeDeclaration_Implementz();

    EReference TYPE_DECLARATION__MEMBERS = eINSTANCE.getTypeDeclaration_Members();

    EReference CLAZZ__SUPER_CLASS = eINSTANCE.getClazz_SuperClass();

    EReference METHOD__PARAMS = eINSTANCE.getMethod_Params();

    EReference METHOD__BODY = eINSTANCE.getMethod_Body();

    EReference FIELD__DEFAULT_VALUE = eINSTANCE.getField_DefaultValue();

    EReference BLOCK__STATEMENTS = eINSTANCE.getBlock_Statements();

    EReference PRINT_STATEMENT__EXPRESSION = eINSTANCE.getPrintStatement_Expression();

    EReference RETURN__EXPRESSION = eINSTANCE.getReturn_Expression();

    EReference IF_STATEMENT__EXPRESSION = eINSTANCE.getIfStatement_Expression();

    EReference IF_STATEMENT__THEN_BLOCK = eINSTANCE.getIfStatement_ThenBlock();

    EReference IF_STATEMENT__ELSE_BLOCK = eINSTANCE.getIfStatement_ElseBlock();

    EReference WHILE_STATEMENT__CONDITION = eINSTANCE.getWhileStatement_Condition();

    EReference WHILE_STATEMENT__BLOCK = eINSTANCE.getWhileStatement_Block();

    EReference FOR_STATEMENT__DECLARATION = eINSTANCE.getForStatement_Declaration();

    EReference FOR_STATEMENT__CONDITION = eINSTANCE.getForStatement_Condition();

    EReference FOR_STATEMENT__PROGRESSION = eINSTANCE.getForStatement_Progression();

    EReference FOR_STATEMENT__BLOCK = eINSTANCE.getForStatement_Block();

    EReference CLASS_REF__REFERENCED_CLASS = eINSTANCE.getClassRef_ReferencedClass();

    EReference TYPED_DECLARATION__TYPE_REF = eINSTANCE.getTypedDeclaration_TypeRef();

    EReference ASSIGNMENT__ASSIGNEE = eINSTANCE.getAssignment_Assignee();

    EReference ASSIGNMENT__VALUE = eINSTANCE.getAssignment_Value();

    EReference ARRAY_TYPE_REF__TYPE_REF = eINSTANCE.getArrayTypeRef_TypeRef();

    EReference OR__LEFT = eINSTANCE.getOr_Left();

    EReference OR__RIGHT = eINSTANCE.getOr_Right();

    EReference AND__LEFT = eINSTANCE.getAnd_Left();

    EReference AND__RIGHT = eINSTANCE.getAnd_Right();

    EReference EQUALITY__LEFT = eINSTANCE.getEquality_Left();

    EReference EQUALITY__RIGHT = eINSTANCE.getEquality_Right();

    EReference INEQUALITY__LEFT = eINSTANCE.getInequality_Left();

    EReference INEQUALITY__RIGHT = eINSTANCE.getInequality_Right();

    EReference SUPERIOR_OR_EQUAL__LEFT = eINSTANCE.getSuperiorOrEqual_Left();

    EReference SUPERIOR_OR_EQUAL__RIGHT = eINSTANCE.getSuperiorOrEqual_Right();

    EReference INFERIOR_OR_EQUAL__LEFT = eINSTANCE.getInferiorOrEqual_Left();

    EReference INFERIOR_OR_EQUAL__RIGHT = eINSTANCE.getInferiorOrEqual_Right();

    EReference SUPERIOR__LEFT = eINSTANCE.getSuperior_Left();

    EReference SUPERIOR__RIGHT = eINSTANCE.getSuperior_Right();

    EReference INFERIOR__LEFT = eINSTANCE.getInferior_Left();

    EReference INFERIOR__RIGHT = eINSTANCE.getInferior_Right();

    EReference PLUS__LEFT = eINSTANCE.getPlus_Left();

    EReference PLUS__RIGHT = eINSTANCE.getPlus_Right();

    EReference MINUS__LEFT = eINSTANCE.getMinus_Left();

    EReference MINUS__RIGHT = eINSTANCE.getMinus_Right();

    EReference MULTIPLICATION__LEFT = eINSTANCE.getMultiplication_Left();

    EReference MULTIPLICATION__RIGHT = eINSTANCE.getMultiplication_Right();

    EReference DIVISION__LEFT = eINSTANCE.getDivision_Left();

    EReference DIVISION__RIGHT = eINSTANCE.getDivision_Right();

    EReference ARRAY_ACCESS__OBJECT = eINSTANCE.getArrayAccess_Object();

    EReference ARRAY_ACCESS__INDEX = eINSTANCE.getArrayAccess_Index();

    EReference ARRAY_LENGTH__ARRAY = eINSTANCE.getArrayLength_Array();

    EReference NOT__EXPRESSION = eINSTANCE.getNot_Expression();

    EReference NEG__EXPRESSION = eINSTANCE.getNeg_Expression();

    EReference FIELD_ACCESS__RECEIVER = eINSTANCE.getFieldAccess_Receiver();

    EReference FIELD_ACCESS__FIELD = eINSTANCE.getFieldAccess_Field();

    EReference METHOD_CALL__RECEIVER = eINSTANCE.getMethodCall_Receiver();

    EReference METHOD_CALL__METHOD = eINSTANCE.getMethodCall_Method();

    EReference METHOD_CALL__ARGS = eINSTANCE.getMethodCall_Args();

    EReference NEW_OBJECT__TYPE = eINSTANCE.getNewObject_Type();

    EReference NEW_OBJECT__ARGS = eINSTANCE.getNewObject_Args();

    EReference NEW_ARRAY__TYPE = eINSTANCE.getNewArray_Type();

    EReference NEW_ARRAY__SIZE = eINSTANCE.getNewArray_Size();

    EReference SYMBOL_REF__SYMBOL = eINSTANCE.getSymbolRef_Symbol();

    EReference CONTEXT__BINDINGS = eINSTANCE.getContext_Bindings();

    EReference CONTEXT__PARENT_CONTEXT = eINSTANCE.getContext_ParentContext();

    EReference CONTEXT__CHILD_CONTEXT = eINSTANCE.getContext_ChildContext();

    EReference CONTEXT__CACHE = eINSTANCE.getContext_Cache();

    EReference SYMBOL_BINDING__VALUE = eINSTANCE.getSymbolBinding_Value();

    EReference SYMBOL_BINDING__SYMBOL = eINSTANCE.getSymbolBinding_Symbol();

    EReference FIELD_BINDING__FIELD = eINSTANCE.getFieldBinding_Field();

    EReference FIELD_BINDING__VALUE = eINSTANCE.getFieldBinding_Value();

    EReference STATE__ROOT_FRAME = eINSTANCE.getState_RootFrame();

    EReference STATE__OBJECTS_HEAP = eINSTANCE.getState_ObjectsHeap();

    EReference STATE__OUTPUT_STREAM = eINSTANCE.getState_OutputStream();

    EReference STATE__ARRAYS_HEAP = eINSTANCE.getState_ArraysHeap();

    EReference STATE__CONTEXT_CACHE = eINSTANCE.getState_ContextCache();

    EReference STATE__FRAME_CACHE = eINSTANCE.getState_FrameCache();

    EReference FRAME__CALL = eINSTANCE.getFrame_Call();

    EReference FRAME__INSTANCE = eINSTANCE.getFrame_Instance();

    EReference FRAME__CHILD_FRAME = eINSTANCE.getFrame_ChildFrame();

    EReference FRAME__PARENT_FRAME = eINSTANCE.getFrame_ParentFrame();

    EReference FRAME__ROOT_CONTEXT = eINSTANCE.getFrame_RootContext();

    EReference FRAME__RETURN_VALUE = eINSTANCE.getFrame_ReturnValue();

    EReference NEW_CALL__NEWZ = eINSTANCE.getNewCall_Newz();

    EReference METHOD_CALL2__METHODCALL = eINSTANCE.getMethodCall2_Methodcall();

    EReference OBJECT_INSTANCE__FIELDBINDINGS = eINSTANCE.getObjectInstance_Fieldbindings();

    EReference OBJECT_INSTANCE__TYPE = eINSTANCE.getObjectInstance_Type();

    EReference ARRAY_INSTANCE__VALUE = eINSTANCE.getArrayInstance_Value();

    EReference OBJECT_REF_VALUE__INSTANCE = eINSTANCE.getObjectRefValue_Instance();

    EReference ARRAY_REF_VALUE__INSTANCE = eINSTANCE.getArrayRefValue_Instance();

    EReference SYMBOL_TO_SYMBOL_BINDING_MAP__KEY = eINSTANCE.getSymbolToSymbolBindingMap_Key();

    EReference SYMBOL_TO_SYMBOL_BINDING_MAP__VALUE = eINSTANCE.getSymbolToSymbolBindingMap_Value();

    EAttribute PROGRAM__NAME = eINSTANCE.getProgram_Name();

    EAttribute IMPORT__IMPORTED_NAMESPACE = eINSTANCE.getImport_ImportedNamespace();

    EAttribute TYPE_DECLARATION__ACCESS_LEVEL = eINSTANCE.getTypeDeclaration_AccessLevel();

    EAttribute CLAZZ__ISABSTRACT = eINSTANCE.getClazz_Isabstract();

    EAttribute MEMBER__ACCESS = eINSTANCE.getMember_Access();

    EAttribute METHOD__ISABSTRACT = eINSTANCE.getMethod_Isabstract();

    EAttribute METHOD__ISSTATIC = eINSTANCE.getMethod_Isstatic();

    EAttribute NAMED_ELEMENT__NAME = eINSTANCE.getNamedElement_Name();

    EAttribute STRING_CONSTANT__VALUE = eINSTANCE.getStringConstant_Value();

    EAttribute INT_CONSTANT__VALUE = eINSTANCE.getIntConstant_Value();

    EAttribute BOOL_CONSTANT__VALUE = eINSTANCE.getBoolConstant_Value();

    EAttribute INTEGER_VALUE__VALUE = eINSTANCE.getIntegerValue_Value();

    EAttribute STRING_VALUE__VALUE = eINSTANCE.getStringValue_Value();

    EAttribute BOOLEAN_VALUE__VALUE = eINSTANCE.getBooleanValue_Value();

    EAttribute OUTPUT_STREAM__STREAM = eINSTANCE.getOutputStream_Stream();

    EAttribute ARRAY_INSTANCE__SIZE = eINSTANCE.getArrayInstance_Size();
  }
}
