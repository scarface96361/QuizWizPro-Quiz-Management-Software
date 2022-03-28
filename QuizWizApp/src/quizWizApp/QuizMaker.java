package quizWizApp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class QuizMaker {

	public String question;
	public String rightAnswer;
	public String incorrectAlternateOne;
	public String incorrectAlternateTwo;
	public String incorrectAlternateThree;
	public int qCount = 1;
	public String quizName;
	public String authorName;
	public int c = 1;
	public int numOfQuestions;
	int i = 1;

	ArrayList<String> questionList = new ArrayList<String>();
	ArrayList<String> correctAnswerList = new ArrayList<String>();
	ArrayList<String> incorrectAnswer1 = new ArrayList<String>();
	ArrayList<String> incorrectAnswer2 = new ArrayList<String>();
	ArrayList<String> incorrectAnswer3 = new ArrayList<String>();

	ArrayList<String> possibleAnswers = new ArrayList<String>();

	public void startBuildQuiz() {
		/* ***** Header ***** */

		System.out.println("QUIZZ WIZZ PRO --- VERSION.1");
		System.out.println("QUIZ MAKER WIZARD \n" + "");

		/* ***** Instructions to users ***** */

		System.out.println("*** Please Follow These Instructions:***");
		System.out.println(" 1) You will be prompted to enter quiz Question");
		System.out.println(" 2) You will be prompted to enter the correct  answer for question");
		System.out.println(" 3) You will be prompted to enter 3 alternate incorrect answers to quiz question");
		System.out.println(" 4) This software will randomly shuffle the order of quiz questions ");
		System.out.println("\n");

		Scanner in = new Scanner(System.in);
		Scanner in2 = new Scanner(System.in);
		Scanner inputNumQues = new Scanner(System.in);

		System.out.println("How many questions will this quiz consist of? must Select a number between 1 and 10.");
		numOfQuestions = inputNumQues.nextInt();

		/* ***** Checking if the input is valid ***** */

// ------------------------------------------------------------------------------------------------------------------------------------------

		/* ***** Iterate through the questions and add correct answers ***** */

		while (numOfQuestions > 10 || numOfQuestions < 1) {

			System.out.println("Please Try again. Must enter a number between 1 and 10");
			numOfQuestions = inputNumQues.nextInt();
		}
		int c = 1;
		
		System.out.println("----------------------------------------------------------------------------------------------------------------");
		System.out.print("Question # " + i + " Please Enter Question You Wish To Record \n");
		question = in.nextLine();
		System.out.println("Question # " + i + ": Has been added Susscefully");
		System.out.println("");
		System.out.println("Question # " + i + " Please Provide The Correct Answer for this Question");
		Scanner inAnswer = new Scanner(System.in);
		rightAnswer = inAnswer.nextLine();
		System.out.println("Question # " + i + " Solution Has Been Added to Answer Key");
		System.out.println();
		questionList.add(question);
		correctAnswerList.add(rightAnswer);
		// i++;

		while (c <= 3) {
			System.out.println("Question # " + i + " Please enter alternate incorrect multiple choice option  " + c);
			if (c == 1) {
				incorrectAlternateOne = inAnswer.nextLine();
				incorrectAnswer1.add(incorrectAlternateOne);
			} else if (c == 2) {
				incorrectAlternateTwo = inAnswer.nextLine();
				incorrectAnswer2.add(incorrectAlternateTwo);
			} else if (c == 3) {
				incorrectAlternateThree = inAnswer.nextLine();
				incorrectAnswer3.add(incorrectAlternateThree);
			}

			c++;
			// createQuestion();

		}
		System.out.print("Question # " + i + " Alternate Question choices added Successfully. Question " + i
				+ " is now complete. \n");
		System.out.println();
		/* ***** Add incorrect answers to the possible answers array, finishing with
		the correct answer on top ***** */
		
		possibleAnswers.add(0, incorrectAlternateOne);
		possibleAnswers.add(0, incorrectAlternateTwo);
		possibleAnswers.add(0, incorrectAlternateThree);
		possibleAnswers.add(0, rightAnswer);

		createQuestion();

		i++;
	}

	
	public void createQuestion() {
		String correctAnswer = possibleAnswers.get(0);
		shuffleQuestions(possibleAnswers);

		// System.out.println(quizName );
		System.out.println();
		System.out.println("Question " + i);
		System.out.println();
		System.out.println(questionList.get(0));
		System.out.println();
		System.out.println("A: " + possibleAnswers.get(0));
		System.out.println();
		System.out.println("B: " + possibleAnswers.get(1));
		System.out.println();
		System.out.println("C: " + possibleAnswers.get(2));
		System.out.println();
		System.out.println("D: " + possibleAnswers.get(3));
		System.out.println();
		System.out.println("The Correct Answer is: " + correctAnswer);
		System.out.println();
		System.out.println();

	}

	public ArrayList<String> shuffleQuestions(ArrayList<String> possibleAnswers2) {
		Collections.shuffle(possibleAnswers);
		return possibleAnswers2;

	}

}