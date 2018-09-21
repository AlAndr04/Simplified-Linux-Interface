// **********************************************************
// Assignment2:
// Student1: Abhinav Chaudharu
// UTORID user_name: chaud349
// UT Student #: 1002707733
// Author: Abhinav Chaudhary
//
// Student2: Alexandru Andros
// UTORID user_name: androsal
// UT Student #: 1004354263
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
import input.UniqueNameException;
import fileSystemObjects.Directory;
import input.Output;
/**
 * Class meant to represent mkdir command. It includes the method that makes
 * the directory at given path.
 *
 */
public class Mkdir extends Commands<Void> {
  /**
   * lst_path: 2D array that stores all the paths that already exist and the
   * directories require to create.
   **/
  public String[][] lst_path;

  /**
   * Constructor for object (command) Mkdir. Populates lst_path with the split
   * input
   * 
   * @param raw_path: an array of all paths.
   * @return:None.
   */
  public Mkdir(String[] raw_path) {
    // Populates lst_path.
    this.lst_path = generate_path_array(raw_path);
  }

  public Void execute() {
    // Initiates symbols, that will store whether the names are valid,
    // and c, which is a char being compared.
    boolean symbols;
    char c;
    // Loops through lst_path.
    for (int i = 0; i < this.lst_path.length; i++) {
      // Makes symbols being true.
      symbols = true;
      // Loops through the string elements.
      for (int j = 0; j < this.lst_path[i][1].length(); j++) {
        // Gets the char at the index and checks if it's not a valid
        // character. Then symbols becomes false.
        c = this.lst_path[i][1].charAt(j);
        if (!(c <= 'Z' && c >= 'A') && !(c <= 'z' && c >= 'a')
            && !(c <= '9' && c >= '0')) {
          symbols = false;
        }
      }
      // Does the following only if symbols is true (name is valid).
      if (symbols) {
        // Gets the existent part of the path and stores in a variable pointer.
        Directory pointer =
            Traverse.findPathString(lst_path[i][0], JShell.root);
        if (pointer == null) {
          // If pointer is null, then it means the path does not exist, thus
          // outputs an error.
          Output.directoryInvalid();
        } else {
          try {
            // Makes the directory using the created method with the given name
            // and the pointer as the parent.
            Directory new_dir = Directory.makeDir(lst_path[i][1], pointer);
          } catch (UniqueNameException e) {
            // If the exception is called, that means there is a directory
            // with that same name. So it sends an error to output.
            Output.nameNotValid(e.toString());
          }
        }
      } else {
        // This means it does have characters that are not accepted. So it
        // outputs an error.
        Output.directoryInvalid();
      }
    }
    return null;
  }

  /**
   * Populates lst_path and splits the path given into the path that exists and
   * the directory needed to create
   * 
   * @param raw_path: an array of all paths.
   * @return:local_lst_path: a 2D array with the necessary data inside.
   */
  public String[][] generate_path_array(String[] raw_lst_path) {
    // Creates a variable j and a new 2D array with the number
    // of input as 1 side and 2 as the other.
    int j;
    String[][] local_lst_path = new String[raw_lst_path.length][2];
    // Loops through all the the input.
    for (int i = 0; i < raw_lst_path.length; i++) {
      // Makes j equal to index of last element.
      j = raw_lst_path[i].length() - 1;
      // Runs as long as j is greater than 0 and as long there is no /.
      // This will find where the name of the directory that should be created
      // is. Decreases j in the loop.
      while ((j > 0) && (raw_lst_path[i].charAt(j) != '/')) {
        j--;
      }
      // the first element of 2D array at the index i is the substring up to j.
      // The second element is the rest, which is the name of the directory.
      local_lst_path[i][0] = raw_lst_path[i].substring(0, j);
      if (raw_lst_path[i].charAt(j) == '/') {
        j++;
      }
      local_lst_path[i][1] =
          raw_lst_path[i].substring(j, raw_lst_path[i].length());
    }
    return local_lst_path;
  }

}
