package polylab;

//Programmer hierarchy test program.

import java.util.Scanner;

/** This program uses Scanner to obtain user input */

public class MyPaySystemTest {
	public static void main(String[] args) {
		// create subclass objects
		SalariedProgrammer salariedProgrammer = new SalariedProgrammer("Emmanuel", "Okoro", "123-11-4567", 6, 1992,
				500.00);
		HourlyProgrammer hourlyProgrammer = new HourlyProgrammer("Mary", "Cheng", "890-22-1234", 12, 1981, 16.75, 40);
		CommissionProgrammer commissionProgrammer = new CommissionProgrammer("Martha", "Peter", "567-33-8901", 9, 1983,
				23000, .06);
		BasePlusCommissionProgrammer basePlusCommissionProgrammer = new BasePlusCommissionProgrammer("John", "Mark",
				"234-44-5678", 3, 1978, 9000, .04, 300);

		System.out.println("Programmers are processed individually:\n");

		System.out.printf("%s\n%s: $%,.2f\n\n", salariedProgrammer, "earned", salariedProgrammer.earnings());
		System.out.printf("%s\n%s: $%,.2f\n\n", hourlyProgrammer, "earned", hourlyProgrammer.earnings());
		System.out.printf("%s\n%s: $%,.2f\n\n", commissionProgrammer, "earned", commissionProgrammer.earnings());
		System.out.printf("%s\n%s: $%,.2f\n\n", basePlusCommissionProgrammer, "earned",
				basePlusCommissionProgrammer.earnings());

		/** create and initialize the programmer array */

		// TO DO: COMPLETE THIS PORTION. INSERT YOUR OWN CODE:
		// create the Programmer array elements as required.
		// Hint: How many elements array do you need to create? DO SO HERE!!!

		// START
		Programmer[] programmer = { salariedProgrammer, hourlyProgrammer, commissionProgrammer,
				basePlusCommissionProgrammer };
		// END

		// IMPLEMENT THE USE OF A SCANNER TO GET THE CURRENT MONTH. COMPLETE THIS
		// PORTION!!!!
		// START
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the current month (1 - 12): ");
		// END

		// TO DO: GET AND VALIDATE THE CURRENT MONTH. COMPLETE THIS PORTION!!!!

		// START
		int currentMonth;
		while (true) {
			if (!input.hasNextInt()) {
				System.out.println("Invalid input, please try again!");
				input.nextLine(); // remove enter key character
			} else {
				currentMonth = input.nextInt();
				input.nextLine(); // remove enter key character
				if (currentMonth <= 0 || currentMonth > 12) {
					System.out.println("Enter the current month (1 - 12): ");
				} else {
					break;
				}
			}
		}
		// END

		System.out.println("Programmers processed polymorphically:\n");

		// generically process each element in array
		for (Programmer currentProgrammer : programmer) {
			System.out.println(currentProgrammer); // invokes toString

			// determine whether element is a BasePlusCommissionProgrammer
			if (currentProgrammer instanceof BasePlusCommissionProgrammer) {
				// downcast Programmer reference to
				// BasePlusCommissionProgrammer reference
				BasePlusCommissionProgrammer programmers = (BasePlusCommissionProgrammer) currentProgrammer;

				double oldBaseSalary = programmers.getBaseSalary();
				programmers.setBaseSalary(1.10 * oldBaseSalary);
				System.out.printf("new base salary with 10%% increase is: $%,.2f\n", programmers.getBaseSalary());
			}

			// TO DO: COMPLETE THIS PORTION: if this is the month of the programmer's
			// birthday, add $500 to his salary
			// otherwise just state what this programmer currently earned.

			// START
			if (currentMonth == currentProgrammer.getBirthDate().getMonth()) {
				System.out.printf("earned $%,.2f %s\n\n", currentProgrammer.earnings(), " plus $500.00 birthday bonus");
			} else {
				System.out.printf("earned $%,.2f\n\n", currentProgrammer.earnings());
			}
			// END
		}

		// get type name of each object in programmers array
		for (int j = 0; j < programmer.length; j++) {
			System.out.printf("Programmer %d is a %s\n", j, programmer[j].getClass().getName());
		}
	}
}
