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

import input.UniqueNameException;

/***
 * File object, meant to replicate a file in a file system. Has a parent and
 * able to contain text content.
 *
 */
public class File extends FSElement {

  /***
   * String meant to represent the contents of a file
   */
  private String contents = "";

  /***
   * Constructor for file object. Takes in a string parameter which is meant to
   * be the name of the file and directory parameter which is meant to act as
   * the parent of the file in the file system.
   * 
   * @param newName name of instance File being constructed
   * @param parent parent of instance File being construced
   */
  public File(String newName, Directory parent) throws NullPointerException {
    super(parent, newName);
    if (parent != null) {
      parent.addToChildDir(this);
    } else {
      throw new NullPointerException();
    }
  }

  /***
   * Appends String parameter to contents of instance file.
   * 
   * @param newContent String needed to be appended to instance file contents
   */
  public void addToContent(String newContent) {
    // System.out.println("I am inside File Class");
    this.contents += newContent;
  }

  /***
   * Deletes contents of instance file
   */
  public void delStrings() {
    this.contents = "";

  }

  /***
   * Returns text contents of instance file.
   * 
   * @return contents of instance file
   */
  public String getContent() {
    return this.contents;
  }

  /**
   * equals override method, to compare two files
   * 
   * @param file: File to compare to
   * @return boolean: whether both Files are the same
   */
  public boolean equals(File file) {
    return (this.getName().equals(file.getName()));
  }
}
