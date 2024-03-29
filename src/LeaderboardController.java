/**LeaderboardController Class
 * this class processes leaderboard sorting inputs
 *
 * @author Kevin Fu
 * @since January 20, 2023
*/

import javax.swing.*;
import java.awt.event.*;

public class LeaderboardController implements ActionListener
{
     //instance variables
     private Model2048 model;    //the model attatched to the controller
     private JComboBox selector; //the sorting selector box
     
     /**Constructor for LeaderboardController object
       * @param aModel The model the controller is attatched to
       * @param aSelector The combo box the controller is attatched to
       */
     public LeaderboardController (Model2048 aModel, JComboBox aSelector)
     {
          this.model = aModel;
          this.selector = aSelector;
     } //end of Leaderboard Controller constructor
     
     /**Triggers actions when the leaderboard sorting function is used
       * @param e The ActionEvent generated by the component used
       */
     public void actionPerformed (ActionEvent e)
     {
          this.model.sortLeaderboard((String)selector.getSelectedItem());
     } //end of actionPerformed method
     
} //LeaderboardController class