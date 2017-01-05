package ch05;


import java.io.*;
import java.util.*;
import ch05.FloatReader;
import ch05.ScanWrite;
import ch05.RewriteFinally;
import ch05.CloseableReentrantLock;
import ch05.StackFactorial;
import ch05.MyException;

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

	/*

	try (Scanner in = new Scanner(Paths.get(“/usr/share/dict/words”));
	     PrintWriter out = new PrintWriter(“output.txt”)) {
	    while (in.hasNext())
		out.println(in.next().toLowerCase());
	}
	*/
	String base = "/home/shinken/comp/java/core/impatient/done/ch05/";
	filename = base  +  "someLines.txt";
	String outfile = base + "someSmallLines.txt";
	try {
	    System.out.println("Trying ScanWrite");
	    ScanWrite.smallit(filename, outfile);
	} catch (IOException exc ) {
	    System.out.println("Something.");
	}
	try {
	    System.out.println("Trying ScanWrite with wrong outFile");
	    ScanWrite.smallit(filename, "/df");
	} catch (IOException exc ) {
	    System.out.println("Something.");
	}
	
	/*6. Section 5.1.6, “The finally Clause,” on p. 181 has an example of
	  a broken try statement with catch and finally clauses. Fix the code
	  with (a) catching the exception in the finally clause, (b) a
	  try/catch statement containing a try/finally statement, and (c) a 
	  try-with-resources statement with a catch clause.*/

	/*
	BufferedReader in = null;
	try {
	    in = Files.newBufferedReader(path, StandardCharsets.UTF_8);
	    Read from in
		} catch (IOException ex) {
	    System.err.println(“Caught IOException: ” + ex.getMessage());
	} finally {
	    if (in != null) {
		in.close(); // Caution—might throw an exception
	    }
	}
	*/
	System.out.println("\n 5.6 Rewrite finally /n");
	RewriteFinally.run(filename);

	/*For this exercise, you’ll need to read through the source code of the
	  java.util.Scanner class. If input fails when using a Scanner,
	  the Scanner class catches the input exception and closes the resource
	  from which it consumes input. What happens if closing the resource
	  throws an exception? How does this implementation interact with the
	  handling of suppressed exceptions in the try-with-resources statement?
	*/
	/*
	  "It closes the resource"; It just sets sourceClosed to true;
	  close calls Closeable close and sets close to true; 
	  it catches closed Execptions, so they wont show up as suppressed
	 */

	/*
	  8. Design a helper method so that one can use a ReentrantLock in a
	  try-with-resources statement. Call lock and return an AutoCloseable
	  whose close method calls unlock and throws no exceptions.
	 */

	System.out.println("\n 5.8 ReentrantLock Closeable \n");
	
	try (CloseableReentrantLock l = new CloseableReentrantLock();){
	    System.out.println("in the try");
	}
	System.out.println("out the try");
    
    /*9. The methods of the Scanner and PrintWriter classes do not throw
      checked exceptions to make them easier to use for beginning programmers.
      How do you find out whether errors occurred during reading or writing?
      Note that the constructors can throw checked exceptions. Why does that
      defeat the goal of making the classes easier to use for beginners?*/

    /* They throw Runtime Exceptions; If an error occured they will throw
       that exception, the i know. I can test for specific errors before
       liek hasNextInt() if i want to have an int,
       also i can catch exceptions and handle them;
       If u have to dealt with exception throwing and catching anyway
       in the constructor you have to learn this too.
    */

    /*10 Write a recursive factorial method in which you print all stack frames
      before you return the value. Construct (but don’t throw) an exception
      object of any kind and get its stack trace, as described in Section 
      5.1.8, “The Stack Trace,” on p. 184.
    */

	System.out.println("\n 5.10a Factorial with stackTrace \n");
	
	StackFactorial fun = new StackFactorial();
	System.out.println(fun.applyAsInt(5));

	System.out.println("\n 5.10bMy Exception with StackTrace \n");
	Exception ex  = new MyException("this is an error");
	StackTraceElement[] frame = ex.getStackTrace();
	System.out.println(Arrays.toString(frame));

	/*11. Compare the use of Objects.requireNonNull(obj)
	  and assert obj != null. Give a compelling use for each.*/

	/*assert is for testing, 
	  requiring nonnull is for contract enforcement.
	  Lets say assert: you have written several classes, 
	  that have a common entry point in a program and
	  wamt to make sure that some mehtod of them really 
	  returns something for every class;
	  require non-null:
	  You have not written these classes but get them delivered
	  from outside. Your program must make sure that these classes
	  really deliver.
	*/

	/*12. Write a method int min(int[] values) that, just before returning 
	  the smallest value, asserts that it is indeed ≤ all values in the
	  array. Use a private helper method or, if you already peeked into
	  Chapter 8, Stream.allMatch. Call the method repeatedly on a large
	  array and measure the runtime with assertions enabled,
	  disabled, and removed.
	  Too much work, i wont work with assertions as testing tool;
	*/
    }
    
    
}

