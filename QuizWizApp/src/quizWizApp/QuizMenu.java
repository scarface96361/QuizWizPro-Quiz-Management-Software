package quizWizApp;

import java.util.Scanner;

import quizWizApp.GUI.AdminMenuGUI;
import quizWizApp.GUI.StudentMenuGUI;

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
		}else if ((menuSelectionStartMenu > 2 )||(menuSelectionStartMenu==0)) {
			do {
				menuSelectionStartMenu=0;
			System.out.println("The Value you entered is not recognized. Please Try again. press 1 or 2. ");
			System.out.println("1. Press 1 if you are a STUDENT. ");
			System.out.println("2. Press 2 if you are and ADMIN");
			menuSelectionStartMenu = inputStartMenu.nextInt();
		}while (menuSelectionStartMenu>2);
			if (menuSelectionStartMenu == 1) {
				studentLoginPrompt();
			} else if (menuSelectionStartMenu == 2) {
				adminLoginPrompt();
		}
		}
	}

	// ---------------------------------------------------------------------------------------------------------------------------	// ***Login Prompt Menu***
	public void studentLoginPrompt() {
	
		new StudentMenuGUI();

	}

	// admin login prompt menu method
	public void adminLoginPrompt() {
		
		new AdminMenuGUI();

	} // end of adminLoginPrompt

	// ---------------------------------------------------------------------------------------------------------------------------------------------------------------------
	// *** once a student is logged in they will see this menu
	// ***Student Main Menu***
	public void studentMenu() {

		
		//4/24/2022 Joseph rosenbaum. modifying and refactoring this code to allow for taking the quizes
		Scanner inputSInterface = new Scanner(System.in);
		
		DB_Handler database = new DB_Handler();

		System.out.println("1. Take Quiz");
		System.out.println("2. Go Back ");
		System.out.println("3. Exit Program ");

		int interfaceSelection = inputSInterface.nextInt();

		if (interfaceSelection == 1) {
			// *** Take Quiz
			//System.out.println("This function is being coded now");
			
			//setting up the code to retrieve a quiz and take it
			System.out.println("Please enter the quiz number your professor gave you");
			int quizNum = inputSInterface.nextInt();
			
			Quiz_Object quizToTake = database.getQuiz(quizNum);
			 
			quizTake Quizer = new quizTake();
			 
			Quizer.takeQuiz(quizToTake);
			
			
		} else if (interfaceSelection == 2) {
			startMenu();
		} 
			// ***Exit Program
		else if (interfaceSelection == 3) {
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