package quizWizApp;

import java.util.Scanner;

public class QuizMenu {

	public String AdminUserId;
	public String AdminPassword;
	public int menuSelection;

//-------------------------------------------------------------------------------------------------------------------------------
	// *****START MENU*******
	// This is the first Menu All users will see when program begins
	public void startMenu() {

		System.out.println("Welcome to Quiz Wiz Pro ");
		System.out.println("1. Press 1 if You are a STUDENT ");
		System.out.println("2. Press 2 if you are an ADMINISTRATOR ");
		// gets and input from user
		Scanner inputStartMenu = new Scanner(System.in);
		int menuSelectionStartMenu = inputStartMenu.nextInt();

		if (menuSelectionStartMenu == 1) {
			studentLoginPrompt();
		} else if (menuSelectionStartMenu == 2) {
			adminLoginPrompt();
		}

	}

	// ---------------------------------------------------------------------------------------------------------------------------
	// ***Login Prompt Menu***
	public void studentLoginPrompt() {
		Scanner inputStudentM = new Scanner(System.in);

		System.out.println("Please Select From THe Following Options");
		System.out.println("1. I already have a Student account ");
		System.out.println("2. Create a Student account ");
		System.out.println("3. Go Back ");
		System.out.println("4. Exit Program ");
		int studentMenuSelection = inputStudentM.nextInt();

		if (studentMenuSelection == 1) {
			QuizAppUser studentUser = new QuizAppUser();
			studentUser.studentLogin();
		} else if (studentMenuSelection == 2) {

			QuizAppUser studentUser = new QuizAppUser();
			studentUser.createUser();
			
		}else if (studentMenuSelection == 3) {
			startMenu();

		} else if (studentMenuSelection == 4) {
			System.exit(studentMenuSelection);

		}

	}

	// admin login prompt menu method
	public void adminLoginPrompt() {
		Scanner adminStudentM = new Scanner(System.in);

		System.out.println("Please Select From THe Following Options");
		System.out.println("1. I already have a Admin account ");
		System.out.println("2. Create an Admin account ");
		System.out.println("3. Go Back ");
		System.out.println("4. Exit Program ");
		int adminMenuSelection = adminStudentM.nextInt();

		if (adminMenuSelection == 1) {
			QuizAppUser adminUser = new QuizAppUser();
			adminUser.adminLogin();
		} else if (adminMenuSelection == 2) {

			QuizAppUser adminUser1 = new QuizAppUser();
			adminUser1.createUser();

		} else if (adminMenuSelection == 3) {
			startMenu();

		} else if (adminMenuSelection == 4) {
			System.exit(adminMenuSelection);

		}

	} // end of adminLoginPrompt

	// ---------------------------------------------------------------------------------------------------------------------------------------------------------------------
	// *** once a student is logged in they will see this menu
	// ***Student Main Menu***
	public void studentMenu() {

		Scanner inputSInterface = new Scanner(System.in);

		System.out.println("1. Take Quiz");
		System.out.println("2. Check Quiz Scores ");
		System.out.println("3. Go Back ");
		System.out.println("4. Exit Program ");

		int interfaceSelection = inputSInterface.nextInt();

		if (interfaceSelection == 1) {
			System.out.println("This Function has not yet been coded");
		} else if (interfaceSelection == 2) {

			System.out.println("This Function has not yet been coded");
		}else if(interfaceSelection == 3) {
			startMenu();
		}else if (interfaceSelection == 4) {
			System.exit(interfaceSelection);

		}

	}// end of Student Menu

	// ----------------------------------------------------------------------------------------------------------------------------
	// ***Admin Menu ***
	public void adminMenu() {

		Scanner input = new Scanner(System.in);
		System.out.println("Welcome. Thank you for choosing QUIZZ WIZZ PRO \n" + "Team Trinity Software Group 2022 \n"
				+ "\n" + "please enter the the number of the task you wish to perform \n" + "\n"

		);

		System.out.println("1. Create a Quiz");
		System.out.println("2. Display a list of  Quizzes ");
		System.out.println("3. Edit a Quiz");
		System.out.println("4. Delete a Quiz");
		System.out.println("5. Deploy Quiz");
		System.out.println("6. Go Back");
		System.out.println("7. Exit program");

		menuSelection = input.nextInt();
		// input.close();

		if (menuSelection == 1) {

			QuizMaker q3 = new QuizMaker();
			q3.startBuildQuiz();

		} else if (menuSelection == 2) {
			System.out.println("This Function has not yet been coded");
			System.exit(menuSelection);
		} else if (menuSelection == 3) {
			System.out.println("This Function has not yet been coded");
			System.exit(menuSelection);
		} else if (menuSelection == 4) {
			System.out.println("This Function has not yet been coded");
			System.exit(menuSelection);
		} else if (menuSelection == 5) {
			System.out.println("This Function has not yet been coded");
			System.exit(menuSelection);
		} else if (menuSelection == 6) {
			System.out.println("This Function has not yet been coded");
			System.exit(menuSelection);
		} else if (menuSelection == 7) {
			System.exit(menuSelection);
		}

	}

}