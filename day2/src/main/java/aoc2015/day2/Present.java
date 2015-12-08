package aoc2015.day2;
import java.util.Arrays;

public class Present {
	
	private int[] sides;
	
	public Present(String dims) {
		this.sides = Arrays.stream(dims.split("x")).mapToInt(s -> Integer.parseInt(s)).sorted().toArray();
	}
	
	public int getRequiredWrapping() {
		return getSurfaceArea() + getSmallestSideArea();
	}
	
	public int getRequiredRibbon() {
		return getSmallestFacePerimeter() + getCubicVolume();
	}
	
	private int getSmallestFacePerimeter() {
		return 2 * sides[0] + 2 * sides[1];
	}
	
	private int getCubicVolume() {
		return Arrays.stream(sides).reduce(1, (x, y) -> (x * y));
	}
	
	// This is sufficient because the constructor sorts the array during creation
	private int getSmallestSideArea() {
		return sides[0] * sides[1];
	}
	
	private int getSurfaceArea() {
		return 2 * sides[0] * sides[1] + 2 * sides[1] * sides[2] + 2 * sides[2] * sides[0];
	}
}
