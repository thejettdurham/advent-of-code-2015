#!/bin/bash

[[ ! -z $1 ]] && KEY=$1 || (echo "First arg must be the input key" && exit 1)
[[ ! -z $2 ]] && BATCHSIZE=$2 || (echo "Second arg must be the batch size" && exit 1)
[[ ! -z $3 ]] && PREFIX=$3 || PREFIX=""

java -cp "build/libs/*" aoc2015.day4.Run $KEY $BATCHSIZE $PREFIX
