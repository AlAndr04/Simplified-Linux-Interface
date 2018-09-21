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
import org.junit.Before;
import org.junit.Test;
import dirCommands.Traverse;
import fileCommands.Mkfile;
import fileSystemObjects.File;
import input.InvalidNameException;
import input.PathIncorrectException;
import input.UniqueNameException;

public class MkfileTest {
  private MockJShell mockJS;

  @Before
  public void setUp() throws Exception {
    mockJS = new MockJShell();
  }

  @Test
  public void testmkFileWPathCorrectInput()
      throws PathIncorrectException, UniqueNameException, InvalidNameException {
    String[] newArr = {"/", "Dir_1"};
    String[] testNewArr = {"/", "Dir_1", "newFile"};
    Mkfile newMkfile = new Mkfile(newArr, mockJS.getMockLocation().getRoot());
    File newfile = newMkfile.mkFileWPath("newFile");
    assertEquals(Traverse.returnGivenPathFromRootFile(testNewArr,
        mockJS.getMockLocation().getRoot()), newfile);
  }

  @Test(expected = InvalidNameException.class)
  public void testmkFileWPathInvalidNameSpecialCharacters()
      throws PathIncorrectException, UniqueNameException, InvalidNameException {
    String[] newArr = {"/", "Dir_1"};
    Mkfile newMkfile = new Mkfile(newArr, mockJS.getMockLocation().getRoot());
    newMkfile.mkFileWPath("new_File");
  }

  @Test(expected = UniqueNameException.class)
  public void testmkFileWPathInvalidNameUnique()
      throws PathIncorrectException, UniqueNameException, InvalidNameException {
    String[] newArr = {"/"};
    Mkfile newMkfile = new Mkfile(newArr, mockJS.getMockLocation().getRoot());
    newMkfile.mkFileWPath("file");
    mockJS.makeFolderWithSameName();
  }

  @Test(expected = PathIncorrectException.class)
  public void testmkFileWIncorrectPath()
      throws PathIncorrectException, UniqueNameException, InvalidNameException {
    String[] newArr = {"/a/b"};
    Mkfile newMkfile = new Mkfile(newArr, mockJS.getMockLocation().getRoot());
    newMkfile.mkFileWPath("file");
  }
}
