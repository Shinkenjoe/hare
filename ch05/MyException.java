package ch05;

/*10 Write a recursive factorial method in which you print all stack frames
      before you return the value. Construct (but don’t throw) an exception
      object of any kind and get its stack trace, as described in Section 
      5.1.8, “The Stack Trace,” on p. 184.
    */


public class MyException extends Exception {
    public MyException() { super(); }
    public MyException(String message) { super(message); }
    public MyException(String message, Throwable cause)
    { super(message, cause); }
    public MyException(Throwable cause) { super(cause); }
}
