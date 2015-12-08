package aoc2015.day2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Run {
	
	public static void main(String[] args) {
		
		String inputFilePath = args[0];
		
		int totalWrapping = 0;
		int totalRibbon = 0;
		
		try (BufferedReader br = new BufferedReader(new FileReader(new File(inputFilePath)))) {
			
		    String line;
		    while ((line = br.readLine()) != null) {
		    	Present p = new Present(line);
		    	totalWrapping += p.getRequiredWrapping();
		    	totalRibbon += p.getRequiredRibbon();
		    }
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(String.format("The elves need %d sqft of wrapping paper", totalWrapping));
		System.out.println(String.format("The elves need %d ft of wrapping paper", totalRibbon));
	}
}
