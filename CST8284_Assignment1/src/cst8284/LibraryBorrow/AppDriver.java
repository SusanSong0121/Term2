package cst8284.LibraryBorrow;

import java.util.Scanner;

/**
 * Class Name: CST8284-300 Assignment1
 * Author Name: Chunfang Song
 * Class Name: AppDriver
 * Date: June 14,2021
 */

public class AppDriver {
	private static final int APP_EXIT = 0,
			APP_ADD_BOOK = 1,
			APP_MOD_BOOK = 2,
			APP_FIND_BOOK = 3,
			APP_LIST_BOOK = 4,
			APP_ADD_USER = 5,
			APP_MOD_USER = 6,
			APP_FIND_USER = 7,
			APP_LIST_USERS = 8,
			APP_ADD_LOAN = 9,
			APP_MOD_LOAN = 10,
			APP_FIND_LOAN = 11,
			APP_LIST_LOANS = 12;
	private static Scanner input = new Scanner(System.in); 
	public LendingLibraryController appControl = new LendingLibraryController();
	
	public void startApp() {
		int choice = 0;
		while(true) {
			choice = displayAppMenu();
			if (choice == APP_EXIT) {
				System.out.println("Good Bye!");
				break;
			}
			executeMenuItem(choice);
		}
	}
	
	private int displayAppMenu() {
		System.out.printf("\n%s\n\t%s\n\t%s\n\t%s\n\t%s\n",
				"Enter a selectoin from the following menu:",
				APP_ADD_BOOK + ".Enter a new book",
				APP_MOD_BOOK + ".Modify the book details.Enter the book isbn number",
				APP_FIND_BOOK + ".Find a book by isbn number",
				APP_LIST_BOOK + ".Display list of all books\n");
		System.out.printf("\t%s\n\t%s\n\t%s\n\t%s\n",
				APP_ADD_USER + ".Add a new user",
				APP_MOD_USER + ".Modify user details",
				APP_FIND_USER + ".Find a user by name",
				APP_LIST_USERS + ".Display all users\n");
		System.out.printf("\t%s\n\t%s\n\t%s\n\t%s\n",
				APP_ADD_LOAN + ".Add a loan. Link a user name to a book by isbn number",
				APP_MOD_LOAN + ".Modify a loan. Loan is identified by isbn number",
				APP_FIND_LOAN + ".Find a loan. Loan is identified by isbn number",
				APP_LIST_LOANS + ".Display all loans\n");
		System.out.println("\t" + APP_EXIT + ".Exit program");
		return(input.nextInt());
	}
	
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
		default:
			System.out.println("Invalid choice. Choose again!");
		}
	}
}
