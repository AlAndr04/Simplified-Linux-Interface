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
import dirCommands.Ls;
import input.Location;

public class LsTest {
  
  private MockJShell mockJS;
  @Before
  public void setUp() throws Exception {
    mockJS = new MockJShell();
  }
  /***
   * Testing Ls when no recursive option is given and no path is given
   */
  @Test
  public void testLsNonRecursiveNoPathGiven() {
    Location newLoc = new Location(mockJS.getRootDir(), null, null);
    String[] strArg = {};
    String compString ="Dir_1\n" + 
        "Dir_2\n" + 
        "Dir_3\n" + 
        "Dir_4\n" + 
        "Dir_5";
    Ls testLs = new Ls(strArg, false, newLoc);
    assertEquals(compString,testLs.execute());
  }
  private String testLsRecursiveString = "/:\n" + 
      "Dir_1\n" + 
      "Dir_2\n" + 
      "Dir_3\n" + 
      "Dir_4\n" + 
      "Dir_5\n" + 
      "\n" + 
      "/Dir_1:\n" + 
      "Dir_1_1\n" + 
      "file_1_1\n" + 
      "Dir_1_2\n" + 
      "\n" + 
      "/Dir_1/Dir_1_1:\n" + 
      "\n" + 
      "\n" + 
      "/Dir_1/file_1_1\n" + 
      "\n" + 
      "/Dir_1/Dir_1_2:\n" + 
      "\n" + 
      "\n" + 
      "/Dir_2:\n" + 
      "file_2_1\n" + 
      "\n" + 
      "/Dir_2/file_2_1\n" + 
      "\n" + 
      "/Dir_3:\n" + 
      "\n" + 
      "\n" + 
      "/Dir_4:\n" + 
      "\n" + 
      "\n" + 
      "/Dir_5:\n" + 
      "Dir_5_1\n" + 
      "file_5_1\n" + 
      "Dir_5_2\n" + 
      "Dir_1_2\n" + 
      "\n" + 
      "/Dir_5/Dir_5_1:\n" + 
      "\n" + 
      "\n" + 
      "/Dir_5/file_5_1\n" + 
      "\n" + 
      "/Dir_5/Dir_5_2:\n" + 
      "\n" + 
      "\n" + 
      "/Dir_5/Dir_1_2:\n";
  @Test
  public void testLsRecursiveNoPathGiven() {
    Location newLoc = new Location(mockJS.getRootDir(), null, null);
    String[] strArg = {};
    Ls testLs = new Ls(strArg, true, newLoc);
    assertEquals(testLsRecursiveString, testLs.execute());
  }
  @Test
  public void testLsAbsolutePathGivenNonRecursive() {
    Location newLoc = mockJS.getMockLocation();
    String[] strArg = {"/Dir_1"};
    Ls testLs = new Ls(strArg, false, newLoc);
    String compString =
        "Dir_1_1\n" + 
        "file_1_1\n" + 
        "Dir_1_2";
    assertEquals(compString,testLs.execute());
  }
  String testLsAbsolutePathGivenString = "Subdirectories of /:\n" + 
      "/:\n" + 
      "Dir_1\n" + 
      "Dir_2\n" + 
      "Dir_3\n" + 
      "Dir_4\n" + 
      "Dir_5\n" + 
      "\n" + 
      "/Dir_1:\n" + 
      "Dir_1_1\n" + 
      "file_1_1\n" + 
      "Dir_1_2\n" + 
      "\n" + 
      "/Dir_1/Dir_1_1:\n" + 
      "\n" + 
      "\n" + 
      "/Dir_1/file_1_1\n" + 
      "\n" + 
      "/Dir_1/Dir_1_2:\n" + 
      "\n" + 
      "\n" + 
      "/Dir_2:\n" + 
      "file_2_1\n" + 
      "\n" + 
      "/Dir_2/file_2_1\n" + 
      "\n" + 
      "/Dir_3:\n" + 
      "\n" + 
      "\n" + 
      "/Dir_4:\n" + 
      "\n" + 
      "\n" + 
      "/Dir_5:\n" + 
      "Dir_5_1\n" + 
      "file_5_1\n" + 
      "Dir_5_2\n" + 
      "Dir_1_2\n" + 
      "\n" + 
      "/Dir_5/Dir_5_1:\n" + 
      "\n" + 
      "\n" + 
      "/Dir_5/file_5_1\n" + 
      "\n" + 
      "/Dir_5/Dir_5_2:\n" + 
      "\n" + 
      "\n" + 
      "/Dir_5/Dir_1_2:\n";
  @Test
  public void testLsAbsolutePathGivenRecursive() {
    Location newLoc = mockJS.getMockLocation();
    String[] strArg = {"/"};
    Ls testLs = new Ls(strArg, true, newLoc);
    System.out.println(testLs.toString());
    assertEquals(testLsAbsolutePathGivenString,testLs.execute());
  }
  private String testLsAbsoluteString = "/Dir_1:\n" + 
      "Dir_1_1\n" + 
      "file_1_1\n" + 
      "Dir_1_2\n" + 
      "\n" + 
      "/Dir_2:\n" + 
      "file_2_1\n" + 
      "\n" + 
      "/Dir_3:\n";
  @Test
  public void testLsAbsolutePathGivenMultipleInputs() {
    Location newLoc = new Location(mockJS.getRootDir(), null, null);
    String[] strArg = {"/Dir_1","/Dir_2","/Dir_3"};
    Ls testLs = new Ls(strArg, false, newLoc);
    assertEquals(testLsAbsoluteString,testLs.execute());
  }
  private String testLsAbsolutePathGivenRecString = 
      "Subdirectories of /Dir_1:\n" + 
      "/Dir_1:\n" + 
      "Dir_1_1\n" + 
      "file_1_1\n" + 
      "Dir_1_2\n" + 
      "\n" + 
      "/Dir_1/Dir_1_1:\n" + 
      "\n" + 
      "\n" + 
      "/Dir_1/file_1_1\n" + 
      "\n" + 
      "/Dir_1/Dir_1_2:\n" + 
      "Subdirectories of /Dir_2:\n" + 
      "/Dir_2:\n" + 
      "file_2_1\n" + 
      "\n" + 
      "/Dir_2/file_2_1\n" + 
      "\n" + 
      "Subdirectories of /Dir_3:\n" + 
      "/Dir_3:\n";
  @Test
  public void testLsAbsolutePathGivenRecursiveGivenMultipleInputs() {
    Location newLoc = new Location(mockJS.getRootDir(), null, null);
    String[] strArg = {"/Dir_1","/Dir_2","/Dir_3"};
    Ls testLs = new Ls(strArg, true, newLoc);
    assertEquals(testLsAbsolutePathGivenRecString,testLs.execute());
  }
  @Test
  public void testLsGivenFile() {
    Location newLoc = new Location(mockJS.getRootDir(), null, null);
    String[] strArg = {"/Dir_1/file_1_1"};
    String compString = "/Dir_1/file_1_1\n";
    Ls testLs = new Ls(strArg, false, newLoc);
    assertEquals(compString, testLs.execute());
  }
  private String testLsGivenFileAndDirString = "/Dir_1/file_1_1\n" + 
      "\n" + 
      "/Dir_1:\n" + 
      "Dir_1_1\n" + 
      "file_1_1\n" + 
      "Dir_1_2";
  @Test
  public void testLsGivenFileAndDir() {
    Location newLoc = new Location(mockJS.getRootDir(), null, null);
    String[] strArg = {"/Dir_1/file_1_1", "/Dir_1"};
    Ls testLs = new Ls(strArg, false, newLoc);
    assertEquals(testLsGivenFileAndDirString, testLs.execute());
  }
  @Test
  public void testLsInvalidPath() {
    final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    Location newLoc = new Location(mockJS.getRootDir(), null, null);
    String[] strArg = {"/dir_non_existent"};
    String compString = "/dir_non_existent: No such file or directory\n";
    Ls testLs = new Ls(strArg, false, newLoc);
    testLs.execute();
    assertEquals(compString, outContent.toString());
  }
}
