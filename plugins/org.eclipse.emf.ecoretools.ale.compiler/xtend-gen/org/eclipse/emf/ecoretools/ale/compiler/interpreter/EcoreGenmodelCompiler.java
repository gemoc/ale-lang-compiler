package org.eclipse.emf.ecoretools.ale.compiler.interpreter;

import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import org.eclipse.emf.codegen.ecore.genmodel.GenJDKLevel;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenModelFactory;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class EcoreGenmodelCompiler {
  public void compileEcoreGenmodel(final List<EPackage> ePackages, final String path, final String projectName) {
    final ResourceSetImpl resSet = new ResourceSetImpl();
    final Consumer<EPackage> _function = (EPackage ePackage) -> {
      try {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append(path);
        _builder.append("/");
        String _name = ePackage.getName();
        _builder.append(_name);
        _builder.append(".ecore");
        final URI tmp = URI.createFileURI(_builder.toString());
        final Resource ecoreRes = resSet.createResource(tmp);
        EList<EObject> _contents = ecoreRes.getContents();
        EPackage _copy = EcoreUtil2.<EPackage>copy(ePackage);
        final Procedure1<EPackage> _function_1 = (EPackage it) -> {
          StringConcatenation _builder_1 = new StringConcatenation();
          _builder_1.append("http://");
          String _name_1 = ePackage.getName();
          _builder_1.append(_name_1);
          _builder_1.append(".");
          String _name_2 = ePackage.getName();
          _builder_1.append(_name_2);
          _builder_1.append(".");
          String _name_3 = ePackage.getName();
          _builder_1.append(_name_3);
          _builder_1.append("/");
          it.setNsURI(_builder_1.toString());
        };
        EPackage _doubleArrow = ObjectExtensions.<EPackage>operator_doubleArrow(_copy, _function_1);
        _contents.add(_doubleArrow);
        ecoreRes.save(null);
        final GenModel gm = GenModelFactory.eINSTANCE.createGenModel();
        gm.initialize(Collections.<EPackage>unmodifiableList(CollectionLiterals.<EPackage>newArrayList(ePackage)));
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("/");
        _builder_1.append(projectName);
        _builder_1.append("/interpreter-comp");
        gm.setModelDirectory(_builder_1.toString());
        GenPackage _head = IterableExtensions.<GenPackage>head(gm.getGenPackages());
        StringConcatenation _builder_2 = new StringConcatenation();
        String _name_1 = ePackage.getName();
        _builder_2.append(_name_1);
        _builder_2.append(".interpreter");
        _head.setBasePackage(_builder_2.toString());
        gm.setComplianceLevel(GenJDKLevel.JDK80_LITERAL);
        EList<String> _foreignModel = gm.getForeignModel();
        StringConcatenation _builder_3 = new StringConcatenation();
        String _name_2 = ePackage.getName();
        _builder_3.append(_name_2);
        _builder_3.append(".ecore");
        _foreignModel.add(_builder_3.toString());
        StringConcatenation _builder_4 = new StringConcatenation();
        _builder_4.append(path);
        _builder_4.append("/");
        String _name_3 = ePackage.getName();
        _builder_4.append(_name_3);
        _builder_4.append(".genmodel");
        final Resource gmRes = resSet.createResource(URI.createFileURI(_builder_4.toString()));
        EList<EObject> _contents_1 = gmRes.getContents();
        _contents_1.add(gm);
        gmRes.save(null);
      } catch (Throwable _e) {
        throw Exceptions.sneakyThrow(_e);
      }
    };
    ePackages.forEach(_function);
  }
}
