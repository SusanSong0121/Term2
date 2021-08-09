package exception_handling;

/**
 * Class Name: CST8284-300 Assignment3 
 * Author Name: Chunfang Song 
 * Class Name: SolutionThree 
 * Date: August 8,2021
 */

public class SolutionThree {

	public SolutionThree() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
		{
			courseStarting();
		}
		catch (Exception e)
		{
			System.out.println("Caught an exception");
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	public static void courseEnding() throws Exception {
		throw new Exception("Exception thrown in courseEnding");
	}
	
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
