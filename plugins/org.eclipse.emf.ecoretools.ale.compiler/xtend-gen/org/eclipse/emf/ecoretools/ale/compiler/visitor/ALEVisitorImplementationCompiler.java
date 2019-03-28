package org.eclipse.emf.ecoretools.ale.compiler.visitor;

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
import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EStringToStringMapEntryImpl;
import org.eclipse.emf.ecoretools.ale.compiler.EcoreUtils;
import org.eclipse.emf.ecoretools.ale.compiler.visitor.AcceptInterfaceCompiler;
import org.eclipse.emf.ecoretools.ale.compiler.visitor.EClassImplementationCompiler;
import org.eclipse.emf.ecoretools.ale.compiler.visitor.EClassInterfaceCompiler;
import org.eclipse.emf.ecoretools.ale.compiler.visitor.EcoreGenmodelCompiler;
import org.eclipse.emf.ecoretools.ale.compiler.visitor.FactoryImplementationCompiler;
import org.eclipse.emf.ecoretools.ale.compiler.visitor.FactoryInterfaceCompiler;
import org.eclipse.emf.ecoretools.ale.compiler.visitor.OperationImplementationCompiler;
import org.eclipse.emf.ecoretools.ale.compiler.visitor.OperationInterfaceCompiler;
import org.eclipse.emf.ecoretools.ale.compiler.visitor.PackageImplementationCompiler;
import org.eclipse.emf.ecoretools.ale.compiler.visitor.PackageInterfaceCompiler;
import org.eclipse.emf.ecoretools.ale.compiler.visitor.VisitorImplementationCompiler;
import org.eclipse.emf.ecoretools.ale.compiler.visitor.VisitorInterfaceCompiler;
import org.eclipse.emf.ecoretools.ale.core.interpreter.ExtensionEnvironment;
import org.eclipse.emf.ecoretools.ale.core.interpreter.services.TrigoServices;
import org.eclipse.emf.ecoretools.ale.core.parser.Dsl;
import org.eclipse.emf.ecoretools.ale.core.parser.DslBuilder;
import org.eclipse.emf.ecoretools.ale.core.parser.visitor.ParseResult;
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
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.MapExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

@SuppressWarnings("all")
public class ALEVisitorImplementationCompiler {
  @Data
  public static class ResolvedClass {
    private final ExtendedClass aleCls;
    
    public final EClass eCls;
    
    private final GenClass genCls;
    
    public ResolvedClass(final ExtendedClass aleCls, final EClass eCls, final GenClass genCls) {
      super();
      this.aleCls = aleCls;
      this.eCls = eCls;
      this.genCls = genCls;
    }
    
    @Override
    @Pure
    public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((this.aleCls== null) ? 0 : this.aleCls.hashCode());
      result = prime * result + ((this.eCls== null) ? 0 : this.eCls.hashCode());
      return prime * result + ((this.genCls== null) ? 0 : this.genCls.hashCode());
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
      ALEVisitorImplementationCompiler.ResolvedClass other = (ALEVisitorImplementationCompiler.ResolvedClass) obj;
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
      if (this.genCls == null) {
        if (other.genCls != null)
          return false;
      } else if (!this.genCls.equals(other.genCls))
        return false;
      return true;
    }
    
    @Override
    @Pure
    public String toString() {
      ToStringBuilder b = new ToStringBuilder(this);
      b.add("aleCls", this.aleCls);
      b.add("eCls", this.eCls);
      b.add("genCls", this.genCls);
      return b.toString();
    }
    
    @Pure
    public ExtendedClass getAleCls() {
      return this.aleCls;
    }
    
    @Pure
    public EClass getECls() {
      return this.eCls;
    }
    
    @Pure
    public GenClass getGenCls() {
      return this.genCls;
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
  
  private List<ALEVisitorImplementationCompiler.ResolvedClass> resolved;
  
  public ALEVisitorImplementationCompiler() {
    this.queryEnvironment = this.createQueryEnvironment(false, null);
    this.queryEnvironment.registerEPackage(ImplementationPackage.eINSTANCE);
    this.queryEnvironment.registerEPackage(AstPackage.eINSTANCE);
    this.javaExtensions = JavaExtensionsManager.createManagerWithOverride();
    this.javaExtensions.addClassLoadingCallBack(new ClassLoadingCallback() {
      @Override
      public void loaded(final String arg0, final Class<?> arg1) {
        ALEVisitorImplementationCompiler.this.registeredServices.put(arg0, arg1);
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
        ALEVisitorImplementationCompiler.this.registeredServices.remove(arg0);
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
  
  public IStatus compile(final String projectName, final File projectRoot, final Dsl dsl) {
    IStatus _xblockexpression = null;
    {
      this.dsl = dsl;
      this.parsedSemantics = new DslBuilder(this.queryEnvironment).parse(dsl);
      this.registerServices(projectName);
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
      final File compileDirectory = new File(projectRoot, "visitor-comp");
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
      final AcceptInterfaceCompiler acceptInterfaceCompiler = new AcceptInterfaceCompiler(compileDirectory, packageRoot);
      acceptInterfaceCompiler.compile();
      final VisitorInterfaceCompiler visitorInterfaceCompiler = new VisitorInterfaceCompiler(compileDirectory, this.syntaxes, packageRoot);
      visitorInterfaceCompiler.compile();
      final VisitorImplementationCompiler visitorImplementationCompiler = new VisitorImplementationCompiler(compileDirectory, this.syntaxes, packageRoot);
      visitorImplementationCompiler.compile();
      final EClassInterfaceCompiler eic = new EClassInterfaceCompiler();
      final EClassImplementationCompiler eimplc = new EClassImplementationCompiler(packageRoot, this.dsl);
      final OperationInterfaceCompiler operationInterfaceCompiler = new OperationInterfaceCompiler(compileDirectory, packageRoot, this.syntaxes);
      final OperationImplementationCompiler operationImplementationCompiler = new OperationImplementationCompiler(compileDirectory, packageRoot, 
        this.syntaxes, this.queryEnvironment, this.parsedSemantics, this.resolved, this.registeredServices);
      final Function1<Pair<EPackage, GenModel>, EPackage> _function_4 = (Pair<EPackage, GenModel> v) -> {
        return v.getKey();
      };
      egc.compileEcoreGenmodel(IterableExtensions.<EPackage>toList(IterableExtensions.<Pair<EPackage, GenModel>, EPackage>map(this.syntaxes.values(), _function_4)), compileDirectory.getAbsolutePath(), projectName);
      final BiConsumer<String, Pair<EPackage, GenModel>> _function_5 = (String key, Pair<EPackage, GenModel> pairEPackageGenModel) -> {
        fic.compileFactoryInterface(pairEPackageGenModel.getKey(), compileDirectory, packageRoot);
        fimplc.compileFactoryImplementation(pairEPackageGenModel.getKey(), compileDirectory, packageRoot);
        pic.compilePackageInterface(pairEPackageGenModel.getKey(), compileDirectory, packageRoot);
        pimplc.compilePackageImplementation(pairEPackageGenModel.getKey(), compileDirectory, packageRoot);
        List<EClass> _allClasses = this._ecoreUtils.getAllClasses(pairEPackageGenModel.getKey());
        for (final EClass eclazz : _allClasses) {
          {
            final Function1<ALEVisitorImplementationCompiler.ResolvedClass, Boolean> _function_6 = (ALEVisitorImplementationCompiler.ResolvedClass it) -> {
              return Boolean.valueOf((Objects.equal(it.eCls.getName(), eclazz.getName()) && Objects.equal(it.eCls.getEPackage().getName(), eclazz.getEPackage().getName())));
            };
            final ALEVisitorImplementationCompiler.ResolvedClass rc = IterableExtensions.<ALEVisitorImplementationCompiler.ResolvedClass>head(IterableExtensions.<ALEVisitorImplementationCompiler.ResolvedClass>filter(this.resolved, _function_6));
            ExtendedClass _aleCls = null;
            if (rc!=null) {
              _aleCls=rc.aleCls;
            }
            eic.compileEClassInterface(eclazz, _aleCls, compileDirectory, this.dsl, packageRoot);
            eimplc.compileEClassImplementation(eclazz, compileDirectory);
            ExtendedClass _aleCls_1 = null;
            if (rc!=null) {
              _aleCls_1=rc.aleCls;
            }
            operationInterfaceCompiler.compile(eclazz, _aleCls_1);
            ExtendedClass _aleCls_2 = null;
            if (rc!=null) {
              _aleCls_2=rc.aleCls;
            }
            operationImplementationCompiler.compile(eclazz, _aleCls_2);
          }
        }
      };
      this.syntaxes.forEach(_function_5);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public List<ALEVisitorImplementationCompiler.ResolvedClass> resolve(final List<ExtendedClass> aleClasses, final EPackage syntax) {
    final Function1<EClass, ALEVisitorImplementationCompiler.ResolvedClass> _function = (EClass eClass) -> {
      ALEVisitorImplementationCompiler.ResolvedClass _xblockexpression = null;
      {
        final Function1<ExtendedClass, Boolean> _function_1 = (ExtendedClass it) -> {
          return Boolean.valueOf((Objects.equal(it.getName(), eClass.getName()) || Objects.equal(it.getName(), ((eClass.getEPackage().getName() + ".") + eClass.getName()))));
        };
        final ExtendedClass aleClass = IterableExtensions.<ExtendedClass>head(IterableExtensions.<ExtendedClass>filter(aleClasses, _function_1));
        final Function2<String, Pair<EPackage, GenModel>, Boolean> _function_2 = (String k, Pair<EPackage, GenModel> v) -> {
          return Boolean.valueOf(this._ecoreUtils.getAllClasses(v.getKey()).contains(eClass));
        };
        final Function1<Pair<EPackage, GenModel>, GenModel> _function_3 = (Pair<EPackage, GenModel> it) -> {
          return it.getValue();
        };
        final Function1<GenModel, Iterable<GenClass>> _function_4 = (GenModel it) -> {
          final Function1<GenPackage, EList<GenClass>> _function_5 = (GenPackage it_1) -> {
            return it_1.getGenClasses();
          };
          return Iterables.<GenClass>concat(ListExtensions.<GenPackage, EList<GenClass>>map(it.getGenPackages(), _function_5));
        };
        final Function1<GenClass, Boolean> _function_5 = (GenClass it) -> {
          EClass _ecoreClass = it.getEcoreClass();
          return Boolean.valueOf(Objects.equal(_ecoreClass, eClass));
        };
        final GenClass gl = IterableExtensions.<GenClass>head(IterableExtensions.<GenClass>filter(Iterables.<GenClass>concat(IterableExtensions.<GenModel, Iterable<GenClass>>map(IterableExtensions.<Pair<EPackage, GenModel>, GenModel>map(MapExtensions.<String, Pair<EPackage, GenModel>>filter(this.syntaxes, _function_2).values(), _function_3), _function_4)), _function_5));
        if ((gl == null)) {
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("gl is null");
          throw new RuntimeException(_builder.toString());
        }
        _xblockexpression = new ALEVisitorImplementationCompiler.ResolvedClass(aleClass, eClass, gl);
      }
      return _xblockexpression;
    };
    return ListExtensions.<EClass, ALEVisitorImplementationCompiler.ResolvedClass>map(this._ecoreUtils.getAllClasses(syntax), _function);
  }
}
