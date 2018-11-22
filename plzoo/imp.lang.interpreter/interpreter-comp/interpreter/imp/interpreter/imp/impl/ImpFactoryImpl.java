package interpreter.imp.interpreter.imp.impl;

import interpreter.imp.interpreter.imp.Assign;
import interpreter.imp.interpreter.imp.Binary;
import interpreter.imp.interpreter.imp.Block;
import interpreter.imp.interpreter.imp.BoolValue;
import interpreter.imp.interpreter.imp.If;
import interpreter.imp.interpreter.imp.ImpFactory;
import interpreter.imp.interpreter.imp.ImpPackage;
import interpreter.imp.interpreter.imp.IntConst;
import interpreter.imp.interpreter.imp.IntValue;
import interpreter.imp.interpreter.imp.Skip;
import interpreter.imp.interpreter.imp.Store;
import interpreter.imp.interpreter.imp.Unary;
import interpreter.imp.interpreter.imp.Value;
import interpreter.imp.interpreter.imp.Var;
import interpreter.imp.interpreter.imp.While;
import java.lang.IllegalArgumentException;
import java.lang.String;
import java.util.Map;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

public class ImpFactoryImpl extends EFactoryImpl implements ImpFactory {
  public ImpFactoryImpl() {
  }

  public static ImpFactory init() {
    try {
    	ImpFactory theImpFactory = (ImpFactory) EPackage.Registry.INSTANCE.getEFactory(ImpPackage.eNS_URI);
    	if (theImpFactory != null) {
    		return theImpFactory;
    	}
    } catch (Exception exception) {
    	EcorePlugin.INSTANCE.log(exception);
    }
    return new ImpFactoryImpl();
  }

  public EObject create(EClass eClass) {
    switch (eClass.getClassifierID()) {
    case ImpPackage.SKIP:
    	return createSkip();
    case ImpPackage.ASSIGN:
    	return createAssign();
    case ImpPackage.BLOCK:
    	return createBlock();
    case ImpPackage.IF:
    	return createIf();
    case ImpPackage.WHILE:
    	return createWhile();
    case ImpPackage.INT_CONST:
    	return createIntConst();
    case ImpPackage.VAR:
    	return createVar();
    case ImpPackage.UNARY:
    	return createUnary();
    case ImpPackage.BINARY:
    	return createBinary();
    case ImpPackage.STORE:
    	return createStore();
    case ImpPackage.STRING_TO_VALUE_MAP:
    	return (org.eclipse.emf.ecore.EObject) createStringToValueMap();
    case ImpPackage.INT_VALUE:
    	return createIntValue();
    case ImpPackage.BOOL_VALUE:
    	return createBoolValue();
    default:
    	throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  public ImpPackage getImpPackage() {
    return (ImpPackage)getEPackage();}

  public Skip createSkip() {
    SkipImpl ret = new SkipImpl();
    return ret;
  }

  public Assign createAssign() {
    AssignImpl ret = new AssignImpl();
    return ret;
  }

  public Block createBlock() {
    BlockImpl ret = new BlockImpl();
    return ret;
  }

  public If createIf() {
    IfImpl ret = new IfImpl();
    return ret;
  }

  public While createWhile() {
    WhileImpl ret = new WhileImpl();
    return ret;
  }

  public IntConst createIntConst() {
    IntConstImpl ret = new IntConstImpl();
    return ret;
  }

  public Var createVar() {
    VarImpl ret = new VarImpl();
    return ret;
  }

  public Unary createUnary() {
    UnaryImpl ret = new UnaryImpl();
    return ret;
  }

  public Binary createBinary() {
    BinaryImpl ret = new BinaryImpl();
    return ret;
  }

  public Store createStore() {
    StoreImpl ret = new StoreImpl();
    return ret;
  }

  public Map.Entry<String, Value> createStringToValueMap() {
    StringToValueMapImpl ret = new StringToValueMapImpl();
    return ret;
  }

  public IntValue createIntValue() {
    IntValueImpl ret = new IntValueImpl();
    return ret;
  }

  public BoolValue createBoolValue() {
    BoolValueImpl ret = new BoolValueImpl();
    return ret;
  }
}
