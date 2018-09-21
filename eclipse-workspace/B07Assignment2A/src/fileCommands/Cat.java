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
package fileCommands;

import dirCommands.Commands;
import input.Location;
import dirCommands.Pwd;
import dirCommands.Traverse;
import fileSystemObjects.File;
import input.Output;
import input.PathIncorrectException;
import fileSystemObjects.Directory;

/**
 * Class is for Cat cmd. Core Cat functions implemented here.
 * 
 **
 */
public class Cat extends Commands<String> {
  /**
   * filenames is composed of file(s) name(s) given as a parameter for Cat
   */
  private String[] filenames;
  /**
   * This Directory variable is used for Junit testing and gives the root
   */
  private Directory root;

  /**
   * Constructor for object Cat (Command Cat). Instantiates file parameter
   * needed to run Cat command.
   * 
   * @param files: file(s) paramater(s) for cat command.
   * @return None
   */
  public Cat(String[] files, Location loc) {
    this.filenames = files;
    this.root = loc.getRoot();
  }

  /**
   * Executes the cat command, with already given file(s) parameter(s)
   * 
   * @param None
   * @return String: Contents of file is returned as a String
   */
  public String execute() {
    // Getting the size of the array
    int size = filenames.length;
    String output = null;
    for (int i = 0; i < size; i++) {
      String file = filenames[i];
      // Changing the path string into an array [ ,Abhi,Document,B07]
      String[] currpatharray = file.split("/");
      currpatharray[0] = "/";
      // Add the root in the array [ / , Abhi, Document, B07]
      currpatharray[0] = "/";
      File currentfile;
      try {
        currentfile =
            Traverse.returnGivenPathFromRootFile(currpatharray, this.root);
        if (currentfile != null) {
          String contents = currentfile.getContent();
          // Printing the contents via class Output
          if (size == 1) {
            output = contents;
          } else {
            if (output == null) {
              output = "";
            }
            output += contents + "\n\n\n";
          }
        } else {
          Output.NoFilesFound();
        }
      } catch (PathIncorrectException e) {
        Output.pathIncorrect(e.toString());;
      }
    }
    return output;
  }
}

