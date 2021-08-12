package exception_handling;

import java.io.IOException;

/**
 * Class Name: CST8284-300 Assignment3 
 * Author Name: Chunfang Song 
 * Class Name:SolutionFour 
 * Date: August 11,2021
 */

/*
 * Class SolutionFour will demonstrate the order of exception handling
 */
public class SolutionFour {

	// entry point of the program
	public static void main(String[] args) {

		Exception e1 = new Exception();// instantiate a Exception object
		IOException ioe = new IOException();// instantiate a IOException object

		try {
			throw ioe;
		} catch (Exception e) {// if caught the exception type of ExceptionOne, then execute following code

			System.out.println("Caught Exception type exception");
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
		/*
		 * because IOException inherits from Exception, we already caught the superclass
		 * exception type before, here we got a compilation error
		 */
		catch (IOException e) {

			System.out.println("Caught IOException type exception");
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
	}

}
