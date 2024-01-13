/**OKController Class
 * This class processes the OK button for 2048.
 *
 * @author Kevin Fu
 * @since January 22, 2023
*/

import javax.swing.*;
import java.awt.event.*;

public class OKController implements ActionListener
{
     //instance variables
     private Model2048 model;    //the model attatched to the controller
     private JPanel panel;       //the panel containing all new game components
     private JTextField name;    //the text field where the user inputs their name
     private JTextField rounds;  //the text field where the user enters max number of rounds to play
     private JButton ok;         //the ok button
     private JLabel status;      //the status label that displays if the user has lost or won
     
     /**Constructor for OKController object
       * @param aModel The model the controller is attatched to
       * @param aPanel The panel containing all new game components
       * @param aName The textfield containing the user's entered name
       * @param aRounds The textfield containing the user's entered number or rounds
       * @param aButton The ok button
       * @param aStatus The status label that displays if the user has lost or won
       */
     public OKController (Model2048 aModel, JPanel aPanel, JTextField aName, JTextField aRounds, JButton aButton, JLabel aStatus)
     {
          this.model = aModel;
          this.panel = aPanel;
          this.name = aName;
          this.rounds = aRounds;
          this.ok = aButton;
          this.status = aStatus;
     } //end of OKController constructor
     
     /**Triggers actions when OK button is used
       * @param e The ActionEvent generated by the component used
       */
     public void actionPerformed (ActionEvent e)
     {
          boolean disable = true; //flag that determines if the button will be disabled or not after use
          
          //if OK button is pressed on game setup screen
          if (this.model.getRoundNum() == 0) {
               String userName = ""; //stores the user's name
               int userRounds = 0;   //stores the max rounds entered
               
               //gets userName
               if (this.name.getText().equals(""))
                    this.name.setText("Invalid.");
               else
                    userName = this.name.getText();
               
               //gets userRounds
               try { 
                    userRounds = Integer.parseInt(this.rounds.getText());
                    if (userRounds <= 0)
                         this.rounds.setText("Invalid.");
               }
               catch (NumberFormatException ex) {
                    this.rounds.setText("Invalid.");
               }
               
               //sets up game with text in text fields if not invalid
               if (!this.name.getText().equals("Invalid.") && !this.rounds.getText().equals("Invalid.")) {
                    this.model.setUpGame(userName, userRounds);
                    this.panel.setVisible(false);
               }
               else
                    disable = false;
          } //end of game setup screen functions
          
          //disables game setup components if all info is entered correctly and starts a new round
          if (disable) {
               this.ok.setEnabled(false);
               this.status.setVisible(false);
               this.model.setButtonsEnabled(true);
               this.model.newRound();
          }
     } //end of actionPerformend method
     
} //OKController class