package exception_handling;

/**
 * Class Name: CST8284-300 Assignment3 
 * Author Name: Chunfang Song 
 * Class Name: SolutionThree 
 * Date: August 11,2021
 */

/*
 * Class SolutionThree will perform rethrowing exception handling 
 */
public class SolutionThree {

	// entry point of the program
	public static void main(String[] args) {
		
		try
		{
			courseStarting(); //call coursStarting()
		}
		catch (Exception e)//if caught the Exception type exception then execute following code
		{
			System.out.println("Caught an exception");
			System.err.println(e.getMessage());
			e.printStackTrace();// print the throwable and its backtrace to the standard error stream
		}
	}
	
	//method courseEnding() initially throw an exception
	public static void courseEnding() throws Exception {
		throw new Exception("Exception thrown in courseEnding");
	}
	
	//method courseStarting() calls courseEnding and catch the rethrow exception
	public static void courseStarting() throws Exception {
		try {
			courseEnding();
		}
		catch (Exception e)
		{
			throw e;
		}
	}

}
