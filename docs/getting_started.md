---
title: Installation
order: 1
---

Install ALE from its update site
============================

1 - Install Eclipse IDE
-----------------------

The recommended package is [Eclipse IDE for Java and DSL developers](https://www.eclipse.org/downloads/packages/release/2019-09/r/eclipse-ide-java-and-dsl-developers):
- [https://www.eclipse.org/downloads/packages/release/2019-09/r/eclipse-ide-java-and-dsl-developers](https://www.eclipse.org/downloads/packages/release/2019-09/r/eclipse-ide-java-and-dsl-developers)
  
2 - Install ALE
---------------

1. Open Eclipse IDE
2. Go to `Help > Install New Software...`
3. Copy the [update site's URL](https://ci.inria.fr/gemoc/job/ale-lang/lastSuccessfulBuild/artifact/releng/org.eclipse.emf.ecoretools.ale.updatesite/target/repository/) in the `Work with` textbox
   * [https://ci.inria.fr/gemoc/job/ale-lang/lastSuccessfulBuild/artifact/releng/org.eclipse.emf.ecoretools.ale.updatesite/target/repository/](https://ci.inria.fr/gemoc/job/ale-lang/lastSuccessfulBuild/artifact/releng/org.eclipse.emf.ecoretools.ale.updatesite/target/repository/)
4. Hit `Enter` and wait for the list to load
5. Check `Action Language for EMF`
6. Click `Next` and `Finish`

You are ready to go!

Install older ALE versions
==========================

Archived versions of ALE can be found at the following URL:
- [http://www.kermeta.org/ale-lang/updates/](http://www.kermeta.org/ale-lang/updates/)

To install a version:
1. Pick its URL (which is in the form [http://www.kermeta.org/ale-lang/updates/yyyy-mm-dd/](http://www.kermeta.org/ale-lang/updates/yyyy-mm-dd/))
2. Use it in Eclipse IDE as explained above.