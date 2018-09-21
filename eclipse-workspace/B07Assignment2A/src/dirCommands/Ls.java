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

import fileSystemObjects.*;
import input.Location;
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
  boolean recursion;
  private Directory root;
  private Directory curr;

  /***
   * Constructor for a Ls object, setting the values of lsTarget to path.
   * 
   * @param paths Paths of the directories which contents are wanting to be
   *        displayed
   * @param option Option for recursive display of subdirectories, True = -R
   *        exists, False = no -R option specified by user
   * @param loc Location which stores the current directory, root, information
   *        about the file system
   */
  public Ls(String[] paths, boolean option, Location loc) {
    this.lsTarget = paths;
    this.recursion = option;
    this.root = loc.getRoot();
    this.curr = loc.getCurrDir();

  }

  /***
   * Helper function for execute, finds each lsTarget in lsTarget array and
   * lists them, or if lsTarget length is 0, list the current directory
   * 
   * @return String output, result of listing all directories specified in
   *         lsTarget array or current directory
   */
  private String executeHelper() {
    String output = "";
    if (lsTarget.length == 0) {
      try {
        output = list(this.curr);
      } catch (NullPointerException e) {
        Output.commandInvalid();
      }
    } else if (lsTarget.length == 1) {
      FSElement temp = Traverse.accessFS(lsTarget[0], this.root);
      try {
        output = list(temp);
      } catch (NullPointerException e) {
        Output.pathDoesNotExistError(lsTarget[0]);
      }
    } else {
      output = "";
      ArrayList<FSElement> allinput = new ArrayList<FSElement>();
      for (int i = 0; i < lsTarget.length; i++) {
        FSElement temp = Traverse.accessFS(lsTarget[i], this.root);
        if (temp != null) {
          allinput.add(temp);
        } else {
          Output.pathDoesNotExistError(lsTarget[i]);
        }
      }
      output = Ls.list(allinput);
    }
    return output;
  }

  /***
   * Execute helper which recursively lists all absolute path names in lsTarget
   * array, or if the lsTarget length is 0, list the current directory
   * recursively
   * 
   * @return String output, result of listing all directories specified in
   *         lsTarget array or current directory recursively
   */
  private String executeHelperRecursive() {
    ArrayList<FSElement> newArr = new ArrayList<FSElement>();
    String ret = "";
    if (lsTarget.length == 0) {
      ret = list(subDirAccu(curr, newArr));
    } else {
      for (String E : lsTarget) {
        FSElement temp = Traverse.accessFS(E, this.root);
        if ((!(temp == null)) && (temp instanceof Directory)) {
          ret +=
              "Subdirectories of " + E + ":\n" + list(subDirAccu(temp, newArr));
        } else if ((!(temp == null)) && (temp instanceof File)) {
          ret += list(subDirAccu(temp, newArr));
        } else {
          Output.pathDoesNotExistError(E);
        }
        newArr.clear();
      }
    }
    return ret;
  }

  /***
   * Executes the function by calling list method.
   * 
   * @return String which is returned by either executeHelperRecursive or
   *         executeHelper, lists things as per the command description
   */
  public String execute() {
    if (recursion) {
      return executeHelperRecursive();
    } else {
      return executeHelper();
    }
  }

  /***
   * Returns a string of the names of the children of a directory given as a
   * parameter, with whitespace separating the names of the children.
   * 
   * @param element Directory element wanting the contents of it to be returned
   *        as a string
   * @return string which represents the contents of the directory element
   *         parameter
   * @throws NullPointerException Thrown when a null is given as a parameter
   */
  private static String list(FSElement element) throws NullPointerException {
    if (element instanceof File) {
      return Pwd.returnPathFromRoot(element) + "\n";
    } else {
      String toReturn = "";
      if (!(((Directory) element).getChildDir().isEmpty())) {
        for (int i = 0; i < ((Directory) element).getChildDir().size(); i++) {
          toReturn +=
              ((Directory) element).getChildDir().get(i).getName() + "\n";
        }
      }
      return toReturn.trim();
    }
  }

  /***
   * Recursively accumulates all subdirectories and files of the given element
   * or just the file if a file is passed in as an element.
   * 
   * @param element Subdirectory to be start recursing from or file
   * @param toReturn Recursively accumulates FSElements onto toReturn ArrayList
   *        to be returned after recursion in complete
   * @return ArrayList of FSElements which are the subdirectories and files of
   *         the given element or just the file if a file is passed as an
   *         element
   */
  private static ArrayList<FSElement> subDirAccu(FSElement element,
      ArrayList<FSElement> toReturn) {
    ArrayList<FSElement> ret = toReturn;
    ret.add(element);
    if (element instanceof Directory) {
      for (FSElement E : ((Directory) element).getChildDir()) {
        ret = subDirAccu(E, ret);
      }
    }
    return ret;
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
  private static String list(ArrayList<FSElement> elements) {
    String toReturnLs = "";
    FSElement E;
    for (int i = 0; i < elements.size(); i++) {
      try {
        E = elements.get(i);
        if (E instanceof File) {
          toReturnLs += list(E) + "\n";
        } else {
          toReturnLs += (Pwd.returnPathFromRoot(E) + ":\n" + Ls.list(E));
          if (i != elements.size() - 1) {
            toReturnLs += "\n\n";
          }
        }
      } catch (NullPointerException e) {
        Output.commandInvalid();
      }
    }
    return toReturnLs;
  }
}
