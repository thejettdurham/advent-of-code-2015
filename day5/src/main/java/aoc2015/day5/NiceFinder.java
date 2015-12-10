package aoc2015.day5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

import org.apache.commons.lang3.StringUtils;

public class NiceFinder {

	// Backing store
	private List<String> niceStrings = new ArrayList<String>();
	
	// Ruleset
	private Ruleset rules;
	
	// Old Rules
	private int vowelsRequiredToMatch = 3;
	private int requiredConsecutiveMatches = 1;
	private int numberOfConsecutiveLettersForMatch = 2;
	private List<String> disallowedStrings;
	
	private static final List<String> defaultDisallowedStrings = new ArrayList<String>();
	static {
		defaultDisallowedStrings.add("ab");
		defaultDisallowedStrings.add("cd");
		defaultDisallowedStrings.add("pq");
		defaultDisallowedStrings.add("xy");
	}
	
	public NiceFinder() {
		this.disallowedStrings = defaultDisallowedStrings;
		this.rules = Ruleset.OLD;
	}
	
	public NiceFinder(Ruleset r) {
		this.rules = r;
	}
	
	public int niceStringsInInput(File inFile) {
		try (BufferedReader br = new BufferedReader(new FileReader(inFile))) {
			
		    String line;
		    while ((line = br.readLine()) != null) {
		    	if (rules == Ruleset.OLD) {
			    	if (inputStringIsNiceForOldRules(line)) {
			    		niceStrings.add(line);
			    	}
		    	} else if (rules == Ruleset.NEW) {
		    		if (inputStringIsNiceForNewRules(line)) {
		    			niceStrings.add(line);
		    		}
		    	}
		    }
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return niceStrings.size();
	}
	
	public List<String> getNiceStrings() {
		return niceStrings;
	}
	
	public boolean inputStringIsNiceForOldRules(String input) {
		if (containsDisallowedString(input)) return false;
		
		if (containsRequiredConsecutiveMatches(input)) return false;
		
		if (containsRequiredVowels(input)) return true;
		
		return false;
	}
	
	public boolean inputStringIsNiceForNewRules(String input) {
		if (!containsSingleLetterWrappedByCertainLetter(input)) return false;
		
		if (containsTwoNonoverlappingPairSequences(input)) return true;
		
		return false;
	}

	private boolean containsDisallowedString(String in) {
		return disallowedStrings.stream().anyMatch(s -> in.contains(s));
	}
	
	private boolean containsRequiredConsecutiveMatches(String in) {
		StringBuilder consecutiveLetterPattern = new StringBuilder("([a-z])");
		IntStream.range(1, numberOfConsecutiveLettersForMatch).forEach(n -> consecutiveLetterPattern.append("\\1"));
		Pattern pattern = Pattern.compile(consecutiveLetterPattern.toString(), Pattern.CASE_INSENSITIVE);
		
		int consecutiveMatches = 0;
		Matcher m = pattern.matcher(in);
		while (m.find()) consecutiveMatches++;
		
		return consecutiveMatches < requiredConsecutiveMatches;
	}

	private boolean containsRequiredVowels(String in) {
		String disemvoweled = in.replaceAll("[AaEeIiOoUu]", "1");
		return StringUtils.countMatches(disemvoweled, "1") >= vowelsRequiredToMatch;
	}
	
	private boolean containsSingleLetterWrappedByCertainLetter(String in) {
		Pattern p = Pattern.compile("([a-z])([a-z])\\1", Pattern.CASE_INSENSITIVE);
		return p.matcher(in).find();
	}
	
	// Extracts each two-character substring from the input string and checks for repeats, short-circuiting if a match is found
	private boolean containsTwoNonoverlappingPairSequences(String input) {
		for (int i = 0; i < input.length() - 1; i++) {
			String sub = input.substring(i, i+2);
			String left = input.substring(0, i);
			String right = input.substring(i+2);
			if (left.contains(sub) || right.contains(sub)) return true;
		}
		return false;
	}
}
