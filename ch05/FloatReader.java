/*1. Write a method public ArrayList<Double> readValues(String
filename) throws... that reads a file containing floating-point numbers. Throw
appropriate exceptions if the file could not be opened or if some
of the inputs are not floating-point numbers.*/


package ch05;

import java.util.*;
import java.io.*;

public class FloatReader {
    
    public static ArrayList<Double> readValues(String filename)
	throws FileNotFoundException, IOException, NumberFormatException {
	ArrayList<Double> result = new ArrayList<Double>();
	FileReader filereader;
	BufferedReader reader;
	try {
	    reader = new BufferedReader(new FileReader(filename));  
	    String line;
	    String[] stringNumbas;
	    
	    while ((line = reader.readLine()) != null){
		stringNumbas = line.split(" ");
		for (String numba : stringNumbas){
		    result.add(new Double(numba));
		}
	    }
	} catch (FileNotFoundException exc) {
	    System.out.println("File not found.\n");
	    throw exc;
	} catch (IOException exc) {
	    System.out.println("Problems reading a line.\n");
	    throw exc;
	} catch (NumberFormatException exc) {
	    System.out.println("File has non-float elements.\n");
	    throw exc;
	} 

      	return result;
    }

    /*     Write a method public double sumOfValues(String filename)
           throws... that calls the preceding method and returns the
            sum of the values in the file. Propagate any exceptions
	    to the caller.
    */

}

