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
import dirCommands.Tree;

public class TreeTest {
  private MockJShell mockJS;

  @Before
  public void setUp() throws Exception {
    mockJS = new MockJShell();
  }

  @Test
  public void testTree() {
    String compString = "/\n\tDir_1\n\t\tDir_1_1\n\t\tfile_1_1\n\t\tDir_1_2\n"
        + "\tDir_2\n\t\tfile_2_1\n\tDir_3\n\tDir_4\n\tDir_5\n\t\tDir_5_1\n\t\t"
        + "file_5_1" + "\n\t\tDir_5_2\n\t\tDir_1_2\n";
    Tree testTree = new Tree(mockJS.getMockLocation());
    assertEquals(compString, testTree.buildTree(mockJS.getRootDir(), 0));
  }

  @Test
  public void testExecute() {
    String compString = "/\n\tDir_1\n\t\tDir_1_1\n\t\tfile_1_1\n\t\tDir_1_2\n"
        + "\tDir_2\n\t\tfile_2_1\n\tDir_3\n\tDir_4\n\tDir_5\n\t\tDir_5_1\n\t\t"
        + "file_5_1" + "\n\t\tDir_5_2\n\t\tDir_1_2\n";
    Tree testTree = new Tree(mockJS.getMockLocation());
    assertEquals(compString, testTree.execute());
  }
}
