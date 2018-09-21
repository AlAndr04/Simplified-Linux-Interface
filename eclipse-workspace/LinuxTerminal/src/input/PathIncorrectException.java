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

import java.util.Arrays;

/**
 * Handles PathIncorrectException.
 * 
 *
 */
public class PathIncorrectException extends Exception {
  /**
   * Path(s) that are incorrect
   */
  private String[] path;

  /**
   * Constructor for object PathIncorrectException
   * 
   * @param newPath:
   */
  public PathIncorrectException(String[] newPath) {
    this.path = newPath;
  }

  /**
   * Returns incorrect path as a string, this is the string representation of PathIncorrectException
   * @return String: incorrect path.
   * @param None
   */
  public String toString() {
    String ret = "";
    if (path.length == 1) {
      ret += path[0];
    } else if (path.length > 1) {
      for (int i = 0; i < path.length - 1; i++) {
        ret += path[i] + "/";
      }
    }
    return ret;
  }
}
