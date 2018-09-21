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
package input;

import java.util.ArrayList;
import java.util.Stack;
import fileSystemObjects.*;


/***
 * Location holds root directory, current directory, history stack, directory
 * stack and other information relevant to the file system. This class is to be
 * composed in the JShell class.
 */
public class Location {
  /**
   * Root Directory
   */
  private Directory rootDir;
  /**
   * Current Directory
   */
  private Directory currDir;
  /**
   * History Stack
   */
  private ArrayList<String> HistoryArr;
  /**
   * Directory Stack
   */
  private Stack<String> DirStack;

  /**
   * Constructor for a location object.
   * 
   * @param root Root Directory
   * @param history Input History Stack
   * @param dir Input Directory Stack
   */
  public Location(Directory root, ArrayList<String> history,
      Stack<String> dir) {
    this.rootDir = root;
    this.currDir = rootDir;
    this.HistoryArr = history;
    this.DirStack = dir;
  }

  /**
   * Getter for root directory
   * 
   * @return root directory
   */
  public Directory getRoot() {
    return this.rootDir;
  }

  /**
   * Setter for current directory
   */
  public void setCurrDir(Directory newCurr) {
    this.currDir = newCurr;
  }

  /**
   * Getter for current directory
   * 
   * @return current directory
   */
  public Directory getCurrDir() {
    return this.currDir;
  }

  /**
   * Getter for History Stack
   * 
   * @return History Stack
   */
  public ArrayList<String> getHistoryArr() {
    return this.HistoryArr;
  }

  /**
   * Getter for Directory stack
   * 
   * @return Directory stack
   */
  public Stack<String> getDirStack() {
    return this.DirStack;
  }
}
