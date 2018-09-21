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
import fileSystemObjects.FSElement;
import input.InvalidNameException;

public class FSElementTest {
  private MockJShell mockJS;

  @Before
  public void setUp() throws Exception {
    mockJS = new MockJShell();
  }

  @Test
  public void testSetParent() {
    FSElement newDir = new FSElement("directory");
    newDir.setParent(mockJS.getRootDir());
    assertEquals(mockJS.getRootDir(), newDir.getParent());
  }

  @Test
  public void testRemoveFromParent() throws NullPointerException {
    FSElement newDir = new FSElement("directory");
    newDir.setParent(mockJS.getRootDir());
    ArrayList<FSElement> newArr = mockJS.getRootDir().getChildDir();
    newArr.remove(newDir);
    newDir.removeFromParentRef();
    assertEquals(newArr, mockJS.getRootDir().getChildDir());
  }

  @Test(expected = NullPointerException.class)
  public void testRemoveFromParentBadInput() throws NullPointerException {
    FSElement newDir = new FSElement("directory");
    newDir.removeFromParentRef();
  }

  @Test
  public void testEquals() {
    FSElement newFS = new FSElement("/");
    assertTrue(newFS.equals(mockJS.getRootDir()));
  }

  @Test
  public void testEqualsFalse() {
    FSElement newFS = new FSElement("Dog");
    assertFalse(newFS.equals(mockJS.getRootDir()));
  }
}
