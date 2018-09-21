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
import java.io.*;
import org.junit.Test;
import org.junit.Before;
import dirCommands.Find;
import fileSystemObjects.*;

public class FindTest {
  private Find find;
  private MockJShell JShell;

  @Before
  public void setUp() {
    JShell = new MockJShell();
  }

  @Test
  /**
   * Test find from root directory.
   */
  public void testFindAtRoot() {
    String[] array = {"/", "d", "Dir_5"};
    find = new Find(array, JShell.getMockLocation());
    String output = find.execute();
    assertEquals("/Dir_5", output);
  }

  @Test
  /**
   * Test find to search for root directory.
   */
  public void testFindRootAtRoot() {
    String[] array = {"/", "d", "/"};
    final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    find = new Find(array, JShell.getMockLocation());
    find.execute();
    assertEquals("No files found." + System.lineSeparator(),
        outContent.toString());
  }

  @Test
  /**
   * Test find to search for multiple directroies from root directory.
   */
  public void testFindMultipleDirectories() {
    String[] array = {"/", "d", "Dir_1_2"};
    find = new Find(array, JShell.getMockLocation());
    String output = find.execute();
    String actualOutput = "/Dir_1/Dir_1_2\n/Dir_5/Dir_1_2";
    assertEquals(actualOutput, output);
  }

  @Test
  /**
   * Test find to search for multiple directroies from root directory.
   */
  public void testFindMultipleSources() {
    String[] array = {"/Dir_5", "/Dir_1", "d", "Dir_1_2"};
    find = new Find(array, JShell.getMockLocation());
    String output = find.execute();
    String actualOutput = "/Dir_5/Dir_1_2\n/Dir_1/Dir_1_2";
    assertEquals(actualOutput, output);
  }
}
