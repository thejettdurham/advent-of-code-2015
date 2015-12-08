#!/usr/bin/python

import processor

with open('../input', 'r') as infile:
    data = infile.read().rstrip()
    print 'Santa needs to go to floor ' + str(processor.DestFloorForInstructions(data))
    print 'Santa will enter the basement at instruction ' + str(processor.InstructionOfFirstBasementEntry(data))
