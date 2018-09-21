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
package fileSystemObjects;

import java.util.*;
import input.UniqueNameException;

/***
 * Represents a directory in a File System, able to contain children and possess
 * a parent directory.
 */
public class Directory extends FSElement {
  /***
   * ArrayList of FSElements which contain the children of this instance
   * directory
   */
  private ArrayList<FSElement> childDir = new ArrayList<FSElement>();

  /***
   * Adds a new Directory to instance directory's child directory.
   * 
   * @param newNode Directory or file
   */
  public void addToChildDir(FSElement newNode) {
    childDir.add(newNode);
  }

  /**
   * Prints the names of all children of directory.
   * 
   * @return output: the names of all children.
   */
  public String PrintChildDir() {
    String output = "";
    for (FSElement element : childDir) {
      output += element.getName() + ",";
    }
    return output;
  }

  /***
   * Returns ArrayList which is the child array of this directory.
   * 
   * @return child array of this directory
   */
  public ArrayList<FSElement> getChildDir() {
    return childDir;
  }

  /***
   * Constructs a Directory object when no parent is given.
   * 
   * @param newName Name of directory
   */
  public Directory(String newName) {
    super(newName);
  }

  /***
   * Creates a new directory with the given name and parent directory.
   * 
   * @param newName Name of the directory object being created
   * @param parentpara Parent of directory object being created
   * @return new Directory object
   * @throws UniqueNameException Thrown if there exists a file/directory with
   *         same name in the parent's child directory array
   */
  public static Directory makeDir(String newName, Directory parentpara)
      throws UniqueNameException {
    if (!(parentpara.childDir.isEmpty())) {
      for (FSElement E : parentpara.childDir) {
        if (newName.equals(E.getName())) {
          throw new UniqueNameException(newName);
        }
      }
    }
    return new Directory(newName, parentpara);
  }

  /***
   * Private constructor for factory method makeDir.
   * 
   * @param newName Name of directory being created
   * @param parentpara parent directory
   */
  private Directory(String newName, Directory parentpara) {
    super(parentpara, newName);
    parentpara.addToChildDir(this);
  }
}
