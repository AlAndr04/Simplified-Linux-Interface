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

import driver.JShell;
import fileSystemObjects.*;
import fileCommands.Mkfile;
import input.PathIncorrectException;
import input.UniqueNameException;
import input.Output;
import input.Location;
/**
 * Copy command that copies a FSElement into a valid destination.
 * @author Alex
 *
 */
public class Cp extends Commands<Void>{
  private FSElement src;
  private FSElement dest;
  private String srcName;
  private String destName;
  private Directory root;
  /**
   * The constructor for copy.
   * @param input
   * @param loc
   */
  public Cp(String[] input, Location loc) {
      this.root = loc.getRoot();
      this.src = Traverse.accessFS(input[0], root);
      this.dest = Traverse.accessFS(input[1], root);
      this.srcName = input[0];
      this.destName = input[1];
  }
  /**
   * Executes the copy command.
   */
  public Void execute() {
    if (dest instanceof Directory) {
      Directory dir = (Directory) this.dest;
      if ((src != null) && (dir != null)) {
        if (src instanceof File) {
          File orig = (File) src;
          File newFile = new File(src.getName(), dir);
          newFile.addToContent(orig.getContent());
        } else {
          try {
          Directory newInst = Directory.makeDir(src.getName(), dir);
          } catch (UniqueNameException e) {
            Output.nameNotValid(src.getName());
          }
        }
      } else {
        if (this.src == null) {
          Output.pathIncorrect(this.srcName);
        }
        if (dir == null) {
          Output.directoryFileNameInvalid();
        }
      }
    } else {
      if (this.src == null ) {
        Output.pathIncorrect(this.srcName);
      }
      Output.NotDirectory(this.destName);
    }
    return null;
  }
}
