package ch04;



/*
 Write a “universal” toString method that uses reflection to yield a string
 with all instance variables of an object. 
 Extra credit if you can handle cyclic references.
 */

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import ch04.MotherObject;
import java.util.*;

public class SomeObject extends MotherObject{
    public String someString;
    private int[] someInts;

    public SomeObject(String aString, int[] Ints, double aDouble) {
	super(aDouble);
	this.someString = aString;
	this.someInts = Ints;
    }


    public String toString()   {
	Class<?> cl = this.getClass();
	// get fields declared in the class itsself
	List<Field> fields = new ArrayList<Field>
	    (Arrays.asList(cl.getDeclaredFields()));
	Field[] publicFields = cl.getFields();
	// add also inherited public fields
	for (Field field: publicFields) {
	    if (!fields.contains(field)) {
		fields.add(field);
	    }
	}
	String resultString = "";
	for (Field field : fields){
	    field.setAccessible(true);
	    Class<?> type = field.getType();
	    Class
	    resultString +=  "\n";
	    
	    
	}
	return resultString;		
    }
}
    
	    


