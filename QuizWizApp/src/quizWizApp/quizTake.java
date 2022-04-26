package quizWizApp;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class quizTake {
	
	
	public quizTake() {
		// TODO Auto-generated constructor stub
	}
	
	
	//this is an overloaded constructor for a specific testing case that allows me to test the code using a premade quiz
	public quizTake(Quiz_Object quiz1) {
		takeQuiz(quiz1);
	}
	
	
	
	
	/**This is the method to take a quiz from a quiz_Object
	 * 
	 */
	public void takeQuiz(Quiz_Object quiz) {
		ArrayList<String> questions = quiz.getQuiz_Questions();
		ArrayList<String> correctAnswers = quiz.getQuiz_Answers();
		ArrayList<String> incorrectAnswers1 = quiz.getQuiz_Incorrect_Answers1();
		ArrayList<String> incorrectAnswers2 = quiz.getQuiz_Incorrect_Answers2();
		ArrayList<String> incorrectAnswers3 = quiz.getQuiz_Incorrect_Answers3();
		
		//creating a scanner object to get inputs
		Scanner Myinput = new Scanner(System.in); 
		
		
		
		int CorrectGuess = 0;
		
		System.out.println("****************************");
		System.out.println("Now Taking the Selected Quiz");
		System.out.println("****************************");
		
		
		
		
		for (int i = 0; i < questions.size(); i++) {
			
			//this chunk of code takes the questions and asnwers for the first round and gives them the correct answer
			System.out.println("****************************");
			System.out.println("Question");
			System.out.println(i+ "." + questions.get(i));
			System.out.println("    1." + correctAnswers.get(i));
			System.out.println("    2." + incorrectAnswers1.get(i));
			System.out.println("    3." + incorrectAnswers2.get(i));
			System.out.println("    4." + incorrectAnswers3.get(i));
			System.out.println("****************************");
			
			//using the scanner to get an INT answer
			System.out.println("please enter your answer in as The number");
			
			int guess = Myinput.nextInt();
			
			//validating if the input was the correct answer
			if (guess == 1) {
				System.out.println("Correct answer!");
				CorrectGuess++;
				
			}
		}
		
		
		//closing the scanner
		Myinput.close();
		
		
		
		//grading/informing the student how many questions they got right out of how many were taken
		System.out.println("****************************");
		System.out.println("You got " + CorrectGuess + " out of " + questions.size()+ " correct!");
		
		return;
		
		
	}

}
