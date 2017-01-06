package ch06;

import java.lang.Object;

	/* 2. Reimplement the Stack<E> class, using an array to hold the
	   elements. If necessary grow  the array in the push method. 
	   Provide two solutions, one with  an E[] array and one with an
	   Object[] array. Both solutions should compile without warnings.
	   Which do you prefer, and why?*/



public class ArrayObStack{
    private Object[] daArray;
    private int daEnd;
	
    
    public ArrayObStack(){
	this.daArray = new Object[1];
	this.daEnd = 0;
	
    }
    public void push(Object el) {
	if (this.daEnd == this.daArray.length - 1){
	    Object[] broader = new Object[this.daArray.length + 32];
	    for (int i = 0; i < this.daArray.length; i++){
		broader[i] = this.daArray[i];
	    }
	    this.daArray = broader;
	}
	this.daArray[daEnd] = el;
	this.daEnd++;
    }
    public Object pop(){
	this.daEnd--;
	return this.daArray[daEnd];
    }
    public boolean isEmpty() {return this.daEnd == 0;}
}
