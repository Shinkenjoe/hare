package ch05;

import java.util.*;
import java.lang.Thread;
import java.util.function.IntUnaryOperator;

public class StackFactorial implements IntUnaryOperator {

    public int applyAsInt(int operand){
	if (operand == 0){
	    StackTraceElement[] frame = Thread.currentThread().getStackTrace();
	    ArrayList<String> frameStrings = new ArrayList<>();
	    for (StackTraceElement el : frame)
		frameStrings.add(el.toString());
	    System.out.println(String.join("\n", frameStrings));
	    return 1;
	} else {
	    return operand * applyAsInt(operand - 1);
	}
    }
}
    
