package aoc2015.day6;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Run {

	public static void main(String[] args) {
		String inputFilePath = args[0];

		Lights lights = new Lights(1000,1000);
		AdjustableLights liteBrite = new AdjustableLights(1000,1000);
		
		try (BufferedReader br = new BufferedReader(new FileReader(new File(inputFilePath)))) {
					
		    String line;
		    while ((line = br.readLine()) != null) {
		    	Instruction i = new Instruction(line);
		    	lights.processInstruction(i);
		    	liteBrite.processInstruction(i);
		    }
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(String.format("The 1000x1000 light array will have %d lights turned on", lights.countLightsOn()));
		System.out.println(String.format("The 1000x1000 adjustable light array will have total brightness of %d", liteBrite.totalLightBrightness()));
	}
}
