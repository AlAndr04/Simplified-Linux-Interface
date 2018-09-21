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
import org.junit.Test;
import input.Parse;

public class ParseTest {

  @Test
  public void testParseNormal() {
    String test1 = "mkdir abhi";
    String test2 = "mkdir abhi /abhi/b07 /abhi/b07/A2";
    String test3 = "cd a";
    String[][] actOut1 = Parse.stringtoarray(test1);
    String[][] actOut2 = Parse.stringtoarray(test2);
    String[][] actOut3 = Parse.stringtoarray(test3);
    String exp1 = "[mkdir, abhi]";
    String exp2 = "[mkdir, abhi, /abhi/b07, /abhi/b07/A2]";
    String exp3 = "[cd, a]";
    assertEquals(exp1, Arrays.toString(actOut1[0]));
    assertEquals(exp2, Arrays.toString(actOut2[0]));
    assertEquals(exp3, Arrays.toString(actOut3[0]));
  }

  @Test
  public void testParseEcho() {
    String test1 = "echo \"This should work\" > pop.txt";
    String test2 = "echo \"This should work\"";
    String test3 = "echo \"This should work\" >> pop.txt ";
    String[][] actOut1 = Parse.stringtoarray(test1);
    String[][] actOut2 = Parse.stringtoarray(test2);
    String[][] actOut3 = Parse.stringtoarray(test3);
    String exp1 = "[echo, This should work,  > pop.txt]";
    String exp2 = "[echo, This should work]";
    String exp3 = "[echo, This should work,  >> pop.txt ]";
    assertEquals(exp1, Arrays.toString(actOut1[0]));
    assertEquals(exp2, Arrays.toString(actOut2[0]));
    assertEquals(exp3, Arrays.toString(actOut3[0]));
  }

  @Test
  public void testParseRecursive() {
    String test1 = "ls -R /abhi/b07";
    String test2 = "grep -R /abhi/b07";
    String[][] actOut1 = Parse.stringtoarray(test1);
    String[][] actOut2 = Parse.stringtoarray(test2);
    String exp1 = "[ls-R, /abhi/b07]";
    String exp2 = "[grep-R, /abhi/b07]";
    assertEquals(exp1, Arrays.toString(actOut1[0]));
    assertEquals(exp2, Arrays.toString(actOut2[0]));
  }

  @Test
  public void testParseRedirection() {
    String test1 = "ls > /abhi/b07/make.txt";
    String test2 = "pwd > file1.txt";
    String[][] actOut1 = Parse.stringtoarray(test1);
    String[][] actOut2 = Parse.stringtoarray(test2);
    String exp1 = "[ls]";
    String exp2 = "[pwd]";
    assertEquals(exp1, Arrays.toString(actOut1[0]));
    assertEquals(exp2, Arrays.toString(actOut2[0]));
  }

  @Test
  public void testParseHistory() {
    String test1 = "history 3";
    String test2 = "!3";
    String[][] actOut1 = Parse.stringtoarray(test1);
    String[][] actOut2 = Parse.stringtoarray(test2);
    String exp1 = "[history, 3]";
    String exp2 = "[histcommand, 3]";
    assertEquals(exp1, Arrays.toString(actOut1[0]));
    assertEquals(exp2, Arrays.toString(actOut2[0]));
  }

}


