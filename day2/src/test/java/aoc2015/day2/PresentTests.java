package aoc2015.day2;

import static org.junit.Assert.*;
import org.junit.Test;

import aoc2015.day2.Present;

public class PresentTests {
	
	@Test
    public void wrappingExample1() {
		assertEquals(new Present("2x3x4").getRequiredWrapping(), 58);
    }
	
	@Test
	public void wrappingExample2() {
		assertEquals(new Present("1x1x10").getRequiredWrapping(), 43);
	}
	
	@Test
	public void ribbonExample1() {
		assertEquals(new Present("2x3x4").getRequiredRibbon(), 34);
	}
	
	@Test
	public void ribbonExample2() {
		assertEquals(new Present("1x1x10").getRequiredRibbon(), 14);
	}
}