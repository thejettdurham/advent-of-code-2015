package aoc2015.day6;

import static org.junit.Assert.*;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.Test;

public class InstructionTests {
	
	@Test
	public void turnOffParsedCorrectly() {
		Instruction i = new Instruction("turn off 539,243 through 559,965");
		assertEquals(i.getOperation(), Operation.OFF);
	}
	
	@Test
	public void turnOnParsedCorrectly() {
		Instruction i = new Instruction("turn on 539,243 through 559,965");
		assertEquals(i.getOperation(), Operation.ON);
	}
	
	@Test
	public void toggleParsedCorrectly() {
		Instruction i = new Instruction("toggle 539,243 through 559,965");
		assertEquals(i.getOperation(), Operation.TOGGLE);
	}
	
	@Test
	public void coordsParsedCorrectly() {
		Instruction i = new Instruction("toggle 539,243 through 559,965");
		Pair<Integer,Integer> testStart = new ImmutablePair<Integer,Integer>(539,243);
		Pair<Integer,Integer> testEnd = new ImmutablePair<Integer,Integer>(560,966);
		assertEquals(testStart, i.getStart());
		assertEquals(testEnd, i.getEnd());
	}
}
