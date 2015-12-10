package aoc2015.day6;

import static org.junit.Assert.*;
import org.junit.Test;

public class LightsTests {

	@Test
	public void part1Example1() {
		Lights l = new Lights(1000,1000);
		l.processInstruction(new Instruction("turn on 0,0 through 999,999"));
		assertEquals(l.countLightsOn(), 1000000);
	}
	
	@Test
	public void part1Example2() {
		Lights l = new Lights(1000,1000);
		l.processInstruction(new Instruction("toggle 0,0 through 999,0"));
		assertEquals(l.countLightsOn(), 1000);	
	}
	
	@Test
	public void part1Example3() {
		Lights l = new Lights(1000,1000);
		l.processInstruction(new Instruction("turn off 499,499 through 500,500"));
		assertEquals(l.countLightsOn(), 0);
	}
}
