package quizWizApp;

import java.util.Scanner;

public class QuizAppUser {
	String firstName;
	String lastName;
	String email;
	String username;
	String password;
	int userID;
	boolean admin;

	
	/*
	 * public QuizAppUser (String fName, String lName, String email, int userID,
	 * boolean admin) {
	 * 
	 * this.firstName =fName; this.lastName = lName; this.email = email; this.userID
	 * = userID; this.admin=admin;
	 * 
	 * 
	 * }
	 */
	
	
//-----------------------------------------------------------------------------------------------------------------------------------
//***Create New User	
	public void createUser() {
		System.out.println("Please Enter Your First Name");
		Scanner inputFirstName = new Scanner(System.in);
		this.firstName = inputFirstName.next();
		
		System.out.println("Please Enter Your Last Name");
		Scanner inputLastName = new Scanner(System.in);
		this.lastName = inputLastName.next();
		
		System.out.println("Please Enter Your Email Adress");
		Scanner inputEmail = new Scanner(System.in);
		this.email = inputEmail.next();
		
		
		System.out.println("Are you A Student or Admin");
		System.out.println("1.Student");
		System.out.println("2.Admin");
		Scanner inputAdmin = new Scanner(System.in);
		int typeOfAccount= inputAdmin.nextInt();
		//if the user is a student admin variable  will be made false, if user is an admin ...admin variable  will be true
		if(typeOfAccount == 1) {
			this.admin=false;
			
		}else if (typeOfAccount ==2) {
			this.admin=true;
		}
	
		System.out.println("Please Enter a Username");
		Scanner inputUserName = new Scanner(System.in);
		this.username = inputUserName.next();
		
		System.out.println("Please enter a password");
		Scanner inputPassWord = new Scanner(System.in);
		this.password = inputPassWord.next();
	}

//------------------------------------------------------------------------------------------------------------------------------------------
//*** User Login***
	//**Student Login***
	public void studentLogin() {
		Scanner stuInputUser = new Scanner(System.in);
		Scanner stuInputPass = new Scanner(System.in);
		System.out.println("Student Login");
		System.out.println("Please Enter Your Username");
		String studentId = stuInputUser.next();
		System.out.println("Please Enter Your User Password");
		String studentPass = stuInputPass.next();
		String password = "password";
		String id = "student";
		if (studentPass.equals(password) || studentId.equals(id)){
			QuizMenu studentMenu = new QuizMenu();
			studentMenu.studentMenu();
		}

	}
//*** Admin Login***
	public void adminLogin() {
		Scanner adminInputUser = new Scanner(System.in);
		Scanner adminInputPass = new Scanner(System.in);
		System.out.println("Admin Login");
		System.out.println("Please Enter Your Username");
		String adminId = adminInputUser.next();
		System.out.println("Please Enter Your User Password");
		String studentPass = adminInputPass.next();
		String password = "password";
		String id = "admin";
		if (studentPass.equals(password) || adminId.equals(id)){
			QuizMenu adminMenu = new QuizMenu();
			adminMenu.adminMenu();
	}else {
		System.out.println("The username password combination you entered was incorrect. Please try again ");
	}
}
}