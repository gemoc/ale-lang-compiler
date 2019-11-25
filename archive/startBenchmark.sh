#!/usr/bin/env bash
mvn clean install

######################################
##          BOA  BENCHMARK          ##
######################################

## INTERPRETER
java -jar languages/boa/boa.lang.interpreter.benchmark/target/benchmarks.jar -wi 10 -i 50 -rf json -rff boa_interpreter_graal_ce.json -jvm benchmark_jvm/graal_ce/bin/java
java -jar languages/boa/boa.lang.interpreter.benchmark/target/benchmarks.jar -wi 10 -i 50 -rf json -rff boa_interpreter_graal_ee.json -jvm benchmark_jvm/graal_ee/bin/java
java -jar languages/boa/boa.lang.interpreter.benchmark/target/benchmarks.jar -wi 10 -i 50 -rf json -rff boa_interpreter_graalj9_11.json -jvm benchmark_jvm/openj9_11/bin/java
java -jar languages/boa/boa.lang.interpreter.benchmark/target/benchmarks.jar -wi 10 -i 50 -rf json -rff boa_interpreter_graalj9_12.json -jvm benchmark_jvm/openj9_12/bin/java
java -jar languages/boa/boa.lang.interpreter.benchmark/target/benchmarks.jar -wi 10 -i 50 -rf json -rff boa_interpreter_graalj9_8.json -jvm benchmark_jvm/openj9_8/bin/java
java -jar languages/boa/boa.lang.interpreter.benchmark/target/benchmarks.jar -wi 10 -i 50 -rf json -rff boa_interpreter_graaljdk_11.json -jvm benchmark_jvm/openjdk_11/bin/java
java -jar languages/boa/boa.lang.interpreter.benchmark/target/benchmarks.jar -wi 10 -i 50 -rf json -rff boa_interpreter_graaljdk_12.json -jvm benchmark_jvm/openjdk_12/bin/java
java -jar languages/boa/boa.lang.interpreter.benchmark/target/benchmarks.jar -wi 10 -i 50 -rf json -rff boa_interpreter_graaljdk_8.json -jvm benchmark_jvm/openjdk_8/bin/java

## VISITOR
java -jar languages/boa/boa.lang.visitor.benchmark/target/benchmarks.jar -wi 10 -i 50 -rf json -rff boa_visitor_graal_ce.json -jvm benchmark_jvm/graal_ce/bin/java
java -jar languages/boa/boa.lang.visitor.benchmark/target/benchmarks.jar -wi 10 -i 50 -rf json -rff boa_visitor_graal_ee.json -jvm benchmark_jvm/graal_ee/bin/java
java -jar languages/boa/boa.lang.visitor.benchmark/target/benchmarks.jar -wi 10 -i 50 -rf json -rff boa_visitor_graalj9_11.json -jvm benchmark_jvm/openj9_11/bin/java
java -jar languages/boa/boa.lang.visitor.benchmark/target/benchmarks.jar -wi 10 -i 50 -rf json -rff boa_visitor_graalj9_12.json -jvm benchmark_jvm/openj9_12/bin/java
java -jar languages/boa/boa.lang.visitor.benchmark/target/benchmarks.jar -wi 10 -i 50 -rf json -rff boa_visitor_graalj9_8.json -jvm benchmark_jvm/openj9_8/bin/java
java -jar languages/boa/boa.lang.visitor.benchmark/target/benchmarks.jar -wi 10 -i 50 -rf json -rff boa_visitor_graaljdk_11.json -jvm benchmark_jvm/openjdk_11/bin/java
java -jar languages/boa/boa.lang.visitor.benchmark/target/benchmarks.jar -wi 10 -i 50 -rf json -rff boa_visitor_graaljdk_12.json -jvm benchmark_jvm/openjdk_12/bin/java
java -jar languages/boa/boa.lang.visitor.benchmark/target/benchmarks.jar -wi 10 -i 50 -rf json -rff boa_visitor_graaljdk_8.json -jvm benchmark_jvm/openjdk_8/bin/java

## REVISITOR
java -jar languages/boa/boa.lang.revisitor.benchmark/target/benchmarks.jar -wi 10 -i 50 -rf json -rff boa_revisitor_graal_ce.json -jvm benchmark_jvm/graal_ce/bin/java
java -jar languages/boa/boa.lang.revisitor.benchmark/target/benchmarks.jar -wi 10 -i 50 -rf json -rff boa_revisitor_graal_ee.json -jvm benchmark_jvm/graal_ee/bin/java
java -jar languages/boa/boa.lang.revisitor.benchmark/target/benchmarks.jar -wi 10 -i 50 -rf json -rff boa_revisitor_graalj9_11.json -jvm benchmark_jvm/openj9_11/bin/java
java -jar languages/boa/boa.lang.revisitor.benchmark/target/benchmarks.jar -wi 10 -i 50 -rf json -rff boa_revisitor_graalj9_12.json -jvm benchmark_jvm/openj9_12/bin/java
java -jar languages/boa/boa.lang.revisitor.benchmark/target/benchmarks.jar -wi 10 -i 50 -rf json -rff boa_revisitor_graalj9_8.json -jvm benchmark_jvm/openj9_8/bin/java
java -jar languages/boa/boa.lang.revisitor.benchmark/target/benchmarks.jar -wi 10 -i 50 -rf json -rff boa_revisitor_graaljdk_11.json -jvm benchmark_jvm/openjdk_11/bin/java
java -jar languages/boa/boa.lang.revisitor.benchmark/target/benchmarks.jar -wi 10 -i 50 -rf json -rff boa_revisitor_graaljdk_12.json -jvm benchmark_jvm/openjdk_12/bin/java
java -jar languages/boa/boa.lang.revisitor.benchmark/target/benchmarks.jar -wi 10 -i 50 -rf json -rff boa_revisitor_graaljdk_8.json -jvm benchmark_jvm/openjdk_8/bin/java

## SWITCH
java -jar languages/boa/boa.lang.switch.benchmark/target/benchmarks.jar -wi 10 -i 50 -rf json -rff boa_switch_graal_ce.json -jvm benchmark_jvm/graal_ce/bin/java
java -jar languages/boa/boa.lang.switch.benchmark/target/benchmarks.jar -wi 10 -i 50 -rf json -rff boa_switch_graal_ee.json -jvm benchmark_jvm/graal_ee/bin/java
java -jar languages/boa/boa.lang.switch.benchmark/target/benchmarks.jar -wi 10 -i 50 -rf json -rff boa_switch_graalj9_11.json -jvm benchmark_jvm/openj9_11/bin/java
java -jar languages/boa/boa.lang.switch.benchmark/target/benchmarks.jar -wi 10 -i 50 -rf json -rff boa_switch_graalj9_12.json -jvm benchmark_jvm/openj9_12/bin/java
java -jar languages/boa/boa.lang.switch.benchmark/target/benchmarks.jar -wi 10 -i 50 -rf json -rff boa_switch_graalj9_8.json -jvm benchmark_jvm/openj9_8/bin/java
java -jar languages/boa/boa.lang.switch.benchmark/target/benchmarks.jar -wi 10 -i 50 -rf json -rff boa_switch_graaljdk_11.json -jvm benchmark_jvm/openjdk_11/bin/java
java -jar languages/boa/boa.lang.switch.benchmark/target/benchmarks.jar -wi 10 -i 50 -rf json -rff boa_switch_graaljdk_12.json -jvm benchmark_jvm/openjdk_12/bin/java
java -jar languages/boa/boa.lang.switch.benchmark/target/benchmarks.jar -wi 10 -i 50 -rf json -rff boa_switch_graaljdk_8.json -jvm benchmark_jvm/openjdk_8/bin/java

######################################
##          FSM  BENCHMARK          ##
######################################

## INTERPRETER
java -jar languages/fsm/fsm.lang.interpreter.benchmark/target/benchmarks.jar -wi 10 -i 50 -rf json -rff fsm_interpreter_graal_ce.json -jvm benchmark_jvm/graal_ce/bin/java
java -jar languages/fsm/fsm.lang.interpreter.benchmark/target/benchmarks.jar -wi 10 -i 50 -rf json -rff fsm_interpreter_graal_ee.json -jvm benchmark_jvm/graal_ee/bin/java
java -jar languages/fsm/fsm.lang.interpreter.benchmark/target/benchmarks.jar -wi 10 -i 50 -rf json -rff fsm_interpreter_graalj9_11.json -jvm benchmark_jvm/openj9_11/bin/java
java -jar languages/fsm/fsm.lang.interpreter.benchmark/target/benchmarks.jar -wi 10 -i 50 -rf json -rff fsm_interpreter_graalj9_12.json -jvm benchmark_jvm/openj9_12/bin/java
java -jar languages/fsm/fsm.lang.interpreter.benchmark/target/benchmarks.jar -wi 10 -i 50 -rf json -rff fsm_interpreter_graalj9_8.json -jvm benchmark_jvm/openj9_8/bin/java
java -jar languages/fsm/fsm.lang.interpreter.benchmark/target/benchmarks.jar -wi 10 -i 50 -rf json -rff fsm_interpreter_graaljdk_11.json -jvm benchmark_jvm/openjdk_11/bin/java
java -jar languages/fsm/fsm.lang.interpreter.benchmark/target/benchmarks.jar -wi 10 -i 50 -rf json -rff fsm_interpreter_graaljdk_12.json -jvm benchmark_jvm/openjdk_12/bin/java
java -jar languages/fsm/fsm.lang.interpreter.benchmark/target/benchmarks.jar -wi 10 -i 50 -rf json -rff fsm_interpreter_graaljdk_8.json -jvm benchmark_jvm/openjdk_8/bin/java

## VISITOR
java -jar languages/fsm/fsm.lang.visitor.benchmark/target/benchmarks.jar -wi 10 -i 50 -rf json -rff fsm_visitor_graal_ce.json -jvm benchmark_jvm/graal_ce/bin/java
java -jar languages/fsm/fsm.lang.visitor.benchmark/target/benchmarks.jar -wi 10 -i 50 -rf json -rff fsm_visitor_graal_ee.json -jvm benchmark_jvm/graal_ee/bin/java
java -jar languages/fsm/fsm.lang.visitor.benchmark/target/benchmarks.jar -wi 10 -i 50 -rf json -rff fsm_visitor_graalj9_11.json -jvm benchmark_jvm/openj9_11/bin/java
java -jar languages/fsm/fsm.lang.visitor.benchmark/target/benchmarks.jar -wi 10 -i 50 -rf json -rff fsm_visitor_graalj9_12.json -jvm benchmark_jvm/openj9_12/bin/java
java -jar languages/fsm/fsm.lang.visitor.benchmark/target/benchmarks.jar -wi 10 -i 50 -rf json -rff fsm_visitor_graalj9_8.json -jvm benchmark_jvm/openj9_8/bin/java
java -jar languages/fsm/fsm.lang.visitor.benchmark/target/benchmarks.jar -wi 10 -i 50 -rf json -rff fsm_visitor_graaljdk_11.json -jvm benchmark_jvm/openjdk_11/bin/java
java -jar languages/fsm/fsm.lang.visitor.benchmark/target/benchmarks.jar -wi 10 -i 50 -rf json -rff fsm_visitor_graaljdk_12.json -jvm benchmark_jvm/openjdk_12/bin/java
java -jar languages/fsm/fsm.lang.visitor.benchmark/target/benchmarks.jar -wi 10 -i 50 -rf json -rff fsm_visitor_graaljdk_8.json -jvm benchmark_jvm/openjdk_8/bin/java

## REVISITOR
java -jar languages/fsm/fsm.lang.revisitor.benchmark/target/benchmarks.jar -wi 10 -i 50 -rf json -rff fsm_revisitor_graal_ce.json -jvm benchmark_jvm/graal_ce/bin/java
java -jar languages/fsm/fsm.lang.revisitor.benchmark/target/benchmarks.jar -wi 10 -i 50 -rf json -rff fsm_revisitor_graal_ee.json -jvm benchmark_jvm/graal_ee/bin/java
java -jar languages/fsm/fsm.lang.revisitor.benchmark/target/benchmarks.jar -wi 10 -i 50 -rf json -rff fsm_revisitor_graalj9_11.json -jvm benchmark_jvm/openj9_11/bin/java
java -jar languages/fsm/fsm.lang.revisitor.benchmark/target/benchmarks.jar -wi 10 -i 50 -rf json -rff fsm_revisitor_graalj9_12.json -jvm benchmark_jvm/openj9_12/bin/java
java -jar languages/fsm/fsm.lang.revisitor.benchmark/target/benchmarks.jar -wi 10 -i 50 -rf json -rff fsm_revisitor_graalj9_8.json -jvm benchmark_jvm/openj9_8/bin/java
java -jar languages/fsm/fsm.lang.revisitor.benchmark/target/benchmarks.jar -wi 10 -i 50 -rf json -rff fsm_revisitor_graaljdk_11.json -jvm benchmark_jvm/openjdk_11/bin/java
java -jar languages/fsm/fsm.lang.revisitor.benchmark/target/benchmarks.jar -wi 10 -i 50 -rf json -rff fsm_revisitor_graaljdk_12.json -jvm benchmark_jvm/openjdk_12/bin/java
java -jar languages/fsm/fsm.lang.revisitor.benchmark/target/benchmarks.jar -wi 10 -i 50 -rf json -rff fsm_revisitor_graaljdk_8.json -jvm benchmark_jvm/openjdk_8/bin/java

## SWITCH
java -jar languages/fsm/fsm.lang.switch.benchmark/target/benchmarks.jar -wi 10 -i 50 -rf json -rff fsm_switch_graal_ce.json -jvm benchmark_jvm/graal_ce/bin/java
java -jar languages/fsm/fsm.lang.switch.benchmark/target/benchmarks.jar -wi 10 -i 50 -rf json -rff fsm_switch_graal_ee.json -jvm benchmark_jvm/graal_ee/bin/java
java -jar languages/fsm/fsm.lang.switch.benchmark/target/benchmarks.jar -wi 10 -i 50 -rf json -rff fsm_switch_graalj9_11.json -jvm benchmark_jvm/openj9_11/bin/java
java -jar languages/fsm/fsm.lang.switch.benchmark/target/benchmarks.jar -wi 10 -i 50 -rf json -rff fsm_switch_graalj9_12.json -jvm benchmark_jvm/openj9_12/bin/java
java -jar languages/fsm/fsm.lang.switch.benchmark/target/benchmarks.jar -wi 10 -i 50 -rf json -rff fsm_switch_graalj9_8.json -jvm benchmark_jvm/openj9_8/bin/java
java -jar languages/fsm/fsm.lang.switch.benchmark/target/benchmarks.jar -wi 10 -i 50 -rf json -rff fsm_switch_graaljdk_11.json -jvm benchmark_jvm/openjdk_11/bin/java
java -jar languages/fsm/fsm.lang.switch.benchmark/target/benchmarks.jar -wi 10 -i 50 -rf json -rff fsm_switch_graaljdk_12.json -jvm benchmark_jvm/openjdk_12/bin/java
java -jar languages/fsm/fsm.lang.switch.benchmark/target/benchmarks.jar -wi 10 -i 50 -rf json -rff fsm_switch_graaljdk_8.json -jvm benchmark_jvm/openjdk_8/bin/java

######################################
##          LOGO BENCHMARK          ##
######################################

## INTERPRETER
java -jar languages/logo/logo.lang.interpreter.benchmark/target/benchmarks.jar -wi 10 -i 50 -rf json -rff logo_interpreter_graal_ce.json -jvm benchmark_jvm/graal_ce/bin/java
java -jar languages/logo/logo.lang.interpreter.benchmark/target/benchmarks.jar -wi 10 -i 50 -rf json -rff logo_interpreter_graal_ee.json -jvm benchmark_jvm/graal_ee/bin/java
java -jar languages/logo/logo.lang.interpreter.benchmark/target/benchmarks.jar -wi 10 -i 50 -rf json -rff logo_interpreter_graalj9_11.json -jvm benchmark_jvm/openj9_11/bin/java
java -jar languages/logo/logo.lang.interpreter.benchmark/target/benchmarks.jar -wi 10 -i 50 -rf json -rff logo_interpreter_graalj9_12.json -jvm benchmark_jvm/openj9_12/bin/java
java -jar languages/logo/logo.lang.interpreter.benchmark/target/benchmarks.jar -wi 10 -i 50 -rf json -rff logo_interpreter_graalj9_8.json -jvm benchmark_jvm/openj9_8/bin/java
java -jar languages/logo/logo.lang.interpreter.benchmark/target/benchmarks.jar -wi 10 -i 50 -rf json -rff logo_interpreter_graaljdk_11.json -jvm benchmark_jvm/openjdk_11/bin/java
java -jar languages/logo/logo.lang.interpreter.benchmark/target/benchmarks.jar -wi 10 -i 50 -rf json -rff logo_interpreter_graaljdk_12.json -jvm benchmark_jvm/openjdk_12/bin/java
java -jar languages/logo/logo.lang.interpreter.benchmark/target/benchmarks.jar -wi 10 -i 50 -rf json -rff logo_interpreter_graaljdk_8.json -jvm benchmark_jvm/openjdk_8/bin/java

## VISITOR
java -jar languages/logo/logo.lang.visitor.benchmark/target/benchmarks.jar -wi 10 -i 50 -rf json -rff logo_visitor_graal_ce.json -jvm benchmark_jvm/graal_ce/bin/java
java -jar languages/logo/logo.lang.visitor.benchmark/target/benchmarks.jar -wi 10 -i 50 -rf json -rff logo_visitor_graal_ee.json -jvm benchmark_jvm/graal_ee/bin/java
java -jar languages/logo/logo.lang.visitor.benchmark/target/benchmarks.jar -wi 10 -i 50 -rf json -rff logo_visitor_graalj9_11.json -jvm benchmark_jvm/openj9_11/bin/java
java -jar languages/logo/logo.lang.visitor.benchmark/target/benchmarks.jar -wi 10 -i 50 -rf json -rff logo_visitor_graalj9_12.json -jvm benchmark_jvm/openj9_12/bin/java
java -jar languages/logo/logo.lang.visitor.benchmark/target/benchmarks.jar -wi 10 -i 50 -rf json -rff logo_visitor_graalj9_8.json -jvm benchmark_jvm/openj9_8/bin/java
java -jar languages/logo/logo.lang.visitor.benchmark/target/benchmarks.jar -wi 10 -i 50 -rf json -rff logo_visitor_graaljdk_11.json -jvm benchmark_jvm/openjdk_11/bin/java
java -jar languages/logo/logo.lang.visitor.benchmark/target/benchmarks.jar -wi 10 -i 50 -rf json -rff logo_visitor_graaljdk_12.json -jvm benchmark_jvm/openjdk_12/bin/java
java -jar languages/logo/logo.lang.visitor.benchmark/target/benchmarks.jar -wi 10 -i 50 -rf json -rff logo_visitor_graaljdk_8.json -jvm benchmark_jvm/openjdk_8/bin/java

## REVISITOR
java -jar languages/logo/logo.lang.revisitor.benchmark/target/benchmarks.jar -wi 10 -i 50 -rf json -rff logo_revisitor_graal_ce.json -jvm benchmark_jvm/graal_ce/bin/java
java -jar languages/logo/logo.lang.revisitor.benchmark/target/benchmarks.jar -wi 10 -i 50 -rf json -rff logo_revisitor_graal_ee.json -jvm benchmark_jvm/graal_ee/bin/java
java -jar languages/logo/logo.lang.revisitor.benchmark/target/benchmarks.jar -wi 10 -i 50 -rf json -rff logo_revisitor_graalj9_11.json -jvm benchmark_jvm/openj9_11/bin/java
java -jar languages/logo/logo.lang.revisitor.benchmark/target/benchmarks.jar -wi 10 -i 50 -rf json -rff logo_revisitor_graalj9_12.json -jvm benchmark_jvm/openj9_12/bin/java
java -jar languages/logo/logo.lang.revisitor.benchmark/target/benchmarks.jar -wi 10 -i 50 -rf json -rff logo_revisitor_graalj9_8.json -jvm benchmark_jvm/openj9_8/bin/java
java -jar languages/logo/logo.lang.revisitor.benchmark/target/benchmarks.jar -wi 10 -i 50 -rf json -rff logo_revisitor_graaljdk_11.json -jvm benchmark_jvm/openjdk_11/bin/java
java -jar languages/logo/logo.lang.revisitor.benchmark/target/benchmarks.jar -wi 10 -i 50 -rf json -rff logo_revisitor_graaljdk_12.json -jvm benchmark_jvm/openjdk_12/bin/java
java -jar languages/logo/logo.lang.revisitor.benchmark/target/benchmarks.jar -wi 10 -i 50 -rf json -rff logo_revisitor_graaljdk_8.json -jvm benchmark_jvm/openjdk_8/bin/java

## SWITCH
java -jar languages/logo/logo.lang.switch.benchmark/target/benchmarks.jar -wi 10 -i 50 -rf json -rff logo_switch_graal_ce.json -jvm benchmark_jvm/graal_ce/bin/java
java -jar languages/logo/logo.lang.switch.benchmark/target/benchmarks.jar -wi 10 -i 50 -rf json -rff logo_switch_graal_ee.json -jvm benchmark_jvm/graal_ee/bin/java
java -jar languages/logo/logo.lang.switch.benchmark/target/benchmarks.jar -wi 10 -i 50 -rf json -rff logo_switch_graalj9_11.json -jvm benchmark_jvm/openj9_11/bin/java
java -jar languages/logo/logo.lang.switch.benchmark/target/benchmarks.jar -wi 10 -i 50 -rf json -rff logo_switch_graalj9_12.json -jvm benchmark_jvm/openj9_12/bin/java
java -jar languages/logo/logo.lang.switch.benchmark/target/benchmarks.jar -wi 10 -i 50 -rf json -rff logo_switch_graalj9_8.json -jvm benchmark_jvm/openj9_8/bin/java
java -jar languages/logo/logo.lang.switch.benchmark/target/benchmarks.jar -wi 10 -i 50 -rf json -rff logo_switch_graaljdk_11.json -jvm benchmark_jvm/openjdk_11/bin/java
java -jar languages/logo/logo.lang.switch.benchmark/target/benchmarks.jar -wi 10 -i 50 -rf json -rff logo_switch_graaljdk_12.json -jvm benchmark_jvm/openjdk_12/bin/java
java -jar languages/logo/logo.lang.switch.benchmark/target/benchmarks.jar -wi 10 -i 50 -rf json -rff logo_switch_graaljdk_8.json -jvm benchmark_jvm/openjdk_8/bin/java

######################################
##        MINIJAVA BENCHMARK        ##
######################################

## INTERPRETER
java -jar languages/minijava/minijava.lang.interpreter.benchmark/target/benchmarks.jar -wi 10 -i 50 -rf json -rff minijava_interpreter_graal_ce.json -jvm benchmark_jvm/graal_ce/bin/java
java -jar languages/minijava/minijava.lang.interpreter.benchmark/target/benchmarks.jar -wi 10 -i 50 -rf json -rff minijava_interpreter_graal_ee.json -jvm benchmark_jvm/graal_ee/bin/java
java -jar languages/minijava/minijava.lang.interpreter.benchmark/target/benchmarks.jar -wi 10 -i 50 -rf json -rff minijava_interpreter_graalj9_11.json -jvm benchmark_jvm/openj9_11/bin/java
java -jar languages/minijava/minijava.lang.interpreter.benchmark/target/benchmarks.jar -wi 10 -i 50 -rf json -rff minijava_interpreter_graalj9_12.json -jvm benchmark_jvm/openj9_12/bin/java
java -jar languages/minijava/minijava.lang.interpreter.benchmark/target/benchmarks.jar -wi 10 -i 50 -rf json -rff minijava_interpreter_graalj9_8.json -jvm benchmark_jvm/openj9_8/bin/java
java -jar languages/minijava/minijava.lang.interpreter.benchmark/target/benchmarks.jar -wi 10 -i 50 -rf json -rff minijava_interpreter_graaljdk_11.json -jvm benchmark_jvm/openjdk_11/bin/java
java -jar languages/minijava/minijava.lang.interpreter.benchmark/target/benchmarks.jar -wi 10 -i 50 -rf json -rff minijava_interpreter_graaljdk_12.json -jvm benchmark_jvm/openjdk_12/bin/java
java -jar languages/minijava/minijava.lang.interpreter.benchmark/target/benchmarks.jar -wi 10 -i 50 -rf json -rff minijava_interpreter_graaljdk_8.json -jvm benchmark_jvm/openjdk_8/bin/java

## VISITOR
# java -jar languages/minijava/minijava.lang.visitor.benchmark/target/benchmarks.jar -wi 10 -i 50 -rf json -rff minijava_visitor_graal_ce.json -jvm benchmark_jvm/graal_ce/bin/java
# java -jar languages/minijava/minijava.lang.visitor.benchmark/target/benchmarks.jar -wi 10 -i 50 -rf json -rff minijava_visitor_graal_ee.json -jvm benchmark_jvm/graal_ee/bin/java
# java -jar languages/minijava/minijava.lang.visitor.benchmark/target/benchmarks.jar -wi 10 -i 50 -rf json -rff minijava_visitor_graalj9_11.json -jvm benchmark_jvm/openj9_11/bin/java
# java -jar languages/minijava/minijava.lang.visitor.benchmark/target/benchmarks.jar -wi 10 -i 50 -rf json -rff minijava_visitor_graalj9_12.json -jvm benchmark_jvm/openj9_12/bin/java
# java -jar languages/minijava/minijava.lang.visitor.benchmark/target/benchmarks.jar -wi 10 -i 50 -rf json -rff minijava_visitor_graalj9_8.json -jvm benchmark_jvm/openj9_8/bin/java
# java -jar languages/minijava/minijava.lang.visitor.benchmark/target/benchmarks.jar -wi 10 -i 50 -rf json -rff minijava_visitor_graaljdk_11.json -jvm benchmark_jvm/openjdk_11/bin/java
# java -jar languages/minijava/minijava.lang.visitor.benchmark/target/benchmarks.jar -wi 10 -i 50 -rf json -rff minijava_visitor_graaljdk_12.json -jvm benchmark_jvm/openjdk_12/bin/java
# java -jar languages/minijava/minijava.lang.visitor.benchmark/target/benchmarks.jar -wi 10 -i 50 -rf json -rff minijava_visitor_graaljdk_8.json -jvm benchmark_jvm/openjdk_8/bin/java

## REVISITOR
# java -jar languages/minijava/minijava.lang.revisitor.benchmark/target/benchmarks.jar -wi 10 -i 50 -rf json -rff minijava_revisitor_graal_ce.json -jvm benchmark_jvm/graal_ce/bin/java
# java -jar languages/minijava/minijava.lang.revisitor.benchmark/target/benchmarks.jar -wi 10 -i 50 -rf json -rff minijava_revisitor_graal_ee.json -jvm benchmark_jvm/graal_ee/bin/java
# java -jar languages/minijava/minijava.lang.revisitor.benchmark/target/benchmarks.jar -wi 10 -i 50 -rf json -rff minijava_revisitor_graalj9_11.json -jvm benchmark_jvm/openj9_11/bin/java
# java -jar languages/minijava/minijava.lang.revisitor.benchmark/target/benchmarks.jar -wi 10 -i 50 -rf json -rff minijava_revisitor_graalj9_12.json -jvm benchmark_jvm/openj9_12/bin/java
# java -jar languages/minijava/minijava.lang.revisitor.benchmark/target/benchmarks.jar -wi 10 -i 50 -rf json -rff minijava_revisitor_graalj9_8.json -jvm benchmark_jvm/openj9_8/bin/java
# java -jar languages/minijava/minijava.lang.revisitor.benchmark/target/benchmarks.jar -wi 10 -i 50 -rf json -rff minijava_revisitor_graaljdk_11.json -jvm benchmark_jvm/openjdk_11/bin/java
# java -jar languages/minijava/minijava.lang.revisitor.benchmark/target/benchmarks.jar -wi 10 -i 50 -rf json -rff minijava_revisitor_graaljdk_12.json -jvm benchmark_jvm/openjdk_12/bin/java
# java -jar languages/minijava/minijava.lang.revisitor.benchmark/target/benchmarks.jar -wi 10 -i 50 -rf json -rff minijava_revisitor_graaljdk_8.json -jvm benchmark_jvm/openjdk_8/bin/java

## SWITCH
# java -jar languages/minijava/minijava.lang.switch.benchmark/target/benchmarks.jar -wi 10 -i 50 -rf json -rff minijava_switch_graal_ce.json -jvm benchmark_jvm/graal_ce/bin/java
# java -jar languages/minijava/minijava.lang.switch.benchmark/target/benchmarks.jar -wi 10 -i 50 -rf json -rff minijava_switch_graal_ee.json -jvm benchmark_jvm/graal_ee/bin/java
# java -jar languages/minijava/minijava.lang.switch.benchmark/target/benchmarks.jar -wi 10 -i 50 -rf json -rff minijava_switch_graalj9_11.json -jvm benchmark_jvm/openj9_11/bin/java
# java -jar languages/minijava/minijava.lang.switch.benchmark/target/benchmarks.jar -wi 10 -i 50 -rf json -rff minijava_switch_graalj9_12.json -jvm benchmark_jvm/openj9_12/bin/java
# java -jar languages/minijava/minijava.lang.switch.benchmark/target/benchmarks.jar -wi 10 -i 50 -rf json -rff minijava_switch_graalj9_8.json -jvm benchmark_jvm/openj9_8/bin/java
# java -jar languages/minijava/minijava.lang.switch.benchmark/target/benchmarks.jar -wi 10 -i 50 -rf json -rff minijava_switch_graaljdk_11.json -jvm benchmark_jvm/openjdk_11/bin/java
# java -jar languages/minijava/minijava.lang.switch.benchmark/target/benchmarks.jar -wi 10 -i 50 -rf json -rff minijava_switch_graaljdk_12.json -jvm benchmark_jvm/openjdk_12/bin/java
# java -jar languages/minijava/minijava.lang.switch.benchmark/target/benchmarks.jar -wi 10 -i 50 -rf json -rff minijava_switch_graaljdk_8.json -jvm benchmark_jvm/openjdk_8/bin/java
