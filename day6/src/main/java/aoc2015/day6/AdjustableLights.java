package aoc2015.day6;

import java.util.Arrays;
import java.util.stream.IntStream;

import org.apache.commons.lang3.tuple.Pair;

public class AdjustableLights {

	private int[][] lightMatrix;
	
	public AdjustableLights(int rows, int columns) {
		lightMatrix = new int[rows][columns];
		
		Arrays.stream(lightMatrix).forEach(a -> Arrays.fill(a, 0));
	}
	
	public int[][] getLightMatrix() {
		return lightMatrix;
	}
	
	public long totalLightBrightness() {
		return Arrays.stream(lightMatrix).flatMapToInt(x -> Arrays.stream(x)).sum();
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
	
	private int changeLightForOperation(int light, Operation op) {
		switch (op) {
			case ON: 
				return ++light;
			case OFF:
				return (light == 0) ? 0 : --light;
			case TOGGLE:
				return light + 2;
			default:
				throw new UnsupportedOperationException("Unrecognized instruction operation");
		}
	}
}
