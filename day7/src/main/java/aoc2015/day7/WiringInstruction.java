package aoc2015.day7;

import java.util.Arrays;
import java.util.Optional;

public class WiringInstruction {
	
	@Override
	public String toString() {
		return "WiringInstruction [lSource=" + lSource + ", rSource=" + rSource + ", gate=" + gate + "]";
	}

	public Optional<String> lSource = Optional.empty();
	public Optional<String> rSource = Optional.empty();
	public Optional<String> gate = Optional.empty();
	
	private final String[] allowedGates = { "AND", "OR", "LSHIFT", "RSHIFT", "NOT" };
	
	public WiringInstruction(String instruction) {
		String trimmedInstruction = instruction.replaceAll("\\s","");
		gate = Arrays.stream(allowedGates).filter(s -> trimmedInstruction.contains(s)).findFirst();
		
		if (gate.isPresent()) {
			String[] sources = trimmedInstruction.split(gate.get());
			
			switch (sources.length) {
			case 1:
				lSource = Optional.of(sources[0]);
				break;
			case 2:
				lSource = Optional.of(sources[0]);
				rSource = Optional.of(sources[1]);
				break;
			default:
				throw new UnsupportedOperationException("A gate was specified with an improper number of inputs: " + sources.length);
			}
		} else {
			lSource = Optional.of(trimmedInstruction);
		}
	}
	
	
	
}
