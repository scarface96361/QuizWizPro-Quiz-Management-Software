package quizWizApp;

import java.util.function.ToDoubleBiFunction;

public class DB_Handler {


    String DB_URL ="jdbc:MySQL://localhost/joseph";
    String DB_User = "root";
    String DB_password = "Rosenbaum6";


    /**db_Handler, generic constructor for the database handler object.
     *
     */
    public DB_Handler(){

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
    }
}
