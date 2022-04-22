package quizWizApp.GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import quizWizApp.QuizMenu;

public class StudentLoginGUI extends JFrame{

    static JTextField usernameTextField;                            // declares JTextField
    static JLabel usernameLabel;                                    // declares JLabel
    static JPanel usernamePanel;                                    // declares JPanel
    static JTextField passwordTextField;                            // declares JTextField
    static JLabel passwordLabel;                                    // declares JLabel
    static JPanel passwordPanel;                                    // declares JPanel
    static JButton loginButton;                                     // declares JButton
    static JPanel loginPanel;                                       // declares JPanel
    static JLabel wrongLabel;                                       // declares JLabel
    static JPanel wrongPanel;                                       // declares JPanel     

    static JLabel headerLabel;                                      // declares JLabel
    static JPanel headerPanel;                                      // declares JPanel
    static JLabel backLabel;                                        // declares JLabel
    static JPanel backPanel;                                        // declares JPanel
    static JButton backButton;                                      // declares JButton
    static JLabel closeLabel;                                       // declares JLabel
    static JPanel closePanel;                                       // declares JPanel
    static JButton closeButton;                                     // declares JButton    
    static JFrame frame;                                            // declares JFrame
    static Color textColor = new Color(0x1e1f26);               // sets text color
    static Color bgColor = new Color(0xF2EFEA);                 // sets background color

    static boolean authenticated = false;
    private static int loginAttemptCounter = 0;

    public StudentLoginGUI(){

    // ******* HEADER *******

         headerPanel = new JPanel();
         headerPanel.setBounds(25, 50, 750, 100);
         headerPanel.setBackground(bgColor);
         headerLabel = new JLabel("<html>Please login to your account</html>", SwingConstants.CENTER);
         headerLabel.setForeground(textColor);                           // sets text color to Night
         headerLabel.setFont(new Font("Lib/Druk/Druk.otf", Font.BOLD, 32)); // sets font of text to Druk
         headerLabel.setVerticalAlignment(JLabel.TOP);                   // sets Vertical position of icon + text
         headerLabel.setHorizontalAlignment(JLabel.CENTER);              // sets Horizontal position of icon + text
         headerPanel.add(headerLabel);                                   // adds label to panel
 
    // ******* END HEADER *******


    // ******* WRONG CREDENTIALS LABEL *******

    wrongLabel = new JLabel
                            ("<html>The username and/or password you entered was incorrect<br/>Please try again</html>");
    wrongLabel.setForeground(Color.RED);                                  // make error message text red
    wrongLabel.setFont(new Font("Lib/helvetica-neue-9-cufonfonts/HelveticaNeueMediumItalic.otf", Font.PLAIN, 12));
    wrongPanel = new JPanel();
    wrongPanel.setBounds(250, 290, 400, 38);            // place the panel
    wrongPanel.add(wrongLabel);                                           // add label to panel
    wrongPanel.setVisible(false);                                   // keep panel hidden until needed
    
    // ******* END WRONG CREDENTIALS LABEL *******


    // ******* LOGIN TEXT FIELDS *******

        // Username text field

    usernameTextField = new JTextField();                                           // creates username text field
    usernameTextField.setPreferredSize(new Dimension(250,30));         // sets size of username text field

    usernameLabel = new JLabel("<html>Username</html>",SwingConstants.LEFT);   // labels username text field
    usernameLabel.setForeground(textColor);                                         // sets label text color
    usernameLabel.setFont(new Font("Lib/helvetica-neue-9-cufonfonts/HelveticaNeueMediumItalic.otf", Font.ITALIC, 15));

    usernamePanel = new JPanel();
    usernamePanel.setBounds(40, 150, 350,40);                     // places username panel
    usernamePanel.setBackground(bgColor);                                           // sets background of username panel
    usernamePanel.add(usernameLabel);                                               // adds label to panel
    usernamePanel.add(usernameTextField);                                           // adds text field to panel


        // Password text field

    passwordTextField = new JTextField();                                           // creates password text field
    passwordTextField.setPreferredSize(new Dimension(250,30));         // sets size of password text field
    

    passwordLabel = new JLabel("<html>Password</html>",SwingConstants.LEFT);   // labels password text field
    passwordLabel.setForeground(textColor);                                         // sets label text color
    passwordLabel.setFont(new Font("Lib/helvetica-neue-9-cufonfonts/HelveticaNeueMediumItalic.otf", Font.ITALIC, 15));

    passwordPanel = new JPanel();
    passwordPanel.setBounds(40, 200, 350,40);                     // places password panel
    passwordPanel.setBackground(bgColor);                                           // sets background of password panel
    passwordPanel.add(passwordLabel);                                               // adds label to panel
    passwordPanel.add(passwordTextField);                                           // adds text field to panel

        // Login button that applies textfields to adminLogin();

    loginButton = new JButton("Login");                                        // creates login button
    loginButton.addActionListener(new ActionListener() {                            // Action Listener anonymous class
        @Override
        public void actionPerformed(final ActionEvent click) {
           try {


        /*** USE THIS BLOCK OF CODE IF CAN'T LOGIN ***/

        //    authenticated = true;
        //    frame.dispose();

        /*** USE THIS BLOCK OF CODE IF CAN'T LOGIN ***/
        

            authenticatePassword(usernameTextField.getText(), passwordTextField.getText()); // takes text from text fields and passes them through authenticatePassword()
            System.out.println("User credentials are " + authenticated);            // prints if credentials are authenticated to console
            wrongPanel.setVisible(false);                                     // shows error message because credentials are wrong
           } catch (Exception e) {
               e.printStackTrace();
           }

        // Testing the password and user name combination is correct to login
		// user allowed 3 attempts

           if(authenticated == true) {                                             // if credentials are authenticated...

            QuizMenu studentMenu = new QuizMenu();
            studentMenu.studentMenu();                                             // ... run studentMenu() from QuizMenu.java...
			
            loginButton.setEnabled(false);                                      // ... disable the login button...
            frame.dispose();                                                       // ... close the window

            new EndPageGUI();

            } else if(loginAttemptCounter < 2) {                                   // ... if the user hasn't used 3 login attempts...

                wrongPanel.setVisible(true);                                 // ... show error message because credentials are wrong...
                loginAttemptCounter++;                                             // ... log the attempt ...
                System.out.println("\t\t Login attempts: " + loginAttemptCounter); // ... to the console

            } else {                                                               // if credentials are wrong 3 times...

                frame.dispose();                                                   // ... close the window
                QuizMenu studentMenu = new QuizMenu();                                
                studentMenu.studentLoginPrompt();                                  // ... run studentLoginPrompt from QuizMenu.java that boots them back ...
                loginAttemptCounter = 0;                                           // ... reset the login attempt counter
            } 
        } // end Action Listener
    });

    loginPanel = new JPanel();
    loginPanel.setBackground(bgColor);                           // sets correct color to panel
    loginPanel.setBounds(400, 250, 70, 35);    // places login panel
    loginPanel.add(loginButton);                                 // adds login button to panel

    // ******* END LOGIN TEXT FIELDS *******

    
    // ******* GO BACK *******
    ImageIcon backIcon = new ImageIcon("Lib/209 - Media Buttons - 10.Flat Multicolor (A4 B99)/PNG/1024 x 1024/9935 - Left Arrow.png");
    Image backimg = backIcon.getImage();  
    Image newbackimg = backimg.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
    backIcon = new ImageIcon(newbackimg);

        // Creates Go Back button
        backButton = new JButton();                              // initializes backButton
        backButton.setIcon(backIcon);                            // sets button as back image
        backButton.setVerticalAlignment(JButton.CENTER);         // puts the button on the center of the panel
        backButton.setBorderPainted(false);                   // makes the border of the button transparent so the image is the button
        backButton.addActionListener(new ActionListener() {      // Action Listener anonymous class
            @Override
            public void actionPerformed(final ActionEvent click) {
               try {
                new StudentMenuGUI();                            // goes back to Student Menu page when clicked
               } catch (Exception e) {
                   e.printStackTrace();
               }
               backButton.setEnabled(false);
               frame.dispose();                                  // closes Admin Login window
            }
        });
        
        // Create "Go Back" Panel
        backPanel = new JPanel();
        backPanel.setBounds(30, 270, 100, 100);
        backPanel.setBackground(bgColor);

        // Create "Create Account" Label with Image
        backLabel = new JLabel();
        backLabel.setText("Back to Menu");
        backLabel.setForeground(textColor);                          // sets text color to Night
        backLabel.setFont(new Font("Lib/helvetica-neue-9-cufonfonts/Helvetica65Medium_22443.ttf", Font.PLAIN, 15)); // sets font of text to Druk
        backLabel.setVerticalAlignment(JLabel.BOTTOM);               // sets Vertical position of icon + text
        backLabel.setHorizontalAlignment(JLabel.CENTER);             // sets Horizontal position of icon + text
        backPanel.add(backLabel);                                    // adds label to panel
        backPanel.add(backButton);                                   // adds button to panel
        
    // ******* END GO BACK *******


    // ******* CLOSE *******
    ImageIcon closeIcon = new ImageIcon("Lib/209 - Media Buttons - 10.Flat Multicolor (A4 B99)/PNG/1024 x 1024/9923 - Close.png");
    Image closeimg = closeIcon.getImage();  
    Image newcloseimg = closeimg.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
    closeIcon = new ImageIcon(newcloseimg);

        // Creates Close button
        closeButton = new JButton();                              // initializes closeButton
        closeButton.setIcon(closeIcon);                           // sets button as close image
        closeButton.setVerticalAlignment(JButton.CENTER);         // puts the button on the center of the panel
        closeButton.setHorizontalAlignment(JButton.LEFT);
        closeButton.setBorderPainted(false);                   // makes the border of the button transparent so the image is the button
        closeButton.addActionListener(new ActionListener() {      // Action Listener anonymous class
            @Override
            public void actionPerformed(final ActionEvent click) {
               try {
                System.exit(4);                
               } catch (Exception e) {
                   e.printStackTrace();
               }
               closeButton.setEnabled(false);
               frame.dispose(); 
            }
        });

        closePanel = new JPanel();
        closePanel.setBounds(0,0,120,100);
        
        // Create Close Panel
        closeLabel = new JLabel();
        closeLabel.setText("Close Program");
        closeLabel.setForeground(textColor);                          // sets text color to Night
        closeLabel.setFont(new Font("Lib/helvetica-neue-9-cufonfonts/Helvetica65Medium_22443.ttf", Font.PLAIN, 10)); // sets font of text to Druk
        //closeLabel.setHorizontalAlignment(JLabel.RIGHT);             // sets Horizontal position of icon + text
        closePanel.add(closeButton);                         
        closePanel.add(closeLabel);                                    // adds label to panel        
    // ******* END CLOSE *******

    // ******* FRAME *******

        // Creates the Frame
        frame = new JFrame();
        frame.setTitle("Quiz Maker - Student Login");              // sets frame title
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);                 // sets width and height of frame          
        frame.setLayout(null);                                 // disables default layout manager
    
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);          // exits the application on close
        frame.getContentPane().setBackground(bgColor);                 // sets background color as a warm white
        frame.add(headerPanel);                                        // adds header panel to frame
        frame.add(usernamePanel);                                      // adds username panel to frame
        frame.add(passwordPanel);                                      // adds password panel to frame
        frame.add(loginPanel);                                         // adds login panel to frame
        frame.add(wrongPanel);                                         // adds wrong credentials panel to frame
        frame.add(backPanel);                                          // adds go back panel to frame
        frame.add(closePanel);                                         // adds close panel to frame
        frame.setVisible(true);                                     // makes frame visible

    // ******* END FRAME *******

    } // end StudentLoginGUI() constructor

//************************************************************************************************************************

	public static boolean authenticatePassword(String usrName, String uPass) throws Exception {

		String url = "jdbc:mysql://localhost:3306/userdb";
		String uName = "root";
		String pass = "root";
		String query = "select password from user where username = '" + usrName + "'";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection(url, uName, pass);

		Statement myStmt = connection.createStatement();
		ResultSet resultSet = myStmt.executeQuery(query);
		resultSet.next();

		String dbPassword = resultSet.getString("password");
		
		if (usrName.equals(dbPassword)) {

			authenticated = false;

			return authenticated = true;
		}
		return authenticated;

	} // end authenticatePassword()

} // end StudentLoginGUI class
