package ch06;

import java.util.ArrayList;

/*1. Implement a class Stack<E> that manages an array list of elements
  of type E. Provide methods push, pop, and isEmpty. */


public class MyStack<T>{
    private ArrayList<T> daList;
    
    public MyStack(){
	this.daList = new ArrayList<>();
    };

    public void push(T el) { daList.add(el); }
    public T pop(){ return daList.remove(daList.size() - 1);}
    public boolean isEmpty() {return daList.isEmpty();}
    
}
