package org.eclipse.emf.ecoretools.ale.compiler.interpreter;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.CodeBlock;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PrimitiveIterator;
import java.util.Set;
import java.util.stream.IntStream;
import org.eclipse.acceleo.query.ast.And;
import org.eclipse.acceleo.query.ast.BooleanLiteral;
import org.eclipse.acceleo.query.ast.Call;
import org.eclipse.acceleo.query.ast.CallType;
import org.eclipse.acceleo.query.ast.EnumLiteral;
import org.eclipse.acceleo.query.ast.ErrorBinding;
import org.eclipse.acceleo.query.ast.ErrorCall;
import org.eclipse.acceleo.query.ast.ErrorConditional;
import org.eclipse.acceleo.query.ast.ErrorExpression;
import org.eclipse.acceleo.query.ast.ErrorStringLiteral;
import org.eclipse.acceleo.query.ast.ErrorTypeLiteral;
import org.eclipse.acceleo.query.ast.ErrorVariableDeclaration;
import org.eclipse.acceleo.query.ast.Expression;
import org.eclipse.acceleo.query.ast.Implies;
import org.eclipse.acceleo.query.ast.IntegerLiteral;
import org.eclipse.acceleo.query.ast.Lambda;
import org.eclipse.acceleo.query.ast.Let;
import org.eclipse.acceleo.query.ast.NullLiteral;
import org.eclipse.acceleo.query.ast.Or;
import org.eclipse.acceleo.query.ast.RealLiteral;
import org.eclipse.acceleo.query.ast.SequenceInExtensionLiteral;
import org.eclipse.acceleo.query.ast.SetInExtensionLiteral;
import org.eclipse.acceleo.query.ast.StringLiteral;
import org.eclipse.acceleo.query.ast.TypeLiteral;
import org.eclipse.acceleo.query.ast.VarRef;
import org.eclipse.acceleo.query.ast.VariableDeclaration;
import org.eclipse.acceleo.query.validation.type.EClassifierType;
import org.eclipse.acceleo.query.validation.type.IType;
import org.eclipse.acceleo.query.validation.type.SequenceType;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecoretools.ale.compiler.interpreter.ALEInterpreterImplementationCompiler;
import org.eclipse.emf.ecoretools.ale.compiler.interpreter.EClassImplementationCompiler;
import org.eclipse.emf.ecoretools.ale.compiler.interpreter.InterpreterNamingUtils;
import org.eclipse.emf.ecoretools.ale.compiler.interpreter.TypeSystemUtils;
import org.eclipse.emf.ecoretools.ale.core.validation.BaseValidator;
import org.eclipse.emf.ecoretools.ale.implementation.ExpressionStatement;
import org.eclipse.emf.ecoretools.ale.implementation.ExtendedClass;
import org.eclipse.emf.ecoretools.ale.implementation.Method;
import org.eclipse.emf.ecoretools.ale.implementation.Switch;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class AleExpressionsCompiler {
  @Extension
  private TypeSystemUtils tsu;
  
  @Extension
  private InterpreterNamingUtils namingUtils = new InterpreterNamingUtils();
  
  private final String packageRoot;
  
  private List<ALEInterpreterImplementationCompiler.ResolvedClass> resolved;
  
  private final Set<Method> registreredDispatch;
  
  private final Map<String, Class<?>> registeredServices;
  
  private final Set<String> registeredArray;
  
  private final boolean isTruffle;
  
  private final ClassName collectionServiceClassName = ClassName.get("org.eclipse.emf.ecoretools.ale.compiler.lib", "CollectionService");
  
  private final ClassName equalServiceClassName = ClassName.get("org.eclipse.emf.ecoretools.ale.compiler.lib", "EqualService");
  
  private final ClassName logServiceClassName = ClassName.get("org.eclipse.emf.ecoretools.ale.compiler.lib", "LogService");
  
  public AleExpressionsCompiler(final Map<String, Pair<EPackage, GenModel>> syntaxes, final String packageRoot, final BaseValidator base, final List<ALEInterpreterImplementationCompiler.ResolvedClass> resolved, final Set<Method> registreredDispatch, final Set<String> registeredArray, final Map<String, Class<?>> registeredServices, final boolean isTruffle) {
    this.packageRoot = packageRoot;
    this.resolved = resolved;
    TypeSystemUtils _typeSystemUtils = new TypeSystemUtils(syntaxes, packageRoot, base, resolved);
    this.tsu = _typeSystemUtils;
    this.registreredDispatch = registreredDispatch;
    this.registeredServices = registeredServices;
    this.registeredArray = registeredArray;
    this.isTruffle = isTruffle;
  }
  
  protected CodeBlock _compileExpression(final Call call, final EClassImplementationCompiler.CompilerExpressionCtx ctx) {
    CodeBlock _switchResult = null;
    String _serviceName = call.getServiceName();
    boolean _matched = false;
    if (Objects.equal(_serviceName, "not")) {
      _matched=true;
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("!($L)");
      _switchResult = CodeBlock.of(_builder.toString(), this.compileExpression(call.getArguments().get(0), ctx));
    }
    if (!_matched) {
      if (Objects.equal(_serviceName, "greaterThan")) {
        _matched=true;
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("($L) > ($L)");
        _switchResult = CodeBlock.of(_builder_1.toString(), this.compileExpression(call.getArguments().get(0), ctx), this.compileExpression(call.getArguments().get(1), ctx));
      }
    }
    if (!_matched) {
      if (Objects.equal(_serviceName, "differs")) {
        _matched=true;
        StringConcatenation _builder_2 = new StringConcatenation();
        _builder_2.append("!$T.equals(($L), ($L))");
        _switchResult = CodeBlock.of(_builder_2.toString(), this.equalServiceClassName, 
          this.compileExpression(call.getArguments().get(0), ctx), this.compileExpression(call.getArguments().get(1), ctx));
      }
    }
    if (!_matched) {
      if (Objects.equal(_serviceName, "sub")) {
        _matched=true;
        StringConcatenation _builder_3 = new StringConcatenation();
        _builder_3.append("($L) - ($L)");
        _switchResult = CodeBlock.of(_builder_3.toString(), this.compileExpression(call.getArguments().get(0), ctx), 
          this.compileExpression(call.getArguments().get(1), ctx));
      }
    }
    if (!_matched) {
      if ((Objects.equal(call.getServiceName(), "add") && Objects.equal(call.getType(), CallType.CALLSERVICE))) {
        _matched=true;
        StringConcatenation _builder_4 = new StringConcatenation();
        _builder_4.append("($L) + ($L)");
        _switchResult = CodeBlock.of(_builder_4.toString(), this.compileExpression(call.getArguments().get(0), ctx), 
          this.compileExpression(call.getArguments().get(1), ctx));
      }
    }
    if (!_matched) {
      if (Objects.equal(_serviceName, "divOp")) {
        _matched=true;
        StringConcatenation _builder_5 = new StringConcatenation();
        _builder_5.append("($L) / ($L)");
        _switchResult = CodeBlock.of(_builder_5.toString(), this.compileExpression(call.getArguments().get(0), ctx), 
          this.compileExpression(call.getArguments().get(1), ctx));
      }
    }
    if (!_matched) {
      if (Objects.equal(_serviceName, "equals")) {
        _matched=true;
        StringConcatenation _builder_6 = new StringConcatenation();
        _builder_6.append("$T.equals(($L), ($L))");
        _switchResult = CodeBlock.of(_builder_6.toString(), this.equalServiceClassName, 
          this.compileExpression(call.getArguments().get(0), ctx), this.compileExpression(call.getArguments().get(1), ctx));
      }
    }
    if (!_matched) {
      if (Objects.equal(_serviceName, "lessThan")) {
        _matched=true;
        StringConcatenation _builder_7 = new StringConcatenation();
        _builder_7.append("($L) < ($L)");
        _switchResult = CodeBlock.of(_builder_7.toString(), this.compileExpression(call.getArguments().get(0), ctx), 
          this.compileExpression(call.getArguments().get(1), ctx));
      }
    }
    if (!_matched) {
      if (Objects.equal(_serviceName, "lessThanEqual")) {
        _matched=true;
        StringConcatenation _builder_8 = new StringConcatenation();
        _builder_8.append("($L) <= ($L)");
        _switchResult = CodeBlock.of(_builder_8.toString(), this.compileExpression(call.getArguments().get(0), ctx), 
          this.compileExpression(call.getArguments().get(1), ctx));
      }
    }
    if (!_matched) {
      if (Objects.equal(_serviceName, "greaterThanEqual")) {
        _matched=true;
        StringConcatenation _builder_9 = new StringConcatenation();
        _builder_9.append("($L) >= ($L)");
        _switchResult = CodeBlock.of(_builder_9.toString(), this.compileExpression(call.getArguments().get(0), ctx), 
          this.compileExpression(call.getArguments().get(1), ctx));
      }
    }
    if (!_matched) {
      if (Objects.equal(_serviceName, "mult")) {
        _matched=true;
        StringConcatenation _builder_10 = new StringConcatenation();
        _builder_10.append("($L) * ($L)");
        _switchResult = CodeBlock.of(_builder_10.toString(), this.compileExpression(call.getArguments().get(0), ctx), 
          this.compileExpression(call.getArguments().get(1), ctx));
      }
    }
    if (!_matched) {
      if (Objects.equal(_serviceName, "unaryMin")) {
        _matched=true;
        StringConcatenation _builder_11 = new StringConcatenation();
        _builder_11.append("-($L)");
        _switchResult = CodeBlock.of(_builder_11.toString(), this.compileExpression(call.getArguments().get(0), ctx));
      }
    }
    if (!_matched) {
      if (Objects.equal(_serviceName, "first")) {
        _matched=true;
        CodeBlock _xifexpression = null;
        CallType _type = call.getType();
        boolean _equals = Objects.equal(_type, CallType.COLLECTIONCALL);
        if (_equals) {
          StringConcatenation _builder_12 = new StringConcatenation();
          _builder_12.append("$T.head($L)");
          _xifexpression = CodeBlock.of(_builder_12.toString(), this.collectionServiceClassName, 
            this.compileExpression(call.getArguments().get(0), ctx));
        } else {
          StringConcatenation _builder_13 = new StringConcatenation();
          _builder_13.append("/*FIRST ");
          _builder_13.append(call);
          _builder_13.append("*/");
          _xifexpression = CodeBlock.of(_builder_13.toString());
        }
        _switchResult = _xifexpression;
      }
    }
    if (!_matched) {
      if (Objects.equal(_serviceName, "size")) {
        _matched=true;
        CodeBlock _xifexpression_1 = null;
        CallType _type_1 = call.getType();
        boolean _equals_1 = Objects.equal(_type_1, CallType.COLLECTIONCALL);
        if (_equals_1) {
          StringConcatenation _builder_14 = new StringConcatenation();
          _builder_14.append("$T.size($L)");
          _xifexpression_1 = CodeBlock.of(_builder_14.toString(), this.collectionServiceClassName, 
            this.compileExpression(call.getArguments().get(0), ctx));
        } else {
          CodeBlock _xifexpression_2 = null;
          CallType _type_2 = call.getType();
          boolean _equals_2 = Objects.equal(_type_2, CallType.CALLORAPPLY);
          if (_equals_2) {
            StringConcatenation _builder_15 = new StringConcatenation();
            _builder_15.append("$T.size($L)");
            _xifexpression_2 = CodeBlock.of(_builder_15.toString(), this.collectionServiceClassName, 
              this.compileExpression(call.getArguments().get(0), ctx));
          } else {
            StringConcatenation _builder_16 = new StringConcatenation();
            _builder_16.append("/*FIRST ");
            _builder_16.append(call);
            _builder_16.append("*/");
            _xifexpression_2 = CodeBlock.of(_builder_16.toString());
          }
          _xifexpression_1 = _xifexpression_2;
        }
        _switchResult = _xifexpression_1;
      }
    }
    if (!_matched) {
      if (Objects.equal(_serviceName, "at")) {
        _matched=true;
        CodeBlock _xifexpression_3 = null;
        CallType _type_3 = call.getType();
        boolean _equals_3 = Objects.equal(_type_3, CallType.COLLECTIONCALL);
        if (_equals_3) {
          StringConcatenation _builder_17 = new StringConcatenation();
          _builder_17.append("$T.get($L, $L)");
          _xifexpression_3 = CodeBlock.of(_builder_17.toString(), this.collectionServiceClassName, 
            this.compileExpression(call.getArguments().get(0), ctx), this.compileExpression(call.getArguments().get(1), ctx));
        } else {
          StringConcatenation _builder_18 = new StringConcatenation();
          _builder_18.append("/*FIRST ");
          _builder_18.append(call);
          _builder_18.append("*/");
          _xifexpression_3 = CodeBlock.of(_builder_18.toString());
        }
        _switchResult = _xifexpression_3;
      }
    }
    if (!_matched) {
      if (Objects.equal(_serviceName, "select")) {
        _matched=true;
        CodeBlock _xifexpression_4 = null;
        CallType _type_4 = call.getType();
        boolean _equals_4 = Objects.equal(_type_4, CallType.COLLECTIONCALL);
        if (_equals_4) {
          StringConcatenation _builder_19 = new StringConcatenation();
          _builder_19.append("$T.select($L, $L)");
          _xifexpression_4 = CodeBlock.of(_builder_19.toString(), this.collectionServiceClassName, 
            this.compileExpression(call.getArguments().get(0), ctx), this.compileExpression(call.getArguments().get(1), ctx));
        } else {
          StringConcatenation _builder_20 = new StringConcatenation();
          _builder_20.append("/*FIRST ");
          _builder_20.append(call);
          _builder_20.append("*/");
          _xifexpression_4 = CodeBlock.of(_builder_20.toString());
        }
        _switchResult = _xifexpression_4;
      }
    }
    if (!_matched) {
      if (Objects.equal(_serviceName, "filter")) {
        _matched=true;
        CodeBlock _xifexpression_5 = null;
        CallType _type_5 = call.getType();
        boolean _equals_5 = Objects.equal(_type_5, CallType.COLLECTIONCALL);
        if (_equals_5) {
          CodeBlock _xblockexpression = null;
          {
            final IType t = IterableExtensions.<IType>head(this.tsu.infereType(call.getArguments().get(1)));
            CodeBlock _xifexpression_6 = null;
            if ((t instanceof EClassifierType)) {
              StringConcatenation _builder_21 = new StringConcatenation();
              _builder_21.append("$T.select($L, it -> it instanceof $L)");
              _xifexpression_6 = CodeBlock.of(_builder_21.toString(), this.collectionServiceClassName, 
                this.compileExpression(call.getArguments().get(0), ctx), this.compileExpression(call.getArguments().get(1), ctx));
            } else {
              StringConcatenation _builder_22 = new StringConcatenation();
              _builder_22.append("$T.select($L, $L)");
              _xifexpression_6 = CodeBlock.of(_builder_22.toString(), this.collectionServiceClassName, 
                this.compileExpression(call.getArguments().get(0), ctx), this.compileExpression(call.getArguments().get(1), ctx));
            }
            _xblockexpression = _xifexpression_6;
          }
          _xifexpression_5 = _xblockexpression;
        } else {
          StringConcatenation _builder_21 = new StringConcatenation();
          _builder_21.append("/*FIRST ");
          _builder_21.append(call);
          _builder_21.append("*/");
          _xifexpression_5 = CodeBlock.of(_builder_21.toString());
        }
        _switchResult = _xifexpression_5;
      }
    }
    if (!_matched) {
      if (Objects.equal(_serviceName, "exists")) {
        _matched=true;
        CodeBlock _xifexpression_6 = null;
        CallType _type_6 = call.getType();
        boolean _equals_6 = Objects.equal(_type_6, CallType.COLLECTIONCALL);
        if (_equals_6) {
          StringConcatenation _builder_22 = new StringConcatenation();
          _builder_22.append("$T.exists($L, $L)");
          _xifexpression_6 = CodeBlock.of(_builder_22.toString(), this.collectionServiceClassName, this.compileExpression(call.getArguments().get(0), ctx), this.compileExpression(call.getArguments().get(1), ctx));
        } else {
          StringConcatenation _builder_23 = new StringConcatenation();
          _builder_23.append("/*FIRST ");
          _builder_23.append(call);
          _builder_23.append("*/");
          _xifexpression_6 = CodeBlock.of(_builder_23.toString());
        }
        _switchResult = _xifexpression_6;
      }
    }
    if (!_matched) {
      if (Objects.equal(_serviceName, "isEmpty")) {
        _matched=true;
        CodeBlock _xifexpression_7 = null;
        CallType _type_7 = call.getType();
        boolean _equals_7 = Objects.equal(_type_7, CallType.COLLECTIONCALL);
        if (_equals_7) {
          StringConcatenation _builder_24 = new StringConcatenation();
          _builder_24.append("$T.isEmpty($L)");
          _xifexpression_7 = CodeBlock.of(_builder_24.toString(), this.collectionServiceClassName, this.compileExpression(call.getArguments().get(0), ctx));
        } else {
          StringConcatenation _builder_25 = new StringConcatenation();
          _builder_25.append("/*FIRST ");
          _builder_25.append(call);
          _builder_25.append("*/");
          _xifexpression_7 = CodeBlock.of(_builder_25.toString());
        }
        _switchResult = _xifexpression_7;
      }
    }
    if (!_matched) {
      if (Objects.equal(_serviceName, "oclIsKindOf")) {
        _matched=true;
        CodeBlock _xifexpression_8 = null;
        CallType _type_8 = call.getType();
        boolean _equals_8 = Objects.equal(_type_8, CallType.CALLORAPPLY);
        if (_equals_8) {
          CodeBlock _xblockexpression_1 = null;
          {
            final CodeBlock rhs = this.compileExpression(call.getArguments().get(0), ctx);
            final CodeBlock lhs = this.compileExpression(call.getArguments().get(1), ctx);
            StringConcatenation _builder_26 = new StringConcatenation();
            _builder_26.append("$L instanceof $L");
            _xblockexpression_1 = CodeBlock.of(_builder_26.toString(), rhs, lhs);
          }
          _xifexpression_8 = _xblockexpression_1;
        } else {
          StringConcatenation _builder_26 = new StringConcatenation();
          _builder_26.append("/*OCLISKINDOF*/");
          _xifexpression_8 = CodeBlock.of(_builder_26.toString());
        }
        _switchResult = _xifexpression_8;
      }
    }
    if (!_matched) {
      if (Objects.equal(_serviceName, "log")) {
        _matched=true;
        CodeBlock _xifexpression_9 = null;
        CallType _type_9 = call.getType();
        boolean _equals_9 = Objects.equal(_type_9, CallType.CALLORAPPLY);
        if (_equals_9) {
          StringConcatenation _builder_27 = new StringConcatenation();
          _builder_27.append("$T.log(");
          CodeBlock _compileExpression = this.compileExpression(call.getArguments().get(0), ctx);
          _builder_27.append(_compileExpression);
          _builder_27.append(")");
          _xifexpression_9 = CodeBlock.of(_builder_27.toString(), this.logServiceClassName);
        } else {
          StringConcatenation _builder_28 = new StringConcatenation();
          _builder_28.append("/*OCLISKINDOF*/");
          _xifexpression_9 = CodeBlock.of(_builder_28.toString());
        }
        _switchResult = _xifexpression_9;
      }
    }
    if (!_matched) {
      CodeBlock _xifexpression_10 = null;
      CallType _type_10 = call.getType();
      boolean _equals_10 = Objects.equal(_type_10, CallType.CALLORAPPLY);
      if (_equals_10) {
        CodeBlock _xifexpression_11 = null;
        String _serviceName_1 = call.getServiceName();
        boolean _equals_11 = Objects.equal(_serviceName_1, "aqlFeatureAccess");
        if (_equals_11) {
          CodeBlock _xblockexpression_2 = null;
          {
            final IType t = IterableExtensions.<IType>head(this.tsu.infereType(call));
            final CodeBlock lhs = this.compileExpression(IterableExtensions.<Expression>head(call.getArguments()), ctx);
            CodeBlock _xifexpression_12 = null;
            String _string = lhs.toString();
            boolean _equals_12 = Objects.equal(_string, "this");
            if (_equals_12) {
              CodeBlock _xifexpression_13 = null;
              if ((((t instanceof SequenceType) && (((SequenceType) t).getCollectionType().getType() instanceof EClass)) && (!Objects.equal(((EClass) ((SequenceType) t).getCollectionType().getType()).getInstanceClassName(), "java.util.Map$Entry")))) {
                CodeBlock _xblockexpression_3 = null;
                {
                  Expression _get = call.getArguments().get(1);
                  final String rhs = ((StringLiteral) _get).getValue();
                  CodeBlock _xifexpression_14 = null;
                  if ((this.isTruffle && (!ctx.aleClass.getMutable().contains(rhs)))) {
                    CodeBlock _xblockexpression_4 = null;
                    {
                      this.registeredArray.add(rhs);
                      StringConcatenation _builder_29 = new StringConcatenation();
                      _builder_29.append(lhs);
                      _builder_29.append(".");
                      _builder_29.append(rhs);
                      _builder_29.append("Arr");
                      _xblockexpression_4 = CodeBlock.of(_builder_29.toString());
                    }
                    _xifexpression_14 = _xblockexpression_4;
                  } else {
                    StringConcatenation _builder_29 = new StringConcatenation();
                    _builder_29.append(lhs);
                    _builder_29.append(".get");
                    String _firstUpper = StringExtensions.toFirstUpper(rhs);
                    _builder_29.append(_firstUpper);
                    _builder_29.append("()");
                    _xifexpression_14 = CodeBlock.of(_builder_29.toString());
                  }
                  _xblockexpression_3 = _xifexpression_14;
                }
                _xifexpression_13 = _xblockexpression_3;
              } else {
                CodeBlock _xifexpression_14 = null;
                if (((t.getType() instanceof EClass) || (t.getType() instanceof EDataType))) {
                  StringConcatenation _builder_29 = new StringConcatenation();
                  _builder_29.append(lhs);
                  _builder_29.append(".");
                  Expression _get = call.getArguments().get(1);
                  String _value = ((StringLiteral) _get).getValue();
                  _builder_29.append(_value);
                  _xifexpression_14 = CodeBlock.of(_builder_29.toString());
                } else {
                  StringConcatenation _builder_30 = new StringConcatenation();
                  _builder_30.append(lhs);
                  _builder_30.append(".");
                  {
                    Expression _get_1 = call.getArguments().get(1);
                    if ((_get_1 instanceof StringLiteral)) {
                      Expression _get_2 = call.getArguments().get(1);
                      String _value_1 = ((StringLiteral) _get_2).getValue();
                      _builder_30.append(_value_1);
                    } else {
                      CodeBlock _compileExpression_1 = this.compileExpression(call.getArguments().get(1), ctx);
                      _builder_30.append(_compileExpression_1);
                    }
                  }
                  _xifexpression_14 = CodeBlock.of(_builder_30.toString());
                }
                _xifexpression_13 = _xifexpression_14;
              }
              _xifexpression_12 = _xifexpression_13;
            } else {
              CodeBlock _xifexpression_15 = null;
              if (((t instanceof SequenceType) && 
                (((SequenceType) t).getCollectionType().getType() instanceof EClass))) {
                StringConcatenation _builder_31 = new StringConcatenation();
                _builder_31.append(lhs);
                _builder_31.append(".get");
                Expression _get_3 = call.getArguments().get(1);
                String _firstUpper = StringExtensions.toFirstUpper(((StringLiteral) _get_3).getValue());
                _builder_31.append(_firstUpper);
                _builder_31.append("()");
                _xifexpression_15 = CodeBlock.of(_builder_31.toString());
              } else {
                CodeBlock _xifexpression_16 = null;
                if (((t != null) && ((t.getType() instanceof EClass) || (t.getType() instanceof EDataType)))) {
                  CodeBlock _xifexpression_17 = null;
                  if (((t.getType() instanceof EDataType) && (Objects.equal(((EDataType) t.getType()).getInstanceClass(), Boolean.class) || 
                    Objects.equal(((EDataType) t.getType()).getInstanceClass(), boolean.class)))) {
                    StringConcatenation _builder_32 = new StringConcatenation();
                    _builder_32.append(lhs);
                    _builder_32.append(".is");
                    Expression _get_4 = call.getArguments().get(1);
                    String _firstUpper_1 = StringExtensions.toFirstUpper(((StringLiteral) _get_4).getValue());
                    _builder_32.append(_firstUpper_1);
                    _builder_32.append("()");
                    _xifexpression_17 = CodeBlock.of(_builder_32.toString());
                  } else {
                    StringConcatenation _builder_33 = new StringConcatenation();
                    _builder_33.append(lhs);
                    _builder_33.append(".get");
                    Expression _get_5 = call.getArguments().get(1);
                    String _firstUpper_2 = StringExtensions.toFirstUpper(((StringLiteral) _get_5).getValue());
                    _builder_33.append(_firstUpper_2);
                    _builder_33.append("()");
                    _xifexpression_17 = CodeBlock.of(_builder_33.toString());
                  }
                  _xifexpression_16 = _xifexpression_17;
                } else {
                  StringConcatenation _builder_34 = new StringConcatenation();
                  _builder_34.append(lhs);
                  _builder_34.append(".");
                  {
                    Expression _get_6 = call.getArguments().get(1);
                    if ((_get_6 instanceof StringLiteral)) {
                      _builder_34.append("get");
                      Expression _get_7 = call.getArguments().get(1);
                      String _firstUpper_3 = StringExtensions.toFirstUpper(((StringLiteral) _get_7).getValue());
                      _builder_34.append(_firstUpper_3);
                      _builder_34.append("()");
                    } else {
                      CodeBlock _compileExpression_2 = this.compileExpression(call.getArguments().get(1), ctx);
                      _builder_34.append(_compileExpression_2);
                    }
                  }
                  _xifexpression_16 = CodeBlock.of(_builder_34.toString());
                }
                _xifexpression_15 = _xifexpression_16;
              }
              _xifexpression_12 = _xifexpression_15;
            }
            _xblockexpression_2 = _xifexpression_12;
          }
          _xifexpression_11 = _xblockexpression_2;
        } else {
          CodeBlock _xifexpression_12 = null;
          String _serviceName_2 = call.getServiceName();
          boolean _equals_12 = Objects.equal(_serviceName_2, "create");
          if (_equals_12) {
            CodeBlock _xblockexpression_3 = null;
            {
              final Expression e = call.getArguments().get(0);
              final IType t = IterableExtensions.<IType>head(this.tsu.infereType(e));
              Object _type_11 = t.getType();
              final EClass ecls = ((EClass) _type_11);
              final EPackage epks = ecls.getEPackage();
              CodeBlock.Builder _builder_29 = CodeBlock.builder();
              StringConcatenation _builder_30 = new StringConcatenation();
              _builder_30.append("$factory:T.eINSTANCE.create");
              String _name = ecls.getName();
              _builder_30.append(_name);
              _builder_30.append("()");
              ClassName _get = ClassName.get(this.namingUtils.factoryInterfacePackageName(epks, this.packageRoot), 
                this.namingUtils.factoryInterfaceClassName(epks));
              Pair<String, ClassName> _mappedTo = Pair.<String, ClassName>of("factory", _get);
              _xblockexpression_3 = _builder_29.addNamed(_builder_30.toString(), 
                CollectionLiterals.<String, ClassName>newHashMap(_mappedTo)).build();
            }
            _xifexpression_12 = _xblockexpression_3;
          } else {
            CodeBlock _xblockexpression_4 = null;
            {
              final Expression argumentsh = IterableExtensions.<Expression>head(call.getArguments());
              final Set<IType> ts = this.tsu.infereType(argumentsh);
              final IType t = IterableExtensions.<IType>head(ts);
              final Function1<ALEInterpreterImplementationCompiler.ResolvedClass, Boolean> _function = (ALEInterpreterImplementationCompiler.ResolvedClass it) -> {
                boolean _xifexpression_13 = false;
                if (((t != null) && (t.getType() instanceof EClass))) {
                  boolean _xblockexpression_5 = false;
                  {
                    Object _type_11 = t.getType();
                    final EClass tecls = ((EClass) _type_11);
                    _xblockexpression_5 = (Objects.equal(it.getECls().getName(), tecls.getName()) && Objects.equal(it.getECls().getEPackage().getName(), tecls.getEPackage().getName()));
                  }
                  _xifexpression_13 = _xblockexpression_5;
                } else {
                  _xifexpression_13 = false;
                }
                return Boolean.valueOf(_xifexpression_13);
              };
              final ALEInterpreterImplementationCompiler.ResolvedClass re = IterableExtensions.<ALEInterpreterImplementationCompiler.ResolvedClass>head(IterableExtensions.<ALEInterpreterImplementationCompiler.ResolvedClass>filter(this.resolved, _function));
              CodeBlock _xifexpression_13 = null;
              if ((re != null)) {
                CodeBlock _xblockexpression_5 = null;
                {
                  final Iterable<Method> allMethods = this.tsu.allMethods(re.getAleCls());
                  final Function1<Method, Boolean> _function_1 = (Method it) -> {
                    String _name = it.getOperationRef().getName();
                    String _serviceName_3 = call.getServiceName();
                    return Boolean.valueOf(Objects.equal(_name, _serviceName_3));
                  };
                  final boolean methodExist = IterableExtensions.<Method>exists(allMethods, _function_1);
                  CodeBlock _xifexpression_14 = null;
                  if (methodExist) {
                    CodeBlock _xblockexpression_6 = null;
                    {
                      final Function1<Method, Boolean> _function_2 = (Method it) -> {
                        String _name = it.getOperationRef().getName();
                        String _serviceName_3 = call.getServiceName();
                        return Boolean.valueOf(Objects.equal(_name, _serviceName_3));
                      };
                      final List<Method> methods = IterableExtensions.<Method>toList(IterableExtensions.<Method>filter(allMethods, _function_2));
                      Method method = null;
                      ALEInterpreterImplementationCompiler.ResolvedClass rev = re;
                      while ((method == null)) {
                        {
                          final ExtendedClass lc = rev.getAleCls();
                          final Function1<Method, Boolean> _function_3 = (Method it) -> {
                            EObject _eContainer = it.eContainer();
                            return Boolean.valueOf((_eContainer == lc));
                          };
                          method = IterableExtensions.<Method>head(IterableExtensions.<Method>filter(methods, _function_3));
                          final ALEInterpreterImplementationCompiler.ResolvedClass revc = rev;
                          final Function1<ALEInterpreterImplementationCompiler.ResolvedClass, Boolean> _function_4 = (ALEInterpreterImplementationCompiler.ResolvedClass it) -> {
                            return Boolean.valueOf(((revc.eCls instanceof EClass) && 
                              ((EClass) revc.eCls).getESuperTypes().contains(it.eCls)));
                          };
                          rev = IterableExtensions.<ALEInterpreterImplementationCompiler.ResolvedClass>head(IterableExtensions.<ALEInterpreterImplementationCompiler.ResolvedClass>filter(this.resolved, _function_4));
                        }
                      }
                      boolean isDispatch = false;
                      rev = re;
                      while (((!isDispatch) && (rev != null))) {
                        {
                          final ExtendedClass lc = rev.getAleCls();
                          final Function1<Method, Boolean> _function_3 = (Method it) -> {
                            EObject _eContainer = it.eContainer();
                            return Boolean.valueOf((_eContainer == lc));
                          };
                          method = IterableExtensions.<Method>head(IterableExtensions.<Method>filter(methods, _function_3));
                          isDispatch = ((method != null) && method.isDispatch());
                          final ALEInterpreterImplementationCompiler.ResolvedClass revc = rev;
                          final Function1<ALEInterpreterImplementationCompiler.ResolvedClass, Boolean> _function_4 = (ALEInterpreterImplementationCompiler.ResolvedClass it) -> {
                            return Boolean.valueOf(((revc.eCls instanceof EClass) && 
                              ((EClass) revc.eCls).getESuperTypes().contains(it.eCls)));
                          };
                          rev = IterableExtensions.<ALEInterpreterImplementationCompiler.ResolvedClass>head(IterableExtensions.<ALEInterpreterImplementationCompiler.ResolvedClass>filter(this.resolved, _function_4));
                        }
                      }
                      CodeBlock _xifexpression_15 = null;
                      if ((this.isTruffle && isDispatch)) {
                        CodeBlock _xblockexpression_7 = null;
                        {
                          this.registreredDispatch.add(method);
                          EObject _eContainer = call.eContainer();
                          final boolean effectFull = (!(_eContainer instanceof ExpressionStatement));
                          StringConcatenation _builder_29 = new StringConcatenation();
                          {
                            if ((effectFull && (method.getOperationRef().getEType() != null))) {
                              _builder_29.append("((");
                              Object _solveType = this.tsu.solveType(method.getOperationRef().getEType());
                              _builder_29.append(_solveType);
                              _builder_29.append(")");
                            }
                          }
                          _builder_29.append("dispatch");
                          EObject _eContainer_1 = method.eContainer();
                          String _normalizeExtendedClassName = this.namingUtils.normalizeExtendedClassName(((ExtendedClass) _eContainer_1));
                          _builder_29.append(_normalizeExtendedClassName);
                          String _firstUpper = StringExtensions.toFirstUpper(method.getOperationRef().getName());
                          _builder_29.append(_firstUpper);
                          _builder_29.append(".executeDispatch(");
                          CodeBlock _compileExpression_1 = this.compileExpression(IterableExtensions.<Expression>head(call.getArguments()), ctx);
                          _builder_29.append(_compileExpression_1);
                          _builder_29.append(".getCached");
                          String _firstUpper_1 = StringExtensions.toFirstUpper(call.getServiceName());
                          _builder_29.append(_firstUpper_1);
                          _builder_29.append("(), new Object[] {");
                          {
                            Iterable<Expression> _tail = IterableExtensions.<Expression>tail(call.getArguments());
                            boolean _hasElements = false;
                            for(final Expression param : _tail) {
                              if (!_hasElements) {
                                _hasElements = true;
                              } else {
                                _builder_29.appendImmediate(",", "");
                              }
                              CodeBlock _compileExpression_2 = this.compileExpression(param, ctx);
                              _builder_29.append(_compileExpression_2);
                            }
                          }
                          _builder_29.append("})");
                          {
                            if ((effectFull && (method.getOperationRef().getEType() != null))) {
                              _builder_29.append(")");
                            }
                          }
                          _xblockexpression_7 = CodeBlock.of(_builder_29.toString());
                        }
                        _xifexpression_15 = _xblockexpression_7;
                      } else {
                        CodeBlock _xblockexpression_8 = null;
                        {
                          final HashMap<String, Object> hm = CollectionLiterals.<String, Object>newHashMap();
                          Object _type_11 = IterableExtensions.<IType>head(this.tsu.infereType(IterableExtensions.<Expression>head(call.getArguments()))).getType();
                          hm.put("typecaller", this.tsu.solveType(((EClass) _type_11)));
                          Iterable<Pair<Expression, Integer>> _enumerate = this.<Expression>enumerate(IterableExtensions.<Expression>tail(call.getArguments()));
                          for (final Pair<Expression, Integer> param : _enumerate) {
                            Integer _value = param.getValue();
                            String _plus = ("typeparam" + _value);
                            Object _type_12 = IterableExtensions.<IType>head(this.tsu.infereType(param.getKey())).getType();
                            hm.put(_plus, this.tsu.solveType(((EClass) _type_12)));
                          }
                          CodeBlock.Builder _builder_29 = CodeBlock.builder();
                          StringConcatenation _builder_30 = new StringConcatenation();
                          _builder_30.append("(($typecaller:T)");
                          CodeBlock _compileExpression_1 = this.compileExpression(IterableExtensions.<Expression>head(call.getArguments()), ctx);
                          _builder_30.append(_compileExpression_1);
                          _builder_30.append(").");
                          String _serviceName_3 = call.getServiceName();
                          _builder_30.append(_serviceName_3);
                          _builder_30.append("(");
                          {
                            Iterable<Pair<Expression, Integer>> _enumerate_1 = this.<Expression>enumerate(IterableExtensions.<Expression>tail(call.getArguments()));
                            boolean _hasElements = false;
                            for(final Pair<Expression, Integer> param_1 : _enumerate_1) {
                              if (!_hasElements) {
                                _hasElements = true;
                              } else {
                                _builder_30.appendImmediate(",", "");
                              }
                              _builder_30.append("($typeparam");
                              Integer _value_1 = param_1.getValue();
                              _builder_30.append(_value_1);
                              _builder_30.append(":T) ");
                              CodeBlock _compileExpression_2 = this.compileExpression(param_1.getKey(), ctx);
                              _builder_30.append(_compileExpression_2);
                            }
                          }
                          _builder_30.append(")");
                          _xblockexpression_8 = _builder_29.addNamed(_builder_30.toString(), hm).build();
                        }
                        _xifexpression_15 = _xblockexpression_8;
                      }
                      _xblockexpression_6 = _xifexpression_15;
                    }
                    _xifexpression_14 = _xblockexpression_6;
                  } else {
                    CodeBlock _xblockexpression_7 = null;
                    {
                      final Function1<Map.Entry<String, Class<?>>, List<Pair<String, java.lang.reflect.Method>>> _function_2 = (Map.Entry<String, Class<?>> e) -> {
                        final Function1<java.lang.reflect.Method, Pair<String, java.lang.reflect.Method>> _function_3 = (java.lang.reflect.Method it) -> {
                          String _key = e.getKey();
                          return Pair.<String, java.lang.reflect.Method>of(_key, it);
                        };
                        return ListExtensions.<java.lang.reflect.Method, Pair<String, java.lang.reflect.Method>>map(((List<java.lang.reflect.Method>)Conversions.doWrapArray(e.getValue().getMethods())), _function_3);
                      };
                      final List<Pair<String, java.lang.reflect.Method>> methods = IterableExtensions.<Pair<String, java.lang.reflect.Method>>toList(Iterables.<Pair<String, java.lang.reflect.Method>>concat(IterableExtensions.<Map.Entry<String, Class<?>>, List<Pair<String, java.lang.reflect.Method>>>map(this.registeredServices.entrySet(), _function_2)));
                      final Function1<Pair<String, java.lang.reflect.Method>, Boolean> _function_3 = (Pair<String, java.lang.reflect.Method> it) -> {
                        return Boolean.valueOf(Modifier.isStatic(it.getValue().getModifiers()));
                      };
                      final Function1<Pair<String, java.lang.reflect.Method>, Boolean> _function_4 = (Pair<String, java.lang.reflect.Method> it) -> {
                        String _name = it.getValue().getName();
                        String _serviceName_3 = call.getServiceName();
                        return Boolean.valueOf(Objects.equal(_name, _serviceName_3));
                      };
                      final Pair<String, java.lang.reflect.Method> candidate = IterableExtensions.<Pair<String, java.lang.reflect.Method>>head(IterableExtensions.<Pair<String, java.lang.reflect.Method>>filter(IterableExtensions.<Pair<String, java.lang.reflect.Method>>filter(methods, _function_3), _function_4));
                      CodeBlock _xifexpression_15 = null;
                      if ((candidate != null)) {
                        StringConcatenation _builder_29 = new StringConcatenation();
                        String _key = candidate.getKey();
                        _builder_29.append(_key);
                        _builder_29.append(".");
                        String _name = candidate.getValue().getName();
                        _builder_29.append(_name);
                        _builder_29.append("(");
                        {
                          EList<Expression> _arguments = call.getArguments();
                          boolean _hasElements = false;
                          for(final Expression p : _arguments) {
                            if (!_hasElements) {
                              _hasElements = true;
                            } else {
                              _builder_29.appendImmediate(", ", "");
                            }
                            CodeBlock _compileExpression_1 = this.compileExpression(p, ctx);
                            _builder_29.append(_compileExpression_1);
                          }
                        }
                        _builder_29.append(")");
                        _xifexpression_15 = CodeBlock.of(_builder_29.toString());
                      } else {
                        StringConcatenation _builder_30 = new StringConcatenation();
                        CodeBlock _compileExpression_2 = this.compileExpression(IterableExtensions.<Expression>head(call.getArguments()), ctx);
                        _builder_30.append(_compileExpression_2);
                        _builder_30.append(".");
                        String _serviceName_3 = call.getServiceName();
                        _builder_30.append(_serviceName_3);
                        _builder_30.append("(");
                        {
                          Iterable<Expression> _tail = IterableExtensions.<Expression>tail(call.getArguments());
                          boolean _hasElements_1 = false;
                          for(final Expression param : _tail) {
                            if (!_hasElements_1) {
                              _hasElements_1 = true;
                            } else {
                              _builder_30.appendImmediate(",", "");
                            }
                            CodeBlock _compileExpression_3 = this.compileExpression(param, ctx);
                            _builder_30.append(_compileExpression_3);
                          }
                        }
                        _builder_30.append(")");
                        _xifexpression_15 = CodeBlock.of(_builder_30.toString());
                      }
                      _xblockexpression_7 = _xifexpression_15;
                    }
                    _xifexpression_14 = _xblockexpression_7;
                  }
                  _xblockexpression_5 = _xifexpression_14;
                }
                _xifexpression_13 = _xblockexpression_5;
              } else {
                CodeBlock _xblockexpression_6 = null;
                {
                  final Function1<Map.Entry<String, Class<?>>, List<Pair<String, java.lang.reflect.Method>>> _function_1 = (Map.Entry<String, Class<?>> e) -> {
                    final Function1<java.lang.reflect.Method, Pair<String, java.lang.reflect.Method>> _function_2 = (java.lang.reflect.Method it) -> {
                      String _key = e.getKey();
                      return Pair.<String, java.lang.reflect.Method>of(_key, it);
                    };
                    return ListExtensions.<java.lang.reflect.Method, Pair<String, java.lang.reflect.Method>>map(((List<java.lang.reflect.Method>)Conversions.doWrapArray(e.getValue().getMethods())), _function_2);
                  };
                  final Iterable<Pair<String, java.lang.reflect.Method>> methods = Iterables.<Pair<String, java.lang.reflect.Method>>concat(IterableExtensions.<Map.Entry<String, Class<?>>, List<Pair<String, java.lang.reflect.Method>>>map(this.registeredServices.entrySet(), _function_1));
                  final Function1<Pair<String, java.lang.reflect.Method>, Boolean> _function_2 = (Pair<String, java.lang.reflect.Method> it) -> {
                    return Boolean.valueOf(Modifier.isStatic(it.getValue().getModifiers()));
                  };
                  final Function1<Pair<String, java.lang.reflect.Method>, Boolean> _function_3 = (Pair<String, java.lang.reflect.Method> it) -> {
                    String _name = it.getValue().getName();
                    String _serviceName_3 = call.getServiceName();
                    return Boolean.valueOf(Objects.equal(_name, _serviceName_3));
                  };
                  final Pair<String, java.lang.reflect.Method> candidate = IterableExtensions.<Pair<String, java.lang.reflect.Method>>head(IterableExtensions.<Pair<String, java.lang.reflect.Method>>filter(IterableExtensions.<Pair<String, java.lang.reflect.Method>>filter(methods, _function_2), _function_3));
                  CodeBlock _xifexpression_14 = null;
                  if ((candidate != null)) {
                    CodeBlock _xblockexpression_7 = null;
                    {
                      final HashMap<String, Object> hm = CollectionLiterals.<String, Object>newHashMap();
                      Iterable<Pair<Expression, Integer>> _enumerate = this.<Expression>enumerate(call.getArguments());
                      for (final Pair<Expression, Integer> param : _enumerate) {
                        Integer _value = param.getValue();
                        String _plus = ("typeparam" + _value);
                        Object _type_11 = IterableExtensions.<IType>head(this.tsu.infereType(param.getKey())).getType();
                        hm.put(_plus, this.tsu.solveType(((EClass) _type_11)));
                      }
                      CodeBlock.Builder _builder_29 = CodeBlock.builder();
                      StringConcatenation _builder_30 = new StringConcatenation();
                      String _key = candidate.getKey();
                      _builder_30.append(_key);
                      _builder_30.append(".");
                      String _name = candidate.getValue().getName();
                      _builder_30.append(_name);
                      _builder_30.append("(");
                      {
                        Iterable<Pair<Expression, Integer>> _enumerate_1 = this.<Expression>enumerate(call.getArguments());
                        boolean _hasElements = false;
                        for(final Pair<Expression, Integer> p : _enumerate_1) {
                          if (!_hasElements) {
                            _hasElements = true;
                          } else {
                            _builder_30.appendImmediate(", ", "");
                          }
                          _builder_30.append("($typeparam");
                          Integer _value_1 = p.getValue();
                          _builder_30.append(_value_1);
                          _builder_30.append(":T)");
                          CodeBlock _compileExpression_1 = this.compileExpression(p.getKey(), ctx);
                          _builder_30.append(_compileExpression_1);
                        }
                      }
                      _builder_30.append(")");
                      _xblockexpression_7 = _builder_29.addNamed(_builder_30.toString(), hm).build();
                    }
                    _xifexpression_14 = _xblockexpression_7;
                  } else {
                    CodeBlock _xblockexpression_8 = null;
                    {
                      final HashMap<String, Object> hm = CollectionLiterals.<String, Object>newHashMap();
                      Iterable<Pair<Expression, Integer>> _enumerate = this.<Expression>enumerate(IterableExtensions.<Expression>tail(call.getArguments()));
                      for (final Pair<Expression, Integer> param : _enumerate) {
                        Integer _value = param.getValue();
                        String _plus = ("typeparam" + _value);
                        Object _type_11 = IterableExtensions.<IType>head(this.tsu.infereType(param.getKey())).getType();
                        hm.put(_plus, this.tsu.solveType(((EClass) _type_11)));
                      }
                      CodeBlock.Builder _builder_29 = CodeBlock.builder();
                      StringConcatenation _builder_30 = new StringConcatenation();
                      CodeBlock _compileExpression_1 = this.compileExpression(IterableExtensions.<Expression>head(call.getArguments()), ctx);
                      _builder_30.append(_compileExpression_1);
                      _builder_30.append(".");
                      String _serviceName_3 = call.getServiceName();
                      _builder_30.append(_serviceName_3);
                      _builder_30.append("(");
                      {
                        Iterable<Pair<Expression, Integer>> _enumerate_1 = this.<Expression>enumerate(IterableExtensions.<Expression>tail(call.getArguments()));
                        boolean _hasElements = false;
                        for(final Pair<Expression, Integer> param_1 : _enumerate_1) {
                          if (!_hasElements) {
                            _hasElements = true;
                          } else {
                            _builder_30.appendImmediate(",", "");
                          }
                          _builder_30.append("($typeparam");
                          Integer _value_1 = param_1.getValue();
                          _builder_30.append(_value_1);
                          _builder_30.append(":T)");
                          CodeBlock _compileExpression_2 = this.compileExpression(param_1.getKey(), ctx);
                          _builder_30.append(_compileExpression_2);
                        }
                      }
                      _builder_30.append(")");
                      _xblockexpression_8 = _builder_29.addNamed(_builder_30.toString(), hm).build();
                    }
                    _xifexpression_14 = _xblockexpression_8;
                  }
                  _xblockexpression_6 = _xifexpression_14;
                }
                _xifexpression_13 = _xblockexpression_6;
              }
              _xblockexpression_4 = _xifexpression_13;
            }
            _xifexpression_12 = _xblockexpression_4;
          }
          _xifexpression_11 = _xifexpression_12;
        }
        _xifexpression_10 = _xifexpression_11;
      } else {
        StringConcatenation _builder_29 = new StringConcatenation();
        _builder_29.append("/*Call ");
        _builder_29.append(call);
        _builder_29.append("*/");
        _xifexpression_10 = CodeBlock.of(_builder_29.toString());
      }
      _switchResult = _xifexpression_10;
    }
    return _switchResult;
  }
  
  public <A extends Object> Iterable<Pair<A, Integer>> enumerate(final Iterable<A> itt) {
    Iterable<Pair<A, Integer>> _xblockexpression = null;
    {
      final PrimitiveIterator.OfInt ints = IntStream.range(0, IterableExtensions.size(itt)).iterator();
      final Function1<A, Pair<A, Integer>> _function = (A it) -> {
        Integer _next = ints.next();
        return Pair.<A, Integer>of(it, _next);
      };
      _xblockexpression = IterableExtensions.<A, Pair<A, Integer>>map(itt, _function);
    }
    return _xblockexpression;
  }
  
  protected CodeBlock _compileExpression(final And call, final EClassImplementationCompiler.CompilerExpressionCtx ctx) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("((");
    CodeBlock _compileExpression = this.compileExpression(call.getArguments().get(0), ctx);
    _builder.append(_compileExpression);
    _builder.append(") && (");
    CodeBlock _compileExpression_1 = this.compileExpression(call.getArguments().get(1), ctx);
    _builder.append(_compileExpression_1);
    _builder.append("))");
    return CodeBlock.of(_builder.toString());
  }
  
  protected CodeBlock _compileExpression(final ErrorCall call, final EClassImplementationCompiler.CompilerExpressionCtx ctx) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/*ERRORCALL*/");
    return CodeBlock.of(_builder.toString());
  }
  
  protected CodeBlock _compileExpression(final Implies call, final EClassImplementationCompiler.CompilerExpressionCtx ctx) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/*IMPLIES*/");
    return CodeBlock.of(_builder.toString());
  }
  
  protected CodeBlock _compileExpression(final Or call, final EClassImplementationCompiler.CompilerExpressionCtx ctx) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("((");
    CodeBlock _compileExpression = this.compileExpression(call.getArguments().get(0), ctx);
    _builder.append(_compileExpression);
    _builder.append(") || (");
    CodeBlock _compileExpression_1 = this.compileExpression(call.getArguments().get(1), ctx);
    _builder.append(_compileExpression_1);
    _builder.append("))");
    return CodeBlock.of(_builder.toString());
  }
  
  protected CodeBlock _compileExpression(final ErrorConditional call, final EClassImplementationCompiler.CompilerExpressionCtx ctx) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/*ERRORCONDITIONAL*/");
    return CodeBlock.of(_builder.toString());
  }
  
  protected CodeBlock _compileExpression(final ErrorBinding call, final EClassImplementationCompiler.CompilerExpressionCtx ctx) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/*ERRORBINDING*/");
    return CodeBlock.of(_builder.toString());
  }
  
  protected CodeBlock _compileExpression(final EEnumLiteral call, final EClassImplementationCompiler.CompilerExpressionCtx ctx) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/*EENUMLITERAL*/");
    return CodeBlock.of(_builder.toString());
  }
  
  protected CodeBlock _compileExpression(final ErrorExpression call, final EClassImplementationCompiler.CompilerExpressionCtx ctx) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/*ERROREXPRESSION*/");
    return CodeBlock.of(_builder.toString());
  }
  
  protected CodeBlock _compileExpression(final ErrorStringLiteral call, final EClassImplementationCompiler.CompilerExpressionCtx ctx) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/*ERRORSTRINGLITERAL*/");
    return CodeBlock.of(_builder.toString());
  }
  
  protected CodeBlock _compileExpression(final ErrorTypeLiteral call, final EClassImplementationCompiler.CompilerExpressionCtx ctx) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/*ERRORTYPELITERAL*/");
    return CodeBlock.of(_builder.toString());
  }
  
  protected CodeBlock _compileExpression(final ErrorVariableDeclaration call, final EClassImplementationCompiler.CompilerExpressionCtx ctx) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/*ERRORVARIABLEDECLARATION*/");
    return CodeBlock.of(_builder.toString());
  }
  
  protected CodeBlock _compileExpression(final Let call, final EClassImplementationCompiler.CompilerExpressionCtx ctx) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/*let*/");
    return CodeBlock.of(_builder.toString());
  }
  
  protected CodeBlock _compileExpression(final BooleanLiteral call, final EClassImplementationCompiler.CompilerExpressionCtx ctx) {
    CodeBlock _xblockexpression = null;
    {
      String _xifexpression = null;
      boolean _isValue = call.isValue();
      if (_isValue) {
        _xifexpression = "true";
      } else {
        _xifexpression = "false";
      }
      final String ret = _xifexpression;
      _xblockexpression = CodeBlock.of(ret);
    }
    return _xblockexpression;
  }
  
  protected CodeBlock _compileExpression(final EnumLiteral call, final EClassImplementationCompiler.CompilerExpressionCtx ctx) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/*ENUMLITERAL*/");
    return CodeBlock.of(_builder.toString());
  }
  
  protected CodeBlock _compileExpression(final IntegerLiteral call, final EClassImplementationCompiler.CompilerExpressionCtx ctx) {
    return CodeBlock.of(Integer.valueOf(call.getValue()).toString());
  }
  
  protected CodeBlock _compileExpression(final Lambda call, final EClassImplementationCompiler.CompilerExpressionCtx ctx) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("(");
    {
      EList<VariableDeclaration> _parameters = call.getParameters();
      boolean _hasElements = false;
      for(final VariableDeclaration p : _parameters) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          _builder.appendImmediate(", ", "");
        }
        String _name = p.getName();
        _builder.append(_name);
      }
    }
    _builder.append(") -> ");
    CodeBlock _compileExpression = this.compileExpression(call.getExpression(), ctx);
    _builder.append(_compileExpression);
    return CodeBlock.of(_builder.toString());
  }
  
  protected CodeBlock _compileExpression(final NullLiteral call, final EClassImplementationCompiler.CompilerExpressionCtx ctx) {
    return CodeBlock.of("null");
  }
  
  protected CodeBlock _compileExpression(final RealLiteral call, final EClassImplementationCompiler.CompilerExpressionCtx ctx) {
    return CodeBlock.of(Double.valueOf(call.getValue()).toString());
  }
  
  protected CodeBlock _compileExpression(final SequenceInExtensionLiteral call, final EClassImplementationCompiler.CompilerExpressionCtx ctx) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("$T.createEList(");
    {
      EList<Expression> _values = call.getValues();
      boolean _hasElements = false;
      for(final Expression a : _values) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          _builder.appendImmediate(", ", "");
        }
        CodeBlock _compileExpression = this.compileExpression(a, ctx);
        _builder.append(_compileExpression);
      }
    }
    _builder.append(")");
    return CodeBlock.of(_builder.toString(), this.collectionServiceClassName);
  }
  
  protected CodeBlock _compileExpression(final SetInExtensionLiteral call, final EClassImplementationCompiler.CompilerExpressionCtx ctx) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/*SETINEXTENSIONLITERAL*/");
    return CodeBlock.of(_builder.toString());
  }
  
  protected CodeBlock _compileExpression(final StringLiteral call, final EClassImplementationCompiler.CompilerExpressionCtx ctx) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("\"");
    String _value = call.getValue();
    _builder.append(_value);
    _builder.append("\"");
    return CodeBlock.of(_builder.toString());
  }
  
  protected CodeBlock _compileExpression(final TypeLiteral call, final EClassImplementationCompiler.CompilerExpressionCtx ctx) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("$T");
    Object _value = call.getValue();
    return CodeBlock.of(_builder.toString(), this.tsu.solveType(((EClass) _value)));
  }
  
  protected CodeBlock _compileExpression(final Switch call, final EClassImplementationCompiler.CompilerExpressionCtx ctx) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/*SWITCH*/");
    return CodeBlock.of(_builder.toString());
  }
  
  protected CodeBlock _compileExpression(final VarRef call, final EClassImplementationCompiler.CompilerExpressionCtx ctx) {
    CodeBlock _xblockexpression = null;
    {
      String _xifexpression = null;
      String _variableName = call.getVariableName();
      boolean _equals = Objects.equal(_variableName, "self");
      if (_equals) {
        _xifexpression = ctx.thisCtxName;
      } else {
        _xifexpression = call.getVariableName();
      }
      final String ret = _xifexpression;
      _xblockexpression = CodeBlock.of(ret);
    }
    return _xblockexpression;
  }
  
  public CodeBlock compileExpression(final EObject call, final EClassImplementationCompiler.CompilerExpressionCtx ctx) {
    if (call instanceof ErrorStringLiteral) {
      return _compileExpression((ErrorStringLiteral)call, ctx);
    } else if (call instanceof ErrorTypeLiteral) {
      return _compileExpression((ErrorTypeLiteral)call, ctx);
    } else if (call instanceof And) {
      return _compileExpression((And)call, ctx);
    } else if (call instanceof BooleanLiteral) {
      return _compileExpression((BooleanLiteral)call, ctx);
    } else if (call instanceof EnumLiteral) {
      return _compileExpression((EnumLiteral)call, ctx);
    } else if (call instanceof ErrorBinding) {
      return _compileExpression((ErrorBinding)call, ctx);
    } else if (call instanceof ErrorCall) {
      return _compileExpression((ErrorCall)call, ctx);
    } else if (call instanceof ErrorConditional) {
      return _compileExpression((ErrorConditional)call, ctx);
    } else if (call instanceof ErrorExpression) {
      return _compileExpression((ErrorExpression)call, ctx);
    } else if (call instanceof ErrorVariableDeclaration) {
      return _compileExpression((ErrorVariableDeclaration)call, ctx);
    } else if (call instanceof Implies) {
      return _compileExpression((Implies)call, ctx);
    } else if (call instanceof IntegerLiteral) {
      return _compileExpression((IntegerLiteral)call, ctx);
    } else if (call instanceof Lambda) {
      return _compileExpression((Lambda)call, ctx);
    } else if (call instanceof NullLiteral) {
      return _compileExpression((NullLiteral)call, ctx);
    } else if (call instanceof Or) {
      return _compileExpression((Or)call, ctx);
    } else if (call instanceof RealLiteral) {
      return _compileExpression((RealLiteral)call, ctx);
    } else if (call instanceof SequenceInExtensionLiteral) {
      return _compileExpression((SequenceInExtensionLiteral)call, ctx);
    } else if (call instanceof SetInExtensionLiteral) {
      return _compileExpression((SetInExtensionLiteral)call, ctx);
    } else if (call instanceof StringLiteral) {
      return _compileExpression((StringLiteral)call, ctx);
    } else if (call instanceof TypeLiteral) {
      return _compileExpression((TypeLiteral)call, ctx);
    } else if (call instanceof EEnumLiteral) {
      return _compileExpression((EEnumLiteral)call, ctx);
    } else if (call instanceof Call) {
      return _compileExpression((Call)call, ctx);
    } else if (call instanceof Let) {
      return _compileExpression((Let)call, ctx);
    } else if (call instanceof VarRef) {
      return _compileExpression((VarRef)call, ctx);
    } else if (call instanceof Switch) {
      return _compileExpression((Switch)call, ctx);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(call, ctx).toString());
    }
  }
}
