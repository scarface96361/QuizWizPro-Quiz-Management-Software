package quizWizApp.GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import quizWizApp.QuizAppUser;

public class AdminMenuGUI extends JFrame {

    static JLabel headerLabel;                                      // declares JLabel
    static JPanel headerPanel;                                      // declares JPanel
    static JButton loginButton;                                     // declares JButton
    static JButton createButton;                                    // declares JButton
    static JPanel loginPanel;                                       // declares JPanel
    static JLabel loginLabel;                                       // declares JLabel
    static JPanel createPanel;                                      // declares JPanel
    static JLabel createLabel;                                      // declares JLabel
    static JLabel backLabel;                                        // declares JLabel
    static JPanel backPanel;                                        // declares JPanel
    static JButton backButton;                                      // declares JButton
    static JLabel closeLabel;                                       // declares JLabel
    static JPanel closePanel;                                       // declares JPanel
    static JButton closeButton;                                     // declares JButton    
    static JFrame frame;                                            // declares JFrame
    static Color textColor = new Color(0x1e1f26);               // sets text color
    static Color bgColor = new Color(0xF2EFEA);                 // sets background color

    public AdminMenuGUI(){

    // ******* HEADER *******

         headerPanel = new JPanel();
         headerPanel.setBounds(25, 50, 750, 100);
         headerPanel.setBackground(bgColor);
         headerLabel = new JLabel("<html>You are an Administrator<br/>Please Select From The Following Options</html>", SwingConstants.CENTER);
         headerLabel.setForeground(textColor);                           // sets text color to Night
         headerLabel.setFont(new Font("Lib/Druk/Druk.otf", Font.BOLD, 32)); // sets font of text to Druk
         headerLabel.setVerticalAlignment(JLabel.TOP);                   // sets Vertical position of icon + text
         headerLabel.setHorizontalAlignment(JLabel.CENTER);              // sets Horizontal position of icon + text
         headerPanel.add(headerLabel);                                   // adds label to panel
 
    // ******* END HEADER *******


    // ******* LOGIN *******

        // Creates login button
        ImageIcon loginIcon = new ImageIcon("Lib/Security Line/PNG/padlock, access, login, safety.png");
        Image loginimg = loginIcon.getImage();  
        Image newloginimg = loginimg.getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH);
        loginIcon = new ImageIcon(newloginimg);
        
        loginButton = new JButton();                              // initializes loginButton
        loginButton.setIcon(loginIcon);                           // sets button as login image
        loginButton.setVerticalAlignment(JButton.CENTER);         // puts the button on the center
        loginButton.setBorderPainted(false);                   // makes the border of the button transparent so the image is the button
        loginButton.addActionListener(new ActionListener() {      // Action Listener anonymous class
            @Override
            public void actionPerformed(final ActionEvent click) {
                QuizAppUser adminUser = new QuizAppUser();
               try {
                adminUser.adminLogin();                           // starts login method 
               } catch (Exception e) {
                   e.printStackTrace();
               }
               loginButton.setEnabled(false);
               frame.dispose(); 
            }
        });
        
        // Create "Login" Panel
        loginPanel = new JPanel();
        loginPanel.setBounds(25, 200, 250, 250);
        loginPanel.setBackground(bgColor);

        // Create "Login" Label with Image
        loginLabel = new JLabel();
        loginLabel.setText("Login to your account");
        loginLabel.setForeground(textColor);                          // sets text color to Night
        loginLabel.setFont(new Font("Lib/helvetica-neue-9-cufonfonts/Helvetica65Medium_22443.ttf", Font.PLAIN, 20)); // sets font of text to Helvetica
        loginLabel.setVerticalAlignment(JLabel.BOTTOM);               // sets Vertical position of icon + text
        loginLabel.setHorizontalAlignment(JLabel.CENTER);             // sets Horizontal position of icon + text
        loginPanel.add(loginLabel);                                   // adds label to panel
        loginPanel.add(loginButton);                          

    // ******* END LOGIN *******   


    // ******* CREATE ACCOUNT *******
        // Creates Create Account button
        ImageIcon createIcon = new ImageIcon("Lib/Security Line/PNG/secure, privacy, safety, cyber.png");
        Image createimg = createIcon.getImage();  
        Image newcreateimg = createimg.getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH);
        createIcon = new ImageIcon(newcreateimg);

        createButton = new JButton();                              // initializes createButton
        createButton.setIcon(createIcon);                          // sets button as create account image
        createButton.setVerticalAlignment(JButton.CENTER);         // puts the button on the center of the panel
        createButton.setBorderPainted(false);                   // makes the border of the button transparent so the image is the button
        createButton.addActionListener(new ActionListener() {      // Action Listener anonymous class
            @Override
            public void actionPerformed(final ActionEvent click) {
                QuizAppUser adminUser1 = new QuizAppUser();
			    try {
				    adminUser1.createNewUser();                    // starts create account method
			    } catch (Exception e) {
				    e.printStackTrace();
			    }
               createButton.setEnabled(false);
               frame.dispose(); 
            }
        });
        
        // Create "Create Account" Panel
        createPanel = new JPanel();
        createPanel.setBounds(350, 200, 250, 250);
        createPanel.setBackground(bgColor);

        // Create "Create Account" Label with Image
        createLabel = new JLabel();
        createLabel.setText("Create an Account");
        createLabel.setForeground(textColor);                          // sets text color to Night
        createLabel.setFont(new Font("Lib/helvetica-neue-9-cufonfonts/Helvetica65Medium_22443.ttf", Font.PLAIN, 20)); // sets font of text to Druk
        createLabel.setVerticalAlignment(JLabel.BOTTOM);               // sets Vertical position of icon + text
        createLabel.setHorizontalAlignment(JLabel.CENTER);             // sets Horizontal position of icon + text
        createPanel.add(createLabel);                                  // adds label to panel
        createPanel.add(createButton);                          
        
    // ******* END CREATE ACCOUNT ******* 


    // ******* GO BACK *******
    ImageIcon backIcon = new ImageIcon("Lib/209 - Media Buttons - 10.Flat Multicolor (A4 B99)/PNG/1024 x 1024/9935 - Left Arrow.png");
    Image backimg = backIcon.getImage();  
    Image newbackimg = backimg.getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH);
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
                new MainMenuGUI();                 
               } catch (Exception e) {
                   e.printStackTrace();
               }
               backButton.setEnabled(false);
               frame.dispose(); 
            }
        });
        
        // Create "Go Back" Panel
        backPanel = new JPanel();
        backPanel.setBounds(700, 200, 250, 250);
        backPanel.setBackground(bgColor);

        // Create "Create Account" Label with Image
        backLabel = new JLabel();
        backLabel.setText("Back to Menu");
        backLabel.setForeground(textColor);                          // sets text color to Night
        backLabel.setFont(new Font("Lib/helvetica-neue-9-cufonfonts/Helvetica65Medium_22443.ttf", Font.PLAIN, 20)); // sets font of text to Druk
        backLabel.setVerticalAlignment(JLabel.BOTTOM);               // sets Vertical position of icon + text
        backLabel.setHorizontalAlignment(JLabel.CENTER);             // sets Horizontal position of icon + text
        backPanel.add(backLabel);                                    // adds label to panel
        backPanel.add(backButton);                          
        
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
        closePanel.add(closeButton);                         
        closePanel.add(closeLabel);                                    // adds label to panel        
    // ******* END CLOSE *******


    // ******* FRAME *******

        // Creates the Frame
        frame = new JFrame();
        frame.setTitle("Quiz Maker - Admin Menu");             // sets frame title
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);                 // sets width and height of frame          
        frame.setLayout(null);                                 // disables default layout manager
    
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);          // exits the application on close
        frame.getContentPane().setBackground(bgColor); // sets background color as a warm white
        frame.add(headerPanel);                                        // adds header panel to frame
        frame.add(loginPanel);                                         // adds login panel to frame
        frame.add(createPanel);                                        // adds create account panel to frame
        frame.add(backPanel);                                          // adds go back panel to frame
        frame.add(closePanel);                                         // adds close panel to frame
        frame.setVisible(true);                                     // makes frame visible

    // ******* END FRAME *******

    } // end AdminLoginGUI() constructor
    
} // end AdminLoginGUI class
