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
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import org.junit.*;
import fileCommands.*;
import input.*;
import fileSystemObjects.*;

/**
 * Testing class for class Curl
 * 
 * @author babubala
 *
 */
public class CurlTest {
  /**
   * Main reference to test Curl, *will be used to invoke Curl constructor in
   * test methods
   */
  private Curl curlTester;
  /**
   * Mock file-system
   */
  private MockJShell fs;
  /**
   * New output STREAM as to gather data from it to compare what's been printed
   */
  private ByteArrayOutputStream output = new ByteArrayOutputStream();
  /**
   * PrimaryOutput restores output stream to original
   */
  private PrintStream primaryOutput = System.out;

  /**
   * SetUp method for testing, sets up mock file-system and additional output
   * stream
   * 
   * @param None
   * @return Void
   */
  @Before
  public void setUp() {
    System.setOut(new PrintStream(output));
    fs = new MockJShell();
  }

  /**
   * After testing methods this method is ran and it restores the output stream
   * to the original
   * 
   * @param None
   * @return Void
   */
  @After
  public void restore() {
    System.setOut(primaryOutput);
  }

  /**
   * Tests Curl with a valid urlPath
   * 
   * @param None
   * @return Void
   * @throws MalformedURLException
   * @throws URISyntaxException
   */
  @Test
  public void testGoodUmlExecute()
      throws MalformedURLException, URISyntaxException {
    // do the execute method for curl
    curlTester = new Curl("http://www.cs.cmu.edu/~spok/grimmtmp/073.txt",
        fs.getMockLocation());
    curlTester.execute();
    // get the current working directory
    Directory currDir = fs.getMockLocation().getCurrDir();
    // get contents of current working directory
    ArrayList<FSElement> files = currDir.getChildDir();
    // get last element of files LIST as it is the file that was just created,
    // so we
    // are going to extract it to do our comparison
    FSElement file = files.get(files.size() - 1);
    assertEquals(file.getName(), curlTester.getFileName());
  }

  /**
   * Tests Curl with an invalid UrlPath
   * 
   * @param None
   * @return Void
   * @throws MalformedURLException
   * @throws URISyntaxException
   */

  @Test
  public void testBadUmlExecute()
      throws MalformedURLException, URISyntaxException {
    // constructor for curl throws and catches exceptions for bad url
    // those exceptions print an error message and that is what im asserting
    // here.
    curlTester = new Curl("http", fs.getMockLocation());
    assertEquals("Command invalid please refer to the manual via man CMD\n",
        output.toString());
  }

}
