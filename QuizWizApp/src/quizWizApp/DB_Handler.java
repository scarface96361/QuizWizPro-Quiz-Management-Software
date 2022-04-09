package quizWizApp;

import java.net.ConnectException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.function.ToDoubleBiFunction;

public class DB_Handler {


    String DB_URL ="jdbc:mysql://quizmaker.cs5pwn0dgd4l.us-east-1.rds.amazonaws.com:3306";
    String DB_User = "quizmaker";
    String DB_password = "quizmaker";
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
    // TODO: 3/17/2022 Create code to connect to AWS database to validate the connection.
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
                "Answer VARCHAR(255),"+
                "isCorrect BIT )";


        //Trying a connection and opening it
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_User, DB_password);
             Statement stmt = conn.createStatement();){

            stmt.executeUpdate(sqlQuiz);
            stmt.executeUpdate(sqlQuestions);
            stmt.executeUpdate(sqlQuiz);

            System.out.println("Created tables in given database");

        }catch (SQLException e) {
            e.printStackTrace();
        }





        }
}