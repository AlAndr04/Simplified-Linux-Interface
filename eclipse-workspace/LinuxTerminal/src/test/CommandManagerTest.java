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
import dirCommands.Cp;
import org.junit.Before;
import java.util.ArrayList;
import input.CommandManager;
import fileSystemObjects.*;
import fileSystemObjects.File;

public class CommandManagerTest {
  private CommandManager com;
  private MockJShell JShell;

  @Before
  public void setUp() {
    JShell = new MockJShell();
  }

  @Test
  /**
   * Test command manager for an action command (does not print anything) with
   * an absolute path.
   */
  public void testCommandManagerMkdir() {
    com = new CommandManager("mkdir /Dir6", JShell.getMockLocation());
    // Adds the children of the root from which Dir_4 is removed, to see that
    // it is not there.
    String output = JShell.getMockLocation().getRoot().PrintChildDir();
    assertEquals("Dir_1,Dir_2,Dir_3,Dir_4,Dir_5,Dir6,", output);
  }

  @Test
  /**
   * Test command manager for an output command (prints to output).
   */
  public void testCommandManagerPwd() {
    final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    com = new CommandManager("pwd", JShell.getMockLocation());
    assertEquals("/" + System.lineSeparator(), outContent.toString());
  }

  @Test
  /**
   * Test command manager for an error command.
   */
  public void testCommandManagerError() {
    final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    com = new CommandManager("HundredPlz", JShell.getMockLocation());
    String output = "Command invalid please refer to the manual via man CMD"
        + System.lineSeparator();
    assertEquals(output, outContent.toString());
  }

  @Test
  /**
   * Test command manager for a command with the wrong number of variables. In
   * this case, mkdir is wrong because it requires 1 variable at least.
   */
  public void testCommandManagerIncorrect() {
    final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    com = new CommandManager("mkdir", JShell.getMockLocation());
    String output = "Command invalid please refer to the manual via man CMD"
        + System.lineSeparator();
    assertEquals(output, outContent.toString());
  }

  @Test
  /**
   * Test command manager for a command with a relative path, in this case it is
   * ls.
   */
  public void testCommandManagerRelative() {
    final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    com = new CommandManager("ls Dir_2", JShell.getMockLocation());
    String output = "file_2_1" + System.lineSeparator();
    assertEquals(output, outContent.toString());
  }

  @Test
  /**
   * Test command manager with redirection
   */
  public void testCommandManagerRedirection() {
    com = new CommandManager("ls Dir_2 > file", JShell.getMockLocation());
    File file = (File) JShell.getRootDir().getChildDir().get(5);
    String output = file.getName() + " " + file.getContent();
    assertEquals("file file_2_1", output);
  }

  @Test
  /**
   * Test command manager with appending output.
   */
  public void testCommandManagerAppending() {
    com = new CommandManager("echo \"a\" > file", JShell.getMockLocation());
    com = new CommandManager("ls Dir_2 >> file", JShell.getMockLocation());
    File file = (File) JShell.getRootDir().getChildDir().get(5);
    String output = file.getName() + " " + file.getContent();
    assertEquals("file a\nfile_2_1", output);
  }

  @Test
  /**
   * Test command manager with redirection of something that does not redirect.
   */
  public void testCommandManagerInvalidRedirection() {
    final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    com = new CommandManager("mkdir a >> file", JShell.getMockLocation());
    String actualOutput =
        "Cannot redirect absence of output." + System.lineSeparator();
    assertEquals(actualOutput, outContent.toString());
  }
}
