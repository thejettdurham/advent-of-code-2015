package aoc2015.day8;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CharacterCounter {

	public static int codeRepresentationLength(String input) {
		return input.length();
	}
	
	public static int literalRepresentationLength(String input) {
		
		// Remove the starting and ending double quotes here
		String output = input.substring(1, input.length() - 1);
	
		output = removeCharsForPattern(output, "\\\\x[0-9,a-f][0-9,a-f]");
		output = removeCharsForPattern(output, "\\\\\\\\");
		output = removeCharsForPattern(output, "\\\\\"");
		
		return output.length();
	}

	public static int reencodedRepresentationLength(String input) {
		String output = input;

		output = padCharsForPattern(output, "\"");
		output = padCharsForPattern(output, "\\\\");
		output = "\"" + output + "\"";
		
		return output.length();
	}
	
	private static String padCharsForPattern(String input, String pattern) {
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(input);
		return m.replaceAll("00");
	}

	private static String removeCharsForPattern(String input, String pattern) {
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(input);
		return m.replaceAll("1");
		
	}
	
}
