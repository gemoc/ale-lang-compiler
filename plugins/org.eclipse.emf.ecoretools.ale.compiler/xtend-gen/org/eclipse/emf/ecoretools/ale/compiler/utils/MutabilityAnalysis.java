package org.eclipse.emf.ecoretools.ale.compiler.utils;

import com.google.common.collect.Iterables;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import org.eclipse.acceleo.query.ast.Call;
import org.eclipse.acceleo.query.ast.Expression;
import org.eclipse.acceleo.query.validation.type.IType;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecoretools.ale.core.validation.BaseValidator;
import org.eclipse.emf.ecoretools.ale.implementation.Attribute;
import org.eclipse.emf.ecoretools.ale.implementation.BehavioredClass;
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
import org.eclipse.emf.ecoretools.ale.implementation.RuntimeClass;
import org.eclipse.emf.ecoretools.ale.implementation.Statement;
import org.eclipse.emf.ecoretools.ale.implementation.VariableAssignment;
import org.eclipse.emf.ecoretools.ale.implementation.VariableDeclaration;
import org.eclipse.emf.ecoretools.ale.implementation.While;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;

/**
 * Mark every field mutated potentialy mutated during the language execution to mutable.
 * Based on closed world hypothesis.
 */
@SuppressWarnings("all")
public class MutabilityAnalysis {
  /**
   * @param behavior: the language to analyze
   * @param baseValidator: the resolved types for the language
   */
  public List<Attribute> analyse(final ModelUnit unit, final BaseValidator baseValidator) {
    List<Attribute> _xblockexpression = null;
    {
      final Function1<ExtendedClass, EList<Attribute>> _function = (ExtendedClass it) -> {
        return it.getAttributes();
      };
      final Iterable<Attribute> weavedAttributes = Iterables.<Attribute>concat(ListExtensions.<ExtendedClass, EList<Attribute>>map(unit.getClassExtensions(), _function));
      final Function1<ExtendedClass, EList<EAttribute>> _function_1 = (ExtendedClass it) -> {
        return it.getBaseClass().getEAttributes();
      };
      final Iterable<EAttribute> metamodelAttributes = Iterables.<EAttribute>concat(ListExtensions.<ExtendedClass, EList<EAttribute>>map(unit.getClassExtensions(), _function_1));
      final Iterable<EModelElement> allAttributes = Iterables.<EModelElement>concat(weavedAttributes, metamodelAttributes);
      EList<RuntimeClass> _classDefinitions = unit.getClassDefinitions();
      EList<ExtendedClass> _classExtensions = unit.getClassExtensions();
      final Iterable<BehavioredClass> cds = Iterables.<BehavioredClass>concat(_classDefinitions, _classExtensions);
      final Function1<BehavioredClass, List<List<List<Attribute>>>> _function_2 = (BehavioredClass it) -> {
        final Function1<Method, List<List<Attribute>>> _function_3 = (Method it_1) -> {
          final Function1<Statement, List<Attribute>> _function_4 = (Statement it_2) -> {
            List<Attribute> _xblockexpression_1 = null;
            {
              InputOutput.<String>println("STMT");
              _xblockexpression_1 = this.mutatedAttributes(it_2, baseValidator);
            }
            return _xblockexpression_1;
          };
          return ListExtensions.<Statement, List<Attribute>>map(it_1.getBody().getStatements(), _function_4);
        };
        return ListExtensions.<Method, List<List<Attribute>>>map(it.getMethods(), _function_3);
      };
      final Set<Attribute> ret = IterableExtensions.<Attribute>toSet(Iterables.<Attribute>concat(Iterables.<List<Attribute>>concat(Iterables.<List<List<Attribute>>>concat(IterableExtensions.<BehavioredClass, List<List<List<Attribute>>>>map(cds, _function_2)))));
      _xblockexpression = IterableExtensions.<Attribute>toList(ret);
    }
    return _xblockexpression;
  }
  
  protected List<Attribute> _mutatedAttributes(final FeatureAssignment s, final BaseValidator baseValidator) {
    List<Attribute> _xblockexpression = null;
    {
      InputOutput.<Set<IType>>println(baseValidator.getPossibleTypes(s.getTarget()));
      InputOutput.<Set<IType>>println(baseValidator.getPossibleTypes(s.getValue()));
      Expression _target = s.getTarget();
      String _plus = (_target + ".");
      String _targetFeature = s.getTargetFeature();
      String _plus_1 = (_plus + _targetFeature);
      InputOutput.<String>println(_plus_1);
      _xblockexpression = Collections.<Attribute>unmodifiableList(CollectionLiterals.<Attribute>newArrayList());
    }
    return _xblockexpression;
  }
  
  protected List<Attribute> _mutatedAttributes(final FeatureInsert s, final BaseValidator baseValidator) {
    List<Attribute> _xblockexpression = null;
    {
      InputOutput.<Set<IType>>println(baseValidator.getPossibleTypes(s.getTarget()));
      InputOutput.<Set<IType>>println(baseValidator.getPossibleTypes(s.getValue()));
      Expression _target = s.getTarget();
      String _plus = (_target + ".");
      String _targetFeature = s.getTargetFeature();
      String _plus_1 = (_plus + _targetFeature);
      InputOutput.<String>println(_plus_1);
      _xblockexpression = Collections.<Attribute>unmodifiableList(CollectionLiterals.<Attribute>newArrayList());
    }
    return _xblockexpression;
  }
  
  protected List<Attribute> _mutatedAttributes(final FeatureRemove s, final BaseValidator baseValidator) {
    List<Attribute> _xblockexpression = null;
    {
      InputOutput.<FeatureRemove>println(s);
      _xblockexpression = Collections.<Attribute>unmodifiableList(CollectionLiterals.<Attribute>newArrayList());
    }
    return _xblockexpression;
  }
  
  protected List<Attribute> _mutatedAttributes(final VariableAssignment s, final BaseValidator baseValidator) {
    List<Attribute> _xblockexpression = null;
    {
      InputOutput.<VariableAssignment>println(s);
      _xblockexpression = Collections.<Attribute>unmodifiableList(CollectionLiterals.<Attribute>newArrayList());
    }
    return _xblockexpression;
  }
  
  protected List<Attribute> _mutatedAttributes(final Block s, final BaseValidator baseValidator) {
    List<Attribute> _xblockexpression = null;
    {
      InputOutput.<Block>println(s);
      _xblockexpression = Collections.<Attribute>unmodifiableList(CollectionLiterals.<Attribute>newArrayList());
    }
    return _xblockexpression;
  }
  
  protected List<Attribute> _mutatedAttributes(final ConditionalBlock s, final BaseValidator baseValidator) {
    List<Attribute> _xblockexpression = null;
    {
      InputOutput.<ConditionalBlock>println(s);
      _xblockexpression = Collections.<Attribute>unmodifiableList(CollectionLiterals.<Attribute>newArrayList());
    }
    return _xblockexpression;
  }
  
  protected List<Attribute> _mutatedAttributes(final ExpressionStatement s, final BaseValidator baseValidator) {
    List<Attribute> _xblockexpression = null;
    {
      Expression _expression = s.getExpression();
      InputOutput.<Set<IType>>println(baseValidator.getPossibleTypes(IterableExtensions.<Expression>head(((Call) _expression).getArguments())));
      InputOutput.<ExpressionStatement>println(s);
      _xblockexpression = Collections.<Attribute>unmodifiableList(CollectionLiterals.<Attribute>newArrayList());
    }
    return _xblockexpression;
  }
  
  protected List<Attribute> _mutatedAttributes(final FeaturePut s, final BaseValidator baseValidator) {
    List<Attribute> _xblockexpression = null;
    {
      InputOutput.<FeaturePut>println(s);
      _xblockexpression = Collections.<Attribute>unmodifiableList(CollectionLiterals.<Attribute>newArrayList());
    }
    return _xblockexpression;
  }
  
  protected List<Attribute> _mutatedAttributes(final ForEach s, final BaseValidator baseValidator) {
    List<Attribute> _xblockexpression = null;
    {
      InputOutput.<ForEach>println(s);
      _xblockexpression = Collections.<Attribute>unmodifiableList(CollectionLiterals.<Attribute>newArrayList());
    }
    return _xblockexpression;
  }
  
  protected List<Attribute> _mutatedAttributes(final If s, final BaseValidator baseValidator) {
    List<Attribute> _xblockexpression = null;
    {
      InputOutput.<If>println(s);
      _xblockexpression = Collections.<Attribute>unmodifiableList(CollectionLiterals.<Attribute>newArrayList());
    }
    return _xblockexpression;
  }
  
  protected List<Attribute> _mutatedAttributes(final VariableDeclaration s, final BaseValidator baseValidator) {
    List<Attribute> _xblockexpression = null;
    {
      InputOutput.<VariableDeclaration>println(s);
      _xblockexpression = Collections.<Attribute>unmodifiableList(CollectionLiterals.<Attribute>newArrayList());
    }
    return _xblockexpression;
  }
  
  protected List<Attribute> _mutatedAttributes(final While s, final BaseValidator baseValidator) {
    List<Attribute> _xblockexpression = null;
    {
      InputOutput.<While>println(s);
      _xblockexpression = Collections.<Attribute>unmodifiableList(CollectionLiterals.<Attribute>newArrayList());
    }
    return _xblockexpression;
  }
  
  public List<Attribute> mutatedAttributes(final Statement s, final BaseValidator baseValidator) {
    if (s instanceof FeatureAssignment) {
      return _mutatedAttributes((FeatureAssignment)s, baseValidator);
    } else if (s instanceof FeatureInsert) {
      return _mutatedAttributes((FeatureInsert)s, baseValidator);
    } else if (s instanceof FeatureRemove) {
      return _mutatedAttributes((FeatureRemove)s, baseValidator);
    } else if (s instanceof VariableAssignment) {
      return _mutatedAttributes((VariableAssignment)s, baseValidator);
    } else if (s instanceof Block) {
      return _mutatedAttributes((Block)s, baseValidator);
    } else if (s instanceof ConditionalBlock) {
      return _mutatedAttributes((ConditionalBlock)s, baseValidator);
    } else if (s instanceof ExpressionStatement) {
      return _mutatedAttributes((ExpressionStatement)s, baseValidator);
    } else if (s instanceof FeaturePut) {
      return _mutatedAttributes((FeaturePut)s, baseValidator);
    } else if (s instanceof ForEach) {
      return _mutatedAttributes((ForEach)s, baseValidator);
    } else if (s instanceof If) {
      return _mutatedAttributes((If)s, baseValidator);
    } else if (s instanceof VariableDeclaration) {
      return _mutatedAttributes((VariableDeclaration)s, baseValidator);
    } else if (s instanceof While) {
      return _mutatedAttributes((While)s, baseValidator);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(s, baseValidator).toString());
    }
  }
}
