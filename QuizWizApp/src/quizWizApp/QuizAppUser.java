package quizWizApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;
import java.sql.*;

public class QuizAppUser {
	String firstName;
	String lastName;
	String email;
	String username;
	String password;
	int userID;
	boolean admin;
	String typeOfAccout = "s";

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
	public void createNewUser() throws Exception {
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
		int typeOfAccount = inputAdmin.nextInt();
		// if the user is a student admin variable will be made false, if user is an
		// admin ...admin variable will be true
		if (typeOfAccount == 1) {
			this.admin = false;

		} else if (typeOfAccount == 2) {
			this.admin = true;
		} // end of if statement

		System.out.println("Please Enter a Username");
		Scanner inputUserName = new Scanner(System.in);
		this.username = inputUserName.next();

		System.out.println("Please enter a password");
		Scanner inputPassWord = new Scanner(System.in);
		this.password = inputPassWord.next();

		System.out.println("Please Check to make sure the information you have entered is correct.\n");
		System.out.println("First Name:" + this.firstName);
		System.out.println("Last Name:" + this.lastName);
		System.out.println("Email:" + this.email);
		System.out.println("UserName:" + this.username);
		System.out.println("");
		Scanner confirmCorrectInfo = new Scanner(System.in);
		System.out.println("Is this information correct?");
		System.out.println("1. Press 1 for yes. My information is Correct. ");
		System.out.println("2. Press 2 to re-enter. My Information is Not Correct");
		int confirmation = confirmCorrectInfo.nextInt();
		if (confirmation == 1) {
			addNewUserToDatabse();
		} else if (confirmation == 2) {
			createNewUser();
		}

	}

//****************Add Created User to Databse****************************************************************************
	public void addNewUserToDatabse() throws Exception {

		String url = "jdbc:mysql://localhost:3306/userdb";
		String uName = "root";
		String pass = "root";
		String query = ("INSERT INTO user(first_name, last_name, email," + " account_type, username, password ) "
				+ "VALUES ('" + this.firstName + "'," + "'" + this.lastName + "','" + this.email + "','"
				+ this.typeOfAccout + "'," + "'" + this.username + "'," + "'" + this.password + "' )");

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection(url, uName, pass);
		PreparedStatement myStmt = connection.prepareStatement(query);

		myStmt.executeUpdate();

		System.out.println("Your Account Has Been Created");
		connection.close();

	}

//------------------------------------------------------------------------------------------------------------------------------------------
//*** User Login***
	// **Student Login***
	public void studentLogin() {
		Scanner stuInputUser = new Scanner(System.in);
		Scanner stuInputPass = new Scanner(System.in);
		System.out.println("Student Login");
		System.out.println("Please Enter Your Username");
		String studentId = stuInputUser.next();
		System.out.println("Please Enter Your User Password");
		String studentPass = stuInputPass.next();
		// this.password = stuInputPass.next();
		String password = "password";
		String id = "student";
		if (studentPass.equals(password) || studentId.equals(id)) {
			QuizMenu studentMenu = new QuizMenu();
			studentMenu.studentMenu();
		}

	}

//*** Admin Login********************************************************************************************
	public void adminLogin() {
		Scanner adminInputUser = new Scanner(System.in);
		Scanner adminInputPass = new Scanner(System.in);
		int loginAttemptCounter = 0;

		System.out.println("ADMIN LOGIN");
		System.out.println("Please Enter Your Username");
		String adminId = adminInputUser.next();
		System.out.println("Please Enter Your User Password");
		String studentPass = adminInputPass.next();
		String password = "password";
		String id = "admin";

		// Testing the password and user name combination is correct to login
		// user allowed 3 attempts
		if (studentPass.equals(password) || adminId.equals(id)) {
			QuizMenu adminMenu = new QuizMenu();
			adminMenu.adminMenu();
		} else {

			while (!(studentPass.equals(password))) {
				if (loginAttemptCounter < 3) {
					System.out.println("");
					System.out
							.println("The username password combination you entered was incorrect. Please try again ");
					System.out.println(
							"*********************************************************************************************");
					System.out.println("ADMIN LOGIN");
					System.out.println("Quiz Wiz Pro v1");
					System.out.println("Please Enter Your Username");
					String adminId2 = adminInputUser.next();
					System.out.println("Please Enter Your User Password");
					String studentPass2 = adminInputPass.next();
					String password2 = "password";
					String id2 = "admin";
				}
				if ((studentPass.equals(password) || adminId.equals(id)) || loginAttemptCounter < 3) {
					QuizMenu adminMenu = new QuizMenu();
					adminMenu.adminMenu();
					break;

				}

			}
		}
	}

//************************************************************************************************************************

	public void queryUsername() throws Exception{
		
		

			String url = "jdbc:mysql://localhost:3306/userdb";
			String uName = "root";
			String pass = "";
			String query ="";

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection(url, uName, pass);
			PreparedStatement myStmt = connection.prepareStatement(query);

			myStmt.executeUpdate();

			System.out.println("Your Account Has Been Created");
			connection.close();

		}
		
		

	}

