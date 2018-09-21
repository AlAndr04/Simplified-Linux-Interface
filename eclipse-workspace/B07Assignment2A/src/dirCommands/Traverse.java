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
package dirCommands;

import java.util.ArrayList;
import java.util.Arrays;
import driver.JShell;
import fileSystemObjects.Directory;
import fileSystemObjects.FSElement;
import fileSystemObjects.File;
import input.PathIncorrectException;

/***
 * Class which contains methods to Traverse the file system.
 *
 */
public class Traverse {
  /***
   * Constructor for a Traverse object.
   */
  public Traverse() {}

  /***
   * Returns root directory given an element within the file system.
   * 
   * @param fs Directory element within file system
   * @return Returns Root Directory
   */
  public static Directory returnRoot(Directory fs) {
    Directory root = (Directory) fs;
    if (root.getParent() != null) {
      root = (Directory) root.getParent();
      return returnRoot(root);
    } else {
      return root;
    }
  }

  /***
   * private static final long serialVersionUID = -1042327258726510013L; Returns
   * Directory given string path to it, null otherwise.
   * 
   * @param path String array which contains each subdirectory to directory in
   *        sequential order
   * @param element Directory that the search is being done from, the root of
   *        the subtree
   * @return directory specified by path
   */
  private static Directory returnGivenPath(String[] path, Directory element) {
    // child directory of element being passed in
    ArrayList<FSElement> children = element.getChildDir();
    // tep to stop recursion once path.length == 0
    if (path.length == 0) {
      return element;
    } else {
      String nextDir = path[0];
      String[] newPath = new String[path.length - 1];
      // creating and supplying values for newPath to be passed into new
      // returnGivenPath call
      if (path.length > 1) {
        for (int i = 1; i < path.length; i++) {
          newPath[i - 1] = path[i];
        }
      }
      for (FSElement E : children) {
        if ((E.getName().equals(nextDir)) && (E instanceof Directory)) {
          return returnGivenPath(newPath, (Directory) E);
        }
      }
    }
    // Returns null when path is invalid
    return null;
  }

  /***
   * Returns File given string path to it, null otherwise.
   * 
   * @param path String array which contains each subdirectory to the file in
   *        sequential order
   * @param element Directory that the search is being done from, the root of
   *        the subtree
   * @return file specified by path
   */
  private static File returnGivenPathFile(String[] path, Directory element)
      throws PathIncorrectException {
    ArrayList<FSElement> children = element.getChildDir();
    if (path.length == 1) {
      String File = path[0];
      for (FSElement E : children) {
        if ((E.getName().equals(File)) && (E instanceof File)) {
          return (File) E;
        }
      }
    } else {
      String nextDir = path[0];
      String[] newPath = new String[path.length - 1];
      // creating and supplying values for newPath to be passed into new
      // returnGivenPath call
      if (path.length > 1) {
        for (int i = 1; i < path.length; i++) {
          newPath[i - 1] = path[i];
        }
      }
      for (FSElement E : children) {
        if ((E.getName().equals(nextDir)) && (E instanceof Directory)) {
          return returnGivenPathFile(newPath, (Directory) E);
        }
      }
    }
    // Returns null when path is invalid or when no file is found
    return null;
  }

  /***
   * Returns file given a path to it from the root directory
   * 
   * @param path String array containing names of subdirectories leading to the
   *        file
   * @return Returns file given its path relative to root
   * @throws PathIncorrectException
   */
  public static File returnGivenPathFromRootFile(String[] path, Directory root)
      throws PathIncorrectException {
    if (path.length == 1) {
      throw new PathIncorrectException(path);
    }
    String[] newPath = new String[path.length - 1];
    for (int i = 1; i < path.length; i++) {
      newPath[i - 1] = path[i];
    }
    return returnGivenPathFile(newPath, root);
  }

  /***
   * Returns directory given a path to it from the root directory
   * 
   * @param path String array containing names of subdirectories leading to the
   *        file
   * @return Returns file given its path relative to root
   * @throws PathIncorrectException
   */
  public static Directory returnGivenPathFromRoot(String[] path, Directory root)
      throws PathIncorrectException {
    // Im assuming ill always get an absolute path here
    String[] newPath = new String[path.length - 1];
    if (path.length > 1) {
      for (int i = 1; i < path.length; i++) {
        newPath[i - 1] = path[i];
      }
    } else {
      if (path[0].equals(root.getName())) {
        return root;
      } else {
        throw new PathIncorrectException(path);
      }
    }
    if ((returnGivenPath(newPath, root)) == null) {
      throw new PathIncorrectException(path);
    }
    return returnGivenPath(newPath, root);
  }

  /**
   * Given the root and the path, goes from the root to the directory at that
   * path and outputs the directory.
   * 
   * @param strpath: the path that needs to be traversed
   * @param root: the start directory.
   * @return dir: the directory at the destination
   */
  public static Directory findPathString(String strpath, Directory root) {
    // Makes the dir directory equal to the root initially.
    Directory dir = root;
    // Creates an array of string which equals to the split strpath using
    // / as delimiter.
    String[] lstpath = strpath.split("/");
    int j;
    // Creates a list of FSElement objects named child.
    ArrayList<FSElement> child;
    // Loops from the second element (first one will be a blank string)
    // since the split method removes the root directory.
    for (int i = 1; i < lstpath.length; i++) {
      // Initializes the variable j for looping through child as 0.
      j = 0;
      // Initializes child as children of directory, using the method.
      child = dir.getChildDir();
      // Loops as long as j is not the same as the amount of children,
      // and until it hasn't found an instance that has the same name
      // as the one currently the first loop is at from the path and
      // that is a directory. Increases j by 1.
      while ((j < child.size()) && (!(child.get(j) instanceof Directory)
          || !(child.get(j).getName().equals(lstpath[i])))) {
        j++;
      }
      // returns null if j is the same as the amount of children, which
      // means there are no children with the same name. Makes dir the
      // chosen child. Repeats the loop until lstpath is complete.
      if (j == child.size()) {
        return null;
      } else {
        dir = (Directory) child.get(j);
      }
    }
    return dir;
  }

  /**
   * Given the path and start directory, returns the FSElement at that path.
   * 
   * @param strpath: the path to traverse
   * @param start: the start directory
   * @return dest:
   */
  public static FSElement accessFS(String strpath, Directory start) {
    String[] path = strpath.split("/");
    ArrayList<FSElement> child;
    FSElement dest = start;
    int j;
    for (int i = 1; i < path.length; i++) {
      child = start.getChildDir();
      j = 0;
      while ((j < child.size()) && !((child.get(j).getName().equals(path[i]))
          && ((child.get(j) instanceof Directory) || (i == path.length - 1)))) {
        j++;
      }
      if ((j < child.size()) && (child.get(j).getName().equals(path[i]))) {
        if (i == path.length - 1) {
          dest = child.get(j);
        } else {
          start = (Directory) child.get(j);
        }
      } else {
        return null;
      }
    }
    return dest;
  }

  /**
   * Given a directory, a file type and a name, returns the string with all the
   * absolute paths.
   * 
   * @param start: the directory at which to start
   * @param file: the type of file
   * @param name: the name of file
   * @return result: the string with absolute paths which is returned.
   */
  public static String findName(Directory start, String file, String name) {
    String result = "";
    // Makes child the children of the start directory.
    ArrayList<FSElement> child = start.getChildDir();
    // Loops through all the size of child.
    for (int i = 0; i < child.size(); i++) {
      // If the type of file is f and the child is a file.
      if (file.equals("f") && child.get(i) instanceof File) {
        // Checks if the file is the same as the name, prints the
        // path using pwd and adds a newline.
        if (child.get(i).getName().equals(name)) {
          result += Pwd.returnPathFromRoot(child.get(i)) + "\n";
        }
        // Otherwise if child is a directory.
      } else if (child.get(i) instanceof Directory) {
        // Checks if the type is d and if the directory has the same name.
        if (file.equals("d") && child.get(i).getName().equals(name)) {
          // Gets the full root and adds a new line.
          result += Pwd.returnPathFromRoot(child.get(i)) + "\n";
        }
        // Adds the return from the recursive call of child.
        result += findName((Directory) child.get(i), file, name);
      }
    }
    return result;
  }

  public static ArrayList<FSElement> getAllDirs(Directory start) {
    ArrayList<FSElement> files = new ArrayList<FSElement>();
    ArrayList<FSElement> children = start.getChildDir();
    for (FSElement child : children) {
      files.add(child);
      if (child instanceof Directory) {
        files.addAll(getAllDirs((Directory) child));
      }
    }
    return files;
  }
}
