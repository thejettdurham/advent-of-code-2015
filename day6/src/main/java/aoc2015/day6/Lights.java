package aoc2015.day6;

import java.util.Arrays;
import java.util.stream.IntStream;

import org.apache.commons.lang3.tuple.Pair;

public class Lights {

	private Boolean[][] lightMatrix;
	
	public Lights(int rows, int columns) {
		lightMatrix = new Boolean[rows][columns];
		
		Arrays.stream(lightMatrix).forEach(a -> Arrays.fill(a, false));
	}
	
	public Boolean[][] getLightMatrix() {
		return lightMatrix;
	}
	
	public long countLightsOn() {
		return Arrays.stream(lightMatrix).flatMap(x -> Arrays.stream(x)).filter(v -> v).count();
	}
	
	public void processInstruction(Instruction in) {
		Pair<Integer,Integer> from = in.getStart();
		Pair<Integer,Integer> to = in.getEnd();
		
		IntStream.range(from.getLeft(), to.getLeft()).forEach(row -> 
			IntStream.range(from.getRight(), to.getRight()).forEach(col -> 
				lightMatrix[row][col] = changeLightForOperation(lightMatrix[row][col], in.getOperation())
			)
		);
	}
	
	private boolean changeLightForOperation(boolean light, Operation op) {
		switch (op) {
			case ON: 
				return true;
			case OFF:
				return false;
			case TOGGLE:
				return !light;
			default:
				throw new UnsupportedOperationException("Unrecognized instruction operation");
		}
	}
}
