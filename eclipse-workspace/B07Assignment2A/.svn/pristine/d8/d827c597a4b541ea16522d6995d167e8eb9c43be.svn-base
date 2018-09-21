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
package fileSystemObjects;

import java.util.*;

/***
 * Object which exists within the file system. Inherited by both File and
 * Directory classes. This class represents commonalities between both objects
 * within the file system, like possessing a name and a parent directory.
 *
 */
public class FSElement {
  /***
   * FSElement used to point towards parent element
   */
  private FSElement parent;
  /***
   * Name of the instance FSElement
   */
  private String name;

  /***
   * Sets the parent for this instance of FSElement
   * 
   * @param parentSetter FSElement object needed to be set as the parent for
   *        this FSElement instance
   */
  public void setParent(FSElement parentSetter) {
    this.parent = parentSetter;
  }

  /***
   * Getter for FSElement instance's parent
   * 
   * @return parent Parent of the instance FSElement
   */
  public FSElement getParent() {
    return this.parent;
  }

  /***
   * Sets the name for this instance of FSElement
   * 
   * @param nameSetter Name to be set as the name of this FSElement
   */
  public void setName(String nameSetter) {
    this.name = nameSetter;
  }
  public void removeFromParentRef() {
    ((Directory) this.getParent()).getChildDir().remove(this);
  }
  /***
   * Gets name of the FSElement instance
   * 
   * @return Name of this FSElement instance
   */
  public String getName() {
    return this.name;
  }

  /***
   * Constructor when taking in no elements. To be overwritten in subclasses.
   */
  public FSElement() {}

  /***
   * Constructor when both a parent and name are given.
   * 
   * @param parentpara Parent of the FSElement on creation
   * @param newName Name of the FSElement on creation
   */
  public FSElement(FSElement parentpara, String newName) {
    this.parent = parentpara;
    this.name = newName;
  }

  /***
   * Constructor for constructing an FSElement object when the name is only
   * given
   * 
   * @param newName Name of the FSElement on creation
   */
  public FSElement(String newName) {
    this.name = newName;
  }
}
