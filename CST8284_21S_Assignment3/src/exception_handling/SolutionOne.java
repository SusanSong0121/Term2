package exception_handling;

/**
 * Class Name: CST8284-300 Assignment3 
 * Author Name: Chunfang Song 
 * Class Name: SolutionOne 
 * Date: August 8,2021
 */

public class SolutionOne {

	public SolutionOne() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
//		try {
//			throw new SolutionOne().new ExceptionTwo();
//			
//		} catch (ExceptionThree exception) {
//			
//			System.out.println("Catch exception for ExceptionThree");
//			System.err.println(exception.getMessage());
//			exception.printStackTrace();
//		} catch (ExceptionTwo exception) {
//
//			System.err.println("Catch exception for ExceptionTwo: " + exception.getMessage());
//			exception.printStackTrace();
//		} catch (ExceptionOne exception) {
//
//			System.err.println("Catch exception for ExceptionOne: " + exception.getMessage());
//			exception.printStackTrace();
//		} catch (Exception exception) {
//			System.out.println("in Exception");
//		}
		

		try {
			throw new SolutionOne().new ExceptionTwo();
			
		} catch (ExceptionOne exception) {

			System.err.println("Catch exception for ExceptionOne: " + exception.getMessage());
			exception.printStackTrace();
		}
		System.out.println("--------------------------------------------------------------");

		try {
			throw new SolutionOne().new ExceptionThree();
			
		} catch (ExceptionOne exception) {

			System.err.println("Catch exception for ExceptionOne: " + exception.getMessage());
			exception.printStackTrace();
		}
	}

	public class ExceptionOne extends Exception {

	}

	public class ExceptionTwo extends ExceptionOne {

	}

	public class ExceptionThree extends ExceptionTwo {

	}
}
