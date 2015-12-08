#!/usr/bin/python

def ProcessInput(input):
    # Simple mapping of input character to numeric value
    charToValue = {'(': 1, ')': -1}
    floor = 0

    for c in input:
        floor += charToValue[c]

    return floor

if __name__ == "__main__":
    print("Testing ProcessInput against example input...")
    assert ProcessInput('(())') == 0
    assert ProcessInput('()()') == 0

    assert ProcessInput('(((') == 3
    assert ProcessInput('(()(()(') == 3
    assert ProcessInput('))(((((') == 3

    assert ProcessInput('())') == -1
    assert ProcessInput('))(') == -1

    assert ProcessInput(')))') == -3
    assert ProcessInput(')())())') == -3

    print("All assertions passed")
