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
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import dirCommands.Traverse;
import input.PathIncorrectException;
import fileSystemObjects.*;

public class TraverseTest {
  private MockJShell mockJS;

  @Before
  public void setUp() {
    mockJS = new MockJShell();
  }

  @Test
  public void testReturnRoot() {
    mockJS.moveCurrDirOneLevelOne();
    assertEquals(mockJS.getRootDir(),
        Traverse.returnRoot(mockJS.getMockLocation().getCurrDir()));
  }

  @Test
  public void testReturnGivenPathFromRootFile() throws PathIncorrectException {
    mockJS.moveCurrDirOneLevelOne();
    String[] newPath = {"/", "Dir_1"};
    assertEquals(mockJS.getMockLocation().getCurrDir(),
        Traverse.returnGivenPathFromRoot(newPath, mockJS.getRootDir()));
  }

  @Test(expected = PathIncorrectException.class)
  public void testReturnGivenPathFromRootFileIncorrect()
      throws PathIncorrectException {
    mockJS.moveCurrDirOneLevelOne();
    String[] newPath = {"/", "Dir_Non_Existant"};
    Traverse.returnGivenPathFromRoot(newPath, mockJS.getRootDir());
  }

  @Test
  public void testreturnGivenPathFromRootFile() throws PathIncorrectException {
    mockJS.moveCurrDirOneLevelOne();
    String[] newPath = {"/", "Dir_1", "file_1_1"};
    assertEquals(mockJS.returnFileRef(),
        Traverse.returnGivenPathFromRootFile(newPath, mockJS.getRootDir()));
  }

  @Test
  public void testreturnGivenPathFromRootFileIncorrect()
      throws PathIncorrectException {
    String[] newPath = {"/", "Dir_1", "huh?"};
    assertEquals(null,
        Traverse.returnGivenPathFromRootFile(newPath, mockJS.getRootDir()));
  }

  @Test
  /**
   * Test findPathString with correct output.
   */
  public void testFindPathStringCorrect() {
    Directory result =
        Traverse.findPathString("/Dir_1/Dir_1_1", mockJS.getRootDir());
    Directory actualDir =
        (Directory) ((Directory) mockJS.getRootDir().getChildDir().get(0))
            .getChildDir().get(0);
    assertEquals(actualDir, result);
  }

  @Test
  /**
   * Test findPathString with incorrect output.
   */
  public void testFindPathStringIncorrect() {
    Directory result =
        Traverse.findPathString("/Dir_1/Jeff", mockJS.getRootDir());
    assertEquals(null, result);
  }

  @Test
  /**
   * Test findPathString with the path for a file.
   */
  public void testFindPathStringFile() {
    Directory result =
        Traverse.findPathString("/Dir_1/file_1_1", mockJS.getRootDir());
    assertEquals(null, result);
  }

  @Test
  /**
   * Test findName with the path for a file.
   */
  public void testFindNameCorrect() {
    String result = Traverse.findName(mockJS.getRootDir(), "d", "Dir_1");
    assertEquals("/Dir_1\n", result);
  }

  @Test
  /**
   * Test findName with the path for a file.
   */
  public void testFindNameFile() {
    String result = Traverse.findName(mockJS.getRootDir(), "f", "file_1_1");
    assertEquals("/Dir_1/file_1_1\n", result);
  }

  @Test
  /**
   * Test findName with the invalid path for a file.
   */
  public void testFindNameInvalid() {
    String result = Traverse.findName(mockJS.getRootDir(), "f", "Jeff");
    assertEquals("", result);
  }

  @Test
  /**
   * Test accessFS with the valid path for a directory.
   */
  public void testAccessFSvalid() {
    Directory result =
        (Directory) Traverse.accessFS("/Dir_1/Dir_1_1", mockJS.getRootDir());
    Directory actualDir =
        (Directory) ((Directory) mockJS.getRootDir().getChildDir().get(0))
            .getChildDir().get(0);
    assertEquals(actualDir, result);
  }

  @Test
  /**
   * Test accessFS with a valid path for a file.
   */
  public void testAccessFSFile() {
    File result =
        (File) Traverse.accessFS("/Dir_1/file_1_1", mockJS.getRootDir());
    File actualDir =
        (File) ((Directory) mockJS.getRootDir().getChildDir().get(0))
            .getChildDir().get(1);
    assertEquals(actualDir, result);
  }

  @Test
  /**
   * Test accessFS with the invalid path for a file.
   */
  public void testAccessFSInvalid() {
    File result = (File) Traverse.accessFS("/Dir_1/Jeff", mockJS.getRootDir());

    assertEquals(null, result);
  }

  @Test
  /**
   * Test getAllDirs with a valid directory.
   */
  public void testGetAllDirs() {
    ArrayList<FSElement> result = Traverse
        .getAllDirs((Directory) mockJS.getRootDir().getChildDir().get(1));
    ArrayList<FSElement> actualOutput = new ArrayList<FSElement>();
    File file = (File) ((Directory) mockJS.getRootDir().getChildDir().get(1))
        .getChildDir().get(0);
    actualOutput.add(file);
    assertEquals(actualOutput, result);
  }
  @Test
  /**
   * Test getAllDirs with an empty directory.
   */
  public void testGetAllDirsNoInput() {
    ArrayList<FSElement> result = Traverse
        .getAllDirs((Directory) mockJS.getRootDir().getChildDir().get(2));
    ArrayList<FSElement> actualOutput = new ArrayList<FSElement>();
    assertEquals(actualOutput, result);
  }
}
