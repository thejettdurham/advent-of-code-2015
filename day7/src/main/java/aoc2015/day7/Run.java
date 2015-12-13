package aoc2015.day7;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Run {

	public static void main(String[] args) {
		String inputFilePath = args[0];

		List<String> instructions = new ArrayList<String>();
		try (BufferedReader br = new BufferedReader(new FileReader(new File(inputFilePath)))) {

		    String line;
		    while ((line = br.readLine()) != null) {
		    	instructions.add(line);
		    }
		    
		    Circuit bobbysCircuit = new Circuit(instructions);
		    int outputAtWireA = bobbysCircuit.getUnsignedOutputForWire("a");
		    System.out.println(String.format("The output at wire 'a' will be %d", outputAtWireA));
		    
		    instructions.removeIf(s -> s.matches("^.*-> b$"));
		    String newInstruction = outputAtWireA + " -> b";
		    instructions.add(0, newInstruction);
		    Circuit bobbysNewCircuit = new Circuit(instructions);
		    int newOutputAtWireA = bobbysNewCircuit.getUnsignedOutputForWire("a");
		    System.out.println(String.format("The new output at wire 'a' will be %d", newOutputAtWireA));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
