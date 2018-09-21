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
package test;

import input.ExecuteHistory;
import input.History;
import fileSystemObjects.Directory;
import fileSystemObjects.File;
import static org.junit.Assert.*;
import java.io.*;
import org.junit.Test;
import org.junit.Before;

public class ExecuteHistoryTest {
  private ExecuteHistory ehist;
  private MockJShell JShell;

  @Before
  public void setUp() {
    JShell = new MockJShell();
  }

  @Test
  /**
   * Tests history with a basic command.
   */
  public void testExecHistBasic() {
    final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    ehist = new ExecuteHistory("3", JShell.getMockLocation());
    ehist.execute();
    String actualOutput = "/" + System.lineSeparator();
    assertEquals(actualOutput, outContent.toString());
  }

  @Test
  /**
   * Tests history with a command that changes stuff.
   */
  public void testExecHistActionCommand() {
    ehist = new ExecuteHistory("2", JShell.getMockLocation());
    ehist.execute();
    String output =
        JShell.getMockLocation().getRoot().getChildDir().get(5).getName();
    String actualOutput = "a";
    assertEquals(actualOutput, output);
  }

  @Test
  /**
   * Tests history with a command that has an invalid number.
   */
  public void testExecHistInvalidNum() {
    final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    ehist = new ExecuteHistory("0", JShell.getMockLocation());
    ehist.execute();
    String actualOutput = "Input invalid please refer to details via man CMD"
        + System.lineSeparator();
    assertEquals(actualOutput, outContent.toString());
  }

  @Test
  /**
   * Tests history with a command that has a string as input.
   */
  public void testExecHistString() {
    final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    ehist = new ExecuteHistory("Jeff", JShell.getMockLocation());
    ehist.execute();
    String actualOutput = "Input invalid please refer to details via man CMD"
        + System.lineSeparator();
    assertEquals(actualOutput, outContent.toString());
  }

  @Test
  /**
   * Tests history with an invalid command.
   */
  public void testExecHistInvalidCommand() {
    final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    ehist = new ExecuteHistory("1", JShell.getMockLocation());
    ehist.execute();
    String actualOutput =
        "Command invalid please refer to the manual via man CMD"
            + System.lineSeparator();
    assertEquals(actualOutput, outContent.toString());
  }

  @Test
  /**
   * Tests history with a -R Command.
   */
  public void testHistRCommand() {
    final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    // gets to file_1_1, without using any commands.
    File file = (File) ((Directory) JShell.getRootDir().getChildDir().get(0))
        .getChildDir().get(1);
    file.addToContent("a");
    ehist = new ExecuteHistory("4", JShell.getMockLocation());
    ehist.execute();
    String actualOutput = "/Dir_1/file_1_1:\na" + System.lineSeparator();
    assertEquals(actualOutput, outContent.toString());
  }
}
