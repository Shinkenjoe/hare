package ch05;

import java.util.*;
import java.io.*;
import java.nio.charset.*;
import java.nio.file.*;

public class RewriteFinally{

    public static void run(String filename){
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
	
	BufferedReader in = null;
	String line = null;
	Path path = Paths.get(filename);
	System.out.println(" a try catch in the finally statement");
	try {
	    in = Files.newBufferedReader(path, StandardCharsets.UTF_8);
	    while ((line = in.readLine()) != null){
		System.out.println(line);
	    } 
	} catch (IOException ex) {
	    System.err.println("Caught IOException: " + ex.getMessage());
	} finally {
	    if (in != null) {
		try {
		    in.close(); // Caution—might throw an exception
		} catch (Exception e) {
		    System.out.println("caught an exception while closing");
		}
		
	    }
	}

	

	System.out.println("a try catch statement containing a try finally");
	try {
	    try{
		in = Files.newBufferedReader(path, StandardCharsets.UTF_8);
		while ((line = in.readLine()) != null){
		    System.out.println(line);
		}
	    }
	    finally {
		if (in != null) {
		    in.close(); // Caution—might throw an exception
		}
	    }
	} catch (IOException ex) {
	    System.err.println("Caught IOException: " + ex.getMessage());
	} catch (Exception e) {
	    System.out.println("caught an exception while closing");
			}		
    

	System.out.println("a try with resources");
	try (BufferedReader in2 =
	     Files.newBufferedReader(path, StandardCharsets.UTF_8);){
	    while ((line = in2.readLine()) != null){
		System.out.println(line);}
	}  catch (IOException ex) {
	    System.err.println("Caught IOException: " + ex.getMessage());
	}
    }
}
