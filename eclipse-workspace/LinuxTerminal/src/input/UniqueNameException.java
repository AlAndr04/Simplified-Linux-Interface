// **********************************************************
// Assignment2:
// Student1: Abhinav Chaudharu
// UTORID username: chaud349
// UT Student #: 1002707733
// Author: Abhinav Chaudhary
//
// Student2: Alexandru Andros
// UTORID username: androsal
// UT Student #: 1003354871
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
// Honor Code: I pledge that
// this program represents my own
// program code and that I have coded on my own. I received
// help from no one in designing and debugging my program.
// I have also read the plagiarism section in the course info
// sheet of CSC B07 and understand the consequences.
// *********************************************************
package input;

/**
 * Handles UniqueNameException
 * 
 *
 */
public class UniqueNameException extends Exception {
  /**
   * Name causing the raise of exception.
   */
  private String fsName;

  /**
   * Constructor for object UniqueNameException
   * 
   * @param fsNo: Name causing the exceptionn
   * @return Void
   */
  public UniqueNameException(String fsNo) {
    this.fsName = fsNo;
  }

  /**
   * String representation of object UniqueNameException
   * 
   * @param None
   * @return String: Name causing the raise of exception UniqueName
   */
  public String toString() {
    return this.fsName;
  }
}
