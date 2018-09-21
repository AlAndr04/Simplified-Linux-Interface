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
// UT Student #: 1003354871
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
package fileCommands;

import dirCommands.*;
import fileSystemObjects.*;
import input.Output;
import input.PathIncorrectException;
import input.UniqueNameException;

/***
 * Mkfile class. Used to represent the Mkfile command in the JShell, which is
 * used to create a file. It's not called by the user, but used in echo to make
 * a file given a string input.
 *
 */
public class Mkfile {
  /***
   * String array to the directory you desire the file to be created in.
   */
  private String[] path;

  /***
   * Constructor for Mkfile class object.
   * 
   * @param newPath String array to the directory desired for the file to be
   *        created in
   */
  public Mkfile(String[] newPath) {
    this.path = newPath;
  }

  /***
   * Returns file linked to the parent given by the path instance variable
   * 
   * @param name Name of the file desired to be created
   * @return file linked to directory specified by the path
   */
  public File mkFileWPath(String name)
      throws PathIncorrectException, UniqueNameException {
    Directory parent = null;
    parent = Traverse.returnGivenPathFromRoot(path);
    if (parent == null) {
      throw new PathIncorrectException(path);
    }
    for (FSElement E : parent.getChildDir()) {
      if ((E instanceof Directory) && (E.getName().equals(name))) {
        throw new UniqueNameException(name);
      }
    }
    return new File(name, parent);
  }
}
