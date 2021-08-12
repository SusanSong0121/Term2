package exception_handling;

/**
 * Class Name: CST8284-300 Assignment3 
 * Author Name: Chunfang Song
 * ClassName:SolutionOne 
 * Date: August 11,2021
 */

/*
 * Class SolutionOne will perform exception handling that the exception of
 * subclass ExceptiongTwo&ExceptionThree will be caught by the superclass
 * ExceptionOne type
 */
public class SolutionOne {

	// entry point of the program
	public static void main(String[] args) {

		SolutionOne solution = new SolutionOne(); // instantiate a SolutionOne object

		try {
			throw solution.new ExceptionTwo(); // instantiate an ExceptionTwo object and throw it

		} catch (ExceptionOne exception) { // if caught the exception type of ExceptionOne, then execute following code
										
			System.err.println("Catch exception type: ExceptionOne");
			exception.printStackTrace();// print the throwable and its backtrace to the standard error stream
		}

		System.out.println("--------------------------------------------------------------");

		try {
			throw solution.new ExceptionThree(); // instantiate an ExceptionThree object and throw it

		} catch (ExceptionOne exception) {// if caught the exception type of ExceptionOne, then execute following code
										
			System.err.println("Catch exception type: ExceptionOne");
			exception.printStackTrace();// print the throwable and its backtrace to the standard error stream 
		}
	}

	/* inner class ExceptionOne is a subclass of Exception */
	public class ExceptionOne extends Exception {

	}

	/* inner class ExceptionTwo is a subclass of ExceptionOne */
	public class ExceptionTwo extends ExceptionOne {

	}

	/* inner class ExceptionThree is a subclass of ExceptionTwo */
	public class ExceptionThree extends ExceptionTwo {

	}
}
