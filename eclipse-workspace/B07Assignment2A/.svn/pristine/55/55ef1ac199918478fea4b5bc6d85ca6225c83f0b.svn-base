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
package driver;

import input.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import dirCommands.Pwd;
import fileSystemObjects.*;

/**
 * JShell class runs the interface as well as parses and analyzes user input to
 * conduct commands accordingly
 */
public class JShell {
  /*  *//**
         * Intialized a Director type as a root for thr file sysytem
         */
  /*
   * public static Directory root = new Directory("/");
   *//**
      * Intialized a DirStack for popd and push d
      */
  /*
   * public static Stack<String> DirStack = new Stack<String>();
   *//**
      * Intialized a currdir of type Directory to keep track of the file system
      * objects
      */
  /*
   * public static Directory currdir = root;
   * 
   *//**
      * Void main function to run the whole program via calling class Input
      */
  /*
  */ public static void main(String[] args) {

    Directory root = new Directory("/");
    // TODO Auto-generated method stub
    Stack<String> DirStack = new Stack<String>();
    ArrayList<String> HistoryArr = new ArrayList<String>();
    Location loc = new Location(root, HistoryArr, DirStack);
    Input userInput = Input.createInstanceOfInput(loc);
  }
}
