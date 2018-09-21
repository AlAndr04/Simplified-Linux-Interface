package dirCommands;

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
import driver.JShell;
import fileSystemObjects.*;
import input.Output;
/**
 * Cd makes a new current directory. Inherits from commands and
 * represents the cd command.
 *
 */
public class Cd extends Commands<Void> {
  /**
   * abs_path: the path of the new curr_dir, if it is a correct one.
   */
  private String abs_path;

  /**
   * Constructor for cd that gives the abs_path instance variable the . given
   * value of abs_path.
   * 
   * @param String input abs_path that represents the absolute path needed to
   *        traverse..
   * @return none
   **/
  public Cd(String abs_path) {
    this.abs_path = abs_path;
  }

  /**
   * Method execute switches the curr_dir to the abs_path given.
   * 
   * @param none
   * @return none
   **/
  public Void execute() {
    // Makes a temporary directory temp equal null.
    Directory temp = null;
    // Checks if path contains .., which would mean it has to switch to its
    // parent directory.
    if (abs_path.contains("/..")) {
      // Checks if curr_dir is the root, which would mean it has no parent,
      // which throws an error.
      if (JShell.curr_dir == JShell.root) {
        Output.invalidInput();
      } else {
        // Otherwise gets the parent.
        JShell.curr_dir = (Directory) JShell.curr_dir.getParent();
      }
    } else if (!(abs_path.contains("/."))) {
      // If the command was . then don't change current directory, so
      // it is not covered. If it is not, which would mean it's a standard
      //
      temp = Traverse.findPathString(this.abs_path, JShell.root);
      if (temp == null) {
        Output.pathDoesNotExistError(this.abs_path);
      } else {
        JShell.curr_dir = temp;
      } // System.out.println(JShell.curr_dir.getName());
    }
    return null;
  }

}
