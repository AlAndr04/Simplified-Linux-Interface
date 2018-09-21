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
import java.util.Arrays;
import org.junit.Before;
import org.junit.Test;
import dirCommands.Traverse;
import fileSystemObjects.Directory;
import fileSystemObjects.FSElement;
import input.PathIncorrectException;
import input.UniqueNameException;

public class DirectoryTest {
  private MockJShell mockJS;

  @Before
  public void setUp() throws Exception {
    mockJS = new MockJShell();
  }

  @Test
  public void testMakeDir() throws UniqueNameException, PathIncorrectException {
    Directory newDir = Directory.makeDir("newDirectory", mockJS.getRootDir());
    String[] newArr = {"/", "newDirectory"};
    assertEquals(Traverse.returnGivenPathFromRoot(newArr, mockJS.getRootDir()),
        newDir);
  }

  @Test(expected = UniqueNameException.class)
  public void testMakeDirUniqueName() throws UniqueNameException {
    Directory.makeDir("newDirectory", mockJS.getRootDir());
    Directory.makeDir("newDirectory", mockJS.getRootDir());
  }
}
