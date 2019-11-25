JAVA8_HOME=/usr/lib/jvm/java-8-oracle
GRAALVM_HOME=$HOME/jdk/graalvm-ee-1.0.0-rc7
# Jar names:
if [ ! -f "boa-visitor.jar" ]; then
  echo "File boa-visitor.jar does not exist."
  exit 1
fi

if [ ! -f "boa-revisitor.jar" ]; then
  echo "File boa-revisitor.jar does not exist."
  exit 1
fi

if [ ! -f "boa-interpreter.jar" ]; then
  echo "File boa-interpreter.jar does not exist."
  exit 1
fi

# Executions:
$GRAALVM_HOME/bin/java -jar boa-visitor.jar fib10.xmi 500  > visitor-graalvm-boa-fib10.log
$GRAALVM_HOME/bin/java -jar boa-visitor.jar fib15.xmi 500  > visitor-graalvm-boa-fib15.log
$JAVA8_HOME/bin/java -jar boa-visitor.jar fib10.xmi 500  > visitor-java8-boa-fib10.log
$JAVA8_HOME/bin/java -jar boa-visitor.jar fib15.xmi 500  > visitor-java8-boa-fib15.log
$GRAALVM_HOME/bin/java -jar boa-revisitor.jar fib10.xmi 500  > revisitor-graalvm-boa-fib10.log
$GRAALVM_HOME/bin/java -jar boa-revisitor.jar fib15.xmi 500  > revisitor-graalvm-boa-fib15.log
$JAVA8_HOME/bin/java -jar boa-revisitor.jar fib10.xmi 500  > revisitor-java8-boa-fib10.log
$JAVA8_HOME/bin/java -jar boa-revisitor.jar fib15.xmi 500  > revisitor-java8-boa-fib15.log
$GRAALVM_HOME/bin/java -jar boa-interpreter.jar fib10.xmi 500  > interpreter-graalvm-boa-fib10.log
$GRAALVM_HOME/bin/java -jar boa-interpreter.jar fib15.xmi 500  > interpreter-graalvm-boa-fib15.log
$JAVA8_HOME/bin/java -jar boa-interpreter.jar fib10.xmi 500  > interpreter-java8-boa-fib10.log
$JAVA8_HOME/bin/java -jar boa-interpreter.jar fib15.xmi 500  > interpreter-java8-boa-fib15.log
