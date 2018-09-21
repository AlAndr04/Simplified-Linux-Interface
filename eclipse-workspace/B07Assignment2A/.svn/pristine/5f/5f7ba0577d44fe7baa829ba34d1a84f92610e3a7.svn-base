// **********************************************************
// Assignment2:
// Student1: Abhinav Chaudharu
// UTORID user_name: chaud349
// UT Student #: 1002707733
// Author: Abhinav Chaudhary
//
// Student2: Alexandru Andros
// UTORID user_name: androsal
// UT Student #:1004354263
// Author: Alexandru Andros
//
// Student3: Balaji Babu
// UTORID user_name: babubala
// UT Student #:1003354871
// Author: Balaji Babu
//
// Student4: Zhi Zhong Huang
// UTORID user_name: huang472
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

import driver.JShell;
import java.util.Arrays;
import fileSystemObjects.*;
import input.Output;
/**
 * Class meant to represent the find command. Given the start directories, it
 * finds the files with the given name of the given type.
 *
 */
public class Find extends Commands<String> {
  /**
   * start: array of the starting directories for search. type: the type of
   * file
   * name: the name of the file to search for.
   */
  private String[] start;
  private String type;
  private String name;

  /**
   * Constructor for Find. loc_start is all of the input. Splits the loc_start
   * into 3 parts: start takes all of loc_start except the last 2 values. type
   * takes the second last parameter and name takes the last one.
   * 
   * @param loc_start
   * @return none
   */
  public Find(String[] loc_start) {
    int size = loc_start.length;
    this.start = Arrays.copyOfRange(loc_start, 0, (size - 2));
    this.type = loc_start[size - 2];
    this.name = loc_start[size - 1];
  }

  /**
   * Prints the full path of all the instances of type this.type and name
   * this.name in all of the the paths this.start.
   * 
   * @param none
   * @return none
   */
  public String execute() {
    // Generates the result string which would output all of the paths.
    String result = "";
    // Creates a directory temp.
    Directory temp;
    // Loops through all the paths of start.
    for (int i = 0; i < this.start.length; i++) {
      // gets the directory at the given string and stores it in temp.
      temp = Traverse.findPathString(this.start[i], JShell.root);
      // Outputs the error if temp is null, which means it doesn't exist.
      if (temp == null) {
        Output.pathDoesNotExistError(this.start[i]);
      }
      // Otherwise appends the result of findName function from traverse
      // to result.
      else {
        result += Traverse.findName(temp, this.type, this.name);
      }
    }
    Output.printNoNewLine(result);
    return null;
  }
}
