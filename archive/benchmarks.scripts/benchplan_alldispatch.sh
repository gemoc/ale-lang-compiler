if [ -z ${ITERATIONS+x} ]; then ITERATIONS=100; fi
ITERATIONS=$ITERATIONS ./benchplan_alldispatch_boa.sh
ITERATIONS=$ITERATIONS ./benchplan_alldispatch_logo.sh
