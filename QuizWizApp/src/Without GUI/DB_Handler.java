package quizWizApp;

import java.net.ConnectException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;




public class DB_Handler {


    String DB_URL ="jdbc:mysql://localhost/finalproject";
    String DB_User = "root";
    String DB_password = "123456";
    String DB_Connect;


    /**db_Handler, generic constructor for the database handler object.
     *
     */
    public DB_Handler(){
        DB_Connect = "jdbc:mysql://quizmaker.cs5pwn0dgd4l.us-east-1.rds.amazonaws.com:3306";
    }


    /**The official constructor for the DB_handler object, designed to be passed the correct login information for the database by main to override the temporary defaults
     *
     * @param url
     * @param Password
     * @param User
     */
    public DB_Handler(String url, String Password, String User){
        DB_URL = url;
        DB_password = Password;
        DB_User= User;
    }


    /**DB_Test will be run to validate a connection to the database
     * is functional to validate the connection.
     *
     */

    public void DB_Test(){
        System.out.println("incomplete testing method. plan is to connect to database to validate the connection");
        Connection conn=null;
        try {
            conn = DriverManager.getConnection(DB_Connect,DB_User, DB_password);

            if(conn!= null){
                System.out.println("Database connection successful");
                conn.close();
            }
        }catch (SQLException e){
            throw new Error("Problem: ", e);
        }

    }

    /**Create_Table creates the table used to store data long term
     *
     */
    public void Create_Table() {
        String sqlQuiz = "CREATE TABLE QUIZ" +
                "(Quiz_ID INT not NULL PRIMARY KEY," +
                "QuizType VARCHAR(255))";
        String sqlQuestions = "CREATE TABLE Questions" +
                "(Question_ID INT not NULL PRIMARY KEY," +
                "Question VARCHAR(255)," +
                "Quiz_ID  INT FOREIGN KEY REFERENCES QUIZ(Quiz_ID))";
        String sqlAnswers = "CREATE TABLE Answers" +
                "(Answer_ID INT not NULL PRIMARY KEY AUTO_INCREMMENT," +
                "Quiz_ID INT FOREIGN KEY REFERENCES QUIZ(Quiz_ID)," +
                "Question_ID INT FOREIGN KEY REFERENCES Questions(Question_ID)," +
                "Answer VARCHAR(255)," +
                "isCorrect BIT )";


        //Trying a connection and opening it
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_User, DB_password);
             Statement stmt = conn.createStatement();) {

            stmt.executeUpdate(sqlQuiz);
            stmt.executeUpdate(sqlQuestions);
            stmt.executeUpdate(sqlQuiz);

            System.out.println("Created tables in given database");

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    /**GetQuizList returns a list of all quiz numbers
     *
     */
    public ArrayList<Integer> getQuizList(){
        String Query = "SELECT Quiz_ID FROM QUIZ";
        ArrayList<Integer> quizlist = new ArrayList<Integer>();

        try(Connection conn = DriverManager.getConnection(DB_URL, DB_User, DB_password);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(Query);) {

            while (rs.next()){
                quizlist.add(rs.getInt("Quiz_ID"));
            }
        }catch(SQLException e) {
            e.printStackTrace();
        }
        
		return quizlist;
    }


    //TODO 4/12/2022 implement the ability to pull the quiz from the database and pass back a Quiz_Object to use for taking quizes
    public Quiz_Object getQuiz(int someId){
        String Query = "SELECT q.quiz_name, q.quiz_type, qu.question, a.answer, a.istrue "
        		+ "FROM quiz q JOIN questions qu ON q.quiz_id = qu.quiz_id JOIN answers a ON a.question_id = qu.question_id WHERE q.quiz_id = " + someId + ";";
        
        return null;


    }


    //TODO test method
    /**storeQuiz is a method that takes a quiz object created and stores it in the long term storage database
     * 
     * 
     * @param quizToStore
     */
    public void storeQuiz(Quiz_Object quizToStore) {
        int latest_quiz =0;

        String query = "INSERT INTO QUIZ (QuizType) values ('test description')";
        ArrayList<Integer> QuizList = new ArrayList<Integer>(); 

        ArrayList<String> Questions = quizToStore.getQuiz_Questions();
        ArrayList<String> Answers = quizToStore.getQuiz_Answers();
        ArrayList<String> incorrectAnswers1 = quizToStore.getQuiz_Incorrect_Answers1();
        ArrayList<String> incorrectAnswers2 = quizToStore.getQuiz_Incorrect_Answers2();
        ArrayList<String> incorrectAnswers3 = quizToStore.getQuiz_Incorrect_Answers3();
        
        
        //creating a method to store and create a quiz
        try(Connection conn = DriverManager.getConnection(DB_URL,DB_User,DB_password);
                Statement stmt = conn.createStatement();){

            //creating and executing the quarry
        	//this run of the query creates the specific quiz
            stmt.executeUpdate(query);
            
            QuizList = getQuizList();
            int QuizID = QuizList.size() - 1;
            
            
            for (int i = 0; i < 10; i++) {
            	
            	//this creates a query for each revolution to insert all ten questions into the 
				query = "INSERT INTO Question(Question_ID, Question, Quiz_ID) values ("+ i  +","+ Questions.get(i) +","+ QuizID + ")";
				
				stmt.executeUpdate(query);
			}
            
            for (int i = 0; i < 10; i++) {
            	//inserting the correct answer 
            	query = "INSERT INTO answers (Quiz_ID, Question_ID, Answer, isCorrect) Values(" + QuizID +","+ i +","+ Answers.get(i) + ",0)";
            	stmt.executeUpdate(query);
            	
            	//the next 6 lines insert the incorrect answers, binding them to the matching questions
            	query = "INSERT INTO answers (Quiz_ID, Question_ID, Answer, isCorrect) Values(" + QuizID +","+ i +","+ incorrectAnswers1.get(i) + ",1)";
            	stmt.executeUpdate(query);
            	
            	query = "INSERT INTO answers (Quiz_ID, Question_ID, Answer, isCorrect) Values(" + QuizID +","+ i +","+ incorrectAnswers2.get(i) + ",1)";
            	stmt.executeUpdate(query);
            	
            	query = "INSERT INTO answers (Quiz_ID, Question_ID, Answer, isCorrect) Values(" + QuizID +","+ i +","+ incorrectAnswers3.get(i) + ",1)";
            	stmt.executeUpdate(query);
				
			}
            
            


        }catch (SQLException e){
            e.printStackTrace();
        }


    }



}