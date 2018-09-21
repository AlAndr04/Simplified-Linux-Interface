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
// UT Student #: 1003354871
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
package fileCommands;

import dirCommands.*;
import input.InvalidNameException;
import input.Location;
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
  private Directory root;

  /***
   * Constructor for Mkfile class object.
   * 
   * @param newPath String array to the directory desired for the file to be
   *        created in
   */
  public Mkfile(String[] newPath, Directory newRoot) {
    this.root = newRoot;
    this.path = newPath;
  }

  /***
   * Returns file linked to the parent given by the path instance variable
   * 
   * @param name Name of the file desired to be created
   * @return file linked to directory specified by the path
   */
  public File mkFileWPath(String name)
      throws PathIncorrectException, UniqueNameException, InvalidNameException {
    Directory parent = null;
    parent = Traverse.returnGivenPathFromRoot(path, this.root);
    if (parent == null) {
      throw new PathIncorrectException(path);
    }
    for (FSElement E : parent.getChildDir()) {
      if ((E instanceof Directory) && (E.getName().equals(name))) {
        throw new UniqueNameException(name);
      }
    }
    char c;
    int periodNum = 0;
    for (int j = 0; j < name.length(); j++) {
      // Gets the char at the index and checks if it's not a valid
      // character. Then symbols becomes false.
      c = name.charAt(j);
      if (c == '.') {
        periodNum++;
      }
      if (((!(c <= 'Z' && c >= 'A') && !(c <= 'z' && c >= 'a')
          && !(c <= '9' && c >= '0')) && !(c == '.')) || (periodNum >= 2)
          || ((name.length() == 1)) && (periodNum == 1)) {
        throw new InvalidNameException(name);
      }
    }
    return new File(name, parent);
  }
}
