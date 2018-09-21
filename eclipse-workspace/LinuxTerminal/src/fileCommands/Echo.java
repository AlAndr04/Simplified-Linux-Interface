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

import java.lang.reflect.Array;
import input.Location;
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
import input.InvalidNameException;

public class Echo extends Commands<Void> {
  // Initializing Variables
  /**
   * This is a variable for size of the Array
   */
  private int size;
  /**
   * This variable is used for testing by using a location type
   */
  private Location loc;
  /**
   * This variable is used to store the contents of the file
   */
  private String content;
  /**
   * This variable is used to store the file name and the operator ie. > or >>
   */
  private String fileAndOperator;
  /**
   * A flag for append file ie. >>
   */
  private boolean appendFile = false;
  /**
   * A flag for new fiel ie >
   */
  private boolean newFile = false;

  /**
   * Constructor for object Echo (Command Echo). Takes Input and breaks it into
   * substring .
   * 
   * @param input: Array String
   * @return None
   */
  public Echo(String[] input, Location loc) {
    // System.out.println(Arrays.toString(input));
    // Getting the size of the echo command
    this.size = input.length;
    this.loc = loc;
    // System.out.println(this.loc);
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
      this.fileAndOperator = input[1];
      // Taking care of Case 3 here
      if (fileAndOperator.contains(">>")) {
        this.appendFile = true;
        // ">> apples.txt"
        this.fileAndOperator = this.fileAndOperator.replaceAll(">>", "");
        this.fileAndOperator = this.fileAndOperator.replaceAll("\\s+", "");
      }
      // Taking care of Case 2 here
      else if (fileAndOperator.contains(">")) {
        this.newFile = true;
        // "> apples.txt"
        this.fileAndOperator = this.fileAndOperator.replaceAll(">", "");
        this.fileAndOperator = this.fileAndOperator.replaceAll("\\s+", "");
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
    String[][] pathArray;
    String[] currPathArray = null;
    String[] currPathMk = null;
    if (size == 1) {
      Output.printTextToShell(content);
    }
    if (size == 2) {
      if (this.fileAndOperator.contains("/")) {
        String[][] arr = absoluteFile(this.fileAndOperator);
        currPathArray = arr[0];
        currPathMk = arr[1];
        this.fileAndOperator = currPathArray[(currPathArray.length) - 1];
      } else {
        pathArray = currPathArr();
        currPathArray = pathArray[0];
        currPathMk = pathArray[1];
      }
    }
    if (newFile) {
      try {
        newfile(currPathArray, currPathMk);
      } catch (PathIncorrectException e) {
        Output.pathIncorrect(e.toString());
      }
    }
    if (appendFile) {
      appendfile(currPathArray);
    }
    return null;
  }

  /**
   * This is when the user gives in a relative path this helper method finds the
   * current working directory and makes currPathArray and currPathMk EXAMPLE:
   * >>> mkdir User User/Abhinav User/Abhinav/Doc >>> cd User/Abhinav/Doc >>>
   * echo "Make me a file machine" > file.txt The method would do the following
   * currPathArray -> [/, User, Abhinav, Doc, file.txt] currPathMk -> [/, User,
   * Abhinav, Doc]
   * 
   * @param None
   * @return String[][]
   */
  private String[][] currPathArr() {
    // Getting the path is a string form eg : "/Abhi/Document/B07/"
    String currPath = Pwd.returnPathFromRoot(loc.getCurrDir());
    String currPathStringMk = "*/" + currPath.substring(1, currPath.length());
    String currPathString =
        "*/" + currPath.substring(1, currPath.length()) + "/" + fileAndOperator;
    // Changing the path string into an array [ ,Abhi,Document,B07]
    String[] currPathArray = currPathString.split("/");
    String[] currPathMk = currPathStringMk.split("/");
    // Add the root in the array [ / , Abhi, Document, B07]
    currPathArray[0] = "/";
    currPathMk[0] = "/";
    if (currPath.equals("/")) {
      currPathArray = new String[2];
      currPathArray[0] = "/";
      currPathArray[1] = fileAndOperator;
    }
    String[][] retArr = {currPathArray, currPathMk};
    return retArr;
  }

  /**
   * This helper method creates a new file or if the file already exist it
   * deletes the content of the file and appends the new content given by the
   * user existing file. Example : newfile([/, User, Abhinav, Doc, file.txt] ,
   * [/, User, Abhinav, Doc])
   * 
   * @param String[], String[]
   * @return void
   */
  private void newfile(String[] currPathArray, String[] currPathMk)
      throws PathIncorrectException {
    if (Traverse.returnGivenPathFromRootFile(currPathArray,
        loc.getRoot()) == null) {
      Mkfile file = new Mkfile(currPathMk, loc.getRoot());
      File fileMade;
      try {
        fileMade = file.mkFileWPath(fileAndOperator);
        fileMade.addToContent(content);
      } catch (PathIncorrectException e) {
        Output.pathIncorrect(e.toString());
      } catch (UniqueNameException e) {
        Output.nameNotValid(e.toString());
      } catch (InvalidNameException e) {
        Output.directoryFileNameInvalid();
      }
      // Appending the contents of the file to the the node...
    } else {
      // Find the path of the file
      File foundfile =
          Traverse.returnGivenPathFromRootFile(currPathArray, loc.getRoot());
      // Delete the contents of the file
      foundfile.delStrings();
      // Add the content
      foundfile.addToContent(content);

    }
  }

  /**
   * This helper method appends content to an already existing file. Example :
   * appndfile([/, User, Abhinav, Doc, file.txt])
   * 
   * @param String[]
   * @return void
   */
  private void appendfile(String[] currPathArray) {
    try {
      // Find the path of the file
      File foundFile =
          Traverse.returnGivenPathFromRootFile(currPathArray, loc.getRoot());
      // Add the contents
      // System.out.println("Hello my "+foundFile.getName());
      content = "\n" + content;
      foundFile.addToContent(content);
    } catch (PathIncorrectException e) {
      Output.pathIncorrect(e.toString());
    } catch (NullPointerException e) {
      Output.NoFilesFound();
    }
  }

  /**
   * This is when the user gives in a absolute path this helper method finds the
   * current working directory and makes currPathArray and currPathMk EXAMPLE:
   * >>> mkdir User /User/Abhinav /User/Abhinav/Doc >>> echo "Make me a file
   * machine" > /User/Abhinav/Doc/file.txt The method would do the following
   * currPathArray -> [/, User, Abhinav, Doc, file.txt] currPathMk -> [/, User,
   * Abhinav, Doc]
   * 
   * @param None
   * @return String[][]
   */
  private String[][] absoluteFile(String file) {
    // Split the contents of the path into an array
    if (file.charAt(0) != '/') {
      file = Pwd.returnPathFromRoot(loc.getCurrDir()) + file;
    }
    String[] fileArr = file.split("/");
    int lastElement = (fileArr.length) - 1;
    String[] currPathMk = Arrays.copyOfRange(fileArr, 0, lastElement);
    currPathMk[0] = "/";
    String[] currPathArray = fileArr;
    currPathArray[0] = "/";
    // Return a 2D array
    String[][] retVal = {currPathArray, currPathMk};
    return (retVal);
  }

  /**
   * This is a helper method for testing in Junit It takes the content of the
   * file and file name and output it
   * 
   * @param String[]
   * @param Directory
   * @return String[]
   */
  public static String[] testHelper(String[] currrpatharray, Directory root)
      throws PathIncorrectException {
    File currentfile;
    String[] currpatharray = currrpatharray;
    currentfile = Traverse.returnGivenPathFromRootFile(currpatharray, root);
    String nameFile = currentfile.getName();
    String content = currentfile.getContent();
    String[] ret = {nameFile, content};
    return ret;

  }
}

