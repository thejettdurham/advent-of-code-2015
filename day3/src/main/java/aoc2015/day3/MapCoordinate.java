package aoc2015.day3;

public class MapCoordinate {

	public final int xPos;
	public final int yPos;
	
	public MapCoordinate(int x, int y) {
		this.xPos = x;
		this.yPos = y;
	}
	
	public static MapCoordinate sum(MapCoordinate c1, MapCoordinate c2) {
		return new MapCoordinate((c1.xPos + c2.xPos), (c1.yPos + c2.yPos));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + xPos;
		result = prime * result + yPos;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MapCoordinate other = (MapCoordinate) obj;
		if (xPos != other.xPos)
			return false;
		if (yPos != other.yPos)
			return false;
		return true;
	}
}
