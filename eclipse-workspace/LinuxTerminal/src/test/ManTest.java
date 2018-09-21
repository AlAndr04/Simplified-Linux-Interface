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

package test;

import dirCommands.*;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * Class ManTest, testing class for Man
 * 
 * @author babubala
 *
 */

public class ManTest {

  /**
   * Manual reference to MockMan class used to invoke MockMan constructor and
   * create objects in test methods
   */
  private MockMan manual;

  /**
   * Testing method for when manual for a valid command is requested.
   * 
   * @param None
   * @return Void
   */
  @Test
  public void testValidCmdExecute() {
    manual = new MockMan("exit");
    String actual = "Usage: exit\nQuits the program";
    String expected = manual.execute();
    assertEquals(actual, expected);
  }

  /**
   * Testing method for when manual for an invalid command is requested.
   * 
   * @param None
   * @return Void
   */
  @Test
  public void testInvalidCmdExecute() {
    manual = new MockMan("sadfsaf");
    String actual = "invalid cmd requested";
    String expected = manual.execute();
    assertEquals(actual, expected);
  }

}
