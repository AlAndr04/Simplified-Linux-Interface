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
import dirCommands.Mkdir;
import fileSystemObjects.*;

public class MkdirTest {
  private Mkdir mkdir;
  private MockJShell JShell;

  @Before
  public void setUp() {
    JShell = new MockJShell();
  }

  @Test
  /**
   * Test mkdir with 1 directory as path.
   */
  public void testMakeOneDir() {
    String[] array = {"/Dir6"};
    mkdir = new Mkdir(array, JShell.getMockLocation());
    mkdir.execute();
    String output = JShell.getRootDir().getChildDir().get(5).getName();
    assertEquals("Dir6", output);
  }

  @Test
  /**
   * Test mkdir with multiple directories as path.
   */
  public void testMakeOneDirPath() {
    String[] array = {"/Dir_1/Dir6"};
    mkdir = new Mkdir(array, JShell.getMockLocation());
    mkdir.execute();
    String output = ((Directory) JShell.getRootDir().getChildDir().get(0))
        .getChildDir().get(3).getName();
    assertEquals("Dir6", output);
  }

  @Test
  /**
   * Test mkdir with wrong path.
   */
  public void testMakeDirWrongPath() {
    String[] array = {"/Jeff/Dir6"};
    final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    mkdir = new Mkdir(array, JShell.getMockLocation());
    mkdir.execute();
    String actualOutput = "Directory given is invalid, note : Directory name"
        + " convention: the only valid characters are from\n"
        + "lowercase a to z and upper case A to Z and numbers 0 to 9.\n"
        + "Anything other than these characters are considered invalid!"
        + System.lineSeparator();
    assertEquals(actualOutput, outContent.toString());
  }

  @Test
  /**
   * Test mkdir with wrong name.
   */
  public void testMakeDirWrongName() {
    String[] array = {"/Dir_6"};
    final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    mkdir = new Mkdir(array, JShell.getMockLocation());
    mkdir.execute();
    String actualOutput = "Directory given is invalid, note : Directory name"
        + " convention: the only valid characters are from\n"
        + "lowercase a to z and upper case A to Z and numbers 0 to 9.\n"
        + "Anything other than these characters are considered invalid!"
        + System.lineSeparator();
    assertEquals(actualOutput, outContent.toString());
  }

  @Test
  /**
   * Test mkdir with mutiple paths.
   */
  public void testMakeDirMutiplePaths() {
    String[] array = {"/Dir7", "/Dir_1/Dir6"};
    mkdir = new Mkdir(array, JShell.getMockLocation());
    mkdir.execute();
    String output = ((Directory) JShell.getRootDir().getChildDir().get(0))
        .getChildDir().get(3).getName() + " "
        + JShell.getRootDir().getChildDir().get(5).getName();
    assertEquals("Dir6 Dir7", output);
  }

  @Test
  /**
   * Test mkdir with mutiple paths, and one of them is wrong.
   */
  public void testMakeDirMutiplePathsOneWrong() {
    String[] array = {"/Dir7", "/Jeff/Dir6"};
    final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    mkdir = new Mkdir(array, JShell.getMockLocation());
    mkdir.execute();
    String output =
        ((Directory) JShell.getRootDir().getChildDir().get(5)).getName();
    String Actualoutput = "Dir7Directory given is invalid, note : Directory"
        + " name convention: the only valid characters are from\n"
        + "lowercase a to z and upper case A to Z and numbers 0 to 9.\n"
        + "Anything other than these characters are considered invalid!"
        + System.lineSeparator();
    assertEquals(Actualoutput, output + outContent.toString());
  }

  @Test
  /**
   * Test mkdir with mutiple paths, and one of them is wrong.
   */
  public void testMakeTwoDirsSameName() {
    String[] array = {"/Dir7", "/Dir7"};
    final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    mkdir = new Mkdir(array, JShell.getMockLocation());
    mkdir.execute();
    String Actualoutput =
        "Dir7 : A file or directory in this directory already has the same "
            + "name.\nPlease create a new file or directory with a different name"
            + System.lineSeparator();
    assertEquals(Actualoutput, outContent.toString());
  }
}
