// **********************************************************
// Assignment2:
// Student1: Abhinav Chaudharu
// UTORID username: chaud349
// UT Student #: 1002707733
// Author: Abhinav Chaudhary
//
// Student2: Alexandru Andros
// UTORID username: androsal
// UT Student #: 1004354263
// Author: Alexandru Andros
//
// Student3: Balaji Babu
// UTORID username: babubala
// UT Student #: 1003354871
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
// *********************************************************
package input;

import dirCommands.Commands;
import java.util.ArrayList;
import driver.JShell;

/**
 * Class that represents history command and cooperates with history array.
 * Responsible for the methods that prints the commands.
 *
 */
public class History extends Commands<String> {
  /**
   * start: the start point of history.
   */
  private int start = 0;
  private ArrayList<String> HistoryArr;

  /**
   * Constructor for history with no parameters.
   * 
   * @param None
   * @return None
   */
  public History(Location loc) {
    HistoryArr = loc.getHistoryArr();
  }

  /**
   * Constructor for history with one parameter. Makes start equal to the size
   * of history array - the newstart.
   * 
   * @param newstart
   * @return None
   */
  public History(String newstart, Location loc) {
    try {
      HistoryArr = loc.getHistoryArr();
      // Makes start the size minus newstart.
      this.start = HistoryArr.size() - Integer.parseInt(newstart);
      // If newstart is not a number, throws an exception to output and
      // makes newstart bigger than history array.
    } catch (NumberFormatException e) {
      this.start = HistoryArr.size() + 1;
    }
  }

  /**
   * Prints all the contents of history array for start.
   * 
   * @param None
   * @return None
   */
  public String execute() {
    String output = "";
    // Outputs error if start is less than 0.
    if ((start < 0) || (start > HistoryArr.size())) {
      Output.invalidInput();
      // prints the contents of the history array.
    } else {
      for (int i = this.start; i < HistoryArr.size(); i++) {
        output += String.valueOf(i + 1) + ". " + HistoryArr.get(i) + "\n";
      }
    }
    if (output.length() == 0) {
      return null;
    } else {
      return output.substring(0, output.length() - 1);
    }
  }
}
