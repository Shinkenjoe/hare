package ch05;


import java.io.*;
import java.util.*;
import ch05.FloatReader;

public class Exercises {
    public static void main(String... args){

/*1. Write a method public ArrayList<Double> readValues(String
filename) throws... that reads a file containing floating-point numbers. Throw
appropriate exceptions if the file could not be opened or if some
of the inputs are not floating-point numbers.*/;
	String filename = "/home/shinken/comp/java/core"+
	    "/impatient/done/ch05/floats";
	System.out.println("read Float file: " + filename);
	ArrayList<Double> result = null;
	try {
	    result = FloatReader.readValues(filename);
	} catch (NumberFormatException | IOException  exc) {
	    System.out.println("other caught by caller.");
	}    
	System.out.println(result.toString());

	try {
	System.out.println("read nonexisting file");
	result = FloatReader.readValues("/jaerer");
	} catch (FileNotFoundException exc) {
	    System.out.println("FileNotFound caught by caller.");
	
	} catch (NumberFormatException | IOException  exc) {
	    System.out.println("other caught by caller.");
	}
       
	filename = "/home/shinken/comp/java/core"+
	    "/impatient/done/ch05/none-floats";
	System.out.println("read fail file: " + filename);
	try{
	result = FloatReader.readValues(filename);
	} catch (NumberFormatException exc) {
	    System.out.println("NumberFormatException caught by caller.");
	}  catch (IOException exc) {
	System.out.println("other caught by caller.");
    }

	/*     Write a method public double sumOfValues(String filename)
	       throws... that calls the preceding method and returns the
	       sum of the values in the file. Propagate any exceptions
	       to the caller.
	*/
    }    
}

