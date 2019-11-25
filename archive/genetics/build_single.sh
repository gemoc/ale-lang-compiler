#!/bin/bash
pwd=$3
GRAALVM_HOME=$pwd/graalvm-ee-1.0.0-rc9
MAVEN_HOME=$pwd/apache-maven-3.6.0
# PATH=$PATH:$MAVEN_HOME/bin
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
#tmp="$GRAALVM_HOME/bin/java -XX:-UseJVMCIClassLoader -cp $pwd/workspace/standaloneboainterpreter/target/standaloneboainterpreter.jar boa.benchmark.truffle.BoaBenchmarkTruffle $pwd/fib30.xmi $itt"
# JAVA_HOME=\"$GRAALVM_HOME\" PATH=\"$JAVA_HOME/bin:$PATH\"
tmp=" mvn -q -Dmaven.repo.local=$PWD/.m2 -f $PWD/workspace/standaloneboainterpreter/pom.xml  clean compile exec:exec -DboaFile=$pwd/fib30.xmi -DittNbr=$itt"
echo $tmp
#RES="$()"
timestamp=$(date +%s)
echo $key > times_$timestamp.log
$(echo $tmp) | tail -n1 >> times_$timestamp.log
cat times_$timestamp.log
