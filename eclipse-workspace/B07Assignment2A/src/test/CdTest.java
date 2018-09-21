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
package test;

import static org.junit.Assert.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.Before;
import org.junit.Test;
import dirCommands.Cd;



public class CdTest {
  private Cd cd;
  private MockJShell JShell;

  @Before
  public void setUp() {
    JShell = new MockJShell();
  }

  @Test
  /**
   * Test cd with invalid directory
   * 
   * @param none
   * @return none
   */
  public void testExecuteNoDirectory() {
    final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    cd = new Cd("/Jeff", JShell.getMockLocation());
    cd.execute();
    String actualOutput =
        "/Jeff: No such file or directory" + System.lineSeparator();
    assertEquals(actualOutput, outContent.toString());
  }

  @Test
  /**
   * Test cd with valid directory
   * 
   * @param none
   * @return none
   */
  public void testExecuteDirectoryExists() {
    cd = new Cd("/Dir_1", JShell.getMockLocation());
    cd.execute();
    assertEquals("Dir_1", JShell.getMockLocation().getCurrDir().getName());
  }

  @Test
  /**
   * Test cd with . as input
   * 
   * @param none
   * @return none
   */
  public void testExecuteDot() {
    cd = new Cd("/.", JShell.getMockLocation());
    cd.execute();
    assertEquals(JShell.getMockLocation().getRoot(),
        JShell.getMockLocation().getCurrDir());
  }

  @Test
  /**
   * Test cd with .. as input, the input being valid.
   * 
   * @param none
   * @return none
   */
  public void testExecuteDoubleDotValid() {
    cd = new Cd("/Dir_1", JShell.getMockLocation());
    cd.execute();
    cd = new Cd("/..", JShell.getMockLocation());
    cd.execute();
    assertEquals(JShell.getMockLocation().getRoot(),
        JShell.getMockLocation().getCurrDir());
  }

  @Test
  /**
   * Test cd with .. as input, the input being invalid, since the directory is
   * the root one.
   * 
   * @param none
   * @return none
   */
  public void testExecuteDoubleDotInvalid() {
    final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    cd = new Cd("/..", JShell.getMockLocation());
    cd.execute();
    String actualOutput = "Input invalid please refer to details via man CMD"
        + System.lineSeparator();
    assertEquals(actualOutput, outContent.toString());
  }

  @Test
  /**
   * Test cd through multiple directories.
   * 
   * @param none
   * @return none
   */
  public void testExecuteMultipleDirectories() {
    cd = new Cd("/Dir_1/Dir_1_1", JShell.getMockLocation());
    cd.execute();
    String actualOutput = "Dir_1_1";
    assertEquals(actualOutput, JShell.getMockLocation().getCurrDir().getName());
  }

  @Test
  /**
   * Test cd into file. The current directory should not change.
   * 
   * @param none
   * @return none
   */
  public void testExecuteCdIntoFile() {
    final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    cd = new Cd("/Dir_1/file_1_1", JShell.getMockLocation());
    cd.execute();
    String actualOutput =
        "/Dir_1/file_1_1: No such file or directory" + System.lineSeparator();
    assertEquals(actualOutput, outContent.toString());
  }

  @Test
  /**
   * Test cd multiple times.
   * 
   * @param none
   * @return none
   */
  public void testExecuteMultipleCds() {
    cd = new Cd("/Dir_1", JShell.getMockLocation());
    cd.execute();
    cd = new Cd("/Dir_1/Dir_1_1", JShell.getMockLocation());
    cd.execute();
    assertEquals("Dir_1_1", JShell.getMockLocation().getCurrDir().getName());
  }
}
