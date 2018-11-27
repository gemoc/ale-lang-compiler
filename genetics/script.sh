GRAALVM_HOME=$PWD/graalvm-ee-1.0.0-rc9
MAVEN_HOME=$PWD/apache-maven-3.6.0
PATH=$PATH:$MAVEN_HOME/bin
pwd=$PWD


for i in $(seq 0 7)
do
  echo $i
  cd ./workspace/standaloneboainterpreter
  java -jar ../../genetic.jar src/boa_exec.ale $i
  cd $pwd
  ./app/eclipse/eclipse
  mvn -f workspace/standaloneboainterpreter/pom.xml clean package
  cd workspace
  git add .
  git commit -m "version $i"
  md5sum standaloneboainterpreter/target/standaloneboainterpreter.jar
  cd $pwd
  tmp="$GRAALVM_HOME/bin/java -XX:-UseJVMCIClassLoader -cp $pwd/workspace/standaloneboainterpreter/target/standaloneboainterpreter.jar boa.benchmark.truffle.BoaBenchmarkTruffle $pwd/fib30.xmi 1"
  echo $tmp
  $(echo $tmp) | tail -n1 > times_$i.log
done
