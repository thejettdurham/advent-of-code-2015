package aoc2015.day7;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Circuit {

	private Map<String,WiringInstruction> _circuit;
	private Map<String,Integer> wireValues;
	
	public Circuit(List<String> instructions) {
		_circuit = new HashMap<String,WiringInstruction>();
		wireValues = new HashMap<String,Integer>();
		
		instructions.stream().forEach(s -> addInstructionToCircuit(s));
	}

	private void addInstructionToCircuit(String instruction) {
		String[] instructionParts = instruction.split("->");
		_circuit.put(instructionParts[1].replaceAll("\\s",""), new WiringInstruction(instructionParts[0].replaceAll("\\s","")));
	}
	
	public Integer getOutputForWire(String wire) {
		// If the wire is a numeric value, add it to the value map and return it.
		try {
			return Integer.parseInt(wire);
		} catch (Exception e) {
			// wireName is non-numeric, continue with parsing logic
		}
		
		// See if we've already calculated the wire's output at some point
		if (wireValues.containsKey(wire)) {
			return wireValues.get(wire);
		}
		
		WiringInstruction instForWire = _circuit.get(wire);
		Integer val;
		
		if (instForWire.gate.isPresent()) {
		
			switch (instForWire.gate.get()) {
			case "NOT":
				val = ~ getOutputForWire(instForWire.rSource.get());
				break;
			case "AND":
				val = getOutputForWire(instForWire.lSource.get()) & getOutputForWire(instForWire.rSource.get());
				break;
			case "OR":
				val = getOutputForWire(instForWire.lSource.get()) | getOutputForWire(instForWire.rSource.get());
				break;
			case "LSHIFT":				
				val = getOutputForWire(instForWire.lSource.get()) << getOutputForWire(instForWire.rSource.get());
				break;
			case "RSHIFT":				
				val = getOutputForWire(instForWire.lSource.get()) >> getOutputForWire(instForWire.rSource.get());
				break;
			default:
				throw new UnsupportedOperationException("Unrecognized gate " + instForWire.gate.get() + " for wiring instruction " + instForWire.toString());
			}
		} else {
			val = getOutputForWire(instForWire.lSource.get());
		}
		
		wireValues.put(wire, val);
		return val;
	}
	
	public int getUnsignedOutputForWire(String wire) {
		//return Short.toUnsignedInt(getOutputForWire(wire));
		return getOutputForWire(wire);
	}
	
	public Map<String,Integer> getOutputForAllWires() {
		for (Map.Entry<String, WiringInstruction> entry: _circuit.entrySet()) {
			getOutputForWire(entry.getKey());
		}
		
		Map<String,Integer> ret = new HashMap<String,Integer>();
		
		for (Map.Entry<String,Integer> entry: wireValues.entrySet()) {
			ret.put(entry.getKey(), entry.getValue());
		}
		
		return ret;
	}
}
