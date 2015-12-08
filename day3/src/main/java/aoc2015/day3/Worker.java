package aoc2015.day3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Worker {

	private List<MapCoordinate> visitedLocations = new ArrayList<MapCoordinate>(Arrays.asList(new MapCoordinate(0,0)));
	
	private static final HashMap<Character, MapCoordinate> movementPlan = new HashMap<Character, MapCoordinate>(); 
	static {
		movementPlan.put('<', new MapCoordinate(-1, 0));
		movementPlan.put('>', new MapCoordinate(1,0));
		movementPlan.put('^', new MapCoordinate(0,1));
		movementPlan.put('v', new MapCoordinate(0,-1));
	}
	
	public Worker() {
		
	}
	
	public void processInstruction(char c) {
		MapCoordinate lastCoord = getLastCoordinate();
		MapCoordinate transformCoord = movementPlan.get(c);
		if (transformCoord != null) {
			MapCoordinate newCoord = MapCoordinate.sum(lastCoord, transformCoord);
			visitedLocations.add(newCoord);
		}
	}
	
	public List<MapCoordinate> getVisitedLocations() {
		return visitedLocations;
	}
	
	private MapCoordinate getLastCoordinate() {
		return visitedLocations.get(visitedLocations.size() - 1);
	}
}
