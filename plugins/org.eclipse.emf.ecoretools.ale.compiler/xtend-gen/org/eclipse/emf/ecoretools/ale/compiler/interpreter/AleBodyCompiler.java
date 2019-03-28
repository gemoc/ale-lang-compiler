package org.eclipse.emf.ecoretools.ale.compiler.interpreter;

import com.google.common.base.Objects;
import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.CodeBlock;
import com.squareup.javapoet.ParameterizedTypeName;
import com.squareup.javapoet.TypeName;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.eclipse.acceleo.query.validation.type.IType;
import org.eclipse.acceleo.query.validation.type.SequenceType;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecoretools.ale.compiler.interpreter.ALEInterpreterImplementationCompiler;
import org.eclipse.emf.ecoretools.ale.compiler.interpreter.AleExpressionsCompiler;
import org.eclipse.emf.ecoretools.ale.compiler.interpreter.EClassImplementationCompiler;
import org.eclipse.emf.ecoretools.ale.compiler.interpreter.TypeSystemUtils;
import org.eclipse.emf.ecoretools.ale.core.validation.BaseValidator;
import org.eclipse.emf.ecoretools.ale.implementation.Block;
import org.eclipse.emf.ecoretools.ale.implementation.ConditionalBlock;
import org.eclipse.emf.ecoretools.ale.implementation.ExpressionStatement;
import org.eclipse.emf.ecoretools.ale.implementation.FeatureAssignment;
import org.eclipse.emf.ecoretools.ale.implementation.FeatureInsert;
import org.eclipse.emf.ecoretools.ale.implementation.FeaturePut;
import org.eclipse.emf.ecoretools.ale.implementation.FeatureRemove;
import org.eclipse.emf.ecoretools.ale.implementation.ForEach;
import org.eclipse.emf.ecoretools.ale.implementation.If;
import org.eclipse.emf.ecoretools.ale.implementation.Method;
import org.eclipse.emf.ecoretools.ale.implementation.Statement;
import org.eclipse.emf.ecoretools.ale.implementation.VariableAssignment;
import org.eclipse.emf.ecoretools.ale.implementation.VariableDeclaration;
import org.eclipse.emf.ecoretools.ale.implementation.While;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class AleBodyCompiler {
  @Extension
  private TypeSystemUtils tsu;
  
  @Extension
  private AleExpressionsCompiler aec;
  
  public AleBodyCompiler(final Map<String, Pair<EPackage, GenModel>> syntaxes, final String packageRoot, final BaseValidator base, final List<ALEInterpreterImplementationCompiler.ResolvedClass> resolved, final Set<Method> registreredDispatch, final Set<String> registeredArray, final Map<String, Class<?>> registeredServices, final boolean isTruffle) {
    TypeSystemUtils _typeSystemUtils = new TypeSystemUtils(syntaxes, packageRoot, base, resolved);
    this.tsu = _typeSystemUtils;
    AleExpressionsCompiler _aleExpressionsCompiler = new AleExpressionsCompiler(syntaxes, packageRoot, base, resolved, registreredDispatch, registeredArray, registeredServices, isTruffle);
    this.aec = _aleExpressionsCompiler;
  }
  
  protected CodeBlock.Builder _compileBody(final CodeBlock.Builder builderSeed, final FeatureAssignment body, final EClassImplementationCompiler.CompilerExpressionCtx ctx) {
    CodeBlock.Builder _xblockexpression = null;
    {
      final IType t = IterableExtensions.<IType>head(this.tsu.infereType(body.getTarget()));
      final CodeBlock lhs = this.aec.compileExpression(body.getTarget(), ctx);
      CodeBlock.Builder _xifexpression = null;
      boolean _equals = Objects.equal(lhs, "this");
      if (_equals) {
        CodeBlock.Builder _xifexpression_1 = null;
        if (((t instanceof SequenceType) && (((SequenceType) t).getCollectionType().getType() instanceof EClass))) {
          StringConcatenation _builder = new StringConcatenation();
          _builder.append(lhs);
          _builder.append(".");
          String _targetFeature = body.getTargetFeature();
          _builder.append(_targetFeature);
          _builder.append(".add(");
          CodeBlock _compileExpression = this.aec.compileExpression(body.getValue(), ctx);
          _builder.append(_compileExpression);
          _builder.append(")");
          _xifexpression_1 = builderSeed.addStatement(_builder.toString());
        } else {
          CodeBlock.Builder _xifexpression_2 = null;
          if (((t.getType() instanceof EClass) || (t.getType() instanceof EDataType))) {
            StringConcatenation _builder_1 = new StringConcatenation();
            _builder_1.append(lhs);
            _builder_1.append(".set");
            String _firstUpper = StringExtensions.toFirstUpper(body.getTargetFeature());
            _builder_1.append(_firstUpper);
            _builder_1.append("(");
            CodeBlock _compileExpression_1 = this.aec.compileExpression(body.getValue(), ctx);
            _builder_1.append(_compileExpression_1);
            _builder_1.append(")");
            _xifexpression_2 = builderSeed.addStatement(_builder_1.toString());
          } else {
            StringConcatenation _builder_2 = new StringConcatenation();
            _builder_2.append(lhs);
            _builder_2.append(".");
            String _targetFeature_1 = body.getTargetFeature();
            _builder_2.append(_targetFeature_1);
            _builder_2.append(" = ");
            CodeBlock _compileExpression_2 = this.aec.compileExpression(body.getValue(), ctx);
            _builder_2.append(_compileExpression_2);
            _xifexpression_2 = builderSeed.addStatement(_builder_2.toString());
          }
          _xifexpression_1 = _xifexpression_2;
        }
        _xifexpression = _xifexpression_1;
      } else {
        CodeBlock.Builder _xifexpression_3 = null;
        if (((t instanceof SequenceType) && (((SequenceType) t).getCollectionType().getType() instanceof EClass))) {
          StringConcatenation _builder_3 = new StringConcatenation();
          _builder_3.append(lhs);
          _builder_3.append(".get");
          String _firstUpper_1 = StringExtensions.toFirstUpper(body.getTargetFeature());
          _builder_3.append(_firstUpper_1);
          _builder_3.append("().add(");
          CodeBlock _compileExpression_3 = this.aec.compileExpression(body.getValue(), ctx);
          _builder_3.append(_compileExpression_3);
          _builder_3.append(")");
          _xifexpression_3 = builderSeed.addStatement(_builder_3.toString());
        } else {
          CodeBlock.Builder _xifexpression_4 = null;
          if (((t.getType() instanceof EClass) || (t.getType() instanceof EDataType))) {
            StringConcatenation _builder_4 = new StringConcatenation();
            _builder_4.append(lhs);
            _builder_4.append(".set");
            String _firstUpper_2 = StringExtensions.toFirstUpper(body.getTargetFeature());
            _builder_4.append(_firstUpper_2);
            _builder_4.append("(");
            CodeBlock _compileExpression_4 = this.aec.compileExpression(body.getValue(), ctx);
            _builder_4.append(_compileExpression_4);
            _builder_4.append(")");
            _xifexpression_4 = builderSeed.addStatement(_builder_4.toString());
          } else {
            StringConcatenation _builder_5 = new StringConcatenation();
            _builder_5.append(lhs);
            _builder_5.append(".");
            String _targetFeature_2 = body.getTargetFeature();
            _builder_5.append(_targetFeature_2);
            _builder_5.append(" = ");
            CodeBlock _compileExpression_5 = this.aec.compileExpression(body.getValue(), ctx);
            _builder_5.append(_compileExpression_5);
            _xifexpression_4 = builderSeed.addStatement(_builder_5.toString());
          }
          _xifexpression_3 = _xifexpression_4;
        }
        _xifexpression = _xifexpression_3;
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  protected CodeBlock.Builder _compileBody(final CodeBlock.Builder builderSeed, final FeatureInsert body, final EClassImplementationCompiler.CompilerExpressionCtx ctx) {
    CodeBlock.Builder _xblockexpression = null;
    {
      final CodeBlock lhs = this.aec.compileExpression(body.getTarget(), ctx);
      CodeBlock.Builder _xifexpression = null;
      boolean _equals = Objects.equal(lhs, "this");
      if (_equals) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append(lhs);
        _builder.append(".");
        String _targetFeature = body.getTargetFeature();
        _builder.append(_targetFeature);
        _builder.append(".add(");
        CodeBlock _compileExpression = this.aec.compileExpression(body.getValue(), ctx);
        _builder.append(_compileExpression);
        _builder.append(")");
        _xifexpression = builderSeed.addStatement(_builder.toString());
      } else {
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append(lhs);
        _builder_1.append(".get");
        String _firstUpper = StringExtensions.toFirstUpper(body.getTargetFeature());
        _builder_1.append(_firstUpper);
        _builder_1.append("().add(");
        CodeBlock _compileExpression_1 = this.aec.compileExpression(body.getValue(), ctx);
        _builder_1.append(_compileExpression_1);
        _builder_1.append(")");
        _xifexpression = builderSeed.addStatement(_builder_1.toString());
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  protected CodeBlock.Builder _compileBody(final CodeBlock.Builder builderSeed, final FeatureRemove body, final EClassImplementationCompiler.CompilerExpressionCtx ctx) {
    CodeBlock.Builder _xblockexpression = null;
    {
      final CodeBlock lhs = this.aec.compileExpression(body.getTarget(), ctx);
      CodeBlock.Builder _xifexpression = null;
      boolean _equals = Objects.equal(lhs, "this");
      if (_equals) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append(lhs);
        _builder.append(".");
        String _targetFeature = body.getTargetFeature();
        _builder.append(_targetFeature);
        _builder.append(".remove(");
        CodeBlock _compileExpression = this.aec.compileExpression(body.getValue(), ctx);
        _builder.append(_compileExpression);
        _builder.append(")");
        _xifexpression = builderSeed.addStatement(_builder.toString());
      } else {
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append(lhs);
        _builder_1.append(".get");
        String _firstUpper = StringExtensions.toFirstUpper(body.getTargetFeature());
        _builder_1.append(_firstUpper);
        _builder_1.append("().remove(");
        CodeBlock _compileExpression_1 = this.aec.compileExpression(body.getValue(), ctx);
        _builder_1.append(_compileExpression_1);
        _builder_1.append(")");
        _xifexpression = builderSeed.addStatement(_builder_1.toString());
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  protected CodeBlock.Builder _compileBody(final CodeBlock.Builder builderSeed, final VariableAssignment body, final EClassImplementationCompiler.CompilerExpressionCtx ctx) {
    CodeBlock.Builder _builder = CodeBlock.builder();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("$name:N = $expr:L");
    String _name = body.getName();
    Pair<String, String> _mappedTo = Pair.<String, String>of("name", _name);
    CodeBlock _compileExpression = this.aec.compileExpression(body.getValue(), ctx);
    Pair<String, CodeBlock> _mappedTo_1 = Pair.<String, CodeBlock>of("expr", _compileExpression);
    return builderSeed.addStatement(
      _builder.addNamed(_builder_1.toString(), CollectionLiterals.<String, Object>newHashMap(_mappedTo, _mappedTo_1)).build());
  }
  
  protected CodeBlock.Builder _compileBody(final CodeBlock.Builder builderSeed, final VariableDeclaration body, final EClassImplementationCompiler.CompilerExpressionCtx ctx) {
    CodeBlock.Builder _xblockexpression = null;
    {
      final IType inft = IterableExtensions.<IType>head(this.tsu.infereType(body.getInitialValue()));
      CodeBlock.Builder _xifexpression = null;
      if ((inft instanceof SequenceType)) {
        CodeBlock.Builder _xblockexpression_1 = null;
        {
          final Object ict = ((SequenceType)inft).getCollectionType().getType();
          ParameterizedTypeName _xifexpression_1 = null;
          if ((ict instanceof EClass)) {
            _xifexpression_1 = ParameterizedTypeName.get(ClassName.get("org.eclipse.emf.common.util", "EList"), this.tsu.resolveType(((EClassifier)ict)));
          } else {
            Object _type = ((SequenceType)inft).getCollectionType().getType();
            _xifexpression_1 = ParameterizedTypeName.get(ClassName.get("org.eclipse.emf.common.util", "EList"), 
              ClassName.get(((Class<?>) _type)));
          }
          final ParameterizedTypeName t = _xifexpression_1;
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("$T $L = (($T) ($L))");
          _xblockexpression_1 = builderSeed.addStatement(_builder.toString(), t, body.getName(), t, this.aec.compileExpression(body.getInitialValue(), ctx));
        }
        _xifexpression = _xblockexpression_1;
      } else {
        CodeBlock.Builder _xblockexpression_2 = null;
        {
          final Object t = this.tsu.solveType(body.getType());
          CodeBlock.Builder _builder = CodeBlock.builder();
          StringConcatenation _builder_1 = new StringConcatenation();
          _builder_1.append("$t:T $name:N = (($t:T) ($expr:L))");
          Pair<String, Object> _mappedTo = Pair.<String, Object>of("t", t);
          String _name = body.getName();
          Pair<String, String> _mappedTo_1 = Pair.<String, String>of("name", _name);
          CodeBlock _compileExpression = this.aec.compileExpression(body.getInitialValue(), ctx);
          Pair<String, CodeBlock> _mappedTo_2 = Pair.<String, CodeBlock>of("expr", _compileExpression);
          final CodeBlock.Builder cbb = _builder.addNamed(_builder_1.toString(), CollectionLiterals.<String, Object>newHashMap(_mappedTo, _mappedTo_1, _mappedTo_2));
          final CodeBlock cb = cbb.build();
          _xblockexpression_2 = builderSeed.addStatement(cb);
        }
        _xifexpression = _xblockexpression_2;
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  protected CodeBlock.Builder _compileBody(final CodeBlock.Builder builderSeed, final Block body, final EClassImplementationCompiler.CompilerExpressionCtx ctx) {
    final Function2<CodeBlock.Builder, Statement, CodeBlock.Builder> _function = (CodeBlock.Builder builder, Statement statement) -> {
      return this.compileBody(builder, statement, ctx);
    };
    return IterableExtensions.<Statement, CodeBlock.Builder>fold(body.getStatements(), builderSeed, _function);
  }
  
  protected CodeBlock.Builder _compileBody(final CodeBlock.Builder builderSeed, final ExpressionStatement body, final EClassImplementationCompiler.CompilerExpressionCtx ctx) {
    return builderSeed.addStatement(this.aec.compileExpression(body.getExpression(), ctx));
  }
  
  protected CodeBlock.Builder _compileBody(final CodeBlock.Builder builderSeed, final FeaturePut body, final EClassImplementationCompiler.CompilerExpressionCtx ctx) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("throw new $T(\"FeaturePut not implemented\")");
    return builderSeed.addStatement(_builder.toString(), RuntimeException.class);
  }
  
  protected CodeBlock.Builder _compileBody(final CodeBlock.Builder builderSeed, final ForEach body, final EClassImplementationCompiler.CompilerExpressionCtx ctx) {
    CodeBlock.Builder _xblockexpression = null;
    {
      IType _head = IterableExtensions.<IType>head(this.tsu.infereType(body.getCollectionExpression()));
      final SequenceType lt = ((SequenceType) _head);
      CodeBlock.Builder _xifexpression = null;
      Object _type = lt.getCollectionType().getType();
      if ((_type instanceof EClass)) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("for ($T $L : ");
        CodeBlock _compileExpression = this.aec.compileExpression(body.getCollectionExpression(), ctx);
        _builder.append(_compileExpression);
        _builder.append(")");
        Object _type_1 = lt.getCollectionType().getType();
        _xifexpression = this.compileBody(builderSeed.beginControlFlow(_builder.toString(), 
          this.tsu.solveType(((EClass) _type_1)), body.getVariable()), body.getBody(), ctx).endControlFlow();
      } else {
        CodeBlock.Builder _xblockexpression_1 = null;
        {
          final TypeName iteratorType = this.tsu.resolveType2(lt.getCollectionType().getType());
          final String iteratorVariable = body.getVariable();
          final CodeBlock iterable = this.aec.compileExpression(body.getCollectionExpression(), ctx);
          StringConcatenation _builder_1 = new StringConcatenation();
          _builder_1.append("for ($T $L: $L)");
          _xblockexpression_1 = this.compileBody(builderSeed.beginControlFlow(_builder_1.toString(), iteratorType, iteratorVariable, iterable), body.getBody(), ctx).endControlFlow();
        }
        _xifexpression = _xblockexpression_1;
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  protected CodeBlock.Builder _compileBody(final CodeBlock.Builder builderSeed, final If body, final EClassImplementationCompiler.CompilerExpressionCtx ctx) {
    CodeBlock.Builder _xblockexpression = null;
    {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("if ($L)");
      CodeBlock.Builder ret = this.compileBody(builderSeed.beginControlFlow(_builder.toString(), this.aec.compileExpression(IterableExtensions.<ConditionalBlock>head(body.getBlocks()).getCondition(), ctx)), IterableExtensions.<ConditionalBlock>head(body.getBlocks()).getBlock(), ctx).endControlFlow();
      Iterable<ConditionalBlock> _tail = IterableExtensions.<ConditionalBlock>tail(body.getBlocks());
      for (final ConditionalBlock x : _tail) {
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("else if ($L");
        ret = this.compileBody(ret.beginControlFlow(_builder_1.toString(), this.aec.compileExpression(x.getCondition(), ctx)), x.getBlock(), ctx).endControlFlow();
      }
      Block _else = body.getElse();
      boolean _tripleNotEquals = (_else != null);
      if (_tripleNotEquals) {
        ret = this.compileBody(ret.beginControlFlow("else"), body.getElse(), ctx).endControlFlow();
      }
      _xblockexpression = ret;
    }
    return _xblockexpression;
  }
  
  protected CodeBlock.Builder _compileBody(final CodeBlock.Builder builderSeed, final ConditionalBlock body, final EClassImplementationCompiler.CompilerExpressionCtx ctx) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("throw new $T(\"ConditionalBlock not implemented\")");
    return builderSeed.addStatement(_builder.toString(), RuntimeException.class);
  }
  
  protected CodeBlock.Builder _compileBody(final CodeBlock.Builder builderSeed, final While body, final EClassImplementationCompiler.CompilerExpressionCtx ctx) {
    return this.compileBody(builderSeed.beginControlFlow("while ($L)", this.aec.compileExpression(body.getCondition(), ctx)), body.getBody(), ctx).endControlFlow();
  }
  
  public String escapeDollar(final String s) {
    return s.replaceAll("\\$\\(", "\\$\\$(");
  }
  
  public CodeBlock.Builder compileBody(final CodeBlock.Builder builderSeed, final Statement body, final EClassImplementationCompiler.CompilerExpressionCtx ctx) {
    if (body instanceof FeatureAssignment) {
      return _compileBody(builderSeed, (FeatureAssignment)body, ctx);
    } else if (body instanceof FeatureInsert) {
      return _compileBody(builderSeed, (FeatureInsert)body, ctx);
    } else if (body instanceof FeatureRemove) {
      return _compileBody(builderSeed, (FeatureRemove)body, ctx);
    } else if (body instanceof VariableAssignment) {
      return _compileBody(builderSeed, (VariableAssignment)body, ctx);
    } else if (body instanceof Block) {
      return _compileBody(builderSeed, (Block)body, ctx);
    } else if (body instanceof ConditionalBlock) {
      return _compileBody(builderSeed, (ConditionalBlock)body, ctx);
    } else if (body instanceof ExpressionStatement) {
      return _compileBody(builderSeed, (ExpressionStatement)body, ctx);
    } else if (body instanceof FeaturePut) {
      return _compileBody(builderSeed, (FeaturePut)body, ctx);
    } else if (body instanceof ForEach) {
      return _compileBody(builderSeed, (ForEach)body, ctx);
    } else if (body instanceof If) {
      return _compileBody(builderSeed, (If)body, ctx);
    } else if (body instanceof VariableDeclaration) {
      return _compileBody(builderSeed, (VariableDeclaration)body, ctx);
    } else if (body instanceof While) {
      return _compileBody(builderSeed, (While)body, ctx);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(builderSeed, body, ctx).toString());
    }
  }
}
