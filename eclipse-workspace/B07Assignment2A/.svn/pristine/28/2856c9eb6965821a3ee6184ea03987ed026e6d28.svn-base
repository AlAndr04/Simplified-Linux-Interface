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
package input;

import java.util.*;

/**
 * Class for Output handling. Handles output of program to shell.
 * 
 * @author Balaji Babu
 *
 */
public class Output {
  /**
   * Printed to shell, an error message when a name is given for a file or
   * directory to be created but the name isn't unique
   * 
   * @param name Name of the file/directory which is not unique
   */
  public static void nameNotValid(String name) {
    System.out
        .println(name + " : A file or directory in this directory already "
            + "has the same name.\nPlease create a new file or directory"
            + " with a different name");
  }

  /**
   * Prints error message if no syntatically valid command is requested
   * 
   * @param None
   * @return None
   */
  public static void commandInvalid() {
    System.out
        .println("Command invalid please refer to the manual via man CMD");
  }

  // USED IN CLASSES: Ls, Find,
  /**
   * Prints error message regarding an invalid path name
   * 
   * @param path_name: name of path (path_name) that is invalid.
   * @return None
   */
  public static void pathDoesNotExistError(String path_name) {
    System.out.println(path_name + ": No such file or directory");
  }

  // USED IN CLASSES: Man,
  /**
   * Prints error message if given command is not found. Mainly used in
   * combination with Man command
   * 
   * @param command: (String) name of non-existent command
   */
  public static void commandNotFoundError(String command) {
    System.out.println(command + ": command not found");
  }

  // USED IN CLASSES: Mkdir
  /**
   * Prints error message if invalid directory is present, in addition if naming
   * conventions of directories is not followed.
   * 
   * @param None
   * @return Void
   */
  public static void directoryInvalid() {
    System.out.println(
        "Directory given is invalid, note : Directory name convention: the only valid characters are from\n"
            + "lowercase a to z and upper case A to Z and numbers 0 to 9.\n"
            + "Anything other than these characters are considered invalid!");
  }

  // file names and directory names in JShell do not contain a space. Space is
  // considered as an invalid character.
  /**
   * Prints an error message regarding the invalid character *space* being
   * present in File and Directory names.
   * 
   * @param None
   * @return Void
   */
  public static void spacePresentInName() {
    System.out.println("File and Directory names should not contain a space!");
  }

  /**
   * Prints error message if invalidInput is present.
   * 
   * @param None
   * @return Void
   */
  public static void invalidInput() {
    System.out.println("Input invalid please refer to details via man CMD");
  }

  /**
   * Prints error message regarding input for a certain command can only be an
   * integer.
   * 
   * @param None
   * @return Void
   */
  public static void mustBeIntegers() {
    System.out.println("The input given for this command must be integer");
  }

  /**
   * Prints error message regarding an invalid path present.
   * 
   * @param newString: Name of the incorrect path.
   * @return Void
   */
  // Used in Traverse when looking through path
  public static void pathIncorrect(String newString) {
    System.out.println(newString + ": No such file or directory.");
  }

  // USED IN CLASSES: Tree, Man, Echo
  /**
   * Prints given text to shell.
   * 
   * @param text: Text to be printed onto the shell.
   * @return Void
   */
  public static void printTextToShell(String text) {
    System.out.println(text);
  }

  public static void printNoNewLine(String result) {
    // TODO Auto-generated method stub
    System.out.print(result);
  }
  public static void InfiniteLoop() {
    System.out.println("The command that you just inputted leads to an infinte"
        + " loop, please try again");
  }
}

