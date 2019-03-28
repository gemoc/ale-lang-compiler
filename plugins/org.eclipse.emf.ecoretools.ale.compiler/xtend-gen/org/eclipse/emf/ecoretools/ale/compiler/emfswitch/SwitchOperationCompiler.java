package org.eclipse.emf.ecoretools.ale.compiler.emfswitch;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.CodeBlock;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.ParameterSpec;
import com.squareup.javapoet.ParameterizedTypeName;
import com.squareup.javapoet.TypeName;
import com.squareup.javapoet.TypeSpec;
import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PrimitiveIterator;
import java.util.Set;
import java.util.stream.IntStream;
import javax.lang.model.element.Modifier;
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
import org.eclipse.acceleo.query.runtime.IQueryEnvironment;
import org.eclipse.acceleo.query.validation.type.EClassifierType;
import org.eclipse.acceleo.query.validation.type.IType;
import org.eclipse.acceleo.query.validation.type.SequenceType;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecoretools.ale.compiler.emfswitch.ALESwitchImplementationCompiler;
import org.eclipse.emf.ecoretools.ale.compiler.emfswitch.SwitchNamingUtils;
import org.eclipse.emf.ecoretools.ale.compiler.emfswitch.TypeSystemUtils;
import org.eclipse.emf.ecoretools.ale.compiler.interpreter.JavaPoetUtils;
import org.eclipse.emf.ecoretools.ale.core.parser.Dsl;
import org.eclipse.emf.ecoretools.ale.core.parser.visitor.ParseResult;
import org.eclipse.emf.ecoretools.ale.core.validation.BaseValidator;
import org.eclipse.emf.ecoretools.ale.core.validation.IValidator;
import org.eclipse.emf.ecoretools.ale.core.validation.TypeValidator;
import org.eclipse.emf.ecoretools.ale.implementation.Block;
import org.eclipse.emf.ecoretools.ale.implementation.ConditionalBlock;
import org.eclipse.emf.ecoretools.ale.implementation.ExpressionStatement;
import org.eclipse.emf.ecoretools.ale.implementation.ExtendedClass;
import org.eclipse.emf.ecoretools.ale.implementation.FeatureAssignment;
import org.eclipse.emf.ecoretools.ale.implementation.FeatureInsert;
import org.eclipse.emf.ecoretools.ale.implementation.FeaturePut;
import org.eclipse.emf.ecoretools.ale.implementation.FeatureRemove;
import org.eclipse.emf.ecoretools.ale.implementation.ForEach;
import org.eclipse.emf.ecoretools.ale.implementation.If;
import org.eclipse.emf.ecoretools.ale.implementation.Method;
import org.eclipse.emf.ecoretools.ale.implementation.ModelUnit;
import org.eclipse.emf.ecoretools.ale.implementation.Statement;
import org.eclipse.emf.ecoretools.ale.implementation.Switch;
import org.eclipse.emf.ecoretools.ale.implementation.VariableAssignment;
import org.eclipse.emf.ecoretools.ale.implementation.VariableDeclaration;
import org.eclipse.emf.ecoretools.ale.implementation.While;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class SwitchOperationCompiler {
  @Extension
  private SwitchNamingUtils namingUtils = new SwitchNamingUtils();
  
  @Extension
  private JavaPoetUtils _javaPoetUtils = new JavaPoetUtils();
  
  @Extension
  private TypeSystemUtils tsu;
  
  private final String packageRoot;
  
  private final File directory;
  
  private final Map<String, Pair<EPackage, GenModel>> syntaxes;
  
  private final List<ALESwitchImplementationCompiler.ResolvedClass> resolved;
  
  private final BaseValidator base;
  
  private final Map<String, Class<?>> registeredServices;
  
  private final Dsl dsl;
  
  public SwitchOperationCompiler(final String packageRoot, final File directory, final Map<String, Pair<EPackage, GenModel>> syntaxes, final IQueryEnvironment queryEnvironment, final List<ParseResult<ModelUnit>> parsedSemantics, final List<ALESwitchImplementationCompiler.ResolvedClass> resolved, final Map<String, Class<?>> registeredServices, final Dsl dsl) {
    this.packageRoot = packageRoot;
    this.directory = directory;
    this.syntaxes = syntaxes;
    this.resolved = resolved;
    TypeValidator _typeValidator = new TypeValidator();
    BaseValidator _baseValidator = new BaseValidator(queryEnvironment, Collections.<IValidator>unmodifiableList(CollectionLiterals.<IValidator>newArrayList(_typeValidator)));
    this.base = _baseValidator;
    this.base.validate(parsedSemantics);
    TypeSystemUtils _typeSystemUtils = new TypeSystemUtils(syntaxes, packageRoot, this.base, resolved);
    this.tsu = _typeSystemUtils;
    this.registeredServices = registeredServices;
    this.dsl = dsl;
  }
  
  public void compile(final ALESwitchImplementationCompiler.ResolvedClass resolved) {
    try {
      final ClassName eClassType = ClassName.get(resolved.getGenCls().getGenPackage().getInterfacePackageName(), resolved.getGenCls().getInterfaceName());
      final ClassName switchType = ClassName.get(this.namingUtils.switchImplementationPackageName(this.packageRoot), this.namingUtils.switchImplementationClassName(this.packageRoot));
      final String operationsPackage = this.namingUtils.operationPackageName(this.packageRoot);
      TypeSpec.Builder _classBuilder = TypeSpec.classBuilder(this.namingUtils.operationClassName(resolved.eCls));
      boolean _isEmpty = ((EClass) resolved.eCls).getESuperTypes().isEmpty();
      boolean _not = (!_isEmpty);
      final Function1<TypeSpec.Builder, TypeSpec.Builder> _function = (TypeSpec.Builder it) -> {
        return it.superclass(ClassName.get(operationsPackage, this.namingUtils.operationClassName(IterableExtensions.<EClass>head(((EClass) resolved.eCls).getESuperTypes()))));
      };
      MethodSpec.Builder _addParameter = MethodSpec.constructorBuilder().addParameter(eClassType, "it").addParameter(switchType, "emfswitch");
      StringConcatenation _builder = new StringConcatenation();
      {
        boolean _isEmpty_1 = ((EClass) resolved.eCls).getESuperTypes().isEmpty();
        boolean _not_1 = (!_isEmpty_1);
        if (_not_1) {
          _builder.append("super(it, emfswitch);");
          _builder.newLine();
        }
      }
      _builder.append("this.it = it;");
      _builder.newLine();
      _builder.append("this.emfswitch = emfswitch;");
      _builder.newLine();
      TypeSpec.Builder _addMethod = this._javaPoetUtils.<TypeSpec.Builder>applyIfTrue(_classBuilder, Boolean.valueOf(_not), _function).addField(eClassType, "it", Modifier.PRIVATE, Modifier.FINAL).addField(switchType, "emfswitch", Modifier.PRIVATE, Modifier.FINAL).addMethod(
        _addParameter.addCode(_builder.toString()).addModifiers(Modifier.PUBLIC).build());
      ExtendedClass _aleCls = resolved.getAleCls();
      boolean _tripleNotEquals = (_aleCls != null);
      final Function1<TypeSpec.Builder, TypeSpec.Builder> _function_1 = (TypeSpec.Builder it) -> {
        final Function1<Method, MethodSpec> _function_2 = (Method it_1) -> {
          return this.compileMethodB(it_1);
        };
        return it.addMethods(ListExtensions.<Method, MethodSpec>map(resolved.getAleCls().getMethods(), _function_2));
      };
      final TypeSpec factory = this._javaPoetUtils.<TypeSpec.Builder>applyIfTrue(_addMethod, Boolean.valueOf(_tripleNotEquals), _function_1).addModifiers(Modifier.PUBLIC).build();
      final JavaFile javaFile = JavaFile.builder(operationsPackage, factory).indent("\t").build();
      javaFile.writeTo(this.directory);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public MethodSpec compileMethodB(final Method method) {
    MethodSpec _xblockexpression = null;
    {
      TypeName _xifexpression = null;
      EClassifier _eType = method.getOperationRef().getEType();
      boolean _tripleNotEquals = (_eType != null);
      if (_tripleNotEquals) {
        TypeName _xifexpression_1 = null;
        if (((method.getOperationRef().getEType() instanceof EClass) && 
          (!Objects.equal(method.getOperationRef().getEType().getEPackage(), EcorePackage.eINSTANCE)))) {
          EClassifier _eType_1 = method.getOperationRef().getEType();
          _xifexpression_1 = ClassName.get(this.getEcoreInterfacesPackage(), ((EClass) _eType_1).getName());
        } else {
          _xifexpression_1 = this.tsu.resolveType2(method.getOperationRef().getEType());
        }
        _xifexpression = _xifexpression_1;
      } else {
        _xifexpression = null;
      }
      final TypeName retType = _xifexpression;
      final Function1<MethodSpec.Builder, MethodSpec.Builder> _function = (MethodSpec.Builder it) -> {
        return it.returns(retType);
      };
      final Function1<EParameter, ParameterSpec> _function_1 = (EParameter param) -> {
        ParameterSpec _xifexpression_2 = null;
        Class<?> _instanceClass = param.getEType().getInstanceClass();
        boolean _tripleNotEquals_1 = (_instanceClass != null);
        if (_tripleNotEquals_1) {
          ParameterSpec _xifexpression_3 = null;
          if (((param.getEType() instanceof EClass) && (!Objects.equal(param.getEType().getEPackage(), EcorePackage.eINSTANCE)))) {
            EClassifier _eType_2 = param.getEType();
            _xifexpression_3 = ParameterSpec.builder(
              ClassName.get(this.getEcoreInterfacesPackage(), ((EClass) _eType_2).getName()), param.getName()).build();
          } else {
            _xifexpression_3 = ParameterSpec.builder(param.getEType().getInstanceClass(), param.getName()).build();
          }
          _xifexpression_2 = _xifexpression_3;
        } else {
          _xifexpression_2 = ParameterSpec.builder(this.tsu.resolveType(param.getEType()), param.getName()).build();
        }
        return _xifexpression_2;
      };
      _xblockexpression = this.closeMethod(this.compileBody(this.openMethod(this._javaPoetUtils.<MethodSpec.Builder>applyIfTrue(MethodSpec.methodBuilder(method.getOperationRef().getName()), Boolean.valueOf((retType != null)), _function).addParameters(ListExtensions.<EParameter, ParameterSpec>map(method.getOperationRef().getEParameters(), _function_1)).addModifiers(Modifier.PUBLIC), method.getOperationRef().getEType()), method.getBody()), method.getOperationRef().getEType()).build();
    }
    return _xblockexpression;
  }
  
  public MethodSpec.Builder openMethod(final MethodSpec.Builder builder, final EClassifier type) {
    MethodSpec.Builder _xifexpression = null;
    if ((type != null)) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("$T result");
      _xifexpression = builder.addStatement(_builder.toString(), this.tsu.resolveType2(type));
    } else {
      _xifexpression = builder;
    }
    return _xifexpression;
  }
  
  public MethodSpec.Builder closeMethod(final MethodSpec.Builder builder, final EClassifier type) {
    MethodSpec.Builder _xifexpression = null;
    if ((type != null)) {
      _xifexpression = builder.addStatement("return result");
    } else {
      _xifexpression = builder;
    }
    return _xifexpression;
  }
  
  protected Object _solveType(final EClass type) {
    return this.tsu.resolveType(type);
  }
  
  protected Object _solveType(final EDataType edt) {
    return edt.getInstanceClass();
  }
  
  public Set<IType> infereType(final Expression exp) {
    return this.base.getPossibleTypes(exp);
  }
  
  protected MethodSpec.Builder _compileBody(final MethodSpec.Builder builderSeed, final FeatureAssignment body) {
    MethodSpec.Builder _xblockexpression = null;
    {
      final IType t = IterableExtensions.<IType>head(this.infereType(body.getTarget()));
      MethodSpec.Builder _xifexpression = null;
      if (((t instanceof SequenceType) && (((SequenceType) t).getCollectionType().getType() instanceof EClass))) {
        StringConcatenation _builder = new StringConcatenation();
        CodeBlock _compileExpression = this.compileExpression(body.getTarget());
        _builder.append(_compileExpression);
        _builder.append(".get");
        String _firstUpper = StringExtensions.toFirstUpper(body.getTargetFeature());
        _builder.append(_firstUpper);
        _builder.append("().add(");
        CodeBlock _compileExpression_1 = this.compileExpression(body.getValue());
        _builder.append(_compileExpression_1);
        _builder.append(")");
        _xifexpression = builderSeed.addStatement(_builder.toString());
      } else {
        MethodSpec.Builder _xifexpression_1 = null;
        if (((t.getType() instanceof EClass) || (t.getType() instanceof EDataType))) {
          StringConcatenation _builder_1 = new StringConcatenation();
          _builder_1.append("$L.set$L($L)");
          _xifexpression_1 = builderSeed.addStatement(_builder_1.toString(), this.compileExpression(body.getTarget()), StringExtensions.toFirstUpper(body.getTargetFeature()), this.compileExpression(body.getValue()));
        } else {
          StringConcatenation _builder_2 = new StringConcatenation();
          _builder_2.append("$L.$L = $L");
          _xifexpression_1 = builderSeed.addStatement(_builder_2.toString(), this.compileExpression(body.getTarget()), body.getTargetFeature(), this.compileExpression(body.getValue()));
        }
        _xifexpression = _xifexpression_1;
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  protected MethodSpec.Builder _compileBody(final MethodSpec.Builder builderSeed, final FeatureInsert body) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("$L.get$L().add($L)");
    return builderSeed.addStatement(_builder.toString(), this.compileExpression(body.getTarget()), 
      StringExtensions.toFirstUpper(body.getTargetFeature()), this.compileExpression(body.getValue()));
  }
  
  protected MethodSpec.Builder _compileBody(final MethodSpec.Builder builderSeed, final FeatureRemove body) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("$L.get$L().remove($L)");
    return builderSeed.addStatement(_builder.toString(), this.compileExpression(body.getTarget()), StringExtensions.toFirstUpper(body.getTargetFeature()), 
      this.compileExpression(body.getValue()));
  }
  
  protected MethodSpec.Builder _compileBody(final MethodSpec.Builder builderSeed, final VariableAssignment body) {
    StringConcatenation _builder = new StringConcatenation();
    String _name = body.getName();
    _builder.append(_name);
    _builder.append(" = $L");
    return builderSeed.addStatement(_builder.toString(), this.compileExpression(body.getValue()));
  }
  
  protected MethodSpec.Builder _compileBody(final MethodSpec.Builder builderSeed, final VariableDeclaration body) {
    MethodSpec.Builder _xblockexpression = null;
    {
      final IType inft = IterableExtensions.<IType>head(this.infereType(body.getInitialValue()));
      MethodSpec.Builder _xifexpression = null;
      if ((inft instanceof SequenceType)) {
        MethodSpec.Builder _xblockexpression_1 = null;
        {
          Object _type = ((SequenceType)inft).getCollectionType().getType();
          final ParameterizedTypeName t = ParameterizedTypeName.get(ClassName.get("org.eclipse.emf.common.util", "EList"), 
            ClassName.get(((Class<?>) _type)));
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("$T $L = (($T) ($L))");
          _xblockexpression_1 = builderSeed.addStatement(_builder.toString(), t, body.getName(), t, this.compileExpression(body.getInitialValue()));
        }
        _xifexpression = _xblockexpression_1;
      } else {
        MethodSpec.Builder _xblockexpression_2 = null;
        {
          final Object t = this.solveType(body.getType());
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("$T $L = (($T) ($L))");
          _xblockexpression_2 = builderSeed.addStatement(_builder.toString(), t, body.getName(), t, this.compileExpression(body.getInitialValue()));
        }
        _xifexpression = _xblockexpression_2;
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  protected MethodSpec.Builder _compileBody(final MethodSpec.Builder builderSeed, final Block body) {
    final Function2<MethodSpec.Builder, Statement, MethodSpec.Builder> _function = (MethodSpec.Builder builder, Statement statement) -> {
      return this.compileBody(builder, statement);
    };
    return IterableExtensions.<Statement, MethodSpec.Builder>fold(body.getStatements(), builderSeed, _function);
  }
  
  protected MethodSpec.Builder _compileBody(final MethodSpec.Builder builderSeed, final ExpressionStatement body) {
    return builderSeed.addStatement(this.compileExpression(body.getExpression()));
  }
  
  protected MethodSpec.Builder _compileBody(final MethodSpec.Builder builderSeed, final FeaturePut body) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("throw new $T(\"FeaturePut not implemented\")");
    return builderSeed.addStatement(_builder.toString(), RuntimeException.class);
  }
  
  protected MethodSpec.Builder _compileBody(final MethodSpec.Builder builderSeed, final ForEach body) {
    MethodSpec.Builder _xblockexpression = null;
    {
      IType _head = IterableExtensions.<IType>head(this.infereType(body.getCollectionExpression()));
      final SequenceType lt = ((SequenceType) _head);
      MethodSpec.Builder _xifexpression = null;
      Object _type = lt.getCollectionType().getType();
      if ((_type instanceof EClass)) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("for ($T $L: ");
        CodeBlock _compileExpression = this.compileExpression(body.getCollectionExpression());
        _builder.append(_compileExpression);
        _builder.append(")");
        Object _type_1 = lt.getCollectionType().getType();
        _xifexpression = this.compileBody(builderSeed.beginControlFlow(_builder.toString(), 
          this.solveType(((EClass) _type_1)), body.getVariable()), body.getBody()).endControlFlow();
      } else {
        MethodSpec.Builder _xblockexpression_1 = null;
        {
          final TypeName iteratorType = this.tsu.resolveType2(lt.getCollectionType().getType());
          final String iteratorVariable = body.getVariable();
          final CodeBlock iterable = this.compileExpression(body.getCollectionExpression());
          StringConcatenation _builder_1 = new StringConcatenation();
          _builder_1.append("for ($T $L: $L)");
          _xblockexpression_1 = this.compileBody(builderSeed.beginControlFlow(_builder_1.toString(), iteratorType, iteratorVariable, iterable), body.getBody()).endControlFlow();
        }
        _xifexpression = _xblockexpression_1;
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  protected MethodSpec.Builder _compileBody(final MethodSpec.Builder builderSeed, final If body) {
    MethodSpec.Builder _xblockexpression = null;
    {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("if($L)");
      MethodSpec.Builder ret = this.compileBody(builderSeed.beginControlFlow(_builder.toString(), this.compileExpression(IterableExtensions.<ConditionalBlock>head(body.getBlocks()).getCondition())), 
        IterableExtensions.<ConditionalBlock>head(body.getBlocks()).getBlock()).endControlFlow();
      Iterable<ConditionalBlock> _tail = IterableExtensions.<ConditionalBlock>tail(body.getBlocks());
      for (final ConditionalBlock x : _tail) {
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("else if ($L");
        ret = this.compileBody(ret.beginControlFlow(_builder_1.toString(), this.compileExpression(x.getCondition())), x.getBlock()).endControlFlow();
      }
      Block _else = body.getElse();
      boolean _tripleNotEquals = (_else != null);
      if (_tripleNotEquals) {
        ret = this.compileBody(ret.beginControlFlow("else"), body.getElse()).endControlFlow();
      }
      _xblockexpression = ret;
    }
    return _xblockexpression;
  }
  
  protected MethodSpec.Builder _compileBody(final MethodSpec.Builder builderSeed, final ConditionalBlock body) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("throw new $T(\"ConditionalBlock not implemented\")");
    return builderSeed.addStatement(_builder.toString(), RuntimeException.class);
  }
  
  protected MethodSpec.Builder _compileBody(final MethodSpec.Builder builderSeed, final While body) {
    MethodSpec.Builder _xblockexpression = null;
    {
      final MethodSpec.Builder a = builderSeed.beginControlFlow("while ($L)", this.compileExpression(body.getCondition()));
      _xblockexpression = this.compileBody(a, body.getBody()).endControlFlow();
    }
    return _xblockexpression;
  }
  
  protected CodeBlock _compileExpression(final Call call) {
    CodeBlock _switchResult = null;
    String _serviceName = call.getServiceName();
    if (_serviceName != null) {
      switch (_serviceName) {
        case "not":
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("!($L)");
          _switchResult = CodeBlock.of(_builder.toString(), this.compileExpression(call.getArguments().get(0)));
          break;
        case "greaterThan":
          StringConcatenation _builder_1 = new StringConcatenation();
          _builder_1.append("($L) > ($L)");
          _switchResult = CodeBlock.of(_builder_1.toString(), this.compileExpression(call.getArguments().get(0)), this.compileExpression(call.getArguments().get(1)));
          break;
        case "differs":
          StringConcatenation _builder_2 = new StringConcatenation();
          _builder_2.append("($L) != ($L)");
          _switchResult = CodeBlock.of(_builder_2.toString(), this.compileExpression(call.getArguments().get(0)), this.compileExpression(call.getArguments().get(1)));
          break;
        case "sub":
          StringConcatenation _builder_3 = new StringConcatenation();
          _builder_3.append("($L) - ($L)");
          _switchResult = CodeBlock.of(_builder_3.toString(), this.compileExpression(call.getArguments().get(0)), this.compileExpression(call.getArguments().get(1)));
          break;
        case "add":
          StringConcatenation _builder_4 = new StringConcatenation();
          _builder_4.append("($L) + ($L)");
          _switchResult = CodeBlock.of(_builder_4.toString(), this.compileExpression(call.getArguments().get(0)), this.compileExpression(call.getArguments().get(1)));
          break;
        case "divOp":
          StringConcatenation _builder_5 = new StringConcatenation();
          _builder_5.append("($L) / ($L)");
          _switchResult = CodeBlock.of(_builder_5.toString(), this.compileExpression(call.getArguments().get(0)), this.compileExpression(call.getArguments().get(1)));
          break;
        case "equals":
          StringConcatenation _builder_6 = new StringConcatenation();
          _builder_6.append("$T.equals(($L), ($L))");
          _switchResult = CodeBlock.of(_builder_6.toString(), ClassName.get(java.util.Objects.class), this.compileExpression(call.getArguments().get(0)), this.compileExpression(call.getArguments().get(1)));
          break;
        case "lessThan":
          StringConcatenation _builder_7 = new StringConcatenation();
          _builder_7.append("($L) < ($L)");
          _switchResult = CodeBlock.of(_builder_7.toString(), this.compileExpression(call.getArguments().get(0)), this.compileExpression(call.getArguments().get(1)));
          break;
        case "lessThanEqual":
          StringConcatenation _builder_8 = new StringConcatenation();
          _builder_8.append("($L) <= ($L)");
          _switchResult = CodeBlock.of(_builder_8.toString(), this.compileExpression(call.getArguments().get(0)), this.compileExpression(call.getArguments().get(1)));
          break;
        case "greaterThanEqual":
          StringConcatenation _builder_9 = new StringConcatenation();
          _builder_9.append("($L) >= ($L)");
          _switchResult = CodeBlock.of(_builder_9.toString(), this.compileExpression(call.getArguments().get(0)), 
            this.compileExpression(call.getArguments().get(1)));
          break;
        case "mult":
          StringConcatenation _builder_10 = new StringConcatenation();
          _builder_10.append("(");
          CodeBlock _compileExpression = this.compileExpression(call.getArguments().get(0));
          _builder_10.append(_compileExpression);
          _builder_10.append(") * (");
          CodeBlock _compileExpression_1 = this.compileExpression(call.getArguments().get(1));
          _builder_10.append(_compileExpression_1);
          _builder_10.append(")");
          _switchResult = CodeBlock.of(_builder_10.toString());
          break;
        case "unaryMin":
          StringConcatenation _builder_11 = new StringConcatenation();
          _builder_11.append("-(");
          CodeBlock _compileExpression_2 = this.compileExpression(call.getArguments().get(0));
          _builder_11.append(_compileExpression_2);
          _builder_11.append(")");
          _switchResult = CodeBlock.of(_builder_11.toString());
          break;
        case "first":
          CodeBlock _xifexpression = null;
          CallType _type = call.getType();
          boolean _equals = Objects.equal(_type, CallType.COLLECTIONCALL);
          if (_equals) {
            StringConcatenation _builder_12 = new StringConcatenation();
            _builder_12.append("$T.head($L)");
            _xifexpression = CodeBlock.of(_builder_12.toString(), ClassName.get("org.eclipse.emf.ecoretools.ale.compiler.lib", "CollectionService"), this.compileExpression(call.getArguments().get(0)));
          } else {
            StringConcatenation _builder_13 = new StringConcatenation();
            _builder_13.append("/*FIRST ");
            _builder_13.append(call);
            _builder_13.append("*/");
            _xifexpression = CodeBlock.of(_builder_13.toString());
          }
          _switchResult = _xifexpression;
          break;
        case "size":
          CodeBlock _xifexpression_1 = null;
          CallType _type_1 = call.getType();
          boolean _equals_1 = Objects.equal(_type_1, CallType.COLLECTIONCALL);
          if (_equals_1) {
            StringConcatenation _builder_14 = new StringConcatenation();
            _builder_14.append("$T.size($L)");
            _xifexpression_1 = CodeBlock.of(_builder_14.toString(), ClassName.get("org.eclipse.emf.ecoretools.ale.compiler.lib", "CollectionService"), this.compileExpression(call.getArguments().get(0)));
          } else {
            CodeBlock _xifexpression_2 = null;
            CallType _type_2 = call.getType();
            boolean _equals_2 = Objects.equal(_type_2, CallType.CALLORAPPLY);
            if (_equals_2) {
              StringConcatenation _builder_15 = new StringConcatenation();
              _builder_15.append("$T.size($L)");
              _xifexpression_2 = CodeBlock.of(_builder_15.toString(), ClassName.get("org.eclipse.emf.ecoretools.ale.compiler.lib", "CollectionService"), this.compileExpression(call.getArguments().get(0)));
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
          break;
        case "at":
          CodeBlock _xifexpression_3 = null;
          CallType _type_3 = call.getType();
          boolean _equals_3 = Objects.equal(_type_3, CallType.COLLECTIONCALL);
          if (_equals_3) {
            StringConcatenation _builder_17 = new StringConcatenation();
            _builder_17.append("$T.get($L, $L)");
            _xifexpression_3 = CodeBlock.of(_builder_17.toString(), ClassName.get("org.eclipse.emf.ecoretools.ale.compiler.lib", "CollectionService"), this.compileExpression(call.getArguments().get(0)), this.compileExpression(call.getArguments().get(1)));
          } else {
            StringConcatenation _builder_18 = new StringConcatenation();
            _builder_18.append("/*FIRST ");
            _builder_18.append(call);
            _builder_18.append("*/");
            _xifexpression_3 = CodeBlock.of(_builder_18.toString());
          }
          _switchResult = _xifexpression_3;
          break;
        case "select":
          CodeBlock _xifexpression_4 = null;
          CallType _type_4 = call.getType();
          boolean _equals_4 = Objects.equal(_type_4, CallType.COLLECTIONCALL);
          if (_equals_4) {
            StringConcatenation _builder_19 = new StringConcatenation();
            _builder_19.append("$T.select($L, $L)");
            _xifexpression_4 = CodeBlock.of(_builder_19.toString(), ClassName.get("org.eclipse.emf.ecoretools.ale.compiler.lib", "CollectionService"), this.compileExpression(call.getArguments().get(0)), this.compileExpression(call.getArguments().get(1)));
          } else {
            StringConcatenation _builder_20 = new StringConcatenation();
            _builder_20.append("/*FIRST ");
            _builder_20.append(call);
            _builder_20.append("*/");
            _xifexpression_4 = CodeBlock.of(_builder_20.toString());
          }
          _switchResult = _xifexpression_4;
          break;
        case "filter":
          CodeBlock _xifexpression_5 = null;
          CallType _type_5 = call.getType();
          boolean _equals_5 = Objects.equal(_type_5, CallType.COLLECTIONCALL);
          if (_equals_5) {
            CodeBlock _xblockexpression = null;
            {
              final IType t = IterableExtensions.<IType>head(this.infereType(call.getArguments().get(1)));
              CodeBlock _xifexpression_6 = null;
              if ((t instanceof EClassifierType)) {
                StringConcatenation _builder_21 = new StringConcatenation();
                _builder_21.append("$T.select($L, it -> it instanceof $L)");
                _xifexpression_6 = CodeBlock.of(_builder_21.toString(), ClassName.get("org.eclipse.emf.ecoretools.ale.compiler.lib", "CollectionService"), this.compileExpression(call.getArguments().get(0)), this.compileExpression(call.getArguments().get(1)));
              } else {
                StringConcatenation _builder_22 = new StringConcatenation();
                _builder_22.append("$T.select($L, $L)");
                _xifexpression_6 = CodeBlock.of(_builder_22.toString(), ClassName.get("org.eclipse.emf.ecoretools.ale.compiler.lib", "CollectionService"), this.compileExpression(call.getArguments().get(0)), this.compileExpression(call.getArguments().get(1)));
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
          break;
        case "exists":
          CodeBlock _xifexpression_6 = null;
          CallType _type_6 = call.getType();
          boolean _equals_6 = Objects.equal(_type_6, CallType.COLLECTIONCALL);
          if (_equals_6) {
            StringConcatenation _builder_22 = new StringConcatenation();
            _builder_22.append("$T.exists($L, $L)");
            _xifexpression_6 = CodeBlock.of(_builder_22.toString(), ClassName.get("org.eclipse.emf.ecoretools.ale.compiler.lib", "CollectionService"), this.compileExpression(call.getArguments().get(0)), this.compileExpression(call.getArguments().get(1)));
          } else {
            StringConcatenation _builder_23 = new StringConcatenation();
            _builder_23.append("/*FIRST ");
            _builder_23.append(call);
            _builder_23.append("*/");
            _xifexpression_6 = CodeBlock.of(_builder_23.toString());
          }
          _switchResult = _xifexpression_6;
          break;
        case "isEmpty":
          CodeBlock _xifexpression_7 = null;
          CallType _type_7 = call.getType();
          boolean _equals_7 = Objects.equal(_type_7, CallType.COLLECTIONCALL);
          if (_equals_7) {
            StringConcatenation _builder_24 = new StringConcatenation();
            _builder_24.append("$T.isEmpty($L)");
            _xifexpression_7 = CodeBlock.of(_builder_24.toString(), ClassName.get("org.eclipse.emf.ecoretools.ale.compiler.lib", "CollectionService"), this.compileExpression(call.getArguments().get(0)));
          } else {
            StringConcatenation _builder_25 = new StringConcatenation();
            _builder_25.append("/*FIRST ");
            _builder_25.append(call);
            _builder_25.append("*/");
            _xifexpression_7 = CodeBlock.of(_builder_25.toString());
          }
          _switchResult = _xifexpression_7;
          break;
        case "oclIsKindOf":
          CodeBlock _xifexpression_8 = null;
          CallType _type_8 = call.getType();
          boolean _equals_8 = Objects.equal(_type_8, CallType.CALLORAPPLY);
          if (_equals_8) {
            StringConcatenation _builder_26 = new StringConcatenation();
            _builder_26.append("$L instanceof $L");
            _xifexpression_8 = CodeBlock.of(_builder_26.toString(), this.compileExpression(call.getArguments().get(0)), this.compileExpression(call.getArguments().get(1)));
          } else {
            StringConcatenation _builder_27 = new StringConcatenation();
            _builder_27.append("/*OCLISKINDOF*/");
            _xifexpression_8 = CodeBlock.of(_builder_27.toString());
          }
          _switchResult = _xifexpression_8;
          break;
        case "log":
          CodeBlock _xifexpression_9 = null;
          CallType _type_9 = call.getType();
          boolean _equals_9 = Objects.equal(_type_9, CallType.CALLORAPPLY);
          if (_equals_9) {
            StringConcatenation _builder_28 = new StringConcatenation();
            _builder_28.append("$T.log($L)");
            _xifexpression_9 = CodeBlock.of(_builder_28.toString(), ClassName.get("org.eclipse.emf.ecoretools.ale.compiler.lib", "LogService"), 
              this.compileExpression(call.getArguments().get(0)));
          } else {
            StringConcatenation _builder_29 = new StringConcatenation();
            _builder_29.append("/*OCLISKINDOF*/");
            _xifexpression_9 = CodeBlock.of(_builder_29.toString());
          }
          _switchResult = _xifexpression_9;
          break;
        default:
          CodeBlock _xifexpression_10 = null;
          CallType _type_10 = call.getType();
          boolean _equals_10 = Objects.equal(_type_10, CallType.CALLORAPPLY);
          if (_equals_10) {
            CodeBlock _xifexpression_11 = null;
            String _serviceName_1 = call.getServiceName();
            boolean _equals_11 = Objects.equal(_serviceName_1, "aqlFeatureAccess");
            if (_equals_11) {
              CodeBlock _xblockexpression_1 = null;
              {
                final IType t = IterableExtensions.<IType>head(this.infereType(call));
                final CodeBlock lhs = this.compileExpression(IterableExtensions.<Expression>head(call.getArguments()));
                CodeBlock _xifexpression_12 = null;
                String _string = lhs.toString();
                boolean _equals_12 = Objects.equal(_string, "this");
                if (_equals_12) {
                  CodeBlock _xifexpression_13 = null;
                  if ((((t instanceof SequenceType) && (((SequenceType) t).getCollectionType().getType() instanceof EClass)) && (!Objects.equal(((EClass) ((SequenceType) t).getCollectionType().getType()).getInstanceClassName(), "java.util.Map$Entry")))) {
                    CodeBlock _xblockexpression_2 = null;
                    {
                      Expression _get = call.getArguments().get(1);
                      final String rhs = ((StringLiteral) _get).getValue();
                      StringConcatenation _builder_30 = new StringConcatenation();
                      _builder_30.append(lhs);
                      _builder_30.append(".get");
                      String _firstUpper = StringExtensions.toFirstUpper(rhs);
                      _builder_30.append(_firstUpper);
                      _builder_30.append("()");
                      _xblockexpression_2 = CodeBlock.of(_builder_30.toString());
                    }
                    _xifexpression_13 = _xblockexpression_2;
                  } else {
                    CodeBlock _xifexpression_14 = null;
                    if (((t.getType() instanceof EClass) || (t.getType() instanceof EDataType))) {
                      StringConcatenation _builder_30 = new StringConcatenation();
                      _builder_30.append(lhs);
                      _builder_30.append(".");
                      Expression _get = call.getArguments().get(1);
                      String _value = ((StringLiteral) _get).getValue();
                      _builder_30.append(_value);
                      _xifexpression_14 = CodeBlock.of(_builder_30.toString());
                    } else {
                      StringConcatenation _builder_31 = new StringConcatenation();
                      _builder_31.append(lhs);
                      _builder_31.append(".");
                      {
                        Expression _get_1 = call.getArguments().get(1);
                        if ((_get_1 instanceof StringLiteral)) {
                          Expression _get_2 = call.getArguments().get(1);
                          String _value_1 = ((StringLiteral) _get_2).getValue();
                          _builder_31.append(_value_1);
                        } else {
                          CodeBlock _compileExpression_3 = this.compileExpression(call.getArguments().get(1));
                          _builder_31.append(_compileExpression_3);
                        }
                      }
                      _xifexpression_14 = CodeBlock.of(_builder_31.toString());
                    }
                    _xifexpression_13 = _xifexpression_14;
                  }
                  _xifexpression_12 = _xifexpression_13;
                } else {
                  CodeBlock _xifexpression_15 = null;
                  if (((t instanceof SequenceType) && 
                    (((SequenceType) t).getCollectionType().getType() instanceof EClass))) {
                    StringConcatenation _builder_32 = new StringConcatenation();
                    _builder_32.append(lhs);
                    _builder_32.append(".get");
                    Expression _get_3 = call.getArguments().get(1);
                    String _firstUpper = StringExtensions.toFirstUpper(((StringLiteral) _get_3).getValue());
                    _builder_32.append(_firstUpper);
                    _builder_32.append("()");
                    _xifexpression_15 = CodeBlock.of(_builder_32.toString());
                  } else {
                    CodeBlock _xifexpression_16 = null;
                    if (((t != null) && ((t.getType() instanceof EClass) || (t.getType() instanceof EDataType)))) {
                      CodeBlock _xifexpression_17 = null;
                      if (((t.getType() instanceof EDataType) && (Objects.equal(((EDataType) t.getType()).getInstanceClass(), Boolean.class) || 
                        Objects.equal(((EDataType) t.getType()).getInstanceClass(), boolean.class)))) {
                        StringConcatenation _builder_33 = new StringConcatenation();
                        _builder_33.append(lhs);
                        _builder_33.append(".is");
                        Expression _get_4 = call.getArguments().get(1);
                        String _firstUpper_1 = StringExtensions.toFirstUpper(((StringLiteral) _get_4).getValue());
                        _builder_33.append(_firstUpper_1);
                        _builder_33.append("()");
                        _xifexpression_17 = CodeBlock.of(_builder_33.toString());
                      } else {
                        StringConcatenation _builder_34 = new StringConcatenation();
                        _builder_34.append(lhs);
                        _builder_34.append(".get");
                        Expression _get_5 = call.getArguments().get(1);
                        String _firstUpper_2 = StringExtensions.toFirstUpper(((StringLiteral) _get_5).getValue());
                        _builder_34.append(_firstUpper_2);
                        _builder_34.append("()");
                        _xifexpression_17 = CodeBlock.of(_builder_34.toString());
                      }
                      _xifexpression_16 = _xifexpression_17;
                    } else {
                      StringConcatenation _builder_35 = new StringConcatenation();
                      _builder_35.append(lhs);
                      _builder_35.append(".");
                      {
                        Expression _get_6 = call.getArguments().get(1);
                        if ((_get_6 instanceof StringLiteral)) {
                          _builder_35.append("get");
                          Expression _get_7 = call.getArguments().get(1);
                          String _firstUpper_3 = StringExtensions.toFirstUpper(((StringLiteral) _get_7).getValue());
                          _builder_35.append(_firstUpper_3);
                          _builder_35.append("()");
                        } else {
                          CodeBlock _compileExpression_4 = this.compileExpression(call.getArguments().get(1));
                          _builder_35.append(_compileExpression_4);
                        }
                      }
                      _xifexpression_16 = CodeBlock.of(_builder_35.toString());
                    }
                    _xifexpression_15 = _xifexpression_16;
                  }
                  _xifexpression_12 = _xifexpression_15;
                }
                _xblockexpression_1 = _xifexpression_12;
              }
              _xifexpression_11 = _xblockexpression_1;
            } else {
              CodeBlock _xifexpression_12 = null;
              String _serviceName_2 = call.getServiceName();
              boolean _equals_12 = Objects.equal(_serviceName_2, "create");
              if (_equals_12) {
                CodeBlock _xblockexpression_2 = null;
                {
                  final Expression e = call.getArguments().get(0);
                  final IType t = IterableExtensions.<IType>head(this.infereType(e));
                  Object _type_11 = t.getType();
                  final EClass ecls = ((EClass) _type_11);
                  final EPackage epks = ecls.getEPackage();
                  StringConcatenation _builder_30 = new StringConcatenation();
                  _builder_30.append("$T.eINSTANCE.create");
                  String _name = ecls.getName();
                  _builder_30.append(_name);
                  _builder_30.append("()");
                  _xblockexpression_2 = CodeBlock.of(_builder_30.toString(), ClassName.get(this.getEcoreInterfacesPackage(), this.namingUtils.factoryInterfaceClassName(epks)));
                }
                _xifexpression_12 = _xblockexpression_2;
              } else {
                CodeBlock _xblockexpression_3 = null;
                {
                  final Expression argumentsh = IterableExtensions.<Expression>head(call.getArguments());
                  final Set<IType> ts = this.infereType(argumentsh);
                  final IType t = IterableExtensions.<IType>head(ts);
                  final Function1<ALESwitchImplementationCompiler.ResolvedClass, Boolean> _function = (ALESwitchImplementationCompiler.ResolvedClass it) -> {
                    boolean _xifexpression_13 = false;
                    if (((t != null) && (t.getType() instanceof EClass))) {
                      boolean _xblockexpression_4 = false;
                      {
                        Object _type_11 = t.getType();
                        final EClass tecls = ((EClass) _type_11);
                        _xblockexpression_4 = (Objects.equal(it.getECls().getName(), tecls.getName()) && Objects.equal(it.getECls().getEPackage().getName(), tecls.getEPackage().getName()));
                      }
                      _xifexpression_13 = _xblockexpression_4;
                    } else {
                      _xifexpression_13 = false;
                    }
                    return Boolean.valueOf(_xifexpression_13);
                  };
                  final ALESwitchImplementationCompiler.ResolvedClass re = IterableExtensions.<ALESwitchImplementationCompiler.ResolvedClass>head(IterableExtensions.<ALESwitchImplementationCompiler.ResolvedClass>filter(this.resolved, _function));
                  CodeBlock _xifexpression_13 = null;
                  if ((re != null)) {
                    CodeBlock _xblockexpression_4 = null;
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
                        CodeBlock _xblockexpression_5 = null;
                        {
                          final Function1<Method, Boolean> _function_2 = (Method it) -> {
                            String _name = it.getOperationRef().getName();
                            String _serviceName_3 = call.getServiceName();
                            return Boolean.valueOf(Objects.equal(_name, _serviceName_3));
                          };
                          final List<Method> methods = IterableExtensions.<Method>toList(IterableExtensions.<Method>filter(allMethods, _function_2));
                          Method method = null;
                          ALESwitchImplementationCompiler.ResolvedClass rev = re;
                          while ((method == null)) {
                            {
                              final ExtendedClass lc = rev.getAleCls();
                              final Function1<Method, Boolean> _function_3 = (Method it) -> {
                                EObject _eContainer = it.eContainer();
                                return Boolean.valueOf((_eContainer == lc));
                              };
                              method = IterableExtensions.<Method>head(IterableExtensions.<Method>filter(methods, _function_3));
                              final ALESwitchImplementationCompiler.ResolvedClass revc = rev;
                              final Function1<ALESwitchImplementationCompiler.ResolvedClass, Boolean> _function_4 = (ALESwitchImplementationCompiler.ResolvedClass it) -> {
                                return Boolean.valueOf(((revc.eCls instanceof EClass) && 
                                  ((EClass) revc.eCls).getESuperTypes().contains(it.eCls)));
                              };
                              rev = IterableExtensions.<ALESwitchImplementationCompiler.ResolvedClass>head(IterableExtensions.<ALESwitchImplementationCompiler.ResolvedClass>filter(this.resolved, _function_4));
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
                              final ALESwitchImplementationCompiler.ResolvedClass revc = rev;
                              final Function1<ALESwitchImplementationCompiler.ResolvedClass, Boolean> _function_4 = (ALESwitchImplementationCompiler.ResolvedClass it) -> {
                                return Boolean.valueOf(((revc.eCls instanceof EClass) && 
                                  ((EClass) revc.eCls).getESuperTypes().contains(it.eCls)));
                              };
                              rev = IterableExtensions.<ALESwitchImplementationCompiler.ResolvedClass>head(IterableExtensions.<ALESwitchImplementationCompiler.ResolvedClass>filter(this.resolved, _function_4));
                            }
                          }
                          Object _type_11 = t.getType();
                          ClassName _get = ClassName.get(this.namingUtils.operationPackageName(this.packageRoot), this.namingUtils.operationClassName(this.solveType(((EClassifier) _type_11))));
                          Pair<String, ClassName> _mappedTo = Pair.<String, ClassName>of("operationType", _get);
                          CodeBlock _compileExpression_3 = this.compileExpression(IterableExtensions.<Expression>head(call.getArguments()));
                          Pair<String, CodeBlock> _mappedTo_1 = Pair.<String, CodeBlock>of("switched", _compileExpression_3);
                          String _serviceName_3 = call.getServiceName();
                          Pair<String, String> _mappedTo_2 = Pair.<String, String>of("callService", _serviceName_3);
                          final HashMap<String, Object> hm = CollectionLiterals.<String, Object>newHashMap(_mappedTo, _mappedTo_1, _mappedTo_2);
                          Iterable<Pair<Expression, Integer>> _enumerate = this.<Expression>enumerate(IterableExtensions.<Expression>tail(call.getArguments()));
                          for (final Pair<Expression, Integer> param : _enumerate) {
                            {
                              Integer _value = param.getValue();
                              String _plus = ("paramType" + _value);
                              Object _type_12 = IterableExtensions.<IType>head(this.infereType(param.getKey())).getType();
                              hm.put(_plus, this.solveType(((EClass) _type_12)));
                              Integer _value_1 = param.getValue();
                              String _plus_1 = ("paramExpr" + _value_1);
                              hm.put(_plus_1, this.compileExpression(param.getKey()));
                            }
                          }
                          CodeBlock.Builder _builder_30 = CodeBlock.builder();
                          StringConcatenation _builder_31 = new StringConcatenation();
                          _builder_31.append("(($operationType:T) emfswitch.doSwitch($switched:L)).$callService:L(");
                          {
                            Iterable<Pair<Expression, Integer>> _enumerate_1 = this.<Expression>enumerate(IterableExtensions.<Expression>tail(call.getArguments()));
                            boolean _hasElements = false;
                            for(final Pair<Expression, Integer> param_1 : _enumerate_1) {
                              if (!_hasElements) {
                                _hasElements = true;
                              } else {
                                _builder_31.appendImmediate(",", "");
                              }
                              _builder_31.append("($paramType");
                              Integer _value = param_1.getValue();
                              _builder_31.append(_value);
                              _builder_31.append(":T) $paramExpr");
                              Integer _value_1 = param_1.getValue();
                              _builder_31.append(_value_1);
                              _builder_31.append(":L");
                            }
                          }
                          _builder_31.append(")");
                          _xblockexpression_5 = _builder_30.addNamed(_builder_31.toString(), hm).build();
                        }
                        _xifexpression_14 = _xblockexpression_5;
                      } else {
                        CodeBlock _xblockexpression_6 = null;
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
                            return Boolean.valueOf(java.lang.reflect.Modifier.isStatic(it.getValue().getModifiers()));
                          };
                          final Function1<Pair<String, java.lang.reflect.Method>, Boolean> _function_4 = (Pair<String, java.lang.reflect.Method> it) -> {
                            String _name = it.getValue().getName();
                            String _serviceName_3 = call.getServiceName();
                            return Boolean.valueOf(Objects.equal(_name, _serviceName_3));
                          };
                          final Pair<String, java.lang.reflect.Method> candidate = IterableExtensions.<Pair<String, java.lang.reflect.Method>>head(IterableExtensions.<Pair<String, java.lang.reflect.Method>>filter(IterableExtensions.<Pair<String, java.lang.reflect.Method>>filter(methods, _function_3), _function_4));
                          CodeBlock _xifexpression_15 = null;
                          if ((candidate != null)) {
                            StringConcatenation _builder_30 = new StringConcatenation();
                            String _key = candidate.getKey();
                            _builder_30.append(_key);
                            _builder_30.append(".");
                            String _name = candidate.getValue().getName();
                            _builder_30.append(_name);
                            _builder_30.append("(");
                            {
                              EList<Expression> _arguments = call.getArguments();
                              boolean _hasElements = false;
                              for(final Expression p : _arguments) {
                                if (!_hasElements) {
                                  _hasElements = true;
                                } else {
                                  _builder_30.appendImmediate(", ", "");
                                }
                                CodeBlock _compileExpression_3 = this.compileExpression(p);
                                _builder_30.append(_compileExpression_3);
                              }
                            }
                            _builder_30.append(")");
                            _xifexpression_15 = CodeBlock.of(_builder_30.toString());
                          } else {
                            StringConcatenation _builder_31 = new StringConcatenation();
                            _builder_31.append("(($T) emfswitch.doSwitch(");
                            CodeBlock _compileExpression_4 = this.compileExpression(IterableExtensions.<Expression>head(call.getArguments()));
                            _builder_31.append(_compileExpression_4);
                            _builder_31.append(")).");
                            String _serviceName_3 = call.getServiceName();
                            _builder_31.append(_serviceName_3);
                            _builder_31.append("(");
                            {
                              Iterable<Expression> _tail = IterableExtensions.<Expression>tail(call.getArguments());
                              boolean _hasElements_1 = false;
                              for(final Expression param : _tail) {
                                if (!_hasElements_1) {
                                  _hasElements_1 = true;
                                } else {
                                  _builder_31.appendImmediate(",", "");
                                }
                                CodeBlock _compileExpression_5 = this.compileExpression(param);
                                _builder_31.append(_compileExpression_5);
                              }
                            }
                            _builder_31.append(")");
                            Object _type_11 = t.getType();
                            _xifexpression_15 = CodeBlock.of(_builder_31.toString(), 
                              ClassName.get(this.namingUtils.operationPackageName(this.packageRoot), 
                                this.namingUtils.operationClassName(this.solveType(((EClassifier) _type_11)))));
                          }
                          _xblockexpression_6 = _xifexpression_15;
                        }
                        _xifexpression_14 = _xblockexpression_6;
                      }
                      _xblockexpression_4 = _xifexpression_14;
                    }
                    _xifexpression_13 = _xblockexpression_4;
                  } else {
                    CodeBlock _xblockexpression_5 = null;
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
                        return Boolean.valueOf(java.lang.reflect.Modifier.isStatic(it.getValue().getModifiers()));
                      };
                      final Function1<Pair<String, java.lang.reflect.Method>, Boolean> _function_3 = (Pair<String, java.lang.reflect.Method> it) -> {
                        String _name = it.getValue().getName();
                        String _serviceName_3 = call.getServiceName();
                        return Boolean.valueOf(Objects.equal(_name, _serviceName_3));
                      };
                      final Pair<String, java.lang.reflect.Method> candidate = IterableExtensions.<Pair<String, java.lang.reflect.Method>>head(IterableExtensions.<Pair<String, java.lang.reflect.Method>>filter(IterableExtensions.<Pair<String, java.lang.reflect.Method>>filter(methods, _function_2), _function_3));
                      CodeBlock _xifexpression_14 = null;
                      if ((candidate != null)) {
                        StringConcatenation _builder_30 = new StringConcatenation();
                        String _key = candidate.getKey();
                        _builder_30.append(_key);
                        _builder_30.append(".");
                        String _name = candidate.getValue().getName();
                        _builder_30.append(_name);
                        _builder_30.append("(");
                        {
                          EList<Expression> _arguments = call.getArguments();
                          boolean _hasElements = false;
                          for(final Expression p : _arguments) {
                            if (!_hasElements) {
                              _hasElements = true;
                            } else {
                              _builder_30.appendImmediate(", ", "");
                            }
                            CodeBlock _compileExpression_3 = this.compileExpression(p);
                            _builder_30.append(_compileExpression_3);
                          }
                        }
                        _builder_30.append(")");
                        _xifexpression_14 = CodeBlock.of(_builder_30.toString());
                      } else {
                        CodeBlock _xifexpression_15 = null;
                        if (((((t != null) && (t.getType() != null)) && (t.getType() instanceof EClassifier)) && (this.solveType(((EClassifier) t.getType())) instanceof EClass))) {
                          StringConcatenation _builder_31 = new StringConcatenation();
                          _builder_31.append("(($T) emfswitch.doSwitch(");
                          CodeBlock _compileExpression_4 = this.compileExpression(IterableExtensions.<Expression>head(call.getArguments()));
                          _builder_31.append(_compileExpression_4);
                          _builder_31.append(")).");
                          String _serviceName_3 = call.getServiceName();
                          _builder_31.append(_serviceName_3);
                          _builder_31.append("(");
                          {
                            Iterable<Expression> _tail = IterableExtensions.<Expression>tail(call.getArguments());
                            boolean _hasElements_1 = false;
                            for(final Expression param : _tail) {
                              if (!_hasElements_1) {
                                _hasElements_1 = true;
                              } else {
                                _builder_31.appendImmediate(",", "");
                              }
                              CodeBlock _compileExpression_5 = this.compileExpression(param);
                              _builder_31.append(_compileExpression_5);
                            }
                          }
                          _builder_31.append(")");
                          Object _type_11 = t.getType();
                          Object _solveType = this.solveType(((EClassifier) _type_11));
                          _xifexpression_15 = CodeBlock.of(_builder_31.toString(), 
                            ClassName.get(this.namingUtils.operationPackageName(this.packageRoot), 
                              this.namingUtils.operationClassName(
                                ((EClass) _solveType))));
                        } else {
                          StringConcatenation _builder_32 = new StringConcatenation();
                          CodeBlock _compileExpression_6 = this.compileExpression(IterableExtensions.<Expression>head(call.getArguments()));
                          _builder_32.append(_compileExpression_6);
                          _builder_32.append(".");
                          String _serviceName_4 = call.getServiceName();
                          _builder_32.append(_serviceName_4);
                          _builder_32.append("(");
                          {
                            Iterable<Expression> _tail_1 = IterableExtensions.<Expression>tail(call.getArguments());
                            boolean _hasElements_2 = false;
                            for(final Expression param_1 : _tail_1) {
                              if (!_hasElements_2) {
                                _hasElements_2 = true;
                              } else {
                                _builder_32.appendImmediate(",", "");
                              }
                              CodeBlock _compileExpression_7 = this.compileExpression(param_1);
                              _builder_32.append(_compileExpression_7);
                            }
                          }
                          _builder_32.append(")");
                          _xifexpression_15 = CodeBlock.of(_builder_32.toString());
                        }
                        _xifexpression_14 = _xifexpression_15;
                      }
                      _xblockexpression_5 = _xifexpression_14;
                    }
                    _xifexpression_13 = _xblockexpression_5;
                  }
                  _xblockexpression_3 = _xifexpression_13;
                }
                _xifexpression_12 = _xblockexpression_3;
              }
              _xifexpression_11 = _xifexpression_12;
            }
            _xifexpression_10 = _xifexpression_11;
          } else {
            StringConcatenation _builder_30 = new StringConcatenation();
            _builder_30.append("/*Call ");
            _builder_30.append(call);
            _builder_30.append("*/");
            _xifexpression_10 = CodeBlock.of(_builder_30.toString());
          }
          _switchResult = _xifexpression_10;
          break;
      }
    } else {
      CodeBlock _xifexpression_10 = null;
      CallType _type_10 = call.getType();
      boolean _equals_10 = Objects.equal(_type_10, CallType.CALLORAPPLY);
      if (_equals_10) {
        CodeBlock _xifexpression_11 = null;
        String _serviceName_1 = call.getServiceName();
        boolean _equals_11 = Objects.equal(_serviceName_1, "aqlFeatureAccess");
        if (_equals_11) {
          CodeBlock _xblockexpression_1 = null;
          {
            final IType t = IterableExtensions.<IType>head(this.infereType(call));
            final CodeBlock lhs = this.compileExpression(IterableExtensions.<Expression>head(call.getArguments()));
            CodeBlock _xifexpression_12 = null;
            String _string = lhs.toString();
            boolean _equals_12 = Objects.equal(_string, "this");
            if (_equals_12) {
              CodeBlock _xifexpression_13 = null;
              if ((((t instanceof SequenceType) && (((SequenceType) t).getCollectionType().getType() instanceof EClass)) && (!Objects.equal(((EClass) ((SequenceType) t).getCollectionType().getType()).getInstanceClassName(), "java.util.Map$Entry")))) {
                CodeBlock _xblockexpression_2 = null;
                {
                  Expression _get = call.getArguments().get(1);
                  final String rhs = ((StringLiteral) _get).getValue();
                  StringConcatenation _builder_30 = new StringConcatenation();
                  _builder_30.append(lhs);
                  _builder_30.append(".get");
                  String _firstUpper = StringExtensions.toFirstUpper(rhs);
                  _builder_30.append(_firstUpper);
                  _builder_30.append("()");
                  _xblockexpression_2 = CodeBlock.of(_builder_30.toString());
                }
                _xifexpression_13 = _xblockexpression_2;
              } else {
                CodeBlock _xifexpression_14 = null;
                if (((t.getType() instanceof EClass) || (t.getType() instanceof EDataType))) {
                  StringConcatenation _builder_30 = new StringConcatenation();
                  _builder_30.append(lhs);
                  _builder_30.append(".");
                  Expression _get = call.getArguments().get(1);
                  String _value = ((StringLiteral) _get).getValue();
                  _builder_30.append(_value);
                  _xifexpression_14 = CodeBlock.of(_builder_30.toString());
                } else {
                  StringConcatenation _builder_31 = new StringConcatenation();
                  _builder_31.append(lhs);
                  _builder_31.append(".");
                  {
                    Expression _get_1 = call.getArguments().get(1);
                    if ((_get_1 instanceof StringLiteral)) {
                      Expression _get_2 = call.getArguments().get(1);
                      String _value_1 = ((StringLiteral) _get_2).getValue();
                      _builder_31.append(_value_1);
                    } else {
                      CodeBlock _compileExpression_3 = this.compileExpression(call.getArguments().get(1));
                      _builder_31.append(_compileExpression_3);
                    }
                  }
                  _xifexpression_14 = CodeBlock.of(_builder_31.toString());
                }
                _xifexpression_13 = _xifexpression_14;
              }
              _xifexpression_12 = _xifexpression_13;
            } else {
              CodeBlock _xifexpression_15 = null;
              if (((t instanceof SequenceType) && 
                (((SequenceType) t).getCollectionType().getType() instanceof EClass))) {
                StringConcatenation _builder_32 = new StringConcatenation();
                _builder_32.append(lhs);
                _builder_32.append(".get");
                Expression _get_3 = call.getArguments().get(1);
                String _firstUpper = StringExtensions.toFirstUpper(((StringLiteral) _get_3).getValue());
                _builder_32.append(_firstUpper);
                _builder_32.append("()");
                _xifexpression_15 = CodeBlock.of(_builder_32.toString());
              } else {
                CodeBlock _xifexpression_16 = null;
                if (((t != null) && ((t.getType() instanceof EClass) || (t.getType() instanceof EDataType)))) {
                  CodeBlock _xifexpression_17 = null;
                  if (((t.getType() instanceof EDataType) && (Objects.equal(((EDataType) t.getType()).getInstanceClass(), Boolean.class) || 
                    Objects.equal(((EDataType) t.getType()).getInstanceClass(), boolean.class)))) {
                    StringConcatenation _builder_33 = new StringConcatenation();
                    _builder_33.append(lhs);
                    _builder_33.append(".is");
                    Expression _get_4 = call.getArguments().get(1);
                    String _firstUpper_1 = StringExtensions.toFirstUpper(((StringLiteral) _get_4).getValue());
                    _builder_33.append(_firstUpper_1);
                    _builder_33.append("()");
                    _xifexpression_17 = CodeBlock.of(_builder_33.toString());
                  } else {
                    StringConcatenation _builder_34 = new StringConcatenation();
                    _builder_34.append(lhs);
                    _builder_34.append(".get");
                    Expression _get_5 = call.getArguments().get(1);
                    String _firstUpper_2 = StringExtensions.toFirstUpper(((StringLiteral) _get_5).getValue());
                    _builder_34.append(_firstUpper_2);
                    _builder_34.append("()");
                    _xifexpression_17 = CodeBlock.of(_builder_34.toString());
                  }
                  _xifexpression_16 = _xifexpression_17;
                } else {
                  StringConcatenation _builder_35 = new StringConcatenation();
                  _builder_35.append(lhs);
                  _builder_35.append(".");
                  {
                    Expression _get_6 = call.getArguments().get(1);
                    if ((_get_6 instanceof StringLiteral)) {
                      _builder_35.append("get");
                      Expression _get_7 = call.getArguments().get(1);
                      String _firstUpper_3 = StringExtensions.toFirstUpper(((StringLiteral) _get_7).getValue());
                      _builder_35.append(_firstUpper_3);
                      _builder_35.append("()");
                    } else {
                      CodeBlock _compileExpression_4 = this.compileExpression(call.getArguments().get(1));
                      _builder_35.append(_compileExpression_4);
                    }
                  }
                  _xifexpression_16 = CodeBlock.of(_builder_35.toString());
                }
                _xifexpression_15 = _xifexpression_16;
              }
              _xifexpression_12 = _xifexpression_15;
            }
            _xblockexpression_1 = _xifexpression_12;
          }
          _xifexpression_11 = _xblockexpression_1;
        } else {
          CodeBlock _xifexpression_12 = null;
          String _serviceName_2 = call.getServiceName();
          boolean _equals_12 = Objects.equal(_serviceName_2, "create");
          if (_equals_12) {
            CodeBlock _xblockexpression_2 = null;
            {
              final Expression e = call.getArguments().get(0);
              final IType t = IterableExtensions.<IType>head(this.infereType(e));
              Object _type_11 = t.getType();
              final EClass ecls = ((EClass) _type_11);
              final EPackage epks = ecls.getEPackage();
              StringConcatenation _builder_30 = new StringConcatenation();
              _builder_30.append("$T.eINSTANCE.create");
              String _name = ecls.getName();
              _builder_30.append(_name);
              _builder_30.append("()");
              _xblockexpression_2 = CodeBlock.of(_builder_30.toString(), ClassName.get(this.getEcoreInterfacesPackage(), this.namingUtils.factoryInterfaceClassName(epks)));
            }
            _xifexpression_12 = _xblockexpression_2;
          } else {
            CodeBlock _xblockexpression_3 = null;
            {
              final Expression argumentsh = IterableExtensions.<Expression>head(call.getArguments());
              final Set<IType> ts = this.infereType(argumentsh);
              final IType t = IterableExtensions.<IType>head(ts);
              final Function1<ALESwitchImplementationCompiler.ResolvedClass, Boolean> _function = (ALESwitchImplementationCompiler.ResolvedClass it) -> {
                boolean _xifexpression_13 = false;
                if (((t != null) && (t.getType() instanceof EClass))) {
                  boolean _xblockexpression_4 = false;
                  {
                    Object _type_11 = t.getType();
                    final EClass tecls = ((EClass) _type_11);
                    _xblockexpression_4 = (Objects.equal(it.getECls().getName(), tecls.getName()) && Objects.equal(it.getECls().getEPackage().getName(), tecls.getEPackage().getName()));
                  }
                  _xifexpression_13 = _xblockexpression_4;
                } else {
                  _xifexpression_13 = false;
                }
                return Boolean.valueOf(_xifexpression_13);
              };
              final ALESwitchImplementationCompiler.ResolvedClass re = IterableExtensions.<ALESwitchImplementationCompiler.ResolvedClass>head(IterableExtensions.<ALESwitchImplementationCompiler.ResolvedClass>filter(this.resolved, _function));
              CodeBlock _xifexpression_13 = null;
              if ((re != null)) {
                CodeBlock _xblockexpression_4 = null;
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
                    CodeBlock _xblockexpression_5 = null;
                    {
                      final Function1<Method, Boolean> _function_2 = (Method it) -> {
                        String _name = it.getOperationRef().getName();
                        String _serviceName_3 = call.getServiceName();
                        return Boolean.valueOf(Objects.equal(_name, _serviceName_3));
                      };
                      final List<Method> methods = IterableExtensions.<Method>toList(IterableExtensions.<Method>filter(allMethods, _function_2));
                      Method method = null;
                      ALESwitchImplementationCompiler.ResolvedClass rev = re;
                      while ((method == null)) {
                        {
                          final ExtendedClass lc = rev.getAleCls();
                          final Function1<Method, Boolean> _function_3 = (Method it) -> {
                            EObject _eContainer = it.eContainer();
                            return Boolean.valueOf((_eContainer == lc));
                          };
                          method = IterableExtensions.<Method>head(IterableExtensions.<Method>filter(methods, _function_3));
                          final ALESwitchImplementationCompiler.ResolvedClass revc = rev;
                          final Function1<ALESwitchImplementationCompiler.ResolvedClass, Boolean> _function_4 = (ALESwitchImplementationCompiler.ResolvedClass it) -> {
                            return Boolean.valueOf(((revc.eCls instanceof EClass) && 
                              ((EClass) revc.eCls).getESuperTypes().contains(it.eCls)));
                          };
                          rev = IterableExtensions.<ALESwitchImplementationCompiler.ResolvedClass>head(IterableExtensions.<ALESwitchImplementationCompiler.ResolvedClass>filter(this.resolved, _function_4));
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
                          final ALESwitchImplementationCompiler.ResolvedClass revc = rev;
                          final Function1<ALESwitchImplementationCompiler.ResolvedClass, Boolean> _function_4 = (ALESwitchImplementationCompiler.ResolvedClass it) -> {
                            return Boolean.valueOf(((revc.eCls instanceof EClass) && 
                              ((EClass) revc.eCls).getESuperTypes().contains(it.eCls)));
                          };
                          rev = IterableExtensions.<ALESwitchImplementationCompiler.ResolvedClass>head(IterableExtensions.<ALESwitchImplementationCompiler.ResolvedClass>filter(this.resolved, _function_4));
                        }
                      }
                      Object _type_11 = t.getType();
                      ClassName _get = ClassName.get(this.namingUtils.operationPackageName(this.packageRoot), this.namingUtils.operationClassName(this.solveType(((EClassifier) _type_11))));
                      Pair<String, ClassName> _mappedTo = Pair.<String, ClassName>of("operationType", _get);
                      CodeBlock _compileExpression_3 = this.compileExpression(IterableExtensions.<Expression>head(call.getArguments()));
                      Pair<String, CodeBlock> _mappedTo_1 = Pair.<String, CodeBlock>of("switched", _compileExpression_3);
                      String _serviceName_3 = call.getServiceName();
                      Pair<String, String> _mappedTo_2 = Pair.<String, String>of("callService", _serviceName_3);
                      final HashMap<String, Object> hm = CollectionLiterals.<String, Object>newHashMap(_mappedTo, _mappedTo_1, _mappedTo_2);
                      Iterable<Pair<Expression, Integer>> _enumerate = this.<Expression>enumerate(IterableExtensions.<Expression>tail(call.getArguments()));
                      for (final Pair<Expression, Integer> param : _enumerate) {
                        {
                          Integer _value = param.getValue();
                          String _plus = ("paramType" + _value);
                          Object _type_12 = IterableExtensions.<IType>head(this.infereType(param.getKey())).getType();
                          hm.put(_plus, this.solveType(((EClass) _type_12)));
                          Integer _value_1 = param.getValue();
                          String _plus_1 = ("paramExpr" + _value_1);
                          hm.put(_plus_1, this.compileExpression(param.getKey()));
                        }
                      }
                      CodeBlock.Builder _builder_30 = CodeBlock.builder();
                      StringConcatenation _builder_31 = new StringConcatenation();
                      _builder_31.append("(($operationType:T) emfswitch.doSwitch($switched:L)).$callService:L(");
                      {
                        Iterable<Pair<Expression, Integer>> _enumerate_1 = this.<Expression>enumerate(IterableExtensions.<Expression>tail(call.getArguments()));
                        boolean _hasElements = false;
                        for(final Pair<Expression, Integer> param_1 : _enumerate_1) {
                          if (!_hasElements) {
                            _hasElements = true;
                          } else {
                            _builder_31.appendImmediate(",", "");
                          }
                          _builder_31.append("($paramType");
                          Integer _value = param_1.getValue();
                          _builder_31.append(_value);
                          _builder_31.append(":T) $paramExpr");
                          Integer _value_1 = param_1.getValue();
                          _builder_31.append(_value_1);
                          _builder_31.append(":L");
                        }
                      }
                      _builder_31.append(")");
                      _xblockexpression_5 = _builder_30.addNamed(_builder_31.toString(), hm).build();
                    }
                    _xifexpression_14 = _xblockexpression_5;
                  } else {
                    CodeBlock _xblockexpression_6 = null;
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
                        return Boolean.valueOf(java.lang.reflect.Modifier.isStatic(it.getValue().getModifiers()));
                      };
                      final Function1<Pair<String, java.lang.reflect.Method>, Boolean> _function_4 = (Pair<String, java.lang.reflect.Method> it) -> {
                        String _name = it.getValue().getName();
                        String _serviceName_3 = call.getServiceName();
                        return Boolean.valueOf(Objects.equal(_name, _serviceName_3));
                      };
                      final Pair<String, java.lang.reflect.Method> candidate = IterableExtensions.<Pair<String, java.lang.reflect.Method>>head(IterableExtensions.<Pair<String, java.lang.reflect.Method>>filter(IterableExtensions.<Pair<String, java.lang.reflect.Method>>filter(methods, _function_3), _function_4));
                      CodeBlock _xifexpression_15 = null;
                      if ((candidate != null)) {
                        StringConcatenation _builder_30 = new StringConcatenation();
                        String _key = candidate.getKey();
                        _builder_30.append(_key);
                        _builder_30.append(".");
                        String _name = candidate.getValue().getName();
                        _builder_30.append(_name);
                        _builder_30.append("(");
                        {
                          EList<Expression> _arguments = call.getArguments();
                          boolean _hasElements = false;
                          for(final Expression p : _arguments) {
                            if (!_hasElements) {
                              _hasElements = true;
                            } else {
                              _builder_30.appendImmediate(", ", "");
                            }
                            CodeBlock _compileExpression_3 = this.compileExpression(p);
                            _builder_30.append(_compileExpression_3);
                          }
                        }
                        _builder_30.append(")");
                        _xifexpression_15 = CodeBlock.of(_builder_30.toString());
                      } else {
                        StringConcatenation _builder_31 = new StringConcatenation();
                        _builder_31.append("(($T) emfswitch.doSwitch(");
                        CodeBlock _compileExpression_4 = this.compileExpression(IterableExtensions.<Expression>head(call.getArguments()));
                        _builder_31.append(_compileExpression_4);
                        _builder_31.append(")).");
                        String _serviceName_3 = call.getServiceName();
                        _builder_31.append(_serviceName_3);
                        _builder_31.append("(");
                        {
                          Iterable<Expression> _tail = IterableExtensions.<Expression>tail(call.getArguments());
                          boolean _hasElements_1 = false;
                          for(final Expression param : _tail) {
                            if (!_hasElements_1) {
                              _hasElements_1 = true;
                            } else {
                              _builder_31.appendImmediate(",", "");
                            }
                            CodeBlock _compileExpression_5 = this.compileExpression(param);
                            _builder_31.append(_compileExpression_5);
                          }
                        }
                        _builder_31.append(")");
                        Object _type_11 = t.getType();
                        _xifexpression_15 = CodeBlock.of(_builder_31.toString(), 
                          ClassName.get(this.namingUtils.operationPackageName(this.packageRoot), 
                            this.namingUtils.operationClassName(this.solveType(((EClassifier) _type_11)))));
                      }
                      _xblockexpression_6 = _xifexpression_15;
                    }
                    _xifexpression_14 = _xblockexpression_6;
                  }
                  _xblockexpression_4 = _xifexpression_14;
                }
                _xifexpression_13 = _xblockexpression_4;
              } else {
                CodeBlock _xblockexpression_5 = null;
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
                    return Boolean.valueOf(java.lang.reflect.Modifier.isStatic(it.getValue().getModifiers()));
                  };
                  final Function1<Pair<String, java.lang.reflect.Method>, Boolean> _function_3 = (Pair<String, java.lang.reflect.Method> it) -> {
                    String _name = it.getValue().getName();
                    String _serviceName_3 = call.getServiceName();
                    return Boolean.valueOf(Objects.equal(_name, _serviceName_3));
                  };
                  final Pair<String, java.lang.reflect.Method> candidate = IterableExtensions.<Pair<String, java.lang.reflect.Method>>head(IterableExtensions.<Pair<String, java.lang.reflect.Method>>filter(IterableExtensions.<Pair<String, java.lang.reflect.Method>>filter(methods, _function_2), _function_3));
                  CodeBlock _xifexpression_14 = null;
                  if ((candidate != null)) {
                    StringConcatenation _builder_30 = new StringConcatenation();
                    String _key = candidate.getKey();
                    _builder_30.append(_key);
                    _builder_30.append(".");
                    String _name = candidate.getValue().getName();
                    _builder_30.append(_name);
                    _builder_30.append("(");
                    {
                      EList<Expression> _arguments = call.getArguments();
                      boolean _hasElements = false;
                      for(final Expression p : _arguments) {
                        if (!_hasElements) {
                          _hasElements = true;
                        } else {
                          _builder_30.appendImmediate(", ", "");
                        }
                        CodeBlock _compileExpression_3 = this.compileExpression(p);
                        _builder_30.append(_compileExpression_3);
                      }
                    }
                    _builder_30.append(")");
                    _xifexpression_14 = CodeBlock.of(_builder_30.toString());
                  } else {
                    CodeBlock _xifexpression_15 = null;
                    if (((((t != null) && (t.getType() != null)) && (t.getType() instanceof EClassifier)) && (this.solveType(((EClassifier) t.getType())) instanceof EClass))) {
                      StringConcatenation _builder_31 = new StringConcatenation();
                      _builder_31.append("(($T) emfswitch.doSwitch(");
                      CodeBlock _compileExpression_4 = this.compileExpression(IterableExtensions.<Expression>head(call.getArguments()));
                      _builder_31.append(_compileExpression_4);
                      _builder_31.append(")).");
                      String _serviceName_3 = call.getServiceName();
                      _builder_31.append(_serviceName_3);
                      _builder_31.append("(");
                      {
                        Iterable<Expression> _tail = IterableExtensions.<Expression>tail(call.getArguments());
                        boolean _hasElements_1 = false;
                        for(final Expression param : _tail) {
                          if (!_hasElements_1) {
                            _hasElements_1 = true;
                          } else {
                            _builder_31.appendImmediate(",", "");
                          }
                          CodeBlock _compileExpression_5 = this.compileExpression(param);
                          _builder_31.append(_compileExpression_5);
                        }
                      }
                      _builder_31.append(")");
                      Object _type_11 = t.getType();
                      Object _solveType = this.solveType(((EClassifier) _type_11));
                      _xifexpression_15 = CodeBlock.of(_builder_31.toString(), 
                        ClassName.get(this.namingUtils.operationPackageName(this.packageRoot), 
                          this.namingUtils.operationClassName(
                            ((EClass) _solveType))));
                    } else {
                      StringConcatenation _builder_32 = new StringConcatenation();
                      CodeBlock _compileExpression_6 = this.compileExpression(IterableExtensions.<Expression>head(call.getArguments()));
                      _builder_32.append(_compileExpression_6);
                      _builder_32.append(".");
                      String _serviceName_4 = call.getServiceName();
                      _builder_32.append(_serviceName_4);
                      _builder_32.append("(");
                      {
                        Iterable<Expression> _tail_1 = IterableExtensions.<Expression>tail(call.getArguments());
                        boolean _hasElements_2 = false;
                        for(final Expression param_1 : _tail_1) {
                          if (!_hasElements_2) {
                            _hasElements_2 = true;
                          } else {
                            _builder_32.appendImmediate(",", "");
                          }
                          CodeBlock _compileExpression_7 = this.compileExpression(param_1);
                          _builder_32.append(_compileExpression_7);
                        }
                      }
                      _builder_32.append(")");
                      _xifexpression_15 = CodeBlock.of(_builder_32.toString());
                    }
                    _xifexpression_14 = _xifexpression_15;
                  }
                  _xblockexpression_5 = _xifexpression_14;
                }
                _xifexpression_13 = _xblockexpression_5;
              }
              _xblockexpression_3 = _xifexpression_13;
            }
            _xifexpression_12 = _xblockexpression_3;
          }
          _xifexpression_11 = _xifexpression_12;
        }
        _xifexpression_10 = _xifexpression_11;
      } else {
        StringConcatenation _builder_30 = new StringConcatenation();
        _builder_30.append("/*Call ");
        _builder_30.append(call);
        _builder_30.append("*/");
        _xifexpression_10 = CodeBlock.of(_builder_30.toString());
      }
      _switchResult = _xifexpression_10;
    }
    return _switchResult;
  }
  
  protected CodeBlock _compileExpression(final And call) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("((");
    CodeBlock _compileExpression = this.compileExpression(call.getArguments().get(0));
    _builder.append(_compileExpression);
    _builder.append(") && (");
    CodeBlock _compileExpression_1 = this.compileExpression(call.getArguments().get(1));
    _builder.append(_compileExpression_1);
    _builder.append("))");
    return CodeBlock.of(_builder.toString());
  }
  
  protected CodeBlock _compileExpression(final ErrorCall call) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/*ERRORCALL*/");
    return CodeBlock.of(_builder.toString());
  }
  
  protected CodeBlock _compileExpression(final Implies call) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/*IMPLIES*/");
    return CodeBlock.of(_builder.toString());
  }
  
  protected CodeBlock _compileExpression(final Or call) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("((");
    CodeBlock _compileExpression = this.compileExpression(call.getArguments().get(0));
    _builder.append(_compileExpression);
    _builder.append(") || (");
    CodeBlock _compileExpression_1 = this.compileExpression(call.getArguments().get(1));
    _builder.append(_compileExpression_1);
    _builder.append("))");
    return CodeBlock.of(_builder.toString());
  }
  
  protected CodeBlock _compileExpression(final ErrorConditional call) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/*ERRORCONDITIONAL*/");
    return CodeBlock.of(_builder.toString());
  }
  
  protected CodeBlock _compileExpression(final ErrorBinding call) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/*ERRORBINDING*/");
    return CodeBlock.of(_builder.toString());
  }
  
  protected CodeBlock _compileExpression(final EEnumLiteral call) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/*EENUMLITERAL*/");
    return CodeBlock.of(_builder.toString());
  }
  
  protected CodeBlock _compileExpression(final ErrorExpression call) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/*ERROREXPRESSION*/");
    return CodeBlock.of(_builder.toString());
  }
  
  protected CodeBlock _compileExpression(final ErrorStringLiteral call) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/*ERRORSTRINGLITERAL*/");
    return CodeBlock.of(_builder.toString());
  }
  
  protected CodeBlock _compileExpression(final ErrorTypeLiteral call) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/*ERRORTYPELITERAL*/");
    return CodeBlock.of(_builder.toString());
  }
  
  protected CodeBlock _compileExpression(final ErrorVariableDeclaration call) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/*ERRORVARIABLEDECLARATION*/");
    return CodeBlock.of(_builder.toString());
  }
  
  protected CodeBlock _compileExpression(final Let call) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/*let*/");
    return CodeBlock.of(_builder.toString());
  }
  
  protected CodeBlock _compileExpression(final BooleanLiteral call) {
    String _xifexpression = null;
    boolean _isValue = call.isValue();
    if (_isValue) {
      _xifexpression = "true";
    } else {
      _xifexpression = "false";
    }
    return CodeBlock.of(_xifexpression);
  }
  
  protected CodeBlock _compileExpression(final EnumLiteral call) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/*ENUMLITERAL*/");
    return CodeBlock.of(_builder.toString());
  }
  
  protected CodeBlock _compileExpression(final IntegerLiteral call) {
    return CodeBlock.of(Integer.valueOf(call.getValue()).toString());
  }
  
  protected CodeBlock _compileExpression(final Lambda call) {
    CodeBlock _xblockexpression = null;
    {
      CodeBlock _compileExpression = this.compileExpression(call.getExpression());
      Pair<String, Object> _mappedTo = Pair.<String, Object>of("expr", _compileExpression);
      final Map<String, Object> hm = CollectionLiterals.<String, Object>newHashMap(_mappedTo);
      Iterable<Pair<org.eclipse.acceleo.query.ast.VariableDeclaration, Integer>> _enumerate = this.<org.eclipse.acceleo.query.ast.VariableDeclaration>enumerate(call.getParameters());
      for (final Pair<org.eclipse.acceleo.query.ast.VariableDeclaration, Integer> param : _enumerate) {
        Integer _value = param.getValue();
        String _plus = ("param" + _value);
        hm.put(_plus, param.getKey().getName());
      }
      CodeBlock.Builder _builder = CodeBlock.builder();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("(");
      {
        Iterable<Pair<org.eclipse.acceleo.query.ast.VariableDeclaration, Integer>> _enumerate_1 = this.<org.eclipse.acceleo.query.ast.VariableDeclaration>enumerate(call.getParameters());
        boolean _hasElements = false;
        for(final Pair<org.eclipse.acceleo.query.ast.VariableDeclaration, Integer> p : _enumerate_1) {
          if (!_hasElements) {
            _hasElements = true;
          } else {
            _builder_1.appendImmediate(", ", "");
          }
          _builder_1.append("$param");
          Integer _value_1 = p.getValue();
          _builder_1.append(_value_1);
          _builder_1.append(":L");
        }
      }
      _builder_1.append(") -> $expr:L");
      _xblockexpression = _builder.addNamed(_builder_1.toString(), hm).build();
    }
    return _xblockexpression;
  }
  
  protected CodeBlock _compileExpression(final NullLiteral call) {
    return CodeBlock.of("null");
  }
  
  protected CodeBlock _compileExpression(final RealLiteral call) {
    return CodeBlock.of(Double.valueOf(call.getValue()).toString());
  }
  
  protected CodeBlock _compileExpression(final SequenceInExtensionLiteral call) {
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
        CodeBlock _compileExpression = this.compileExpression(a);
        _builder.append(_compileExpression);
      }
    }
    _builder.append(")");
    return CodeBlock.of(_builder.toString(), ClassName.get("org.eclipse.emf.ecoretools.ale.compiler.lib", "CollectionService"));
  }
  
  protected CodeBlock _compileExpression(final SetInExtensionLiteral call) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/*SETINEXTENSIONLITERAL*/");
    return CodeBlock.of(_builder.toString());
  }
  
  protected CodeBlock _compileExpression(final StringLiteral call) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("\"");
    String _value = call.getValue();
    _builder.append(_value);
    _builder.append("\"");
    return CodeBlock.of(_builder.toString());
  }
  
  protected CodeBlock _compileExpression(final TypeLiteral call) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("$T");
    Object _value = call.getValue();
    return CodeBlock.of(_builder.toString(), this.solveType(((EClass) _value)));
  }
  
  protected CodeBlock _compileExpression(final Switch call) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/*SWITCH*/");
    return CodeBlock.of(_builder.toString());
  }
  
  protected CodeBlock _compileExpression(final VarRef call) {
    String _xifexpression = null;
    String _variableName = call.getVariableName();
    boolean _equals = Objects.equal(_variableName, "self");
    if (_equals) {
      _xifexpression = "this.it";
    } else {
      _xifexpression = call.getVariableName();
    }
    return CodeBlock.of(_xifexpression);
  }
  
  public String getEcoreInterfacesPackage() {
    String _xblockexpression = null;
    {
      final GenModel gm = this.syntaxes.get(IterableExtensions.<String>head(this.dsl.getAllSyntaxes())).getValue();
      _xblockexpression = IterableExtensions.<GenPackage>head(gm.getGenPackages()).getQualifiedPackageName();
    }
    return _xblockexpression;
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
  
  public Object solveType(final EClassifier type) {
    if (type instanceof EClass) {
      return _solveType((EClass)type);
    } else if (type instanceof EDataType) {
      return _solveType((EDataType)type);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(type).toString());
    }
  }
  
  public MethodSpec.Builder compileBody(final MethodSpec.Builder builderSeed, final Statement body) {
    if (body instanceof FeatureAssignment) {
      return _compileBody(builderSeed, (FeatureAssignment)body);
    } else if (body instanceof FeatureInsert) {
      return _compileBody(builderSeed, (FeatureInsert)body);
    } else if (body instanceof FeatureRemove) {
      return _compileBody(builderSeed, (FeatureRemove)body);
    } else if (body instanceof VariableAssignment) {
      return _compileBody(builderSeed, (VariableAssignment)body);
    } else if (body instanceof Block) {
      return _compileBody(builderSeed, (Block)body);
    } else if (body instanceof ConditionalBlock) {
      return _compileBody(builderSeed, (ConditionalBlock)body);
    } else if (body instanceof ExpressionStatement) {
      return _compileBody(builderSeed, (ExpressionStatement)body);
    } else if (body instanceof FeaturePut) {
      return _compileBody(builderSeed, (FeaturePut)body);
    } else if (body instanceof ForEach) {
      return _compileBody(builderSeed, (ForEach)body);
    } else if (body instanceof If) {
      return _compileBody(builderSeed, (If)body);
    } else if (body instanceof VariableDeclaration) {
      return _compileBody(builderSeed, (VariableDeclaration)body);
    } else if (body instanceof While) {
      return _compileBody(builderSeed, (While)body);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(builderSeed, body).toString());
    }
  }
  
  public CodeBlock compileExpression(final EObject call) {
    if (call instanceof ErrorStringLiteral) {
      return _compileExpression((ErrorStringLiteral)call);
    } else if (call instanceof ErrorTypeLiteral) {
      return _compileExpression((ErrorTypeLiteral)call);
    } else if (call instanceof And) {
      return _compileExpression((And)call);
    } else if (call instanceof BooleanLiteral) {
      return _compileExpression((BooleanLiteral)call);
    } else if (call instanceof EnumLiteral) {
      return _compileExpression((EnumLiteral)call);
    } else if (call instanceof ErrorBinding) {
      return _compileExpression((ErrorBinding)call);
    } else if (call instanceof ErrorCall) {
      return _compileExpression((ErrorCall)call);
    } else if (call instanceof ErrorConditional) {
      return _compileExpression((ErrorConditional)call);
    } else if (call instanceof ErrorExpression) {
      return _compileExpression((ErrorExpression)call);
    } else if (call instanceof ErrorVariableDeclaration) {
      return _compileExpression((ErrorVariableDeclaration)call);
    } else if (call instanceof Implies) {
      return _compileExpression((Implies)call);
    } else if (call instanceof IntegerLiteral) {
      return _compileExpression((IntegerLiteral)call);
    } else if (call instanceof Lambda) {
      return _compileExpression((Lambda)call);
    } else if (call instanceof NullLiteral) {
      return _compileExpression((NullLiteral)call);
    } else if (call instanceof Or) {
      return _compileExpression((Or)call);
    } else if (call instanceof RealLiteral) {
      return _compileExpression((RealLiteral)call);
    } else if (call instanceof SequenceInExtensionLiteral) {
      return _compileExpression((SequenceInExtensionLiteral)call);
    } else if (call instanceof SetInExtensionLiteral) {
      return _compileExpression((SetInExtensionLiteral)call);
    } else if (call instanceof StringLiteral) {
      return _compileExpression((StringLiteral)call);
    } else if (call instanceof TypeLiteral) {
      return _compileExpression((TypeLiteral)call);
    } else if (call instanceof EEnumLiteral) {
      return _compileExpression((EEnumLiteral)call);
    } else if (call instanceof Call) {
      return _compileExpression((Call)call);
    } else if (call instanceof Let) {
      return _compileExpression((Let)call);
    } else if (call instanceof VarRef) {
      return _compileExpression((VarRef)call);
    } else if (call instanceof Switch) {
      return _compileExpression((Switch)call);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(call).toString());
    }
  }
}
