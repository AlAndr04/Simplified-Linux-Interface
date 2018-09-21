// **********************************************************
// Assignment2:
// Student1: Abhinav Chaudharu
// UTORID user_name: chaud349
// UT Student #: 1002707733
// Author: Abhinav Chaudhary
//
// Student2: Alexandru Andros
// UTORID user_name: androsal
// UT Student #:1004354263
// Author: Alexandru Andros
//
// Student3: Balaji Babu
// UTORID user_name: babubala
// UT Student #:1003354871
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
package dirCommands;

import driver.JShell;
/**
 * Class that cooperates with directory stack. Includes the method
 * that pops the diretories out of the stack and makes them current
 * directories
 */
public class Popd extends Commands<Void> {
  /**
   * Constructor for Popd that takes no parameters.
   * 
   * @param None.
   * @return None.
   */
  public Popd() {}

  /**
   * Removes the top element of directory stack and makes it the new current
   * directory.
   * 
   * @param None.
   * @return None.
   */
  public Void execute() {
    // Pops the top element of directory stack
    String new_dir = JShell.Dir_Stack.pop();
    // Creates a new cd object and executes it using the top element as
    // input.
    Cd dir_changer = new Cd(new_dir);
    dir_changer.execute();
    return null;
  }

}
