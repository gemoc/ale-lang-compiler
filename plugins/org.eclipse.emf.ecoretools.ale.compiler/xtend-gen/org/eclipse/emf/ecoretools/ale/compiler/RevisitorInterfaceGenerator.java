package org.eclipse.emf.ecoretools.ale.compiler;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import java.util.List;
import java.util.Map;
import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecoretools.ale.compiler.EcoreUtils;
import org.eclipse.emf.ecoretools.ale.compiler.revisitor.RevisitorNamingUtils;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.StringExtensions;

/**
 * TODO: Migrate to Javapoet!
 */
@SuppressWarnings("all")
public class RevisitorInterfaceGenerator {
  @Extension
  private RevisitorNamingUtils _revisitorNamingUtils = new RevisitorNamingUtils();
  
  @Extension
  private EcoreUtils _ecoreUtils = new EcoreUtils();
  
  public List<EClass> allClassesCompl(final EPackage pkg) {
    List<EClass> _allClasses = this._ecoreUtils.getAllClasses(pkg);
    final Function1<Map.Entry<String, String>, List<EClass>> _function = (Map.Entry<String, String> z) -> {
      return this._ecoreUtils.getAllClasses(this._ecoreUtils.loadEPackage(z.getKey()));
    };
    Iterable<EClass> _complementaryFromEPackage = this._ecoreUtils.<EClass>getComplementaryFromEPackage(pkg, _function);
    final Function1<EClass, String> _function_1 = (EClass it) -> {
      StringConcatenation _builder = new StringConcatenation();
      String _name = it.getEPackage().getName();
      _builder.append(_name);
      _builder.append(".");
      String _name_1 = it.getName();
      _builder.append(_name_1);
      return _builder.toString();
    };
    final Function1<EClass, EClass> _function_2 = (EClass it) -> {
      return it;
    };
    return this._ecoreUtils.sortByName(IterableExtensions.<EClass, String, EClass>toMap(Iterables.<EClass>concat(_allClasses, _complementaryFromEPackage), _function_1, _function_2).values());
  }
  
  public String generateInterface(final EPackage pkg, final GenModel gm, final GenPackage gp) {
    this._ecoreUtils.resetResourceSet();
    final Function1<Map.Entry<String, String>, List<EClassifier>> _function = (Map.Entry<String, String> z) -> {
      return this._ecoreUtils.loadEPackage(z.getKey()).getEClassifiers();
    };
    final Iterable<EClassifier> complementaryClassifiers = this._ecoreUtils.<EClassifier>getComplementaryFromEPackage(pkg, _function);
    EList<EClassifier> _eClassifiers = pkg.getEClassifiers();
    final Iterable<EClassifier> classifiers = Iterables.<EClassifier>concat(_eClassifiers, complementaryClassifiers);
    final Iterable<EClass> eclasses = Iterables.<EClass>filter(classifiers, EClass.class);
    final Function1<EClass, String> _function_1 = (EClass it) -> {
      return it.getName();
    };
    final Function1<EClass, Boolean> _function_2 = (EClass it) -> {
      String _instanceClassName = it.getInstanceClassName();
      return Boolean.valueOf((!Objects.equal(_instanceClassName, "java.util.Map$Entry")));
    };
    final List<Pair<EClass, EClass>> localClasses = this._ecoreUtils.buildExtendedFactoryNames(IterableExtensions.<EClass>toList(IterableExtensions.<EClass>filter(IterableExtensions.<EClass, String>sortBy(eclasses, _function_1), _function_2)));
    final Function1<EClass, Boolean> _function_3 = (EClass it) -> {
      String _instanceClassName = it.getInstanceClassName();
      return Boolean.valueOf((!Objects.equal(_instanceClassName, "java.util.Map$Entry")));
    };
    final List<Pair<EClass, EClass>> allClasses = this._ecoreUtils.buildExtendedFactoryNames(IterableExtensions.<EClass>toList(IterableExtensions.<EClass>filter(this.allClassesCompl(pkg), _function_3)));
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package ");
    String _revisitorPackageFqn = this._revisitorNamingUtils.getRevisitorPackageFqn(gp);
    _builder.append(_revisitorPackageFqn);
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("public interface ");
    String _revisitorInterfaceName = this._revisitorNamingUtils.getRevisitorInterfaceName(gp);
    _builder.append(_revisitorInterfaceName);
    String _typeParams = this.getTypeParams(allClasses, true);
    _builder.append(_typeParams);
    {
      List<EPackage> _directReferencedPkgs = this._ecoreUtils.getDirectReferencedPkgs(pkg);
      boolean _hasElements = false;
      for(final EPackage ref : _directReferencedPkgs) {
        if (!_hasElements) {
          _hasElements = true;
          _builder.append("\n\textends ");
        } else {
          _builder.appendImmediate(",\n\t\t", "");
        }
        String _revisitorInterfaceFqn = this._revisitorNamingUtils.getRevisitorInterfaceFqn(gp);
        _builder.append(_revisitorInterfaceFqn);
        String _typeParams_1 = this.getTypeParams(this._ecoreUtils.buildExtendedFactoryNames(this.allClassesCompl(ref)), false);
        _builder.append(_typeParams_1);
      }
    }
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    {
      final Function1<Pair<EClass, EClass>, Boolean> _function_4 = (Pair<EClass, EClass> it) -> {
        boolean _isAbstract = it.getKey().isAbstract();
        return Boolean.valueOf((!_isAbstract));
      };
      Iterable<Pair<EClass, EClass>> _filter = IterableExtensions.<Pair<EClass, EClass>>filter(localClasses, _function_4);
      for(final Pair<EClass, EClass> cls : _filter) {
        _builder.append("\t");
        String _typeParam = this.getTypeParam(cls, false);
        _builder.append(_typeParam, "\t");
        _builder.append(" ");
        String _denotationName = this._revisitorNamingUtils.getDenotationName(cls);
        _builder.append(_denotationName, "\t");
        _builder.append("(final ");
        GenClass _genClass = this._ecoreUtils.getGenClass(cls.getKey(), gm);
        String _qualifiedInterfaceName = null;
        if (_genClass!=null) {
          _qualifiedInterfaceName=_genClass.getQualifiedInterfaceName();
        }
        _builder.append(_qualifiedInterfaceName, "\t");
        _builder.append(" ");
        String _varName = this._revisitorNamingUtils.getVarName(cls.getKey());
        _builder.append(_varName, "\t");
        _builder.append(");");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.newLine();
    {
      final Function1<Pair<EClass, EClass>, Boolean> _function_5 = (Pair<EClass, EClass> it) -> {
        EClass _value = it.getValue();
        return Boolean.valueOf((_value == null));
      };
      Iterable<Pair<EClass, EClass>> _filter_1 = IterableExtensions.<Pair<EClass, EClass>>filter(allClasses, _function_5);
      for(final Pair<EClass, EClass> cls_1 : _filter_1) {
        _builder.append("\t");
        final GenClass genCls = this._ecoreUtils.getGenClass(cls_1.getKey(), gm);
        _builder.newLineIfNotEmpty();
        {
          if ((this._ecoreUtils.hasRequiredAnnotation(cls_1.getKey()) && this._ecoreUtils.getSubClasses(cls_1.getKey(), allClasses).isEmpty())) {
            _builder.append("\t");
            String _typeParam_1 = this.getTypeParam(cls_1, false);
            _builder.append(_typeParam_1, "\t");
            _builder.append(" $(final ");
            String _qualifiedInterfaceName_1 = genCls.getQualifiedInterfaceName();
            _builder.append(_qualifiedInterfaceName_1, "\t");
            _builder.append(" it);");
            _builder.newLineIfNotEmpty();
          } else {
            _builder.append("\t");
            _builder.append("default ");
            String _typeParam_2 = this.getTypeParam(cls_1, false);
            _builder.append(_typeParam_2, "\t");
            _builder.append(" $(final ");
            String _qualifiedInterfaceName_2 = null;
            if (genCls!=null) {
              _qualifiedInterfaceName_2=genCls.getQualifiedInterfaceName();
            }
            _builder.append(_qualifiedInterfaceName_2, "\t");
            _builder.append(" it) {");
            _builder.newLineIfNotEmpty();
            {
              final Function1<Pair<EClass, EClass>, Boolean> _function_6 = (Pair<EClass, EClass> it) -> {
                boolean _isAbstract = it.getKey().isAbstract();
                return Boolean.valueOf((!_isAbstract));
              };
              Iterable<Pair<EClass, EClass>> _filter_2 = IterableExtensions.<Pair<EClass, EClass>>filter(this._ecoreUtils.getSubClasses(cls_1.getKey(), allClasses), _function_6);
              for(final Pair<EClass, EClass> subClass : _filter_2) {
                _builder.append("\t");
                _builder.append("\t");
                final GenClass subGenCls = this._ecoreUtils.getGenClass(subClass.getKey(), gm);
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("\t");
                _builder.append("if (it.getClass() == ");
                String _qualifiedClassName = null;
                if (subGenCls!=null) {
                  _qualifiedClassName=subGenCls.getQualifiedClassName();
                }
                _builder.append(_qualifiedClassName, "\t\t");
                _builder.append(".class)");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("\t");
                _builder.append("\t");
                _builder.append("return ");
                String _denotationName_1 = this._revisitorNamingUtils.getDenotationName(subClass);
                _builder.append(_denotationName_1, "\t\t\t");
                _builder.append("((");
                String _qualifiedInterfaceName_3 = null;
                if (subGenCls!=null) {
                  _qualifiedInterfaceName_3=subGenCls.getQualifiedInterfaceName();
                }
                _builder.append(_qualifiedInterfaceName_3, "\t\t\t");
                _builder.append(") it);");
                _builder.newLineIfNotEmpty();
              }
            }
            {
              boolean _isAbstract = cls_1.getKey().isAbstract();
              if (_isAbstract) {
                _builder.append("\t");
                _builder.append("\t");
                _builder.append("return null;");
                _builder.newLine();
              } else {
                _builder.append("\t");
                _builder.append("\t");
                _builder.append("return ");
                String _denotationName_2 = this._revisitorNamingUtils.getDenotationName(cls_1.getKey());
                _builder.append(_denotationName_2, "\t\t");
                _builder.append("(it);");
                _builder.newLineIfNotEmpty();
              }
            }
            _builder.append("\t");
            _builder.append("}");
            _builder.newLine();
          }
        }
      }
    }
    _builder.append("}");
    _builder.newLine();
    return _builder.toString();
  }
  
  public String getTypeParams(final List<Pair<EClass, EClass>> classes, final boolean withExtends) {
    StringConcatenation _builder = new StringConcatenation();
    {
      boolean _hasElements = false;
      for(final Pair<EClass, EClass> cls : classes) {
        if (!_hasElements) {
          _hasElements = true;
          _builder.append("<");
        } else {
          _builder.appendImmediate(", ", "");
        }
        String _typeParam = this.getTypeParam(cls, withExtends);
        _builder.append(_typeParam);
      }
      if (_hasElements) {
        _builder.append(">");
      }
    }
    return _builder.toString();
  }
  
  public String getTypeParam(final Pair<EClass, EClass> pairCls, final boolean withExtends) {
    String _xblockexpression = null;
    {
      final EClass cls = pairCls.getKey();
      final EClass parent = pairCls.getValue();
      String _xifexpression = null;
      EClass _value = pairCls.getValue();
      boolean _tripleEquals = (_value == null);
      if (_tripleEquals) {
        StringConcatenation _builder = new StringConcatenation();
        String _firstUpper = StringExtensions.toFirstUpper(cls.getEPackage().getName().replaceAll("\\.", ""));
        _builder.append(_firstUpper);
        _builder.append("__");
        String _name = cls.getName();
        _builder.append(_name);
        _builder.append("T");
        {
          if (((cls.getESuperTypes().size() == 1) && withExtends)) {
            _builder.append(" extends ");
            EClass _head = IterableExtensions.<EClass>head(cls.getESuperTypes());
            String _typeParam = this.getTypeParam(Pair.<EClass, EClass>of(_head, null), false);
            _builder.append(_typeParam);
          }
        }
        _xifexpression = _builder.toString();
      } else {
        StringConcatenation _builder_1 = new StringConcatenation();
        String _firstUpper_1 = StringExtensions.toFirstUpper(cls.getEPackage().getName().replaceAll("\\.", ""));
        _builder_1.append(_firstUpper_1);
        _builder_1.append("__");
        String _name_1 = cls.getName();
        _builder_1.append(_name_1);
        _builder_1.append("T_AS_");
        String _firstUpper_2 = StringExtensions.toFirstUpper(parent.getEPackage().getName().replaceAll("\\.", ""));
        _builder_1.append(_firstUpper_2);
        _builder_1.append("__");
        String _name_2 = parent.getName();
        _builder_1.append(_name_2);
        _builder_1.append("T");
        {
          if (((parent != null) && withExtends)) {
            _builder_1.append(" extends ");
            String _typeParam_1 = this.getTypeParam(Pair.<EClass, EClass>of(parent, null), false);
            _builder_1.append(_typeParam_1);
          }
        }
        _xifexpression = _builder_1.toString();
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
}
