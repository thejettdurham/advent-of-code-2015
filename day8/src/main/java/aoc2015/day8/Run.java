package aoc2015.day8;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Run {

	public static void main(String[] args) {
		String inputFilePath = args[0];

		try (BufferedReader br = new BufferedReader(new FileReader(new File(inputFilePath)))) {

		    String line;
		    int codeCharCount = 0;
		    int literalCharCount = 0;
		    int reencodedCharCount = 0;
		    
		    while ((line = br.readLine()) != null) {
		    	codeCharCount += CharacterCounter.codeRepresentationLength(line);
		    	literalCharCount += CharacterCounter.literalRepresentationLength(line);
		    	reencodedCharCount += CharacterCounter.reencodedRepresentationLength(line);
		    }
		    
		    // This works
		    System.out.println(String.format("Input file contains %d characters", codeCharCount));
		    System.out.println(String.format("Literal string representation of input is represented by %d total characters", literalCharCount));
		    System.out.println(String.format("There are %d more characters in the input file", codeCharCount - literalCharCount));
		    
		    System.out.println(String.format("There are %d total characters when the strings are rencoded", reencodedCharCount));
		    System.out.println(String.format("There are %d more characters in the rencoded strings vs the input file", reencodedCharCount - codeCharCount));
		    
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
