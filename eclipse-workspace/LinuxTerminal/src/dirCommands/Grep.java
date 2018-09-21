// **********************************************************
// Assignment2:
// Student1: Abhinav Chaudhary
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

import input.Output;
import input.Location;
import java.util.ArrayList;
import java.util.Arrays;
import driver.JShell;
import fileSystemObjects.*;

/**
 * Grep class
 * 
 * @author babubala
 *
 */
public class Grep extends Commands<String> {
  /**
   * String array for directories
   */
  private String[] dirArray;
  /**
   * String var search to store the search path from user
   */
  private String search;
  /**
   * Boolean var to store if subdir is present
   */
  private boolean subdir;
  /**
   * Directory var to store the root
   */
  private Directory root;

  /**
   * Constructor for Grep, initializes dir string array and true or false if it
   * is subdir, and location
   * 
   * @param dir
   * @param issubdir
   * @param loc
   * @return none
   */
  public Grep(String[] dir, boolean issubdir, Location loc) {
    this.dirArray = Arrays.copyOfRange(dir, 1, dir.length);
    this.search = dir[0];
    this.subdir = issubdir;
    this.root = loc.getRoot();
  }

  /**
   * Execute method returns string. This method executes the Grep cmd
   * 
   * @param None
   * @return String: output of Grep execution.
   */
  public String execute() {
    String output = "";
    String tempOut = "";
    FSElement file;
    ArrayList<FSElement> recfiles;
    for (String fileName : dirArray) {
      file = Traverse.accessFS(fileName, root);
      if (file != null) {
        if (file instanceof File) {
          tempOut = getContent((File) file);
          if (!(output.contains(tempOut))) {
            output += tempOut;
          }
        } else if (subdir) {
          recfiles = Traverse.getAllDirs((Directory) file);
          for (FSElement temp : recfiles) {
            if (temp instanceof File) {
              tempOut = getContent((File) temp);
              if (!(output.contains(tempOut))) {
                output += tempOut;
              }
            }
          }
        }
      } else {
        Output.pathIncorrect(fileName);
      }
    }
    if (!(output.equals(""))) {
      output = output.substring(0, output.length() - 2);
      return output;
    } else {
      Output.NoFilesFound();
      return null;
    }
  }

  /**
   * This method returns a string of the file contents.
   * 
   * @param file: Type File, this is a file
   * @return String: contents of file
   */

  private String getContent(File file) {
    String output = "";
    String[] content;
    content = ((File) file).getContent().split("\\r?\\n");
    for (String line : content) {
      if (line.contains(this.search)) {
        output += line + "\n";
      }
    }
    if (!(output.equals(""))) {
      output = Pwd.returnPathFromRoot(file) + ":\n" + output + "\n";
    }
    return output;
  }
}
