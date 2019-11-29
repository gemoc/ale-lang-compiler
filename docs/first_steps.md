---
title: First steps
order: 2
---

First steps
===========

Requirements
-------------

* Have at least a basic knowledge of [EMF (Eclipse Modeling Framework)](https://www.eclipse.org/modeling/emf/).
* Have [installed ALE Compiler]({{ site.baseurl }}{% link getting_started.md %}).

Objectives
----------

 * Compile an ALE project to Java.
 * Execute a program using the compiled language.

# Get the HelloWorld example from ALE

ALE provides an `Hello world!` project template:

1. `File > New > Example...`
2. `EcoreTools ALE Examples > Hello world!`
3. Select `helloworld`
4. `Finish`

After a few seconds a new project called *helloworld* should be created in your workspace. This project defines a simple `HelloWorld` EClass able to print "Hello world!". The content of the project is presented below.

What we have inside
-------------------

For more details of the language's architecture, see [ALE first steps](http://gemoc.org/ale-lang/first_steps.html).

# Compile!

At this point you are able to interpret Helloworld programs using the ALE interpreter.

## Compilation using the Eclipse IDE


1. Create an Eclipse Plugin-in Project named 'helloworld.interpreter'
2. Create `src/helloworld.dsl` in this project, with the following content:

```
syntax=platform:/resource/helloworld/model/helloworld.ecore
behavior=platform:/resource/helloworld/model/helloworld.ale
compilationType=interpreter
```

3. Create a genmodel file for `helloworld.ecore`
3. Open `META-INF/MANIFEST.MF`, and on the Dependencies list, add `org.eclipse.emf.ecore`, `helloworld`, and `org.eclipse.emf.ecoretools.ale.compiler.lib` on the project's required plugins. 
3. Right click on the dsl file and select **ALE > Generate Ale Implementation**
4. Right click on the newly created `interpreter-comp` directory and select **Build Path > Use as Source Folder

You have generated a compiled version of the helloworld language following the Interpreter implementation pattern.

By substituting `interpreter` by `visitor`, `switch` or `revisitor` in the steps above, you can freely compile your language to another implementation pattern.


## Compilation with Maven

**Prerequisite**: We do not cover the details of the integration of you project using maven but several example of ALE language with a maven integration can be found in the [ale compiler github repository](https://github.com/gemoc/ale-lang-compiler/tree/master/languages).

Once your language integrated with maven, the automated compilation using the alecompiler-maven-plugin can be integrated by adding the following definition in your language's pom.xml:

```xml
<build>
    <sourceDirectory>PATTERN-comp</sourceDirectory>
    <plugins>
        <plugin>
            <groupId>org.eclipse.emf.ecoretools.ale.compiler</groupId>
            <artifactId>alecompiler-maven-plugin</artifactId>
            <version>1.0.0-SNAPSHOT</version>
            <executions>
                <execution>
                    <phase>generate-sources</phase>
                    <goals>
                        <goal>ale-dsl-compile</goal>
                    </goals>
                </execution>
            </executions>
            <configuration>
                <dslFile>${project.basedir}/src/LANGUAGE.dsl</dslFile>
            </configuration>
        </plugin>
    </plugins>
</build>
```