package ch04;

/*
 Write a “universal” toString method that uses reflection to yield a string
 with all instance variables of an object. 
 Extra credit if you can handle cyclic references.
 */

import ch04.SomeObject;

public class UniversalToString {

    
    public static void main(String[] args)
    {
	int[] someInts = {1, 2};
	SomeObject someObject = new SomeObject("try", someInts, 3.0);
	System.out.println(someObject.toString());
	
	
    }


}
