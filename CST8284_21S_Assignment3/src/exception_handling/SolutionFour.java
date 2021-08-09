package exception_handling;
import java.io.IOException;

/**
 * Class Name: CST8284-300 Assignment3 
 * Author Name: Chunfang Song 
 * Class Name: SolutionFour 
 * Date: August 8,2021
 */

public class SolutionFour {

	public SolutionFour() {
		
	}

	public static void main(String[] args) {

		try {
			Exception e1 = new Exception("test exception");
			IOException e2 = new IOException("test 2");
			throw e2;
		}
		catch (Exception e) {

			System.out.println("Caught superclass exception");
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
		catch (IOException e) {

			System.out.println("Caught subclass exception");
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
//		catch (Exception e) {
//
//			System.out.println("Caught superclass exception");
//			System.err.println(e.getMessage());
//			e.printStackTrace();
//		}
	}

}
