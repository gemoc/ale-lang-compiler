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
if [ ! -f "logo_visitor.jar" ]; then
  echo "File logo_visitor.jar does not exist."
  exit 1
fi

if [ ! -f "logo_revisitor.jar" ]; then
  echo "File logo_revisitor.jar does not exist."
  exit 1
fi

if [ ! -f "logo_interpreter.jar" ]; then
  echo "File logo_interpreter.jar does not exist."
  exit 1
fi

if [ ! -f "logo_truffle.jar" ]; then
  echo "File logo_truffle.jar does not exist."
  exit 1
fi

if [ ! -f "logo_switch.jar" ]; then
  echo "File logo_switch.jar does not exist."
  exit 1
fi

if [ ! -f "boa_visitor.jar" ]; then
  echo "File boa_visitor.jar does not exist."
  exit 1
fi

if [ ! -f "boa_revisitor.jar" ]; then
  echo "File boa_revisitor.jar does not exist."
  exit 1
fi

if [ ! -f "boa_interpreter.jar" ]; then
  echo "File boa_interpreter.jar does not exist."
  exit 1
fi

if [ ! -f "boa_truffle.jar" ]; then
  echo "File boa_truffle.jar does not exist."
  exit 1
fi

if [ ! -f "boa_switch.jar" ]; then
  echo "File boa_switch.jar does not exist."
  exit 1
fi

# Executions:
echo "visitor_graalvm_logo_fractal"
$GRAALVM_HOME/bin/java -jar logo_visitor.jar fractal.xmi $ITERATIONS | tail -n1 > visitor_graalvm_logo_fractal.log

echo "visitor_graalvm_boa_fib20"
$GRAALVM_HOME/bin/java -jar boa_visitor.jar fib20.xmi $ITERATIONS | tail -n1 > visitor_graalvm_boa_fib20.log

echo "visitor_graalvm_boa_fib30"
$GRAALVM_HOME/bin/java -jar boa_visitor.jar fib30.xmi $ITERATIONS | tail -n1 > visitor_graalvm_boa_fib30.log

echo "visitor_java8_logo_fractal"
$JAVA8_HOME/bin/java -jar logo_visitor.jar fractal.xmi $ITERATIONS | tail -n1 > visitor_java8_logo_fractal.log

echo "visitor_java8_boa_fib20"
$JAVA8_HOME/bin/java -jar boa_visitor.jar fib20.xmi $ITERATIONS | tail -n1 > visitor_java8_boa_fib20.log

echo "visitor_java8_boa_fib30"
$JAVA8_HOME/bin/java -jar boa_visitor.jar fib30.xmi $ITERATIONS | tail -n1 > visitor_java8_boa_fib30.log

echo "visitor_openj9_logo_fractal"
$OPENJ9_HOME/bin/java -jar logo_visitor.jar fractal.xmi $ITERATIONS | tail -n1 > visitor_openj9_logo_fractal.log

echo "visitor_openj9_boa_fib20"
$OPENJ9_HOME/bin/java -jar boa_visitor.jar fib20.xmi $ITERATIONS | tail -n1 > visitor_openj9_boa_fib20.log

echo "visitor_openj9_boa_fib30"
$OPENJ9_HOME/bin/java -jar boa_visitor.jar fib30.xmi $ITERATIONS | tail -n1 > visitor_openj9_boa_fib30.log

echo "revisitor_graalvm_logo_fractal"
$GRAALVM_HOME/bin/java -jar logo_revisitor.jar fractal.xmi $ITERATIONS | tail -n1 > revisitor_graalvm_logo_fractal.log

echo "revisitor_graalvm_boa_fib20"
$GRAALVM_HOME/bin/java -jar boa_revisitor.jar fib20.xmi $ITERATIONS | tail -n1 > revisitor_graalvm_boa_fib20.log

echo "revisitor_graalvm_boa_fib30"
$GRAALVM_HOME/bin/java -jar boa_revisitor.jar fib30.xmi $ITERATIONS | tail -n1 > revisitor_graalvm_boa_fib30.log

echo "revisitor_java8_logo_fractal"
$JAVA8_HOME/bin/java -jar logo_revisitor.jar fractal.xmi $ITERATIONS | tail -n1 > revisitor_java8_logo_fractal.log

echo "revisitor_java8_boa_fib20"
$JAVA8_HOME/bin/java -jar boa_revisitor.jar fib20.xmi $ITERATIONS | tail -n1 > revisitor_java8_boa_fib20.log

echo "revisitor_java8_boa_fib30"
$JAVA8_HOME/bin/java -jar boa_revisitor.jar fib30.xmi $ITERATIONS | tail -n1 > revisitor_java8_boa_fib30.log

echo "revisitor_openj9_logo_fractal"
$OPENJ9_HOME/bin/java -jar logo_revisitor.jar fractal.xmi $ITERATIONS | tail -n1 > revisitor_openj9_logo_fractal.log

echo "revisitor_openj9_boa_fib20"
$OPENJ9_HOME/bin/java -jar boa_revisitor.jar fib20.xmi $ITERATIONS | tail -n1 > revisitor_openj9_boa_fib20.log

echo "revisitor_openj9_boa_fib30"
$OPENJ9_HOME/bin/java -jar boa_revisitor.jar fib30.xmi $ITERATIONS | tail -n1 > revisitor_openj9_boa_fib30.log

echo "interpreter_graalvm_logo_fractal"
$GRAALVM_HOME/bin/java -jar logo_interpreter.jar fractal.xmi $ITERATIONS | tail -n1 > interpreter_graalvm_logo_fractal.log

echo "interpreter_graalvm_boa_fib20"
$GRAALVM_HOME/bin/java -jar boa_interpreter.jar fib20.xmi $ITERATIONS | tail -n1 > interpreter_graalvm_boa_fib20.log

echo "interpreter_graalvm_boa_fib30"
$GRAALVM_HOME/bin/java -jar boa_interpreter.jar fib30.xmi $ITERATIONS | tail -n1 > interpreter_graalvm_boa_fib30.log

echo "interpreter_java8_logo_fractal"
$JAVA8_HOME/bin/java -jar logo_interpreter.jar fractal.xmi $ITERATIONS | tail -n1 > interpreter_java8_logo_fractal.log

echo "interpreter_java8_boa_fib20"
$JAVA8_HOME/bin/java -jar boa_interpreter.jar fib20.xmi $ITERATIONS | tail -n1 > interpreter_java8_boa_fib20.log

echo "interpreter_java8_boa_fib30"
$JAVA8_HOME/bin/java -jar boa_interpreter.jar fib30.xmi $ITERATIONS | tail -n1 > interpreter_java8_boa_fib30.log

echo "interpreter_openj9_logo_fractal"
$OPENJ9_HOME/bin/java -jar logo_interpreter.jar fractal.xmi $ITERATIONS | tail -n1 > interpreter_openj9_logo_fractal.log

echo "interpreter_openj9_boa_fib20"
$OPENJ9_HOME/bin/java -jar boa_interpreter.jar fib20.xmi $ITERATIONS | tail -n1 > interpreter_openj9_boa_fib20.log

echo "interpreter_openj9_boa_fib30"
$OPENJ9_HOME/bin/java -jar boa_interpreter.jar fib30.xmi $ITERATIONS | tail -n1 > interpreter_openj9_boa_fib30.log

echo "switch_graalvm_logo_fractal"
$GRAALVM_HOME/bin/java -jar logo_switch.jar fractal.xmi $ITERATIONS | tail -n1 > switch_graalvm_logo_fractal.log

echo "switch_graalvm_boa_fib20"
$GRAALVM_HOME/bin/java -jar boa_switch.jar fib20.xmi $ITERATIONS | tail -n1 > switch_graalvm_boa_fib20.log

echo "switch_graalvm_boa_fib30"
$GRAALVM_HOME/bin/java -jar boa_switch.jar fib30.xmi $ITERATIONS | tail -n1 > switch_graalvm_boa_fib30.log

echo "switch_java8_logo_fractal"
$JAVA8_HOME/bin/java -jar logo_switch.jar fractal.xmi $ITERATIONS | tail -n1 > switch_java8_logo_fractal.log

echo "switch_java8_boa_fib20"
$JAVA8_HOME/bin/java -jar boa_switch.jar fib20.xmi $ITERATIONS | tail -n1 > switch_java8_boa_fib20.log

echo "switch_java8_boa_fib30"
$JAVA8_HOME/bin/java -jar boa_switch.jar fib30.xmi $ITERATIONS | tail -n1 > switch_java8_boa_fib30.log

echo "switch_openj9_logo_fractal"
$OPENJ9_HOME/bin/java -jar logo_switch.jar fractal.xmi $ITERATIONS | tail -n1 > switch_openj9_logo_fractal.log

echo "switch_openj9_boa_fib20"
$OPENJ9_HOME/bin/java -jar boa_switch.jar fib20.xmi $ITERATIONS | tail -n1 > switch_openj9_boa_fib20.log

echo "switch_openj9_boa_fib30"
$OPENJ9_HOME/bin/java -jar boa_switch.jar fib30.xmi $ITERATIONS | tail -n1 > switch_openj9_boa_fib30.log

echo "truffle_graalvmtruffle_logo_fractal"
$GRAALVM_HOME/bin/java -XX:-UseJVMCIClassLoader -jar logo_truffle.jar fractal.xmi $ITERATIONS | tail -n1 > truffle_graalvmtruffle_logo_fractal.log

echo "truffle_graalvmtruffle_boa_fib20"
$GRAALVM_HOME/bin/java -XX:-UseJVMCIClassLoader -jar boa_truffle.jar fib20.xmi $ITERATIONS | tail -n1 > truffle_graalvmtruffle_boa_fib20.log

echo "truffle_graalvmtruffle_boa_fib30"
$GRAALVM_HOME/bin/java -XX:-UseJVMCIClassLoader -jar boa_truffle.jar fib30.xmi $ITERATIONS | tail -n1 > truffle_graalvmtruffle_boa_fib30.log

# Total executions 19500
echo -n "visitor_graalvm_logo_fractal="
tail -n1 visitor_graalvm_logo_fractal.log

echo -n "visitor_graalvm_boa_fib20="
tail -n1 visitor_graalvm_boa_fib20.log

echo -n "visitor_graalvm_boa_fib30="
tail -n1 visitor_graalvm_boa_fib30.log

echo -n "visitor_java8_logo_fractal="
tail -n1 visitor_java8_logo_fractal.log

echo -n "visitor_java8_boa_fib20="
tail -n1 visitor_java8_boa_fib20.log

echo -n "visitor_java8_boa_fib30="
tail -n1 visitor_java8_boa_fib30.log

echo -n "visitor_openj9_logo_fractal="
tail -n1 visitor_openj9_logo_fractal.log

echo -n "visitor_openj9_boa_fib20="
tail -n1 visitor_openj9_boa_fib20.log

echo -n "visitor_openj9_boa_fib30="
tail -n1 visitor_openj9_boa_fib30.log

echo -n "revisitor_graalvm_logo_fractal="
tail -n1 revisitor_graalvm_logo_fractal.log

echo -n "revisitor_graalvm_boa_fib20="
tail -n1 revisitor_graalvm_boa_fib20.log

echo -n "revisitor_graalvm_boa_fib30="
tail -n1 revisitor_graalvm_boa_fib30.log

echo -n "revisitor_java8_logo_fractal="
tail -n1 revisitor_java8_logo_fractal.log

echo -n "revisitor_java8_boa_fib20="
tail -n1 revisitor_java8_boa_fib20.log

echo -n "revisitor_java8_boa_fib30="
tail -n1 revisitor_java8_boa_fib30.log

echo -n "revisitor_openj9_logo_fractal="
tail -n1 revisitor_openj9_logo_fractal.log

echo -n "revisitor_openj9_boa_fib20="
tail -n1 revisitor_openj9_boa_fib20.log

echo -n "revisitor_openj9_boa_fib30="
tail -n1 revisitor_openj9_boa_fib30.log

echo -n "interpreter_graalvm_logo_fractal="
tail -n1 interpreter_graalvm_logo_fractal.log

echo -n "interpreter_graalvm_boa_fib20="
tail -n1 interpreter_graalvm_boa_fib20.log

echo -n "interpreter_graalvm_boa_fib30="
tail -n1 interpreter_graalvm_boa_fib30.log

echo -n "interpreter_java8_logo_fractal="
tail -n1 interpreter_java8_logo_fractal.log

echo -n "interpreter_java8_boa_fib20="
tail -n1 interpreter_java8_boa_fib20.log

echo -n "interpreter_java8_boa_fib30="
tail -n1 interpreter_java8_boa_fib30.log

echo -n "interpreter_openj9_logo_fractal="
tail -n1 interpreter_openj9_logo_fractal.log

echo -n "interpreter_openj9_boa_fib20="
tail -n1 interpreter_openj9_boa_fib20.log

echo -n "interpreter_openj9_boa_fib30="
tail -n1 interpreter_openj9_boa_fib30.log

echo -n "switch_graalvm_logo_fractal="
tail -n1 switch_graalvm_logo_fractal.log

echo -n "switch_graalvm_boa_fib20="
tail -n1 switch_graalvm_boa_fib20.log

echo -n "switch_graalvm_boa_fib30="
tail -n1 switch_graalvm_boa_fib30.log

echo -n "switch_java8_logo_fractal="
tail -n1 switch_java8_logo_fractal.log

echo -n "switch_java8_boa_fib20="
tail -n1 switch_java8_boa_fib20.log

echo -n "switch_java8_boa_fib30="
tail -n1 switch_java8_boa_fib30.log

echo -n "switch_openj9_logo_fractal="
tail -n1 switch_openj9_logo_fractal.log

echo -n "switch_openj9_boa_fib20="
tail -n1 switch_openj9_boa_fib20.log

echo -n "switch_openj9_boa_fib30="
tail -n1 switch_openj9_boa_fib30.log

echo -n "truffle_graalvmtruffle_logo_fractal="
tail -n1 truffle_graalvmtruffle_logo_fractal.log

echo -n "truffle_graalvmtruffle_boa_fib20="
tail -n1 truffle_graalvmtruffle_boa_fib20.log

echo -n "truffle_graalvmtruffle_boa_fib30="
tail -n1 truffle_graalvmtruffle_boa_fib30.log

echo "results = {\"visitor_graalvm_logo_fractal\": visitor_graalvm_logo_fractal , \"visitor_graalvm_boa_fib20\": visitor_graalvm_boa_fib20 , \"visitor_graalvm_boa_fib30\": visitor_graalvm_boa_fib30 , \"visitor_java8_logo_fractal\": visitor_java8_logo_fractal , \"visitor_java8_boa_fib20\": visitor_java8_boa_fib20 , \"visitor_java8_boa_fib30\": visitor_java8_boa_fib30 , \"visitor_openj9_logo_fractal\": visitor_openj9_logo_fractal , \"visitor_openj9_boa_fib20\": visitor_openj9_boa_fib20 , \"visitor_openj9_boa_fib30\": visitor_openj9_boa_fib30 , \"revisitor_graalvm_logo_fractal\": revisitor_graalvm_logo_fractal , \"revisitor_graalvm_boa_fib20\": revisitor_graalvm_boa_fib20 , \"revisitor_graalvm_boa_fib30\": revisitor_graalvm_boa_fib30 , \"revisitor_java8_logo_fractal\": revisitor_java8_logo_fractal , \"revisitor_java8_boa_fib20\": revisitor_java8_boa_fib20 , \"revisitor_java8_boa_fib30\": revisitor_java8_boa_fib30 , \"revisitor_openj9_logo_fractal\": revisitor_openj9_logo_fractal , \"revisitor_openj9_boa_fib20\": revisitor_openj9_boa_fib20 , \"revisitor_openj9_boa_fib30\": revisitor_openj9_boa_fib30 , \"interpreter_graalvm_logo_fractal\": interpreter_graalvm_logo_fractal , \"interpreter_graalvm_boa_fib20\": interpreter_graalvm_boa_fib20 , \"interpreter_graalvm_boa_fib30\": interpreter_graalvm_boa_fib30 , \"interpreter_java8_logo_fractal\": interpreter_java8_logo_fractal , \"interpreter_java8_boa_fib20\": interpreter_java8_boa_fib20 , \"interpreter_java8_boa_fib30\": interpreter_java8_boa_fib30 , \"interpreter_openj9_logo_fractal\": interpreter_openj9_logo_fractal , \"interpreter_openj9_boa_fib20\": interpreter_openj9_boa_fib20 , \"interpreter_openj9_boa_fib30\": interpreter_openj9_boa_fib30 , \"switch_graalvm_logo_fractal\": switch_graalvm_logo_fractal , \"switch_graalvm_boa_fib20\": switch_graalvm_boa_fib20 , \"switch_graalvm_boa_fib30\": switch_graalvm_boa_fib30 , \"switch_java8_logo_fractal\": switch_java8_logo_fractal , \"switch_java8_boa_fib20\": switch_java8_boa_fib20 , \"switch_java8_boa_fib30\": switch_java8_boa_fib30 , \"switch_openj9_logo_fractal\": switch_openj9_logo_fractal , \"switch_openj9_boa_fib20\": switch_openj9_boa_fib20 , \"switch_openj9_boa_fib30\": switch_openj9_boa_fib30 , \"truffle_graalvmtruffle_logo_fractal\": truffle_graalvmtruffle_logo_fractal , \"truffle_graalvmtruffle_boa_fib20\": truffle_graalvmtruffle_boa_fib20 , \"truffle_graalvmtruffle_boa_fib30\": truffle_graalvmtruffle_boa_fib30}"
