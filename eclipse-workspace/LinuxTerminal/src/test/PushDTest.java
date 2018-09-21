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

import static org.junit.Assert.*;
import java.io.*;
import org.junit.Test;
import org.junit.Before;
import dirCommands.Pushd;

public class PushDTest {
  private Pushd pushd;
  private MockJShell JShell;

  @Before
  public void setUp() {
    JShell = new MockJShell();
  }

  @Test
  /**
   * Test push of 1 directory.
   */
  public void testPush() {
    pushd = new Pushd("/Dir_1", JShell.getMockLocation());
    pushd.execute();
    String output = JShell.getMockLocation().getDirStack().peek() + " "
        + JShell.getMockLocation().getCurrDir().getName();
    assertEquals("/ Dir_1", output);
  }

  @Test
  /**
   * Test push of the same directory as the current one.
   */
  public void testPushSameDir() {
    pushd = new Pushd("/", JShell.getMockLocation());
    pushd.execute();
    String output = JShell.getMockLocation().getDirStack().peek() + " "
        + JShell.getMockLocation().getCurrDir().getName();
    assertEquals("/ /", output);
  }

  @Test
  /**
   * Test push of a directory that does not exist.
   */
  public void testPushNonExistingDir() {
    final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    pushd = new Pushd("/Jeff", JShell.getMockLocation());
    pushd.execute();
    String actualOutput =
        "/Jeff: No such file or directory" + System.lineSeparator();
    assertEquals(actualOutput, outContent.toString());
  }
}
