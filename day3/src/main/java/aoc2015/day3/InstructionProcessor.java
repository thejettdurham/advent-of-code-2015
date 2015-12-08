package aoc2015.day3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.HashSet;
import java.util.Set;

/**
 * The constructors to this class takes in a set of instructions from a string or a file
 * Santa will visit in his journey.
 * @author jettdurham
 *
 */
public class InstructionProcessor {
	
	private WorkerPool pool;
	
	/**
	 * 
	 * @param instructions
	 * @param workers Number of workers across which to spread the instruction set
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public InstructionProcessor(File instructions, int workers) throws FileNotFoundException, IOException {
		try (InputStream in = new FileInputStream(instructions);
				Reader r = new InputStreamReader(in);) {
		
			pool = new WorkerPool(workers);
			
			int c;
			while ((c = r.read()) != -1) {
				pool.processInstructionEvenly((char)c);
			}
		}
	}
	
	/**
	 * Use the string constructor for small input sets
	 * @param instructions 
	 * @param workers Number of workers across which to spread the instruction set
	 */
	public InstructionProcessor(String instructions, int workers) {
		pool = new WorkerPool(workers);
		
		for (char c: instructions.toCharArray()) {
			pool.processInstructionEvenly(c);
		}
	}
	
	
	/**
	 * Counts the number of locations that were visited at least once between all workers
	 * @return
	 */
	public int countHousesRecievedAtLeastOnePresent() {
		Set<MapCoordinate> uniqueCoords = new HashSet<MapCoordinate>();
		for (Worker w: pool.getWorkers()) {
			uniqueCoords.addAll(w.getVisitedLocations());
		}
		
		return uniqueCoords.size();
	}
}
