// **********************************************************
// Assignment2:
// Student1: Abhinav Chaudharu
// UTORID user_name: chaud349
// UT Student #: 1002707733
// Author: Abhinav Chaudhary
//
// Student2: Alexandru Andros
// UTORID user_name: androsal
// UT Student #: 1004354263
// Author: Alexandru Andros
//
// Student3: Balaji Babu
// UTORID user_name: babubala
// UT Student #: 1003354871
// Author: Balaji Babu
//
// Student4: Zhi Zhong Huang
// UTORID user_name: huang472
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
  /**
   * Constructor for history with no parameters.
   * @param None
   * @return None
   */
  public History() {}
  /**
   * Constructor for history with one parameter. Makes start
   * equal to the size of history array - the new_start.
   * @param new_start
   * @return None
   */
  public History(String new_start) {
    try {
      // Makes start the size minus new_start.
      this.start = Input.History_Arr.size() - Integer.parseInt(new_start);
      // If new_start is not a number, throws an exception to output and
      // makes new_start bigger than history array.
    } catch (NumberFormatException e) {
      Output.mustBeIntegers();
      this.start = Input.History_Arr.size() + 1;
    }
  }
  /**
   * Prints all the contents of history array for start.
   * @param None
   * @return None
   */
  public String execute() {
    // Outputs error if start is less than 0.
    if (start < 0) {
      Output.invalidInput();
      // prints the contents of the history array.
    } else {
      for (int i = this.start; i < Input.History_Arr.size(); i++) {
        Output.printTextToShell((i + 1) + ". " + Input.History_Arr.get(i));
      }
    }
    return null;
  }
}
