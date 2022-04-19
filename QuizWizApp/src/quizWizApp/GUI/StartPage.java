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

public class StartPage extends JFrame {

    static JButton startButton;                                     // declares JButton
    static JPanel imagePanel;                                       // declares JPanel
    static JLabel mainLabel;                                        // declares JLabel
    static JPanel subtextPanel;                                     // declares JPanel
    static JLabel subtextLabel;                                     // declares JLabel
    static JFrame frame;                                            // declares JFrame
    static Color textColor = new Color(0x1e1f26);               // sets text color
    static Color bgColor = new Color(0xF2EFEA);                 // sets background color


    public StartPage(){

    // ******* START BUTTON ********
    ImageIcon startIcon = new ImageIcon("Lib/209 - Media Buttons - 10.Flat Multicolor (A4 B99)/PNG/1024 x 1024/9914 - Play.png");
    Image img = startIcon.getImage();  
    Image newimg = img.getScaledInstance(300, 300, java.awt.Image.SCALE_SMOOTH);
    startIcon = new ImageIcon(newimg);

        // Creates start button
        startButton = new JButton();                                                      // initializes startButton
        startButton.setIcon(startIcon);  // sets the image as the button
        startButton.setVerticalAlignment(JButton.CENTER);                                // centers the image on the button
        startButton.setBorderPainted(false);                                          // makes the border of the button transparent so the image is the button
        startButton.addActionListener(new ActionListener() {                             // Action Listener anonymous class
            @Override
            public void actionPerformed(final ActionEvent e) {
                startButton.setEnabled(false);
                new MainMenuGUI();
                frame.dispose();
            }
        });

    // ******* END START BUTTON ********


    // ******* HOURGLASS PANEL ********

        // Create "Quiz Maker Menu" Panel
        imagePanel = new JPanel();
        imagePanel.setBounds(50, 50, 700, 400);
        imagePanel.setBackground(bgColor);                             // sets background color

        // Create "Quiz Maker Menu" Label with Image
        mainLabel = new JLabel();
        mainLabel.setText("Quiz Maker Main Menu");
        //mainLabel.setIcon(frontImage);
        mainLabel.setHorizontalTextPosition(JLabel.CENTER);            // sets text in center
        mainLabel.setVerticalTextPosition(JLabel.TOP);                 // sets text above image
        mainLabel.setForeground(textColor);                            // sets text color to Night
        mainLabel.setFont(new Font("Lib/Druk/DrukTextWide-Bold.otf", Font.BOLD, 60)); // sets font of text to Druk
        mainLabel.setIconTextGap(-100);                                // brings text closer to the image
        mainLabel.setVerticalAlignment(JLabel.CENTER);                 // sets Vertical position of icon + text
        mainLabel.setHorizontalAlignment(JLabel.CENTER);               // sets Horizontal position of icon + text
        imagePanel.add(mainLabel);                                     // adds label to panel
        imagePanel.add(startButton); 

    // ******* END HOURGLASS PANEL ********                         


    // ******* SUBTEXT PANEL *******

        // Create "Click to Begin" Panel
        subtextPanel = new JPanel();
        subtextPanel.setBounds(50, 450, 700, 500);           // sets bounds of the subtext panel below the other panel 
        subtextPanel.setBackground(bgColor);                                   // sets background color
        
        // Create "Click to Begin" Label
        subtextLabel = new JLabel();
        subtextLabel.setText("Click to begin");                           // sets text
        subtextLabel.setHorizontalTextPosition(JLabel.CENTER);                 // sets text in center of the label
        subtextLabel.setVerticalTextPosition(JLabel.TOP);                      // sets text on top of the label
        subtextLabel.setForeground(textColor);                                 // sets text color to Night
        subtextLabel.setFont(new Font("Lib/helvetica-neue-9-cufonfonts/HelveticaNeueMediumItalic.otf", Font.PLAIN, 25)); // sets font of text to Helvetica
        subtextLabel.setVerticalAlignment(JLabel.CENTER);                      // sets Vertical position of icon + text
        subtextLabel.setHorizontalAlignment(JLabel.CENTER);                    // sets Horizontal position of icon + text
        subtextPanel.add(subtextLabel);                                        // adds subtext label to panel
    
    // ******* END SUBTEXT PANEL *******


    // ******* FRAME *******

        // Creates the Frame
        frame = new JFrame();
        frame.setTitle("Quiz Maker - Start Page");                       // sets frame title
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);                         // sets width and height of frame          
        frame.setLayout(null);                                         // disables default layout manager
    
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);                  // exits the application on close
        frame.getContentPane().setBackground(bgColor);                         // sets background color as a warm white
        frame.add(imagePanel);                                                 // adds image panel to frame
        frame.add(subtextPanel);                                               // adds subtext panel to frame
        frame.setVisible(true);                                             // makes frame visible
    
    // ******* END FRAME *******
    } // end StartPage constructor
    
} // end StartPage class
