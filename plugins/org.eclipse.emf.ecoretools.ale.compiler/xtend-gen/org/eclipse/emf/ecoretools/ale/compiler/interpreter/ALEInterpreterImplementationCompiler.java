package org.eclipse.emf.ecoretools.ale.compiler.interpreter;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import org.eclipse.acceleo.query.ast.AstPackage;
import org.eclipse.acceleo.query.runtime.IQueryEnvironment;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EStringToStringMapEntryImpl;
import org.eclipse.emf.ecoretools.ale.compiler.EcoreUtils;
import org.eclipse.emf.ecoretools.ale.compiler.interpreter.EClassImplementationCompiler;
import org.eclipse.emf.ecoretools.ale.compiler.interpreter.EClassInterfaceCompiler;
import org.eclipse.emf.ecoretools.ale.compiler.interpreter.EcoreGenmodelCompiler;
import org.eclipse.emf.ecoretools.ale.compiler.interpreter.FactoryImplementationCompiler;
import org.eclipse.emf.ecoretools.ale.compiler.interpreter.FactoryInterfaceCompiler;
import org.eclipse.emf.ecoretools.ale.compiler.interpreter.PackageImplementationCompiler;
import org.eclipse.emf.ecoretools.ale.compiler.interpreter.PackageInterfaceCompiler;
import org.eclipse.emf.ecoretools.ale.core.interpreter.ExtensionEnvironment;
import org.eclipse.emf.ecoretools.ale.core.interpreter.services.TrigoServices;
import org.eclipse.emf.ecoretools.ale.core.parser.Dsl;
import org.eclipse.emf.ecoretools.ale.core.parser.DslBuilder;
import org.eclipse.emf.ecoretools.ale.core.parser.visitor.ParseResult;
import org.eclipse.emf.ecoretools.ale.core.validation.BaseValidator;
import org.eclipse.emf.ecoretools.ale.core.validation.IValidator;
import org.eclipse.emf.ecoretools.ale.core.validation.TypeValidator;
import org.eclipse.emf.ecoretools.ale.implementation.ExtendedClass;
import org.eclipse.emf.ecoretools.ale.implementation.ImplementationPackage;
import org.eclipse.emf.ecoretools.ale.implementation.ModelUnit;
import org.eclipse.sirius.common.tools.api.interpreter.ClassLoadingCallback;
import org.eclipse.sirius.common.tools.api.interpreter.JavaExtensionsManager;
import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

@SuppressWarnings("all")
public class ALEInterpreterImplementationCompiler {
  @Data
  public static class ResolvedClass {
    private final ExtendedClass aleCls;
    
    public final EClassifier eCls;
    
    public ResolvedClass(final ExtendedClass aleCls, final EClassifier eCls) {
      super();
      this.aleCls = aleCls;
      this.eCls = eCls;
    }
    
    @Override
    @Pure
    public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((this.aleCls== null) ? 0 : this.aleCls.hashCode());
      return prime * result + ((this.eCls== null) ? 0 : this.eCls.hashCode());
    }
    
    @Override
    @Pure
    public boolean equals(final Object obj) {
      if (this == obj)
        return true;
      if (obj == null)
        return false;
      if (getClass() != obj.getClass())
        return false;
      ALEInterpreterImplementationCompiler.ResolvedClass other = (ALEInterpreterImplementationCompiler.ResolvedClass) obj;
      if (this.aleCls == null) {
        if (other.aleCls != null)
          return false;
      } else if (!this.aleCls.equals(other.aleCls))
        return false;
      if (this.eCls == null) {
        if (other.eCls != null)
          return false;
      } else if (!this.eCls.equals(other.eCls))
        return false;
      return true;
    }
    
    @Override
    @Pure
    public String toString() {
      ToStringBuilder b = new ToStringBuilder(this);
      b.add("aleCls", this.aleCls);
      b.add("eCls", this.eCls);
      return b.toString();
    }
    
    @Pure
    public ExtendedClass getAleCls() {
      return this.aleCls;
    }
    
    @Pure
    public EClassifier getECls() {
      return this.eCls;
    }
  }
  
  @Extension
  private EcoreUtils _ecoreUtils = new EcoreUtils();
  
  private List<ParseResult<ModelUnit>> parsedSemantics;
  
  private final IQueryEnvironment queryEnvironment;
  
  private final Map<String, Class<?>> registeredServices = CollectionLiterals.<String, Class<?>>newHashMap();
  
  private final JavaExtensionsManager javaExtensions;
  
  private Map<String, Pair<EPackage, GenModel>> syntaxes;
  
  private Dsl dsl;
  
  private List<ALEInterpreterImplementationCompiler.ResolvedClass> resolved;
  
  public ALEInterpreterImplementationCompiler() {
    this.queryEnvironment = this.createQueryEnvironment(false, null);
    this.queryEnvironment.registerEPackage(ImplementationPackage.eINSTANCE);
    this.queryEnvironment.registerEPackage(AstPackage.eINSTANCE);
    this.javaExtensions = JavaExtensionsManager.createManagerWithOverride();
    this.javaExtensions.addClassLoadingCallBack(new ClassLoadingCallback() {
      @Override
      public void loaded(final String arg0, final Class<?> arg1) {
        ALEInterpreterImplementationCompiler.this.registeredServices.put(arg0, arg1);
      }
      
      @Override
      public void notFound(final String arg0) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append(arg0);
        _builder.append(" not found during services registration");
        throw new RuntimeException(_builder.toString());
      }
      
      @Override
      public void unloaded(final String arg0, final Class<?> arg1) {
        ALEInterpreterImplementationCompiler.this.registeredServices.remove(arg0);
      }
    });
  }
  
  private IQueryEnvironment createQueryEnvironment(final boolean b, final Object object) {
    IQueryEnvironment _xblockexpression = null;
    {
      final IQueryEnvironment newEnv = new ExtensionEnvironment();
      newEnv.registerEPackage(EcorePackage.eINSTANCE);
      newEnv.registerCustomClassMapping(EcorePackage.eINSTANCE.getEStringToStringMapEntry(), 
        EStringToStringMapEntryImpl.class);
      _xblockexpression = newEnv;
    }
    return _xblockexpression;
  }
  
  public IStatus compile(final String projectName, final File projectRoot, final Dsl dsl, final Map<String, Class<?>> services) {
    IStatus _xblockexpression = null;
    {
      this.dsl = dsl;
      this.parsedSemantics = new DslBuilder(this.queryEnvironment).parse(dsl);
      if (((services != null) && (!services.isEmpty()))) {
        this.registeredServices.putAll(services);
      } else {
        this.registerServices(projectName);
      }
      this.compile(projectRoot, projectName);
      _xblockexpression = Status.OK_STATUS;
    }
    return _xblockexpression;
  }
  
  public void registerServices(final String projectName) {
    this.javaExtensions.updateScope(CollectionLiterals.<String>newHashSet(), Collections.<String>unmodifiableSet(CollectionLiterals.<String>newHashSet(projectName)));
    final Function1<ParseResult<ModelUnit>, ModelUnit> _function = (ParseResult<ModelUnit> it) -> {
      return it.getRoot();
    };
    final Function1<ModelUnit, Boolean> _function_1 = (ModelUnit it) -> {
      return Boolean.valueOf((it != null));
    };
    final Function1<ModelUnit, EList<String>> _function_2 = (ModelUnit it) -> {
      return it.getServices();
    };
    Iterable<String> _flatten = Iterables.<String>concat(IterableExtensions.<ModelUnit, EList<String>>map(IterableExtensions.<ModelUnit>filter(ListExtensions.<ParseResult<ModelUnit>, ModelUnit>map(this.parsedSemantics, _function), _function_1), _function_2));
    String _name = TrigoServices.class.getName();
    final Iterable<String> services = Iterables.<String>concat(_flatten, Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList(_name)));
    this.registerServices(IterableExtensions.<String>toList(services));
  }
  
  public void registerServices(final List<String> services) {
    final Consumer<String> _function = (String it) -> {
      this.javaExtensions.addImport(it);
    };
    services.forEach(_function);
    this.javaExtensions.reloadIfNeeded();
  }
  
  private void compile(final File projectRoot, final String projectName) {
    try {
      final File compileDirectory = new File(projectRoot, "interpreter-comp");
      boolean _exists = compileDirectory.exists();
      if (_exists) {
        final Function<Path, File> _function = (Path it) -> {
          return it.toFile();
        };
        final Consumer<File> _function_1 = (File it) -> {
          it.delete();
        };
        Files.walk(compileDirectory.toPath()).sorted(Comparator.<Path>reverseOrder()).<File>map(_function).forEach(_function_1);
      }
      final ArrayList<ExtendedClass> aleClasses = CollectionLiterals.<ExtendedClass>newArrayList();
      for (final ParseResult<ModelUnit> pr : this.parsedSemantics) {
        {
          ModelUnit root = pr.getRoot();
          EList<ExtendedClass> _classExtensions = root.getClassExtensions();
          Iterables.<ExtendedClass>addAll(aleClasses, _classExtensions);
        }
      }
      final Function1<String, String> _function_2 = (String it) -> {
        return it;
      };
      final Function1<String, Pair<EPackage, GenModel>> _function_3 = (String it) -> {
        EPackage _loadEPackage = this._ecoreUtils.loadEPackage(it);
        GenModel _loadGenmodel = this._ecoreUtils.loadGenmodel(it.replaceAll(".ecore$", ".genmodel"));
        return Pair.<EPackage, GenModel>of(_loadEPackage, _loadGenmodel);
      };
      this.syntaxes = IterableExtensions.<String, String, Pair<EPackage, GenModel>>toMap(this.dsl.getAllSyntaxes(), _function_2, _function_3);
      final EPackage syntax = this.syntaxes.get(IterableExtensions.<String>head(this.dsl.getAllSyntaxes())).getKey();
      this.resolved = this.resolve(aleClasses, syntax);
      Object _get = this.dsl.getDslProp().get("rootPackage");
      final String packageRoot = ((String) _get);
      final EcoreGenmodelCompiler egc = new EcoreGenmodelCompiler();
      final FactoryInterfaceCompiler fic = new FactoryInterfaceCompiler();
      final FactoryImplementationCompiler fimplc = new FactoryImplementationCompiler();
      final PackageInterfaceCompiler pic = new PackageInterfaceCompiler();
      final PackageImplementationCompiler pimplc = new PackageImplementationCompiler();
      final EClassInterfaceCompiler eic = new EClassInterfaceCompiler();
      final EClassImplementationCompiler eimplc = new EClassImplementationCompiler(packageRoot, this.resolved);
      final Function1<Pair<EPackage, GenModel>, EPackage> _function_4 = (Pair<EPackage, GenModel> v) -> {
        return v.getKey();
      };
      egc.compileEcoreGenmodel(IterableExtensions.<EPackage>toList(IterableExtensions.<Pair<EPackage, GenModel>, EPackage>map(this.syntaxes.values(), _function_4)), compileDirectory.getAbsolutePath(), projectName);
      TypeValidator _typeValidator = new TypeValidator();
      final BaseValidator base = new BaseValidator(this.queryEnvironment, Collections.<IValidator>unmodifiableList(CollectionLiterals.<IValidator>newArrayList(_typeValidator)));
      base.validate(this.parsedSemantics);
      String _property = this.dsl.getDslProp().getProperty("truffle", "false");
      final boolean isTruffle = Objects.equal(_property, "true");
      final BiConsumer<String, Pair<EPackage, GenModel>> _function_5 = (String key, Pair<EPackage, GenModel> pairEPackageGenModel) -> {
        try {
          fic.compileFactoryInterface(pairEPackageGenModel.getKey(), compileDirectory, packageRoot);
          fimplc.compileFactoryImplementation(pairEPackageGenModel.getKey(), compileDirectory, packageRoot, isTruffle);
          pic.compilePackageInterface(pairEPackageGenModel.getKey(), compileDirectory, packageRoot);
          pimplc.compilePackageImplementation(pairEPackageGenModel.getKey(), compileDirectory, packageRoot);
          final List<EClassifier> eClassifiersLst = this._ecoreUtils.getAllClassifiers(pairEPackageGenModel.getKey());
          final Function1<EClassifier, Boolean> _function_6 = (EClassifier it) -> {
            return Boolean.valueOf(((!(it instanceof EDataType)) || (it instanceof EEnum)));
          };
          Iterable<EClassifier> _filter = IterableExtensions.<EClassifier>filter(eClassifiersLst, _function_6);
          for (final EClassifier eclazz : _filter) {
            try {
              final Function1<ALEInterpreterImplementationCompiler.ResolvedClass, Boolean> _function_7 = (ALEInterpreterImplementationCompiler.ResolvedClass it) -> {
                return Boolean.valueOf((Objects.equal(it.eCls.getName(), eclazz.getName()) && Objects.equal(it.eCls.getEPackage().getName(), eclazz.getEPackage().getName())));
              };
              final ALEInterpreterImplementationCompiler.ResolvedClass rc = IterableExtensions.<ALEInterpreterImplementationCompiler.ResolvedClass>head(IterableExtensions.<ALEInterpreterImplementationCompiler.ResolvedClass>filter(this.resolved, _function_7));
              ExtendedClass _aleCls = null;
              if (rc!=null) {
                _aleCls=rc.aleCls;
              }
              eic.compileEClassInterface(eclazz, _aleCls, compileDirectory, this.dsl, packageRoot);
              ExtendedClass _aleCls_1 = null;
              if (rc!=null) {
                _aleCls_1=rc.aleCls;
              }
              eimplc.compileEClassImplementation(eclazz, _aleCls_1, compileDirectory, this.syntaxes, this.resolved, 
                this.registeredServices, this.dsl, base);
            } catch (final Throwable _t) {
              if (_t instanceof Exception) {
                final Exception e = (Exception)_t;
                e.printStackTrace();
              } else {
                throw Exceptions.sneakyThrow(_t);
              }
            }
          }
        } catch (final Throwable _t_1) {
          if (_t_1 instanceof Exception) {
            final Exception e_1 = (Exception)_t_1;
            e_1.printStackTrace();
          } else {
            throw Exceptions.sneakyThrow(_t_1);
          }
        }
      };
      this.syntaxes.forEach(_function_5);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public List<ALEInterpreterImplementationCompiler.ResolvedClass> resolve(final List<ExtendedClass> aleClasses, final EPackage syntax) {
    final Function1<EClassifier, ALEInterpreterImplementationCompiler.ResolvedClass> _function = (EClassifier eClass) -> {
      ALEInterpreterImplementationCompiler.ResolvedClass _xblockexpression = null;
      {
        final Function1<ExtendedClass, Boolean> _function_1 = (ExtendedClass it) -> {
          return Boolean.valueOf((Objects.equal(it.getName(), eClass.getName()) || Objects.equal(it.getName(), ((eClass.getEPackage().getName() + ".") + eClass.getName()))));
        };
        final ExtendedClass aleClass = IterableExtensions.<ExtendedClass>head(IterableExtensions.<ExtendedClass>filter(aleClasses, _function_1));
        _xblockexpression = new ALEInterpreterImplementationCompiler.ResolvedClass(aleClass, eClass);
      }
      return _xblockexpression;
    };
    return ListExtensions.<EClassifier, ALEInterpreterImplementationCompiler.ResolvedClass>map(this._ecoreUtils.getAllClassifiers(syntax), _function);
  }
}
