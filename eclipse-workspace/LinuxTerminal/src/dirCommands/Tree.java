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

import fileSystemObjects.*;
import input.Location;
import input.Output;
import input.UniqueNameException;
import driver.JShell;
import fileCommands.Mkfile;

/***
 * Tree command for displaying the contents of an entire file system, in tree
 * form, with sub elements of a parent directory being displayed under the name
 * of the parent with an additional tab character placed at the beginning of the
 * line being displayed.
 *
 */
public class Tree extends Commands<String> {
  /***
   * Builds Tree class object
   */
  private Directory root;

  public Tree(Location loc) {
    this.root = loc.getRoot();
  }

  /***
   * Executes command by calling buildTree and the file system's root
   * 
   * @return returns a String which represents the tree structure of our file
   *         system, or null otherwise
   */
  public String execute() {
    try {
      // noTabs defaulted to 0 in this buildTree call
      return buildTree(this.root, 0);
    } catch (NullPointerException e) {
      Output.directoryFileNameInvalid();
      return null;
    }
  }

  /***
   * Prints out tree via output, sub elements of a parent directory being
   * displayed under the name of the parent with an additional tab character
   * placed at the beginning of the line being displayed.
   * 
   * @param root Root of current subtree
   * @param noTabs Number of tabs to be displayed for current line
   */
  public String buildTree(FSElement root, int noTabs)
      throws NullPointerException {
    if (root == null) {
      throw new NullPointerException("No Directory Exists");
    }
    String dirName = new String(new char[noTabs]).replace("\0", "\t")
        + root.getName() + "\n";
    if (root instanceof Directory) {
      if (!(((Directory) root).getChildDir().isEmpty())) {
        for (FSElement E : ((Directory) root).getChildDir()) {
          dirName += buildTree(E, noTabs + 1);
        }
      }
    }
    return dirName;
  }
}
