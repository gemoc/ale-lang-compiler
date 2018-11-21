if [ -z ${JAVA8_HOME+x} ]; then JAVA8_HOME=$PWD/java-8-oracle; fi
if [ -z ${GRAALVM_HOME+x} ]; then GRAALVM_HOME=$PWD/graalvm-ee-1.0.0-rc7; fi
if [ -z ${OPENJ9_HOME+x} ]; then OPENJ9_HOME=$PWD/openj9-9-0.11.0; fi
if [ -z ${ITERATIONS+x} ]; then ITERATIONS=100; fi
if [ ! -d "$JAVA8_HOME" ]; then echo JAVA8_HOME=$JAVA8_HOME does not exist; exit 1 ; fi
echo SUMMARY:
echo -n JAVA8_HOME=; echo $JAVA8_HOME
echo -n GRAALVM_HOME=; echo $GRAALVM_HOME
echo -n OPENJ9_HOME=; echo $OPENJ9_HOME
echo -n ITERATIONS=; echo $ITERATIONS
# Jar names:
if [ ! -f "boa_interpreter.jar" ]; then
  echo "File boa_interpreter.jar does not exist."
  exit 1
fi

if [ ! -f "boa_truffle.jar" ]; then
  echo "File boa_truffle.jar does not exist."
  exit 1
fi

if [ ! -f "boaalldispatch_truffle.jar" ]; then
  echo "File boaalldispatch_truffle.jar does not exist."
  exit 1
fi

# Executions:
echo "interpreter_graalvm_boa_fib20"
$GRAALVM_HOME/bin/java -jar boa_interpreter.jar fib20.xmi $ITERATIONS | tail -n1 > interpreter_graalvm_boa_fib20.log

echo "interpreter_graalvm_boa_fib30"
$GRAALVM_HOME/bin/java -jar boa_interpreter.jar fib30.xmi $ITERATIONS | tail -n1 > interpreter_graalvm_boa_fib30.log


echo "truffle_graalvmtruffle_boa_fib20"
$GRAALVM_HOME/bin/java -XX:-UseJVMCIClassLoader -jar boa_truffle.jar fib20.xmi $ITERATIONS | tail -n1 > truffle_graalvmtruffle_boa_fib20.log

echo "truffle_graalvmtruffle_boa_fib30"
$GRAALVM_HOME/bin/java -XX:-UseJVMCIClassLoader -jar boa_truffle.jar fib30.xmi $ITERATIONS | tail -n1 > truffle_graalvmtruffle_boa_fib30.log

echo "truffle_graalvmtruffle_boaalldispatch_fib20"
$GRAALVM_HOME/bin/java -XX:-UseJVMCIClassLoader -jar boaalldispatch_truffle.jar fib20.xmi $ITERATIONS | tail -n1 > truffle_graalvmtruffle_boaalldispatch_fib20.log

echo "truffle_graalvmtruffle_boaalldispatch_fib30"
$GRAALVM_HOME/bin/java -XX:-UseJVMCIClassLoader -jar boaalldispatch_truffle.jar fib30.xmi $ITERATIONS | tail -n1 > truffle_graalvmtruffle_boaalldispatch_fib30.log

# Total executions 4000
echo -n "interpreter_graalvm_boa_fib20="
tail -n1 interpreter_graalvm_boa_fib20.log

echo -n "interpreter_graalvm_boa_fib30="
tail -n1 interpreter_graalvm_boa_fib30.log

echo -n "truffle_graalvmtruffle_boa_fib20="
tail -n1 truffle_graalvmtruffle_boa_fib20.log

echo -n "truffle_graalvmtruffle_boa_fib30="
tail -n1 truffle_graalvmtruffle_boa_fib30.log

echo -n "truffle_graalvmtruffle_boaalldispatch_fib20="
tail -n1 truffle_graalvmtruffle_boaalldispatch_fib20.log

echo -n "truffle_graalvmtruffle_boaalldispatch_fib30="
tail -n1 truffle_graalvmtruffle_boaalldispatch_fib30.log

echo "results = {\"interpreter_graalvm_boa_fib20\": interpreter_graalvm_boa_fib20 , \"interpreter_graalvm_boa_fib30\": interpreter_graalvm_boa_fib30 , \"interpreter_graalvm_boaalldispatch_fib20\": interpreter_graalvm_boaalldispatch_fib20 , \"interpreter_graalvm_boaalldispatch_fib30\": interpreter_graalvm_boaalldispatch_fib30 , \"truffle_graalvmtruffle_boa_fib20\": truffle_graalvmtruffle_boa_fib20 , \"truffle_graalvmtruffle_boa_fib30\": truffle_graalvmtruffle_boa_fib30 , \"truffle_graalvmtruffle_boaalldispatch_fib20\": truffle_graalvmtruffle_boaalldispatch_fib20 , \"truffle_graalvmtruffle_boaalldispatch_fib30\": truffle_graalvmtruffle_boaalldispatch_fib30}"
