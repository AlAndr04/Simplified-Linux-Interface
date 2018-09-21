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
// *********************************************************
package test;

import input.History;
import static org.junit.Assert.*;
import java.io.*;
import org.junit.Test;
import org.junit.Before;

public class HistoryTest {
  private History hist;
  private MockJShell JShell;

  @Before
  public void setUp() {
    JShell = new MockJShell();
  }

  @Test
  /**
   * Tests history with no input.
   */
  public void testHistNoInput() {
    hist = new History(JShell.getMockLocation());
    String output = hist.execute();
    String actualOutput = "1. apple.txt\n2. mkdir a\n3. pwd\n4. history";
    assertEquals(actualOutput, output);
  }

  @Test
  /**
   * Tests history for the last 2 elements.
   */
  public void testHistLastXElements() {
    hist = new History("2", JShell.getMockLocation());
    String output = hist.execute();
    String actualOutput = "3. pwd\n4. history";
    assertEquals(actualOutput, output);
  }

  @Test
  /**
   * Tests history for more elements than in array.
   */
  public void testHistTooManyElements() {
    final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    hist = new History("69", JShell.getMockLocation());
    hist.execute();
    String actualOutput = "Input invalid please refer to details via man CMD"
        + System.lineSeparator();
    assertEquals(actualOutput, outContent.toString());
  }

  @Test
  /**
   * Tests history for negative number.
   */
  public void testHistNegativeStart() {
    final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    hist = new History("-69", JShell.getMockLocation());
    hist.execute();
    String actualOutput = "Input invalid please refer to details via man CMD"
        + System.lineSeparator();
    assertEquals(actualOutput, outContent.toString());
  }

  @Test
  /**
   * Tests history when input is not an integer.
   */
  public void testHistNonInt() {
    final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));
    hist = new History("Apple.txt", JShell.getMockLocation());
    hist.execute();
    String actualOutput = "Input invalid please refer to details via man CMD"
        + System.lineSeparator();
    assertEquals(actualOutput, outContent.toString());
  }

}
