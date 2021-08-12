package exception_handling;

import java.io.IOException;

/**
 * Class Name: CST8284-300 Assignment3 
 * Author Name: Chunfang Song 
 * ClassName:SolutionTwo 
 * Date: August 11, 2021
 */

/*
 * Class SolutionTwo will perform exception handling that the exception of
 * subclass ExceptionBlue/ExceptionYellow/NullPointerException/IOException will
 * be caught by the superclass Exception type
 */
public class SolutionTwo {

	// entry point of the program
	public static void main(String[] args) {

		SolutionTwo solution = new SolutionTwo(); // instantiate a SolutionTwo object

		try {
			throw solution.new ExceptionBlue();// instantiate an ExceptionBlue object and throw it

		} catch (Exception exception) {// if caught the exception type of Exception, then execute following code
			System.out.println("Caught ExceptionBlue");
			exception.printStackTrace();// print the throwable and its backtrace to the standard error stream
		}
		System.out.println("--------------------------------------------------------------");

		try {
			throw solution.new ExceptionYellow();// instantiate an ExceptionYellow object and throw it
		} catch (Exception exception) {// if caught the Exception type of exception, then execute following code
			System.out.println("Caught ExceptionYellow");
			exception.printStackTrace();// print the throwable and its backtrace to the standard error stream
		}

		System.out.println("--------------------------------------------------------------");

		try {
			throw new NullPointerException(); // throw a NullPointerException

		} catch (Exception exception) {// if caught the Exception type of exception, then execute following code
			System.out.println("Caught NullPointerException");
			exception.printStackTrace();// print the throwable and its backtrace to the standard error stream
		}
		System.out.println("--------------------------------------------------------------");

		try {
			throw new IOException();// throw IOException

		} catch (Exception exception) {// if caught the Exception type of exception, then execute following code
			System.out.println("Caught IOException");
			exception.printStackTrace();
		}

	}

	/* inner class ExceptionBlue is a subclass of Exception */
	class ExceptionBlue extends Exception {

	}

	/* inner class ExceptionYellow is a subclass of ExceptionBlue */
	class ExceptionYellow extends ExceptionBlue {

	}

}
