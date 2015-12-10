package aoc2015.day6;

import static org.junit.Assert.*;
import org.junit.Test;

public class AdjustableLightsTests {

	@Test
	public void part2Example1() {
		AdjustableLights l = new AdjustableLights(1000,1000);
		l.processInstruction(new Instruction("turn on 0,0 through 0,0"));
		assertEquals(l.totalLightBrightness(), 1);
	}
	
	@Test
	public void part2Example2() {
		AdjustableLights l = new AdjustableLights(1000,1000);
		l.processInstruction(new Instruction("toggle 0,0 through 999,999"));
		assertEquals(l.totalLightBrightness(), 2000000);
	}
	
}
