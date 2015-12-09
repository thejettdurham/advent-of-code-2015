package aoc2015.day4;

import java.util.OptionalInt;
import java.util.stream.IntStream;

import org.apache.commons.codec.digest.DigestUtils;

public class AdventCoinHasher {

	public static String matchString = "00000";
	
	/**
	 * 
	 * @param key
	 * @param batchSize
	 * @return
	 */
	public static int hashForKeyAndBatchSize(String key, int batchSize) {
		
		for (int i = 0; ; i += batchSize) {
			OptionalInt match = IntStream.range(i, i + batchSize)
					.filter(n ->  getHexHashForKeyAndNumber(key, n).startsWith(matchString))
					.findFirst();
			
			if (match.isPresent()) {
				return match.getAsInt();
			} else {
				System.out.println(String.format("No match found between %d and %d", i, i + batchSize));
			}
		}
	}
	
	/**
	 * A simple wrapper around md5Hex provided by Apache Commons Codec. Only here for testing
	 * @param key
	 * @param num
	 * @return
	 */
	public static String getHexHashForKeyAndNumber(String key, int num) {
		return DigestUtils.md5Hex(key + num);
	}
	
}
