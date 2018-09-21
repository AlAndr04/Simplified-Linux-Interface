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
import dirCommands.Pwd;
import fileSystemObjects.FSElement;

public class PwdTest {
  private MockJShell mockJS;

  @Before
  public void setUp() throws Exception {
    mockJS = new MockJShell();
  }

  @Test
  public void testPwdreturnPathFromRootDirectory() {
    String pwdTestStr =
        Pwd.returnPathFromRoot((FSElement) mockJS.returnMoveDir());
    String compStr = "/Dir_1";
    assertEquals(compStr, pwdTestStr);
  }

  @Test
  public void testPwdreturnPathFromRootFile() {
    String pwdTestStr =
        Pwd.returnPathFromRoot((FSElement) mockJS.returnFileRef());
    String compStr = "/Dir_1/file_1_1";
    assertEquals(compStr, pwdTestStr);
  }

  @Test
  public void testPwd() {
    mockJS.moveCurrDirOneLevelOne();
    Pwd newPwd = new Pwd(mockJS.getMockLocation());
    String pwdTestStr = newPwd.execute();
    String compStr = "/Dir_1";
    assertEquals(compStr, pwdTestStr);
  }

  @Test
  public void testPwdRoot() {
    Pwd newPwd = new Pwd(mockJS.getMockLocation());
    String pwdTestStr = newPwd.execute();
    String compStr = "/";
    assertEquals(compStr, pwdTestStr);
  }
}
