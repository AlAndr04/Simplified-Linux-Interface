// **********************************************************
// Assignment2:
// Student1: Abhinav Chaudharu
// UTORID username: chaud349
// UT Student #: 1002707733
// Author: Abhinav Chaudhary
//
// Student2: Alexandru Andros
// UTORID username: androsal
// UT Student #: 1004354264
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

import fileSystemObjects.*;
import input.Location;
import input.Output;
import input.PathIncorrectException;
import java.util.Arrays;
import driver.JShell;
/**
 * The move command, that is responsible for moving.
 * @author Alex
 *
 */
public class Mv extends Commands<Void> {
  private FSElement src;
  private Directory dest;
  private String srcname;
  /**
   * The move constructor
   * @param input
   * @param loc
   */
  public Mv(String[] input, Location loc) {
    this.src = Traverse.accessFS(input[0], loc.getRoot());
    FSElement temp = Traverse.accessFS(input[1], loc.getRoot());
    if (temp instanceof Directory) {
      this.dest = (Directory) temp;
    }
    this.srcname = input[1];
  }
/**
 * The execute method for move. It does not create a new copy and removes the
 * old, but just changes the reference.
 */
  public Void execute() {
    if ((src != null) && (this.dest != null)) {
      Directory temp = (Directory) dest.getParent();
      while ((temp != null) && (temp != src)) {
        temp = (Directory) temp.getParent();
      }
      if (temp != null) {
        Output.NoMoveInDirectory();
      } else {
        this.src.removeFromParentRef();
        src.setParent(dest);
        dest.addToChildDir(src);
      }
    } else {
      if (this.dest == null) {
        Output.directoryFileNameInvalid();
      }
      if (this.src == null) {
        Output.pathIncorrect(this.srcname);
      }
    }
    return null;
  }

}
