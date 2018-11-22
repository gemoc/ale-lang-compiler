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
if [ ! -f "logo_interpreter.jar" ]; then
  echo "File logo_interpreter.jar does not exist."
  exit 1
fi

if [ ! -f "logo_truffle.jar" ]; then
  echo "File logo_truffle.jar does not exist."
  exit 1
fi

if [ ! -f "logoalldispatch_truffle.jar" ]; then
  echo "File logoalldispatch_truffle.jar does not exist."
  exit 1
fi

# Executions:
echo "interpreter_graalvm_logo_fractal"
$GRAALVM_HOME/bin/java -jar logo_interpreter.jar fractal.xmi $ITERATIONS | tail -n1 > interpreter_graalvm_logo_fractal.log

echo "truffle_graalvmtruffle_logo_fractal"
$GRAALVM_HOME/bin/java -XX:-UseJVMCIClassLoader -jar logo_truffle.jar fractal.xmi $ITERATIONS | tail -n1 > truffle_graalvmtruffle_logo_fractal.log

echo "truffle_graalvmtruffle_logoalldispatch_fractal"
$GRAALVM_HOME/bin/java -XX:-UseJVMCIClassLoader -jar logoalldispatch_truffle.jar fractal.xmi $ITERATIONS | tail -n1 > truffle_graalvmtruffle_logoalldispatch_fractal.log

# Total executions 2000
echo -n "interpreter_graalvm_logo_fractal="
tail -n1 interpreter_graalvm_logo_fractal.log

echo -n "truffle_graalvmtruffle_logo_fractal="
tail -n1 truffle_graalvmtruffle_logo_fractal.log

echo -n "truffle_graalvmtruffle_logoalldispatch_fractal="
tail -n1 truffle_graalvmtruffle_logoalldispatch_fractal.log

echo "results = {\"interpreter_graalvm_logo_fractal\": interpreter_graalvm_logo_fractal , \"interpreter_graalvm_logoalldispatch_fractal\": interpreter_graalvm_logoalldispatch_fractal , \"truffle_graalvmtruffle_logo_fractal\": truffle_graalvmtruffle_logo_fractal , \"truffle_graalvmtruffle_logoalldispatch_fractal\": truffle_graalvmtruffle_logoalldispatch_fractal}"
