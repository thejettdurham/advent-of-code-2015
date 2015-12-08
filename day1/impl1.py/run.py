#!/usr/bin/python

import processor

with open('../input', 'r') as infile:
    print(processor.ProcessInput(infile.read().rstrip()))
