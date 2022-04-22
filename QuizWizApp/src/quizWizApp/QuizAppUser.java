package quizWizApp;

import quizWizApp.GUI.AdminLoginGUI;
import quizWizApp.GUI.CreateUserGUI;
import quizWizApp.GUI.StudentLoginGUI;


public class QuizAppUser {
	String firstName;
	String lastName;
	String email;
	String username;
	static String password;
	int userID;
	boolean admin;
	String typeOfAccout;
	int confirmation;
	String correctPassword;
	String loginPassword;
	String passwordEntered;
	static String adminUsername;
	static boolean authenticated = false;
	int loginAttemptCounter = 0;
	
//-----------------------------------------------------------------------------------------------------------------------------------
//***Create New User	
	public void createNewUser() throws Exception {
		
		new CreateUserGUI();

	}


//------------------------------------------------------------------------------------------------------------------------------------------
//*** User Login***
	// **Student Login***
	public void studentLogin() {

		new StudentLoginGUI();

	}
		
		
		
	
//*** Admin Login********************************************************************************************
	public void adminLogin() {
		
		new AdminLoginGUI();
		
	}

}

