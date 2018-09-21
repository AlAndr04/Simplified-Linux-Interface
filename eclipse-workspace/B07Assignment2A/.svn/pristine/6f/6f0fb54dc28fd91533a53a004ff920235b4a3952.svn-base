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
import org.junit.Before;
import org.junit.Test;
import fileCommands.*;



public class CatTest {
  private MockJShell mockJS;

  @Before
  public void setUp() throws Exception {
    mockJS = new MockJShell();
    mockJS.catFileEdit();
  }

  @Test
  public void testCatSingleFile() {
    String[] filename = {"/Dir_2/file_2_1"};
    Cat con = new Cat(filename, mockJS.getMockLocation());
    String content = con.execute();
    String expected = "This is my file 2_1";
    assertEquals(expected, content);
  }

  @Test
  public void testCatMultipleFile() {
    String[] filename = {"/Dir_2/file_2_1", "/Dir_5/file_5_1"};
    Cat con = new Cat(filename, mockJS.getMockLocation());
    String content = con.execute();
    String expected = "This is my file 2_1\n" + "\n" + "\n"
        + "This is my file 5_1\n" + "\n" + "\n" + "";
    assertEquals(expected, content);
  }


}
