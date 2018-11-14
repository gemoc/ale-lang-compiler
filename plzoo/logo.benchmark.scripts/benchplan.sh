JAVA8_HOME=/usr/lib/jvm/java-8-oracle
GRAALVM_HOME=$HOME/jdk/graalvm-ee-1.0.0-rc7
# Jar names:
if [ ! -f "logo-visitor.jar" ]; then
  echo "File logo-visitor.jar does not exist."
  exit 1
fi

if [ ! -f "logo-revisitor.jar" ]; then
  echo "File logo-revisitor.jar does not exist."
  exit 1
fi

if [ ! -f "logo-interpreter.jar" ]; then
  echo "File logo-interpreter.jar does not exist."
  exit 1
fi

if [ ! -f "logo-truffle.jar" ]; then
  echo "File logo-truffle.jar does not exist."
  exit 1
fi

# Executions:
$GRAALVM_HOME/bin/java -jar logo-visitor.jar fractal.xmi 500  > visitor-graalvm-logo-fractal.log
$JAVA8_HOME/bin/java -jar logo-visitor.jar fractal.xmi 500  > visitor-java8-logo-fractal.log
$GRAALVM_HOME/bin/java -jar logo-revisitor.jar fractal.xmi 500  > revisitor-graalvm-logo-fractal.log
$JAVA8_HOME/bin/java -jar logo-revisitor.jar fractal.xmi 500  > revisitor-java8-logo-fractal.log
$GRAALVM_HOME/bin/java -jar logo-interpreter.jar fractal.xmi 500  > interpreter-graalvm-logo-fractal.log
$JAVA8_HOME/bin/java -jar logo-interpreter.jar fractal.xmi 500  > interpreter-java8-logo-fractal.log
$GRAALVM_HOME/bin/java -XX:-UseJVMCIClassLoader -jar logo-truffle.jar fractal.xmi 500  > truffle-graalvmtruffle-logo-fractal.log
# Total executions 3500
