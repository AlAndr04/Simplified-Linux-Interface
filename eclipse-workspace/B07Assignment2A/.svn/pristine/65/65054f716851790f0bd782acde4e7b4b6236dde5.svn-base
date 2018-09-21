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
import java.util.ArrayList;
import dirCommands.Mv;
import fileSystemObjects.*;
import fileSystemObjects.File;

public class MoveTest {
  private Mv mv;
  private MockJShell JShell;

  @Before
  public void setUp() {
    JShell = new MockJShell();
  }

  public String printArrayList(ArrayList<FSElement> children) {
    String output = "";
    for (FSElement child : children) {
      output += child.getName();
    }
    return output;
  }

  @Test
  /**
   * Test move with a simple move of 1 directory.
   */
  public void testMoveOneDir() {
    String[] array = {"/Dir_4", "/Dir_1"};
    mv = new Mv(array, JShell.getMockLocation());
    mv.execute();
    String output = ((Directory) (JShell.getRootDir().getChildDir().get(0)))
        .getChildDir().get(3).getName();
    // Adds the children of the root from which Dir_4 is removed, to see that
    // it is not there.
    output += printArrayList(JShell.getRootDir().getChildDir());
    assertEquals("Dir_4Dir_1Dir_2Dir_3Dir_5", output);
  }

  @Test
  /**
   * Test move with a simple move of 1 file.
   */
  public void testMoveOneFile() {
    String[] array = {"/Dir_5/file_5_1", "/Dir_1"};
    mv = new Mv(array, JShell.getMockLocation());
    mv.execute();
    String output = ((Directory) (JShell.getRootDir().getChildDir().get(0)))
        .getChildDir().get(3).getName();
    output += printArrayList(
        ((Directory) JShell.getRootDir().getChildDir().get(4)).getChildDir());
    assertEquals("file_5_1Dir_5_1Dir_5_2Dir_1_2", output);
  }

  @Test
  /**
   * Test move with moving of 1 directory with subdirectories.
   */
  public void testMoveOneDirectoryWithContent() {
    String[] array = {"/Dir_1", "/Dir_5"};
    mv = new Mv(array, JShell.getMockLocation());
    mv.execute();
    Directory newDir =
        (Directory) ((Directory) (JShell.getRootDir().getChildDir().get(3)))
            .getChildDir().get(4);
    // Checks that the contents of Dir_1 are also there and checks that
    // Dir_1 was removed from the root directory.
    String output = newDir.getName();
    output += printArrayList(newDir.getChildDir());
    output += " " + printArrayList(JShell.getRootDir().getChildDir());
    assertEquals("Dir_1Dir_1_1file_1_1Dir_1_2 Dir_2Dir_3Dir_4Dir_5", output);
  }

  @Test
  /**
   * Test move with moving of 1 file with content.
   */
  public void testMoveFileWithContent() {
    String[] array = {"/Dir_1/file_1_1", "/Dir_5"};
    File file = (File) ((Directory) (JShell.getRootDir().getChildDir().get(0)))
        .getChildDir().get(1);
    file.addToContent("Jeff");
    mv = new Mv(array, JShell.getMockLocation());
    mv.execute();
    Directory newDir = (Directory) (JShell.getRootDir().getChildDir().get(0));
    // Checks that the contents of Dir_1 are also there and checks that
    // Dir_1 was removed from the root directory.
    String output = printArrayList(newDir.getChildDir());
    newDir = (Directory) (JShell.getRootDir().getChildDir().get(4));
    output += " " + printArrayList(newDir.getChildDir());
    output += " " + ((File) newDir.getChildDir().get(4)).getContent();
    String actualOutput =
        "Dir_1_1Dir_1_2 Dir_5_1file_5_1Dir_5_2Dir_1_2file_1_1" + "" + " Jeff";
    assertEquals(actualOutput, output);
  }

  @Test
  /**
   * Test move with moving of 1 directory into a file.
   */
  public void testMoveInFile() {
    final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    String[] array = {"/Dir_5", "/Dir_1/file_1_1"};
    mv = new Mv(array, JShell.getMockLocation());
    mv.execute();
    String actualOutput =
        "Directory/File given is invalid, note : Directory/File name convention"
        + ": the only valid characters are from\n"
            + "lowercase a to z and upper case A to Z and numbers 0 to 9.\n"
            + "Anything other than these characters are considered invalid!"
            + System.lineSeparator();
    assertEquals(actualOutput, outContent.toString());
  }

  @Test
  /**
   * Test move with moving of 1 directory into its child.
   */
  public void testMoveInSubDir() {
    final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    String[] array = {"/Dir_1", "/Dir_1/Dir_1_1"};
    mv = new Mv(array, JShell.getMockLocation());
    mv.execute();
    String actualOutput =
        "Cannot make a parent directory a child of subdirectory"
            + System.lineSeparator();
    assertEquals(actualOutput, outContent.toString());
  }
}
