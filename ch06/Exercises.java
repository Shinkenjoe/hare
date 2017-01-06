package ch06;

import ch06.MyStack;
import ch06.ArrayGenStack;
import ch06.ArrayObStack;
import ch06.Table;
import java.util.Arrays;

public class Exercises{
    public static void main(String... args){
	/*1. Implement a class Stack<E> that manages an array list of elements
	  of type E. Provide methods push, pop, and isEmpty. */
	System.out.println("\n6.1 MyStack\n");
	System.out.println("Building a stack of Integers, popping and pushing");
	MyStack<Integer> stack1 = new MyStack<>();
	stack1.push(23);
	stack1.push(2);
	stack1.pop();
	System.out.print("Should be false: " );
	System.out.println(stack1.isEmpty());
	stack1.pop();
	System.out.println("Should be true (isEmpty): ");
	System.out.println (stack1.isEmpty());
	System.out.println("Building a stack of String, popping and pushing");
	MyStack<String> stack2 = new MyStack<>();
	stack2.push("To find a needle in a hay stack, " +
		   "you need a hay stack first");
	System.out.println(stack2.pop());
	/* 2. Reimplement the Stack<E> class, using an array to hold the
	   elements. If necessary grow  the array in the push method. 
	   Provide two solutions, one with  an E[] array and one with an
	   Object[] array. Both solutions should compile without warnings.
	   Which do you prefer, and why?*/
	
	System.out.println("\n6.2 Array Stacks\n");
	// runtime methods return capture class Class<CAP#1>, only field works;
	ArrayGenStack<String> genStack =
	    new ArrayGenStack<String>(String.class);
	
	genStack.push("Hi");
	genStack.push("there");
	System.out.println(genStack.pop());
	System.out.println(genStack.pop());
	
	ArrayObStack obStack = new ArrayObStack();
	obStack.push("Hi");
	obStack.push("there");
	System.out.println(obStack.pop());
	System.out.println(obStack.pop());

	// I like the Object[] version more: the Generics version is just a
	// pain in the ass: thousand tweeks to make it work, as a generic
	// array isnt wanted in java, eg supply the uncaptured class,
	// create array with  Array.newInstance and cast, Suppress Warnings;
	
	/*3. Implement a class Table<K, V> that manages an array list of
	   Entry<K, V> elements. Supply methods to get the value associated
	   with a key, to put a value for a key, and to remove a key.*/
	/* Test see at 4*/
	
	/*4. In the previous exercise, make Entry into a nested class.
	  Should that class be generic?*/

	/*Needs not To be generic, because Object would suffice;
	  Generics give better error messages though*/

	System.out.println("\n6.3&4 Table of Entries\n");

	Table<Integer, String> daTable = new Table<>();
	daTable.set(1, "Ke Jie");
	daTable.set(2, "Park Jungwhan");
	daTable.set(3, "Chen Yaoye");
	System.out.println(daTable.get(2));
	daTable.remove(3);
	System.out.println(daTable.get(3));
	

	/*5. Consider this variant of the swap method where the array can be
	  supplied with varargs:
    
	   
	public static <T> T[] swap(int i, int j, T... values) {
	    T temp = values[i];
	    values[i] = values[j];
	    values[j] = temp;
	    return values;
	*/
    
	
	//Now have a look at the call
	//Double[] result = Exercises.swap(0, 1, 1.5, 2, 3);
	//What error message do you get?
	/*incompatible types: inferred type does not conform to upper bound(s)
	  Double[] result = Exercises.swap(0, 1, 1.5, 2, 3);
	                                   ^
	  inferred: INT#1
	  upper bound(s): Double,Object
	  where INT#1,INT#2 are intersection types:
	  INT#1 extends Number,Comparable<? extends INT#2>
	  INT#2 extends Number,Comparable<?>
	  
	  Now call*/
	//Double[] result = Exercises.<Double>swap(0, 1, 1.5, 2, 3);
	//Has the error message improved? What do you do to fix the problem?

	/*ch06/Exercises.java:103: error: method swap in class
	  Exercises cannot be applied to given types;
	  Double[] result = Exercises.<Double>swap(0, 1, 1.5, 2, 3);
	                             ^
	  required: int,int,T[]
	  found: int,int,double,int,int
	  reason: varargs mismatch; int cannot be converted to Double
	  where T is a type-variable:
	  T extends Object declared in method <T>swap(int,int,T...)
	  
	  the varargs must be given as floats
	*/
	Double[] result = Exercises.<Double>swap(0, 1, 1.5, 2., 3.);

	/*6. Implement a generic method that appends all elements from one 
	  array list to another. Use a wildcard for one of the type arguments.
	  Provide two equivalent solutions, one with a ? extends E wildcard 
	  and one with ? super E.*/

	/*7. Implement a class Pair<E> that stores a pair of elements of type E.
	  Provide accessors to get the first and second element. */

	/*8. Modify the class of the preceding exercise by adding methods max 
	  and min, getting the larger or smaller of the two elements. Supply an 
	  appropriate type bound for E.*/

	/*9. In a utility class Arrays, supply a method 
	  public static <E> Pair<E> firstLast(ArrayList<___> a)
	  that returns a pair consisting of the first and last element of a.
	  Supply an appropriate type argument.*/

	/*10. Provide generic methods min and max in an Arrays utility class
	  that yield the smallest and largest element in an array.*/

	/*11. Continue the preceding exercise and provide a method minMax that
	  yields a Pair with the minimum and maximum.*/

	/*12. Implement the following method that stores the smallest and
	  largest element in elements in the result list:	  
	  public static <T> void minmax(List<T> elements,
	  Comparator<? super T> comp, List<? super T> result)
	  Note the wildcard in the last parameter—any supertype of T will do
	  to hold the result.*/

	/*13. Given the method from the preceding exercise, consider this method:
	  public static <T> void maxmin(List<T> elements,
	  Comparator<? super T> comp, List<? super T> result) {
	  minmax(elements, comp, result);
	  Lists.swapHelper(result, 0, 1);
	  }
	  Why would this method not compile without wildcard capture?
	  Hint: Try to supply an explicit 
	  type Lists.<___>swapHelper(result, 0, 1).*/

	/*14. Implement an improved version of the closeAll method in Section
	  6.3, “Type Bounds,” on p. 202. Close all elements even if some of them
	  throw an exception. In that case, throw an exception afterwards. If
	  two or more calls throw an exception, chain them together.*/

	/*15. Implement a method map that receives an array list and a
	  Function<T, R> object (see Chapter 3), and that returns an array list
	  consisting of the results of applying the function to the given
	  elements. */

	/*16. What is the erasure of the following methods in the Collection
	  class?
	  public static <T extends Comparable<? super T>>
	  void sort(List<T> list)
	  public static <T extends Object & Comparable<? super T>>
	  T max(Collection<? extends T> coll)*/

	/*17. Define a class Employee that implements Comparable<Employee>.
	  Using the javap utility, demonstrate that a bridge method has been
	  synthesized. What does it do?*/

	/*18. Consider the method
	  public static <T> T[] repeat(int n, T obj, IntFunction<T[]> constr)
	  in Section 6.6.3, “You Cannot Instantiate Type Variables,” on p. 213.
	  The call Arrays.repeat(10, 42, int[]::new) will fail. 
	  Why? How can you fix that? What do you need to do for the other 
	  primitive types?*/

	/*19. Consider the method 
	  public static <T> ArrayList<T> repeat(int n, T obj)
	  in Section 6.6.3, “You Cannot Instantiate Type Variables,” on p. 213.
	  This method had no trouble constructing an ArrayList<T> which contains
	  an array of T values. Can you produce a T[] array from that
	  array list without using a Class value or a constructor reference?
	  If not, why not?*/

	/*20. Implement the method
	  @SafeVarargs public static final <T> T[] repeat(int n,
	  T... objs)
	  Return an array with n copies of the given objects. Note that no Class
	  value or constructor reference is required since you can 
	  reflectively increase objs.*/

	/*21. Using the @SafeVarargs annotation, write a method that can 
	  construct arrays of generic types. For example,
	  List<String>[] result = Arrays.<List<String>>construct(10);
	  // Sets result to a List<String>[] of size 10*/

	/*22. Improve the method
	  public static <V, T> V doWork(Callable<V> c, T ex) throws T
	  of Section 6.6.7, “Exceptions and Generics,” on p. 217 so
	  that one doesn’t have to pass an exception object, which may never
	  get used. Instead, accept a constructor reference for the exception
	  class.*/

	/*23. In the cautionary note at the end of Section 6.6.7,
	  “Exceptions and Generics,” on p. 217, the throwAs helper method is
	  used to “cast” ex into a RuntimeException and rethrow it. Why can’t
	  you use a regular cast, i.e. throw (RuntimeException) ex?*/

	/*24. Which methods can you call on a variable of type Class<?>
	  without using casts?*/

	/*25. Write a method 
	  public static String genericDeclaration(Method m) that returns the
	  declaration of the method m listing the type parameters with their
	  bounds and the types of the method parameters, including their type
	  arguments if they are generic types.*/
    
    }

    

    /*5. Consider this variant of the swap method where the array can be
      supplied with varargs:*/
    
    @SuppressWarnings("unchecked")
    public static <T> T[] swap(int i, int j, T... values) {
	T temp = values[i];
	values[i] = values[j];
	values[j] = temp;
	return values;
    }
  
}
