package aoc2015.day4;

public class Run {
	
	/**
	 * Runnable interface into AdventCoinHasher.  Requires two command line arguments, but can optionally take a third argument to specify the match string used in AdventCoinHasher
	 * @param args[0] the input key to feed to the hash algorithm
	 * @param args[1] the batch size to use for each parallel processing pass
	 */
	public static void main(String[] args) {
		
		String inputKey = args[0];
		int batchSize = Integer.parseInt(args[1]);
		
		if (args.length > 2) {
			AdventCoinHasher.matchString = args[2];
		}
		
		System.out.println(AdventCoinHasher.hashForKeyAndBatchSize(inputKey, batchSize));
	}
}
