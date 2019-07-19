# How to run a Truffle benchmark

```bash
$ cd ../ # go to languages root
$ java -Dtruffle.class.path.append=boa/boa.lang.interpreter.truffle/target/simplelanguage.jar \
  -jar lang.truffle.benchmark/target/benchmarks.jar -wi 0 -i 1 \
  -p "programPath=$PWD/../programs/boa_fibonacci.xmi"
```