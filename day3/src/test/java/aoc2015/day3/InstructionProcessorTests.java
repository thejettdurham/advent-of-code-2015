package aoc2015.day3;

import static org.junit.Assert.*;
import org.junit.Test;


public class InstructionProcessorTests {

	@Test
	public void part1Example1() {
		InstructionProcessor p = new InstructionProcessor(">", 1);
		assertEquals(p.countHousesRecievedAtLeastOnePresent(), 2);
	}
	
	@Test
	public void part1Example2() {
		InstructionProcessor p = new InstructionProcessor("^>v<", 1);
		assertEquals(p.countHousesRecievedAtLeastOnePresent(), 4);
	}
	
	@Test
	public void part1Example3() {
		InstructionProcessor p = new InstructionProcessor("^v^v^v^v^v", 1);
		assertEquals(p.countHousesRecievedAtLeastOnePresent(), 2);
	}
	
	@Test
	public void part2Example1() {
		InstructionProcessor p = new InstructionProcessor("^v", 2);
		assertEquals(p.countHousesRecievedAtLeastOnePresent(),  3);
	}
	
	@Test
	public void part2Example2() {
		InstructionProcessor p = new InstructionProcessor("^>v<", 2);
		assertEquals(p.countHousesRecievedAtLeastOnePresent(), 3);
	}
	
	@Test
	public void part2Example3() {
		InstructionProcessor p = new InstructionProcessor("^v^v^v^v^v", 2);
		assertEquals(p.countHousesRecievedAtLeastOnePresent(), 11);
	}
}
