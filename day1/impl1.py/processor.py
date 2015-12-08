#!/usr/bin/python

charToValue = {'(': 1, ')': -1}

def DestFloorForInstructions(input):
    # Simple mapping of input character to numeric value
    floor = 0

    for c in input:
        floor += charToValue[c]

    return floor

def InstructionOfFirstBasementEntry(input):
    floor = 0
    instructionIndex = 0

    while instructionIndex < len(input):
        floor += charToValue[input[instructionIndex]]
        instructionIndex += 1

        if (floor == -1):
            return instructionIndex


if __name__ == "__main__":
    print("Testing DestFloorForInstructions against example input...")
    assert DestFloorForInstructions('(())') == 0
    assert DestFloorForInstructions('()()') == 0

    assert DestFloorForInstructions('(((') == 3
    assert DestFloorForInstructions('(()(()(') == 3
    assert DestFloorForInstructions('))(((((') == 3

    assert DestFloorForInstructions('())') == -1
    assert DestFloorForInstructions('))(') == -1

    assert DestFloorForInstructions(')))') == -3
    assert DestFloorForInstructions(')())())') == -3

    print("All DestFloorForInstructions assertions passed")

    print("Testing InstructionOfFirstBasmentEntry against example input...")
    assert InstructionOfFirstBasementEntry(')') == 1
    assert InstructionOfFirstBasementEntry('()())') == 5

    print("All InstructionOfFirstBasmentEntry assertions passed")
