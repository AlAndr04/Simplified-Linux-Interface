// **********************************************************
// Assignment2:
// Student1: Abhinav Chaudharu
// UTORID username: chaud349
// UT Student #: 1002707733
// Author: Abhinav Chaudhary
//
// Student2: Alexandru Andros
// UTORID username: androsal
// UT Student #: 1004354264
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
package dirCommands;

import input.Location;

/**
 * Commands is a blueprint for all other commands, from which they inherit.
 *
 */
public abstract class Commands<T> {
  /**
   * Constructor for commands with no input.
   * 
   * @param none
   * @return none
   **/
  public Commands() {

  }

  public Commands(Location loc) {

  }

  /**
   * Constructor for commands with String as the input.
   * 
   * @param String input is a string that is an input.
   * @return none
   **/
  public Commands(String input, Location loc) {

  }

  /**
   * Constructor for commands with Array of strings as the input.
   * 
   * @param String[] input is an array of strings.
   * @return none
   **/
  public Commands(String[] input, Location loc) {

  }

  public Commands(String[] input, boolean r, Location loc) {

  }

  /**
   * Executes the command.
   * 
   * @param none
   * @return none
   **/
  public abstract T execute();
}
