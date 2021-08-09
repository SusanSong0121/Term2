package exception_handling;

import java.io.IOException;

/**
 * Class Name: CST8284-300 Assignment3 Author Name: Chunfang Song Class Name:
 * SolutionTwo Date: August 8,2021
 */

public class SolutionTwo {

	public SolutionTwo() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		try {
			throw new SolutionTwo().new ExceptionYellow();
		} catch (Exception exception) {
			System.out.println("Caught ExceptionYellow");
			System.err.println(exception.getMessage());
			exception.printStackTrace();
		}
		System.out.println("--------------------------------------------------------------");

		try {
			throw new SolutionTwo().new ExceptionBlue();
		} catch (Exception exception) {
			System.out.println("Caught ExceptionBlue");
			System.err.println(exception.getMessage());
			exception.printStackTrace();
		}
		System.out.println("--------------------------------------------------------------");

		try {
			throw new NullPointerException();
		} catch (Exception exception) {
			System.out.println("Caught NullPointerException");
			System.err.println(exception.getMessage());
			exception.printStackTrace();
		}
		System.out.println("--------------------------------------------------------------");

		try {
			throw new IOException();
		} catch (Exception exception) {
			System.out.println("Caught IOException");
			System.err.println(exception.getMessage());
			exception.printStackTrace();
		}

	}

	class ExceptionBlue extends Exception {

	}

	class ExceptionYellow extends Exception {

	}

}
