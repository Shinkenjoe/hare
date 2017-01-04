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
	filename = "/home/shinken/comp/java/core"+
	    "/impatient/done/ch05/floats";
	System.out.println("get sum of floats in: " + filename);
	double result2 = 0;
	try {
	    result2 = FloatReader.sumOfValues(filename);
	} catch (NumberFormatException | IOException  exc) {
	    System.out.println("other caught by caller.");
	}    
	System.out.println(result2);

	/*3. Write a program that calls the preceding method and
	  prints the result. Catch the exceptions and provide feedback
	  to the user about any error conditions.
	  is already Done.
	*/
	/*4. Repeat the preceding exercise, but don’t use exceptions.
	  Instead, have readValues and sumOfValues return error codes
	  of some kind. */

	filename = "/home/shinken/comp/java/core"+
	    "/impatient/done/ch05/floats";
	System.out.println("EC read Float file: " + filename);
	result = FloatReader.readValuesEC(filename);
	FloatReader.reportResult(result);
	
	System.out.println("EC read nonexisting file");
	result = FloatReader.readValuesEC("/jaerer");
	FloatReader.reportResult(result);	
	
	filename = "/home/shinken/comp/java/core"+
	    "/impatient/done/ch05/none-floats";
	System.out.println("EC read fail file: " + filename);
	result = FloatReader.readValuesEC(filename);
	FloatReader.reportResult(result);


	filename = "/home/shinken/comp/java/core"+
	    "/impatient/done/ch05/floats";
	System.out.println("get ECsum of floats in: " + filename);
	result2 = FloatReader.sumOfValuesEC(filename);
	FloatReader.reportResult2(result2);

	/*5. Implement a method that contains the code with a Scanner and 
	  a PrintWriter in Section 5.1.5, “The Try-with-Resources Statement,”
	  on p. 179. But don’t use the try-with-resources statement. Instead,
	  just use catch clauses. Be sure to close both objects, provided they
	  # have been properly constructed. You need to consider the
	  following conditions:
	  • The Scanner constructor throws an exception.
	  • The PrintWriter constructor throws an exception.
	  • hasNext, next, or println throw an exception.
	  • out.close() throws an exception.
	  • in.close() throws an exception.
	*/
	
	ArrayList<String> lines = ...;
	try (PrintWriter out = new PrintWriter(“output.txt”)) {
	    for (String line : lines) {
		out.println(line.toLowerCase());
	    }
	}

	try (Scanner in = new Scanner(Paths.get(“/usr/share/dict/words”));
	     PrintWriter out = new PrintWriter(“output.txt”)) {
	    while (in.hasNext())
		out.println(in.next().toLowerCase());
	}



    }
    
}

