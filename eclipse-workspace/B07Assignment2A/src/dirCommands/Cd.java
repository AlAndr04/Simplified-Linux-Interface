package dirCommands;

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
import input.Location;
import fileSystemObjects.*;
import input.Output;

/**
 * Cd makes a new current directory. Inherits from commands and represents the
 * cd command.
 *
 */
public class Cd extends Commands<Void> {
  /**
   * abspath: the path of the new currdir, if it is a correct one.
   */
  private String abspath;
  private Location loc;

  /**
   * Constructor for cd that gives the abspath instance variable the . given
   * value of abspath.
   * 
   * @param String input abspath that represents the absolute path needed to
   *        traverse..
   * @return none
   **/
  public Cd(String abspath, Location loc) {
    this.abspath = abspath;
    this.loc = loc;
  }

  /**
   * Method execute switches the currdir to the abspath given.
   * 
   * @param none
   * @return none
   **/
  public Void execute() {
    Directory currdir = loc.getCurrDir();
    Directory root = loc.getRoot();
    // Makes a temporary directory temp equal null.
    Directory temp = null;
    // Checks if path contains .., which would mean it has to switch to its
    // parent directory.
    if (abspath.contains("/..")) {
      // Checks if currdir is the root, which would mean it has no parent,
      // which throws an error.
      if (currdir == root) {
        Output.invalidInput();
      } else {
        // Otherwise gets the parent.
        currdir = (Directory) currdir.getParent();
      }
    } else if (!(abspath.contains("/."))) {
      // If the command was . then don't change current directory, so
      // it is not covered. If it is not, which would mean it's a standard
      //
      temp = Traverse.findPathString(this.abspath, root);
      if (temp == null) {
        Output.pathDoesNotExistError(this.abspath);
      } else {
        currdir = temp;
      }
    }
    loc.setCurrDir(currdir);
    return null;
  }

}
