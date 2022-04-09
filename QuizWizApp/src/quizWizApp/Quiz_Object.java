package quizWizApp;

import java.util.ArrayList;

public class Quiz_Object extends Object {
    private ArrayList<String> Quiz_Questions;
    private ArrayList<String> Quiz_Answers;
    private ArrayList<String> Quiz_Incorrect_Answers1;
    private ArrayList<String> Quiz_Incorrect_Answers2;
    private ArrayList<String> Quiz_Incorrect_Answers3;

    /**Generic constructor for the quiz_object
     *
     */
    public Quiz_Object(){
        System.out.println("Generic constructor. Quiz constructed. Requires inputs");
    }


    /**Constructor for the quiz class of objects when passed the quiz objects appropiatly
     *
     * @param Questions
     * @param Answers
     * @param IncorrectAnswers1
     * @param IncorrectAnswers2
     * @param IncorrectAnswers3
     */
    public Quiz_Object(ArrayList<String> Questions,ArrayList<String> Answers, ArrayList<String> IncorrectAnswers1, ArrayList<String> IncorrectAnswers2, ArrayList<String> IncorrectAnswers3){
        Quiz_Questions = Questions;
        Quiz_Answers = Answers;
        Quiz_Incorrect_Answers1 = IncorrectAnswers1;
        Quiz_Incorrect_Answers2 = IncorrectAnswers2;
        Quiz_Incorrect_Answers3 = IncorrectAnswers3;
    }

    //todo Figure out if this object requires any additional methods.

    //The following methods are to set the questions and answers on their own.
    public void setQuiz_Questions(ArrayList<String> Questions){
        Quiz_Questions = Questions;
    }

    public void setQuiz_Answers(ArrayList<String> Answers){
        Quiz_Answers = Answers;
    }

    public void setQuiz_Incorrect_Answers1(ArrayList<String>Incorrect_Answers){
        Quiz_Incorrect_Answers1 = Incorrect_Answers;
    }
    public void setQuiz_Incorrect_Answers2(ArrayList<String>Incorrect_Answers){
        Quiz_Incorrect_Answers2 = Incorrect_Answers;
    }
    public void setQuiz_Incorrect_Answers3(ArrayList<String>Incorrect_Answers){
        Quiz_Incorrect_Answers3 = Incorrect_Answers;
    }



    //The following methods return the appropriate array lists
    public ArrayList<String> getQuiz_Questions(){
        return Quiz_Questions;
    }
    public ArrayList<String> getQuiz_Answers(){
        return Quiz_Answers;
    }
    public ArrayList<String> getQuiz_Incorrect_Answers1() {
        return Quiz_Incorrect_Answers1;
    }
    public ArrayList<String> getQuiz_Incorrect_Answers2() {
        return Quiz_Incorrect_Answers2;
    }
    public ArrayList<String> getQuiz_Incorrect_Answers3() {
        return Quiz_Incorrect_Answers3;
    }
}

