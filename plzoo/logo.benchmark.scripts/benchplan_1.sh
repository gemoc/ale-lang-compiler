JAVA8_HOME=$PWD/java-8-oracle
GRAALVM_HOME=$PWD/graalvm-ee-1.0.0-rc7
OPENJ9_HOME=$PWD/openj9-9-0.11.0
ITERATIONS=1
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

# Executions:
#echo "visitor_graalvm_logo_fractal"
#$GRAALVM_HOME/bin/java -jar logo_visitor.jar fractal.xmi $ITERATIONS | tail -n1 > visitor_graalvm_logo_fractal.log

#echo "visitor_java8_logo_fractal"
#$JAVA8_HOME/bin/java -jar logo_visitor.jar fractal.xmi $ITERATIONS | tail -n1 > visitor_java8_logo_fractal.log

#echo "visitor_openj9_logo_fractal"
#$OPENJ9_HOME/bin/java -jar logo_visitor.jar fractal.xmi $ITERATIONS | tail -n1 > visitor_openj9_logo_fractal.log

#echo "revisitor_graalvm_logo_fractal"
#$GRAALVM_HOME/bin/java -jar logo_revisitor.jar fractal.xmi $ITERATIONS | tail -n1 > revisitor_graalvm_logo_fractal.log

#echo "revisitor_java8_logo_fractal"
#$JAVA8_HOME/bin/java -jar logo_revisitor.jar fractal.xmi $ITERATIONS | tail -n1 > revisitor_java8_logo_fractal.log

#echo "revisitor_openj9_logo_fractal"
#$OPENJ9_HOME/bin/java -jar logo_revisitor.jar fractal.xmi $ITERATIONS | tail -n1 > revisitor_openj9_logo_fractal.log

echo "interpreter_graalvm_logo_fractal"
$GRAALVM_HOME/bin/java -jar logo_interpreter.jar fractal.xmi $ITERATIONS | tail -n1 > interpreter_graalvm_logo_fractal.log

echo "interpreter_java8_logo_fractal"
$JAVA8_HOME/bin/java -jar logo_interpreter.jar fractal.xmi $ITERATIONS | tail -n1 > interpreter_java8_logo_fractal.log

echo "interpreter_openj9_logo_fractal"
$OPENJ9_HOME/bin/java -jar logo_interpreter.jar fractal.xmi $ITERATIONS | tail -n1 > interpreter_openj9_logo_fractal.log

echo "truffle_graalvmtruffle_logo_fractal"
$GRAALVM_HOME/bin/java -XX:-UseJVMCIClassLoader -jar logo_truffle.jar fractal.xmi $ITERATIONS | tail -n1 > truffle_graalvmtruffle_logo_fractal.log

# Total executions 5000
#echo -n "visitor_graalvm_logo_fractal="
#tail -n1 visitor_graalvm_logo_fractal.log

#echo -n "visitor_java8_logo_fractal="
#tail -n1 visitor_java8_logo_fractal.log

#echo -n "visitor_openj9_logo_fractal="
#tail -n1 visitor_openj9_logo_fractal.log

#echo -n "revisitor_graalvm_logo_fractal="
#tail -n1 revisitor_graalvm_logo_fractal.log

#echo -n "revisitor_java8_logo_fractal="
#tail -n1 revisitor_java8_logo_fractal.log

#echo -n "revisitor_openj9_logo_fractal="
#tail -n1 revisitor_openj9_logo_fractal.log

echo -n "interpreter_graalvm_logo_fractal="
tail -n1 interpreter_graalvm_logo_fractal.log

echo -n "interpreter_java8_logo_fractal="
tail -n1 interpreter_java8_logo_fractal.log

echo -n "interpreter_openj9_logo_fractal="
tail -n1 interpreter_openj9_logo_fractal.log

echo -n "truffle_graalvmtruffle_logo_fractal="
tail -n1 truffle_graalvmtruffle_logo_fractal.log

echo "results = { \"interpreter_graalvm_logo_fractal\": interpreter_graalvm_logo_fractal , #\"interpreter_java8_logo_fractal\": interpreter_java8_logo_fractal , \"interpreter_openj9_logo_fractal\": interpreter_openj9_logo_fractal , \"truffle_graalvmtruffle_logo_fractal\": truffle_graalvmtruffle_logo_fractal}"
