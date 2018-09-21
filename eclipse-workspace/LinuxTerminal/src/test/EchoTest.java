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
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import fileCommands.Echo;
import input.PathIncorrectException;

public class EchoTest {
  private MockJShell mockJS;
  private ByteArrayOutputStream output = new ByteArrayOutputStream();
  private PrintStream primaryOutput = System.out;


  @Before
  public void setUp() throws Exception {
    System.setOut(new PrintStream(output));
    mockJS = new MockJShell();
  }

  @After
  public void restore() {
    System.setOut(primaryOutput);
  }

  @Test
  public void testEchoPrint() {
    String[] test = {"Hey there this is my test file"};
    Echo pop = new Echo(test, mockJS.getMockLocation());
    pop.execute();
    assertEquals("Hey there this is my test file\n", output.toString());
  }

  @Test
  public void testEchoAbsolute() {
    //
    String[][] test =
        {{"Hey there this is my test file", "  > /Dir_4/myfile.txt"},
            {"Root not given yet file created", "  > Dir_3/myfile2.txt"}};
    //
    String[][] test1 = new String[][] {{"/", "Dir_4", "myfile.txt"},
        {"/", "Dir_3", "myfile2.txt"}};
    //
    String[] actualfilename = {"myfile.txt", "myfile2.txt"};
    String[] actualfilecontent =
        {"Hey there this is my test file", "Root not given yet file created"};
    for (int i = 0; i < 2; i++) {
      Echo pop = new Echo(test[i], mockJS.getMockLocation());
      pop.execute();
      String[] output;
      try {
        output = Echo.testHelper(test1[i], mockJS.getRootDir());
        assertEquals(output[0], actualfilename[i]);
        assertEquals(output[1], actualfilecontent[i]);
      } catch (PathIncorrectException e) {
        fail();
      }

    }
  }

  @Test
  public void testEchoRelativeWithAppend() {
    String[][] test = {{"Hey there this is my test file", " > rootfile.txt"},
        {"Now add this line to the previous file", " >> rootfile.txt"}};
    //
    String[][] test1 =
        new String[][] {{"/", "rootfile.txt"}, {"/", "rootfile.txt"}};
    //
    String[] actualfilename = {"rootfile.txt", "rootfile.txt"};
    String[] actualfilecontent =
        {"Hey there this is my test file", "Hey there this is my test file\n"
            + "Now add this line to the previous file"};


    for (int i = 0; i < 2; i++) {
      Echo pop = new Echo(test[i], mockJS.getMockLocation());
      pop.execute();
      String[] output;
      try {
        output = Echo.testHelper(test1[i], mockJS.getRootDir());
        assertEquals(output[0], actualfilename[i]);
        assertEquals(output[1], actualfilecontent[i]);
      } catch (PathIncorrectException e) {
        fail();
      }
    }
  }

  @Test(expected = java.lang.NullPointerException.class)
  public void testEchoErrors() throws PathIncorrectException {
    String[] test = {"No file Found", "  >> /Dir_7/errorfile.txt"};
    Echo pop = new Echo(test, mockJS.getMockLocation());
    String[] filepath = {"/", "Dir_7", "errorfile.txt"};
    pop.execute();
    String[] output = Echo.testHelper(filepath, mockJS.getRootDir());
  }


}


