package aoc2015.day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Run {
	
	public static void main(String[] args) {
		
		String inputFilePath = args[0];
		
		try {
			InstructionProcessor santaTrip = new InstructionProcessor(new File(inputFilePath), 1);
			InstructionProcessor santaAndRoboSantaTrip = new InstructionProcessor(new File(inputFilePath), 2);
			
			System.out.println(String.format("Santa will deliver presents to %d houses", santaTrip.countHousesRecievedAtLeastOnePresent()));
			System.out.println(String.format("Santa and Robo Santa will deliver presents to %d houses", santaAndRoboSantaTrip.countHousesRecievedAtLeastOnePresent()));
			
			// Just for fun...
			InstructionProcessor threeWorkerTrip = new InstructionProcessor(new File(inputFilePath), 3);
			InstructionProcessor fiveWorkerTrip = new InstructionProcessor(new File(inputFilePath), 5);
			InstructionProcessor tenWorkerTrip = new InstructionProcessor(new File(inputFilePath), 10);
			System.out.println(String.format("Three workers will deliver presents to %d houses", threeWorkerTrip.countHousesRecievedAtLeastOnePresent()));
			System.out.println(String.format("Five workers will deliver presents to %d houses", fiveWorkerTrip.countHousesRecievedAtLeastOnePresent()));
			System.out.println(String.format("Ten workers will deliver presents to %d houses", tenWorkerTrip.countHousesRecievedAtLeastOnePresent()));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}