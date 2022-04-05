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
		System.out.println("Team Trinity Software Group 2022 ");
		System.out.println("CAPSTONE ");
		System.out.println("");
		System.out.println("1. Press 1 if You are a STUDENT ");
		System.out.println("2. Press 2 if you are an ADMINISTRATOR ");

		// gets and input from user
		Scanner inputStartMenu = new Scanner(System.in);
		int menuSelectionStartMenu = inputStartMenu.nextInt();

		if (menuSelectionStartMenu == 1) {
			// **If you are a Student
			studentLoginPrompt();
		} else if (menuSelectionStartMenu == 2) {
			// ***If you are and admin
			adminLoginPrompt();
		}

	}

	// ---------------------------------------------------------------------------------------------------------------------------
	// ***Login Prompt Menu***
	public void studentLoginPrompt() {
		Scanner inputStudentM = new Scanner(System.in);
		// ***Menu
		System.out.println("You are a Test Taking Student. Please Select From THe Following Options");
		System.out.println("1. I already have a Student account ");
		System.out.println("2. Create a Student account ");
		System.out.println("3. Go Back ");
		System.out.println("4. Exit Program ");
		int studentMenuSelection = inputStudentM.nextInt();

		if (studentMenuSelection == 1) {
			// ***I already Have a Student Account
			QuizAppUser studentUser = new QuizAppUser();
			studentUser.studentLogin();
		} else if (studentMenuSelection == 2) {
			// ***Create Student Account
			QuizAppUser studentUser = new QuizAppUser();
			try {
				studentUser.createNewUser();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else if (studentMenuSelection == 3) {
			// ***Go Back
			startMenu();

		} else if (studentMenuSelection == 4) {
			// ***Exit Program
			System.exit(studentMenuSelection);

		}

	}

	// admin login prompt menu method
	public void adminLoginPrompt() {
		Scanner adminStudentM = new Scanner(System.in);
		// escape Sequence to clear screen in console enivorment outside of IDE
		System.out.print("\033[H\033[2J");
		System.out.flush();
		System.out.println("You are an administrator. Please Select From The Following Options");
		System.out.println("1. I already have a Admin account ");
		System.out.println("2. Create an Admin account ");
		System.out.println("3. Go Back ");
		System.out.println("4. Exit Program ");
		int adminMenuSelection = adminStudentM.nextInt();

		if (adminMenuSelection == 1) {
			// *** I already have an account
			QuizAppUser adminUser = new QuizAppUser();
			adminUser.adminLogin();
		} else if (adminMenuSelection == 2) {
			// Create and admin account
			QuizAppUser adminUser1 = new QuizAppUser();
			try {
				adminUser1.createNewUser();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else if (adminMenuSelection == 3) {
			// ***Go Back
			startMenu();

		} else if (adminMenuSelection == 4) {
			// ***Exit
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
			// *** Take Quiz
			System.out.println("This Function has not yet been coded");
		} else if (interfaceSelection == 2) {

			System.out.println("This Function has not yet been coded");
			// ***Check Quizzes Taken and Quiz Score
		} else if (interfaceSelection == 3) {
			startMenu();
			// ***Exit Program
		} else if (interfaceSelection == 4) {
			System.exit(interfaceSelection);

		}

	}// end of Student Menu

	// ----------------------------------------------------------------------------------------------------------------------------
	// ***Admin Menu ***
	// This Menu will provide Admin with a list of the main features available to
	// them
	public void adminMenu() {

		Scanner input = new Scanner(System.in);
		System.out.println("Welcome. Thank you for choosing QUIZ WIZ PRO \n" + "Team Trinity Software Group 2022 \n"
				+ "\n" + "please enter the the number of the task you wish to perform \n" + "\n"

		);

		System.out.println("1. Create a Quiz");
		System.out.println("2. Display a list of  Quizzes ");
		System.out.println("3. Edit/Delete a Quiz");
		System.out.println("4. Quiz Simulation");
		System.out.println("5. Create Virtual Classroom");
		System.out.println("6. Go Back");
		System.out.println("7. Exit program");

		menuSelection = input.nextInt();
		// input.close();

		if (menuSelection == 1) {
			// *** This is The create a Quiz Method for Admins
			QuizMaker q3 = new QuizMaker();
			q3.startBuildQuiz();

		} else if (menuSelection == 2) {
			// **This Method will list all quizzes created by this Admin user
			System.out.println("This Function has not yet been coded");
			System.out.println("This Function when coded will fetch a list of quizzes created from SQL Databse");
			System.exit(menuSelection);
		} else if (menuSelection == 3) {
			// ***This Function will allow the user to edit and delete quizzes they have
			// created and stored
			System.out.println("This Function has not yet been coded");
			System.exit(menuSelection);
		} else if (menuSelection == 4) {
			// *** Quiz Simulation
			System.out.println("This Function has not yet been coded");
			System.out.println(
					"This Function when coded will allow admin to run a simulation of quizzes created as Admin.");
			System.exit(menuSelection);
		} else if (menuSelection == 5) {
			// ***Virtual Classroom Menu Method
			System.out.println("This Function has not yet been coded");
			System.out.println("When Completed this function will allow for an Admin to create");
			System.out.println("a Virtual Classroom by entering the user ID of registered students");
			System.exit(menuSelection);
		} else if (menuSelection == 6) {
			// ***Go Back
			System.out.println("This Function has not yet been coded");
			System.exit(menuSelection);
		} else if (menuSelection == 7) {
			// **Exit Program
			System.exit(menuSelection);
		}

	}

}