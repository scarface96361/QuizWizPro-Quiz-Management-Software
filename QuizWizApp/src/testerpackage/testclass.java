package testerpackage;

import java.util.ArrayList;

import quizWizApp.Quiz_Object;
import quizWizApp.quizTake;

public class testclass {

	
	//this is a dummy class devoted solely to testing the quizTake function 
	public static void main(String[] args) {
		ArrayList<String> Questions = new ArrayList<String>();
		ArrayList<String> CorrectAnswers = new ArrayList<String>();
		ArrayList<String> inCorrectAnswers1 = new ArrayList<String>();
		ArrayList<String> inCorrectAnswers2 = new ArrayList<String>();
		ArrayList<String> inCorrectAnswers3 = new ArrayList<String>();
		
		
		Questions.add("Is the answer 1");
		Questions.add("Is the answer 2");
		Questions.add("Is the answer 3");
		Questions.add("Is the answer 4");
		Questions.add("Is the answer 5");
		Questions.add("Is the answer 6");
		Questions.add("Is the answer 7");
		Questions.add("Is the answer 8");
		Questions.add("Is the answer 9");
		Questions.add("Is the answer 10");
		
		CorrectAnswers.add("yes");
		CorrectAnswers.add("yes");
		CorrectAnswers.add("yes");
		CorrectAnswers.add("yes");
		CorrectAnswers.add("yes");
		CorrectAnswers.add("yes");
		CorrectAnswers.add("yes");
		CorrectAnswers.add("yes");
		CorrectAnswers.add("yes");
		CorrectAnswers.add("yes");
		
		inCorrectAnswers1.add("no");
		inCorrectAnswers2.add("no");
		inCorrectAnswers3.add("no");
		inCorrectAnswers1.add("no");
		inCorrectAnswers2.add("no");
		inCorrectAnswers3.add("no");
		inCorrectAnswers1.add("no");
		inCorrectAnswers2.add("no");
		inCorrectAnswers3.add("no");
		inCorrectAnswers1.add("no");
		inCorrectAnswers2.add("no");
		inCorrectAnswers3.add("no");
		inCorrectAnswers1.add("no");
		inCorrectAnswers2.add("no");
		inCorrectAnswers3.add("no");
		inCorrectAnswers1.add("no");
		inCorrectAnswers2.add("no");
		inCorrectAnswers3.add("no");
		inCorrectAnswers1.add("no");
		inCorrectAnswers2.add("no");
		inCorrectAnswers3.add("no");
		inCorrectAnswers1.add("no");
		inCorrectAnswers2.add("no");
		inCorrectAnswers3.add("no");
		inCorrectAnswers1.add("no");
		inCorrectAnswers2.add("no");
		inCorrectAnswers3.add("no");
		inCorrectAnswers1.add("no");
		inCorrectAnswers2.add("no");
		inCorrectAnswers3.add("no");
		
		
		
		//creating a quiz_Object for testing purposes
		Quiz_Object quiz = new Quiz_Object();
		quiz.setQuiz_Questions(Questions);
		quiz.setQuiz_Answers(CorrectAnswers);
		quiz.setQuiz_Incorrect_Answers1(inCorrectAnswers1);
		quiz.setQuiz_Incorrect_Answers2(inCorrectAnswers2);
		quiz.setQuiz_Incorrect_Answers3(inCorrectAnswers3);
		
		
		quizTake test = new quizTake(quiz);

	}

}
