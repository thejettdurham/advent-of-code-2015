package aoc2015.day5;

import java.io.File;

public class Run {

	/**
	 * Runnable interface to NiceFinder.  Takes in a path to an input file and returns the resulting number of
	 * nice strings for both the old and new rulesets
	 * 
	 * @param args[0]
	 *            the input file to feed to NiceFinder
	 */
	public static void main(String[] args) { 
		String inputFilePath = args[0];
		
		System.out.println(String.format("Input contains %d nice strings according to the old rules", new NiceFinder().niceStringsInInput(new File(inputFilePath))));
		
		NiceFinder newRules = new NiceFinder(Ruleset.NEW);
		System.out.println(String.format("Input contains %d nice strings according to the new rules", newRules.niceStringsInInput(new File(inputFilePath))));
		System.out.println("New nice strings are as follows");
		newRules.getNiceStrings().stream().forEach(System.out::println);
	}
}
