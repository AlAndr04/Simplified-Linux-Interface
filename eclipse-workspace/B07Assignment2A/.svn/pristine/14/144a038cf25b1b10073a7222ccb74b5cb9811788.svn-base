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
import dirCommands.Pwd;
import dirCommands.Traverse;
import driver.JShell;
import fileSystemObjects.File;
import input.Output;
import input.PathIncorrectException;

/**
 * Class is for Cat cmd. Core Cat functions implemented here.
 * 
 * @author Balaji Babu
 *
 */
public class Cat extends Commands<String> {
  /**
   * file_names is composed of file(s) name(s) given as a parameter for Cat
   */
  private String[] file_names;

  /**
   * Constructor for object Cat (Command Cat). Instantiates file parameter
   * needed to run Cat command.
   * 
   * @param files: file(s) paramater(s) for cat command.
   * @return None
   */
  public Cat(String[] files) {
    this.file_names = files;
  }

  /**
   * Executes the cat command, with already given file(s) parameter(s)
   * 
   * @param None
   * @return None
   */
  public String execute() {

    // Getting the size of the array
    int size = file_names.length;

    for (int i = 0; i < size; i++) {
      String file = file_names[i];
      // String curr_path = Pwd.returnPathFromRoot(JShell.curr_dir);
      // System.out.println("this is the current path inside cat "+curr_path);
      // Changing the path string into an array [ ,Abhi,Document,B07]
      String[] curr_path_array = file.split("/");
      curr_path_array[0] = "/";
      // Add the root in the array [ / , Abhi, Document, B07]
      curr_path_array[0] = "/";
      File current_file;
      try {
        current_file = Traverse.returnGivenPathFromRootFile(curr_path_array);
        String contents = current_file.getContent();
        // Printing the contents via class Output
        if (size == 1) {
          Output.printTextToShell(contents);
        } else {
          Output.printTextToShell(contents + "\n\n\n");
        }
      } catch (PathIncorrectException e) {
        Output.pathIncorrect(e.toString());;
      }
    }
    return null;
  }



}

