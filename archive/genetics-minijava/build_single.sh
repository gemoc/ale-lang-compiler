#!/bin/bash
pwd=$3
GRAALVM_HOME=$pwd/graalvm-ee-1.0.0-rc9
MAVEN_HOME=$pwd/apache-maven-3.6.0
key=$1
itt=$2
cd $pwd
./app/eclipse/eclipse
mvn -f standaloneminijavainterpreter/pom.xml clean package
cd $pwd
timestamp=$(date +%s)
echo $key > times_$timestamp.log
$GRAALVM_HOME/bin/java -XX:-UseJVMCIClassLoader -cp standaloneminijavainterpreter/target/standaloneminijavainterpreter.jar minijava.MiniJavaPerfTest ./binarytree.minijava.xmi $itt | tail -n1 >> times_$timestamp.log
cat times_$timestamp.log
