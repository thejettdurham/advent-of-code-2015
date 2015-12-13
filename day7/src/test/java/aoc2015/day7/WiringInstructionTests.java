package aoc2015.day7;

import static org.junit.Assert.*;
import org.junit.Test;

public class WiringInstructionTests {
	
	@Test
	public void noGate() {
		WiringInstruction wi = new WiringInstruction("1234");
		assertFalse(wi.gate.isPresent());
		assertEquals(wi.lSource.get(), "1234");
		assertFalse(wi.rSource.isPresent());
	}
	
	@Test
	public void notGate() {
		WiringInstruction wi = new WiringInstruction("NOT ab");
		assertTrue(wi.gate.get().equals("NOT"));
		assertEquals(wi.rSource.get(), "ab");
	}
	
	@Test
	public void andGate() {
		WiringInstruction wi = new WiringInstruction("ab AND cd");
		assertEquals(wi.gate.get(), "AND");
		assertEquals(wi.lSource.get(), "ab");
		assertEquals(wi.rSource.get(), "cd");
	}
	
	@Test
	public void orGate() {
		WiringInstruction wi = new WiringInstruction("ab OR cd");
		assertEquals(wi.gate.get(), "OR");
		assertEquals(wi.lSource.get(), "ab");
		assertEquals(wi.rSource.get(), "cd");
	}
	
	@Test
	public void lshiftGate() {
		WiringInstruction wi = new WiringInstruction("ab LSHIFT 3");
		assertEquals(wi.gate.get(), "LSHIFT");
		assertEquals(wi.lSource.get(), "ab");
		assertEquals(wi.rSource.get(), "3");
	}
	
	@Test
	public void rshiftGate() {
		WiringInstruction wi = new WiringInstruction("ab RSHIFT 2");
		assertEquals(wi.gate.get(), "RSHIFT");
		assertEquals(wi.lSource.get(), "ab");
		assertEquals(wi.rSource.get(), "2");
	}
}
