#!/bin/bash

if [[ ! -z $1 ]]; then
   INFILE=$1
else
  echo "First arg must be the input file"
  exit 1
fi

java -cp "build/libs/*" aoc2015.day3.Run $INFILE
