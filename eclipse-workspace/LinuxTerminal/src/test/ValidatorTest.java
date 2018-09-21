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
import org.junit.Test;
import input.Validator;

public class ValidatorTest {

  @Test
  public void testValidatorMkdir() {
    String test1 = "mkdir abhi /abhi/Doc /abhi/Doc/B07";
    String test2 = "mkdir /abhi/apple ";
    String test3 = "mkdir          /Abhi/Doc/";
    String[] test = {test1, test2, test3};
    for (int i = 0; i < 3; i++) {
      Validator testLink = new Validator(test[i], true);
      boolean flag = testLink.isvalid();
      assertEquals(flag, true);
    }
  }

  @Test
  public void testValidatorCd() {
    String test1 = "cd a";
    String test2 = "cd     /b/c/f";
    String test3 = "cd /Hello/";
    String[] test = {test1, test2, test3};
    for (int i = 0; i < 3; i++) {
      Validator testLink = new Validator(test[i], true);
      boolean flag = testLink.isvalid();
      assertEquals(flag, true);
    }
  }

  @Test
  public void testValidatorLs() {
    String test1 = "ls -R /abhi/cdcbo7";
    String[] test = {test1};
    for (int i = 0; i < 1; i++) {
      Validator testLink = new Validator(test[i], true);
      boolean flag = testLink.isvalid();
      assertEquals(flag, true);
    }

  }

  @Test
  public void testValidatorPwd() {
    String test1 = "pwd";
    String test2 = "pwd > /Abhi/fileName.txt";
    String[] test = {test1, test2};
    for (int i = 0; i < 2; i++) {
      Validator testLink = new Validator(test[i], true);
      boolean flag = testLink.isvalid();
      assertEquals(flag, true);
    }

  }

  @Test
  public void testValidatorMv() {
    String test1 = "mv a/b/apple.txt a/b/c";
    String test2 = "mv apple.txt a/b/b";
    String[] test = {test1, test2};
    for (int i = 0; i < 2; i++) {
      Validator testLink = new Validator(test[i], true);
      boolean flag = testLink.isvalid();
      assertEquals(flag, true);
    }

  }

  @Test
  public void testValidatorCp() {
    String test1 = "cp a/b/apple.txt a/b/c";
    String test2 = "cp apple.txt             a/b/b";
    String[] test = {test1, test2};
    for (int i = 0; i < 2; i++) {
      Validator testLink = new Validator(test[i], true);
      boolean flag = testLink.isvalid();
      assertEquals(flag, true);
    }

  }

  @Test
  public void testValidatorEchoAndcat() {
    String test1 = "cat apple.txt";
    String test2 = "cat      /Abhi/Document/apple.txt";
    String[] test = {test1, test2};
    for (int i = 0; i < 2; i++) {
      Validator testLink = new Validator(test[i], true);
      boolean flag = testLink.isvalid();
      assertEquals(flag, true);
    }

  }

  @Test
  public void testValidatorMan() {
    String test1 = "man \"echo\"";
    String[] test = {test1};
    for (int i = 0; i < 1; i++) {
      Validator testLink = new Validator(test[i], true);
      boolean flag = testLink.isvalid();
      assertEquals(flag, true);
    }
  }

  @Test
  public void testValidatorStack() {
    String test1 = "pushd /user/Abhi/Doc";
    String test2 = "popd";
    String[] test = {test1, test2};
    for (int i = 0; i < 2; i++) {
      Validator testLink = new Validator(test[i], true);
      boolean flag = testLink.isvalid();
      assertEquals(flag, true);
    }


  }

  @Test
  public void testValidatorHistory() {
    String test1 = "history 5";
    String[] test = {test1};
    for (int i = 0; i < 1; i++) {
      Validator testLink = new Validator(test[i], true);
      boolean flag = testLink.isvalid();
      assertEquals(flag, true);
    }

  }

  @Test
  public void testValidatorGrep() {
    String test1 = "grep -R /abhi/documents/b07";
    String[] test = {test1};
    for (int i = 0; i < 1; i++) {
      Validator testLink = new Validator(test[i], true);
      boolean flag = testLink.isvalid();
      assertEquals(flag, false);
    }

  }

  @Test
  public void testValidatorCurl() {
    String test1 = "curl http://www.cs.cmu.edu/~spok/grimmtmp/073.txt";
    String[] test = {test1};
    for (int i = 0; i < 1; i++) {
      Validator testLink = new Validator(test[i], true);
      boolean flag = testLink.isvalid();
      assertEquals(flag, true);

    }
  }


}
