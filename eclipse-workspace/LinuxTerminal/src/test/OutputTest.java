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
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import input.Output;

/**
 * Testing class for Output
 * 
 * @author babubala
 *
 */
public class OutputTest {

  // set up separate streams for print testing
  /**
   * New output STREAM as to gather data from it to compare what's been printed
   */
  private ByteArrayOutputStream output = new ByteArrayOutputStream();
  /**
   * PrimaryOutput restores output stream to original
   */
  private PrintStream primaryOutput = System.out;

  /**
   * SetUp instance variables before every test method.
   * 
   * @param None
   * @return Void
   */
  @Before
  public void setUp() {
    System.setOut(new PrintStream(output));
  }

  /**
   * Restores output stream to original
   * 
   * @param None
   * @return Void
   */
  @After
  public void restore() {
    System.setOut(primaryOutput);
  }

  /**
   * Testing method for Output, tests if message for method nameNotValid is
   * printed properly
   * 
   * @param None
   * @return Void
   */
  @Test
  public void testNameNotValid() {
    Output.nameNotValid("name");
    assertEquals("name" + " : A file or directory in this directory already "
        + "has the same name.\n"
        + "Please create a new file or directory" + " with a different name"
        + System.lineSeparator(), output.toString());
  }

  /**
   * Tests if method commandInvalid outputs correct message
   * 
   * @param None
   * @return Void
   */
  @Test
  public void testCommandInvalid() {
    Output.commandInvalid();
    assertEquals("Command invalid please refer to the manual via man CMD"
        + System.lineSeparator(), output.toString());
  }

  /**
   * Tests if method pathDoesNotExistError outputs correct message
   * 
   * @param None
   * @return Void
   */
  @Test
  public void testPathDoesNotExistError() {
    Output.pathDoesNotExistError("pathname");
    assertEquals(
        "pathname" + ": No such file or directory" + System.lineSeparator(),
        output.toString());
  }

  /**
   * Tests if method commandNotFoundError outputs corrext message
   * 
   * @param None
   * @return Void
   */
  @Test
  public void testCommandNotFoundError() {
    Output.commandNotFoundError("command");
    assertEquals("command" + ": command not found" + System.lineSeparator(),
        output.toString());
  }

  /**
   * Tests if method directoryInvalid outputs correct message
   * 
   * @param None
   * @return Void
   */
  @Test
  public void testDirectoryInvalid() {
    Output.directoryFileNameInvalid();
    assertEquals(
        "Directory/File given is invalid, note : Directory/File name convention: the only valid characters are from\n"
            + "lowercase a to z and upper case A to Z and numbers 0 to 9.\n"
            + "Anything other than these characters are considered invalid!"
            + System.lineSeparator(),
        output.toString());
  }

  /**
   * Tests if method spacePresentInName outputs correct message
   */
  @Test
  public void testSpacePresentInName() {
    Output.spacePresentInName();
    assertEquals("File and Directory names should not contain a space!"
        + System.lineSeparator(), output.toString());
  }

  /**
   * Tests if method invalidInput outputs correct message
   * 
   * @param None
   * @return Void
   */
  @Test
  public void testInvalidInput() {
    Output.invalidInput();
    assertEquals("Input invalid please refer to details via man CMD"
        + System.lineSeparator(), output.toString());
  }

  /**
   * Tests if method mustBeIntegers outputs correct message
   * 
   * @param none
   * @return void
   */
  @Test
  public void testMustBeIntegers() {
    Output.mustBeIntegers();
    assertEquals("The input given for this command must be integer"
        + System.lineSeparator(), output.toString());
  }

  /**
   * Tests if method pathIncorrect outputs correct message
   * 
   * @param none
   * @return void
   */
  @Test
  public void testPathIncorrect() {
    Output.pathIncorrect("srcname");
    assertEquals(
        "srcname" + ": No such file or directory." + System.lineSeparator(),
        output.toString());
  }

  /**
   * Tests if method printTextToShell outputs correct message
   * 
   * @param None
   * @return void
   */
  @Test
  public void testPrintTextToShell() {
    Output.printTextToShell("Text printed to Shell");
    assertEquals("Text printed to Shell" + System.lineSeparator(),
        output.toString());
  }

  /**
   * Tests if method noFilesFound outputs correct message
   * 
   * @param None
   * @return Void
   */
  @Test
  public void testNoFilesFound() {
    Output.NoFilesFound();
    assertEquals("No files found." + System.lineSeparator(), output.toString());
  }

  /**
   * Tests if method notDirectory outputs the correct message
   * 
   * @param None
   * @return Void
   */
  @Test
  public void testNotDirectory() {
    Output.NotDirectory("name");
    assertEquals("name" + ": not a directory." + System.lineSeparator(),
        output.toString());
  }

  /**
   * Tests if method noMoveInDirectory outputs correct message
   * 
   * @param None
   * @return Void
   */
  @Test
  public void testNoMoveInDirectory() {
    Output.NoMoveInDirectory();
    assertEquals("Cannot make a parent directory a child of subdirectory"
        + System.lineSeparator(), output.toString());
  }
  /**
   * Tests if method redirectionInvalid outputs correct message
   * 
   * @param None
   * @return Void
   */
  @Test
  public void testRedirectionInvalid() {
    Output.redirectionInvalid();
    assertEquals("Cannot redirect absence of output."
        + System.lineSeparator(), output.toString());
  }
  /**
   * Tests if method  emptyStack outputs correct message
   * 
   * @param None
   * @return Void
   */
  @Test
  public void testEmptyStack() {
    Output.emptyStack();
    assertEquals("The stack is empty"
        + System.lineSeparator(), output.toString());
  }
}
