package library;

import java.util.Scanner;

/**
 * Class Name: CST8284-300 Assignment2 
 * Author Name: Chunfang Song 
 * Class Name: AppDriver 
 * Date: July 15,2021
 */
/*
 * AppDriver class with startApp,displayAppMenu and executeMenuItem methods and
 * relevant supporting variables. it will accept and process the user choices
 * and will call the relevant method to execute.
 */
public class AppDriver {
	private static final int APP_EXIT = 0, APP_ADD_BOOK = 1, APP_MOD_BOOK = 2, APP_FIND_BOOK = 3, APP_LIST_BOOK = 4,
			APP_ADD_USER = 5, APP_MOD_USER = 6, APP_FIND_USER = 7, APP_LIST_USERS = 8, APP_ADD_LOAN = 9,
			APP_MOD_LOAN = 10, APP_FIND_LOAN = 11, APP_LIST_LOANS = 12, APP_DEL_BOOK = 13, APP_DEL_USER = 14,
			APP_DEL_LOAN = 15;

	private static Scanner input = new Scanner(System.in);
	public LendingLibraryController appControl = new LendingLibraryController();

	/*
	 * startApp method has a loop, will call the displayAppMenu method to display
	 * the menu to user and executeMenuItem method base on the user input choice,
	 * only when the input is APP_EXIT will end the loop.
	 */
	public void startApp() {
		int choice = 0;
		while (true) {
			choice = displayAppMenu();
			input.nextLine(); // remove enter key character
			if (choice == APP_EXIT) {
				System.out.println("Good Bye!");
				break;
			}
			executeMenuItem(choice);
		}
	}

	/*
	 * displayAppMenu method will output the main menu for user to choose, and will
	 * return a int number base on the user input
	 */
	private int displayAppMenu() {
		System.out.printf("\n%s\n\t%s\n\t%s\n\t%s\n\t%s\n", "Enter a selectoin from the following menu:",
				APP_ADD_BOOK + ".Enter a new book",
				APP_MOD_BOOK + ".Modify the book details.Enter the book isbn number",
				APP_FIND_BOOK + ".Find a book by isbn number", APP_LIST_BOOK + ".Display list of all books\n");
		System.out.printf("\t%s\n\t%s\n\t%s\n\t%s\n", APP_ADD_USER + ".Add a new user",
				APP_MOD_USER + ".Modify user details", APP_FIND_USER + ".Find a user by name",
				APP_LIST_USERS + ".Display all users\n");
		System.out.printf("\t%s\n\t%s\n\t%s\n\t%s\n",
				APP_ADD_LOAN + ".Add a loan. Link a user name to a book by isbn number",
				APP_MOD_LOAN + ".Modify a loan. Loan is identified by isbn number",
				APP_FIND_LOAN + ".Find a loan. Loan is identified by isbn number",
				APP_LIST_LOANS + ".Display all loans\n");
		System.out.printf("\t%s\n\t%s\n\t%s\n", APP_DEL_BOOK + ".Delete a book", APP_DEL_USER + ".Delete a user",
				APP_DEL_LOAN + ".Delete a loan\n");
		System.out.println("\t" + APP_EXIT + ".Exit program");

		while (true) {
			if (input.hasNextInt()) {
				return (input.nextInt());
			} else {
				System.out.println("Invalid input, try again!");
				input.nextLine(); // remove enter key character
			}
		}
	}

	/*
	 * executeMenuItem method with switch-case structure to execute the
	 * corresponding program base on the user input. appControl is the instance of
	 * class LendingLibraryController, will use appControl to call corresponding
	 * method in LendingLibraryController
	 */
	private void executeMenuItem(int choice) {
		switch (choice) {
		case APP_ADD_BOOK:
			appControl.addBook();
			break;
		case APP_MOD_BOOK:
			appControl.changeBook();
			break;
		case APP_FIND_BOOK:
			appControl.findBook();
			break;
		case APP_LIST_BOOK:
			appControl.listBook();
			break;
		case APP_ADD_USER:
			appControl.addUser();
			break;
		case APP_MOD_USER:
			appControl.changeUser();
			break;
		case APP_FIND_USER:
			appControl.findUser();
			break;
		case APP_LIST_USERS:
			appControl.listUser();
			break;
		case APP_ADD_LOAN:
			appControl.addBookLoan();
			break;
		case APP_MOD_LOAN:
			appControl.chageBookLoan();
			break;
		case APP_FIND_LOAN:
			appControl.findBookLoan();
			break;
		case APP_LIST_LOANS:
			appControl.listBookLoans();
			break;
		case APP_DEL_BOOK:
			appControl.deleteBook();
			break;
		case APP_DEL_USER:
			appControl.deleteUser();
			break;
		case APP_DEL_LOAN:
			appControl.deleteBookLoan();
			break;
		default:
			System.out.println("Invalid choice. Choose again!");
		}
	}
}
