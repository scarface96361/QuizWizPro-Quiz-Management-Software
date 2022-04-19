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

import quizWizApp.QuizMenu;

public class MainMenuGUI extends JFrame {

    static JLabel headerLabel;                                      // declares JLabel
    static JPanel headerPanel;                                      // declares JPanel
    static JButton teacherButton;                                   // declares JButton
    static JButton studentButton;                                   // declares JButton
    static JPanel teacherPanel;                                     // declares JPanel
    static JLabel teacherLabel;                                     // declares JLabel
    static JPanel studentPanel;                                     // declares JPanel
    static JLabel studentLabel;                                     // declares JLabel
    static JFrame frame;                                            // declares JFrame
    static Color textColor = new Color(0x1e1f26);               // sets text color
    static Color bgColor = new Color(0xF2EFEA);                 // sets background color

    MainMenuGUI(){

    // ******* HEADER *******

        headerPanel = new JPanel();
        headerPanel.setBounds(25, 50, 675, 100);
        headerPanel.setBackground(bgColor);
        headerLabel = new JLabel("<html>Welcome to Quiz Wiz Pro<br/>Team Trinity Software Group 2022</html>", SwingConstants.CENTER);
        headerLabel.setForeground(textColor);                           // sets text color to Night
        headerLabel.setFont(new Font("Lib/Druk/Druk.otf", Font.BOLD, 35)); // sets font of text to Druk
        headerLabel.setVerticalAlignment(JLabel.TOP);                   // sets Vertical position of icon + text
        headerLabel.setHorizontalAlignment(JLabel.CENTER);              // sets Horizontal position of icon + text
        headerPanel.add(headerLabel);                                   // adds label to panel
    
    // ******* END HEADER *******


    // ******* TEACHER *******

        // Creates teacher button
        ImageIcon teacherIcon = new ImageIcon("Lib/Teacher:Student Icons/PNG/480px/teacher_hires.png");
        Image img = teacherIcon.getImage();  
        Image newimg = img.getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH);
        teacherIcon = new ImageIcon(newimg);
    
        teacherButton = new JButton();                              // initializes teacherButton
        teacherButton.setIcon(teacherIcon);                         // sets button as teacher image
        teacherButton.setVerticalAlignment(JButton.CENTER);         // puts the button on the center
        teacherButton.setBorderPainted(false);                   // makes the border of the button transparent so the image is the button
        teacherButton.addActionListener(new ActionListener() {      // Action Listener anonymous class
            @Override
            public void actionPerformed(final ActionEvent click) {
               QuizMenu menu = new QuizMenu();
               try {
                menu.adminLoginPrompt();
               } catch (Exception e) {
                   //TODO: handle exception
                   e.printStackTrace();
               }
               teacherButton.setEnabled(false);
               frame.dispose(); 
            }
        });
        
        // Create "Teacher" Panel
        teacherPanel = new JPanel();
        teacherPanel.setBounds(25, 200, 200, 200);
        teacherPanel.setBackground(bgColor);

        // Create "Teacher" Label with Image
        teacherLabel = new JLabel();
        teacherLabel.setText("Teacher");
        teacherLabel.setForeground(textColor);                          // sets text color to Night
        teacherLabel.setFont(new Font("Lib/Druk/DrukTextWide-Bold.otf", Font.BOLD, 35)); // sets font of text to Druk
        teacherLabel.setVerticalAlignment(JLabel.BOTTOM);               // sets Vertical position of icon + text
        teacherLabel.setHorizontalAlignment(JLabel.CENTER);             // sets Horizontal position of icon + text
        teacherPanel.add(teacherLabel);                                 // adds label to panel
        teacherPanel.add(teacherButton);                          

    // ******* END TEACHER *******   


    // ******* STUDENT *******
        // Creates student button
        ImageIcon studentIcon = new ImageIcon("Lib/Teacher:Student Icons/PNG/480px/reading_hires.png");
        Image studentimg = studentIcon.getImage();  
        Image newStudentimg = studentimg.getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH);
        studentIcon = new ImageIcon(newStudentimg);

        studentButton = new JButton();                              // initializes studentButton
        studentButton.setIcon(studentIcon); // sets button as student image
        studentButton.setVerticalAlignment(JButton.CENTER);         // puts the button on the center of the panel
        studentButton.setBorderPainted(false);                   // makes the border of the button transparent so the image is the button
        studentButton.addActionListener(new ActionListener() {      // Action Listener anonymous class
            @Override
            public void actionPerformed(final ActionEvent click) {
               QuizMenu menu = new QuizMenu();
               try {
                menu.studentLoginPrompt();
               } catch (Exception e) {
                   //TODO: handle exception
                   e.printStackTrace();
               }
               studentButton.setEnabled(false);
               frame.dispose(); 
            }
        });
        
        // Create "Student" Panel
        studentPanel = new JPanel();
        studentPanel.setBounds(350, 200, 150, 200);
        studentPanel.setBackground(bgColor);

        // Create "Student" Label with Image
        studentLabel = new JLabel();
        studentLabel.setText("Student");
        studentLabel.setForeground(textColor);                          // sets text color to Night
        studentLabel.setFont(new Font("Lib/Druk/DrukTextWide-Bold.otf", Font.BOLD, 35)); // sets font of text to Druk
        studentLabel.setVerticalAlignment(JLabel.BOTTOM);               // sets Vertical position of icon + text
        studentLabel.setHorizontalAlignment(JLabel.CENTER);             // sets Horizontal position of icon + text
        studentPanel.add(studentLabel);                                 // adds label to panel
        studentPanel.add(studentButton);                          
        
    // ******* END STUDENT ******* 


    // ******* FRAME *******
        // Creates the Frame
        frame = new JFrame();
        frame.setTitle("Quiz Maker - Main Menu");                // sets frame title
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);                 // sets width and height of frame          
        frame.setLayout(null);                                 // disables default layout manager
    
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);          // exits the application on close
        frame.getContentPane().setBackground(bgColor); // sets background color as a warm white
        frame.add(headerPanel);                                        // adds header panel to frame
        frame.add(teacherPanel);                                       // adds teacher panel to frame
        frame.add(studentPanel);                                       // adds student panel to frame
        frame.setVisible(true);                                     // makes frame visible
    // ******* END FRAME *******

    } // end MainMenuGUI constructor
    
} // end MainMenuGUI class
