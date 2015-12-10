package aoc2015.day6;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

public class Instruction {

	private Operation op;
	private Pair<Integer,Integer> start;
	private Pair<Integer,Integer> end;
	
	public Instruction(String input) {
		if (input.startsWith("turn")) {
			if (input.contains("on")) {
				op = Operation.ON;
			} else if (input.contains("off")) {
				op = Operation.OFF;
			}
		} else if (input.startsWith("toggle")) {
			op = Operation.TOGGLE;
		}
		
		if (op == null) throw new UnsupportedOperationException("Invalid operation in instruction");
		
		// Every instruction is guaranteed to have 4 numeric instructions,
		// so they can go into this array and then we can parse out the pairs later
		List<Integer> coordinates = new ArrayList<Integer>();
		Matcher matcher = Pattern.compile("\\d+").matcher(input);
		while (matcher.find()) {
			coordinates.add(Integer.valueOf(matcher.group()));
		}
		
		if (coordinates.size() != 4) {
			throw new IndexOutOfBoundsException("Expected 4 coordinates, got " + coordinates.size());
		} else {
			start = new ImmutablePair<Integer,Integer>(coordinates.get(0), coordinates.get(1));
			
			// Add one to these coordinates to make them inclusive
			end = new ImmutablePair<Integer,Integer>(coordinates.get(2) + 1, coordinates.get(3) + 1);
		}
	}
	
	public Operation getOperation() {
		return op;
	}
	
	public Pair<Integer,Integer> getStart() {
		return start;
	}
	
	public Pair<Integer,Integer> getEnd() {
		return end;
	}
	
}
