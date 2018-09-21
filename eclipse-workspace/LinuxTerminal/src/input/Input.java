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
// UT Student #:1003354871
// Author: Balaji Babu
//
// Student4: Zhi Zhong Huang
// UTORID username: huang472
// UT Student #:
// Author: Zhi Zhong Huang
//
//
// Honor Code: I pledge that this program represents my own
// program code and that I have coded on my own. I received
// help from no one in designing and debugging my program.
// I have also read the plagiarism section in the course info
// sheet of CSC B07 and understand the consequences.
// *********************************************************
package input;

import java.util.*;

/**
 * Input is responsible for receiving the commands inputed in JShell.
 */
public class Input {
  /**
   * The variable that helps with sigleton
   */
  private static Input ref = null;
  /**
   * The variable stores user input
   */
  public static String userIn;

  /**
   * Constructor for object Input (Command Echo). Interacts with Jshell.
   * 
   * @param Location
   * @return None
   */
  private Input(Location loc) {
    boolean exitM = false;
    while (exitM == false) {
      ArrayList<String> HistoryArr = loc.getHistoryArr();
      System.out.print("/#:");
      Scanner sc = new Scanner(System.in);
      userIn = sc.nextLine();
      // If the command is EXIT don't accept new command
      HistoryArr.add(userIn);
      if (userIn.contains("exit")) {
        exitM = true;
        sc.close();
      } else if (!(userIn.trim().isEmpty())) {
        CommandManager command = new CommandManager(userIn, loc);
      }
    }
  }

  /**
   * Instance method to Intialize Input Used for singleton design
   * 
   * @param None
   * @return Input
   */
  public static Input createInstanceOfInput(Location loc) {
    if (ref == null) {
      ref = new Input(loc);
    }
    return ref;
  }
}
