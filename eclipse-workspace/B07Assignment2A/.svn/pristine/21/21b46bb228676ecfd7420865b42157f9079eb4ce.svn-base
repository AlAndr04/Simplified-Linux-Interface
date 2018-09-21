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
// UT Student #:1003354871
// Author: Balaji Babu
//
// Student4: Zhi Zhong Huang
// UTORID user_name: huang472
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
 * Input is responsible for receiving the commands inputed
 * in JShell.
 */
public class Input {
  /**
   * The variable that represents history array. 
   */
  public static ArrayList<String> History_Arr;

  /**
   * Constructor for object Input (Command Echo). Interacts with Jshell.
   * 
   * @param input: Array String
   * @return None
   */
  public Input() {
    History_Arr = new ArrayList<String>();
    boolean exitM = false;
    while (exitM == false) {
      System.out.print("/#:");
      Scanner sc = new Scanner(System.in);
      String userIn = sc.nextLine();
      // If the command is EXIT don't accept new command
      History_Arr.add(userIn);
      if (userIn.contains("exit")) {
        exitM = true;
        sc.close();
      } else if (!(userIn.trim().isEmpty())) {
        CommandManager command = new CommandManager(userIn);
      }
    }
  }
}
