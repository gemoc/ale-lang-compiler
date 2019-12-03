# Action Language for EMF Compiler

ALE is a language to make Ecore metamodels executable.
Concretely, ALE allows to "re-open" the EClasses from Ecore metamodels to implement existing EOperations and weave new features or new operations. The main advantage is to split abstract syntax and semantics concerns by weaving new features and implementations on EClasses. The original Ecore files remain unmodified but thanks to ALE new elements can be used in the execution of the implemented operations.

This project is dedicated to the ALE compiler.
To find out more about ALE and it interpreter, checks the [documentation of the language](http://gemoc.org/ale-lang).

The main features of the ALE Compiler are:
 * **Integration with Eclipse**: Compile ALE languages in the Eclipse IDE.
 * **Maven integration**: Automatically compile your languages using the ale compiler maven plugin.
 * **Configurable**: The ALE Compiler can target four implementation patterns: Interpreter, Visitor, EMF's Switch and Revisitor.

Doc
===
* [Website](http://gemoc.org/ale-lang-compiler/)
* [Continous integration](https://ci.inria.fr/gemoc/job/ale-lang-compiler) 
* [Update site](http://www.kermeta.org/ale-lang-compiler/updates/)
