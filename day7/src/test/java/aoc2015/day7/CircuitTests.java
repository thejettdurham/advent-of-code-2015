package aoc2015.day7;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class CircuitTests {

	@Test
	public void part1Example1() {
		List<String> instructions = new ArrayList<String>(Arrays.asList(
				"123 -> x",
				"456 -> y",
				"x AND y -> d",
				"x LSHIFT 2 -> f",
				"y RSHIFT 2 -> g",
				"NOT x -> h",
				"x OR y -> e",
				"NOT y -> i"
				));
		
		Circuit c = new Circuit(instructions);
		Map<String,Integer> outputs = c.getOutputForAllWires();
		
		assertEquals(outputs.get("d"), new Integer(72));
		assertEquals(outputs.get("e"), new Integer(507));
		assertEquals(outputs.get("f"), new Integer(492));
		assertEquals(outputs.get("g"), new Integer(114));
		assertEquals(outputs.get("h"), new Integer(65412));
		assertEquals(outputs.get("i"), new Integer(65079));
		assertEquals(outputs.get("x"), new Integer(123));
		assertEquals(outputs.get("y"), new Integer(456));
	}
	
}
