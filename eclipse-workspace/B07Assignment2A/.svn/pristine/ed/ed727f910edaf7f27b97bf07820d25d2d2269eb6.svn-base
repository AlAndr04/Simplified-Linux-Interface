// **********************************************************
// Assignment2:
// Student1: Abhinav Chaudharu
// UTORID user_name: chaud349
// UT Student #: 1002707733
// Author: Abhinav Chaudhary
//
// Student2: Alexandru Andros
// UTORID user_name: androsal
// UT Student #:
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
/**
 * Class that is responsible for pushd command and cooperates with
 * directory stack. Also inherits from commands.
 *
 */
public class Pushd extends Commands<Void> {
  /**
   * new_dir: the name that becomes the current directory after the previous one
   * is being pushed.
   */
  private String new_dir;

  /**
   * Puts the dir_name value to new_dir.
   * 
   * @param dir_name
   * @return None.
   */
  public Pushd(String dir_name) {
    this.new_dir = dir_name;
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
    String path = Pwd.returnPathFromRoot(JShell.curr_dir);
    // Pushes the path to the directory stack.
    JShell.Dir_Stack.push(path);
    // Instantiates new cd object with the new_dir as its parameter
    // and executes it.
    Cd dir_changer = new Cd(this.new_dir);
    dir_changer.execute();
    return null;
  }

}
