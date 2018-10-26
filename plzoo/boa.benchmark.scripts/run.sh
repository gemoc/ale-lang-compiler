JAVA8_HOME=/usr/lib/jvm/java-8-oracle
GRAALVM_HOME=$HOME/jdk/graalvm-ee-1.0.0-rc7

INTERPRETER_JAR=compiled-interpreter-boa.jar
REVISITOR_JAR=compiled-revisitor-boa.jar

$JAVA8_HOME/bin/java   -jar $INTERPRETER_JAR  > java8_interpreter.log
$JAVA8_HOME/bin/java   -jar $REVISITOR_JAR    > java8_revisitor.log
$GRAALVM_HOME/bin/java -jar $INTERPRETER_JAR  > graalvm_interpreter.log
$GRAALVM_HOME/bin/java -jar $REVISITOR_JAR    > graalvm_revisitor.log

echo "java8_interpreter = " $(tail -n 1 java8_interpreter.log)
echo "java8_revisitor = " $(tail -n 1 java8_revisitor.log)
echo "graalvm_interpreter = " $(tail -n 1 graalvm_interpreter.log)
echo "graalvm_revisitor = " $(tail -n 1 graalvm_revisitor.log)
