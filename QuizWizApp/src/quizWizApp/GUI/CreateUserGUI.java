package quizWizApp.GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class CreateUserGUI extends JFrame{


    static JTextField firstNameTextField;                           // declares JTextField
    static JLabel firstNameLabel;                                   // declares JLabel
    static JPanel firstNamePanel;                                   // declares JPanel

    static JTextField lastNameTextField;                            // declares JTextField
    static JLabel lastNameLabel;                                    // declares JLabel
    static JPanel lastNamePanel;                                    // declares JPanel

    static JTextField emailTextField;                               // declares JTextField
    static JLabel emailLabel;                                       // declares JLabel
    static JPanel emailPanel;                                       // declares JPanel

    static String[] choices = { "", "Administrator", "Student"};    // declares String Array
    static JComboBox roleList;                                      // declares dropdown menu
    static JLabel roleLabel;                                        // declares JLabel
    static JPanel rolePanel;                                        // declares JPanel

    static JTextField usernameTextField;                            // declares JTextField
    static JLabel usernameLabel;                                    // declares JLabel
    static JPanel usernamePanel;                                    // declares JPanel

    static JTextField passwordTextField;                            // declares JTextField
    static JLabel passwordLabel;                                    // declares JLabel
    static JPanel passwordPanel;                                    // declares JPanel

    static JButton submitButton;                                    // declares JButton
    static JPanel submitPanel;                                      // declares JPanel
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
    static int loginAttemptCounter = 0;
    static String typeOfAccount;

    public CreateUserGUI(){

    // ******* HEADER *******

         headerPanel = new JPanel();
         headerPanel.setBounds(25, 50, 750, 100);
         headerPanel.setBackground(bgColor);
         headerLabel = new JLabel("<html>Create your account</html>", SwingConstants.CENTER);
         headerLabel.setForeground(textColor);                           // sets text color to Night
         headerLabel.setFont(new Font("Lib/Druk/Druk.otf", Font.BOLD, 32)); // sets font of text to Druk
         headerLabel.setVerticalAlignment(JLabel.TOP);                   // sets Vertical position of icon + text
         headerLabel.setHorizontalAlignment(JLabel.CENTER);              // sets Horizontal position of icon + text
         headerPanel.add(headerLabel);                                   // adds label to panel
 
    // ******* END HEADER *******

    // ******* TEXT FIELDS *******

        // First Name text field

    firstNameTextField = new JTextField();                                           // creates Frist Name text field
    firstNameTextField.setPreferredSize(new Dimension(250,30));         // sets size of First Name text field

    
    firstNameLabel = new JLabel("<html>First Name</html>",SwingConstants.LEFT); // labels First Name text field
    firstNameLabel.setForeground(textColor);                                         // sets label text color
    firstNameLabel.setFont(new Font("Lib/helvetica-neue-9-cufonfonts/HelveticaNeueMediumItalic.otf", Font.ITALIC, 15));
    
    firstNamePanel = new JPanel();
    firstNamePanel.setBounds(40, 150, 360,40);                     // places First Name panel
    firstNamePanel.setBackground(bgColor);                                           // sets background of First Name panel
    firstNamePanel.add(firstNameLabel);                                              // adds label to panel
    firstNamePanel.add(firstNameTextField);                                          // adds text field to panel
    
        // Last Name text field
        
    lastNameTextField = new JTextField();                                           // creates Last Name text field
    lastNameTextField.setPreferredSize(new Dimension(250,30));         // sets size of Last Name text field
    
    lastNameLabel = new JLabel("<html>Last Name</html>",SwingConstants.LEFT); // labels Last Name text field
    lastNameLabel.setForeground(textColor);                                         // sets label text color
    lastNameLabel.setFont(new Font("Lib/helvetica-neue-9-cufonfonts/HelveticaNeueMediumItalic.otf", Font.ITALIC, 15));
    
    lastNamePanel = new JPanel();
    lastNamePanel.setBounds(40, 190, 360,40);                     // places Last Name panel
    lastNamePanel.setBackground(bgColor);                                           // sets background of Last Name panel
    lastNamePanel.add(lastNameLabel);                                               // adds label to panel
    lastNamePanel.add(lastNameTextField);                                           // adds text field to panel

        // Email Address text field
        
    emailTextField = new JTextField();                                              // creates email text field
    emailTextField.setPreferredSize(new Dimension(250,30));            // sets size of email text field
        
    emailLabel = new JLabel("<html>Email</html>",SwingConstants.LEFT);         // labels email text field
    emailLabel.setForeground(textColor);                                            // sets label text color
    emailLabel.setFont(new Font("Lib/helvetica-neue-9-cufonfonts/HelveticaNeueMediumItalic.otf", Font.ITALIC, 15));
        
    emailPanel = new JPanel();
    emailPanel.setBounds(40, 230, 360,40);                     // places email panel
    emailPanel.setBackground(bgColor);                                           // sets background of email panel
    emailPanel.add(emailLabel);                                                  // adds label to panel
    emailPanel.add(emailTextField);                                              // adds text field to panel
    
        // Role Dropdown Menu
    roleList = new JComboBox<>(choices);
    roleList.setPreferredSize(new Dimension(250,30));
    roleList.addActionListener(new ActionListener() {                            // Action Listener anonymous class
        @Override
        public void actionPerformed(final ActionEvent click) {
           try {
            System.out.println("Role is: " + roleList.getSelectedIndex());
           } catch (Exception e) {
               e.printStackTrace();
           }
        }
    });
    
    roleLabel = new JLabel("<html>Role</html>", SwingConstants.LEFT);
    roleLabel.setForeground(textColor);
    roleLabel.setFont(new Font("Lib/helvetica-neue-9-cufonfonts/HelveticaNeueMediumItalic.otf", Font.ITALIC, 15));
    
    rolePanel = new JPanel();
    rolePanel.setBounds(40, 270, 360,40);                     // places email panel
    rolePanel.setBackground(bgColor);                                           // sets background of email panel
    rolePanel.add(roleLabel);                                                   // adds label to panel
    rolePanel.add(roleList);                                                    // adds text field to panel
    
        // Username text field

    usernameTextField = new JTextField();                                           // creates username text field
    usernameTextField.setPreferredSize(new Dimension(250,30));         // sets size of username text field

    usernameLabel = new JLabel("<html>Username</html>",SwingConstants.LEFT);   // labels username text field
    usernameLabel.setForeground(textColor);                                         // sets label text color
    usernameLabel.setFont(new Font("Lib/helvetica-neue-9-cufonfonts/HelveticaNeueMediumItalic.otf", Font.ITALIC, 15));

    usernamePanel = new JPanel();
    usernamePanel.setBounds(40, 310, 360,40);                     // places username panel
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
    passwordPanel.setBounds(40, 350, 360,40);                     // places password panel
    passwordPanel.setBackground(bgColor);                                           // sets background of password panel
    passwordPanel.add(passwordLabel);                                               // adds label to panel
    passwordPanel.add(passwordTextField);                                           // adds text field to panel

        // Submit button that applies textfields to addNewUserToDatabse()

    submitButton = new JButton("Submit");                                        // creates login button
    submitButton.addActionListener(new ActionListener() {                            // Action Listener anonymous class
        @Override
        public void actionPerformed(final ActionEvent click) {
           try {

            if (roleList.getSelectedIndex() == 1) {
                typeOfAccount = "A";
        
            } else if (roleList.getSelectedIndex() == 2) {
                typeOfAccount = "S";
            } // end of if statement

           // Get all the text fields and push them to addNewUserToDatabse()
            addNewUserToDatabse(firstNameTextField.getText(), lastNameTextField.getText(), 
           emailTextField.getText(), typeOfAccount, usernameTextField.getText(), passwordTextField.getText());

           frame.dispose();

           } catch (Exception e) {
               e.printStackTrace();
           }
        } // end Action Listener
    });

    submitPanel = new JPanel();
    submitPanel.setBackground(bgColor);                           // sets correct color to panel
    submitPanel.setBounds(400, 410, 70, 35);    // places login panel
    submitPanel.add(submitButton);                                // adds login button to panel

    // ******* END TEXT FIELDS *******

    
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
                new MainMenuGUI();                              // goes back to Main Menu page when clicked
               } catch (Exception e) {
                   e.printStackTrace();
               }
               backButton.setEnabled(false);
               frame.dispose();                                  // closes Admin Login window
            }
        });
        
        // Create "Go Back" Panel
        backPanel = new JPanel();
        backPanel.setBounds(30, 430, 100, 100);
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
        frame.setTitle("Quiz Maker - Create User");              // sets frame title
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);                 // sets width and height of frame          
        frame.setLayout(null);                                 // disables default layout manager
    
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);          // exits the application on close
        frame.getContentPane().setBackground(bgColor);                 // sets background color as a warm white
        frame.add(headerPanel);                                        // adds header panel to frame
        frame.add(firstNamePanel);                                     // adds First Name panel to frame
        frame.add(lastNamePanel);                                      // adds Last Name panel to frame
        frame.add(emailPanel);                                         // adds email panel to frame
        frame.add(rolePanel);                                          // adds role dropdown panel to frame
        frame.add(usernamePanel);                                      // adds username panel to frame
        frame.add(passwordPanel);                                      // adds password panel to frame
        frame.add(submitPanel);                                        // adds login panel to frame
        frame.add(backPanel);                                          // adds go back panel to frame
        frame.add(closePanel);                                         // adds close panel to frame
        frame.setVisible(true);                                     // makes frame visible

    // ******* END FRAME *******

    } // end CreateUserGUI() constructor

//************************************************************************************************************************
//***               Create New User	
//***************** Add Created User to Databse****************************************************************************

public void addNewUserToDatabse(String firstName, String lastName, String email,
                                String typeOfAccount, String username, String password) throws Exception {

    String url = "jdbc:mysql://localhost:3306/userdb";
    String uName = "root";
    String pass = "root";
    String query = ("INSERT INTO user(first_name, last_name, email," + " account_type, username, password ) "
            + "VALUES ('" + firstName + "'," + "'" + lastName + "','" + email + "','"
            + typeOfAccount + "'," + "'" + username + "'," + "'" + password + "' )");

    Class.forName("com.mysql.cj.jdbc.Driver");
    Connection connection = DriverManager.getConnection(url, uName, pass);
    PreparedStatement myStmt = connection.prepareStatement(query);

    myStmt.executeUpdate();

    System.out.println("Your Account Has Been Created");
    connection.close();

} // end addNewUserToDatabase()

} // end CreateUserGUI class
