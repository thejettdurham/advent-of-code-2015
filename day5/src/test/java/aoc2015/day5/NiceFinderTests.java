package aoc2015.day5;

import static org.junit.Assert.*;
import org.junit.Test;

public class NiceFinderTests {

	@Test
	public void part1Example1() {
		assertTrue(new NiceFinder().inputStringIsNiceForOldRules("ugknbfddgicrmopn"));
	}
	
	@Test
	public void part1Example2() {
		assertTrue(new NiceFinder().inputStringIsNiceForOldRules("aaa"));
	}
	
	@Test
	public void part1Example3() {
		assertFalse(new NiceFinder().inputStringIsNiceForOldRules("jchzalrnumimnmhp"));
	}
	
	@Test
	public void part1Example4() {
		assertFalse(new NiceFinder().inputStringIsNiceForOldRules("haegwjzuvuyypxyu"));
	}
	
	@Test
	public void part1Example5() {
		assertFalse(new NiceFinder().inputStringIsNiceForOldRules("dvszwmarrgswjxmb"));
	}
	
	@Test
	public void part2Example1() {
		assertTrue(new NiceFinder().inputStringIsNiceForNewRules("qjhvhtzxzqqjkmpb"));
	}
	
	@Test
	public void part2Example2() {
		assertTrue(new NiceFinder().inputStringIsNiceForNewRules("xxyxx"));
	}
	
	@Test
	public void part2Example3() {
		assertFalse(new NiceFinder().inputStringIsNiceForNewRules("uurcxstgmygtbstg"));
	}
	
	@Test
	public void part2Example4() {
		assertFalse(new NiceFinder().inputStringIsNiceForNewRules("ieodomkazucvgmuy"));
	}
	
	@Test
	public void part2Debug1() {
		assertFalse(new NiceFinder().inputStringIsNiceForNewRules("aaa"));
	}
	
	@Test
	public void part2Debug2() {
		assertTrue(new NiceFinder().inputStringIsNiceForNewRules("aaaa"));
	}
	
	@Test
	public void part2Debug3() {
		assertTrue(new NiceFinder().inputStringIsNiceForNewRules("abbbbc"));
	}
	
	@Test
	public void part2Debug4() {
		assertFalse(new NiceFinder().inputStringIsNiceForNewRules("mmggaba"));
	}
}
