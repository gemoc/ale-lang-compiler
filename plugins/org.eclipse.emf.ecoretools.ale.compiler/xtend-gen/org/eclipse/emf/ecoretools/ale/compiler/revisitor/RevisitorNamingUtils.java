package org.eclipse.emf.ecoretools.ale.compiler.revisitor;

import com.google.common.base.Objects;
import com.squareup.javapoet.ClassName;
import java.util.List;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecoretools.ale.core.parser.Dsl;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class RevisitorNamingUtils {
  public String getRevisitorPackageFqn(final GenPackage pkg) {
    String _xblockexpression = null;
    {
      String _xifexpression = null;
      if (((pkg.getBasePackage() == null) || Objects.equal(pkg.getBasePackage(), ""))) {
        _xifexpression = pkg.getEcorePackage().getName();
      } else {
        _xifexpression = pkg.getBasePackage();
      }
      final String pkgName = _xifexpression;
      StringConcatenation _builder = new StringConcatenation();
      _builder.append(pkgName);
      _builder.append(".revisitor");
      _xblockexpression = _builder.toString();
    }
    return _xblockexpression;
  }
  
  public String getRevisitorInterfaceName(final GenPackage pkg) {
    StringConcatenation _builder = new StringConcatenation();
    String _firstUpper = StringExtensions.toFirstUpper(pkg.getEcorePackage().getName());
    _builder.append(_firstUpper);
    _builder.append("Revisitor");
    return _builder.toString();
  }
  
  public String getRevisitorInterfaceFqn(final GenPackage pkg) {
    StringConcatenation _builder = new StringConcatenation();
    String _revisitorPackageFqn = this.getRevisitorPackageFqn(pkg);
    _builder.append(_revisitorPackageFqn);
    _builder.append(".");
    String _revisitorInterfaceName = this.getRevisitorInterfaceName(pkg);
    _builder.append(_revisitorInterfaceName);
    return _builder.toString();
  }
  
  public String getRevisitorInterfacePath(final GenPackage pkg) {
    String _xblockexpression = null;
    {
      String _xifexpression = null;
      if (((pkg.getBasePackage() != null) && (!Objects.equal(pkg.getBasePackage(), "")))) {
        _xifexpression = pkg.getBasePackage();
      } else {
        _xifexpression = pkg.getEcorePackage().getName();
      }
      final String pn = _xifexpression;
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("src/");
      {
        String[] _split = pn.split("\\.");
        boolean _hasElements = false;
        for(final String fragment : _split) {
          if (!_hasElements) {
            _hasElements = true;
          } else {
            _builder.appendImmediate("/", "");
          }
          _builder.append(fragment);
        }
      }
      _builder.append("/revisitor");
      _xblockexpression = _builder.toString();
    }
    return _xblockexpression;
  }
  
  public String getTypeParamName(final EClass cls) {
    StringConcatenation _builder = new StringConcatenation();
    String _firstUpper = StringExtensions.toFirstUpper(cls.getEPackage().getName().replaceAll("\\.", ""));
    _builder.append(_firstUpper);
    _builder.append("__");
    String _name = cls.getName();
    _builder.append(_name);
    _builder.append("T");
    return _builder.toString();
  }
  
  public String getDenotationName(final EClass cls) {
    StringConcatenation _builder = new StringConcatenation();
    String _firstLower = StringExtensions.toFirstLower(cls.getEPackage().getName());
    _builder.append(_firstLower);
    _builder.append("__");
    String _name = cls.getName();
    _builder.append(_name);
    return _builder.toString();
  }
  
  public String getDenotationName(final Pair<EClass, EClass> cls) {
    StringConcatenation _builder = new StringConcatenation();
    String _denotationName = this.getDenotationName(cls.getKey());
    _builder.append(_denotationName);
    {
      EClass _value = cls.getValue();
      boolean _tripleNotEquals = (_value != null);
      if (_tripleNotEquals) {
        _builder.append("__AS__");
        String _denotationName_1 = this.getDenotationName(cls.getValue());
        _builder.append(_denotationName_1);
      }
    }
    return _builder.toString();
  }
  
  public String getDenotationName(final EClass parent, final EClass child) {
    StringConcatenation _builder = new StringConcatenation();
    String _denotationName = this.getDenotationName(parent);
    _builder.append(_denotationName);
    _builder.append("_");
    String _denotationName_1 = this.getDenotationName(child);
    _builder.append(_denotationName_1);
    return _builder.toString();
  }
  
  public String getVarName(final EClass cls) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("it");
    return _builder.toString();
  }
  
  public String getRevisitorImplementationPackage(final Dsl dsl) {
    StringConcatenation _builder = new StringConcatenation();
    String _sourceFileName = dsl.getSourceFileName();
    _builder.append(_sourceFileName);
    _builder.append(".impl");
    return _builder.toString();
  }
  
  public String getRevisitorOperationInterfacePackage(final Dsl dsl) {
    StringConcatenation _builder = new StringConcatenation();
    String _revisitorImplementationPackage = this.getRevisitorImplementationPackage(dsl);
    _builder.append(_revisitorImplementationPackage);
    _builder.append(".operation");
    return _builder.toString();
  }
  
  public String getRevisitorOperationImplementationPackage(final Dsl dsl) {
    StringConcatenation _builder = new StringConcatenation();
    String _revisitorOperationInterfacePackage = this.getRevisitorOperationInterfacePackage(dsl);
    _builder.append(_revisitorOperationInterfacePackage);
    _builder.append(".impl");
    return _builder.toString();
  }
  
  public String getRevisitorOperationInterfaceClassName(final EClass ecls) {
    StringConcatenation _builder = new StringConcatenation();
    String _name = ecls.getName();
    _builder.append(_name);
    _builder.append("Op");
    return _builder.toString();
  }
  
  public String getRevisitorOperationImplementationClassName(final EClass ecls) {
    StringConcatenation _builder = new StringConcatenation();
    String _name = ecls.getName();
    _builder.append(_name);
    _builder.append("OpImpl");
    return _builder.toString();
  }
  
  public ClassName getRevisitorOperationInterfaceClassName(final Dsl dsl, final EClass ecls) {
    return ClassName.get(this.getRevisitorOperationInterfacePackage(dsl), this.getRevisitorOperationInterfaceClassName(ecls));
  }
  
  public ClassName getRevisitorOperationImplementationClassName(final Dsl dsl, final EClass ecls) {
    return ClassName.get(this.getRevisitorOperationImplementationPackage(dsl), this.getRevisitorOperationImplementationClassName(ecls));
  }
  
  public String getRevisitorImplementationClass(final Dsl dsl) {
    String _xblockexpression = null;
    {
      final String name = dsl.getSourceFileName();
      final Function1<String, String> _function = (String it) -> {
        return StringExtensions.toFirstUpper(it);
      };
      final String camelCased = IterableExtensions.join(ListExtensions.<String, String>map(((List<String>)Conversions.doWrapArray(name.split("\\."))), _function));
      StringConcatenation _builder = new StringConcatenation();
      _builder.append(camelCased);
      _builder.append("Implementation");
      _xblockexpression = _builder.toString();
    }
    return _xblockexpression;
  }
  
  public String classInterfacePackageName(final EClass eClass, final String packageRoot) {
    return this.factoryInterfacePackageName(eClass.getEPackage(), packageRoot);
  }
  
  public String factoryInterfacePackageName(final EPackage ePackage, final String packageRoot) {
    StringConcatenation _builder = new StringConcatenation();
    {
      if (((packageRoot != null) && (!Objects.equal(packageRoot, "")))) {
        _builder.append(packageRoot);
        _builder.append(".");
      }
    }
    String _name = ePackage.getName();
    _builder.append(_name);
    _builder.append(".revisitor.");
    String _name_1 = ePackage.getName();
    _builder.append(_name_1);
    return _builder.toString();
  }
}
