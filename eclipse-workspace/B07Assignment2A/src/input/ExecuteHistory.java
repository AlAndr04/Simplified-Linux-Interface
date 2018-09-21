// **********************************************************
// Assignment2:
// Student1: Abhinav Chaudharu
// UTORID username: chaud349
// UT Student #: 1002707733
// Author: Abhinav Chaudhary
//
// Student2: Alexandru Andros
// UTORID username: androsal
// UT Student #:
// Author: Alexandru Andros
//
// Student3: Balaji Babu
// UTORID username: babubala
// UT Student #:1003354871
// Author: Balaji Babu
//
// Student4: Zhi Zhong Huang
// UTORID username: huang472
// UT Student #:1002671094
// Author: Zhi Zhong Huang
//
//
// Honor Code: I pledge that this program represents my own
// program code and that I have coded on my own. I received
// help from no one in designing and debugging my program.
// I have also read the plagiarism section in the course info
// sheet of CSC B07 and understand the consequences.
package input;

import dirCommands.Commands;
import java.util.ArrayList;
/***
* The class Execute history is a command 
* which prints out the previous commands 
* by the user
*/

public class ExecuteHistory extends Commands<Void> {
  /***
  * A variable to keep track of the number of 
  * command
  */
  private int numcommand;
  /***
   * A location type for testing
   */
  private Location loc;
  /***
   * A List of Array to keep track of 
   * the history
   */
  private ArrayList<String> HistoryArr;
  /***
  *Constructor for the class. Gets the user inputs 
  * (commands)
  * @param String
  * @param Location
  * @return None
  */
  public ExecuteHistory(String numhistory, Location loc) {
    try {
      this.loc = loc;
      HistoryArr = this.loc.getHistoryArr();
      // Makes start the size minus newstart.
      this.numcommand = Integer.parseInt(numhistory) - 1;
      // Removes itself from History.
      HistoryArr.remove(HistoryArr.size() - 1);
      // If newstart is not a number, throws an exception to output and
      // makes newstart bigger than history array.
    } catch (NumberFormatException e) {
      numcommand = HistoryArr.size();
    }
  }
  /***
  *Executes the commands by adding user input into the 
  *history array
  *@param None
  *@return None
  */
  public Void execute() {
    if ((numcommand >= 0) && (numcommand < HistoryArr.size())) {
      HistoryArr.add(HistoryArr.get(numcommand));
      CommandManager command =
          new CommandManager(HistoryArr.get(numcommand), loc);
    } else {
      Output.invalidInput();
    }
    return null;
  }
}
