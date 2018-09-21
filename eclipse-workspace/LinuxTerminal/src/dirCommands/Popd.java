// **********************************************************
// Assignment2:
// Student1: Abhinav Chaudharu
// UTORID username: chaud349
// UT Student #: 1002707733
// Author: Abhinav Chaudhary
//
// Student2: Alexandru Andros
// UTORID username: androsal
// UT Student #:1004354263
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
// *********************************************************
package dirCommands;

import input.Location;
import input.Output;

/**
 * Class that cooperates with directory stack. Includes the method that pops the
 * diretories out of the stack and makes them current directories
 */
public class Popd extends Commands<Void> {
  /**
   * Constructor for Popd that takes no parameters.
   * 
   * @param None.
   * @return None.
   */
  private Location loc;

  public Popd(Location loc) {
    this.loc = loc;
  }

  /**
   * Removes the top element of directory stack and makes it the new current
   * directory.
   * 
   * @param None.
   * @return None.
   */
  public Void execute() {
    // Checks if the stack is empty.
    if (loc.getDirStack().empty()) {
      Output.emptyStack();
    } else {
      // Pops the top element of directory stack
      String newdir = loc.getDirStack().pop();
      // Creates a new cd object and executes it using the top element as
      // input.
      Cd dirchanger = new Cd(newdir, loc);
      dirchanger.execute();
    }
    return null;
  }

}
