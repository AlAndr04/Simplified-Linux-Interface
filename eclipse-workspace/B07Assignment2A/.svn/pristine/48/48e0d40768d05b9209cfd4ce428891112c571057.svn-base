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

import fileSystemObjects.*;
import input.Output;
import driver.JShell;

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
  public Tree() {}

  /***
   * Executes command by calling buildTree and the file system's root
   */
  public String execute() {
    buildTree(JShell.root, 0);
    return null;
  }

  /***
   * Prints out tree via output, sub elements of a parent directory being
   * displayed under the name of the parent with an additional tab character
   * placed at the beginning of the line being displayed.
   * 
   * @param root Root of current subtree
   * @param noTabs Number of tabs to be displayed for current line
   */
  public void buildTree(FSElement root, int noTabs) {
    String dirName =
        new String(new char[noTabs]).replace("\0", "\t") + root.getName();
    Output.printTextToShell(dirName);
    if (root instanceof Directory) {
      if (!((Directory) root).getChildDir().isEmpty()) {
        for (int i = 0; i < ((Directory) root).getChildDir().size(); i++) {
          buildTree(((Directory) root).getChildDir().get(i), noTabs + 1);
        }
      }
    }
  }

}
