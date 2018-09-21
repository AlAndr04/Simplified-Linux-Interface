// **********************************************************
// Assignment2:
// Student1: Abhinav Chaudharu
// UTORID username: chaud349
// UT Student #: 1002707733
// Author: Abhinav Chaudhary
//
// Student2: Alexandru Andros
// UTORID username: androsal
// UT Student #:
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

import input.Location;;

/**
 * Class that is responsible for pushd command and cooperates with directory
 * stack. Also inherits from commands.
 *
 */
public class Pushd extends Commands<Void> {
  /**
   * loc: the location of all the data on JShell.
   */
  private Location loc;
  /**
   * newdir: the name that becomes the current directory after the previous one
   * is being pushed.
   */
  private String newdir;

  /**
   * Puts the dirname value to newdir.
   * 
   * @param dirname
   * @return None.
   */
  public Pushd(String dirname, Location loc) {
    this.newdir = dirname;
    this.loc = loc;
  }

  /**
   * Returns the current directory, pushes it to the directory stack, the call
   * cd and changes the current directory to the one given.
   * 
   * @param None.
   * @return None.
   */
  public Void execute() {
    // Returns the name using pwd and gets it to the string path.
    String path = Pwd.returnPathFromRoot(loc.getCurrDir());
    // Pushes the path to the directory stack.
    loc.getDirStack().push(path);
    // Instantiates new cd object with the newdir as its parameter
    // and executes it.
    Cd dirchanger = new Cd(this.newdir, loc);
    dirchanger.execute();
    return null;
  }

}
