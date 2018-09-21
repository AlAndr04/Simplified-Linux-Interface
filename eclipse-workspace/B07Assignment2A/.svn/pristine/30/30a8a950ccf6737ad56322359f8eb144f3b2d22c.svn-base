// **********************************************************
// Assignment2:
// Student1: Abhinav Chaudharu
// UTORID user_name: chaud349
// UT Student #: 1002707733
// Author: Abhinav Chaudhary
//
// Student2: Alexandru Andros
// UTORID user_name: androsal
// UT Student #:
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

import fileSystemObjects.*;
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
  public Pwd() {

  }

  /***
   * Executes this command by calling returnPathFromRoot.
   */
  public String execute() {
    Output.printTextToShell(returnPathFromRoot(JShell.curr_dir));
    return null;
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
