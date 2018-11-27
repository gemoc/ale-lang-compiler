GRAALVM_HOME=$PWD/graalvm-ee-1.0.0-rc9
MAVEN_HOME=$PWD/apache-maven-3.6.0
PATH=$PATH:$MAVEN_HOME/bin


for i in $(seq 0 7)
do
  echo $i
  cd ./workspace/standaloneboainterpreter
  java -jar ../../genetic.jar src/boa_exec.ale $i
  cd ../../
  ./app/eclipse/eclipse
  mvn -f workspace/standaloneboainterpreter/pom.xml package
done
