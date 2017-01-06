package ch06;

import java.lang.reflect.Array;


	/* 2. Reimplement the Stack<E> class, using an array to hold the
	   elements. If necessary grow  the array in the push method. 
	   Provide two solutions, one with  an E[] array and one with an
	   Object[] array. Both solutions should compile without warnings.
	   Which do you prefer, and why?*/


public class ArrayGenStack<T>{
    private T[] daArray;
    private int daEnd;
    private Class clazz;
	
    
    public ArrayGenStack(Class<T> clazz){
	@SuppressWarnings("unchecked")
	T[] tempArray = (T[]) Array.newInstance(clazz, 1);
	this.daArray = tempArray;
	this.daEnd = 0;
	this.clazz = clazz;
    }
    public void push(T el) {
	if (this.daEnd == this.daArray.length){
	    @SuppressWarnings("unchecked")
	    T[] broader = (T[]) Array.newInstance(this.clazz,
						  this.daArray.length + 32);
	    for (int i = 0; i < this.daArray.length; i++){
		broader[i] = this.daArray[i];
	    }
	    this.daArray = broader;
	}
	this.daArray[daEnd] = el;
	this.daEnd++;
    }
    public T pop(){
	this.daEnd--;
	return this.daArray[this.daEnd];
    }
    public boolean isEmpty() {return this.daEnd == 0;}
}
