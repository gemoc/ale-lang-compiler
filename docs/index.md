---
title: Home
order: 0
---

Action Language for EMF Compiler
=======================

ALE is a language to make Ecore metamodels executable.
Concretely, ALE allows to "re-open" the EClasses from Ecore metamodels to implement existing EOperations and weave new features or new operations. The main advantage is to split abstract syntax and semantics concerns by weaving new features and implementations on EClasses. The original Ecore files remain unmodified but thanks to the ALE interpreter new elements can be used in the execution of the implemented operations.

To find out more about ALE, checks the [documentation of the language](http://gemoc.org/ale-lang).

The main features of the ALE Compiler are:
 * **Integration with Eclipse**: Compile ALE languages in the Eclipse IDE
 * **Maven integration**: Automatically compile your languages using the ale compiler maven plugin
 * **Configurable**: The ALE Compiler can target four implementation patterns: Interpreter, Visitor, EMF's Switch and Revisitor.