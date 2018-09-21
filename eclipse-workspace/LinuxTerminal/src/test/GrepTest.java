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
import fileSystemObjects.*;
import org.junit.Before;
import org.junit.Test;
import dirCommands.*;


public class GrepTest {

  public Grep grepTest;
  public MockJShell JShell;

  @Before
  public void setUp() {
    JShell = new MockJShell();
  }

  @Test
  /**
   * Tests grep with only one file and no -R.
   * 
   * @param none
   * @return none
   */
  public void testOneFile() {
    File file = (File) ((Directory) JShell.getRootDir().getChildDir().get(0))
        .getChildDir().get(1);
    file.addToContent("a");
    String[] array = {"a", "/Dir_1/" + file.getName()};
    grepTest = new Grep(array, false, JShell.getMockLocation());
    String output = grepTest.execute();
    String actualOutput = "/Dir_1/file_1_1:\na";
    assertEquals(actualOutput, output);
  }

  @Test
  /**
   * Tests grep with only one file, but no content and no -R.
   * 
   * @param none
   * @return none
   */
  public void testOneFileNoContent() {
    final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    File file = (File) ((Directory) JShell.getRootDir().getChildDir().get(0))
        .getChildDir().get(1);
    String[] array = {"a", "/Dir_1/" + file.getName()};
    grepTest = new Grep(array, false, JShell.getMockLocation());
    grepTest.execute();
    String actualOutput = "No files found." + System.lineSeparator();
    assertEquals(actualOutput, outContent.toString());
  }

  @Test
  /**
   * Tests grep with only one file, but wrong content and no -R.
   * 
   * @param none
   * @return none
   */
  public void testOneFileWrongContent() {
    final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    File file = (File) ((Directory) JShell.getRootDir().getChildDir().get(0))
        .getChildDir().get(1);
    file.addToContent("b");
    String[] array = {"a", "/Dir_1/" + file.getName()};
    grepTest = new Grep(array, false, JShell.getMockLocation());
    grepTest.execute();
    String actualOutput = "No files found." + System.lineSeparator();
    assertEquals(actualOutput, outContent.toString());
  }

  @Test
  /**
   * Tests grep with only one file, but one correct line and no -R.
   * 
   * @param none
   * @return none
   */
  public void testOneFileMultipleLinesOneRight() {
    File file = (File) ((Directory) JShell.getRootDir().getChildDir().get(0))
        .getChildDir().get(1);
    file.addToContent("b\n");
    file.addToContent("abc");
    String[] array = {"a", "/Dir_1/" + file.getName()};
    grepTest = new Grep(array, false, JShell.getMockLocation());
    String output = grepTest.execute();
    String actualOutput = "/Dir_1/file_1_1:\nabc";
    assertEquals(actualOutput, output);
  }

  @Test
  /**
   * Tests grep with only one file, but multiple correct lines and no -R.
   * 
   * @param none
   * @return none
   */
  public void testOneFileMultipleLinesMultipleRight() {
    File file = (File) ((Directory) JShell.getRootDir().getChildDir().get(0))
        .getChildDir().get(1);
    file.addToContent("a\n");
    file.addToContent("Jeff\n");
    file.addToContent("abc\n");
    String[] array = {"a", "/Dir_1/" + file.getName()};
    grepTest = new Grep(array, false, JShell.getMockLocation());
    String output = grepTest.execute();
    String actualOutput = "/Dir_1/file_1_1:\na\nabc";
    assertEquals(actualOutput, output);
  }

  @Test
  /**
   * Tests grep with one file, one directory and no -R.
   * 
   * @param none
   * @return none
   */
  public void testOneCorrectFileOneDirectory() {
    File file = (File) ((Directory) JShell.getRootDir().getChildDir().get(0))
        .getChildDir().get(1);
    file.addToContent("a\n");
    String[] array = {"a", "/Dir_1/" + file.getName(), "/Dir_1"};
    grepTest = new Grep(array, false, JShell.getMockLocation());
    String output = grepTest.execute();
    String actualOutput = "/Dir_1/file_1_1:\na";
    assertEquals(actualOutput, output);
  }

  @Test
  /**
   * Tests grep with one correct file, one wrong file and no -R.
   * 
   * @param none
   * @return none
   */
  public void testOneCorrectFileOneWrongFile() {
    File file = (File) ((Directory) JShell.getRootDir().getChildDir().get(0))
        .getChildDir().get(1);
    File file2 = (File) ((Directory) JShell.getRootDir().getChildDir().get(1))
        .getChildDir().get(0);
    file.addToContent("b\n");
    file2.addToContent("a\n");
    String[] array = {"a", "/Dir_1/file_1_1", "/Dir_2/file_2_1"};
    grepTest = new Grep(array, false, JShell.getMockLocation());
    String output = grepTest.execute();
    String actualOutput = "/Dir_2/file_2_1:\na";
    assertEquals(actualOutput, output);
  }

  @Test
  /**
   * Tests grep with two correct files and no -R.
   * 
   * @param none
   * @return none
   */
  public void testTwoCorrectFiles() {
    File file = (File) ((Directory) JShell.getRootDir().getChildDir().get(0))
        .getChildDir().get(1);
    File file2 = (File) ((Directory) JShell.getRootDir().getChildDir().get(1))
        .getChildDir().get(0);
    file.addToContent("a\n");
    file2.addToContent("a\n");
    String[] array = {"a", "/Dir_1/file_1_1", "/Dir_2/file_2_1"};
    grepTest = new Grep(array, false, JShell.getMockLocation());
    String output = grepTest.execute();
    String actualOutput = "/Dir_1/file_1_1:\na\n\n/Dir_2/file_2_1:\na";
    assertEquals(actualOutput, output);
  }

  @Test
  /**
   * Tests grep with wrong path and no -R.
   * 
   * @param none
   * @return none
   */
  public void testWrongPath() {
    final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    String[] array = {"a", "/Jeff"};
    grepTest = new Grep(array, false, JShell.getMockLocation());
    grepTest.execute();
    String actualOutput = "/Jeff: No such file or directory."
        + System.lineSeparator() + "No files found." + System.lineSeparator();
    assertEquals(actualOutput, outContent.toString());
  }

  @Test
  /**
   * Tests grep with wrong path and correct path and no -R.
   * 
   * @param none
   * @return none
   */
  public void testWrongPathCorrectPath() {
    final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    File file = (File) ((Directory) JShell.getRootDir().getChildDir().get(0))
        .getChildDir().get(1);
    file.addToContent("a\n");
    String[] array = {"a", "/Dir_1/" + file.getName(), "/Jeff"};
    grepTest = new Grep(array, false, JShell.getMockLocation());
    String output = grepTest.execute();
    String actualOutput = "/Dir_1/file_1_1:\na/Jeff: No such file or"
        + " directory." + System.lineSeparator();
    assertEquals(actualOutput, output + outContent.toString());
  }

  @Test
  /**
   * Tests grep with a directory and -R present.
   * 
   * @param none
   * @return none
   */
  public void testSubDir() {
    File file = (File) ((Directory) JShell.getRootDir().getChildDir().get(0))
        .getChildDir().get(1);
    file.addToContent("a\n");
    String[] array = {"a", "/Dir_1"};
    grepTest = new Grep(array, true, JShell.getMockLocation());
    String output = grepTest.execute();
    String actualOutput = "/Dir_1/file_1_1:\na";
    assertEquals(actualOutput, output);
  }

  @Test
  /**
   * Tests grep with two subdirectories of one another and -R present.
   * 
   * @param none
   * @return none
   */
  public void testTwoSubdirsOfOneAnother() {
    File file = (File) ((Directory) JShell.getRootDir().getChildDir().get(0))
        .getChildDir().get(1);
    file.addToContent("a\n");
    String[] array = {"a", "/Dir_1", "/"};
    grepTest = new Grep(array, true, JShell.getMockLocation());
    String output = grepTest.execute();
    String actualOutput = "/Dir_1/file_1_1:\na";
    assertEquals(actualOutput, output);
  }

  @Test
  /**
   * Tests grep with two directories and -R present.
   * 
   * @param none
   * @return none
   */
  public void testTwoSubdirs() {
    File file = (File) ((Directory) JShell.getRootDir().getChildDir().get(0))
        .getChildDir().get(1);
    File file2 = (File) ((Directory) JShell.getRootDir().getChildDir().get(1))
        .getChildDir().get(0);
    file.addToContent("a\n");
    file2.addToContent("a\n");
    String[] array = {"a", "/Dir_1", "/Dir_2"};
    grepTest = new Grep(array, true, JShell.getMockLocation());
    String output = grepTest.execute();
    String actualOutput = "/Dir_1/file_1_1:\na\n\n/Dir_2/file_2_1:\na";
    assertEquals(actualOutput, output);
  }

  @Test
  /**
   * Tests grep with one directory and one file and -R present.
   * 
   * @param none
   * @return none
   */
  public void testOneSubdirOneFile() {
    File file = (File) ((Directory) JShell.getRootDir().getChildDir().get(0))
        .getChildDir().get(1);
    File file2 = (File) ((Directory) JShell.getRootDir().getChildDir().get(1))
        .getChildDir().get(0);
    file.addToContent("a\n");
    file2.addToContent("a\n");
    String[] array = {"a", "/Dir_1", "/Dir_2/file_2_1"};
    grepTest = new Grep(array, true, JShell.getMockLocation());
    String output = grepTest.execute();
    String actualOutput = "/Dir_1/file_1_1:\na\n\n/Dir_2/file_2_1:\na";
    assertEquals(actualOutput, output);
  }

  @Test
  /**
   * Tests grep with one directory and one directory with no files and -R
   * present.
   * 
   * @param none
   * @return none
   */
  public void testOneCorrectSubDirOneWrong() {
    final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    File file = (File) ((Directory) JShell.getRootDir().getChildDir().get(0))
        .getChildDir().get(1);
    file.addToContent("a\n");
    String[] array = {"a", "/Dir_1", "/Dir_2"};
    grepTest = new Grep(array, true, JShell.getMockLocation());
    String output = grepTest.execute();
    String actualOutput = "/Dir_1/file_1_1:\na";
    assertEquals(actualOutput, output + outContent.toString());
  }
}
