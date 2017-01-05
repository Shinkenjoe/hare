package ch05;

import java.util.*;
import java.io.*;
import java.nio.file.*;
import java.lang.IllegalStateException;

public class ScanWrite{
    
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
	*/
    public static void smallit(String filename, String outFilename)
	throws FileNotFoundException, IOException {
	Scanner in = null;
	PrintWriter out = null;
	try {
	    in = new Scanner(Paths.get(filename));
	    out = new PrintWriter(outFilename);
	    while (in.hasNext())
		out.println(in.next().toLowerCase());
	    in.close();
	    out.close();
	} catch (InvalidPathException exc) {
	    System.out.println("Filename not compatible with op system");
	    throw exc;
	} catch (FileNotFoundException exc) {
	    System.out.println("File not found for output");
	    try {
		in.close();
		System.out.println (in.toString());

	    } catch (Exception closeExc) {
		exc.addSuppressed(closeExc);
		throw exc;
	    }
	    throw exc;
	} catch (IOException exc){
	    System.out.println("File not found for input");
	    throw exc;
	} catch (IllegalStateException exc){
	    System.out.println("Scanner was closed");
	    try {
		in.close();
		out.close();
	    } catch (Exception closeExc) {
		exc.addSuppressed(closeExc);
		throw exc;
	    }
	    throw exc;
	} catch (NoSuchElementException exc){
	    System.out.println("Scanner runs on no elements");
	    in.close();
	    try {
		in.close();
		out.close();
	    } catch (Exception closeExc) {
		exc.addSuppressed(closeExc);
		throw exc;
		}	    
	    throw exc;
	} catch (Exception exc) {
	    System.out.println("Problems closing in or out");
	    throw exc;	
	}	
    }
}
 

