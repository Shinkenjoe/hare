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

    public static double sumOfValues(String filename)
	throws IOException, NumberFormatException {
	ArrayList<Double> arr = FloatReader.readValues(filename);
	double res = 0;
	for (Double numba : arr){
	    res += numba;
	}
	return res;
    }

    /*4. Repeat the preceding exercise, but don’t use exceptions.
      Instead, have readValues and sumOfValues return error codes
      of some kind.*/


    public static ArrayList<Double> readValuesEC(String filename)
    {
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
	    return new ArrayList<Double>(Arrays.asList(-1.0, 0.0));
	} catch (IOException exc) {
	    System.out.println("Problems reading a line.\n");
	    return new ArrayList<Double>(Arrays.asList(-1.0, 1.0));
	} catch (NumberFormatException exc) {
	    System.out.println("File has non-float elements.\n");
	    return new ArrayList<>(Arrays.asList(-1.0, 2.0));
	} 
      	return result;	
    }

    public static double sumOfValuesEC(String filename){
	ArrayList<Double> arr = FloatReader.readValuesEC(filename);
	double res = 0;
	for (Double numba : arr){
	    res += numba;
	}
	return res;
    }
    
    public static void reportResult(List<Double> result){
	if (result.get(0) == -1){
	    switch ((result.get(1).intValue())) {
	    case 0:
		System.out.println("File not found");
		break;
	    case 1:
		System.out.println("Problems with reading a file.");
		break;
	    case 2:
		System.out.println("Non-float stuff in file");
		break;
	    default:
		System.out.println(result.toString());
	    } 	    
	    
	} else
	    System.out.println(result.toString());
    }
    
    public static void reportResult2(Double result2){
	switch (result2.intValue()) {
	case -1:
	    System.out.println("File not found");
	    break;
	case 0:
	    System.out.println("Problems with reading a file.");
	    break;
	case 1:
	    System.out.println("Non-float stuff in file");
	    break;
	default:
	    System.out.println(result2);
	}
    }
}
