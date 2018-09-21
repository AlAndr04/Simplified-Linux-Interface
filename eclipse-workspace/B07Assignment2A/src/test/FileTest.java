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
import fileSystemObjects.File;

public class FileTest {
  private MockJShell mockJS;

  @Before
  public void setUp() throws Exception {
    mockJS = new MockJShell();
  }

  @Test
  public void testAddToContent() {
    File newFile = new File("file", mockJS.getRootDir());
    newFile.addToContent("testing");
    assertEquals("testing", newFile.getContent());
  }

  @Test(expected = NullPointerException.class)
  public void testConstructorNullParent() {
    new File("file", null);
  }

  @Test
  public void testDeleteContent() {
    File newFile = new File("file", mockJS.getRootDir());
    newFile.addToContent("testing");
    newFile.delStrings();
    assertEquals("", newFile.getContent());
  }
}
