package aoc2015.day4;

import static org.junit.Assert.*;
import org.junit.Test;

public class AdventCoinHasherTests {

	@Test
	public void part1Example1() {
		assertTrue(AdventCoinHasher.getHexHashForKeyAndNumber("abcdef", 609043).startsWith("000001dbbfa"));
	}
	
	@Test
	public void part1Example2() {
		assertTrue(AdventCoinHasher.getHexHashForKeyAndNumber("pqrstuv", 1048970).startsWith("000006136ef"));
	}
	
}
