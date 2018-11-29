#!/bin/bash
pwd=$3
GRAALVM_HOME=$pwd/graalvm-ee-1.0.0-rc9
MAVEN_HOME=$pwd/apache-maven-3.6.0
PATH=$PATH:$MAVEN_HOME/bin
key=$1
itt=$2
cd $pwd
./app/eclipse/eclipse
mvn -Dmaven.repo.local=$pwd/.m2 -f workspace/standaloneboainterpreter/pom.xml clean package
cd workspace
#git add .
# git commit -m "version $i"
# md5sum standaloneboainterpreter/target/standaloneboainterpreter.jar
cd $pwd
tmp="$GRAALVM_HOME/bin/java -XX:-UseJVMCIClassLoader -cp $pwd/workspace/standaloneboainterpreter/target/standaloneboainterpreter.jar boa.benchmark.truffle.BoaBenchmarkTruffle $pwd/fib30.xmi $itt"
#echo $tmp
RES="$($(echo $tmp) | tail -n1)"
timestamp=$(date +%s)
echo $key > times_$timestamp.log
echo $RES >> times_$timestamp.log
echo $RES
