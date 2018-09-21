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

import java.lang.reflect.Array;
import java.util.Arrays;
import dirCommands.*;
import dirCommands.Traverse;
import driver.JShell;
import fileSystemObjects.Directory;
import fileSystemObjects.File;
import input.Output;
import input.Parse;
import input.PathIncorrectException;
import input.UniqueNameException;

public class Echo extends Commands<Void> {
  // Initiallizing Variables
  private int size;
  private String content;
  private String file_and_operator;
  private boolean append_file = false;
  private boolean new_file = false;

  /**
   * Constructor for object Echo (Command Echo). Takes Input and breaks it into
   * substring .
   * 
   * @param input: Array String
   * @return None
   */
  public Echo(String[] input) {

    // Getting the size of the echo command
    this.size = input.length;
    // Case 1 : When >>echo "I love Apples"
    if (size == 1) {
      this.content = input[0];
    }
    // Case 2 : When :-> echo "I love Apples" > apples.txt
    // Case 3 : When :-> echo "but I like mangoes too" >> apples.txt
    if (size == 2) {
      // "I love Apples"
      this.content = input[0];
      // ">apples.txt"
      this.file_and_operator = input[1];
      // Taking care of Case 3 here
      if (file_and_operator.contains(">>")) {
        this.append_file = true;
        // ">> apples.txt"
        this.file_and_operator = this.file_and_operator.replaceAll(">>", "");
        this.file_and_operator = this.file_and_operator.replaceAll("\\s+", "");
      }
      // Taking care of Case 2 here
      else if (file_and_operator.contains(">")) {
        this.new_file = true;
        // "> apples.txt"
        this.file_and_operator = this.file_and_operator.replaceAll(">", "");
        this.file_and_operator = this.file_and_operator.replaceAll("\\s+", "");

      } else {
        Output.invalidInput();
      }
    }
  }

  /**
   * Executes the cat command, with already given file(s) parameter(s)
   * 
   * @param None
   * @return None
   */
  public Void execute() {
    if (size == 1) {
      // System.out.println("I was here");
      Output.printTextToShell(content);
    }
    if (size == 2) {
      // Getting the path is a string form eg : "/Abhi/Document/B07/"
      String curr_path = Pwd.returnPathFromRoot(JShell.curr_dir);
      // System.out.println("this is the file "+curr_path);

      String curr_path_string_mk =
          "*/" + curr_path.substring(1, curr_path.length());
      String curr_path_string =
          "*/" + curr_path.substring(1, curr_path.length()) + "/"
              + file_and_operator;
      // System.out.println(curr_path_string);
      // Changing the path string into an array [ ,Abhi,Document,B07]
      String[] curr_path_array = curr_path_string.split("/");
      String[] curr_path_mk = curr_path_string_mk.split("/");
      // Add the root in the array [ / , Abhi, Document, B07]
      curr_path_array[0] = "/";
      curr_path_mk[0] = "/";

      if (curr_path.equals("/")) {
        // Arrays.fill(curr_path_array, null);
        curr_path_array = new String[2];
        curr_path_array[0] = "/";
        curr_path_array[1] = file_and_operator;
      }
      try {
        if (new_file) {
          if (Traverse.returnGivenPathFromRootFile(curr_path_array) == null) {
            Mkfile file = new Mkfile(curr_path_mk);
            File file_made;
            try {
              file_made = file.mkFileWPath(file_and_operator);
              file_made.addToContent(content);
            } catch (PathIncorrectException e) {
              Output.pathIncorrect(e.toString());
            } catch (UniqueNameException e) {
              Output.nameNotValid(e.toString());
            }
            // Appending the contents of the file to the the node...
          } else {
            // System.out.println("I am here");
            // Find the path of the file
            File found_file =
                Traverse.returnGivenPathFromRootFile(curr_path_array);
            // Delete the contents of the file
            found_file.delStrings();
            // Apending the content
            found_file.addToContent(content);
          }
        }
        if (append_file) {
          // Find the path of the file
          File found_file =
              Traverse.returnGivenPathFromRootFile(curr_path_array);
          // Apending the content
          content = "\n"+"\n"+"\n" + content;
          found_file.addToContent(content);
        }
      } catch (PathIncorrectException e) {
        Output.pathIncorrect(e.toString());
      }
    }
    return null;
  }

}
