if [ -z ${JAVA8_HOME+x} ]; then JAVA8_HOME=$PWD/java-8-oracle; fi
if [ -z ${GRAALVM_HOME+x} ]; then GRAALVM_HOME=$PWD/graalvm-ee-1.0.0-rc9; fi
if [ -z ${OPENJ9_HOME+x} ]; then OPENJ9_HOME=$PWD/openj9-9-0.11.0; fi
if [ -z ${ITERATIONS+x} ]; then ITERATIONS=100; fi
if [ ! -d "$JAVA8_HOME" ]; then echo JAVA8_HOME=$JAVA8_HOME does not exist; exit 1 ; fi
echo SUMMARY:
echo -n JAVA8_HOME=; echo $JAVA8_HOME
echo -n GRAALVM_HOME=; echo $GRAALVM_HOME
echo -n OPENJ9_HOME=; echo $OPENJ9_HOME
echo -n ITERATIONS=; echo $ITERATIONS
# Jar names:
if [ ! -f "imp_interpreter.jar" ]; then
  echo "File imp_interpreter.jar does not exist."
  exit 1
fi

if [ ! -f "imp_truffle.jar" ]; then
  echo "File imp_truffle.jar does not exist."
  exit 1
fi

# Executions:
echo "interpreter_graalvm_imp_bubble"
$GRAALVM_HOME/bin/java -jar imp_interpreter.jar bubble.xmi $ITERATIONS | tail -n1 > interpreter_graalvm_imp_bubble.log

echo "truffle_graalvmtruffle_imp_bubble"
$GRAALVM_HOME/bin/java -XX:-UseJVMCIClassLoader -jar imp_truffle.jar bubble.xmi $ITERATIONS | tail -n1 > truffle_graalvmtruffle_imp_bubble.log

# Total executions 1000
echo -n "interpreter_graalvm_imp_bubble="
tail -n1 interpreter_graalvm_imp_bubble.log

echo -n "truffle_graalvmtruffle_imp_bubble="
tail -n1 truffle_graalvmtruffle_imp_bubble.log

echo "results = {\"interpreter_graalvm_imp_bubble\": interpreter_graalvm_imp_bubble , \"truffle_graalvmtruffle_imp_bubble\": truffle_graalvmtruffle_imp_bubble}"

