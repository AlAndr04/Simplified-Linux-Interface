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
// *********************************************************
package dirCommands;

import fileSystemObjects.*;
import input.Location;
import input.Output;
import java.util.Stack;
import driver.JShell;

/***
 * Pwd command class. This class represents the pwd method in JShell which
 * returns a string pathname from the current directory relative to root.
 *
 */
public class Pwd extends Commands<String> {

  /***
   * Constructor for a Pwd Object
   */
  private Directory curr;

  public Pwd(Location loc) {
    curr = loc.getCurrDir();
  }

  /***
   * Executes this command by calling returnPathFromRoot.
   */
  public String execute() {
    return returnPathFromRoot(curr);
  }

  /***
   * Returns a string path from element to the root directory
   * 
   * @param element FSElement to find the path relative to the root directory
   *        from
   * @return string path from element to root directory
   */
  public static String returnPathFromRoot(FSElement element) {
    Stack<String> pathTo = new Stack<String>();
    String returnPath = "";
    FSElement elCopy = element;
    if (elCopy.getParent() == null) {
      return (returnPath += elCopy.getName());
    }
    while (elCopy != null) {
      pathTo.push(elCopy.getName());
      elCopy = elCopy.getParent();
    }
    while (!(pathTo.isEmpty())) {
      if (pathTo.peek() != "/") {
        returnPath += ("/" + pathTo.pop());
      } else {
        pathTo.pop();
      }
    }
    return returnPath;
  }
}
