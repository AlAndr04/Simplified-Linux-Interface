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

import java.util.*;
import input.Location;
import input.Output;

/**
 * Class for Man cmd. Core Man cmd functions implemented here.
 * 
 * @author Balaji Babu
 *
 */
public class Man extends Commands<String> {
  // create instance dictionary
  /**
   * Dictionary for storing manual contents
   */
  private Hashtable<String, String> manual = new Hashtable<String, String>();
  /**
   * Name of command. Parameter with cmd Man.
   */
  private String cmd;

  /**
   * Constructor for object (command) Man. Automatic first method ran when
   * object Man is created.
   * 
   * @param cmd The name of the cmd (command) to be used in conjucture with
   *        command Man
   * @return None.
   */
  public Man(String cmd, Location loc) {
    this.cmd = cmd;
    manual.put("ls", "Usage: ls [PATH..]\nIf no paths are given"
        + " (list of paths permissible),print the contents (file or directory)"
        + " of the current directory\n,"
        + "with a new line following each of the content"
        + " (file or directory).\nOtherwise, for each path p, the order"
        + " listed:\n" + "If p s pecifies a file, p is printed\n"
        + "If p specifies a directory, prints p, a colon, then the"
        + " contents of that"
        + "directory, then an extra new line.\n If p does not exist,"
        + "prints an error message. ");
    manual.put("exit", "Usage: exit\nQuits the program");
    manual.put("mkdir",
        "Usage: mkdir DIR...\n(...) : indicates a list\nCreates directories"
            + ",each of which may be relative to the current directory or may"
            + " be a full path");
    manual.put("cd",
        "Usage: cd DIR\nChanges directory to DIR, which may be relative "
            + "to the\n"
            + "current directory or may be a full path.\nNote in Unix terms,"
            + " .. Findmeans a parent"
            + "directory and a . means the current directory. The directory"
            + " must be /, the forward"
            + "slash. The foot of the file system is a single slash:/.");
    manual.put("pwd",
        "Usage: pwd\nPrint the current working directory(including the"
            + " whole path).");
    manual.put("pushd",
        "Usage: pushd DIR\nSaves the current working directory and then"
            + " changes the new current directory to DIR\n"
            + "The saved directory is now saved so that it can be returned"
            + " to at any time (via the popd command).\n");
    manual.put("popd",
        "Usage: popd\n Changes current directory to the most recently"
            + " saved directory\n"
            + "If no directory has been saved and popd is used, an error"
            + " message is printed");
    manual.put("history",
        "Usage: history [number]\nPrints out recent commands, one per"
            + " line.\n"
            + "The number parameter is optional. It truncates the output"
            + " to only show the last [number] commands typed.");
    manual.put("cat",
        "Usage: cat FILE1 [FILE2...])\n FILE1 paramater is compulsory,"
            + " FILE2...(... indicates a list) is optional\n"
            + "Displays the contents of FILE1 and other files (i.e FILE2...)"
            + " concatenated in the shell.");
    manual.put("echo",
        "Usage: echo STRING [>OUTFILE]\nPrint STTRING on shell of"
            + " OUTFILE not provided. Otherwise, put STRING into file OUTFILE.\n"
            + "A new file OUTFILE is created if it does not exist and erases"
            + " the old contents of OUTFILE if it does exist.");
    manual.put("man", "Usage: man CMD\nPrints out the manual for given CMD.");
    manual.put("curl",
        "Usage: curl URL ---- URL is a web address. Retrieves"
            + " the file at that URL and add it to the current\n"
            + "working directory.");
    manual.put("grep", "Usage: grep [-R] REGEX PATH �\n"
        + " If �R is not supplied, print any lines containing REGEX in PATH,"
        + " which must be\n"
        + "a file. If �R is supplied, and PATH is a directory, recursively "
        + "traverse the directory\n"
        + "and, for all lines in all files that contain REGEX, print the path"
        + " to the file\n"
        + "(including the filename), then a colon, then the line that contain"
        + "ed REGEX.");
  }

  /**
   * Executes the man command, with already given command parameter
   * 
   * @param:None
   * @return:String ret: ret is the manual description of requested cmd
   */
  public String execute() {
    String manualcontents = manual.get(cmd);
    String ret = null;
    if (manualcontents == null) {
      Output.commandNotFoundError(this.cmd);
    } else {
      Output.printTextToShell(manualcontents);
      ret = manualcontents;
    }
    return ret;
  }
}
