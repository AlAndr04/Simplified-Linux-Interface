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
import dirCommands.Popd;

public class PopDTest {
  private Popd popd;
  private MockJShell JShell;

  @Before
  public void setUp() {
    JShell = new MockJShell();
  }

  @Test
  /**
   * Test pop of 1 directory.
   */
  public void testPop() {
    JShell.getMockLocation().getDirStack().push("/Dir_2");
    JShell.getMockLocation().getDirStack().push("/Dir_1");
    popd = new Popd(JShell.getMockLocation());
    popd.execute();
    String output = JShell.getMockLocation().getCurrDir().getName();
    output += " " + JShell.getMockLocation().getDirStack().peek();
    assertEquals("Dir_1 /Dir_2", output);
  }

  @Test
  /**
   * Test pop of 1 directory that does not exist.
   */
  public void testPopNoDirectory() {
    final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    JShell.getMockLocation().getDirStack().push("/Dir_6");
    popd = new Popd(JShell.getMockLocation());
    popd.execute();
    String actualOutput =
        "/Dir_6: No such file or directory" + System.lineSeparator();
    assertEquals(actualOutput, outContent.toString());
  }

  @Test
  /**
   * Test pop of 1 directory that does not exist.
   */
  public void testPopEmpty() {
    final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    popd = new Popd(JShell.getMockLocation());
    popd.execute();
    String actualOutput = "The stack is empty" + System.lineSeparator();
    assertEquals(actualOutput, outContent.toString());
  }
}
