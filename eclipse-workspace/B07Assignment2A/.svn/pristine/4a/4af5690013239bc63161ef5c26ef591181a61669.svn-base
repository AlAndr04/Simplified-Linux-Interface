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

import fileSystemObjects.*;
import driver.JShell;
import fileCommands.Mkfile;
import input.NotDirectoryException;
import input.Output;
import input.PathIncorrectException;
import input.UniqueNameException;
import java.util.ArrayList;
import java.util.Arrays;

/***
 * Class meant to represent the ls shell command. Has responsibility to output
 * the names of the current contents of the current directory or other
 * directories specified by either their absolute or relative paths.
 *
 */
public class Ls extends Commands<String> {
  /***
   * String containing the absolute or relative paths of the directories wanted
   * their contents to be listed.
   */
  String[] lsTarget;

  /***
   * Constructor for a Ls object, setting the values of lsTarget to path.
   * 
   * @param paths Paths of the directories which contents are wanting to be
   *        displayed
   */
  public Ls(String[] paths) {
    this.lsTarget = paths;
  }

  private String executeHelper() {
    String output = "";
    if (lsTarget.length == 0) {
      try {
        output = list(JShell.curr_dir);
      } catch (NotDirectoryException e) {
        Output.pathDoesNotExistError(e.toString());
      } catch (NullPointerException e) {
        Output.commandInvalid();
      }
    } else {
      output = "";
      ArrayList<Directory> all_input = new ArrayList<Directory>();
      for (int i = 0; i < lsTarget.length; i++) {
        Directory temp = Traverse.findPathString(lsTarget[i], JShell.root);
        if (temp != null) {
          all_input.add(temp);
        } else {
          Output.pathDoesNotExistError(lsTarget[i]);
        }
      }
      output = Ls.list(all_input);
    }
    return output;
  }
  /***
   * Executes the function by calling list method.
   */
  public String execute() {
    Output.printTextToShell(executeHelper());
    return null;
  }

  /***
   * Returns a string of the names of the children of a directory given as a
   * parameter, with whitespace separating the names of the children.
   * 
   * @param element Directory element wanting the contents of it to be returned
   *        as a string
   * @return string which represents the contents of the directory element
   *         parameter
   * @throws NotDirectoryException Thrown when a file is placed as a parameter
   * @throws NullPointerException Thrown when a null is given as a parameter
   */
  private static String list(Directory element)
      throws NotDirectoryException, NullPointerException {
    if (!(element instanceof Directory)) {
      throw new NotDirectoryException(element.getName());
    }
    String toReturn = "";
    if (!(element.getChildDir().isEmpty())) {
      for (int i = 0; i < element.getChildDir().size(); i++) {
        toReturn += element.getChildDir().get(i).getName() + "\n";
      }
    }
    return toReturn.trim();
  }
  
  private static ArrayList<Directory> subDirAccu(Directory element, ArrayList<Directory> toReturn) {
    ArrayList<Directory> ret = toReturn;
    ret.add(element);
    for (FSElement E: element.getChildDir()) {
      if (E instanceof Directory) {
        ret = subDirAccu((Directory)E,ret);
      }
    }
    return ret;
  }
  private static String listSubRec(Directory element) {
    ArrayList<Directory> newArr = new ArrayList<Directory>();
    newArr = subDirAccu(element, newArr);
    return list(newArr);
  }
  
  /***
   * Returns a string with the names of the children of the directories in the
   * elements array, with the name of the directory and its children separated
   * by a colon and a newline character.
   * 
   * @param elements Array of Directory elements whose names of children are
   *        wanting to be displayed.
   * @return String formatted as mentioned in method description
   */
  private static String list(ArrayList<Directory> elements) {
    String toReturnLs = "";
    Directory E;
    for (int i = 0; i < elements.size(); i++) {
      try {
        E = elements.get(i);
        toReturnLs += (E.getName() + ":\n" + Ls.list(E));
        if (i != elements.size() - 1) {
          toReturnLs += "\n\n";
        }
      } catch (NotDirectoryException e) {
        Output.pathDoesNotExistError(e.toString());
      } catch (NullPointerException e) {
        Output.commandInvalid();
      }
    }
    return toReturnLs;
  }

//  //pathToFile should be like this: [..directories../filename]
//  //redirectType == false is override, redirectType == True is append
//  @Override
//  public void execute(Boolean redirectType, String[] pathToFile) {
//    try {
//      File redFile = Traverse.returnGivenPathFromRootFile(pathToFile);
//      if (redirectType == false) {
//        redFile.delStrings();
//        redFile.addToContent(executeHelper());
//      } else {
//        redFile.addToContent(executeHelper());
//      }
//    } catch (PathIncorrectException e) {
//      try {
//        String[] newPath = Arrays.copyOfRange(pathToFile,0,pathToFile.length-1);
//        Traverse.returnGivenPathFromRoot(newPath);
//        Mkfile newFileMaker = new Mkfile(newPath);
//        File newFile = newFileMaker.mkFileWPath(pathToFile[pathToFile.length]);
//        newFile.addToContent(executeHelper());
//      } catch (PathIncorrectException e1) {
//        Output.pathDoesNotExistError(e.toString());
//      } catch (UniqueNameException e2) {
//        Output.nameNotValid(pathToFile[pathToFile.length]);
//      }
//    }
//  }
}
