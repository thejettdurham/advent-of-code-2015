package aoc2015.day3;

import java.util.ArrayList;
import java.util.List;

public class WorkerPool {

	private List<Worker> workers;
	private int workerCursor;
	
	public WorkerPool(int numberOfWorkers) {
		workers = new ArrayList<Worker>();
		
		for (int i = 0; i < numberOfWorkers; i ++) {
			workers.add(new Worker());
		}
	}
	
	public void processInstructionEvenly(char c) {
		if (workerCursor == workers.size()) {
			workerCursor = 0;
		}
		
		workers.get(workerCursor).processInstruction(c);
		workerCursor++;
	}
	
	public List<Worker> getWorkers() {
		return workers;
	}
}
