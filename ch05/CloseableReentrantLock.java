
package ch05;
import java.util.concurrent.locks.ReentrantLock;
import java.lang.AutoCloseable;

	/*
	  8. Design a helper method so that one can use a ReentrantLock in a
	  try-with-resources statement. Call lock and return an AutoCloseable
	  whose close method calls unlock and throws no exceptions.
	 */


public class CloseableReentrantLock extends ReentrantLock
    implements AutoCloseable{
    public void close(){
	try{
	    this.unlock();
	} catch (IllegalMonitorStateException exc) {
	    System.out.println("got a Monitor");
	}	
    }
}
